package com.equitativa.property.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equitativa.model.Property;

/**
 * @author amit
 *
 */
public interface PropertyRepository extends JpaRepository<Property, Long>{

}
