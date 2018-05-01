package domain;

import java.util.List;

import helper.Database;

public class CreativeStaff extends StaffMember{
	
	/*
	 * Arda Altunyay
	 * 30.04.2018
	 * */

	public CreativeStaff(int staffNo, String staffName, String staffStartDate, String staffEmailAddress) {
		super(staffNo, staffName, staffStartDate, staffEmailAddress);
		
		
	}
	
	public static List<CreativeStaff> getCreativeStaffs() {
		return Database.creativeStaffList;
	}

}
