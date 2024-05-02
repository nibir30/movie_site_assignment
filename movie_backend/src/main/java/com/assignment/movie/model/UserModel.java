package com.assignment.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Entity(name = "User")
public class UserModel {
    @OneToMany(targetEntity = CastModel.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    List<MovieModel> favoriteMovies;
    @Id
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String fullName;
    private String gender;
    private LocalDateTime dob;
    @JsonIgnore
    private LocalDateTime insertTime;
    @JsonIgnore
    private LocalDateTime updateTime;
}
