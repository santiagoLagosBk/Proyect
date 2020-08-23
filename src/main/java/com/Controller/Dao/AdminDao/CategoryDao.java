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
             final  String sqlListCategories = "SELECT * from catego";
            ps = con.prepareStatement(sqlListCategories);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Category category = new Category();
                category.setIdCategory(rs.getInt("id_Catego"));
                category.setNameCategory(rs.getString("name_catego"));

                listCategories.add(category);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return listCategories;
    }



    @Override
    public boolean editCategory(Connection con, Category category) {

        PreparedStatement ps;

        try {
            final String sqlUpdate = "UPDATE catego SET  name_catego=? WHERE id_Catego=?";
            ps = con.prepareStatement(sqlUpdate);
            ps.setString(1,category.getNameCategory());
            ps.setInt(2, category.getIdCategory());
            if(ps.executeUpdate()!=0){
                return  true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteCategory(Connection con, Category category) {
        return false;
    }





    @Override
    public List<Category> getCategoryFeatures(List<Category> list,int search) {

        List<Category> listFeatures =new ArrayList<>();

        for (Category category:list){

            if (category.getIdCategory()==search){

                listFeatures.add(category);
            }
        }


        return listFeatures;
    }
}
