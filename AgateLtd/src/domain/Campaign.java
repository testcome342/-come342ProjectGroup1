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

public Campaign(String Title, String StartDate, String FinishDate, double EstimatedCost) {
	this.setTitle(title);
	this.setEstimatedCost(estimatedCost);
	this.setFinishDate(finishDate);
	this.setStartDate(startDate);
	}
public void setTitle(String title){
   this.title=title;
}
public String getTitle() {
   return title;
}
public void setEstimatedCost(double estimatedCost) {
   this.estimatedCost=estimatedCost;
}
public double getEstimatedCost() {
   return estimatedCost;
}
public void setFinishDate(String finishDate) {
   this.finishDate=finishDate;
}
public String getFinishDate() {
   return finishDate;
}
public void setStartDate(String startDate) {
   this.startDate=startDate;
}
public String getStartDate() {
   return startDate;
}
}
