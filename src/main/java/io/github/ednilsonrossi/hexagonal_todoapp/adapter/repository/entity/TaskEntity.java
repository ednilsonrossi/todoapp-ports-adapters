package io.github.ednilsonrossi.hexagonal_todoapp.adapter.repository.entity;

import io.github.ednilsonrossi.hexagonal_todoapp.core.domain.Status;
import io.github.ednilsonrossi.hexagonal_todoapp.core.domain.Task;
import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;
    private String title;
    private Integer status;

    public TaskEntity() { }

    public TaskEntity(Task task) {
        if (task.getId() == -1L) {
            taskId = null;
        } else {
            this.taskId = task.getId();
        }
        this.title = task.getTitle();
        this.status = task.getStatus().getOrder();
    }

    public Task toDomain() {
        return new Task(taskId, title, Status.fromCode(status));
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}
