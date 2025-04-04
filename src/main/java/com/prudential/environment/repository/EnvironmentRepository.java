package com.prudential.environment.repository;

import com.prudential.environment.entity.Booking;
import com.prudential.environment.entity.Environment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnvironmentRepository extends JpaRepository<Environment, String> {

    @Query(value = "SELECT " +
            "e.environment_name AS environmentName, " +
            "e.environment_type AS environmentType, " +
            "e.start_date AS startDate, " +
            "e.end_date AS endDate, " +
            "es.status_name AS status, " +
            "e.assigned_engineer AS assignedEngineer, " +
            "e.version AS version, " +
            "COALESCE(p.project_id, 'NA') AS projectId, " +
            "COALESCE(p.project_name, 'NA') AS projectName " +
            "FROM " +
            "Environment e " +
            "LEFT JOIN " +
            "environment_status es ON e.status_id = es.status_id " +
            "LEFT JOIN " +
            "project_environment pe ON e.environment_name = pe.environment_name " +
            "LEFT JOIN " +
            "Project p ON pe.project_id = p.project_id " +
            "ORDER BY " +
            "e.environment_name", nativeQuery = true)
    List<Object[]> findEnvironmentProjectDetails();
}
