package com.equitativa.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equitativa.model.ToDo;

/**
 * @author amit
 *
 */
public interface ToDoRepository extends JpaRepository<ToDo, Long>{

}
