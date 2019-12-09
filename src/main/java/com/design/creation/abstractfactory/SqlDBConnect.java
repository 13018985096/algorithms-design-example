package com.design.creation.abstractfactory;

public class SqlDBConnect implements DBConnect {
    public void connect() {
        System.out.println("SQLCONNECT CREATE INSTALL");
    }
}
