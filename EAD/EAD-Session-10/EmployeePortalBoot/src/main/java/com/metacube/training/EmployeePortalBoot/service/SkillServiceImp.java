package com.metacube.training.EmployeePortalBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortalBoot.dao.SkillDao;
import com.metacube.training.EmployeePortalBoot.model.Skill;


@Service
public class SkillServiceImp implements SkillService {
	
	@Autowired
	private SkillDao skillDao;

	@Override
	public boolean create(Skill skill) {
		return skillDao.create(skill);
	}

	@Override
	public boolean delete(Skill skill) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Skill skill) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Skill> getAll() {
		return skillDao.getAll();
	}
}
