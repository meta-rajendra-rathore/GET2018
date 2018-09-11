package com.metacube.training.EmployeePortalBoot.service;

import java.util.List;

import com.metacube.training.EmployeePortalBoot.model.Job;


public interface JobService {
	List<Job> getAll();
	boolean create(Job job);
}
