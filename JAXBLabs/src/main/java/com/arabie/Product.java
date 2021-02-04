package com.arabie;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@XmlRootElement(name = "MyProduct")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id","name","price","manufacturerName","addressList"})
public class Product {
    @XmlElement(name = "ProductID")
    private int id;
    private double price;
    private String name;
    @XmlTransient
    private String productionDate;
    private String manufacturerName;
    @XmlElement(name = "Addresses")
    private List<Address> addressList=new ArrayList<>();

    public Product() {
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public Product(int id, double price, String name, String productionDate, String manufacturerName) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturerName = manufacturerName;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +"\t"+
                ", price=" + price +"\t"+
                ", name='" + name + '\'' +"\t"+
                ", productionDate='" + productionDate + '\'' +"\t"+
                ", manufacturerName='" + manufacturerName + '\'' +"\n"+
                ", addressList=" + addressList +
                '}';
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }
}
