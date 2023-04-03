package ua.malysh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.malysh.domain.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    List<Purchase> findByRecipeId(Long id);
}
