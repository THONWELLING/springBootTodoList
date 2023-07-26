package br.com.thonwelling.sptingBootTodoList.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@Entity
@Getter
@NoArgsConstructor
@Setter
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String name;
    private String description;
    private boolean done;
    private int priority;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Todo todo)) return false;
        return isDone() == todo.isDone() && getPriority() == todo.getPriority() && Objects.equals(getUuid(), todo.getUuid()) && Objects.equals(getName(), todo.getName()) && Objects.equals(getDescription(), todo.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getName(), getDescription(), isDone(), getPriority());
    }
}
