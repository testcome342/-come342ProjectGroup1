package controller;

import java.util.ArrayList;
import java.util.List;

import domain.Campaign;
import domain.Client;
import domain.CreativeStaff;
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
		
		for(int i=0; i<Client.getClients().size();i++) {
			if(id == Client.getClients().get(i).getId()) {
				client = Client.getClients().get(i);
				
				if(client.getCampaigns().size() == 0) {
					PrintHelper.print("This client don't have campaign(s)");
					return false;
				} else {
										
					 for(int j = 0;j<client.getCampaigns().size();j++) {
						 int num = j + 1;
						 PrintHelper.print(String.valueOf(num) + ") " +client.getCampaigns().get(j).getTitle());
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
		
		for(int i=0; i<Client.getClients().size();i++) {
			if(clientId == Client.getClients().get(i).getId()) {
				client = Client.getClients().get(i);
				campaign = client.getCampaigns().get(campaignNo);
								
				List<CreativeStaff> creativeStaffList = new ArrayList<CreativeStaff>(CreativeStaff.getCreativeStaffs());
				
				creativeStaffList.removeAll(campaign.getCreativeStaffList());
				
				if(creativeStaffList.size() == 0) {
					PrintHelper.print("This client don't have campaign(s)");
					return false;
				} else {
					
					for(int j=0; j < creativeStaffList.size();j++) {
						PrintHelper.print(String.valueOf(creativeStaffList.get(j).getStaffNo())+ " - " +creativeStaffList.get(j).getStaffName());
					}
					
					return true;
				}
				
			}
		}
		return false;
	}

	public void selectCreativeStaff(int staffNo, int campaignNo, int clientId) {
		Client client;
		Campaign campaign;
		
		for(int i=0;i<Client.getClients().size();i++) {
			if(clientId == Client.getClients().get(i).getId()) {
				client = Client.getClients().get(i);
				campaign = client.getCampaigns().get(campaignNo);
				
				for(int j=0;j<CreativeStaff.getCreativeStaffs().size();j++) {
					if(staffNo == CreativeStaff.getCreativeStaffs().get(j).getStaffNo()) {
						campaign.assignStaff(CreativeStaff.getCreativeStaffs().get(j));
					}
				}
				
			}
		}
	}
}
