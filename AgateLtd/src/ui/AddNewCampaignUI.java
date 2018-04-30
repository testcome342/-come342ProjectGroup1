package ui;

import java.util.Scanner;

import controller.AddNewCampaign;
import domain.Campaign;
import domain.Client;
import helper.Database;
import helper.PrintHelper;
/*
 Onur Tengirþek
 30.04.18
 */

public class AddNewCampaignUI {

private static AddNewCampaignUI instance;
	
	public static AddNewCampaignUI getInstance() {		
		instance = new AddNewCampaignUI();
		return instance;
	}
	private AddNewCampaignUI() {
		PrintHelper.print("*** Client list ***");
		Client.getClients();
		startInterface();
		
	}
	public void startInterface() {
		PrintHelper.print("Please Select a Client =>",true);
		int id = new Scanner(System.in).nextInt();
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


