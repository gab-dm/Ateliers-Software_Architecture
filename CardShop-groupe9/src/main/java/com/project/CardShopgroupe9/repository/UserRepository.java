package com.project.CardShopgroupe9.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.project.CardShopgroupe9.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public Optional<User> findById(int id);
	public Optional<User> findByName(String name);

}
