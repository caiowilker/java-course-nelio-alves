package org.example.project_web.demo.src.test.java.com.example.demo.repositories;

import org.example.project_web.demo.src.test.java.com.example.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}