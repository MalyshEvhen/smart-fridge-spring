package ua.malysh.service;

import java.util.List;

import ua.malysh.domain.Product;

public interface ProductService {
    Product save(Product product);

    Product findById(Long id);

    List<Product> findAll();

    void deleteById(Long id);
}
