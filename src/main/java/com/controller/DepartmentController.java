package com.controller;

import com.entity.Department;
import com.payload.ApiResponse;
import com.payload.DepartmentDto;
import com.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping
    public ApiResponse add(@Valid @RequestBody DepartmentDto departmentDto) {
        return departmentService.add(departmentDto);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAll() {
        List<Department> departmentList = departmentService.getAll();
        return ResponseEntity.ok(departmentList);
    }

    @GetMapping("/{id}")
    public Department get(@PathVariable Long id) {
        return departmentService.get(id);
    }

    @PutMapping("/{id}")
    public ApiResponse edit(@PathVariable Long id, @Valid @RequestBody DepartmentDto departmentDto) {
        return departmentService.edit(id, departmentDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        departmentService.delete(id);
    }
}
