package com.arabie;

import javax.json.bind.annotation.JsonbNillable;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTransient;
import java.util.ArrayList;
import java.util.List;

@JsonbNillable
@JsonbPropertyOrder({"id","name","address","dateOfBirth"})
public class User {
    private int id;
    private String name;
    private List<String> address=new ArrayList<>();
    @JsonbTransient
    private String password;
    private String dateOfBirth;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", password='" + password + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public User() {
    }

    public User(int id, String name, String password, String dateOfBirth) {
        this.id = id;
        this.name = name;

        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }
}
