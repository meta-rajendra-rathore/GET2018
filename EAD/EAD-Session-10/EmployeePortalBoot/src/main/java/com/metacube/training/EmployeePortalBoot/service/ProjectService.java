package com.metacube.training.EmployeePortalBoot.service;

import java.util.List;

import com.metacube.training.EmployeePortalBoot.model.Projects;


public interface ProjectService {
	boolean createProject(Projects project);

	boolean updateProject(Projects project);

	List<Projects> getAllProjects();
	
	Projects getProjectById(int id);
	boolean deleteProjectById(int id);
}
