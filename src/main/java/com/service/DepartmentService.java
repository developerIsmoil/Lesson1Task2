package com.service;

import com.entity.Category;
import com.entity.Department;
import com.payload.ApiResponse;
import com.payload.DepartmentDto;
import com.repository.CategoryRepository;
import com.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public ApiResponse add(DepartmentDto departmentDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(departmentDto.getCategoryId());
        if (optionalCategory.isEmpty())
            return new ApiResponse("Bunday categoriya topilmadi", false);
        Department department = new Department();
        department.setName(departmentDto.getName());
        department.setCategory(optionalCategory.get());
        departmentRepository.save(department);
        return new ApiResponse("Saqlandi", true);
    }

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    public Department get(Long id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        return optionalDepartment.orElseGet(Department::new);
    }

    public ApiResponse edit(Long id, DepartmentDto departmentDto) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isEmpty())
            return new ApiResponse("Bunday Department topilmadi", false);
        Optional<Category> optionalCategory = categoryRepository.findById(departmentDto.getCategoryId());
        if (optionalCategory.isEmpty())
            return new ApiResponse("Bunday Categoriya topilmadi", false);
        Department department = new Department();
        department.setName(departmentDto.getName());
        department.setCategory(optionalCategory.get());
        departmentRepository.save(department);
        return new ApiResponse("Editing", true);
    }

    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }
}
