package services.responseModels.commerceModels;

import java.util.List;

public class OrderCheckoutModel {

    /**
     * heading : Order Successful
     * enable_prepaid_retry : false
     * otp_message : Your order #R5132037783 is  acknowledged. Please confirm it in 'My Orders' using the OTP sent to you. Please contact Support () for any assistance required.
     * otp : 289542
     * otp_confirmation_needed : false
     * enable_mandatory_sign_in : {"web":true,"wap":true}
     * order_success : true
     * country_list : [{"code":"IN","flag":"https://images1.voonik.com/assets/flags/india.svg","currency_unicode":"Tk. ","updated_at":"2018-01-22T15:30:20.000+05:30","extra_data":"","name":"INDIA","created_at":null,"currency":"Tk.","id":1,"conversion_rate":1,"currency_code":"BDT","status":"active"},{"code":"LK","flag":"https://images1.voonik.com/assets/flags/sri-lanka.svg","currency_unicode":"Rs ","updated_at":"2018-06-01T15:33:51.000+05:30","extra_data":"","name":"SRILANKA","created_at":"2017-12-27T14:56:03.000+05:30","currency":"","id":4,"conversion_rate":0.85,"currency_code":"INR","status":"active"}]
     * message : Your order #R5132037783 has been successfully placed.
     * shipped_addresses : [{"country":"INDIA","firstname":"Ashok","address2":"Banglore","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":null,"id":9122876,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"Andhra Pradesh","firstname":"Hari","address2":null,"city":"Bagerhat Sadar, Bagerhat","alternative_phone":null,"address1":"TCE Street","lastname":"","zipcode":"755","is_saved":null,"user_id":122694,"phone":"8801877655690","company":null,"id":9122855,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"Andhra Pradesh","firstname":"Hari","address2":null,"city":"Baigertek, Dhaka","alternative_phone":null,"address1":"TCE Street","lastname":"","zipcode":"35","is_saved":null,"user_id":122694,"phone":"8801877655690","company":null,"id":9122854,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"Jagadeesh","address2":"Near near","city":"Adabor, Dhaka","alternative_phone":"8801812345678","address1":"#123, 5th cross, testing area","lastname":"","zipcode":"7","is_saved":true,"user_id":122694,"phone":"8801877755590","company":"home","id":9122817,"state":"Andhra Pradesh","state_id":34,"landmark":"xyz","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122809,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122700,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122697,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122696,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122695,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122694,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122688,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122687,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"Andhra Pradesh","firstname":"testing 1","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street 1","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122686,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"Andhra Pradesh","firstname":"testing 2","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122683,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"Andhra Pradesh","firstname":"testing 3","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street 3","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122682,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"Andhra Pradesh","firstname":"testing  4","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122677,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122670,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122646,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122628,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122625,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122622,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122620,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122617,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122616,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122614,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122613,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"Andhra Pradesh","firstname":"Vijay","address2":"N/A","city":"Adamdighi, Bogra","alternative_phone":null,"address1":"Bsbbsb dbbbdbnd d nsndndndnnd ndndndndndn xndnnxjx","lastname":"","zipcode":"818","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"NA","id":9042990,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"vijay","address2":"N/A","city":"Adabor, Dhaka","alternative_phone":null,"address1":"asdasd asdasdasd asdasdasdasd","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"NA","id":9042987,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1}]
     * user_email_valid : true
     * order_data : {"shipping_adjustments":[],"adjustments":[{"income":0,"is_seller_coupon":false,"adjustment_type":6,"formatted_income":"Tk. 0","label":"Shipping Charges","value_amount":49,"value":"Tk. 49","value_currency":"INR"}],"formatted_total_save":"Tk. -20","cart_items":[{"formatted_price":"Tk. 492","seller":"BBF","min_order_qty":1,"line_item_id":299872,"discount":0,"prepaid_availability":true,"seller_slug":"bbf","delivery_time":"Delivery in 5-6 working days.","title":"Men's Stylish Gabardine Pant - Cream 03 - BBF","liked":false,"category_id":1125,"variant_options":[{"count_on_hand":49,"option_value_name":"28","size":5,"corrected_count_on_hand":3,"name":"28","id":5544},{"count_on_hand":43,"option_value_name":"30","size":5,"corrected_count_on_hand":3,"name":"30","id":5546},{"count_on_hand":39,"option_value_name":"32","size":5,"corrected_count_on_hand":3,"name":"32","id":5547},{"count_on_hand":29,"option_value_name":"34","size":5,"corrected_count_on_hand":3,"name":"34","id":5549},{"count_on_hand":39,"option_value_name":"36","size":5,"corrected_count_on_hand":3,"name":"36","id":5550}],"max_item_quantity":50,"price":"492.0","product_id":5377,"sold_out":false,"variant":5549,"formatted_income":null,"mrp_price_line":"Tk. 472 x 1 = Tk. 472","cod_availability":true,"formatted_per_item_total":"Tk. 492","per_item_total":492,"sku":"270635","delivery_time_message":{"message":"Delivery in 5-6 working days.","type":2},"prepaid_message":"Delivery in 5-6 working days.","activity_object":{"activity_object":{"id":"P5377"}},"image":"https://shopimages.vstores.io/7735/1572852365758-new-small.jpg?1580071087","quantity":1,"max_selling_price":747,"original_amo":472,"variant_price":420,"final_discount":0,"formatted_variant_price":null,"price_line":"Tk. 492 x 1 = Tk. 492","product_name":"Men\\'s Stylish Gabardine Pant - Cream 03 - BBF","sale_price":"492.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 492","size":"34","line_item_adjustments":[],"master_product_id":5377,"messages":[],"min_selling_price":492,"category":"Men track pant","permalink":"men-s-stylish-gabardine-pant-cream-03-bbf-42a65ec9","cod_message":"Delivery in 5-6 working days."}],"order_number":"R5132037783","final_save":-20,"grand_total_amount":541,"total_str":"Tk. 492","total_save":-20,"special_prepaid_method":false,"total_currency":"INR","formatted_final_save":"Tk. -20","payment_methods":[{"payment_method":{"account_id":0,"code":null,"name":"payu_redirect","rank":100,"id":7,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":"ptr","name":"payu_redirect","rank":60,"id":71,"vaccount_id":1,"display_name":"PREPAID TO RESELLER","is_default":false}},{"payment_method":{"account_id":0,"code":"paypal","name":"payu_redirect","rank":50,"id":61,"vaccount_id":1,"display_name":"PAYPAL","is_default":false}},{"payment_method":{"account_id":0,"code":"wallet","name":"payu_redirect","rank":40,"id":51,"vaccount_id":1,"display_name":"WALLETS","is_default":false}},{"payment_method":{"account_id":0,"code":"nb","name":"payu_redirect","rank":40,"id":41,"vaccount_id":1,"display_name":"NET BANKING","is_default":false}},{"payment_method":{"account_id":0,"code":"emi","name":"payu_redirect","rank":35,"id":91,"vaccount_id":1,"display_name":"EMI","is_default":false}},{"payment_method":{"account_id":0,"code":"reseller_online_payment","name":"payu_redirect","rank":30,"id":85,"vaccount_id":1,"display_name":"Online Payment","is_default":false}},{"payment_method":{"account_id":0,"code":"cc","name":"payu_redirect","rank":30,"id":31,"vaccount_id":1,"display_name":"CREDIT CARD","is_default":false}},{"payment_method":{"account_id":0,"code":"online_payment","name":"payu_redirect","rank":25,"id":81,"vaccount_id":1,"display_name":"Online Payment","is_default":false}},{"payment_method":{"account_id":0,"code":"dc","name":"payu_redirect","rank":20,"id":21,"vaccount_id":1,"display_name":"DEBIT / ATM CARD","is_default":false}},{"payment_method":{"account_id":0,"code":"cod","name":"cod","rank":10,"id":1,"vaccount_id":1,"display_name":"CASH ON DELIVERY","is_default":true}},{"payment_method":{"account_id":0,"code":null,"name":"cod","rank":1,"id":16,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"simpl","rank":1,"id":17,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"payu_redirect","rank":1,"id":15,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"simpl","rank":1,"id":14,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"cod","rank":1,"id":13,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"payu_redirect","rank":1,"id":12,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"payu_redirect","rank":1,"id":11,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"cod","rank":1,"id":10,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"payu_redirect","rank":1,"id":9,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"cod","rank":1,"id":8,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"email_invoice","rank":1,"id":6,"vaccount_id":1,"display_name":null,"is_default":false}}],"vcash_data":{"available_vcash":0,"show_vcash_form":true,"vcash_already_applied_in_order":0,"approved_vcash":0},"total":"Tk. 492","total_amount_after_discount":"492.0","grand_total_currency":"INR","order_data":{"error_message":0,"adjustments":[{"amount":49,"is_seller_coupon":false,"is_vcash":false,"label":"Shipping Charges"}],"new_user_check_for_nps":false,"order_number":"R5132037783","count":1,"cart_items_total":"492.0","pickup_address":null,"prepaid_availability":true,"remaining_vcash":0,"item_total":492,"vcash_data":{"available_vcash":0,"show_vcash_form":true,"vcash_already_applied_in_order":0,"approved_vcash":0},"total":541,"total_income":0,"coupon_applied_message":"The coupon code is applied","subtotal":492,"last_completed_order":null,"messages":[],"lastmile_addresses":[],"cod_availability":true,"formatted_total_income":"Tk. 0","payment_method":"cod","code_applied":false,"li_by_sellers":{"BBF":{"adjustments":[],"subtotal":492,"item_total":492,"items":[{"formatted_price":"Tk. 492","seller":"BBF","min_order_qty":1,"line_item_id":299872,"discount":0,"prepaid_availability":true,"seller_slug":"bbf","delivery_time":"Delivery in 5-6 working days.","title":"Men's Stylish Gabardine Pant - Cream 03 - BBF","liked":false,"category_id":1125,"variant_options":[{"count_on_hand":49,"option_value_name":"28","size":5,"corrected_count_on_hand":3,"name":"28","id":5544},{"count_on_hand":43,"option_value_name":"30","size":5,"corrected_count_on_hand":3,"name":"30","id":5546},{"count_on_hand":39,"option_value_name":"32","size":5,"corrected_count_on_hand":3,"name":"32","id":5547},{"count_on_hand":29,"option_value_name":"34","size":5,"corrected_count_on_hand":3,"name":"34","id":5549},{"count_on_hand":39,"option_value_name":"36","size":5,"corrected_count_on_hand":3,"name":"36","id":5550}],"max_item_quantity":50,"price":"492.0","product_id":5377,"sold_out":false,"variant":5549,"formatted_income":null,"mrp_price_line":"Tk. 472 x 1 = Tk. 472","cod_availability":true,"formatted_per_item_total":"Tk. 492","per_item_total":492,"sku":"270635","delivery_time_message":{"message":"Delivery in 5-6 working days.","type":2},"prepaid_message":"Delivery in 5-6 working days.","activity_object":{"activity_object":{"id":"P5377"}},"image":"https://shopimages.vstores.io/7735/1572852365758-new-small.jpg?1580071087","quantity":1,"max_selling_price":747,"original_amo":472,"variant_price":420,"final_discount":0,"formatted_variant_price":null,"price_line":"Tk. 492 x 1 = Tk. 492","product_name":"Men\\'s Stylish Gabardine Pant - Cream 03 - BBF","sale_price":"492.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 492","size":"34","line_item_adjustments":[],"master_product_id":5377,"messages":[],"min_selling_price":492,"category":"Men track pant","permalink":"men-s-stylish-gabardine-pant-cream-03-bbf-42a65ec9","cod_message":"Delivery in 5-6 working days."}]}}},"total_amount":492,"non_cod_adjustments":[{"adjustment_type":6,"label":"Shipping Charges","value_amount":49,"value_currency":"INR"}],"cod_adjustments":[],"grand_total":"Tk. 541","payment_method":"cod","code_applied":false}
     * signed_in_user : true
     * otp_heading : Order Confirmation Pending!
     * serviceable_line_items : []
     * successful_order_variants : [5549]
     * ship_address : {"address":{"country":"INDIA","firstname":"Ashok","address2":"Banglore","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":null,"id":9122876,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1}}
     * user : {"user":{"email":"iamasthme@gmail.com","name":"Ataur"}}
     * adjustment_total : 49
     */

