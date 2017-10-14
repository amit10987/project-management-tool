package com.equitativa.organization.service;

import java.util.List;
import java.util.stream.Collectors;

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

	private static final long serialVersionUID = -5212963861024643073L;
	
	@Autowired
	transient OrganizationRepository organizationRepository;
	
	@Override
	public List<String> getOrganizationNames() {
		return organizationRepository.findAll().stream().map(Organization::getName).collect(Collectors.toList());
	}

}
