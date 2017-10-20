package com.equitativa.property.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equitativa.model.Property;
import com.equitativa.property.repository.PropertyRepository;

/**
 * @author amit
 *
 */
@Service
public class PropertyServiceImpl implements PropertyService{
	
	@Autowired
	PropertyRepository propertyRepository;
	
	@Override
	public List<Property> getAllProperties() {
		return propertyRepository.findAll();
	}

	@Override
	public void deleteProperty(Property property) {
		propertyRepository.delete(property.getId());
	}

	@Override
	public void create(Property property) {
		propertyRepository.save(property);
	}
}
