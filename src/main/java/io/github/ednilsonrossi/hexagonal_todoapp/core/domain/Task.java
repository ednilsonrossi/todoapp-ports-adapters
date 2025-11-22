package io.github.ednilsonrossi.hexagonal_todoapp.core.domain;

import java.util.Objects;

public class Task {
    private Long taskId;
    private String title;
    private Status status;

    public Task() {
        this.taskId = -1L;
        this.status = Status.PENDING;
    }

    public Task(String title) {
        this();
        this.title = title.toUpperCase();
    }

    public Task(String title, Status status) {
        this(title);
        this.status = status;
    }

    public Task(Long id, String title, Status status) {
        this(title, status);
        this.taskId = id;
    }

    public void changeTaskStatus() {
        status = status.next();
    }

    public void finishTask() {
        status = Status.COMPLETED;
    }

    public void cancelTask() {
        status = Status.CANCELED;
    }

    public void setTitle(String title) {
        this.title = title.toUpperCase();
    }

    public Long getId() {
        return taskId;
    }

    public String getTitle() {
        return title;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(taskId, task.taskId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(taskId);
    }
}
