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
public class Task {
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
        if (!(o instanceof Task task)) return false;
        return isDone() == task.isDone() && getPriority() == task.getPriority() && Objects.equals(getUuid(), task.getUuid()) && Objects.equals(getName(), task.getName()) && Objects.equals(getDescription(), task.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getName(), getDescription(), isDone(), getPriority());
    }
}