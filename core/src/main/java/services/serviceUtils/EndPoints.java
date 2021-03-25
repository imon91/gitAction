package services.serviceUtils;

public class EndPoints {

    public static final String CHECKOUT = "checkout/";
    public static final String BAG = "bag/";
    public static final String CATEGORY_MEN_CLOTHING = "men-clothing/";
    public static final String SUB_CATEGORY_MEN_SHIRTS_JSON = "men-shirts.json";
    public static final String COLLECTIONS_JSON = "collections.json";
    public static final String SEARCH_FOR_USER = "search_terms/search_for_user.json?";
    public static final String RECOMMENDATIONS = "recommendations/";
    public static final String LOGGED_IN_USER_DATA_JSON = "loggedin_user_data.json";
    public static final String APP_PREFERENCES = "app_preferences/";
    public static final String SHOPPING_CART_JSON = "shopping_cart.json";
    public static final String SHOPPING_CART = "shopping_cart/";
    public static final String LOCALITY_DATA_JSON = "get_locality_data.json";
    public static final String ADD_TO_CART_JSON = "/add_to_cart.json";
    public static final String ORDER_CHECKOUT_JSON = "order_checkout.json";
    public static final String COMMERCE_SEND_USER_OTP = "users/send_user_otp.json";
    public static final String COMMERCE_VERIFY_OTP = "users/sign_up_user.json";

    /*-RedX-*/
    public static final String VERSION1 = "v1";
    public static final String VERSION2 = "v2";
    public static final String ADMIN = "/admin";
    public static final String LOGISTICS = "/logistics";
    public static final String SHOP = "/shop/";
    public static final String PAYMENT = "/payment";
    public static final String BANKS = "/banks/";
    public static final String BRANCHES = "/branches";
    public static final String PRICING = "/pricing";

    public class WMS{
        public static final String USER_SIGN_IN = "users/sign_in.json";
        public static final String WAREHOUSES_JSON = "warehouses.json";
    }

    public class Store{
        public static final String SEND_OTP = "api/send_otp.json";
        public static final String LOGIN = "api/login.json";
    }

    public class Sap{
        public static final String LOGIN_WITH_CODE = "user/login-with-code";
        public static final String REQUEST_LOGIN_CODE = "user/request-login-code";
    }

    public class RedX{
        public static final String SEND_OTP = "user/login-with-code";
        public static final String LOGIN = "user/request-login-code";
    }


}
