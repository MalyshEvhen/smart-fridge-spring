package ua.malysh.servise;

import ua.malysh.domain.Recipe;

import java.util.List;

public interface RecipeService {
    Recipe save(Recipe recipe);
    
    List<Recipe> findAll();
    
    Recipe findById(Long id);
    
    void deleteById(Long id);
}
