package io.github.ednilsonrossi.hexagonal_todoapp.config;

import io.github.ednilsonrossi.hexagonal_todoapp.adapter.repository.TaskDataMemoryAdapter;
import io.github.ednilsonrossi.hexagonal_todoapp.adapter.repository.TaskDatabaseAdapter;
import io.github.ednilsonrossi.hexagonal_todoapp.adapter.repository.TaskEntityRepository;
import io.github.ednilsonrossi.hexagonal_todoapp.core.port.out.TaskRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public TaskRepositoryPort getRepositoryImpl() {
        return new TaskDataMemoryAdapter();
    }

//    @Bean
//    public TaskRepositoryPort getRepositoryImpl(TaskEntityRepository taskEntityRepository) {
//        return new TaskDatabaseAdapter(taskEntityRepository);
//    }

}
