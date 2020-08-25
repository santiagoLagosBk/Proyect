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
    private static final String COMPARE="<>/'?¡¿|/*-_=()@";

    public String getMessage() {
        return message;
    }

    final private String message="sorry you cannot to write symbols as: <>@/?¡¿|/*-_=()";

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

    /*
    This method is available for validation classes inputs as
    data Category
    data Supplier
    data of products
    data user

     */
    public boolean searchInput(String input){



       for (int i=0;i<input.length();i++){

        for (int j=0;j<COMPARE.length();j++){

            if (COMPARE.charAt(j)==input.charAt(i)){

                return true;
            }
        }
    }
        return false;
}
}