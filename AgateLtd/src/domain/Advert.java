package domain;

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
	
	
	
}
