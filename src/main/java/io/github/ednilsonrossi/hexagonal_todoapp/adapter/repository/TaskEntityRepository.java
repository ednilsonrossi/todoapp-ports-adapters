package io.github.ednilsonrossi.hexagonal_todoapp.adapter.repository;

import io.github.ednilsonrossi.hexagonal_todoapp.adapter.repository.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TaskEntityRepository extends JpaRepository<TaskEntity, Long> {

}
