package controller;

import java.util.ArrayList;
import java.util.List;

import domain.Campaign;
import domain.Client;
import domain.StaffMember;
import helper.PrintHelper;

public class AssignStaffOnCampaign {
	
	//Arda Batuhan Demir
	//01.05.2018
	
	private static AssignStaffOnCampaign instance = new AssignStaffOnCampaign();
	
	public static AssignStaffOnCampaign getInstance() {
		
		return instance;
	}
	
	private AssignStaffOnCampaign() {
		
	}
	
	public boolean showClientCampaigns(int id) {
		Client client;
		/*Find selected client*/
		for(int i=0; i<Client.getClients().size();i++) {
			if(id == Client.getClients().get(i).getId()) {
				client = Client.getClients().get(i);
				
				/*control campaignList size in selected client*/
				if(client.getCampaigns().size() == 0) {
					PrintHelper.print("This client don't have campaign(s)");
					return false;
				} else {
										
					/*
					 * Display campaigns in selected client
					 * */
					 for(int j = 0;j<client.getCampaigns().size();j++) {
						 int num = j + 1;
						 PrintHelper.print("  "+String.valueOf(num) + " - " +client.getCampaigns().get(j).getTitle() +" (Adverts: "+ client.getCampaigns().get(j).getAdvertList().size()+")");
					 }
					 return true;
				}
			}
		}
		return false;
	}

	public boolean showCampaignNotWorkStaff(int campaignNo, int clientId) {
		Client client;
		Campaign campaign;
		
		/*Find selected client*/
		for(int i=0; i<Client.getClients().size();i++) {
			if(clientId == Client.getClients().get(i).getId()) {
				client = Client.getClients().get(i);
				campaign = client.getCampaigns().get(campaignNo);
				
				/*
				 * assign list from staffList in database to staffMemberList
				 * */
				List<StaffMember> staffMemberList = new ArrayList<StaffMember>(StaffMember.getStaffMembers());
				
				/*remove staffs in campaigns*/
				staffMemberList.removeAll(campaign.getCreativeStaffList());
				
				/*
				 * Size control
				 * */
				if(staffMemberList.size() == 0) {
					PrintHelper.print("This campaign has enough staff(s)");
					return false;
				} else {
					PrintHelper.print("*** Staff list of not working this campaign ***");
					PrintHelper.printLine(40);
					
					/*
					 * Display staffMemberList
					 * */
					for(int j=0; j < staffMemberList.size();j++) {
						PrintHelper.print("    "+String.valueOf(staffMemberList.get(j).getStaffNo())+ " - " +staffMemberList.get(j).getStaffName());
					}
					PrintHelper.printLine(40);
					return true;
				}
				
			}
		}
		return false;
	}

	public void selectStaffMember(int staffNo, int campaignNo, int clientId) {
		Client client;
		Campaign campaign;
		/*Find selected client*/
		for(int i=0;i<Client.getClients().size();i++) {
			if(clientId == Client.getClients().get(i).getId()) {
				client = Client.getClients().get(i);
				campaign = client.getCampaigns().get(campaignNo);
				
				/*Find selected staff and assign selected campaign*/
				for(int j=0;j<StaffMember.getStaffMembers().size();j++) {
					if(staffNo == StaffMember.getStaffMembers().get(j).getStaffNo()) {
						campaign.assignStaff(StaffMember.getStaffMembers().get(j));
						PrintHelper.print("Successfuly! This staff added in campaign.");
					}
				}
				
			}
		}
	}
}
