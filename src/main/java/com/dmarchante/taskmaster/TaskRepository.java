package com.dmarchante.taskmaster;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface TaskRepository extends CrudRepository<Tasks, String> {
    @Override
    Optional<Tasks> findById(String id);
}
