package com.prudential.environment.repository;

import com.prudential.environment.entity.EnvironmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvironmentStatusRepository extends JpaRepository<EnvironmentStatus,String> {
}
