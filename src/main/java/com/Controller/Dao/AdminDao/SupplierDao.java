package com.Controller.Dao.AdminDao;

import com.Controller.Dao.AdminDao.Interfaces.InterfaceSupplierDao;
import com.Model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

public class SupplierDao implements InterfaceSupplierDao {


    @Override
    public ArrayList<Supplier> getSupplierList(Connection con) {


        ArrayList<Supplier> supplierList = new ArrayList<>();

        PreparedStatement ps;

        try {
            final String sqlSuppliers = "SELECT * FROM supplier";
            ps = con.prepareStatement(sqlSuppliers);
            ResultSet rs= ps.executeQuery();

            while (rs.next()){
                Supplier supplier = new Supplier();
                supplier.setIdSupplier(rs.getInt("id_supplier"));
                supplier.setNameSupplier(rs.getString("supplier_name"));
                supplierList.add(supplier);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return supplierList;
    }


    @Override
    public boolean editSupplier(Connection con, Supplier supplier) {


        if (!SupplierDao.searchSupplier(con,supplier.getNameSupplier())){

            PreparedStatement ps;
            final String sqlUpdateSupplier = "UPDATE supplier SET supplier_name=? WHERE id_supplier=?";
            try {

                ps = con.prepareStatement(sqlUpdateSupplier);
                ps.setString(1,supplier.getNameSupplier());
                ps.setInt(2,supplier.getIdSupplier());

                while (ps.executeUpdate()!=0){
                    return true;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public boolean deleteSupplier(Connection con, Supplier supplier) {

        PreparedStatement ps;
        final String sqlDelelte = "DELETE FROM supplier WHERE id_supplier=?";
        try {

            ps = con.prepareStatement(sqlDelelte);
            ps.setInt(1,supplier.getIdSupplier());

            while (ps.executeUpdate()!=0){
                return true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return false;
    }

    @Override
    public boolean addSupplier(Connection connection, Supplier supplier) {

        PreparedStatement ps;
        final String sqlAddSupplier = "INSERT INTO supplier (id_supplier,supplier_name) VALUES(null ,?)";

        if (!SupplierDao.searchSupplier(connection,supplier.getNameSupplier())) {
            try {

                ps = connection.prepareStatement(sqlAddSupplier);
                ps.setString(1, supplier.getNameSupplier());

                while (ps.executeUpdate() != 0) {
                    return true;
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public List<Supplier> getSupplierFeatures(ArrayList<Supplier> list, int search) {

        List<Supplier> supplierList = new ArrayList<>();

        for (Supplier supplier:list){

            if (supplier.getIdSupplier()==search){
                supplierList.add(supplier);
            }
        }
        return supplierList;
    }


    private static boolean searchSupplier(Connection connection,String supplierName){

        PreparedStatement ps;
        final String sqlSearchSimilar = "SELECT * FROM supplier where supplier_name=?";
        try{

            ps = connection.prepareStatement(sqlSearchSimilar);
            ps.setString(1,supplierName);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }



}
