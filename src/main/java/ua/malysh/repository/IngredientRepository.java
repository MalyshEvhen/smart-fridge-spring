package ua.malysh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.malysh.domain.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
