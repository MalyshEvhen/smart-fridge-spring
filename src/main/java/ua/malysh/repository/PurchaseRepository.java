package ua.malysh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.malysh.domain.Purchase;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    List<Purchase> findByRecipeId(Long id);
}