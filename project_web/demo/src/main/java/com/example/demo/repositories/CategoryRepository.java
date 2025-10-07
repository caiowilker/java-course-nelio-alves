package org.example.project_web.demo.src.test.java.com.example.demo.repositories;

import org.example.project_web.demo.src.test.java.com.example.demo.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}