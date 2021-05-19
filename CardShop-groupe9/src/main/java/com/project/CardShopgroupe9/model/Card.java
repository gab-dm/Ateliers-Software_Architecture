package com.project.CardShopgroupe9.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="Card")
public final class Card {


@Id
@GeneratedValue
private Integer id;
private String name;
private Integer hp;
private String description;
private String imgUrl;
private Integer attack;
private Integer defence;
private boolean isFree = true;

@ManyToMany
private List<User> userList;
private static Integer price;
	
	public Card() {}


	public Card ( String name , Integer hp, String description, String imgUrl, Integer attack, Integer defence, Integer price ) {
		
		super();
		this.name = name;
		this.hp = hp;
		this.description = description ;
		this.imgUrl = imgUrl; 
		this.attack = attack;
		this.defence = defence;
		
		Card.price = price;
		
	}

public Card ( String name , Integer hp, String description, String imgUrl, Integer attack, Integer defence ) {
		
		super();
		this.name = name;
		this.hp = hp;
		this.description = description ;
		this.imgUrl = imgUrl; 
		this.attack = attack;
		this.defence = defence;
		
		Card.price = 400;
		
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

	public Integer getHp() {
		return hp;
	}

	public void setHp(Integer hp) {
		this.hp = hp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public void setAttack(Integer attack) {
		this.attack = attack;
	}
	
	public Integer getAttack() {
		return attack;
	}
	
	public void setDefence(Integer defence) {
		this.defence = defence;
	}
	
	public Integer getDefence() {
		return defence;
	}
	
	
	public void setPrice(Integer price) {
		Card.price = price;
	}
	
	public static Integer getPrice() {
		return price;
	}
	public boolean getIsFree() {
		return this.isFree;
	}
	public void setNotFree() {
		this.isFree = false;
	}
	@Override
	public String toString() {
		return "Carte ["+getId()+"]: name:"+getName() +", hp:"+getHp()+", imgUrl:"+getImgUrl() + ", attack:"+getAttack() + ", defence:" +getDefence();
	}
	

} 