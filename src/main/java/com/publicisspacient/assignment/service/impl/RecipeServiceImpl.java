package com.publicisspacient.assignment.service.impl;

import com.publicisspacient.assignment.dto.RecipeResponse;
import com.publicisspacient.assignment.model.Recipe;
import com.publicisspacient.assignment.repository.RecipeRepository;
import com.publicisspacient.assignment.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private static final Logger log = LoggerFactory.getLogger(RecipeServiceImpl.class);

    @Autowired
    private RecipeRepository recipeRepository;

    private static final String EXTERNAL_URL = "https://dummyjson.com/recipes";

    @Override
    public void loadRecipesFromExternal() {
        RestTemplate restTemplate = new RestTemplate();
        log.info("Fetching recipes from external API...");

        try {
            RecipeResponse response = restTemplate.getForObject(EXTERNAL_URL, RecipeResponse.class);
            if (response != null && response.getRecipes() != null && !response.getRecipes().isEmpty()) {
                recipeRepository.saveAll(response.getRecipes());
                log.info("Loaded {} recipes into H2 DB", response.getRecipes().size());
            } else {
                log.warn("No recipes found from external API.");
            }
        } catch (Exception e) {
            log.error("Error fetching recipes from external API: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to load recipes from external API", e);
        }
    }

    @Override
    public List<Recipe> getAllRecipes() {
        log.info("Fetching all recipes from H2 database...");
        return recipeRepository.findAll();
    }

    @Override
    public List<Recipe> searchRecipes(String keyword) {
        log.info("Searching recipes for keyword: {}", keyword);
        return recipeRepository.searchRecipes(keyword);
    }
    

    @Override
    public Recipe getRecipeById(Long id) {
        log.info("Fetching recipe by ID: {}", id);
        return recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found with id: " + id));
    }
}
