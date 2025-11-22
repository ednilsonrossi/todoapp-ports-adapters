package io.github.ednilsonrossi.hexagonal_todoapp.config;

import io.github.ednilsonrossi.hexagonal_todoapp.core.application.TaskService;
import io.github.ednilsonrossi.hexagonal_todoapp.core.port.in.TaskInputPort;
import io.github.ednilsonrossi.hexagonal_todoapp.core.port.out.TaskRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InputPortConfig {

    @Bean
    public TaskInputPort getTaskInputImpl(TaskRepositoryPort repositoryPort) {
        return new TaskService(repositoryPort);
    }
}
