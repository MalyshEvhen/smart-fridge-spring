package ua.malysh.servise;

import ua.malysh.domain.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    
    Product findById(Long id);
    
    List<Product> findAll();
    
    void deleteById(Long id);
}
