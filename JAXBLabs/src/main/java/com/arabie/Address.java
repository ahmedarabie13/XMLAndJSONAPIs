package com.arabie;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
    private int id;
    private String city;
    private String country;

    public Address(int id, String city, String country) {
        this.id = id;
        this.city = city;
        this.country = country;
    }

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +"\t"+
                ", city='" + city + '\'' +"\t"+
                ", country='" + country + '\'' +"\t"+
                '}'+"\n";
    }
}
