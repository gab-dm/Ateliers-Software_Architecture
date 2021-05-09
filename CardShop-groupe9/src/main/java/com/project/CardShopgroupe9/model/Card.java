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
private String effect;
private String imgUrl;
	
	public Card ( String _name , Integer _hp, String effect, String imgUrl ) {
		
		super();
		this.name = _name;
		this.hp = _hp;
		this.effect = effect ;
		this.imgUrl = imgUrl; 
		
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

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	@Override
	public String toString() {
		return "Carte ["+this.id+"]: name:"+this.name+", effet:"+this.effect +", hp:"+this.hp+" imgUrl:"+this.imgUrl;
	}

}
