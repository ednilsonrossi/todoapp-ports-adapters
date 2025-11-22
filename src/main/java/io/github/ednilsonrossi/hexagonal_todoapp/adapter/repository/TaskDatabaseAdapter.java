package io.github.ednilsonrossi.hexagonal_todoapp.adapter.repository;

import io.github.ednilsonrossi.hexagonal_todoapp.adapter.repository.entity.TaskEntity;
import io.github.ednilsonrossi.hexagonal_todoapp.core.domain.Task;
import io.github.ednilsonrossi.hexagonal_todoapp.core.port.out.TaskRepositoryPort;

import java.util.List;
import java.util.Optional;

public class TaskDatabaseAdapter implements TaskRepositoryPort {

    private final TaskEntityRepository repository;

    public TaskDatabaseAdapter(TaskEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Task save(Task task) throws IllegalArgumentException {
        var entity = new TaskEntity(task);
        var saved = repository.save(entity);
        return saved.toDomain();
    }

    @Override
    public Task update(Task task) throws IllegalArgumentException {
        var entity = new TaskEntity(task);
        var saved = repository.save(entity);
        return saved.toDomain();
    }

    @Override
    public Task get(Long id) {
        Optional<TaskEntity> entity = repository.findById(id);
        return entity.map(TaskEntity::toDomain).orElse(null);
    }

    @Override
    public List<Task> getAll() {
        return repository.findAll()
                .stream()
                .map(TaskEntity::toDomain)
                .toList();
    }
}
