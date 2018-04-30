package domain;

import helper.Database;

public abstract class StaffMember {
	
	/*
	 * Arda Altunyay
	 * 30.04.2018
	 * */
	
	private int staffNo;
	private String staffName;
	private String staffStartDate;
	private String staffEmailAddress;
	
	public StaffMember(String staffName, String staffStartDate, String staffEmailAddress) {
		int lastClientId = Database.lastClientId();
		this.staffNo = ++lastClientId;
		this.staffName = staffName;
		this.staffStartDate = staffStartDate;
		this.staffEmailAddress = staffEmailAddress;
	}

	public int getStaffNo() {
		return staffNo;
	}

	public void setStaffNo(int staffNo) {
		this.staffNo = staffNo;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffStartDate() {
		return staffStartDate;
	}

	public void setStaffStartDate(String staffStartDate) {
		this.staffStartDate = staffStartDate;
	}

	public String getStaffEmailAddress() {
		return staffEmailAddress;
	}

	public void setStaffEmailAddress(String staffEmailAddress) {
		this.staffEmailAddress = staffEmailAddress;
	}
	
	
}
