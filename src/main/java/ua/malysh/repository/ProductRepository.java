package ua.malysh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.malysh.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}