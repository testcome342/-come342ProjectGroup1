package ui;

import domain.Client;
import domain.Campaign;
import helper.Database;
import helper.PrintHelper;
import helper.ScanHelper;

import java.util.List;

import controller.AddNewClient;

public class AddNewClientUI {
	
	/*
	 * Arda Altunyay
	 * 14.04.2018
	 * */
	
	private static AddNewClientUI instance;
	
	public static AddNewClientUI getInstance() {		
		instance = new AddNewClientUI();
		return instance;
	}
	
	private AddNewClientUI() {
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
		
		/*
		 * User enter client details
		 * */
		
		String companyName, companyAddress, companyEmail, contactName, contactEmail;
		int companyNo;
		
		PrintHelper.print("Company No= ", true);
		companyNo = ScanHelper.scanInt();
		
		PrintHelper.print("Company Name= ", true);
		companyName = ScanHelper.scanString();
		
		PrintHelper.print("Company Address= ", true);
		companyAddress = ScanHelper.scanString();

		PrintHelper.print("Company Email= ", true);
		companyEmail = ScanHelper.scanString();

		PrintHelper.print("Contact Name= ", true);
		contactName = ScanHelper.scanString();

		PrintHelper.print("Contact Email= ", true);
		contactEmail = ScanHelper.scanString();

		Client newClient = new Client(companyNo, companyName, companyAddress, companyEmail, contactName, contactEmail);

		/*Client created and if client add, return clientId*/
		int id = createNewClient(newClient);
		
		if(id > 0) {
			/*
			 * İf client add in clientList
			 * */
			
			PrintHelper.print(" -> Succesfull!! New Client is added");
			
			PrintHelper.print("Would you like to add a campaign ? (Yes/No)");
			/*
			 * After client add, ask to create campaingn 
			 * */
			while(true) {
				
				PrintHelper.print("Answer=> ", true);
				String response = ScanHelper.scanString();
				
				if("YES".equals(response.toUpperCase())) {
					
					for(int i=0; i< Database.clientList.size(); i++) {
						if(id == Database.clientList.get(i).getId()) {
							Database.clientList.get(i).addNewCampaign(createNewCampaign());
							PrintHelper.print(" -> Succesfull!! New Campaign is added");

						}
					}
					break;
				} else if("NO".equals(response.toUpperCase())){
					
					break;
					
				} else {
					
					PrintHelper.print("Error! Try enter answer");
				}
			}
			
		} else {
			PrintHelper.print(" -> Error!! New Client is not added");
		}
		
	}
	
	private int createNewClient(Client client) {	
		
		int id = AddNewClient.getInstance().createNewClient(client);
	
		return id;
	}
	
	private Campaign createNewCampaign() {
		
		return AddNewClient.getInstance().createNewCampaign();
	}
}
