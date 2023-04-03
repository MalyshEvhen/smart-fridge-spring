package ua.malysh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.malysh.domain.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}