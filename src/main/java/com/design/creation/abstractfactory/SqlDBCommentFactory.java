package com.design.creation.abstractfactory;

public class SqlDBCommentFactory implements DBCommentFactory {

    public DBConnect createConnect() {
        return new SqlDBConnect();
    }

    public DBReader createReader() {
        return new SqlDBReader();
    }
}
