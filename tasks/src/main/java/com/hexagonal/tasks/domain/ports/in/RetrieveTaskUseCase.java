package com.hexagonal.tasks.domain.ports.in;

import com.hexagonal.tasks.domain.models.Task;

import java.util.List;

public interface RetrieveTaskUseCase {
    <Optional> Task getTask(Long id);
    List<Task> getAllTasks();
}
