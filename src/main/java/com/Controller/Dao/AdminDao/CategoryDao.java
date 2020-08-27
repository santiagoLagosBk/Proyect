package com.Controller.Dao.AdminDao;

import com.Controller.Dao.AdminDao.Interfaces.InterfaceCategoryDao;
import com.Model.Category;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

public class CategoryDao implements InterfaceCategoryDao {


    @Override
    public ArrayList<Category> getCategories(Connection con) {


        ArrayList<Category> listCategories= new ArrayList<>();

        PreparedStatement ps;

        try{
             final  String sqlListCategories = "SELECT * from category";
            ps = con.prepareStatement(sqlListCategories);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Category category = new Category();
                category.setIdCategory(rs.getInt("id_category"));
                category.setNameCategory(rs.getString("category_name"));

                listCategories.add(category);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return listCategories;
    }



    @Override
    public boolean editCategory(Connection con, Category category) {


        // first we search a similar data in the database
        if (!CategoryDao.searchCategory(con,category.getNameCategory())) {
            PreparedStatement ps;
            final String sqlUpdate = "UPDATE category SET  category_name=? WHERE id_category=?";
            try {

                ps = con.prepareStatement(sqlUpdate);
                ps.setString(1, category.getNameCategory());
                ps.setInt(2, category.getIdCategory());

                if (ps.executeUpdate() != 0) {
                    return true;
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public boolean deleteCategory(Connection con, Category category) {

        PreparedStatement ps;
        final String sqlDelete = "DELETE FROM category WHERE id_category=?";
        try {
            ps = con.prepareStatement(sqlDelete);
            ps.setInt(1,category.getIdCategory());

            while (ps.executeUpdate()!=0){
                return true;
            }
        }catch (SQLException e ){

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean addCategory(Connection connection, Category category) {


        // first we search a similar data in the database
        if (!CategoryDao.searchCategory(connection,category.getNameCategory())){
            PreparedStatement ps;
            final String sqlInsert = "INSERT INTO category(id_category,category_name) VALUES (null,?)";
            try {

                ps = connection.prepareStatement(sqlInsert);
                ps.setString(1, category.getNameCategory());

                while (ps.executeUpdate() != 0) {

                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

            return false;



    }

    private static boolean searchCategory(Connection connection,String category){

        PreparedStatement ps;
        final String sqlSearh = "SELECT * from category WHERE category_name=?";
        try {
            ps = connection.prepareStatement(sqlSearh);
            ps.setString(1,category);

            ResultSet rs= ps.executeQuery();

            while (rs.next()){
                return true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }





    @Override
    public List<Category> getCategoryFeatures(List<Category> list,int search) {

        List<Category> listFeatures =new ArrayList<>();

        // search of item into cookie
        for (Category category:list){

            if (category.getIdCategory()==search){

                listFeatures.add(category);
            }
        }

        return listFeatures;
    }


}
