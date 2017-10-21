package com.equitativa.todo;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.HiddenField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

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
		PropertyModel<Status> dropDownModal = new PropertyModel<Status>(todo, "status");
		DropDownChoice<Status> dropDownChoice = new DropDownChoice<Status>("statusList", dropDownModal, status, new ToDoStatusRenderer());
		add(dropDownChoice);
	}

	private void addEndDate() {
		add(new TextField<String>("endDate", new PropertyModel<String>(todo, "endDate")));
	}

	private void addStartDate() {
		add(new TextField<String>("startDate", new PropertyModel<String>(todo, "startDate")));
	}

	private void addEmployeeDropDown() {
		List<Employee> employees = employeeService.getAllEmployees();
		PropertyModel<Employee> dropDownModal = new PropertyModel<Employee>(todo, "employee");
		DropDownChoice<Employee> dropDownChoice = new DropDownChoice<Employee>("employees", dropDownModal, employees, new EmployeeFullNameChoiceRenderer());
		add(dropDownChoice);
	}

	private void addPropertyDropDown() {
		List<Property> properties = propertyService.getAllProperties();
		PropertyModel<Property> dropDownModal = new PropertyModel<Property>(todo, "property");
		DropDownChoice<Property> dropDownChoice = new DropDownChoice<Property>("properties", dropDownModal, properties,
				new ChoiceRenderer<Property>("name", "id"));
		add(dropDownChoice);
	}

	private void addActivityDropDown() {
		List<Activity> activities = activityService.getAllActivities();
		PropertyModel<Activity> dropDownModal = new PropertyModel<Activity>(todo, "activity");
		DropDownChoice<Activity> dropDownChoice = new DropDownChoice<Activity>("activities", dropDownModal, activities,
				new ChoiceRenderer<Activity>("name", "id"));
		add(dropDownChoice);
	}

	private void addToDoId() {
		add(new HiddenField<String>("id", new PropertyModel<String>(todo, "id")));
	}

	public void onSubmit() {
		boolean isUpdated = null != todo.getId() ? true : false;
		todoService.create(todo);
		prepareFeedback(isUpdated);
		setResponsePage(ToDoPage.class);
	}

	private void prepareFeedback(boolean isUpdated) {
		if (isUpdated) {
			getSession().info("TODO updated successfully.");
		} else {
			getSession().info("TODO saved successfully.");
		}
	}

	public void onError() {

	}
}