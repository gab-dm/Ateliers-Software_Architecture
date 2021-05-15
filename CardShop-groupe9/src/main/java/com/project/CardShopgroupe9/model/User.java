package com.project.CardShopgroupe9.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="User")
@Table(name="Users")


public final class User {

@Id
@GeneratedValue

private Integer id;
private String name;
private String pswd;
private float solde;
private List<Card> CardList;

	
	public User ( String _name , String _pswd ) {
		
		super();
		this.name = _name;
		this.pswd = _pswd;
		//this.CardList = 
		this.solde = 500;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	
	}
	@Override
	public String toString() {
		return " name: "+this.name + "Mot de passe: " + this.pswd + "Solde : " + this.solde;
	}

	public List<Card> getCardList() {
		return CardList;
	}

	public void setCardList(List<Card> cardList) {
		CardList = cardList;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

}
