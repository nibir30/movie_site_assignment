package com.assignment.movie.repository;

import com.assignment.movie.model.MovieModel;
import com.assignment.movie.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieModel, Long> {
}
