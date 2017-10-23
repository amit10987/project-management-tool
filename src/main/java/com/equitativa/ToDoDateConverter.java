package com.equitativa;

import java.util.Locale;

import org.apache.wicket.datetime.DateConverter;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author amit
 *
 */
public class ToDoDateConverter extends DateConverter{

	private static final long serialVersionUID = 1L;

	/**
	 * @param applyTimeZoneDifference
	 */
	public ToDoDateConverter(boolean applyTimeZoneDifference) {
		super(applyTimeZoneDifference);
	}

	@Override
	public String getDatePattern(Locale locale) {
		return CommonConstant.PATTERN_DDMMYYYY;
	}

	@Override
	protected DateTimeFormatter getFormat(Locale locale) {
		return DateTimeFormat.forPattern(CommonConstant.PATTERN_DDMMYYYY);
	}

}
