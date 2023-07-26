package br.com.thonwelling.sptingBootTodoList.controllers;

import br.com.thonwelling.sptingBootTodoList.models.Task;
import br.com.thonwelling.sptingBootTodoList.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("todos")
public class TodoController {
    @Autowired
    TodoService service;

    @PostMapping
    List<Task> createTask (@RequestBody Task task) {
        return service.createTask(task);
    }

    @GetMapping
    List<Task> gatAllTasks () {
        return service.getAllTasks();
    }
    @PutMapping
    List<Task> updateTask (@RequestBody Task task) {
        return service.updateTask(task);
    }
    @DeleteMapping("/{id}")
    List<Task> deleteTask (@PathVariable UUID id) {
        return service.deleteTask(id);
    }
}