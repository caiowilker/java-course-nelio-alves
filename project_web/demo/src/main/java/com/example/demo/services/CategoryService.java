package org.example.project_web.demo.src.test.java.com.example.demo.services;

import org.example.project_web.demo.src.test.java.com.example.demo.entities.Category;
import org.example.project_web.demo.src.test.java.com.example.demo.entities.User;
import org.example.project_web.demo.src.test.java.com.example.demo.repositories.CategoryRepository;
import org.example.project_web.demo.src.test.java.com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }

}
