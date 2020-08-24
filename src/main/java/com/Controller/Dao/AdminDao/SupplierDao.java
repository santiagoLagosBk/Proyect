package com.Controller.Dao.AdminDao;

import com.Controller.Dao.AdminDao.Interfaces.InterfaceSupplierDao;
import com.Model.Supplier;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class SupplierDao implements InterfaceSupplierDao {


    @Override
    public ArrayList<? extends Object> getSupplier(Connection con) {
        return null;
    }

    @Override
    public boolean editSupplier(Connection con, Supplier supplier) {
        return false;
    }

    @Override
    public boolean deleteSupplier(Connection con, Supplier supplier) {
        return false;
    }

    @Override
    public boolean addSupplier(Connection connection, Supplier supplier) {
        return false;
    }

    @Override
    public List<? extends Object> getSupplierFeatures(List<Supplier> list, int search) {
        return null;
    }
}
