package com.epam.prykhodko.constants;

public abstract class ApplicationConstants {

    //Form strings
    public static final String USER_PERSONAL_DATA_REGEX = "^\\w+";
    public static final String LOGIN_REGEX = "^\\w{3,16}$";
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z]+)*$";
    public static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*])[\\w!@#$%^&*]{8,}$";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String CO_PASSWORD = "confirmPassword";
    public static final String LOGIN = "login";
    public static final String USER_LOGIN = "userLogin";
    public static final String POLICY = "privacy-policy";
    public static final String MAILS = "mails";
    public static final String REG_CAPTCHA = "regCaptcha";
    public static final String ROLE_ID = "role_id";
    public static final String AVATAR = "avatar";

    //Captcha strings
    public static final String CAPTCHA = "captcha";
    public static final String CAPTCHA_KEY = "captchaKey";
    public static final String CAPTCHA_KEYS = "captchaKeys";
    public static final String CAPTCHA_VALUE = "captchaValue";
    public static final String CAPTCHA_TIME = "captchaTime";
    public static final String CAPTCHA_KEEPER = "captcha keeper";

    //User strings
    public static final String USER_DATA = "userData";

    //Erorrs strings
    public static final String USER_LOGIN_EXISTS = "User with this login is exists";
    public static final String USER_EMAIL_EXISTS = "User with this email is exists";
    public static final String INCORRECT_INPUT = "Incorrect input of ";
    public static final String YOU_DONT_CHOOSE = "You don't choose ";
    public static final String INCORRECT_CAPTCHA = "Incorrect captcha";

    //Other strings
    public static final String SESSION = "session";
    public static final String COOKIE = "cookie";
    public static final String HIDDEN_FIELD = "hiddenField";
    public static final String KEEPERS = "keepers";
    public static final String ERRORS = "errors";
    public static final String VALIDATOR = "validator";
    public static final String USER_UTILS = "user utils";
    public static final String REG_FORM = "regFormBean";
    public static final String USER_SERVICE = "userService";
    public static final String PRODUCT_SERVICE = "productService";
    public static final String ALL_PRODUCT_LIST = "all_product_list";
    public static final String AMOUNT_OF_PRODUCTS = "amountOfProducts";
    public static final String IMAGE_DRAW = "imageDraw";
    public static final String AVATARS_PATH = "src\\main\\webapp\\images\\avatars\\";
    public static final String JPG_FORMAT = ".jpg";
    public static final String TEMPORARY_STORAGE = "javax.servlet.context.tempdir";
    public static final String CONTEXT_DESTROYER = "context destroyer";
    public static final String HIDDEN = "hidden";
    public static final String CONNECTION_MANAGER = "connection manager";
    public static final String NOT_USER_ERROR = "Try again";

    //URL path
    public static final String HOME_URL = "/";

    //JSP link
    public static final String PRODUCT_JSP = "jsp/products.jsp";
    public static final String REGISTRATION_JSP_LINK = "jsp/registration.jsp";
    public static final String LOGIN_JSP_LINK = "jsp/logIn.jsp";

    //Product parameters
    public static final String MANUFACTURE = "manufacture";
    public static final String CATEGORY = "category";
    public static final String PRICE = "price";
    public static final String DESCRIPTION = "description";

    //Filter form
    public static final String MIN_PRICE = "minPrice";
    public static final String MAX_PRICE = "maxPrice";
    public static final String SORT = "sort";

    //Product page constants
    public static final String STRING_ONE_MILLION = "1000000";

    //Product page request constants
    public static final String FILTERS = "filters";
    public static final String FILTER_QUERY = "FILTER_QUERY";
    public static final String PAGE = "page";
    public static final String AMOUNT_OF_PRODUCTS_FROM_FORM = "amountOfProductsFromForm";
    public static final String DEFAULT_PRODUCTS_ON_PAGE = "defaultProductsOnPage";
    public static final String MANUFACTURES = "manufactures";
    public static final String CATEGORIES = "categories";
    public static final String BY_PRICE_FROM_LOW = "byPriceFromLow";
    public static final String BY_PRICE_FROM_HIGH = "byPriceFromHigh";
    public static final String BY_ALPHABETICAL_FROM_A_Z = "byAlphabeticalFromA-Z";
    public static final String BY_ALPHABETICAL_FROM_Z_A = "byAlphabeticalFromZ-A";

    //Cart constants
    public static final String CART = "cart";
    public static final String PRODUCT_ID = "productId";
    public static final String SUCCESS = "success";
    public static final String AMOUNT = "amount";

}
