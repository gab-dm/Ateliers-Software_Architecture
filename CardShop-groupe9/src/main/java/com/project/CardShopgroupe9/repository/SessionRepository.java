package com.project.CardShopgroupe9.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.project.CardShopgroupe9.model.Session;

public interface SessionRepository extends CrudRepository<Session, Integer> {

	public  Optional<Session> findByTokenAndIp(String Token, String Ip);
	public  Optional<Session> findByIdUser(int id);

}
