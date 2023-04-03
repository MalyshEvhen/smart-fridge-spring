package ua.malysh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.malysh.domain.FridgeProduct;

public interface FridgeProductRepository extends JpaRepository<FridgeProduct, Long> {
}