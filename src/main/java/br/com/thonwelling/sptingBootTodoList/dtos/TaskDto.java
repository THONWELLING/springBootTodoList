package br.com.thonwelling.sptingBootTodoList.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@JsonPropertyOrder({"id", "name", "description", "priority", "done"})
public class TaskDto implements Serializable {

    private UUID id;
    private String name;
    private String description;
    private boolean done;
    private int priority;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskDto taskDto)) return false;
        return isDone() == taskDto.isDone() && getPriority() == taskDto.getPriority() && Objects.equals(getId(), taskDto.getId()) && Objects.equals(getName(), taskDto.getName()) && Objects.equals(getDescription(), taskDto.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), isDone(), getPriority());
    }
}