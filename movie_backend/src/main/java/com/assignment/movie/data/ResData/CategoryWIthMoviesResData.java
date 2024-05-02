package com.assignment.movie.data.ResData;

import com.assignment.movie.model.MovieModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CategoryWIthMoviesResData {
    private Long categoryId;
    private String name;
    private List<MovieModel> movieModelList;
}
