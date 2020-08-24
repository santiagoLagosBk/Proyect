package com.Controller.Dao.AdminDao.Interfaces;

import com.Model.Category;
import com.Model.Supplier;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public interface InterfaceSupplierDao {

    ArrayList<? extends Object> getSupplier(Connection con);

    boolean editSupplier(Connection con, Supplier supplier);

    boolean deleteSupplier(Connection con, Supplier supplier);

    boolean addSupplier(Connection connection,Supplier supplier);

    List<? extends Object> getSupplierFeatures(List<Supplier>list, int search);

}
