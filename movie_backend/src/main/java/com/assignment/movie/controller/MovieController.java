package com.assignment.movie.controller;

import com.assignment.movie.controller.common.UserApiUrlConstants;
import com.assignment.movie.data.ResData.core.ResponseBaseData;
import com.assignment.movie.service.MovieService;
import com.assignment.movie.util.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping(path = UserApiUrlConstants.BYCATEGORY)
    @ResponseBody
    public ResponseBaseData<?> getCategoriesWithMovies() {
        try {
            return movieService.getCategoriesWithMovies();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseUtils.exceptionError("Unable to get movies", ex.getMessage());
        }
    }
}
