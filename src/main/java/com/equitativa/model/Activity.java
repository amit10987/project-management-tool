package com.equitativa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author amit
 *
 */
@Entity
public class Activity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "activity")
	private List<ToDo> todos;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		
		this.name = name;
	}
	public List<ToDo> getTodos() {
		return todos;
	}
	public void setTodos(List<ToDo> todos) {
		this.todos = todos;
	}
}
