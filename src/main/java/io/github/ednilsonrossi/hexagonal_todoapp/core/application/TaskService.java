package io.github.ednilsonrossi.hexagonal_todoapp.core.application;

import io.github.ednilsonrossi.hexagonal_todoapp.core.domain.Status;
import io.github.ednilsonrossi.hexagonal_todoapp.core.domain.Task;
import io.github.ednilsonrossi.hexagonal_todoapp.core.port.in.TaskInputPort;
import io.github.ednilsonrossi.hexagonal_todoapp.core.port.out.TaskRepositoryPort;

import java.util.List;
import java.util.stream.Collectors;

public class TaskService implements TaskInputPort {

    private final TaskRepositoryPort repository;

    public TaskService(TaskRepositoryPort taskRepositoryPort) {
        this.repository = taskRepositoryPort;
    }

    @Override
    public Task createTask(Task task) {
        return repository.save(task);
    }

    @Override
    public Task updateTask(Task task) {
        return repository.update(task);
    }

    @Override
    public Task changeTaskStatus(Task task) {
        task.changeTaskStatus();
        return repository.update(task);
    }

    @Override
    public Task finishTask(Task task) {
        task.finishTask();
        return repository.update(task);
    }

    @Override
    public Task cancelTask(Task task) {
        task.cancelTask();
        return repository.update(task);
    }

    @Override
    public Task getTask(Long id) {
        return repository.get(id);
    }

    @Override
    public List<Task> getPendingTask() {
        var all = repository.getAll();
        return all.stream()
                .filter(task -> task.getStatus() == Status.PENDING)
                .toList();
    }

    @Override
    public List<Task> getPendingAndInProgressTask() {
        var all = repository.getAll();
        return all.stream()
                .filter(task -> task.getStatus() == Status.PENDING || task.getStatus() == Status.IN_PROGRESS)
                .collect(Collectors.toList());
    }
}
