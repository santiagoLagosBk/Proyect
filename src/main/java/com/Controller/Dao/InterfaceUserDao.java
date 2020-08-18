package com.Controller.Dao;

import com.Model.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface InterfaceUserDao {


    boolean login(Connection con, User user) throws SQLException;
}
