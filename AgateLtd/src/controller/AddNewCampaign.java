package controller;

import domain.Campaign;
import domain.Client;
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
		/*
		 * Find selected client
		 * */
		for(int i=0; i<Client.getClients().size();i++) {
			if(id == Client.getClients().get(i).getId()) {
				client = Client.getClients().get(i);
				
				/*campaignList size control in selected client*/
				if(client.getCampaigns().size() == 0) {
					PrintHelper.print("This client don't have campaign(s)");
				} else {
					 /*display campaign list*/					
					 for(int j = 0;j<client.getCampaigns().size();j++) {
						 int num = j + 1;
						 PrintHelper.print("  "+String.valueOf(num) + " - " +client.getCampaigns().get(j).getTitle() + " " + "(Adverts: "+client.getCampaigns().get(j).getAdvertList().size()+")");
					 }
					 
				}
			}
		}
	
	}
}
