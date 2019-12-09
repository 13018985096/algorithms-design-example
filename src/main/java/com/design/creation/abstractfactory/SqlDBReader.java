package com.design.creation.abstractfactory;

public class SqlDBReader implements DBReader {
    public void read() {
        System.out.println("SQL READER CREATE");
    }
}
