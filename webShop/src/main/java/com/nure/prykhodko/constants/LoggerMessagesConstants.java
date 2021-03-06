package com.nure.prykhodko.constants;

public abstract class LoggerMessagesConstants {

    //Connection constants
    public static final String ERR_CANNOT_OBTAIN_CONNECTION = "Cannot obtain a connection from the pool";
    public static final String ERR_CANNOT_CLOSE_CONNECTION = "Cannot close a connection from the pool";
    public static final String ERR_CANNOT_CLOSE_ROLLBACK = "Cannot rollback";
    public static final String ERR_CANNOT_CREATE_DATASOURCE = "Cannot create data source";
    public static final String ERR_CAN_NOT_TO_PERFORM_TRANSACTION = "can not to perform transaction";
    public static final String ERR_CANNOT_PERFORM_OPERATION = "cannot perform operation";

    //DAO exceptions
    public static final String ERR_CANNOT_ADD_USER = "Cannot add user";
    public static final String ERR_CANNOT_GET_ALL_USERS = "Cannot get all users";
    public static final String ERR_CANNOT_GET_ALL_PRODUCTS = "Cannot get all products";
    public static final String ERR_CANNOT_GET_USER_BY_ID = "Cannot get user by id";
    public static final String ERR_CANNOT_DELETE_USER_BY_LOGIN = "Cannot delete user by login";
    public static final String ERR_CANNOT_GET_PRODUCT_BY_ID = "Cannot get product by id";
    public static final String ERR_CANNOT_GET_PRODUCT_BY_DEFINE_PARAMETER = "Cannot get product by define parameter";
    public static final String ERR_CANNOT_GET_PRODUCT_BY_FILTERS = "Cannot get product by filters";

    //Filter messages
    public static final String INFO_LOGOUT_FILTER_INIT = "Log out filter init";
    public static final String INFO_LOGOUT_FILTER_DESTROY = "Log out filter destroy";
    public static final String INFO_CACHE_FILTER_INIT = "Cache filter init";
    public static final String INFO_CACHE_FILTER_DESTROY = "Cache filter destroy";
    public static final String INFO_GZIP_FILTER_INIT = "GZip filter init";
    public static final String INFO_GZIP_FILTER_DESTROY = "GZip filter destroy";
    public static final String INFO_LOCALE_FILTER_INIT = "Locale filter init";
    public static final String INFO_LOCALE_FILTER_DESTROY = "Locale filter destroy";


    //ImageDraw exception
    public static final String ERR_CANNOT_DRAW_AVATAR = "Cannot draw avatar";

    //File exception
    public static final String ERR_CANNOT_LOAD_FILE = "Cannot load file";

    //OrderDAOImpl
    public static final String ERR_CANNOT_ADD_ORDER = "Cannot add order";
    public static final String ERR_CANNOT_MAKE_ORDER = "Cannot make order";
    public static final String ERR_CANNOT_ADD_ORDERED_PRODUCT = "Cannot add ordered product";

    //Wrapper constants
    public static final String CANNOT_FLUSH_OUTPUT_STREAM = "Cannot flush output stream";
    public static final String CANNOT_FLUSH_BUFFER = "Cannot flush buffer";
    public static final String CANNOT_GET_OUTPUT_STREAM = "PrintWriter obtained already - cannot get OutputStream";
    public static final String CANNOT_GET_PRINT_WRITER = "OutputStream obtained already - cannot get PrintWriter";

    //Security constants
    public static final String ERR_INCORRECT_CONFIGURATION = "Incorrect configuration";
    public static final String ERR_INCORRECT_FILE_PATH = "Incorrect file path";
    public static final String ERR_CANNOT_PARSE_FILE = "Cannot parse file";
    public static final String INFO_SECURITY_FILTER_DESTROY = "Security file destroy";
    public static final String INFO_SECURITY_FILTER_INIT = "Security file init";
}
