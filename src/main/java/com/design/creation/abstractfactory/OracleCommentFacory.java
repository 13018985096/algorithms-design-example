package com.design.creation.abstractfactory;

public class OracleCommentFacory implements DBCommentFactory {

    public DBConnect createConnect() {
        return new OracleDBConnect();
    }

    public DBReader createReader() {
        return new OracleDBReader();
    }
}
