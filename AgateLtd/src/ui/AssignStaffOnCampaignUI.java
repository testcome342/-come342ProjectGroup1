package ui;

import java.util.List;

import controller.AssignStaffOnCampaign;
import domain.Client;
import helper.PrintHelper;
import helper.ScanHelper;

public class AssignStaffOnCampaignUI {

	//Arda Batuhan Demir
	//30.04.2018
	
	private static AssignStaffOnCampaignUI instance;
	
	public static AssignStaffOnCampaignUI getInstance() {		
		instance = new AssignStaffOnCampaignUI();
		return instance;
	}
	
	private AssignStaffOnCampaignUI() {
		PrintHelper.print("*** Client list ***");
		List<Client> clientList = Client.getClients();
		if(clientList.size() != 0) {
			for(int i=0; i< clientList.size(); i++) {
				PrintHelper.print(String.valueOf(clientList.get(i).getId()) +" - "+ clientList.get(i).getCompanyName() + 
						" (Campaigns: " + clientList.get(i).getCampaigns().size() + ")");
			}
			
		} else {
			PrintHelper.print("Not Found Any Company at List..!");
		}
		startInterface();
	}
	
	public void startInterface() {
		PrintHelper.print("Please Select a Client =>",true);
		int clientId = ScanHelper.scanInt();
		
		boolean isShowCampaign = selectClient(clientId);
		
		if(isShowCampaign) {
			PrintHelper.print("Please Select a Campaign =>", true);
			int campaignNo = ScanHelper.scanInt();
			campaignNo--;
			boolean isShowStaff = selectCampaign(campaignNo, clientId);
			
			if(isShowStaff) {
				PrintHelper.print("Please Select a Staff =>", true);
				int staffNo = ScanHelper.scanInt();
				
				selectCreativeStaff(staffNo, campaignNo, clientId);
			}
			
		}
		
		
	}
	
	public boolean selectClient(int clientId) {
		return AssignStaffOnCampaign.getInstance().showClientCampaigns(clientId);
	}
	
	public boolean selectCampaign(int campaignNo, int clientId) {
		return AssignStaffOnCampaign.getInstance().showCampaignNotWorkStaff(campaignNo, clientId);
	}
	
	public void selectCreativeStaff(int staffNo, int campaignNo, int cliendId) {
		AssignStaffOnCampaign.getInstance().selectCreativeStaff(staffNo, campaignNo, cliendId);
	}
}
