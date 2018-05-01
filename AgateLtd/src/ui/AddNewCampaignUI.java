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

	/*
	 Onur Tengirsek
	 30.04.18
	 */
	
	private static AddNewCampaignUI instance;
	
	public static AddNewCampaignUI getInstance() {		
		instance = new AddNewCampaignUI();
		return instance;
	}
	private AddNewCampaignUI() {
		PrintHelper.print("*** Client list ***");
		PrintHelper.printLine(40);
		List<Client> clientList = Client.getClients();
		if(clientList.size() != 0) {
			for(int i=0; i< clientList.size(); i++) {
				PrintHelper.print(String.valueOf(clientList.get(i).getId()) +" - "+ clientList.get(i).getCompanyName() + 
						" (Campaigns: " + clientList.get(i).getCampaigns().size() + ")");
			}
			
		} else {
			PrintHelper.print("Not Found Any Company at List..!");
		}
		PrintHelper.printLine(40);
		startInterface();
		
	}
	
	public void startInterface() {
		PrintHelper.print("Please Select a Client =>",true);
		int id = ScanHelper.scanInt();
		PrintHelper.printLine(40);
		selectClient(id);
		PrintHelper.printLine(40);
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


