package com.publicisspacient.assignment.controller;

import com.publicisspacient.assignment.model.Recipe;
import com.publicisspacient.assignment.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/recipes")
@CrossOrigin(origins = "http://localhost:5173")

public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping("/load")
    public ResponseEntity<String> loadRecipes() {
        recipeService.loadRecipesFromExternal();
        return ResponseEntity.ok("Recipes loaded successfully!");
    }

    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        return ResponseEntity.ok(recipeService.getRecipeById(id));
    }
    @GetMapping("/search")
    public ResponseEntity<List<Recipe>> searchRecipes(@RequestParam String keyword) {
        return ResponseEntity.ok(recipeService.searchRecipes(keyword));
    }
    

}
