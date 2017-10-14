package com.equitativa.organization.service;


import java.io.Serializable;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;

/**
 * @author amit
 *
 */
public interface OrganizationService extends Serializable{

	/**
	 * @return
	 */
	@Cacheable("organizations")
	List<String> getOrganizationNames();
}
