package com.equitativa.activity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equitativa.model.Activity;

/**
 * @author amit
 *
 */
public interface ActivityRepository extends JpaRepository<Activity, Long>{

}
