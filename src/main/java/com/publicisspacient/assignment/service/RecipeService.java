package com.publicisspacient.assignment.service;

import com.publicisspacient.assignment.model.Recipe;
import java.util.List;

public interface RecipeService {
    void loadRecipesFromExternal();
    List<Recipe> getAllRecipes();
    List<Recipe> searchRecipes(String keyword); 
    Recipe getRecipeById(Long id);
}
