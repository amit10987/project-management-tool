package com.equitativa.property.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.equitativa.model.Property;

/**
 * @author amit
 *
 */
public interface PropertyService {

	/**
	 * @return
	 */
	@Transactional(readOnly = true)
	List<Property> getAllProperties();

	/**
	 * @param property
	 */
	@Transactional
	void deleteProperty(Property property);

	/**
	 * @param property
	 */
	@Transactional
	void create(Property property);

}
