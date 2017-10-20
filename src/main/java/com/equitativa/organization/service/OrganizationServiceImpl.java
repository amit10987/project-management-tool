package com.equitativa.organization.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equitativa.model.Organization;
import com.equitativa.organization.repository.OrganizationRepository;

/**
 * @author amit
 *
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	OrganizationRepository organizationRepository;
	
	@Override
	public List<Organization> getOrganizationNames() {
		return organizationRepository.findAll();
	}

}
