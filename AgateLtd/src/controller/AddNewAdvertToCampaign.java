package controller;

import java.util.List;

import domain.Advert;
import domain.Campaign;
import domain.Client;
import helper.PrintHelper;

public class AddNewAdvertToCampaign {
	
	/*
	 * Arda Altunyay
	 * 01.05.2018
	 * */
	
	private static AddNewAdvertToCampaign instance = new AddNewAdvertToCampaign();
	
	public static AddNewAdvertToCampaign getInstance() {
		
		return instance;
	}
	
	private AddNewAdvertToCampaign() {
		
	}
	
	public boolean showClientCampaigns(int clientId) {
		Client client;
		
		for(int i=0; i<Client.getClients().size();i++) {
			if(clientId == Client.getClients().get(i).getId()) {
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
	
	public void showCampaignAdverts(int campaignNo, int clientId) {
		Client client;
		Campaign campaign;
		
		for(int i=0; i<Client.getClients().size();i++) {
			if(clientId == Client.getClients().get(i).getId()) {
				client = Client.getClients().get(i);
				campaign = client.getCampaigns().get(campaignNo);
								
				List<Advert> advertList = campaign.getAdvertList();
								
				if(advertList.size() == 0) {
					PrintHelper.print("This campaign don't have advert(s)");
				} else {
					
					for(int j=0; j < advertList.size();j++) {
						int num = j + 1;
						PrintHelper.print(String.valueOf(num) + ") " +advertList.get(j).getAdvertTitle());
					}
					
				}
				
			}
		}
	}

	public Advert createAdvert() {
		return Advert.createAdvert();
	}
}
