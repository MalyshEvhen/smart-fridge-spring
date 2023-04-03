package ua.malysh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.malysh.domain.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}