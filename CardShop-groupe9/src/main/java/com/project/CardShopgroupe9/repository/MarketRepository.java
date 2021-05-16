package com.project.CardShopgroupe9.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.CardShopgroupe9.model.Card;
import com.project.CardShopgroupe9.model.Market;
import com.project.CardShopgroupe9.model.Session;

public interface MarketRepository extends CrudRepository<Market, Integer>{
	
	public List<Market> findAll();
}
