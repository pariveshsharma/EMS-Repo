package com.prudential.environment.repository;

import com.prudential.environment.entity.Booking;
import com.prudential.environment.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, String> {

    @Query(value = "SELECT " +
            "p.project_id AS projectId, " +
            "p.project_name AS projectName, " +
            "p.start_date AS startDate, " +
            "p.end_date AS endDate, " +
            "p.project_manager AS projectManager, " +
            "p.status AS status, " +
            "p.version AS version, " +
            "COALESCE(e.environment_name, 'NA') AS environmentName, " +
            "COALESCE(e.environment_type, 'NA') AS environmentType " +
            "FROM " +
            "Project p " +
            "LEFT JOIN " +
            "project_environment pe ON p.project_id = pe.project_id " +
            "LEFT JOIN " +
            "Environment e ON pe.environment_name = e.environment_name " +
            "ORDER BY " +
            "p.project_id", nativeQuery = true)
    List<Object[]> findProjectDetails();
}
