package controller;

import domain.StaffMember;

public class AddNewMemberStaff {

	/*
	 Onur Tengirsek
	 01.05.18
	 */
	
	private static AddNewMemberStaff instance = new AddNewMemberStaff();
	
	public static AddNewMemberStaff getInstance() {
		
		return instance;
	}
	
	private AddNewMemberStaff() {
		
	}
	
	public void addStaff(StaffMember staffMember) {
		StaffMember.addStaff(staffMember);
	}
	
}
