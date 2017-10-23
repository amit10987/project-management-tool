package com.equitativa.todo;

import java.util.List;

import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;

import com.equitativa.model.Status;

/**
 * To render Status Enum
 * 
 * @author amit
 *
 */
public class ToDoStatusRenderer implements IChoiceRenderer<Status>{

	private static final long serialVersionUID = 1L;

	@Override
	public Object getDisplayValue(Status status) {
		return status.name();
	}

	@Override
	public String getIdValue(Status status, int index) {
		return String.valueOf(status.ordinal());
	}

	@Override
	public Status getObject(String id, IModel<? extends List<? extends Status>> choices) {
		return choices.getObject().get(Integer.parseInt(id));
	}

}
