package com.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private static String USERNAME="user";
    private static String PASSWORD="123";
    private static final String URL="jdbc:mysql://localhost:3306/inverfra?useTimezone=true&serverTimezone=UTC";



    public static Connection getConnectionDb(){

            Connection con=null;

        try{

            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);

        }catch (SQLException e){

            e.printStackTrace();
        }

        return con;

    }



}
