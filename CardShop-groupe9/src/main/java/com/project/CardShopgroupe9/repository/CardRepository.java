/**
 * 
 */
package com.project.CardShopgroupe9.repository;

import com.project.CardShopgroupe9.model.Card;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;


public interface CardRepository extends CrudRepository<Card, Integer> {
	
	public Optional<Card> findById(int id);
	public List<Card> findAll();
}
