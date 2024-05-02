package com.assignment.movie.service;

import com.assignment.movie.data.ReqData.AddFavoriteMovieReqData;
import com.assignment.movie.data.ResData.core.ResponseBaseData;
import com.assignment.movie.model.MovieModel;
import org.springframework.stereotype.Service;

@Service
public interface MovieService {
    ResponseBaseData<?> addMovie(MovieModel movieModel);

    ResponseBaseData<?> addFavoriteMovie(AddFavoriteMovieReqData addFavoriteMovieReqData);

    ResponseBaseData<?> getCategoriesWithMovies();

//    ResponseBaseData<?> addTag(TagReqData tagReqData, Long userId);
//
//    ResponseBaseData<?> getAllTags();
}
