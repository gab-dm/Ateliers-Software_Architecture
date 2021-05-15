package com.project.CardShopgroupe9.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
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
private String family;
private Integer energy;
	
	public Card ( String name , Integer hp, String description, String imgUrl, Integer attack, Integer defence, String family, Integer energy ) {
		
		super();
		this.name = name;
		this.hp = hp;
		this.description = description ;
		this.imgUrl = imgUrl; 
		this.attack = attack;
		this.defence = defence;
		this.family = family;
		this.energy = energy;
		
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
	
	public void setEnergy(Integer energy) {
		this.energy = energy;
	}
	
	public Integer getEnergy() {
		return energy;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	
	public String getFamily() {
		return family;
	}
	
	@Override
	public String toString() {
		return "Carte ["+getId()+"]: name:"+getName()+", family:"+getFamily() +", hp:"+getHp()+", imgUrl:"+getImgUrl() + ", attack:"+getAttack() + ", defence:" +getDefence() +", energy:"+getEnergy();
	}

} 