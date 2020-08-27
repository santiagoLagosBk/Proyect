package com.Model;

import java.sql.Timestamp;
import java.util.Date;

public class Admin extends User{


    @Override
    public int getIdUser() {
        return super.getIdUser();
    }

    @Override
    public void setIdUser(int idUser) {
        super.setIdUser(idUser);
    }

    @Override
    public String getAllName() {
        return super.getAllName();
    }

    @Override
    public void setAllName(String allName) {
        super.setAllName(allName);
    }

    @Override
    public String getAllLastName() {
        return super.getAllLastName();
    }

    @Override
    public void setAllLastName(String allLastName) {
        super.setAllLastName(allLastName);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public Timestamp getLastLogin() {
        return super.getLastLogin();
    }

    @Override
    public void setLastLogin(Timestamp lastLogin) {
        super.setLastLogin(lastLogin);
    }

    @Override
    public String getNickName() {
        return super.getNickName();
    }

    @Override
    public void setNickName(String nickName) {
        super.setNickName(nickName);
    }

    @Override
    public String getTypeRol() {
        return super.getTypeRol();
    }

    @Override
    public void setTypeRol(String typeRol) {
        super.setTypeRol(typeRol);
    }

    @Override
    public byte getActive() {
        return super.getActive();
    }

    @Override
    public void setActive(byte active) {
        super.setActive(active);
    }
}
