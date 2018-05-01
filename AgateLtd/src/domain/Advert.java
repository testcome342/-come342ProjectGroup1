package domain;

import helper.PrintHelper;
import helper.ScanHelper;

public class Advert {
	
	private String advertTitle;
	private String targetCompletionDate;
	private Double estimatedAdvertCost;
	private Double actualAdvertCost;
	
	public Advert(String advertTitle, String targetCompletionDate, Double estimatedAdvertCost, Double actualAdvertCost) {
		super();
		this.advertTitle = advertTitle;
		this.targetCompletionDate = targetCompletionDate;
		this.estimatedAdvertCost = estimatedAdvertCost;
		this.actualAdvertCost = actualAdvertCost;
	}

	public String getAdvertTitle() {
		return advertTitle;
	}

	public void setAdvertTitle(String advertTitle) {
		this.advertTitle = advertTitle;
	}

	public String getTargetCompletionDate() {
		return targetCompletionDate;
	}

	public void setTargetCompletionDate(String targetCompletionDate) {
		this.targetCompletionDate = targetCompletionDate;
	}

	public Double getEstimatedAdvertCost() {
		return estimatedAdvertCost;
	}

	public void setEstimatedAdvertCost(Double estimatedAdvertCost) {
		this.estimatedAdvertCost = estimatedAdvertCost;
	}

	public Double getActualAdvertCost() {
		return actualAdvertCost;
	}

	public void setActualAdvertCost(Double actualAdvertCost) {
		this.actualAdvertCost = actualAdvertCost;
	}
	
	public static Advert createAdvert() {
		
		PrintHelper.print("Advert Title: ", true);
		String advertTitle = ScanHelper.scanString();
		
		PrintHelper.print("Target Completion Date: ", true);
		String targetCompletionDate = ScanHelper.scanString();
		
		PrintHelper.print("Estimated Advert Cost: ", true);
		Double estimatedAdvertCost = ScanHelper.scanDouble();
		
		PrintHelper.print("Actual Advert Cost: ", true);
		Double actualAdvertCost = ScanHelper.scanDouble();
		PrintHelper.printLine(40);
		PrintHelper.print("1- Poster Advert");
		PrintHelper.print("2- Leaflet Advert");
		PrintHelper.print("3- Magazine Advert");
		PrintHelper.print("4- Newspaper Advert");
		PrintHelper.print("5- TV Advert");
		PrintHelper.print("6- Radio Advert");
		PrintHelper.printLine(40);
		PrintHelper.print("Please enter a advert number=> ", true);
		int choice = ScanHelper.scanInt();
		
		while(true) {
			PrintHelper.printLine(40);
			if(choice == 1) {
				//Poster Advert
				Advert advert = new PosterAdvert(advertTitle, targetCompletionDate, estimatedAdvertCost, actualAdvertCost);
				return advert;
				
			} else if(choice == 2) {
				// Leaflet Advert
				Advert advert = new LeafletAdvert(advertTitle, targetCompletionDate, estimatedAdvertCost, actualAdvertCost);
				return advert;

			} else if(choice == 3) {
				//Maganize Advert
				Advert advert = new MagazineAdvert(advertTitle, targetCompletionDate, estimatedAdvertCost, actualAdvertCost);
				return advert;

			} else if(choice == 4) {
				//Newspaper Advert
				Advert advert = new NewspaperAdvert(advertTitle, targetCompletionDate, estimatedAdvertCost, actualAdvertCost);
				return advert;
			
			} else if(choice == 5) {
				//Tv Advert
				Advert advert = new TvAdvert(advertTitle, targetCompletionDate, estimatedAdvertCost, actualAdvertCost);
				return advert;

			} else if(choice == 6) {
				//Radio Advert
				Advert advert = new RadioAdvert(advertTitle, targetCompletionDate, estimatedAdvertCost, actualAdvertCost);
				return advert;

			} else {
				PrintHelper.print("Error! Try enter a advert number.");
				PrintHelper.print("Please enter a advert number=> ", true);
				choice = ScanHelper.scanInt();
			}
		}
			
	}
	
	
	
}
