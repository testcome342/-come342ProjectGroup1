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
		/*Select client and return boolean*/
		boolean isShowCampaign = selectClient(clientId);
		PrintHelper.printLine(40);
		
		if(isShowCampaign) {
			/*
			 * if show campaign list
			 * */
			PrintHelper.print("Please Select a Campaign =>", true);
			int campaignNo = ScanHelper.scanInt();
			campaignNo--;
			PrintHelper.printLine(40);
			/*
			 * Select campaign and
			 * display adverts in selected campaign
			 * */
			selectCampaign(campaignNo, clientId);
			

			PrintHelper.printLine(40);
			
			for(int i=0;i<Client.getClients().size();i++) {
				if(clientId == Client.getClients().get(i).getId()) {
					/*Created Advert added in campaign*/
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
