package com.equitativa.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.equitativa.model.Project;

/**
 * @author amit
 *
 */
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{

}
