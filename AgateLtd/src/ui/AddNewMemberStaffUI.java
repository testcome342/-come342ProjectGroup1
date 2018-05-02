package ui;

import java.util.List;

import controller.AddNewMemberStaff;
import domain.AdminStaff;
import domain.CreativeStaff;
import domain.StaffMember;
import helper.PrintHelper;
import helper.ScanHelper;

public class AddNewMemberStaffUI {
	
	/*
	 Onur Tengirsek
	 01.05.18
	 */
	private static AddNewMemberStaffUI instance;
	
	public static AddNewMemberStaffUI getInstance() {		
		instance = new AddNewMemberStaffUI();
		return instance;
	}
	
	private AddNewMemberStaffUI() {
		PrintHelper.print("*** Staff list ***");
		PrintHelper.printLine(40);
		List<StaffMember> staffMemberList = StaffMember.getStaffMembers();
		/*ClientList size control*/
		if(staffMemberList.size() != 0) {
			/*
			 * Print client object in clientList
			 * */
			for(int i=0; i< staffMemberList.size(); i++) {
				PrintHelper.print(String.valueOf(staffMemberList.get(i).getStaffNo()) + " " +staffMemberList.get(i).getStaffName());
			}
			
		} else {
			PrintHelper.print("Not Found Any Staff at List..!");
		}
		startInterface();
	}
	
	public void startInterface() {
		PrintHelper.printLine(40);
		/*
		 * User enter staff details
		 * */
		
		PrintHelper.print("Staff No: ", true);
		int staffNo = ScanHelper.scanInt();
		PrintHelper.print("Staff Name: ", true);
		String staffName = ScanHelper.scanString();
		PrintHelper.print("Staff Email: ", true);
		String staffEmail = ScanHelper.scanString();
		PrintHelper.print("Staff Start Date: ", true);
		String staffStartDate = ScanHelper.scanString();
		
		PrintHelper.printLine(40);
		PrintHelper.print("1- CreativeStaff");
		PrintHelper.print("2- AdminStaff");
		PrintHelper.printLine(40);
		PrintHelper.print("Please Select CreativeStaff or AdminStaff =>",true);
		int choice;
		choice = ScanHelper.scanInt();

		while(true) {
			if(choice == 1) {
				//CreativeStaff
				CreativeStaff creativeStaff = new CreativeStaff(staffNo, staffName, staffStartDate, staffEmail);
				
				createStaff(creativeStaff);
				PrintHelper.print("Succesfully! Staff added in list.");
				break;
			} else if(choice == 2) {
				//AdminStaff
				AdminStaff adminStaff = new AdminStaff(staffNo, staffName, staffStartDate, staffEmail);

				createStaff(adminStaff);
				PrintHelper.print("Succesfully! Staff added in list.");
				break;
			} else {
				//Try enter a number
				PrintHelper.print("Error!Try enter a number");
				PrintHelper.print("Please Select CreativeStaff or AdminStaff =>",true);
				choice = ScanHelper.scanInt();
			}
		}
		
	}
	
	public void createStaff(StaffMember staffMember) {
		AddNewMemberStaff.getInstance().addStaff(staffMember);
	}
}
