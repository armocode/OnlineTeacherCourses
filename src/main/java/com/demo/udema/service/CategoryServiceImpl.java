package com.demo.udema.service;

import com.demo.udema.entity.Category;
import com.demo.udema.repositoryDAO.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    public CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
    @Override
    public List<Category> getAll() {
        return categoryRepository.findAllByOrderByTitleAsc();
    }

    @Override
    public Category findById(int id) {
        Optional<Category> result = categoryRepository.findById(id);
        Category category = null;
        if (result.isPresent()) {
            category = result.get();
        } else {
            throw new RuntimeException("Did not find category id: " + id);
        }
        return category;
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }
    @Override
    public String findByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }
    @Override
    public void deleteCategoryById(int id) {
        categoryRepository.deleteById(id);
    }
    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAllCategories();
    }
}
