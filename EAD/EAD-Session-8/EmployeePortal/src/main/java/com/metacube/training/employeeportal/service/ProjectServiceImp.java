package com.metacube.training.employeeportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.metacube.training.employeeportal.dao.ProjectDao;
import com.metacube.training.employeeportal.model.Projects;


@Service
public class ProjectServiceImp implements ProjectService{

	
	@Autowired
	private ProjectDao projectDAO;
	
	@Override
	public boolean createProject(Projects project) {
		return projectDAO.create(project);
	}

	@Override
	public boolean updateProject(Projects project) {
		return projectDAO.update(project);
	}

	@Override
	public List<Projects> getAllProjects() {
		return projectDAO.getAll();
	}
	
	@Override
	public Projects getProjectById(int id) {
		return projectDAO.getProjectById(id);
	}

	@Override
	public boolean deleteProjectById(int id) {
		return projectDAO.deleteProjectById(id);
	}
	
}
