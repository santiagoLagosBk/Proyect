package com.Model;

import java.sql.Timestamp;
import java.util.Date;

public abstract class  User {

    private int idUser;
    private String AllName;
    private String AllLastName;
    private String password;
    private Timestamp lastLogin;
    private String nickName;
    private String document;
    private String email;
    private String typeRol;

    private byte active;
    private static final String COMPARE="<>/'?¡¿|/*-_=()@";
    final int RANG =4;

    public String getMessage() {
        return message;
    }

    final private String message="sorry, but you cannot to write symbols as: <>@/?¡¿|/*-_=() and min of \n" +
            "characters is 5";

    public User(int idUser, String allName, String allLastName, String password, Timestamp lastLogin, String nickName, String document, String email, String typeRol, byte active) {
        this.idUser = idUser;
        AllName = allName;
        AllLastName = allLastName;
        this.password = password;
        this.lastLogin = lastLogin;
        this.nickName = nickName;
        this.document = document;
        this.email = email;
        this.typeRol = typeRol;
        this.active = active;
    }

    public User(){}

    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
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



    /*
    This method is available for validation classes inputs as
    data Category
    data Supplier
    data of products
    data user

     */
    public boolean searchInput(String input){


        if (input.length()<=RANG){

            return true;
        }else {
       for (int i=0;i<input.length();i++) {

           for (int j = 0; j < COMPARE.length(); j++) {

               if (COMPARE.charAt(j) == input.charAt(i)) {

                   return true;
               }
           }
       }
    }
        return false;
}
}