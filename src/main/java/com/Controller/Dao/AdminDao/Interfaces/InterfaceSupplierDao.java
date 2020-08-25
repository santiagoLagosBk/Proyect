package com.Controller.Dao.AdminDao.Interfaces;

import com.Model.Supplier;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public interface InterfaceSupplierDao {

    ArrayList<Supplier> getSupplierList(Connection con);

    boolean editSupplier(Connection con, Supplier supplier);

    boolean deleteSupplier(Connection con, Supplier supplier);

    boolean addSupplier(Connection connection,Supplier supplier);

    List<Supplier> getSupplierFeatures(ArrayList<Supplier>list, int search);

}
