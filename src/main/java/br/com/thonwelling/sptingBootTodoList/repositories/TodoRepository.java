package br.com.thonwelling.sptingBootTodoList.repositories;

import br.com.thonwelling.sptingBootTodoList.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TodoRepository extends JpaRepository<Task, UUID>{}
