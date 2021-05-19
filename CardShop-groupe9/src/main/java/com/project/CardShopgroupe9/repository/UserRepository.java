package com.project.CardShopgroupe9.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.project.CardShopgroupe9.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	Optional<User> EMPTY = null;
	public Optional<User> findById(Integer id);
	public Optional<User> findByName(String name);
	
}
