package com.equitativa.todo;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.equitativa.CommonConstant;
import com.equitativa.model.ToDo;
import com.equitativa.todo.service.ToDoService;

/**
 * @author amit
 *
 */
public class ToDoListView extends ListView<ToDo>{

	private static final long serialVersionUID = 1L;
	
	transient ToDoService todoService;

	public ToDoListView(String id, ToDoService todoService) {
		super(id, todoService.getAlltodos());
		this.todoService = todoService;
	}
	
	@Override
	protected void populateItem(ListItem<ToDo> item) {
		item.add(new Label("todoId", new PropertyModel<String>(item.getModel(), "id")));
		item.add(new Label("activityId", new PropertyModel<String>(item.getModelObject().getActivity(), "id")));
		item.add(new Label("activityName", new PropertyModel<String>(item.getModelObject().getActivity(), "name")));
		item.add(new Label("propertyId", new PropertyModel<String>(item.getModelObject().getProperty(), "id")));
		item.add(new Label("propertyName", new PropertyModel<String>(item.getModelObject().getProperty(), "name")));
		item.add(new Label("employeeId", new PropertyModel<String>(item.getModelObject().getEmployee(), "id")));
		item.add(new Label("employeeFullName", new Model<String>(getEmployeeFullName(item))));
		item.add(new Label("startDate", new PropertyModel<String>(item.getModel(), "startDate")));
		item.add(new Label("endDate", new PropertyModel<String>(item.getModel(), "endDate")));
		item.add(new Label("status", new Model<String>(item.getModelObject().getStatus().name())));
		item.add(new Label("statusId", new Model<Integer>(item.getModelObject().getStatus().ordinal())));
		item.add(deleteToDoLink(item));
	}

	/**
	 * @param item
	 * @return
	 */
	private String getEmployeeFullName(ListItem<ToDo> item) {
		
		if(null == item.getModelObject().getEmployee()){
			return "";
		}
		
		String firstName = item.getModelObject().getEmployee().getFirstName();
		String lastName = item.getModelObject().getEmployee().getLastName();
		return firstName + CommonConstant.SPACE + lastName;
	}
	
	private Link<String> deleteToDoLink(final ListItem<ToDo> item) {
		return new Link<String>("deleteToDoLink"){
			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				todoService.deleteToDo(item.getModelObject());
				getSession().info("ToDo deleted successfully.");
				setResponsePage(ToDoPage.class);
			}
		};
	}
}
