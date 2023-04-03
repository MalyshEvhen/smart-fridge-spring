package ua.malysh.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.malysh.domain.Recipe;
import ua.malysh.exceptions.RecipeNotFoundException;
import ua.malysh.repository.RecipeRepository;
import ua.malysh.service.RecipeService;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository repository;

    public RecipeServiceImpl(RecipeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Recipe save(Recipe recipe) {
        return repository.save(recipe);
    }

    @Override
    public List<Recipe> findAll() {
        return repository.findAll();
    }

    @Override
    public Recipe findById(Long id) {
        return repository.findById(id)
                .orElseThrow(RecipeNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
