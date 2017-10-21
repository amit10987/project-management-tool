package com.equitativa.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equitativa.model.ToDo;
import com.equitativa.todo.repository.ToDoRepository;

/**
 * @author amit
 *
 */
@Service
public class ToDoServiceImpl implements ToDoService{
	
	@Autowired
	ToDoRepository todoRepository;

	@Override
	public List<ToDo> getAlltodos() {
		return todoRepository.findAll();
	}

	@Override
	public void deleteToDo(ToDo todo) {
		todoRepository.delete(todo.getId());
	}

	@Override
	public void create(ToDo todo) {
		todoRepository.save(todo);
	}
}
