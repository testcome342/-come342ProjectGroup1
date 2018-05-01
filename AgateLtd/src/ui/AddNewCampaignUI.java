package ui;

import java.util.List;

import controller.AddNewCampaign;
import domain.Campaign;
import domain.Client;
import helper.Database;
import helper.PrintHelper;
/*
 Onur Tengir�ek
 30.04.18
 */
import helper.ScanHelper;

public class AddNewCampaignUI {

private static AddNewCampaignUI instance;
	
	public static AddNewCampaignUI getInstance() {		
		instance = new AddNewCampaignUI();
		return instance;
	}
	private AddNewCampaignUI() {
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
		int id = ScanHelper.scanInt();
		selectClient(id);
		Campaign campaign = createNewCampaign();
		
		for(int i=0; i < Database.clientList.size();i++) {
			if(id == Database.clientList.get(i).getId()) {
				Database.clientList.get(i).addNewCampaign(campaign);
				PrintHelper.print("Successfuly! This campaign added in client.");
			}
		}
		
			
	}
	
	public void selectClient(int id) {
		
		AddNewCampaign.getInstance().showClientCampaigns(id);
	}
	
	public Campaign createNewCampaign() {
		return AddNewCampaign.getInstance().createNewCampaign();
	}
			
}


