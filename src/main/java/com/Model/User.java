package com.Model;

import java.util.Date;

public abstract class  User {

    private int idUser;
    private String AllName;
    private String AllLastName;
    private String password;
    private String lastLogin;
    private String nickName;
    private String typeRol;
    private boolean active;


    public User(int idUser, String allName, String allLastName,
                String password, String lastLogin, String nickName,
                String typeRol, boolean active) {

        this.idUser = idUser;
        AllName = allName;
        AllLastName = allLastName;
        this.password = password;
        this.lastLogin = lastLogin;
        this.nickName = nickName;
        this.typeRol = typeRol;
        this.active = active;
    }

    public User(){}

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getAllName() {
        return AllName;
    }

    public void setAllName(String allName) {
        AllName = allName;
    }

    public String getAllLastName() {
        return AllLastName;
    }

    public void setAllLastName(String allLastName) {
        AllLastName = allLastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTypeRol() {
        return typeRol;
    }

    public void setTypeRol(String typeRol) {
        this.typeRol = typeRol;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}