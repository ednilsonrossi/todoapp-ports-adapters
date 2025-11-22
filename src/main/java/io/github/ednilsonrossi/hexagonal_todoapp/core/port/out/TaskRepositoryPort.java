package io.github.ednilsonrossi.hexagonal_todoapp.core.port.out;

import io.github.ednilsonrossi.hexagonal_todoapp.core.domain.Task;

import java.util.List;

public interface TaskRepositoryPort {

    Task save(Task task) throws IllegalArgumentException;

    Task update(Task task) throws IllegalArgumentException;

    Task get(Long id);

    List<Task> getAll();
}
