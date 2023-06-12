package com.hexagonal.tasks.domain.ports.in;

public interface DeleteTaskUseCase {
    <Optional> boolean deleteTask(Long id);
}
