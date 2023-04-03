package ua.malysh.servise.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.malysh.domain.Product;
import ua.malysh.exceptions.ProductNotFoundException;
import ua.malysh.repository.ProductRepository;
import ua.malysh.servise.ProductService;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
    
    @Override
    public Product findById(Long id) {
        return productRepository.findById(id)
            .orElseThrow(ProductNotFoundException::new);
    }
    
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    
    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
