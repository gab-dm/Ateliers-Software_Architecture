package com.project.CardShopgroupe9.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.CardShopgroupe9.repository.CardRepository;

@Entity(name="User")
@Table(name="Users")


public final class User {

	
	
	@Id
	@GeneratedValue
	
	private Integer id;
	private String name;
	private String pswd;
	private float solde=500;
	@ManyToMany
	@JoinTable(
			  name = "card_user", 
			  joinColumns = @JoinColumn(name = "user_id"), 
			  inverseJoinColumns = @JoinColumn(name = "card_id")
			  )
	
	
	
	
	private List<Card> CardList;
	
		public User() {
			this.CardList=new ArrayList<Card>();
		}
		
		
		public User ( String _name , String _pswd ) {
			
			super();
			this.name = _name;
			this.pswd = _pswd;
			
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
			return "id :"+ this.id+ "name: "+this.name + " Mot de passe: " + this.pswd + " Solde : " + this.solde + " deck : "+ this.CardList;
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
