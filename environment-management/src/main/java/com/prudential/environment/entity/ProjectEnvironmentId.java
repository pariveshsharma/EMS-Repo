package com.prudential.environment.entity;

import lombok.Data;

import java.io.Serializable;


@Data
public class ProjectEnvironmentId implements Serializable {
    private String project;
    private String environment;
}
