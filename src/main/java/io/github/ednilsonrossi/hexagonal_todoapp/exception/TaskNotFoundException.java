package io.github.ednilsonrossi.hexagonal_todoapp.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long id) {
        super("Task " + id + " not founded.");
    }
}
