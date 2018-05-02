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
		PrintHelper.printLine(40);
		List<Client> clientList = Client.getClients();
		
		/*ClientList size control*/
		if(clientList.size() != 0) {
			/*
			 * Print client object in clientList
			 * */
			for(int i=0; i< clientList.size(); i++) {
				PrintHelper.print(String.valueOf(clientList.get(i).getId()) +" - "+ clientList.get(i).getCompanyName() + 
						" (Campaigns: " + clientList.get(i).getCampaigns().size() + ")");
			}
			
		} else {
			/*İf clientList don't have client*/
			PrintHelper.print("Not Found Any Company at List..!");
		}
		PrintHelper.printLine(40);
		startInterface();
	}
	
	public void startInterface() {
		PrintHelper.print("Please Select a Client =>",true);
		int clientId = ScanHelper.scanInt();
		PrintHelper.printLine(40);
		/*
		 * Send selected clientId, 
		 * after show campaign in selected client
		 * */
		boolean isShowCampaign = selectClient(clientId);
		PrintHelper.printLine(40);
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
		AssignStaffOnCampaign.getInstance().selectStaffMember(staffNo, campaignNo, cliendId);
	}
}
