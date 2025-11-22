package io.github.ednilsonrossi.hexagonal_todoapp.core.port.in;

import io.github.ednilsonrossi.hexagonal_todoapp.core.domain.Task;

import java.util.List;

public interface TaskInputPort {
    Task createTask(Task task);

    Task updateTask(Task task);

    Task changeTaskStatus(Task task);

    Task finishTask(Task task);

    Task cancelTask(Task task);

    Task getTask(Long id);

    List<Task> getPendingTask();

    List<Task> getPendingAndInProgressTask();
}