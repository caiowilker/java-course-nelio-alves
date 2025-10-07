package org.example.project_web.demo.src.test.java.com.example.demo.services;

import org.example.project_web.demo.src.test.java.com.example.demo.entities.Product;;
import org.example.project_web.demo.src.test.java.com.example.demo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.get();
    }

}
