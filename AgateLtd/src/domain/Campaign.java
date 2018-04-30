package domain;

import java.util.Scanner;

import helper.PrintHelper;

//Onur TENGIRSEK
//13.04.18
public class Campaign {
	
	private String title;
	private double estimatedCost;
	private String finishDate;
	private String startDate;

public  Campaign() {}
	//Default Constructor

public static Campaign createCampaign() {
	
	String title, finishDate, startDate;
	Double estimatedCost;
	
	PrintHelper.print("Campaign Title= ", true);
	title = new Scanner(System.in).nextLine();
	
	PrintHelper.print("Campaign Start Date= ", true);
	startDate = new Scanner(System.in).nextLine();
	
	PrintHelper.print("Campaign Finish Date= ", true);
	finishDate = new Scanner(System.in).nextLine();
	
	PrintHelper.print("Campaign Estimated Cost= ", true);
	estimatedCost = new Scanner(System.in).nextDouble();
	
	Campaign campaign = new Campaign(title, startDate, finishDate, estimatedCost);
	
	return campaign;
	
}



public Campaign(String title, String startDate, String finishDate, double estimatedCost) {
		super();
		this.title = title;
		this.estimatedCost = estimatedCost;
		this.finishDate = finishDate;
		this.startDate = startDate;
	}
public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public double getEstimatedCost() {
	return estimatedCost;
}

public void setEstimatedCost(double estimatedCost) {
	this.estimatedCost = estimatedCost;
}

public String getFinishDate() {
	return finishDate;
}

public void setFinishDate(String finishDate) {
	this.finishDate = finishDate;
}

public String getStartDate() {
	return startDate;
}

public void setStartDate(String startDate) {
	this.startDate = startDate;
}



}
