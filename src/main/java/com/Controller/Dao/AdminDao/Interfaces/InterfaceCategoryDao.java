package com.Controller.Dao.AdminDao.Interfaces;

import com.Model.Category;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public interface InterfaceCategoryDao {

     ArrayList<Category> getCategories(Connection con);

     boolean editCategory(Connection con, Category category);

     boolean deleteCategory(Connection con, Category category);

     boolean addCategory(Connection connection,Category category);

     List<Category>getCategoryFeatures(List<Category>list,int search);
}
