package com.equitativa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;

	public Long getId() {
		return id;
	}
	public void ListId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void ListName(String name) {
		this.name = name;
	}
}
