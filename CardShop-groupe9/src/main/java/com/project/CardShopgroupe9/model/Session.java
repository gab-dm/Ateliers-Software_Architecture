package com.project.CardShopgroupe9.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Session")
@Table(name="Sessions")


public class Session {
    @Id @GeneratedValue
    private int id;
    private int idUser;
    private String token;
    private String ip;

    public Session() {
    }

    /**
     * Création d'un objet Session
     * @param idUser
     * @param token
     * @param ip
     */
    public Session(int idUser, String token, String ip) {
        this.idUser=idUser;
        this.token = token;
        this.ip=ip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String toJson() {
        return "{" +
                "\"idUser\":" + idUser +
                ", \"token\":\"" + token + '\"' +
                '}';
    }
}
