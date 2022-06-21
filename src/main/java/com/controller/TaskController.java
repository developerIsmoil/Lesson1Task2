package com.controller;

import com.entity.Task;
import com.payload.ApiResponse;
import com.payload.TaskDto;
import com.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping
    public ApiResponse add(@Valid @RequestBody TaskDto taskDto) {
        return taskService.add(taskDto);
    }

    @GetMapping
    public ResponseEntity<List<Task>> get() {
        List<Task> taskList = taskService.getAll();
        return ResponseEntity.ok(taskList);
    }

    @GetMapping("/{id}")
    public Task get(@PathVariable Long id) {
        return taskService.get(id);
    }

    @PutMapping("/{id}")
    public ApiResponse edit(@PathVariable Long id, @Valid @RequestBody TaskDto taskDto) {
        return taskService.edit(id, taskDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
    }
}
