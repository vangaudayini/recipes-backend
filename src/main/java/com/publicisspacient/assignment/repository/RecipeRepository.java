package com.publicisspacient.assignment.repository;

import com.publicisspacient.assignment.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("SELECT r FROM Recipe r WHERE LOWER(r.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(r.cuisine) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Recipe> searchRecipes(String keyword);
}
