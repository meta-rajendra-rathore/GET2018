package com.metacube.training.model;

public class Address {
	private int id;
	private int employeeId;
	private String addressLine1;
	private String addressLine2;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param employeeId
	 * @param addressLine1
	 * @param addressLine2
	 */
	public Address(int id, int employeeId, String addressLine1,
			String addressLine2) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
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
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
}