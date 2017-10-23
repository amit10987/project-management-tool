package com.equitativa.todo;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.equitativa.HomePage;
import com.equitativa.todo.service.ToDoService;

/**
 * @author amit
 *
 */
public class ToDoPage  extends HomePage{
	
	private static final long serialVersionUID = 1L;
	
	@SpringBean
	transient ToDoService todoService;
	
	/**
	 * @param parameters
	 */
	public ToDoPage(PageParameters parameters) {
		super(parameters);
		
		add(new ToDoForm("todoForm"));
		add(new ToDoListView("todos", todoService));
	}
}
