package com.assignment.movie.repository;

import com.assignment.movie.model.CastModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CastRepository extends JpaRepository<CastModel, Long> {
//    List<CastModel> findByNameContaining(String name);
}
