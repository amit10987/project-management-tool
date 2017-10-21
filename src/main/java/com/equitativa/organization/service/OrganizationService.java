package com.equitativa.organization.service;


import java.util.List;

import com.equitativa.model.Organization;

/**
 * @author amit
 *
 */
public interface OrganizationService{

	/**
	 * @return
	 */
	//@Cacheable("organizations")
	List<Organization> getOrganizationNames();
}
