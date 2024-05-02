package com.assignment.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "movie")
public class MovieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long movieId;
    String title;

    @ManyToMany(targetEntity = LookupCategoryModel.class, cascade = {CascadeType.MERGE})
    List<LookupCategoryModel> categories;

    @ManyToMany(targetEntity = CastModel.class, cascade = {CascadeType.MERGE})
    List<CastModel> casts;

    LocalDateTime releaseDate;
    Integer budget;
    Integer year;
    String imagePath;

    @JsonIgnore
    LocalDateTime insertTime;

    @JsonIgnore
    LocalDateTime updateTime;
}
