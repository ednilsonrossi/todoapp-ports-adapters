package io.github.ednilsonrossi.hexagonal_todoapp.adapter.controller;

import io.github.ednilsonrossi.hexagonal_todoapp.core.domain.Task;
import io.github.ednilsonrossi.hexagonal_todoapp.core.port.in.TaskInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("todo")
public class TodoappController {

    private final TaskInputPort inputPort;

    public TodoappController(TaskInputPort taskInputPort) {
        this.inputPort = taskInputPort;
    }

    @GetMapping
    public ResponseEntity check() {
        return ResponseEntity.ok("Working...");
    }

    @GetMapping("/pending")
    public ResponseEntity getPending() {
        return ResponseEntity.ok(inputPort.getPendingTask());
    }

    @GetMapping("/undone")
    public ResponseEntity getUndone() {
        return ResponseEntity.ok(inputPort.getPendingAndInProgressTask());
    }

    @GetMapping("/{id}")
    public ResponseEntity getTaskByID(@PathVariable Long id) {
        var task = inputPort.getTask(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(task);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Task task) {
        var saved = inputPort.createTask(task);
        return ResponseEntity.ok(saved);
    }

    @PatchMapping("/{id}")
    public ResponseEntity changeTaskStatus(@PathVariable Long id) {
        var task = inputPort.getTask(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }

        task = inputPort.changeTaskStatus(task);
        return ResponseEntity.ok(task);
    }

}
