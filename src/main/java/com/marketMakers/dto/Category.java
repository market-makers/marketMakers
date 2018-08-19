package com.marketMakers.dto;

public class Category {
	
	private String name;
    private String averagePrice;
    private Integer amount;

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAveragePrice() {
		return averagePrice;
	}
	public void setAveragePrice(String averagePrice) {
		this.averagePrice = averagePrice;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
