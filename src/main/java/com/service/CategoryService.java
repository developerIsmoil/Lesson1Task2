package com.service;

import com.entity.Category;
import com.payload.ApiResponse;
import com.payload.CategoryDto;
import com.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public ApiResponse add(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        categoryRepository.save(category);
        return new ApiResponse("Saqlandi", true);
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category get(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.orElseGet(Category::new);
    }

    public ApiResponse edit(Long id, CategoryDto categoryDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty())
            return new ApiResponse("Bunday categoriya topilmadi", false);
        Category category = new Category();
        category.setName(categoryDto.getName());
        categoryRepository.save(category);
        return new ApiResponse("Edit category", true);
    }

    public ApiResponse delete(Long id) {
        categoryRepository.deleteById(id);
        return new ApiResponse("Deleted", true);
    }
}