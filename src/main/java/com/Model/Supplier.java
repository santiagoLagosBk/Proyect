package com.Model;

public class Supplier {

    private int idSupplier;
    private String nameSupplier;


    public Supplier(){}

    public Supplier(int idSupplier, String nameSupplier) {
        this.idSupplier = idSupplier;
        this.nameSupplier = nameSupplier;
    }



    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }
}
