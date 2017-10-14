package com.equitativa.activity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.equitativa.model.Activity;

/**
 * @author amit
 *
 */
@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long>{

}
