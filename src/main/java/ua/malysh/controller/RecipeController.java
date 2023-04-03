package ua.malysh.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.malysh.domain.Recipe;
import ua.malysh.servise.RecipeService;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService service;
    
    public RecipeController(RecipeService service) {
        this.service = service;
    }
    
    @PostMapping
    public Recipe save(@RequestBody Recipe recipe) {
        return service.save(recipe);
    }
    
    @GetMapping
    public List<Recipe> list() {
        return service.findAll();
    }
    
    @GetMapping("/{id}")
    public Recipe getById(@PathVariable Long id) {
        return service.findById(id);
    }
    
    @PutMapping
    public Recipe update(@RequestBody Recipe recipe) {
        return service.save(recipe);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
