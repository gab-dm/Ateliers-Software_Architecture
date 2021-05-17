package com.project.CardShopgroupe9.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.CardShopgroupe9.model.Session;
import com.project.CardShopgroupe9.model.User;
import com.project.CardShopgroupe9.repository.SessionRepository;
import com.project.CardShopgroupe9.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;
import java.util.UUID;

@Service
public class SessionService {

	@Autowired
	UserRepository uRepository;
	@Autowired
	SessionRepository sRepository;
    /**
     * Methode de vérification d'un token
     * Test si le token est dans la BDD et l'adresse IP passée correspond
     * @param token
     * @param request
     * @return user
     */
    public User isLogged (String token, HttpServletRequest request){
        String IP = this.getIP(request);
        Optional<Session> session = sRepository.findByTokenAndIp(token, IP);
        
        if (session != null){ // si le token et l'ip correspondent
            User user = uRepository.findById(session.get().getIdUser()).get();
            return user;
        }else{
            return null;
        }
    }

    /**
     * Méthode de récupération de l'adresse Ip d'un client
     * @param request
     * @return String Ip
     */
    public String getIP(HttpServletRequest request){
        String ip = request.getRemoteAddr();
        if(ip.equalsIgnoreCase("0:0:0:0:0:0:0:1")){
            try { ip= InetAddress.getLocalHost().getHostAddress(); }
            catch (UnknownHostException ignored) {  }
        }
        return ip;
    }


    /**
     * Création d'une nouvelle session utilisateur
     * @param user
     * @param request
     * @return
     */
    public Session setSession(User user, HttpServletRequest request){
        //Création d'une session avec la génération d'un token aléatoire
        Session session = new Session(user.getId(), UUID.randomUUID().toString().replace("-", ""), this.getIP(request));
        Session exist = sRepository.findByIdUser(user.getId()).get();
        if(exist != null){
        	sRepository.deleteById(exist.getId());
        }
        sRepository.save(session);
        return session;
    }
}
