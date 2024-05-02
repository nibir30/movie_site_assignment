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
    Long movieId;
    String title;

    @OneToMany(targetEntity = LookupCategoryModel.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    List<LookupCategoryModel> categories;

    @OneToMany(targetEntity = CastModel.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    List<CastModel> casts;

    LocalDateTime releaseDate;
    Long budget;

    @JsonIgnore
    LocalDateTime insertTime;

    @JsonIgnore
    LocalDateTime updateTime;
}
