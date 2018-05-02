package domain;

import java.util.ArrayList;
import java.util.List;

import helper.PrintHelper;
import helper.ScanHelper;

//Onur TENGIRSEK
//13.04.18
public class Campaign {
	
	private String title;
	private double estimatedCost;
	private String finishDate;
	private String startDate;
	private List<StaffMember> staffMemberList;
	private List<Advert> advertList;

	public  Campaign() {}
		//Default Constructor
	
	public static Campaign createCampaign() {
		
		/*
		 * User enter campaign details
		 * */
		
		String title, finishDate, startDate;
		Double estimatedCost;
		
		PrintHelper.print("Campaign Title= ", true);
		title = ScanHelper.scanString();
		
		PrintHelper.print("Campaign Start Date= ", true);
		startDate = ScanHelper.scanString();
		
		PrintHelper.print("Campaign Finish Date= ", true);
		finishDate = ScanHelper.scanString();
		
		PrintHelper.print("Campaign Estimated Cost= ", true);
		estimatedCost = ScanHelper.scanDouble();
		
		Campaign campaign = new Campaign(title, startDate, finishDate, estimatedCost);
		
		return campaign;
		
	}

	public Campaign(String title, String startDate, String finishDate, double estimatedCost) {
			super();
			this.title = title;
			this.estimatedCost = estimatedCost;
			this.finishDate = finishDate;
			this.startDate = startDate;
			this.staffMemberList = new ArrayList<StaffMember>();
			this.advertList = new ArrayList<Advert>();
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

	public List<StaffMember> getCreativeStaffList() {
		return staffMemberList;
	}

	public void setCreativeStaffList(List<StaffMember> staffMemberList) {
		this.staffMemberList = staffMemberList;
	}
	
	public void assignStaff(StaffMember staffMember) {
		this.staffMemberList.add(staffMember);
	}

	public List<Advert> getAdvertList() {
		return advertList;
	}

	public void setAdvertList(List<Advert> advertList) {
		this.advertList = advertList;
	}
	
	public void addAdvert(Advert advert) {
		this.advertList.add(advert);
	}

}
