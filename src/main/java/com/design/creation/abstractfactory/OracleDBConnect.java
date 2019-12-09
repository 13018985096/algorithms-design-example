package com.design.creation.abstractfactory;

public class OracleDBConnect implements DBConnect
{
    public void connect() {
        System.out.println("ORACLE CREATE INSTANCE");
    }
}
