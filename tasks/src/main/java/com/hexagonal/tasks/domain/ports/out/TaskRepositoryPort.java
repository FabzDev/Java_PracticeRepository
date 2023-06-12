package com.hexagonal.tasks.domain.ports.out;

import com.hexagonal.tasks.domain.models.Task;

import java.util.List;

public interface TaskRepositoryPort {
    Task save(Task task);
    <Optional> Task findById(Long id);
    List<Task> findAll();
    <Optional> Task update(Long id, Task updateTask);
    boolean deleteById(Long id);
}
