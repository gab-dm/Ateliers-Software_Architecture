package com.project.CardShopgroupe9.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.project.CardShopgroupe9.repository.CardRepository;
import com.project.CardShopgroupe9.service.CardService;
import com.project.CardShopgroupe9.service.UserService;

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
		this.CardList = generateCardList();
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
		return " name: "+this.name + " Mot de passe: " + this.pswd + " Solde : " + this.solde;
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
	public List<Card> generateCardList(){
		Random random = new Random(System.currentTimeMillis()); //Pour avoir une seed "unique", on utilise la date
		CardRepository cRepository = null;
		List<Card> cards = new ArrayList<>();
		List<Card> cardsAvailable = cRepository.findAll();
        int nbCardsAvailable = cardsAvailable.size();
        Card randomCard;
        for(int i = 0; i < 5; i++){
        	int randomNumber =random.nextInt(nbCardsAvailable);
            randomCard = cardsAvailable.get(randomNumber);
            cards.add(randomCard);
        }
        return cards;
	}
	//public String buyCard(Card card, int price) {

	public void addCard(Card card) {
		// TODO Auto-generated method stub
		this.CardList.add(card);
	}

	public void removeCard(Card card) {
		// TODO Auto-generated method stub
		this.CardList.remove(card);
	}
		
		
	

}
