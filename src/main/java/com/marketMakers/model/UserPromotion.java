package com.marketMakers.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "userPromotion")
public class UserPromotion {
	
    private String userId;
    private Long promotionId;
	
    public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Long getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(Long promotionId) {
		this.promotionId = promotionId;
	}
}
