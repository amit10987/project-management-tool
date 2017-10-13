package com.equitativa.organization.service;


import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.equitativa.model.Organization;

/**
 * @author amit
 *
 */
public interface OrganizationService {

	/**
	 * @return
	 */
	@Cacheable("organizations")
	List<String> getOrganizationNames();
}
