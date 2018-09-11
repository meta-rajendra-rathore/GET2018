package com.metacube.training.model;

public class Project {
	private int id;
	private String name;
	private String startDate;
	private String endDate;
	private String projectLogo;
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param startDate
	 * @param endDate
	 * @param projectLogo
	 */
	public Project(int id, String name, String startDate, String endDate,
			String projectLogo) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.projectLogo = projectLogo;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the projectLogo
	 */
	public String getProjectLogo() {
		return projectLogo;
	}

	/**
	 * @param projectLogo the projectLogo to set
	 */
	public void setProjectLogo(String projectLogo) {
		this.projectLogo = projectLogo;
	}
}
