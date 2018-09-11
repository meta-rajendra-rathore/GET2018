package com.metacube.training.EmployeePortalBoot.dao;

import com.metacube.training.EmployeePortalBoot.model.Projects;

public interface ProjectDao extends BaseDao<Projects> {
	public Projects getProjectById(int id);
	public boolean deleteProjectById(int id);
}
