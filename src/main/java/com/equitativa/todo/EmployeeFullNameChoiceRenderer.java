package com.equitativa.todo;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;

import com.equitativa.CommonConstant;
import com.equitativa.model.Employee;

/**
 * @author amit
 *
 */
public class EmployeeFullNameChoiceRenderer implements IChoiceRenderer<Employee>{

	private static final long serialVersionUID = 1L;

	@Override
	public String getDisplayValue(Employee employee) {
		return employee.getFirstName() + CommonConstant.SPACE + employee.getLastName();
	}

	@Override
	public String getIdValue(Employee employee, int index) {
		return employee.getId().toString();
	}

	@Override
	public Employee getObject(String id, IModel<? extends List<? extends Employee>> choices) {
		Map<String, Employee> employeeMap = choices.getObject().stream().collect(Collectors.toMap(emp -> String.valueOf(emp.getId()), Function.identity()));
		return employeeMap.get(id);
	}

}
