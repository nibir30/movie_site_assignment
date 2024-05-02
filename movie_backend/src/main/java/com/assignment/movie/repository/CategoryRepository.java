package com.assignment.movie.repository;

import com.assignment.movie.model.LookupCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<LookupCategoryModel, Long> {
}
