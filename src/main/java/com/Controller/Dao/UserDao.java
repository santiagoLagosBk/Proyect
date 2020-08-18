package com.Controller.Dao;

import com.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
                user.setLastLogin(rs.getDate("u.lastlogin"));
                user.setTypeRol(rs.getString("r.name_role"));

                return true;
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();


        }



        return false;
    }
}
