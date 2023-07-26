package br.com.thonwelling.sptingBootTodoList.services;

import br.com.thonwelling.sptingBootTodoList.models.Task;
import br.com.thonwelling.sptingBootTodoList.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoService {
    @Autowired
    TodoRepository repository;

    public List<Task> createTask(Task task){
        repository.save(task);
        return getAllTasks();
    }
    public List<Task> getAllTasks(){
        //Ordenando por prioridade e depois por nome
        Sort sort = Sort.by("priority").descending()
                .and(Sort.by("name").ascending());
        return repository.findAll(sort);
    }
    public List<Task> updateTask(Task task){
        repository.save(task);
        return getAllTasks();
    }
    public List<Task> deleteTask(UUID id){
        repository.deleteById(id);
        return getAllTasks();
    }
}
