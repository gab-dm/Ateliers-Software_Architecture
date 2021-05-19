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
		
		card = new Card( "tiplouf" ,  100,  "titiit!",  "url",  15,  15);
		cService.addCard(card);
		
		card = new Card( "ratata" ,  100,  "ratatat!",  "url",  15,  10);
		cService.addCard(card);
		
		card = new Card( "bulbizar" ,  100,  "bulbi bulbi!",  "url",  10,  10);
		cService.addCard(card);
		
		card = new Card( "dracaufeu" ,  100,  "draaa!",  "url",  10,  10);
		cService.addCard(card);
		
		card = new Card( "carapuce" ,  100,  "cara!",  "url",  10,  10);
		cService.addCard(card);
		
		card = new Card( "chenipan" ,  100,  "cheniii",  "url",  10,  10);
		cService.addCard(card);
		
		card = new Card( "florizar" ,  100,  "flori",  "url",  10,  10);
		cService.addCard(card);
	}
}
