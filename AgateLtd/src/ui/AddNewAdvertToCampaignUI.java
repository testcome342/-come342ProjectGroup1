package ui;

import java.util.List;

import controller.AddNewAdvertToCampaign;
import domain.Advert;
import domain.Client;
import helper.PrintHelper;
import helper.ScanHelper;

public class AddNewAdvertToCampaignUI {
	
	/*
	 * Arda Altunyay
	 * 01.05.2018
	 * */
	
	private static AddNewAdvertToCampaignUI instance;
	
	public static AddNewAdvertToCampaignUI getInstance() {		
		instance = new AddNewAdvertToCampaignUI();
		return instance;
	}
	
	private AddNewAdvertToCampaignUI() {
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
			
			selectCampaign(campaignNo, clientId);
			
			PrintHelper.printLine(40);
			
			for(int i=0;i<Client.getClients().size();i++) {
				if(clientId == Client.getClients().get(i).getId()) {
					Client.getClients().get(i).getCampaigns().get(campaignNo).addAdvert(createAdvert());
					PrintHelper.print("Succesfully! Advert added in campaign");
				}
			}
			
			
		}
	}
	
	public boolean selectClient(int clientId) {
		return AddNewAdvertToCampaign.getInstance().showClientCampaigns(clientId);
	}
	
	public void selectCampaign(int campaignNo, int clientId) {
		AddNewAdvertToCampaign.getInstance().showCampaignAdverts(campaignNo, clientId);
	}
	
	public Advert createAdvert() {
		return AddNewAdvertToCampaign.getInstance().createAdvert();
	}

}
