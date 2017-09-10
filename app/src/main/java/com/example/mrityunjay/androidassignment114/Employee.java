package com.example.mrityunjay.androidassignment114;

/**
 * Created by Mrityunjay on 08-06-2017.
 */

public class Employee {
    private String Name;
    private  String Last_Name;

    public Employee(String name, String Last_Name) {
        this.Name=name;
        this.Last_Name=Last_Name;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }
}
