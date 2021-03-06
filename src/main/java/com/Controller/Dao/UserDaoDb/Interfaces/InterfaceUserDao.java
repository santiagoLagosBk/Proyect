package com.Controller.Dao.UserDaoDb.Interfaces;

import com.Model.Supplier;
import com.Model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface InterfaceUserDao {


    boolean login(Connection con, User user) throws SQLException;

    Timestamp getDate();

    void uploadDateLogin(Connection connection,User user);


    ArrayList<User> getActiveAndInactiveUsersList(Connection con,byte choice);

    /*
        edit user employee allow us change only selected features
        as email and nick name
     */
    boolean editMyUserEmployee(Connection con, User user);

    /*
        edit User admin allow us change everything the Admin Wants
     */
    int editUserAdmin(Connection connection, String password,String name,String lastName,String email, int idUser);


    boolean registerUser(Connection connection,User user);

    void deleteRole(Connection connection,int idUser);

    boolean addRole(Connection connection, String[] role,int idUser);

    List<User> getUserFeatures(ArrayList<User>list, int search);
}
