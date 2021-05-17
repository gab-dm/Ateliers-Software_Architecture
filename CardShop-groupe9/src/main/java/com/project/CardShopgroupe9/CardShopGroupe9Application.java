package com.project.CardShopgroupe9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.CardShopgroupe9.service.CardService;

@SpringBootApplication
public class CardShopGroupe9Application {
	
	@Autowired
	CardService cService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CardShopGroupe9Application.class, args);
	}

}