    private String heading;
    private boolean enable_prepaid_retry;
    private String otp_message;
    private int otp;
    private boolean otp_confirmation_needed;
    private EnableMandatorySignInBean enable_mandatory_sign_in;
    private boolean order_success;
    private String message;
    private boolean user_email_valid;
    private OrderDataBeanX order_data;
    private boolean signed_in_user;
    private String otp_heading;
    private ShipAddressBean ship_address;
    private UserBeanX user;
    private int adjustment_total;
    private List<CountryListBean> country_list;
    private List<ShippedAddressesBean> shipped_addresses;
    private List<?> serviceable_line_items;
    private List<Integer> successful_order_variants;

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public boolean isEnable_prepaid_retry() {
        return enable_prepaid_retry;
    }

    public void setEnable_prepaid_retry(boolean enable_prepaid_retry) {
        this.enable_prepaid_retry = enable_prepaid_retry;
    }

    public String getOtp_message() {
        return otp_message;
    }

    public void setOtp_message(String otp_message) {
        this.otp_message = otp_message;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public boolean isOtp_confirmation_needed() {
        return otp_confirmation_needed;
    }

    public void setOtp_confirmation_needed(boolean otp_confirmation_needed) {
        this.otp_confirmation_needed = otp_confirmation_needed;
    }

    public EnableMandatorySignInBean getEnable_mandatory_sign_in() {
        return enable_mandatory_sign_in;
    }

    public void setEnable_mandatory_sign_in(EnableMandatorySignInBean enable_mandatory_sign_in) {
        this.enable_mandatory_sign_in = enable_mandatory_sign_in;
    }

    public boolean isOrder_success() {
        return order_success;
    }

    public void setOrder_success(boolean order_success) {
        this.order_success = order_success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isUser_email_valid() {
        return user_email_valid;
    }

    public void setUser_email_valid(boolean user_email_valid) {
        this.user_email_valid = user_email_valid;
    }

    public OrderDataBeanX getOrder_data() {
        return order_data;
    }

    public void setOrder_data(OrderDataBeanX order_data) {
        this.order_data = order_data;
    }

    public boolean isSigned_in_user() {
        return signed_in_user;
    }

    public void setSigned_in_user(boolean signed_in_user) {
        this.signed_in_user = signed_in_user;
    }

    public String getOtp_heading() {
        return otp_heading;
    }

    public void setOtp_heading(String otp_heading) {
        this.otp_heading = otp_heading;
    }

    public ShipAddressBean getShip_address() {
        return ship_address;
    }

    public void setShip_address(ShipAddressBean ship_address) {
        this.ship_address = ship_address;
    }

    public UserBeanX getUser() {
        return user;
    }

    public void setUser(UserBeanX user) {
        this.user = user;
    }

    public int getAdjustment_total() {
        return adjustment_total;
    }

    public void setAdjustment_total(int adjustment_total) {
        this.adjustment_total = adjustment_total;
    }

    public List<CountryListBean> getCountry_list() {
        return country_list;
    }

    public void setCountry_list(List<CountryListBean> country_list) {
        this.country_list = country_list;
    }

    public List<ShippedAddressesBean> getShipped_addresses() {
        return shipped_addresses;
    }

    public void setShipped_addresses(List<ShippedAddressesBean> shipped_addresses) {
        this.shipped_addresses = shipped_addresses;
    }

    public List<?> getServiceable_line_items() {
        return serviceable_line_items;
    }

    public void setServiceable_line_items(List<?> serviceable_line_items) {
        this.serviceable_line_items = serviceable_line_items;
    }

    public List<Integer> getSuccessful_order_variants() {
        return successful_order_variants;
    }

    public void setSuccessful_order_variants(List<Integer> successful_order_variants) {
        this.successful_order_variants = successful_order_variants;
    }

    public static class EnableMandatorySignInBean {
        /**
         * web : true
         * wap : true
         */

        private boolean web;
        private boolean wap;

        public boolean isWeb() {
            return web;
        }

        public void setWeb(boolean web) {
            this.web = web;
        }

        public boolean isWap() {
            return wap;
        }

        public void setWap(boolean wap) {
            this.wap = wap;
        }
    }

    public static class OrderDataBeanX {
        /**
         * shipping_adjustments : []
         * adjustments : [{"income":0,"is_seller_coupon":false,"adjustment_type":6,"formatted_income":"Tk. 0","label":"Shipping Charges","value_amount":49,"value":"Tk. 49","value_currency":"INR"}]
         * formatted_total_save : Tk. -20
         * cart_items : [{"formatted_price":"Tk. 492","seller":"BBF","min_order_qty":1,"line_item_id":299872,"discount":0,"prepaid_availability":true,"seller_slug":"bbf","delivery_time":"Delivery in 5-6 working days.","title":"Men's Stylish Gabardine Pant - Cream 03 - BBF","liked":false,"category_id":1125,"variant_options":[{"count_on_hand":49,"option_value_name":"28","size":5,"corrected_count_on_hand":3,"name":"28","id":5544},{"count_on_hand":43,"option_value_name":"30","size":5,"corrected_count_on_hand":3,"name":"30","id":5546},{"count_on_hand":39,"option_value_name":"32","size":5,"corrected_count_on_hand":3,"name":"32","id":5547},{"count_on_hand":29,"option_value_name":"34","size":5,"corrected_count_on_hand":3,"name":"34","id":5549},{"count_on_hand":39,"option_value_name":"36","size":5,"corrected_count_on_hand":3,"name":"36","id":5550}],"max_item_quantity":50,"price":"492.0","product_id":5377,"sold_out":false,"variant":5549,"formatted_income":null,"mrp_price_line":"Tk. 472 x 1 = Tk. 472","cod_availability":true,"formatted_per_item_total":"Tk. 492","per_item_total":492,"sku":"270635","delivery_time_message":{"message":"Delivery in 5-6 working days.","type":2},"prepaid_message":"Delivery in 5-6 working days.","activity_object":{"activity_object":{"id":"P5377"}},"image":"https://shopimages.vstores.io/7735/1572852365758-new-small.jpg?1580071087","quantity":1,"max_selling_price":747,"original_amo":472,"variant_price":420,"final_discount":0,"formatted_variant_price":null,"price_line":"Tk. 492 x 1 = Tk. 492","product_name":"Men\\'s Stylish Gabardine Pant - Cream 03 - BBF","sale_price":"492.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 492","size":"34","line_item_adjustments":[],"master_product_id":5377,"messages":[],"min_selling_price":492,"category":"Men track pant","permalink":"men-s-stylish-gabardine-pant-cream-03-bbf-42a65ec9","cod_message":"Delivery in 5-6 working days."}]
         * order_number : R5132037783
         * final_save : -20
         * grand_total_amount : 541
         * total_str : Tk. 492
         * total_save : -20
         * special_prepaid_method : false
         * total_currency : INR
         * formatted_final_save : Tk. -20
         * payment_methods : [{"payment_method":{"account_id":0,"code":null,"name":"payu_redirect","rank":100,"id":7,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":"ptr","name":"payu_redirect","rank":60,"id":71,"vaccount_id":1,"display_name":"PREPAID TO RESELLER","is_default":false}},{"payment_method":{"account_id":0,"code":"paypal","name":"payu_redirect","rank":50,"id":61,"vaccount_id":1,"display_name":"PAYPAL","is_default":false}},{"payment_method":{"account_id":0,"code":"wallet","name":"payu_redirect","rank":40,"id":51,"vaccount_id":1,"display_name":"WALLETS","is_default":false}},{"payment_method":{"account_id":0,"code":"nb","name":"payu_redirect","rank":40,"id":41,"vaccount_id":1,"display_name":"NET BANKING","is_default":false}},{"payment_method":{"account_id":0,"code":"emi","name":"payu_redirect","rank":35,"id":91,"vaccount_id":1,"display_name":"EMI","is_default":false}},{"payment_method":{"account_id":0,"code":"reseller_online_payment","name":"payu_redirect","rank":30,"id":85,"vaccount_id":1,"display_name":"Online Payment","is_default":false}},{"payment_method":{"account_id":0,"code":"cc","name":"payu_redirect","rank":30,"id":31,"vaccount_id":1,"display_name":"CREDIT CARD","is_default":false}},{"payment_method":{"account_id":0,"code":"online_payment","name":"payu_redirect","rank":25,"id":81,"vaccount_id":1,"display_name":"Online Payment","is_default":false}},{"payment_method":{"account_id":0,"code":"dc","name":"payu_redirect","rank":20,"id":21,"vaccount_id":1,"display_name":"DEBIT / ATM CARD","is_default":false}},{"payment_method":{"account_id":0,"code":"cod","name":"cod","rank":10,"id":1,"vaccount_id":1,"display_name":"CASH ON DELIVERY","is_default":true}},{"payment_method":{"account_id":0,"code":null,"name":"cod","rank":1,"id":16,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"simpl","rank":1,"id":17,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"payu_redirect","rank":1,"id":15,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"simpl","rank":1,"id":14,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"cod","rank":1,"id":13,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"payu_redirect","rank":1,"id":12,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"payu_redirect","rank":1,"id":11,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"cod","rank":1,"id":10,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"payu_redirect","rank":1,"id":9,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"cod","rank":1,"id":8,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"email_invoice","rank":1,"id":6,"vaccount_id":1,"display_name":null,"is_default":false}}]
         * vcash_data : {"available_vcash":0,"show_vcash_form":true,"vcash_already_applied_in_order":0,"approved_vcash":0}
         * total : Tk. 492
         * total_amount_after_discount : 492.0
         * grand_total_currency : INR
         * order_data : {"error_message":0,"adjustments":[{"amount":49,"is_seller_coupon":false,"is_vcash":false,"label":"Shipping Charges"}],"new_user_check_for_nps":false,"order_number":"R5132037783","count":1,"cart_items_total":"492.0","pickup_address":null,"prepaid_availability":true,"remaining_vcash":0,"item_total":492,"vcash_data":{"available_vcash":0,"show_vcash_form":true,"vcash_already_applied_in_order":0,"approved_vcash":0},"total":541,"total_income":0,"coupon_applied_message":"The coupon code is applied","subtotal":492,"last_completed_order":null,"messages":[],"lastmile_addresses":[],"cod_availability":true,"formatted_total_income":"Tk. 0","payment_method":"cod","code_applied":false,"li_by_sellers":{"BBF":{"adjustments":[],"subtotal":492,"item_total":492,"items":[{"formatted_price":"Tk. 492","seller":"BBF","min_order_qty":1,"line_item_id":299872,"discount":0,"prepaid_availability":true,"seller_slug":"bbf","delivery_time":"Delivery in 5-6 working days.","title":"Men's Stylish Gabardine Pant - Cream 03 - BBF","liked":false,"category_id":1125,"variant_options":[{"count_on_hand":49,"option_value_name":"28","size":5,"corrected_count_on_hand":3,"name":"28","id":5544},{"count_on_hand":43,"option_value_name":"30","size":5,"corrected_count_on_hand":3,"name":"30","id":5546},{"count_on_hand":39,"option_value_name":"32","size":5,"corrected_count_on_hand":3,"name":"32","id":5547},{"count_on_hand":29,"option_value_name":"34","size":5,"corrected_count_on_hand":3,"name":"34","id":5549},{"count_on_hand":39,"option_value_name":"36","size":5,"corrected_count_on_hand":3,"name":"36","id":5550}],"max_item_quantity":50,"price":"492.0","product_id":5377,"sold_out":false,"variant":5549,"formatted_income":null,"mrp_price_line":"Tk. 472 x 1 = Tk. 472","cod_availability":true,"formatted_per_item_total":"Tk. 492","per_item_total":492,"sku":"270635","delivery_time_message":{"message":"Delivery in 5-6 working days.","type":2},"prepaid_message":"Delivery in 5-6 working days.","activity_object":{"activity_object":{"id":"P5377"}},"image":"https://shopimages.vstores.io/7735/1572852365758-new-small.jpg?1580071087","quantity":1,"max_selling_price":747,"original_amo":472,"variant_price":420,"final_discount":0,"formatted_variant_price":null,"price_line":"Tk. 492 x 1 = Tk. 492","product_name":"Men\\'s Stylish Gabardine Pant - Cream 03 - BBF","sale_price":"492.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 492","size":"34","line_item_adjustments":[],"master_product_id":5377,"messages":[],"min_selling_price":492,"category":"Men track pant","permalink":"men-s-stylish-gabardine-pant-cream-03-bbf-42a65ec9","cod_message":"Delivery in 5-6 working days."}]}}}
         * total_amount : 492
         * non_cod_adjustments : [{"adjustment_type":6,"label":"Shipping Charges","value_amount":49,"value_currency":"INR"}]
         * cod_adjustments : []
         * grand_total : Tk. 541
         * payment_method : cod
         * code_applied : false
         */

        private String formatted_total_save;
        private String order_number;
        private int final_save;
        private int grand_total_amount;
        private String total_str;
        private int total_save;
        private boolean special_prepaid_method;
        private String total_currency;
        private String formatted_final_save;
        private VcashDataBean vcash_data;
        private String total;
        private String total_amount_after_discount;
        private String grand_total_currency;
        private OrderDataBean order_data;
        private int total_amount;
        private String grand_total;
        private String payment_method;
        private boolean code_applied;
        private List<?> shipping_adjustments;
        private List<AdjustmentsBeanX> adjustments;
        private List<CartItemsBean> cart_items;
        private List<PaymentMethodsBean> payment_methods;
        private List<NonCodAdjustmentsBean> non_cod_adjustments;
        private List<?> cod_adjustments;

        public String getFormatted_total_save() {
            return formatted_total_save;
        }

        public void setFormatted_total_save(String formatted_total_save) {
            this.formatted_total_save = formatted_total_save;
        }

        public String getOrder_number() {
            return order_number;
        }

        public void setOrder_number(String order_number) {
            this.order_number = order_number;
        }

        public int getFinal_save() {
            return final_save;
        }

        public void setFinal_save(int final_save) {
            this.final_save = final_save;
        }

        public int getGrand_total_amount() {
            return grand_total_amount;
        }

        public void setGrand_total_amount(int grand_total_amount) {
            this.grand_total_amount = grand_total_amount;
        }

        public String getTotal_str() {
            return total_str;
        }

        public void setTotal_str(String total_str) {
            this.total_str = total_str;
        }

        public int getTotal_save() {
            return total_save;
        }

        public void setTotal_save(int total_save) {
            this.total_save = total_save;
        }

        public boolean isSpecial_prepaid_method() {
            return special_prepaid_method;
        }

        public void setSpecial_prepaid_method(boolean special_prepaid_method) {
            this.special_prepaid_method = special_prepaid_method;
        }

        public String getTotal_currency() {
            return total_currency;
        }

        public void setTotal_currency(String total_currency) {
            this.total_currency = total_currency;
        }

        public String getFormatted_final_save() {
            return formatted_final_save;
        }

        public void setFormatted_final_save(String formatted_final_save) {
            this.formatted_final_save = formatted_final_save;
        }

        public VcashDataBean getVcash_data() {
            return vcash_data;
        }

        public void setVcash_data(VcashDataBean vcash_data) {
            this.vcash_data = vcash_data;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getTotal_amount_after_discount() {
            return total_amount_after_discount;
        }

        public void setTotal_amount_after_discount(String total_amount_after_discount) {
            this.total_amount_after_discount = total_amount_after_discount;
        }

        public String getGrand_total_currency() {
            return grand_total_currency;
        }

        public void setGrand_total_currency(String grand_total_currency) {
            this.grand_total_currency = grand_total_currency;
        }

        public OrderDataBean getOrder_data() {
            return order_data;
        }

        public void setOrder_data(OrderDataBean order_data) {
            this.order_data = order_data;
        }

        public int getTotal_amount() {
            return total_amount;
        }

        public void setTotal_amount(int total_amount) {
            this.total_amount = total_amount;
        }

        public String getGrand_total() {
            return grand_total;
        }

        public void setGrand_total(String grand_total) {
            this.grand_total = grand_total;
        }

        public String getPayment_method() {
            return payment_method;
        }

        public void setPayment_method(String payment_method) {
            this.payment_method = payment_method;
        }

        public boolean isCode_applied() {
            return code_applied;
        }

        public void setCode_applied(boolean code_applied) {
            this.code_applied = code_applied;
        }

        public List<?> getShipping_adjustments() {
            return shipping_adjustments;
        }

        public void setShipping_adjustments(List<?> shipping_adjustments) {
            this.shipping_adjustments = shipping_adjustments;
        }

        public List<AdjustmentsBeanX> getAdjustments() {
            return adjustments;
        }

        public void setAdjustments(List<AdjustmentsBeanX> adjustments) {
            this.adjustments = adjustments;
        }

        public List<CartItemsBean> getCart_items() {
            return cart_items;
        }

        public void setCart_items(List<CartItemsBean> cart_items) {
            this.cart_items = cart_items;
        }

        public List<PaymentMethodsBean> getPayment_methods() {
            return payment_methods;
        }

        public void setPayment_methods(List<PaymentMethodsBean> payment_methods) {
            this.payment_methods = payment_methods;
        }

        public List<NonCodAdjustmentsBean> getNon_cod_adjustments() {
            return non_cod_adjustments;
        }

        public void setNon_cod_adjustments(List<NonCodAdjustmentsBean> non_cod_adjustments) {
            this.non_cod_adjustments = non_cod_adjustments;
        }

        public List<?> getCod_adjustments() {
            return cod_adjustments;
        }

        public void setCod_adjustments(List<?> cod_adjustments) {
            this.cod_adjustments = cod_adjustments;
        }

        public static class VcashDataBean {
            /**
             * available_vcash : 0
             * show_vcash_form : true
             * vcash_already_applied_in_order : 0
             * approved_vcash : 0
             */

            private int available_vcash;
            private boolean show_vcash_form;
            private int vcash_already_applied_in_order;
            private int approved_vcash;

            public int getAvailable_vcash() {
                return available_vcash;
            }

            public void setAvailable_vcash(int available_vcash) {
                this.available_vcash = available_vcash;
            }

            public boolean isShow_vcash_form() {
                return show_vcash_form;
            }

            public void setShow_vcash_form(boolean show_vcash_form) {
                this.show_vcash_form = show_vcash_form;
            }

            public int getVcash_already_applied_in_order() {
                return vcash_already_applied_in_order;
            }

            public void setVcash_already_applied_in_order(int vcash_already_applied_in_order) {
                this.vcash_already_applied_in_order = vcash_already_applied_in_order;
            }

            public int getApproved_vcash() {
                return approved_vcash;
            }

            public void setApproved_vcash(int approved_vcash) {
                this.approved_vcash = approved_vcash;
            }
        }

        public static class OrderDataBean {
            /**
             * error_message : 0
             * adjustments : [{"amount":49,"is_seller_coupon":false,"is_vcash":false,"label":"Shipping Charges"}]
             * new_user_check_for_nps : false
             * order_number : R5132037783
             * count : 1
             * cart_items_total : 492.0
             * pickup_address : null
             * prepaid_availability : true
             * remaining_vcash : 0
             * item_total : 492
             * vcash_data : {"available_vcash":0,"show_vcash_form":true,"vcash_already_applied_in_order":0,"approved_vcash":0}
             * total : 541
             * total_income : 0
             * coupon_applied_message : The coupon code is applied
             * subtotal : 492
             * last_completed_order : null
             * messages : []
             * lastmile_addresses : []
             * cod_availability : true
             * formatted_total_income : Tk. 0
             * payment_method : cod
             * code_applied : false
             * li_by_sellers : {"BBF":{"adjustments":[],"subtotal":492,"item_total":492,"items":[{"formatted_price":"Tk. 492","seller":"BBF","min_order_qty":1,"line_item_id":299872,"discount":0,"prepaid_availability":true,"seller_slug":"bbf","delivery_time":"Delivery in 5-6 working days.","title":"Men's Stylish Gabardine Pant - Cream 03 - BBF","liked":false,"category_id":1125,"variant_options":[{"count_on_hand":49,"option_value_name":"28","size":5,"corrected_count_on_hand":3,"name":"28","id":5544},{"count_on_hand":43,"option_value_name":"30","size":5,"corrected_count_on_hand":3,"name":"30","id":5546},{"count_on_hand":39,"option_value_name":"32","size":5,"corrected_count_on_hand":3,"name":"32","id":5547},{"count_on_hand":29,"option_value_name":"34","size":5,"corrected_count_on_hand":3,"name":"34","id":5549},{"count_on_hand":39,"option_value_name":"36","size":5,"corrected_count_on_hand":3,"name":"36","id":5550}],"max_item_quantity":50,"price":"492.0","product_id":5377,"sold_out":false,"variant":5549,"formatted_income":null,"mrp_price_line":"Tk. 472 x 1 = Tk. 472","cod_availability":true,"formatted_per_item_total":"Tk. 492","per_item_total":492,"sku":"270635","delivery_time_message":{"message":"Delivery in 5-6 working days.","type":2},"prepaid_message":"Delivery in 5-6 working days.","activity_object":{"activity_object":{"id":"P5377"}},"image":"https://shopimages.vstores.io/7735/1572852365758-new-small.jpg?1580071087","quantity":1,"max_selling_price":747,"original_amo":472,"variant_price":420,"final_discount":0,"formatted_variant_price":null,"price_line":"Tk. 492 x 1 = Tk. 492","product_name":"Men\\'s Stylish Gabardine Pant - Cream 03 - BBF","sale_price":"492.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 492","size":"34","line_item_adjustments":[],"master_product_id":5377,"messages":[],"min_selling_price":492,"category":"Men track pant","permalink":"men-s-stylish-gabardine-pant-cream-03-bbf-42a65ec9","cod_message":"Delivery in 5-6 working days."}]}}
             */

            private int error_message;
            private boolean new_user_check_for_nps;
            private String order_number;
            private int count;
            private String cart_items_total;
            private Object pickup_address;
            private boolean prepaid_availability;
            private int remaining_vcash;
            private int item_total;
            private VcashDataBeanX vcash_data;
            private int total;
            private int total_income;
            private String coupon_applied_message;
            private int subtotal;
            private Object last_completed_order;
            private boolean cod_availability;
            private String formatted_total_income;
            private String payment_method;
            private boolean code_applied;
            private LiBySellersBean li_by_sellers;
            private List<AdjustmentsBean> adjustments;
            private List<?> messages;
            private List<?> lastmile_addresses;

            public int getError_message() {
                return error_message;
            }

            public void setError_message(int error_message) {
                this.error_message = error_message;
            }

            public boolean isNew_user_check_for_nps() {
                return new_user_check_for_nps;
            }

            public void setNew_user_check_for_nps(boolean new_user_check_for_nps) {
                this.new_user_check_for_nps = new_user_check_for_nps;
            }

            public String getOrder_number() {
                return order_number;
            }

            public void setOrder_number(String order_number) {
                this.order_number = order_number;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getCart_items_total() {
                return cart_items_total;
            }

            public void setCart_items_total(String cart_items_total) {
                this.cart_items_total = cart_items_total;
            }

            public Object getPickup_address() {
                return pickup_address;
            }

            public void setPickup_address(Object pickup_address) {
                this.pickup_address = pickup_address;
            }

            public boolean isPrepaid_availability() {
                return prepaid_availability;
            }

            public void setPrepaid_availability(boolean prepaid_availability) {
                this.prepaid_availability = prepaid_availability;
            }

            public int getRemaining_vcash() {
                return remaining_vcash;
            }

            public void setRemaining_vcash(int remaining_vcash) {
                this.remaining_vcash = remaining_vcash;
            }

            public int getItem_total() {
                return item_total;
            }

            public void setItem_total(int item_total) {
                this.item_total = item_total;
            }

            public VcashDataBeanX getVcash_data() {
                return vcash_data;
            }

            public void setVcash_data(VcashDataBeanX vcash_data) {
                this.vcash_data = vcash_data;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getTotal_income() {
                return total_income;
            }

            public void setTotal_income(int total_income) {
                this.total_income = total_income;
            }

            public String getCoupon_applied_message() {
                return coupon_applied_message;
            }

            public void setCoupon_applied_message(String coupon_applied_message) {
                this.coupon_applied_message = coupon_applied_message;
            }

            public int getSubtotal() {
                return subtotal;
            }

            public void setSubtotal(int subtotal) {
                this.subtotal = subtotal;
            }

            public Object getLast_completed_order() {
                return last_completed_order;
            }

            public void setLast_completed_order(Object last_completed_order) {
                this.last_completed_order = last_completed_order;
            }

            public boolean isCod_availability() {
                return cod_availability;
            }

            public void setCod_availability(boolean cod_availability) {
                this.cod_availability = cod_availability;
            }

            public String getFormatted_total_income() {
                return formatted_total_income;
            }

            public void setFormatted_total_income(String formatted_total_income) {
                this.formatted_total_income = formatted_total_income;
            }

            public String getPayment_method() {
                return payment_method;
            }

            public void setPayment_method(String payment_method) {
                this.payment_method = payment_method;
            }

            public boolean isCode_applied() {
                return code_applied;
            }

            public void setCode_applied(boolean code_applied) {
                this.code_applied = code_applied;
            }

            public LiBySellersBean getLi_by_sellers() {
                return li_by_sellers;
            }

            public void setLi_by_sellers(LiBySellersBean li_by_sellers) {
                this.li_by_sellers = li_by_sellers;
            }

            public List<AdjustmentsBean> getAdjustments() {
                return adjustments;
            }

            public void setAdjustments(List<AdjustmentsBean> adjustments) {
                this.adjustments = adjustments;
            }

            public List<?> getMessages() {
                return messages;
            }

            public void setMessages(List<?> messages) {
                this.messages = messages;
            }

            public List<?> getLastmile_addresses() {
                return lastmile_addresses;
            }

            public void setLastmile_addresses(List<?> lastmile_addresses) {
                this.lastmile_addresses = lastmile_addresses;
            }

            public static class VcashDataBeanX {
                /**
                 * available_vcash : 0
                 * show_vcash_form : true
                 * vcash_already_applied_in_order : 0
                 * approved_vcash : 0
                 */

                private int available_vcash;
                private boolean show_vcash_form;
                private int vcash_already_applied_in_order;
                private int approved_vcash;

                public int getAvailable_vcash() {
                    return available_vcash;
                }

                public void setAvailable_vcash(int available_vcash) {
                    this.available_vcash = available_vcash;
                }

                public boolean isShow_vcash_form() {
                    return show_vcash_form;
                }

                public void setShow_vcash_form(boolean show_vcash_form) {
                    this.show_vcash_form = show_vcash_form;
                }

                public int getVcash_already_applied_in_order() {
                    return vcash_already_applied_in_order;
                }

                public void setVcash_already_applied_in_order(int vcash_already_applied_in_order) {
                    this.vcash_already_applied_in_order = vcash_already_applied_in_order;
                }

                public int getApproved_vcash() {
                    return approved_vcash;
                }

                public void setApproved_vcash(int approved_vcash) {
                    this.approved_vcash = approved_vcash;
                }
            }

            public static class LiBySellersBean {
                /**
                 * BBF : {"adjustments":[],"subtotal":492,"item_total":492,"items":[{"formatted_price":"Tk. 492","seller":"BBF","min_order_qty":1,"line_item_id":299872,"discount":0,"prepaid_availability":true,"seller_slug":"bbf","delivery_time":"Delivery in 5-6 working days.","title":"Men's Stylish Gabardine Pant - Cream 03 - BBF","liked":false,"category_id":1125,"variant_options":[{"count_on_hand":49,"option_value_name":"28","size":5,"corrected_count_on_hand":3,"name":"28","id":5544},{"count_on_hand":43,"option_value_name":"30","size":5,"corrected_count_on_hand":3,"name":"30","id":5546},{"count_on_hand":39,"option_value_name":"32","size":5,"corrected_count_on_hand":3,"name":"32","id":5547},{"count_on_hand":29,"option_value_name":"34","size":5,"corrected_count_on_hand":3,"name":"34","id":5549},{"count_on_hand":39,"option_value_name":"36","size":5,"corrected_count_on_hand":3,"name":"36","id":5550}],"max_item_quantity":50,"price":"492.0","product_id":5377,"sold_out":false,"variant":5549,"formatted_income":null,"mrp_price_line":"Tk. 472 x 1 = Tk. 472","cod_availability":true,"formatted_per_item_total":"Tk. 492","per_item_total":492,"sku":"270635","delivery_time_message":{"message":"Delivery in 5-6 working days.","type":2},"prepaid_message":"Delivery in 5-6 working days.","activity_object":{"activity_object":{"id":"P5377"}},"image":"https://shopimages.vstores.io/7735/1572852365758-new-small.jpg?1580071087","quantity":1,"max_selling_price":747,"original_amo":472,"variant_price":420,"final_discount":0,"formatted_variant_price":null,"price_line":"Tk. 492 x 1 = Tk. 492","product_name":"Men\\'s Stylish Gabardine Pant - Cream 03 - BBF","sale_price":"492.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 492","size":"34","line_item_adjustments":[],"master_product_id":5377,"messages":[],"min_selling_price":492,"category":"Men track pant","permalink":"men-s-stylish-gabardine-pant-cream-03-bbf-42a65ec9","cod_message":"Delivery in 5-6 working days."}]}
                 */

                private BBFBean BBF;

                public BBFBean getBBF() {
                    return BBF;
                }

                public void setBBF(BBFBean BBF) {
                    this.BBF = BBF;
                }

                public static class BBFBean {
                    /**
                     * adjustments : []
                     * subtotal : 492
                     * item_total : 492
                     * items : [{"formatted_price":"Tk. 492","seller":"BBF","min_order_qty":1,"line_item_id":299872,"discount":0,"prepaid_availability":true,"seller_slug":"bbf","delivery_time":"Delivery in 5-6 working days.","title":"Men's Stylish Gabardine Pant - Cream 03 - BBF","liked":false,"category_id":1125,"variant_options":[{"count_on_hand":49,"option_value_name":"28","size":5,"corrected_count_on_hand":3,"name":"28","id":5544},{"count_on_hand":43,"option_value_name":"30","size":5,"corrected_count_on_hand":3,"name":"30","id":5546},{"count_on_hand":39,"option_value_name":"32","size":5,"corrected_count_on_hand":3,"name":"32","id":5547},{"count_on_hand":29,"option_value_name":"34","size":5,"corrected_count_on_hand":3,"name":"34","id":5549},{"count_on_hand":39,"option_value_name":"36","size":5,"corrected_count_on_hand":3,"name":"36","id":5550}],"max_item_quantity":50,"price":"492.0","product_id":5377,"sold_out":false,"variant":5549,"formatted_income":null,"mrp_price_line":"Tk. 472 x 1 = Tk. 472","cod_availability":true,"formatted_per_item_total":"Tk. 492","per_item_total":492,"sku":"270635","delivery_time_message":{"message":"Delivery in 5-6 working days.","type":2},"prepaid_message":"Delivery in 5-6 working days.","activity_object":{"activity_object":{"id":"P5377"}},"image":"https://shopimages.vstores.io/7735/1572852365758-new-small.jpg?1580071087","quantity":1,"max_selling_price":747,"original_amo":472,"variant_price":420,"final_discount":0,"formatted_variant_price":null,"price_line":"Tk. 492 x 1 = Tk. 492","product_name":"Men\\'s Stylish Gabardine Pant - Cream 03 - BBF","sale_price":"492.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 492","size":"34","line_item_adjustments":[],"master_product_id":5377,"messages":[],"min_selling_price":492,"category":"Men track pant","permalink":"men-s-stylish-gabardine-pant-cream-03-bbf-42a65ec9","cod_message":"Delivery in 5-6 working days."}]
                     */

                    private int subtotal;
                    private int item_total;
                    private List<?> adjustments;
                    private List<ItemsBean> items;

                    public int getSubtotal() {
                        return subtotal;
                    }

                    public void setSubtotal(int subtotal) {
                        this.subtotal = subtotal;
                    }

                    public int getItem_total() {
                        return item_total;
                    }

                    public void setItem_total(int item_total) {
                        this.item_total = item_total;
                    }

                    public List<?> getAdjustments() {
                        return adjustments;
                    }

                    public void setAdjustments(List<?> adjustments) {
                        this.adjustments = adjustments;
                    }

                    public List<ItemsBean> getItems() {
                        return items;
                    }

                    public void setItems(List<ItemsBean> items) {
                        this.items = items;
                    }

                    public static class ItemsBean {
                        /**
                         * formatted_price : Tk. 492
                         * seller : BBF
                         * min_order_qty : 1
                         * line_item_id : 299872
                         * discount : 0
                         * prepaid_availability : true
                         * seller_slug : bbf
                         * delivery_time : Delivery in 5-6 working days.
                         * title : Men's Stylish Gabardine Pant - Cream 03 - BBF
                         * liked : false
                         * category_id : 1125
                         * variant_options : [{"count_on_hand":49,"option_value_name":"28","size":5,"corrected_count_on_hand":3,"name":"28","id":5544},{"count_on_hand":43,"option_value_name":"30","size":5,"corrected_count_on_hand":3,"name":"30","id":5546},{"count_on_hand":39,"option_value_name":"32","size":5,"corrected_count_on_hand":3,"name":"32","id":5547},{"count_on_hand":29,"option_value_name":"34","size":5,"corrected_count_on_hand":3,"name":"34","id":5549},{"count_on_hand":39,"option_value_name":"36","size":5,"corrected_count_on_hand":3,"name":"36","id":5550}]
                         * max_item_quantity : 50
                         * price : 492.0
                         * product_id : 5377
                         * sold_out : false
                         * variant : 5549
                         * formatted_income : null
                         * mrp_price_line : Tk. 472 x 1 = Tk. 472
                         * cod_availability : true
                         * formatted_per_item_total : Tk. 492
                         * per_item_total : 492
                         * sku : 270635
                         * delivery_time_message : {"message":"Delivery in 5-6 working days.","type":2}
                         * prepaid_message : Delivery in 5-6 working days.
                         * activity_object : {"activity_object":{"id":"P5377"}}
                         * image : https://shopimages.vstores.io/7735/1572852365758-new-small.jpg?1580071087
                         * quantity : 1
                         * max_selling_price : 747
                         * original_amo : 472
                         * variant_price : 420
                         * final_discount : 0
                         * formatted_variant_price : null
                         * price_line : Tk. 492 x 1 = Tk. 492
                         * product_name : Men\'s Stylish Gabardine Pant - Cream 03 - BBF
                         * sale_price : 492.0
                         * product_stamp : null
                         * zipcode : 7
                         * formatted_seller_price : Tk. 0
                         * formatted_sale_price : Tk. 492
                         * size : 34
                         * line_item_adjustments : []
                         * master_product_id : 5377
                         * messages : []
                         * min_selling_price : 492
                         * category : Men track pant
                         * permalink : men-s-stylish-gabardine-pant-cream-03-bbf-42a65ec9
                         * cod_message : Delivery in 5-6 working days.
                         */

                        private String formatted_price;
                        private String seller;
                        private int min_order_qty;
                        private int line_item_id;
                        private int discount;
                        private boolean prepaid_availability;
                        private String seller_slug;
                        private String delivery_time;
                        private String title;
                        private boolean liked;
                        private int category_id;
                        private int max_item_quantity;
                        private String price;
                        private int product_id;
                        private boolean sold_out;
                        private int variant;
                        private Object formatted_income;
                        private String mrp_price_line;
                        private boolean cod_availability;
                        private String formatted_per_item_total;
                        private int per_item_total;
                        private String sku;
                        private DeliveryTimeMessageBean delivery_time_message;
                        private String prepaid_message;
                        private ActivityObjectBeanX activity_object;
                        private String image;
                        private int quantity;
                        private int max_selling_price;
                        private int original_amo;
                        private int variant_price;
                        private int final_discount;
                        private Object formatted_variant_price;
                        private String price_line;
                        private String product_name;
                        private String sale_price;
                        private Object product_stamp;
                        private String zipcode;
                        private String formatted_seller_price;
                        private String formatted_sale_price;
                        private String size;
                        private int master_product_id;
                        private int min_selling_price;
                        private String category;
                        private String permalink;
                        private String cod_message;
                        private List<VariantOptionsBean> variant_options;
                        private List<?> line_item_adjustments;
                        private List<?> messages;

                        public String getFormatted_price() {
                            return formatted_price;
                        }

                        public void setFormatted_price(String formatted_price) {
                            this.formatted_price = formatted_price;
                        }

                        public String getSeller() {
                            return seller;
                        }

                        public void setSeller(String seller) {
                            this.seller = seller;
                        }

                        public int getMin_order_qty() {
                            return min_order_qty;
                        }

                        public void setMin_order_qty(int min_order_qty) {
                            this.min_order_qty = min_order_qty;
                        }

                        public int getLine_item_id() {
                            return line_item_id;
                        }

                        public void setLine_item_id(int line_item_id) {
                            this.line_item_id = line_item_id;
                        }

                        public int getDiscount() {
                            return discount;
                        }

                        public void setDiscount(int discount) {
                            this.discount = discount;
                        }

                        public boolean isPrepaid_availability() {
                            return prepaid_availability;
                        }

                        public void setPrepaid_availability(boolean prepaid_availability) {
                            this.prepaid_availability = prepaid_availability;
                        }

                        public String getSeller_slug() {
                            return seller_slug;
                        }

                        public void setSeller_slug(String seller_slug) {
                            this.seller_slug = seller_slug;
                        }

                        public String getDelivery_time() {
                            return delivery_time;
                        }

                        public void setDelivery_time(String delivery_time) {
                            this.delivery_time = delivery_time;
                        }

                        public String getTitle() {
                            return title;
                        }

                        public void setTitle(String title) {
                            this.title = title;
                        }

                        public boolean isLiked() {
                            return liked;
                        }

                        public void setLiked(boolean liked) {
                            this.liked = liked;
                        }

                        public int getCategory_id() {
                            return category_id;
                        }

                        public void setCategory_id(int category_id) {
                            this.category_id = category_id;
                        }

                        public int getMax_item_quantity() {
                            return max_item_quantity;
                        }

                        public void setMax_item_quantity(int max_item_quantity) {
                            this.max_item_quantity = max_item_quantity;
                        }

                        public String getPrice() {
                            return price;
                        }

                        public void setPrice(String price) {
                            this.price = price;
                        }

                        public int getProduct_id() {
                            return product_id;
                        }

                        public void setProduct_id(int product_id) {
                            this.product_id = product_id;
                        }

                        public boolean isSold_out() {
                            return sold_out;
                        }

                        public void setSold_out(boolean sold_out) {
                            this.sold_out = sold_out;
                        }

                        public int getVariant() {
                            return variant;
                        }

                        public void setVariant(int variant) {
                            this.variant = variant;
                        }

                        public Object getFormatted_income() {
                            return formatted_income;
                        }

                        public void setFormatted_income(Object formatted_income) {
                            this.formatted_income = formatted_income;
                        }

                        public String getMrp_price_line() {
                            return mrp_price_line;
                        }

                        public void setMrp_price_line(String mrp_price_line) {
                            this.mrp_price_line = mrp_price_line;
                        }

                        public boolean isCod_availability() {
                            return cod_availability;
                        }

                        public void setCod_availability(boolean cod_availability) {
                            this.cod_availability = cod_availability;
                        }

                        public String getFormatted_per_item_total() {
                            return formatted_per_item_total;
                        }

                        public void setFormatted_per_item_total(String formatted_per_item_total) {
                            this.formatted_per_item_total = formatted_per_item_total;
                        }

                        public int getPer_item_total() {
                            return per_item_total;
                        }

                        public void setPer_item_total(int per_item_total) {
                            this.per_item_total = per_item_total;
                        }

                        public String getSku() {
                            return sku;
                        }

                        public void setSku(String sku) {
                            this.sku = sku;
                        }

                        public DeliveryTimeMessageBean getDelivery_time_message() {
                            return delivery_time_message;
                        }

                        public void setDelivery_time_message(DeliveryTimeMessageBean delivery_time_message) {
                            this.delivery_time_message = delivery_time_message;
                        }

                        public String getPrepaid_message() {
                            return prepaid_message;
                        }

                        public void setPrepaid_message(String prepaid_message) {
                            this.prepaid_message = prepaid_message;
                        }

                        public ActivityObjectBeanX getActivity_object() {
                            return activity_object;
                        }

                        public void setActivity_object(ActivityObjectBeanX activity_object) {
                            this.activity_object = activity_object;
                        }

                        public String getImage() {
                            return image;
                        }

                        public void setImage(String image) {
                            this.image = image;
                        }

                        public int getQuantity() {
                            return quantity;
                        }

                        public void setQuantity(int quantity) {
                            this.quantity = quantity;
                        }

                        public int getMax_selling_price() {
                            return max_selling_price;
                        }

                        public void setMax_selling_price(int max_selling_price) {
                            this.max_selling_price = max_selling_price;
                        }

                        public int getOriginal_amo() {
                            return original_amo;
                        }

                        public void setOriginal_amo(int original_amo) {
                            this.original_amo = original_amo;
                        }

                        public int getVariant_price() {
                            return variant_price;
                        }

                        public void setVariant_price(int variant_price) {
                            this.variant_price = variant_price;
                        }

                        public int getFinal_discount() {
                            return final_discount;
                        }

                        public void setFinal_discount(int final_discount) {
                            this.final_discount = final_discount;
                        }

                        public Object getFormatted_variant_price() {
                            return formatted_variant_price;
                        }

                        public void setFormatted_variant_price(Object formatted_variant_price) {
                            this.formatted_variant_price = formatted_variant_price;
                        }

                        public String getPrice_line() {
                            return price_line;
                        }

                        public void setPrice_line(String price_line) {
                            this.price_line = price_line;
                        }

                        public String getProduct_name() {
                            return product_name;
                        }

                        public void setProduct_name(String product_name) {
                            this.product_name = product_name;
                        }

                        public String getSale_price() {
                            return sale_price;
                        }

                        public void setSale_price(String sale_price) {
                            this.sale_price = sale_price;
                        }

                        public Object getProduct_stamp() {
                            return product_stamp;
                        }

                        public void setProduct_stamp(Object product_stamp) {
                            this.product_stamp = product_stamp;
                        }

                        public String getZipcode() {
                            return zipcode;
                        }

                        public void setZipcode(String zipcode) {
                            this.zipcode = zipcode;
                        }

                        public String getFormatted_seller_price() {
                            return formatted_seller_price;
                        }

                        public void setFormatted_seller_price(String formatted_seller_price) {
                            this.formatted_seller_price = formatted_seller_price;
                        }

                        public String getFormatted_sale_price() {
                            return formatted_sale_price;
                        }

                        public void setFormatted_sale_price(String formatted_sale_price) {
                            this.formatted_sale_price = formatted_sale_price;
                        }

                        public String getSize() {
                            return size;
                        }

                        public void setSize(String size) {
                            this.size = size;
                        }

                        public int getMaster_product_id() {
                            return master_product_id;
                        }

                        public void setMaster_product_id(int master_product_id) {
                            this.master_product_id = master_product_id;
                        }

                        public int getMin_selling_price() {
                            return min_selling_price;
                        }

                        public void setMin_selling_price(int min_selling_price) {
                            this.min_selling_price = min_selling_price;
                        }

                        public String getCategory() {
                            return category;
                        }

                        public void setCategory(String category) {
                            this.category = category;
                        }

                        public String getPermalink() {
                            return permalink;
                        }

                        public void setPermalink(String permalink) {
                            this.permalink = permalink;
                        }

                        public String getCod_message() {
                            return cod_message;
                        }

                        public void setCod_message(String cod_message) {
                            this.cod_message = cod_message;
                        }

                        public List<VariantOptionsBean> getVariant_options() {
                            return variant_options;
                        }

                        public void setVariant_options(List<VariantOptionsBean> variant_options) {
                            this.variant_options = variant_options;
                        }

                        public List<?> getLine_item_adjustments() {
                            return line_item_adjustments;
                        }

                        public void setLine_item_adjustments(List<?> line_item_adjustments) {
                            this.line_item_adjustments = line_item_adjustments;
                        }

                        public List<?> getMessages() {
                            return messages;
                        }

                        public void setMessages(List<?> messages) {
                            this.messages = messages;
                        }

                        public static class DeliveryTimeMessageBean {
                            /**
                             * message : Delivery in 5-6 working days.
                             * type : 2
                             */

                            private String message;
                            private int type;

                            public String getMessage() {
                                return message;
                            }

                            public void setMessage(String message) {
                                this.message = message;
                            }

                            public int getType() {
                                return type;
                            }

                            public void setType(int type) {
                                this.type = type;
                            }
                        }

                        public static class ActivityObjectBeanX {
                            /**
                             * activity_object : {"id":"P5377"}
                             */

                            private ActivityObjectBean activity_object;

                            public ActivityObjectBean getActivity_object() {
                                return activity_object;
                            }

                            public void setActivity_object(ActivityObjectBean activity_object) {
                                this.activity_object = activity_object;
                            }

                            public static class ActivityObjectBean {
                                /**
                                 * id : P5377
                                 */

                                private String id;

                                public String getId() {
                                    return id;
                                }

                                public void setId(String id) {
                                    this.id = id;
                                }
                            }
                        }

                        public static class VariantOptionsBean {
                            /**
                             * count_on_hand : 49
                             * option_value_name : 28
                             * size : 5
                             * corrected_count_on_hand : 3
                             * name : 28
                             * id : 5544
                             */

                            private int count_on_hand;
                            private String option_value_name;
                            private int size;
                            private int corrected_count_on_hand;
                            private String name;
                            private int id;

                            public int getCount_on_hand() {
                                return count_on_hand;
                            }

                            public void setCount_on_hand(int count_on_hand) {
                                this.count_on_hand = count_on_hand;
                            }

                            public String getOption_value_name() {
                                return option_value_name;
                            }

                            public void setOption_value_name(String option_value_name) {
                                this.option_value_name = option_value_name;
                            }

                            public int getSize() {
                                return size;
                            }

                            public void setSize(int size) {
                                this.size = size;
                            }

                            public int getCorrected_count_on_hand() {
                                return corrected_count_on_hand;
                            }

                            public void setCorrected_count_on_hand(int corrected_count_on_hand) {
                                this.corrected_count_on_hand = corrected_count_on_hand;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public int getId() {
                                return id;
                            }

                            public void setId(int id) {
                                this.id = id;
                            }
                        }
                    }
                }
            }

            public static class AdjustmentsBean {
                /**
                 * amount : 49
                 * is_seller_coupon : false
                 * is_vcash : false
                 * label : Shipping Charges
                 */

                private int amount;
                private boolean is_seller_coupon;
                private boolean is_vcash;
                private String label;

                public int getAmount() {
                    return amount;
                }

                public void setAmount(int amount) {
                    this.amount = amount;
                }

                public boolean isIs_seller_coupon() {
                    return is_seller_coupon;
                }

                public void setIs_seller_coupon(boolean is_seller_coupon) {
                    this.is_seller_coupon = is_seller_coupon;
                }

                public boolean isIs_vcash() {
                    return is_vcash;
                }

                public void setIs_vcash(boolean is_vcash) {
                    this.is_vcash = is_vcash;
                }

                public String getLabel() {
                    return label;
                }

                public void setLabel(String label) {
                    this.label = label;
                }
            }
        }

        public static class AdjustmentsBeanX {
            /**
             * income : 0
             * is_seller_coupon : false
             * adjustment_type : 6
             * formatted_income : Tk. 0
             * label : Shipping Charges
             * value_amount : 49
             * value : Tk. 49
             * value_currency : INR
             */

            private int income;
            private boolean is_seller_coupon;
            private int adjustment_type;
            private String formatted_income;
            private String label;
            private int value_amount;
            private String value;
            private String value_currency;

            public int getIncome() {
                return income;
            }

            public void setIncome(int income) {
                this.income = income;
            }

            public boolean isIs_seller_coupon() {
                return is_seller_coupon;
            }

            public void setIs_seller_coupon(boolean is_seller_coupon) {
                this.is_seller_coupon = is_seller_coupon;
            }

            public int getAdjustment_type() {
                return adjustment_type;
            }

            public void setAdjustment_type(int adjustment_type) {
                this.adjustment_type = adjustment_type;
            }

            public String getFormatted_income() {
                return formatted_income;
            }

            public void setFormatted_income(String formatted_income) {
                this.formatted_income = formatted_income;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public int getValue_amount() {
                return value_amount;
            }

            public void setValue_amount(int value_amount) {
                this.value_amount = value_amount;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getValue_currency() {
                return value_currency;
            }

            public void setValue_currency(String value_currency) {
                this.value_currency = value_currency;
            }
        }

        public static class CartItemsBean {
            /**
             * formatted_price : Tk. 492
             * seller : BBF
             * min_order_qty : 1
             * line_item_id : 299872
             * discount : 0
             * prepaid_availability : true
             * seller_slug : bbf
             * delivery_time : Delivery in 5-6 working days.
             * title : Men's Stylish Gabardine Pant - Cream 03 - BBF
             * liked : false
             * category_id : 1125
             * variant_options : [{"count_on_hand":49,"option_value_name":"28","size":5,"corrected_count_on_hand":3,"name":"28","id":5544},{"count_on_hand":43,"option_value_name":"30","size":5,"corrected_count_on_hand":3,"name":"30","id":5546},{"count_on_hand":39,"option_value_name":"32","size":5,"corrected_count_on_hand":3,"name":"32","id":5547},{"count_on_hand":29,"option_value_name":"34","size":5,"corrected_count_on_hand":3,"name":"34","id":5549},{"count_on_hand":39,"option_value_name":"36","size":5,"corrected_count_on_hand":3,"name":"36","id":5550}]
             * max_item_quantity : 50
             * price : 492.0
             * product_id : 5377
             * sold_out : false
             * variant : 5549
             * formatted_income : null
             * mrp_price_line : Tk. 472 x 1 = Tk. 472
             * cod_availability : true
             * formatted_per_item_total : Tk. 492
             * per_item_total : 492
             * sku : 270635
             * delivery_time_message : {"message":"Delivery in 5-6 working days.","type":2}
             * prepaid_message : Delivery in 5-6 working days.
             * activity_object : {"activity_object":{"id":"P5377"}}
             * image : https://shopimages.vstores.io/7735/1572852365758-new-small.jpg?1580071087
             * quantity : 1
             * max_selling_price : 747
             * original_amo : 472
             * variant_price : 420
             * final_discount : 0
             * formatted_variant_price : null
             * price_line : Tk. 492 x 1 = Tk. 492
             * product_name : Men\'s Stylish Gabardine Pant - Cream 03 - BBF
             * sale_price : 492.0
             * product_stamp : null
             * zipcode : 7
             * formatted_seller_price : Tk. 0
             * formatted_sale_price : Tk. 492
             * size : 34
             * line_item_adjustments : []
             * master_product_id : 5377
             * messages : []
             * min_selling_price : 492
             * category : Men track pant
             * permalink : men-s-stylish-gabardine-pant-cream-03-bbf-42a65ec9
             * cod_message : Delivery in 5-6 working days.
             */

            private String formatted_price;
            private String seller;
            private int min_order_qty;
            private int line_item_id;
            private int discount;
            private boolean prepaid_availability;
            private String seller_slug;
            private String delivery_time;
            private String title;
            private boolean liked;
            private int category_id;
            private int max_item_quantity;
            private String price;
            private int product_id;
            private boolean sold_out;
            private int variant;
            private Object formatted_income;
            private String mrp_price_line;
            private boolean cod_availability;
            private String formatted_per_item_total;
            private int per_item_total;
            private String sku;
            private DeliveryTimeMessageBeanX delivery_time_message;
            private String prepaid_message;
            private ActivityObjectBeanXXX activity_object;
            private String image;
            private int quantity;
            private int max_selling_price;
            private int original_amo;
            private int variant_price;
            private int final_discount;
            private Object formatted_variant_price;
            private String price_line;
            private String product_name;
            private String sale_price;
            private Object product_stamp;
            private String zipcode;
            private String formatted_seller_price;
            private String formatted_sale_price;
            private String size;
            private int master_product_id;
            private int min_selling_price;
            private String category;
            private String permalink;
            private String cod_message;
            private List<VariantOptionsBeanX> variant_options;
            private List<?> line_item_adjustments;
            private List<?> messages;

            public String getFormatted_price() {
                return formatted_price;
            }

            public void setFormatted_price(String formatted_price) {
                this.formatted_price = formatted_price;
            }

            public String getSeller() {
                return seller;
            }

            public void setSeller(String seller) {
                this.seller = seller;
            }

            public int getMin_order_qty() {
                return min_order_qty;
            }

            public void setMin_order_qty(int min_order_qty) {
                this.min_order_qty = min_order_qty;
            }

            public int getLine_item_id() {
                return line_item_id;
            }

            public void setLine_item_id(int line_item_id) {
                this.line_item_id = line_item_id;
            }

            public int getDiscount() {
                return discount;
            }

            public void setDiscount(int discount) {
                this.discount = discount;
            }

            public boolean isPrepaid_availability() {
                return prepaid_availability;
            }

            public void setPrepaid_availability(boolean prepaid_availability) {
                this.prepaid_availability = prepaid_availability;
            }

            public String getSeller_slug() {
                return seller_slug;
            }

            public void setSeller_slug(String seller_slug) {
                this.seller_slug = seller_slug;
            }

            public String getDelivery_time() {
                return delivery_time;
            }

            public void setDelivery_time(String delivery_time) {
                this.delivery_time = delivery_time;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public boolean isLiked() {
                return liked;
            }

            public void setLiked(boolean liked) {
                this.liked = liked;
            }

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public int getMax_item_quantity() {
                return max_item_quantity;
            }

            public void setMax_item_quantity(int max_item_quantity) {
                this.max_item_quantity = max_item_quantity;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public boolean isSold_out() {
                return sold_out;
            }

            public void setSold_out(boolean sold_out) {
                this.sold_out = sold_out;
            }

            public int getVariant() {
                return variant;
            }

            public void setVariant(int variant) {
                this.variant = variant;
            }

            public Object getFormatted_income() {
                return formatted_income;
            }

            public void setFormatted_income(Object formatted_income) {
                this.formatted_income = formatted_income;
            }

            public String getMrp_price_line() {
                return mrp_price_line;
            }

            public void setMrp_price_line(String mrp_price_line) {
                this.mrp_price_line = mrp_price_line;
            }

            public boolean isCod_availability() {
                return cod_availability;
            }

            public void setCod_availability(boolean cod_availability) {
                this.cod_availability = cod_availability;
            }

            public String getFormatted_per_item_total() {
                return formatted_per_item_total;
            }

            public void setFormatted_per_item_total(String formatted_per_item_total) {
                this.formatted_per_item_total = formatted_per_item_total;
            }

            public int getPer_item_total() {
                return per_item_total;
            }

            public void setPer_item_total(int per_item_total) {
                this.per_item_total = per_item_total;
            }

            public String getSku() {
                return sku;
            }

            public void setSku(String sku) {
                this.sku = sku;
            }

            public DeliveryTimeMessageBeanX getDelivery_time_message() {
                return delivery_time_message;
            }

            public void setDelivery_time_message(DeliveryTimeMessageBeanX delivery_time_message) {
                this.delivery_time_message = delivery_time_message;
            }

            public String getPrepaid_message() {
                return prepaid_message;
            }

            public void setPrepaid_message(String prepaid_message) {
                this.prepaid_message = prepaid_message;
            }

            public ActivityObjectBeanXXX getActivity_object() {
                return activity_object;
            }

            public void setActivity_object(ActivityObjectBeanXXX activity_object) {
                this.activity_object = activity_object;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public int getMax_selling_price() {
                return max_selling_price;
            }

            public void setMax_selling_price(int max_selling_price) {
                this.max_selling_price = max_selling_price;
            }

            public int getOriginal_amo() {
                return original_amo;
            }

            public void setOriginal_amo(int original_amo) {
                this.original_amo = original_amo;
            }

            public int getVariant_price() {
                return variant_price;
            }

            public void setVariant_price(int variant_price) {
                this.variant_price = variant_price;
            }

            public int getFinal_discount() {
                return final_discount;
            }

            public void setFinal_discount(int final_discount) {
                this.final_discount = final_discount;
            }

            public Object getFormatted_variant_price() {
                return formatted_variant_price;
            }

            public void setFormatted_variant_price(Object formatted_variant_price) {
                this.formatted_variant_price = formatted_variant_price;
            }

            public String getPrice_line() {
                return price_line;
            }

            public void setPrice_line(String price_line) {
                this.price_line = price_line;
            }

            public String getProduct_name() {
                return product_name;
            }

            public void setProduct_name(String product_name) {
                this.product_name = product_name;
            }

            public String getSale_price() {
                return sale_price;
            }

            public void setSale_price(String sale_price) {
                this.sale_price = sale_price;
            }

            public Object getProduct_stamp() {
                return product_stamp;
            }

            public void setProduct_stamp(Object product_stamp) {
                this.product_stamp = product_stamp;
            }

            public String getZipcode() {
                return zipcode;
            }

            public void setZipcode(String zipcode) {
                this.zipcode = zipcode;
            }

            public String getFormatted_seller_price() {
                return formatted_seller_price;
            }

            public void setFormatted_seller_price(String formatted_seller_price) {
                this.formatted_seller_price = formatted_seller_price;
            }

            public String getFormatted_sale_price() {
                return formatted_sale_price;
            }

            public void setFormatted_sale_price(String formatted_sale_price) {
                this.formatted_sale_price = formatted_sale_price;
            }

            public String getSize() {
                return size;
            }

            public void setSize(String size) {
                this.size = size;
            }

            public int getMaster_product_id() {
                return master_product_id;
            }

            public void setMaster_product_id(int master_product_id) {
                this.master_product_id = master_product_id;
            }

            public int getMin_selling_price() {
                return min_selling_price;
            }

            public void setMin_selling_price(int min_selling_price) {
                this.min_selling_price = min_selling_price;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getPermalink() {
                return permalink;
            }

            public void setPermalink(String permalink) {
                this.permalink = permalink;
            }

            public String getCod_message() {
                return cod_message;
            }

            public void setCod_message(String cod_message) {
                this.cod_message = cod_message;
            }

            public List<VariantOptionsBeanX> getVariant_options() {
                return variant_options;
            }

            public void setVariant_options(List<VariantOptionsBeanX> variant_options) {
                this.variant_options = variant_options;
            }

            public List<?> getLine_item_adjustments() {
                return line_item_adjustments;
            }

            public void setLine_item_adjustments(List<?> line_item_adjustments) {
                this.line_item_adjustments = line_item_adjustments;
            }

            public List<?> getMessages() {
                return messages;
            }

            public void setMessages(List<?> messages) {
                this.messages = messages;
            }

            public static class DeliveryTimeMessageBeanX {
                /**
                 * message : Delivery in 5-6 working days.
                 * type : 2
                 */

                private String message;
                private int type;

                public String getMessage() {
                    return message;
                }

                public void setMessage(String message) {
                    this.message = message;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }
            }

            public static class ActivityObjectBeanXXX {
                /**
                 * activity_object : {"id":"P5377"}
                 */

                private ActivityObjectBeanXX activity_object;

                public ActivityObjectBeanXX getActivity_object() {
                    return activity_object;
                }

                public void setActivity_object(ActivityObjectBeanXX activity_object) {
                    this.activity_object = activity_object;
                }

                public static class ActivityObjectBeanXX {
                    /**
                     * id : P5377
                     */

                    private String id;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }
                }
            }

            public static class VariantOptionsBeanX {
                /**
                 * count_on_hand : 49
                 * option_value_name : 28
                 * size : 5
                 * corrected_count_on_hand : 3
                 * name : 28
                 * id : 5544
                 */

                private int count_on_hand;
                private String option_value_name;
                private int size;
                private int corrected_count_on_hand;
                private String name;
                private int id;

                public int getCount_on_hand() {
                    return count_on_hand;
                }

                public void setCount_on_hand(int count_on_hand) {
                    this.count_on_hand = count_on_hand;
                }

                public String getOption_value_name() {
                    return option_value_name;
                }

                public void setOption_value_name(String option_value_name) {
                    this.option_value_name = option_value_name;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public int getCorrected_count_on_hand() {
                    return corrected_count_on_hand;
                }

                public void setCorrected_count_on_hand(int corrected_count_on_hand) {
                    this.corrected_count_on_hand = corrected_count_on_hand;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }
            }
        }

        public static class PaymentMethodsBean {
            /**
             * payment_method : {"account_id":0,"code":null,"name":"payu_redirect","rank":100,"id":7,"vaccount_id":1,"display_name":null,"is_default":false}
             */

            private PaymentMethodBean payment_method;

            public PaymentMethodBean getPayment_method() {
                return payment_method;
            }

            public void setPayment_method(PaymentMethodBean payment_method) {
                this.payment_method = payment_method;
            }

            public static class PaymentMethodBean {
                /**
                 * account_id : 0
                 * code : null
                 * name : payu_redirect
                 * rank : 100
                 * id : 7
                 * vaccount_id : 1
                 * display_name : null
                 * is_default : false
                 */

                private int account_id;
                private Object code;
                private String name;
                private int rank;
                private int id;
                private int vaccount_id;
                private Object display_name;
                private boolean is_default;

                public int getAccount_id() {
                    return account_id;
                }

                public void setAccount_id(int account_id) {
                    this.account_id = account_id;
                }

                public Object getCode() {
                    return code;
                }

                public void setCode(Object code) {
                    this.code = code;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getRank() {
                    return rank;
                }

                public void setRank(int rank) {
                    this.rank = rank;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getVaccount_id() {
                    return vaccount_id;
                }

                public void setVaccount_id(int vaccount_id) {
                    this.vaccount_id = vaccount_id;
                }

                public Object getDisplay_name() {
                    return display_name;
                }

                public void setDisplay_name(Object display_name) {
                    this.display_name = display_name;
                }

                public boolean isIs_default() {
                    return is_default;
                }

                public void setIs_default(boolean is_default) {
                    this.is_default = is_default;
                }
            }
        }

        public static class NonCodAdjustmentsBean {
            /**
             * adjustment_type : 6
             * label : Shipping Charges
             * value_amount : 49
             * value_currency : INR
             */

            private int adjustment_type;
            private String label;
            private int value_amount;
            private String value_currency;

            public int getAdjustment_type() {
                return adjustment_type;
            }

            public void setAdjustment_type(int adjustment_type) {
                this.adjustment_type = adjustment_type;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public int getValue_amount() {
                return value_amount;
            }

            public void setValue_amount(int value_amount) {
                this.value_amount = value_amount;
            }

            public String getValue_currency() {
                return value_currency;
            }

            public void setValue_currency(String value_currency) {
                this.value_currency = value_currency;
            }
        }
    }

    public static class ShipAddressBean {
        /**
         * address : {"country":"INDIA","firstname":"Ashok","address2":"Banglore","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":null,"id":9122876,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1}
         */

        private AddressBean address;

        public AddressBean getAddress() {
            return address;
        }

        public void setAddress(AddressBean address) {
            this.address = address;
        }

        public static class AddressBean {
            /**
             * country : INDIA
             * firstname : Ashok
             * address2 : Banglore
             * city : Adabor, Dhaka
             * alternative_phone : null
             * address1 : Shopup street
             * lastname :
             * zipcode : 7
             * is_saved : null
             * user_id : 122694
             * phone : 8801877755590
             * company : null
             * id : 9122876
             * state : Andhra Pradesh
             * state_id : 34
             * landmark :
             * country_id : 1
             */

            private String country;
            private String firstname;
            private String address2;
            private String city;
            private Object alternative_phone;
            private String address1;
            private String lastname;
            private String zipcode;
            private Object is_saved;
            private int user_id;
            private String phone;
            private Object company;
            private int id;
            private String state;
            private int state_id;
            private String landmark;
            private int country_id;

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getFirstname() {
                return firstname;
            }

            public void setFirstname(String firstname) {
                this.firstname = firstname;
            }

            public String getAddress2() {
                return address2;
            }

            public void setAddress2(String address2) {
                this.address2 = address2;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public Object getAlternative_phone() {
                return alternative_phone;
            }

            public void setAlternative_phone(Object alternative_phone) {
                this.alternative_phone = alternative_phone;
            }

            public String getAddress1() {
                return address1;
            }

            public void setAddress1(String address1) {
                this.address1 = address1;
            }

            public String getLastname() {
                return lastname;
            }

            public void setLastname(String lastname) {
                this.lastname = lastname;
            }

            public String getZipcode() {
                return zipcode;
            }

            public void setZipcode(String zipcode) {
                this.zipcode = zipcode;
            }

            public Object getIs_saved() {
                return is_saved;
            }

            public void setIs_saved(Object is_saved) {
                this.is_saved = is_saved;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public Object getCompany() {
                return company;
            }

            public void setCompany(Object company) {
                this.company = company;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public int getState_id() {
                return state_id;
            }

            public void setState_id(int state_id) {
                this.state_id = state_id;
            }

            public String getLandmark() {
                return landmark;
            }

            public void setLandmark(String landmark) {
                this.landmark = landmark;
            }

            public int getCountry_id() {
                return country_id;
            }

            public void setCountry_id(int country_id) {
                this.country_id = country_id;
            }
        }
    }

    public static class UserBeanX {
        /**
         * user : {"email":"iamasthme@gmail.com","name":"Ataur"}
         */

        private UserBean user;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * email : iamasthme@gmail.com
             * name : Ataur
             */

            private String email;
            private String name;

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class CountryListBean {
        /**
         * code : IN
         * flag : https://images1.voonik.com/assets/flags/india.svg
         * currency_unicode : Tk.
         * updated_at : 2018-01-22T15:30:20.000+05:30
         * extra_data :
         * name : INDIA
         * created_at : null
         * currency : Tk.
         * id : 1
         * conversion_rate : 1
         * currency_code : BDT
         * status : active
         */

        private String code;
        private String flag;
        private String currency_unicode;
        private String updated_at;
        private String extra_data;
        private String name;
        private Object created_at;
        private String currency;
        private int id;
        private Object conversion_rate;
        private String currency_code;
        private String status;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public String getCurrency_unicode() {
            return currency_unicode;
        }

        public void setCurrency_unicode(String currency_unicode) {
            this.currency_unicode = currency_unicode;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getExtra_data() {
            return extra_data;
        }

        public void setExtra_data(String extra_data) {
            this.extra_data = extra_data;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getCreated_at() {
            return created_at;
        }

        public void setCreated_at(Object created_at) {
            this.created_at = created_at;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getConversion_rate() {
            return conversion_rate;
        }

        public void setConversion_rate(Object conversion_rate) {
            this.conversion_rate = conversion_rate;
        }

        public String getCurrency_code() {
            return currency_code;
        }

        public void setCurrency_code(String currency_code) {
            this.currency_code = currency_code;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public static class ShippedAddressesBean {
        /**
         * country : INDIA
         * firstname : Ashok
         * address2 : Banglore
         * city : Adabor, Dhaka
         * alternative_phone : null
         * address1 : Shopup street
         * lastname :
         * zipcode : 7
         * is_saved : null
         * user_id : 122694
         * phone : 8801877755590
         * company : null
         * id : 9122876
         * state : Andhra Pradesh
         * state_id : 34
         * landmark :
         * country_id : 1
         */

        private String country;
        private String firstname;
        private String address2;
        private String city;
        private Object alternative_phone;
        private String address1;
        private String lastname;
        private String zipcode;
        private Object is_saved;
        private int user_id;
        private String phone;
        private Object company;
        private int id;
        private String state;
        private int state_id;
        private String landmark;
        private int country_id;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Object getAlternative_phone() {
            return alternative_phone;
        }

        public void setAlternative_phone(Object alternative_phone) {
            this.alternative_phone = alternative_phone;
        }

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public Object getIs_saved() {
            return is_saved;
        }

        public void setIs_saved(Object is_saved) {
            this.is_saved = is_saved;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Object getCompany() {
            return company;
        }

        public void setCompany(Object company) {
            this.company = company;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getState_id() {
            return state_id;
        }

        public void setState_id(int state_id) {
            this.state_id = state_id;
        }

        public String getLandmark() {
            return landmark;
        }

        public void setLandmark(String landmark) {
            this.landmark = landmark;
        }

        public int getCountry_id() {
            return country_id;
        }

        public void setCountry_id(int country_id) {
            this.country_id = country_id;
        }
    }
}
