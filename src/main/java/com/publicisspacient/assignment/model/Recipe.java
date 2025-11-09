package com.publicisspacient.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipe {

    @Id
    private Long id;
    private String name;
    private String cuisine;
    private String difficulty;
    private Integer caloriesPerServing;
    private String image;

    // ✅ Default constructor (required by JPA)
    public Recipe() {
    }

    // ✅ Parameterized constructor
    public Recipe(Long id, String name, String cuisine, String difficulty, Integer caloriesPerServing, String image) {
        this.id = id;
        this.name = name;
        this.cuisine = cuisine;
        this.difficulty = difficulty;
        this.caloriesPerServing = caloriesPerServing;
        this.image = image;
    }

    // ✅ Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getCaloriesPerServing() {
        return caloriesPerServing;
    }

    public void setCaloriesPerServing(Integer caloriesPerServing) {
        this.caloriesPerServing = caloriesPerServing;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // ✅ For debugging/logging
    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", caloriesPerServing=" + caloriesPerServing +
                ", image='" + image + '\'' +
                '}';
    }
}
