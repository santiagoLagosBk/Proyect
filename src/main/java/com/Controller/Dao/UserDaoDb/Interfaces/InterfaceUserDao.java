package com.Controller.Dao.UserDaoDb.Interfaces;

import com.Model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public interface InterfaceUserDao {


    boolean login(Connection con, User user) throws SQLException;

    String getDate();

    void uploadDateLogin(Connection connection,User user);
}
