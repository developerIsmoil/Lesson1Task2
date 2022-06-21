package com.service;

import com.entity.Department;
import com.entity.Task;
import com.payload.ApiResponse;
import com.payload.TaskDto;
import com.repository.DepartmentRepository;
import com.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    public ApiResponse add(TaskDto taskDto) {
        Optional<Department> optionalDepartment = departmentRepository.findById(taskDto.getDepartmentId());
        if (optionalDepartment.isEmpty())
            return new ApiResponse("Bunday Department yoq", false);
        Task task = new Task();
        task.setName(taskDto.getName());
        task.setDepartment(optionalDepartment.get());
        taskRepository.save(task);
        return new ApiResponse("Saqlandi", true);
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task get(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty())
            return new Task();
        return optionalTask.get();
    }

    public ApiResponse edit(Long id, TaskDto taskDto) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty())
            return new ApiResponse("Bunday Task yoq", false);
        Optional<Department> optionalDepartment = departmentRepository.findById(taskDto.getDepartmentId());
        if (optionalDepartment.isEmpty())
            return new ApiResponse("Bunday department yoq", false);
        Task task = new Task();
        task.setName(taskDto.getName());
        task.setDepartment(optionalDepartment.get());
        taskRepository.save(task);
        return new ApiResponse("Editing", true);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
