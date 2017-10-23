package com.equitativa.todo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.wicket.datetime.markup.html.form.DateTextField;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.HiddenField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.equitativa.ToDoDateConverter;
import com.equitativa.activity.service.ActivityService;
import com.equitativa.employee.service.EmployeeService;
import com.equitativa.model.Activity;
import com.equitativa.model.Employee;
import com.equitativa.model.Property;
import com.equitativa.model.Status;
import com.equitativa.model.ToDo;
import com.equitativa.property.service.PropertyService;
import com.equitativa.todo.service.ToDoService;

/**
 * @author amit
 *
 */
public class ToDoForm extends Form<Void> {

	private static final String TODO_SAVED_SUCCESSFULLY = "TODO saved successfully.";
	private static final String TODO_UPDATED_SUCCESSFULLY = "TODO updated successfully.";
	private static final String ACTIVITIES = "activities";
	private static final String ACTIVITY = "activity";
	private static final String ID = "id";
	private static final String NAME = "name";
	private static final String PROPERTIES = "properties";
	private static final String PROPERTY = "property";
	private static final String EMPLOYEES = "employees";
	private static final String EMPLOYEE = "employee";
	private static final String START_DATE = "startDate";
	private static final String END_DATE = "endDate";
	private static final String STATUS_LIST = "statusList";
	private static final String STATUS = "status";

	private static final long serialVersionUID = 1L;

	private ToDo todo = new ToDo();

	@SpringBean
	transient ToDoService todoService;

	@SpringBean
	transient ActivityService activityService;

	@SpringBean
	transient PropertyService propertyService;

	@SpringBean
	transient EmployeeService employeeService;

	public ToDoForm(String id) {
		super(id);
		addToDoId();
		addActivityDropDown();
		addPropertyDropDown();
		addEmployeeDropDown();
		addStartDate();
		addEndDate();
		addStatusDropDown();
	}
	
	private void addStatusDropDown() {
		List<Status> status = Arrays.asList(Status.values());
		PropertyModel<Status> dropDownModal = new PropertyModel<Status>(todo, STATUS);
		DropDownChoice<Status> dropDownChoice = new DropDownChoice<Status>(STATUS_LIST, dropDownModal, status, new ToDoStatusRenderer());
		dropDownChoice.setRequired(true);
		add(dropDownChoice);
	}

	/**
	 * Mandatory end date, to capture task completion date
	 */
	private void addEndDate() {
		DateTextField endDate = new DateTextField(END_DATE, new PropertyModel<Date>(todo, END_DATE), new ToDoDateConverter(false));
		endDate.setRequired(true);
		add(endDate);
	}

	/**
	 * Mandatory start date to capture start date of task
	 */
	private void addStartDate() {
		DateTextField startDate = new DateTextField(START_DATE, new PropertyModel<Date>(todo, START_DATE), new ToDoDateConverter(false));
		startDate.setRequired(true);
		add(startDate);
	}

	/**
	 * Bind Employees
	 */
	private void addEmployeeDropDown() {
		List<Employee> employees = employeeService.getAllEmployees();
		PropertyModel<Employee> dropDownModal = new PropertyModel<Employee>(todo, EMPLOYEE);
		DropDownChoice<Employee> dropDownChoice = new DropDownChoice<Employee>(EMPLOYEES, dropDownModal, employees, new EmployeeFullNameChoiceRenderer());
		dropDownChoice.setRequired(true);
		add(dropDownChoice);
	}

	/**
	 * Bind properties with todo
	 */
	private void addPropertyDropDown() {
		List<Property> properties = propertyService.getAllProperties();
		PropertyModel<Property> dropDownModal = new PropertyModel<Property>(todo, PROPERTY);
		DropDownChoice<Property> dropDownChoice = new DropDownChoice<Property>(PROPERTIES, dropDownModal, properties,
				new ChoiceRenderer<Property>(NAME, ID));
		dropDownChoice.setRequired(true);
		add(dropDownChoice);
	}

	/**
	 * Bind activities
	 */
	private void addActivityDropDown() {
		List<Activity> activities = activityService.getAllActivities();
		PropertyModel<Activity> dropDownModal = new PropertyModel<Activity>(todo, ACTIVITY);
		DropDownChoice<Activity> dropDownChoice = new DropDownChoice<Activity>(ACTIVITIES, dropDownModal, activities,
				new ChoiceRenderer<Activity>(NAME, ID));
		dropDownChoice.setRequired(true);
		add(dropDownChoice);
	}

	/**
	 *  To identify todo while editing and deleting
	 */
	private void addToDoId() {
		add(new HiddenField<String>(ID, new PropertyModel<String>(todo, ID)));
	}

	public void onSubmit() {
		boolean isUpdated = null != todo.getId() ? true : false;
		todoService.create(todo);
		prepareFeedback(isUpdated);
		setResponsePage(ToDoPage.class);
	}

	/**
	 * @param isUpdated
	 */
	private void prepareFeedback(boolean isUpdated) {
		if (isUpdated) {
			getSession().info(TODO_UPDATED_SUCCESSFULLY);
		} else {
			getSession().info(TODO_SAVED_SUCCESSFULLY);
		}
	}
}