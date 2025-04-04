package com.prudential.environment.repository;

import com.prudential.environment.entity.Environment;
import com.prudential.environment.entity.Project;
import com.prudential.environment.entity.ProjectEnvironment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectEnvironmentRepository extends JpaRepository<ProjectEnvironment, Long> {
    boolean existsByProjectAndEnvironment(Project project, Environment environment);
}
