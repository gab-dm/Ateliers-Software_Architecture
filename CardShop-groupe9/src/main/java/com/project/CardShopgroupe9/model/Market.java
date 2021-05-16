package com.project.CardShopgroupe9.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name="Market")
public class Market {
	@Id
	private int marketId;
	@Id
	private int cardId;
	@Id
	private int userId;
	
	
	public Market() {}
	
	public Market(int marketId, int cardId, int userId) {
		this.marketId = marketId;
		this.cardId = cardId;
		this.userId = userId;
	}
	
	
	
	public int getMarketId() {
		return marketId;
	}
	
	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}
	
	public int getCardId() {
		return cardId;
	}
	
	public void setCardId(int cardId) {
        this.cardId = cardId;
    }
	
	public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
	

}
