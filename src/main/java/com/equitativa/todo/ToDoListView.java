package com.equitativa.todo;

import java.util.Date;

import org.apache.wicket.datetime.markup.html.basic.DateLabel;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.equitativa.CommonConstant;
import com.equitativa.ToDoDateConverter;
import com.equitativa.model.ToDo;
import com.equitativa.todo.service.ToDoService;

/**
 * @author amit
 *
 */
public class ToDoListView extends ListView<ToDo>{

	private static final String TO_DO_DELETED_SUCCESSFULLY = "ToDo deleted successfully.";
	private static final String DELETE_TO_DO_LINK = "deleteToDoLink";
	private static final String NAME = "name";
	private static final String ID = "id";
	private static final String STATUS_ID = "statusId";
	private static final String STATUS = "status";
	private static final String END_DATE = "endDate";
	private static final String START_DATE = "startDate";
	private static final String EMPLOYEE_FULL_NAME = "employeeFullName";
	private static final String EMPLOYEE_ID = "employeeId";
	private static final String PROPERTY_NAME = "propertyName";
	private static final String PROPERTY_ID = "propertyId";
	private static final String ACTIVITY_NAME = "activityName";
	private static final String ACTIVITY_ID = "activityId";
	private static final String TODO_ID = "todoId";
	private static final long serialVersionUID = 1L;
	
	transient ToDoService todoService;

	/**
	 * @param id
	 * @param todoService
	 */
	public ToDoListView(String id, ToDoService todoService) {
		super(id, todoService.getAlltodos());
		this.todoService = todoService;
	}
	
	@Override
	protected void populateItem(ListItem<ToDo> item) {
		
		item.add(new Label(TODO_ID, new PropertyModel<String>(item.getModel(), ID)));
		item.add(new Label(ACTIVITY_ID, new PropertyModel<String>(item.getModelObject().getActivity(), ID)));
		item.add(new Label(ACTIVITY_NAME, new PropertyModel<String>(item.getModelObject().getActivity(), NAME)));
		item.add(new Label(PROPERTY_ID, new PropertyModel<String>(item.getModelObject().getProperty(), ID)));
		item.add(new Label(PROPERTY_NAME, new PropertyModel<String>(item.getModelObject().getProperty(), NAME)));
		item.add(new Label(EMPLOYEE_ID, new PropertyModel<String>(item.getModelObject().getEmployee(), ID)));
		item.add(new Label(EMPLOYEE_FULL_NAME, new Model<String>(getEmployeeFullName(item))));
		item.add(new DateLabel(START_DATE, new PropertyModel<Date>(item.getModel(), START_DATE), new ToDoDateConverter(false)));
		item.add(new DateLabel(END_DATE, new PropertyModel<Date>(item.getModel(), END_DATE), new ToDoDateConverter(false)));
		item.add(new Label(STATUS, new Model<String>(item.getModelObject().getStatus().name())));
		item.add(new Label(STATUS_ID, new Model<Integer>(item.getModelObject().getStatus().ordinal())));
		item.add(deleteToDoLink(item));
	}

	/**
	 * @param item
	 * @return
	 */
	private String getEmployeeFullName(ListItem<ToDo> item) {
		
		if(null == item.getModelObject().getEmployee()){
			return CommonConstant.EMPTY_STRING;
		}
		
		String firstName = item.getModelObject().getEmployee().getFirstName();
		String lastName = item.getModelObject().getEmployee().getLastName();
		return firstName + CommonConstant.SPACE + lastName;
	}
	
	/**
	 * @param item
	 * @return
	 */
	private Link<String> deleteToDoLink(final ListItem<ToDo> item) {
		return new Link<String>(DELETE_TO_DO_LINK){
			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				todoService.deleteToDo(item.getModelObject());
				getSession().info(TO_DO_DELETED_SUCCESSFULLY);
				setResponsePage(ToDoPage.class);
			}
		};
	}
}
