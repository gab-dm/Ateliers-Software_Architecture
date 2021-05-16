package com.project.CardShopgroupe9.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity(name="Market")
public class Market {
	@Id
	private int marketId;
	@Id
	private int cardId;
	@Id
	private int userId;
	private Date onMarketDate;
	
	
	public Market() {}
	
	public Market(int marketId, int cardId, int userId, Date onMarketDate) {
		this.marketId = marketId;
		this.cardId = cardId;
		this.userId = userId;
		this.onMarketDate = new Date();
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
	
    public Date getOnMarketDate() {
        return onMarketDate;
    }

    public void setOnMarketDate(Date onMarketDate) {
        this.onMarketDate = onMarketDate;
    }

}
