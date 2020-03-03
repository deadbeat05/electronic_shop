package com.epam.prykhodko.constants;

public abstract class ExceptionConstants {

    //Connection constants
    public static final String ERR_CANNOT_OBTAIN_CONNECTION = "Cannot obtain a connection from the pool";
    public static final String ERR_CANNOT_CLOSE_CONNECTION = "Cannot close a connection from the pool";
    public static final String ERR_CANNOT_CLOSE_STATEMENT = "Cannot close a statement";
    public static final String ERR_CANNOT_CLOSE_RESULT_SET = "Cannot close a result set";
    public static final String ERR_CANNOT_CLOSE_ROLLBACK = "Cannot rollback";

    //DAO exceptions
    public static final String ERR_CANNOT_ADD_USER = "Cannot add user";
    public static final String ERR_CANNOT_GET_ALL_USERS = "Cannot get all users";
    public static final String ERR_CANNOT_GET_USER_BY_ID = "Cannot get user by id";
}
