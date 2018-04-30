package ui;

import domain.Client;
import domain.Campaign;
import helper.Database;
import helper.PrintHelper;
import helper.ScanHelper;
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
		Client.getClients();
		startInterface();
	}
	
	public void startInterface() {
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

		int id = createNewClient(newClient);
		
		if(id > 0) {
			PrintHelper.print(" -> Succesfull!! New Client is added");
			
			PrintHelper.print("Would you like to add a campaign ? (Yes/No)");
			
			while(true) {
				
				PrintHelper.print("Answer=> ", true);
				String response = ScanHelper.scanString();
				
				if("YES".equals(response.toUpperCase())) {
					
					for(int i=0; i< Database.clientList.size(); i++) {
						if(id == Database.clientList.get(i).getId()) {
							Database.clientList.get(i).addNewCampaign(createNewCampaign());
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
