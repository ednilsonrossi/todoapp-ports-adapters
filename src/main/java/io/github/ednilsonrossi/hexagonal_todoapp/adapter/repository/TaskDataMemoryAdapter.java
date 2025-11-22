package io.github.ednilsonrossi.hexagonal_todoapp.adapter.repository;

import io.github.ednilsonrossi.hexagonal_todoapp.core.domain.Task;
import io.github.ednilsonrossi.hexagonal_todoapp.core.port.out.TaskRepositoryPort;
import io.github.ednilsonrossi.hexagonal_todoapp.exception.TaskNotFoundException;

import java.util.LinkedList;
import java.util.List;

public class TaskDataMemoryAdapter implements TaskRepositoryPort {
    private static Long lastId = 1L;
    private final List<Task> dataset;

    public TaskDataMemoryAdapter() {
        dataset = new LinkedList<>();
    }

    @Override
    public Task save(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("DataMemoryStore: task is null.");
        }

        lastId = lastId + 1;
        var novel = new Task(lastId, task.getTitle(), task.getStatus());
        dataset.add(novel);
        return novel;
    }

    @Override
    public Task update(Task task) throws IllegalArgumentException, TaskNotFoundException {
        if (task == null) {
            throw new IllegalArgumentException("DataMemoryStore: task is null.");
        }

        Task inDataset = null;
        for (Task t : dataset) {
            if (t.equals(task)) {
                inDataset = t;
                break;
            }
        }
        if (inDataset == null) {
            throw new TaskNotFoundException(task.getId());
        }

        dataset.remove(inDataset);
        inDataset = new Task(task.getId(), task.getTitle(), task.getStatus());
        dataset.add(inDataset);
        return inDataset;
    }

    @Override
    public Task get(Long id) {
        return dataset.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Task> getAll() {
        return List.copyOf(dataset);
    }
}
