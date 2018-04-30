package controller;

import domain.Campaign;
import domain.Client;
import helper.Database;
import helper.PrintHelper;

public class AddNewClient {
	
	/*
	 * Arda Altunyay
	 * 14.04.2018
	 * */
	
	private static AddNewClient instance = new AddNewClient();
	
	public static AddNewClient getInstance() {
		
		return instance;
	}
	
	private AddNewClient() {
		
	}
	
	public int createNewClient(Client client) {
		return Client.createClient(client);
	}
	
	public Campaign createNewCampaign() {
		
		return Campaign.createCampaign();
	}

}
