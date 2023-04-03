package ua.malysh.service;

import java.util.List;

import ua.malysh.domain.Recipe;

public interface RecipeService {
    Recipe save(Recipe recipe);

    List<Recipe> findAll();

    Recipe findById(Long id);

    void deleteById(Long id);
}
