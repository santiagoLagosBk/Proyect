package com.Controller.Dao;

import com.Model.User;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UserDao implements InterfaceUserDao{



    @Override
    public boolean login(Connection con, User user)  {

        PreparedStatement ps;



            String sqlLogin = "SELECT * FROM usuario u JOIN usuario_has_rol h ON " +
                    "u.idusuario = h.usuario_idusuario JOIN rol r ON h.rol_id_rol = r.id_rol " +
                    "where u.nick=? and u.password=? and r.name_role=? and u.active=?";

        try {
            ps = con.prepareStatement(sqlLogin);

            ps.setString(1, user.getNickName());
            ps.setString(2, user.getPassword());
            ps.setString(3,user.getTypeRol());
            ps.setBoolean(4, user.isActive());

            ResultSet rs= ps.executeQuery();


            while (rs.next()){

                user.setIdUser(rs.getInt("u.idusuario"));
                user.setAllName(rs.getString("u.allName"));
                user.setAllLastName(rs.getString("u.lastname"));
                user.setTypeRol(rs.getString("r.name_role"));
                user.setActive(rs.getBoolean("u.active"));

                return true;
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();


        }

        return false;
    }

    @Override
    public String getDate() {

        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-dd-mm hh:mm:ss");
        Date date= Calendar.getInstance().getTime();

        return dateFormat.format(date);
    }

    @Override
    public void uploadDateLogin(Connection connection, User user) {


        PreparedStatement ps;

        try {
            String sqlUpdateDate = "update usuario set lastlogin=? where idusuario=?";
            ps= connection.prepareStatement(sqlUpdateDate);
            ps.setString(1,user.getLastLogin());
            ps.setInt(2,user.getIdUser());

            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
