/**
 * 
 */
package com.project.CardShopgroupe9.repository;

import com.project.CardShopgroupe9.model.Card;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * @author g.de-monteynard
 *
 */
public interface CardRepository extends CrudRepository<Card, Integer> {
	
	public List<Card> findByName(String name);
}
