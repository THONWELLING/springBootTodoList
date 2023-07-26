package br.com.thonwelling.sptingBootTodoList.controllers;

import br.com.thonwelling.sptingBootTodoList.dtos.TaskDto;
import br.com.thonwelling.sptingBootTodoList.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TodoController {
    @Autowired
    TodoService service;

    @PostMapping
    ResponseEntity<List<TaskDto>> createTask (@RequestBody TaskDto task) {
        return service.createTask(task);
    }

    @GetMapping
    ResponseEntity<List<TaskDto>> gatAllTasks () {
        return ResponseEntity.ok(service.getAllTasks());
    }
    @PutMapping
    List<TaskDto> updateTask (@RequestBody TaskDto task) {
        return service.updateTask(task);
    }
    @DeleteMapping("/{id}")
    List<TaskDto> deleteTask (@PathVariable UUID id) {
        return service.deleteTask(id);
    }
}