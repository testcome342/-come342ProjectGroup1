package controller;

import domain.Campaign;
import domain.Client;
import helper.Database;
import helper.PrintHelper;

/*
 Onur Tengirsek
 30.04.18
 */

public class AddNewCampaign {

	private static AddNewCampaign instance = new AddNewCampaign ();
	public static AddNewCampaign getInstance() {
		return instance;
	}
	
	private AddNewCampaign() {
		
	}
	public Campaign createNewCampaign() {
		return Campaign.createCampaign();
		
	}
	
	public void showClientCampaigns(int id) {
		Client client;
	
		for(int i=0; i<Database.clientList.size();i++) {
			if(id == Database.clientList.get(i).getId()) {
				client = Database.clientList.get(i);
				
				if(client.getCampaigns().size() == 0) {
					PrintHelper.print("This client don't have campaign(s)");
				} else {
										
					 for(int j = 0;j<client.getCampaigns().size();j++) {
						 PrintHelper.print(String.valueOf(j) + " " +client.getCampaigns().get(j).getTitle());
					 }
					 
				}
			}
		}
	
	}
}
