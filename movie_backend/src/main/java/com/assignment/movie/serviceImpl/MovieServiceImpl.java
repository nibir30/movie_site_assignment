package com.assignment.movie.serviceImpl;

import com.assignment.movie.data.ReqData.AddFavoriteMovieReqData;
import com.assignment.movie.data.ResData.CategoryWIthMoviesResData;
import com.assignment.movie.data.ResData.core.ResponseBaseData;
import com.assignment.movie.model.LookupCategoryModel;
import com.assignment.movie.model.MovieModel;
import com.assignment.movie.model.UserModel;
import com.assignment.movie.repository.CategoryRepository;
import com.assignment.movie.repository.MovieRepository;
import com.assignment.movie.repository.UserRepository;
import com.assignment.movie.service.MovieService;
import com.assignment.movie.util.ResponseUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public ResponseBaseData<?> getCategoriesWithMovies() {
        List<LookupCategoryModel> categoryModelList = categoryRepository.findAll();
        List<CategoryWIthMoviesResData> categoryWIthMoviesResDataList = new ArrayList<>();
        for (LookupCategoryModel categoryModel : categoryModelList) {
            CategoryWIthMoviesResData categoryWIthMoviesResData = new CategoryWIthMoviesResData();
            List<MovieModel> movieModels = movieRepository.findAllByCategories_categoryId(categoryModel.getCategoryId());
            BeanUtils.copyProperties(categoryModel, categoryWIthMoviesResData);
            categoryWIthMoviesResData.setMovieModelList(movieModels);
            categoryWIthMoviesResDataList.add(categoryWIthMoviesResData);
        }
        return ResponseUtils.dataSuccess("Here are the movies", categoryWIthMoviesResDataList);
    }

    @Override
    public ResponseBaseData<?> addMovie(MovieModel movieModel) {
        try {
            MovieModel savedUser = movieRepository.save(movieModel);
            return ResponseUtils.dataSuccess("Successfully added a movie", savedUser);
        } catch (Exception ex) {
            return ResponseUtils.exceptionError("Could not save a user", ex.getMessage());
        }
    }

    @Override
    public ResponseBaseData<?> addFavoriteMovie(AddFavoriteMovieReqData addFavoriteMovieReqData) {
        if (checkStringNullOrEmpty(addFavoriteMovieReqData.getEmail())) {
            return ResponseUtils.validationError("User is not registered!");
        }
        UserModel userModel = userRepository.findByEmail(addFavoriteMovieReqData.getEmail());

        Optional<MovieModel> movieModel = movieRepository.findById(addFavoriteMovieReqData.getMovieId());

        if (movieModel.isEmpty()) {
            return ResponseUtils.validationError("Can not find movie!");
        }
        List<MovieModel> favoriteMovies = new ArrayList<>();
        favoriteMovies.add(movieModel.get());
        userModel.setFavoriteMovies(favoriteMovies);
        userRepository.save(userModel);
        return ResponseUtils.success("Movie added to favorites");
    }

    public Boolean checkStringNullOrEmpty(String value) {
        if (value == null || value.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
