package services.responseModels.commerceModels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoggedInUserDataModel {


    /**
     * main_menu : [{"label":"Shop by Category","position":"1"},{"is_category":"true","top":"true","label":"Women Clothing","url":"/collections/women-clothing"},{"is_low_level":"true","label":"Unstitched","url":"/collections/unstitched"},{"is_low_level":"true","label":"Indian Saree","url":"/collections/indian-saree"},{"is_low_level":"true","label":"Deshi Saree","url":"/collections/deshi-saree"},{"is_low_level":"true","label":"Shrugs Jackets","url":"/collections/shrugs-jackets"},{"is_low_level":"true","label":"Semi Stitched","url":"/collections/semi-stitched"},{"is_low_level":"true","label":"Caps","url":"/collections/women-caps"},{"is_low_level":"true","label":"Kurti","url":"/collections/kurti"},{"is_low_level":"true","label":"Shawls","url":"/collections/shawls"},{"is_low_level":"true","label":"Abayas","url":"/collections/abayas"},{"is_low_level":"true","label":"Hijab","url":"/collections/hijab"},{"is_low_level":"true","label":"Stitched","url":"/collections/stitched"},{"is_low_level":"true","label":"Night Dresses Nighties","url":"/collections/night-dresses-nighties"},{"is_low_level":"true","label":"Kurtis","url":"/collections/kurtis"},{"is_low_level":"true","label":"Bras","url":"/collections/bras"},{"is_low_level":"true","label":"Lehengas","url":"/collections/lehengas"},{"is_low_level":"true","label":"Tops","url":"/collections/tops"},{"is_low_level":"true","label":"T Shirts","url":"/collections/t-shirts"},{"is_category":"true","top":"true","label":"Men Clothing","url":"/collections/men-clothing"},{"is_low_level":"true","label":"Jackets","url":"/collections/jackets"},{"is_low_level":"true","label":"Casual Party Wear Shirts","url":"/collections/casual-party-wear-shirts"},{"is_low_level":"true","label":"Hoodie","url":"/collections/hoodie"},{"is_low_level":"true","label":"Caps","url":"/collections/men-caps"},{"is_low_level":"true","label":"Tshirts","url":"/collections/tshirts"},{"is_low_level":"true","label":"Track Pants","url":"/collections/track-pants"},{"is_low_level":"true","label":"Sweaters","url":"/collections/sweaters"},{"is_low_level":"true","label":"Formal Shirts","url":"/collections/formal-shirts"},{"is_low_level":"true","label":"Punjabis & Kurtas","url":"/collections/punjabis-kurtas"},{"is_low_level":"true","label":"Shirts","url":"/collections/shirts"},{"is_low_level":"true","label":"Pyjamas Lounge Pants","url":"/collections/pyjamas-lounge-pants"},{"is_low_level":"true","label":"Jeans","url":"/collections/jeans"},{"is_category":"true","top":"true","label":"Electronics","url":"/collections/electronics"},{"is_low_level":"true","label":"Mobile Covers Cases","url":"/collections/mobile-covers-cases"},{"is_low_level":"true","label":"Mobile Holders","url":"/collections/mobile-holders"},{"is_low_level":"true","label":"Behind Neck","url":"/collections/behind-neck"},{"is_low_level":"true","label":"Wired Headphones","url":"/collections/wired-headphones"},{"is_low_level":"true","label":"Speakers","url":"/collections/speakers"},{"is_low_level":"true","label":"Selfie Sticks","url":"/collections/selfie-sticks"},{"is_low_level":"true","label":"Mobile Displays","url":"/collections/mobile-displays"},{"is_low_level":"true","label":"Mobile Cables","url":"/collections/mobile-cables"},{"is_low_level":"true","label":"Usb Gadgets","url":"/collections/usb-gadgets"},{"is_category":"true","top":"true","label":"Home Improvement","url":"/collections/13873"},{"is_low_level":"true","label":"Bedsheets","url":"/collections/bedsheets"},{"is_low_level":"true","label":"Mixer juicer grinders","url":"/collections/mixerjuicergrinders"},{"is_low_level":"true","label":"Toothbrush Holders","url":"/collections/toothbrush-holders"},{"is_low_level":"true","label":"Table Lamps","url":"/collections/table-lamps"},{"is_category":"true","top":"true","label":"Bags Wallets & Belts","url":"/collections/bags-wallets-belts"},{"is_low_level":"true","label":"Backpacks","url":"/collections/backpacks"},{"is_low_level":"true","label":"Handbags","url":"/collections/handbags"},{"is_low_level":"true","label":"Shoulder Bags","url":"/collections/shoulder-bags"},{"is_low_level":"true","label":"Wallets Clutches","url":"/collections/wallets-clutches"},{"is_category":"true","top":"true","label":"Watches","url":"/collections/watches"},{"is_low_level":"true","label":"Wrist Watches","url":"/collections/wrist-watches"},{"is_low_level":"true","label":"Smart Watches","url":"/collections/smart-watches"},{"is_category":"true","top":"true","label":"Jewellery","url":"/collections/jewellery"},{"is_low_level":"true","label":"Jewellery Sets","url":"/collections/jewellery-sets"},{"is_low_level":"true","label":"Earrings","url":"/collections/earrings"},{"is_category":"true","top":"true","label":"Personal & Beauty Care","url":"/collections/beauty-personal-care"},{"is_low_level":"true","label":"Beauty Accessories","url":"/collections/beauty-accessories"}]
     * credit_data : {"approved_credits":0,"unapproved_credits":0}
     * user_profile : {"user_id":122694,"Email":"iamasthme@gmail.com","Gender":"M","Name":"Ataur","MSG-email":true,"MSG-push":true,"MSG-sms":true,"last_order":"false","primo_subscription":0,"primo_eligible":true}
     * style_lounge : {"enable_app":"false","browse_collections":true,"browse_looks":false,"phone_input":true,"category_input":false,"color_palette_input":true,"request_thank_you_message":"Thank You!\nOur Style Expert is working on your query.","request_extra_message":"A few Stylish products to checkout \nwhile you wait.","collection_button_text":"STYLIST COLLECTIONS"}
     */

    private CreditDataBean credit_data;
    private UserProfileBean user_profile;
    private StyleLoungeBean style_lounge;
    private List<MainMenuBean> main_menu;

    public CreditDataBean getCredit_data() {
        return credit_data;
    }

    public void setCredit_data(CreditDataBean credit_data) {
        this.credit_data = credit_data;
    }

    public UserProfileBean getUser_profile() {
        return user_profile;
    }

    public void setUser_profile(UserProfileBean user_profile) {
        this.user_profile = user_profile;
    }

    public StyleLoungeBean getStyle_lounge() {
        return style_lounge;
    }

    public void setStyle_lounge(StyleLoungeBean style_lounge) {
        this.style_lounge = style_lounge;
    }

    public List<MainMenuBean> getMain_menu() {
        return main_menu;
    }

    public void setMain_menu(List<MainMenuBean> main_menu) {
        this.main_menu = main_menu;
    }

    public static class CreditDataBean {
        /**
         * approved_credits : 0
         * unapproved_credits : 0
         */

        private int approved_credits;
        private int unapproved_credits;

        public int getApproved_credits() {
            return approved_credits;
        }

        public void setApproved_credits(int approved_credits) {
            this.approved_credits = approved_credits;
        }

        public int getUnapproved_credits() {
            return unapproved_credits;
        }

        public void setUnapproved_credits(int unapproved_credits) {
            this.unapproved_credits = unapproved_credits;
        }
    }

    public static class UserProfileBean {
        /**
         * user_id : 122694
         * Email : iamasthme@gmail.com
         * Gender : M
         * Name : Ataur
         * MSG-email : true
         * MSG-push : true
         * MSG-sms : true
         * last_order : false
         * primo_subscription : 0
         * primo_eligible : true
         */

        private int user_id;
        private String Email;
        private String Gender;
        private String Name;
        @SerializedName("MSG-email")
        private boolean MSGemail;
        @SerializedName("MSG-push")
        private boolean MSGpush;
        @SerializedName("MSG-sms")
        private boolean MSGsms;
        private String last_order;
        private int primo_subscription;
        private boolean primo_eligible;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String Email) {
            this.Email = Email;
        }

        public String getGender() {
            return Gender;
        }

        public void setGender(String Gender) {
            this.Gender = Gender;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public boolean isMSGemail() {
            return MSGemail;
        }

        public void setMSGemail(boolean MSGemail) {
            this.MSGemail = MSGemail;
        }

        public boolean isMSGpush() {
            return MSGpush;
        }

        public void setMSGpush(boolean MSGpush) {
            this.MSGpush = MSGpush;
        }

        public boolean isMSGsms() {
            return MSGsms;
        }

        public void setMSGsms(boolean MSGsms) {
            this.MSGsms = MSGsms;
        }

        public String getLast_order() {
            return last_order;
        }

        public void setLast_order(String last_order) {
            this.last_order = last_order;
        }

        public int getPrimo_subscription() {
            return primo_subscription;
        }

        public void setPrimo_subscription(int primo_subscription) {
            this.primo_subscription = primo_subscription;
        }

        public boolean isPrimo_eligible() {
            return primo_eligible;
        }

        public void setPrimo_eligible(boolean primo_eligible) {
            this.primo_eligible = primo_eligible;
        }
    }

    public static class StyleLoungeBean {
        /**
         * enable_app : false
         * browse_collections : true
         * browse_looks : false
         * phone_input : true
         * category_input : false
         * color_palette_input : true
         * request_thank_you_message : Thank You!
         Our Style Expert is working on your query.
         * request_extra_message : A few Stylish products to checkout
         while you wait.
         * collection_button_text : STYLIST COLLECTIONS
         */

        private String enable_app;
        private boolean browse_collections;
        private boolean browse_looks;
        private boolean phone_input;
        private boolean category_input;
        private boolean color_palette_input;
        private String request_thank_you_message;
        private String request_extra_message;
        private String collection_button_text;

        public String getEnable_app() {
            return enable_app;
        }

        public void setEnable_app(String enable_app) {
            this.enable_app = enable_app;
        }

        public boolean isBrowse_collections() {
            return browse_collections;
        }

        public void setBrowse_collections(boolean browse_collections) {
            this.browse_collections = browse_collections;
        }

        public boolean isBrowse_looks() {
            return browse_looks;
        }

        public void setBrowse_looks(boolean browse_looks) {
            this.browse_looks = browse_looks;
        }

        public boolean isPhone_input() {
            return phone_input;
        }

        public void setPhone_input(boolean phone_input) {
            this.phone_input = phone_input;
        }

        public boolean isCategory_input() {
            return category_input;
        }

        public void setCategory_input(boolean category_input) {
            this.category_input = category_input;
        }

        public boolean isColor_palette_input() {
            return color_palette_input;
        }

        public void setColor_palette_input(boolean color_palette_input) {
            this.color_palette_input = color_palette_input;
        }

        public String getRequest_thank_you_message() {
            return request_thank_you_message;
        }

        public void setRequest_thank_you_message(String request_thank_you_message) {
            this.request_thank_you_message = request_thank_you_message;
        }

        public String getRequest_extra_message() {
            return request_extra_message;
        }

        public void setRequest_extra_message(String request_extra_message) {
            this.request_extra_message = request_extra_message;
        }

        public String getCollection_button_text() {
            return collection_button_text;
        }

        public void setCollection_button_text(String collection_button_text) {
            this.collection_button_text = collection_button_text;
        }
    }

    public static class MainMenuBean {
        /**
         * label : Shop by Category
         * position : 1
         * is_category : true
         * top : true
         * url : /collections/women-clothing
         * is_low_level : true
         */

        private String label;
        private String position;
        private String is_category;
        private String top;
        private String url;
        private String is_low_level;

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getIs_category() {
            return is_category;
        }

        public void setIs_category(String is_category) {
            this.is_category = is_category;
        }

        public String getTop() {
            return top;
        }

        public void setTop(String top) {
            this.top = top;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getIs_low_level() {
            return is_low_level;
        }

        public void setIs_low_level(String is_low_level) {
            this.is_low_level = is_low_level;
        }
    }
}
