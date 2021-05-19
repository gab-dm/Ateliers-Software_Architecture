package com.project.CardShopgroupe9.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.project.CardShopgroupe9.model.Card;
import com.project.CardShopgroupe9.model.Market;
import com.project.CardShopgroupe9.model.Session;
import com.project.CardShopgroupe9.model.User;

public interface MarketRepository extends CrudRepository<Market, Integer>{
	
	public List<Market> findAll();
	public Optional<Market> findById(Integer id);
}
