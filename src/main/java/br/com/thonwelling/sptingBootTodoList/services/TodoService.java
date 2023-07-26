package br.com.thonwelling.sptingBootTodoList.services;

import br.com.thonwelling.sptingBootTodoList.dtos.TaskDto;
import br.com.thonwelling.sptingBootTodoList.mapper.ModelMapperMapping;
import br.com.thonwelling.sptingBootTodoList.models.Task;
import br.com.thonwelling.sptingBootTodoList.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoService {
    @Autowired
    TodoRepository repository;

    public ResponseEntity<List<TaskDto>> createTask(TaskDto task){
        var entity = ModelMapperMapping.parseObject(task, Task.class);
        ModelMapperMapping.parseObject(repository.save(entity), TaskDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(getAllTasks());
    }
    public List<TaskDto> getAllTasks(){
        //Ordenando por prioridade e depois por nome
        Sort sort = Sort.by("priority").descending()
                .and(Sort.by("name").ascending());
        return ModelMapperMapping.parseObjects(repository.findAll(sort), TaskDto.class);
    }
    public List<TaskDto> updateTask(TaskDto task){
        var entity = ModelMapperMapping.parseObject(task, Task.class);
        ModelMapperMapping.parseObject(repository.save(entity), TaskDto.class);
        return getAllTasks();
    }
    public List<TaskDto> deleteTask(UUID id){
        repository.deleteById(id);
        return getAllTasks();
    }
}
