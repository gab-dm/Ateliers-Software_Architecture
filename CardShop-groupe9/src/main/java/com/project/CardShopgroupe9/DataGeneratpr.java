package com.project.CardShopgroupe9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.project.CardShopgroupe9.model.Card;
import com.project.CardShopgroupe9.service.CardService;

@Component
public class DataGeneratpr implements ApplicationRunner {
	@Autowired
	CardService cService;
	public void run(ApplicationArguments args) throws Exception {
		Card card = new Card( "Pikachu" ,  100,  "Pika chuuuu!",  "url",  10,  10);
		cService.addCard(card);
	}
}
