package com.Controller.Dao.UserDaoDb;

import com.Controller.Dao.UserDaoDb.Interfaces.InterfaceUserDao;
import com.Model.Employee;
import com.Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UserDao implements InterfaceUserDao {



    @Override
    public boolean login(Connection con, User user)  {

        PreparedStatement ps;



            String sqlLogin = "SELECT * FROM user u JOIN user_has_role h ON " +
                    "u.id_user = h.fk_id_user JOIN roles r ON h.fk_id_role = r.id_rol " +
                    "where u.nick_name=? and u.password=? and r.role_name=? and u.active=?";

        try {
            ps = con.prepareStatement(sqlLogin);

            ps.setString(1, user.getNickName());
            ps.setString(2, user.getPassword());
            ps.setString(3,user.getTypeRol());
            ps.setByte(4, user.getActive());

            ResultSet rs= ps.executeQuery();

            while (rs.next()){

                user.setIdUser(rs.getInt("u.id_user"));
                user.setAllName(rs.getString("u.name_user"));
                user.setAllLastName(rs.getString("u.last_name"));
                user.setTypeRol(rs.getString("r.role_name"));
                user.setActive(rs.getByte("u.active"));
                user.setDocument(rs.getString("identification_doc"));

                return true;
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();


        }

        return false;
    }

    //  Get current Time
    @Override
    public Timestamp getDate() {

        java.util.Date currentTime = Calendar.getInstance().getTime();

        long time = currentTime.getTime();
        return new Timestamp(time);
    }

    //  Update date current Login with Db
    @Override
    public void uploadDateLogin(Connection connection, User user) {


        PreparedStatement ps;

        try {
            String sqlUpdateDate = "update user set update_login=?  where id_user=?";
            ps= connection.prepareStatement(sqlUpdateDate);
            ps.setTimestamp(1,user.getLastLogin());
            ps.setInt(2,user.getIdUser());

            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    // get enable or disable users to restrict the access for the page
    @Override
    public ArrayList<User> getActiveAndInactiveUsersList(Connection con,byte choice) {


        ArrayList<User> userArrayList = new ArrayList<>();
        PreparedStatement ps;
        final String sqlGetListUsers = "SELECT * FROM user u  WHERE u.active=?";

        try {
            ps = con.prepareStatement(sqlGetListUsers);
            ps.setByte(1,choice);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                User user = new Employee();


                user.setIdUser(rs.getInt("u.id_user"));
                user.setAllName(rs.getString("u.name_user"));
                user.setAllLastName(rs.getString("u.last_name"));
                user.setActive(rs.getByte("u.active"));
                user.setDocument(rs.getString("u.identification_doc"));
                user.setLastLogin(rs.getTimestamp("u.update_login"));
                user.setEmail(rs.getString("u.email"));
                user.setPassword(rs.getString("password"));
                user.setNickName(rs.getString("u.nick_name"));

                userArrayList.add(user);

            }



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return userArrayList;
    }

    @Override
    public boolean editMyUserEmployee(Connection con, User user) {



        return false;
    }


    //  change the status of the access for the page
    public boolean turnOffAndOnUser(Connection connection,int id,Byte active){

        PreparedStatement ps;
        try {
            final String sqlTurnOff = "UPDATE user SET active=? WHERE id_user=?";
            ps = connection.prepareStatement(sqlTurnOff);
            ps.setByte(1,active);
            ps.setInt(2,id);

            while (ps.executeUpdate()!=0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
            return false;

    }




    @Override
    public boolean editUserAdmin(Connection connection, User user) {




        return false;
    }



    @Override
    public boolean deleteUser(Connection con, User user) {
        return false;
    }



    @Override
    public List<User> getUserFeatures(ArrayList<User> list, int search) {

        List<User> userList = new ArrayList<>();


        for (User user:list){

            if (user.getIdUser()==search){

                userList.add(user);
            }
        }
        
        return userList;
    }


    public List<String>listRole(Connection con,int search){

        List<String>listRole= new ArrayList<>();
        final String sqlRole = "SELECT r.role_name  from roles r JOIN user_has_role uhr on r.id_rol = uhr.fk_id_role " +
                "JOIN user u on u.id_user = uhr.fk_id_user where u.id_user=?";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sqlRole);
            ps.setInt(1,search);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                listRole.add(rs.getString("r.role_name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listRole;
    }

}
