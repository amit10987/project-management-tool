package com.equitativa.todo.service;

import java.util.List;

import com.equitativa.model.ToDo;

/**
 * @author amit
 *
 */
public interface ToDoService {

	/**
	 * @return
	 */
	List<ToDo> getAlltodos();

	/**
	 * @param todo
	 */
	void deleteToDo(ToDo todo);

	/**
	 * @param todo
	 */
	void create(ToDo todo);

}
