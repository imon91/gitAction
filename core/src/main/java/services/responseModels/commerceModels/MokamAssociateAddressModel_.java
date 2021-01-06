package services.responseModels.commerceModels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MokamAssociateAddressModel_ {

    private boolean check_duplicate_order;
    private boolean coupon_code_applied;
    private boolean disable_cart_purchase;
    private String disable_cart_timer;
    private MokamAssociateAddressModel.EnableMandatorySignInBean enable_mandatory_sign_in;
    private boolean enable_online_payment_banner;
    private boolean enable_prepaid_retry;
    private MokamAssociateAddressModel.EnablePrimoCartPopupBean enable_primo_cart_popup;
    private boolean enable_remove_coupon;
    @SerializedName("is_gamified_order?")
    private boolean _$Is_gamified_order221; // FIXME check this code
    private String juspay_merchant_id;
    private int maximum_delivery_charge;
    private String message;
    private int minimum_delivery_charge;
    private String online_payment_banner_link;
    private MokamAssociateAddressModel.OrderAddressBean order_address;
    private MokamAssociateAddressModel.OrderDataBean order_data;
    private MokamAssociateAddressModel.PaymentPendingOrdersBean payment_pending_orders;
    private MokamAssociateAddressModel.PrepaidMessageConfigBean prepaid_message_config;
    private String prepaid_order_message;
    private String prepaid_preference_message;
    private String prepaid_retry_message;
    private MokamAssociateAddressModel.PrimoCartImagesBean primo_cart_images;
    private String retry_message_for_close_popup;
    private MokamAssociateAddressModel.ShipAddressBean ship_address;
    private String shop_name;
    private boolean show_pdp_link_in_address_page;
    private boolean show_saved_cards;
    private boolean signed_in_user;
    private boolean single_step_checkout;
    private MokamAssociateAddressModel.SpecialInstructionsBean special_instructions;
    private int status;
    private boolean user_email_valid;
    private List<?> cart_items;
    private List<MokamAssociateAddressModel.CountryListBean> country_list;
    private List<?> coupon_applied;
    private List<?> coupon_display_messages;
    private List<?> payment_types;
    private List<?> serviceable_line_items;
    private List<MokamAssociateAddressModel.ShippedAddressesBean> shipped_addresses;

    public boolean isCheck_duplicate_order() {
        return check_duplicate_order;
    }

    public void setCheck_duplicate_order(boolean check_duplicate_order) {
        this.check_duplicate_order = check_duplicate_order;
    }

    public boolean isCoupon_code_applied() {
        return coupon_code_applied;
    }

    public void setCoupon_code_applied(boolean coupon_code_applied) {
        this.coupon_code_applied = coupon_code_applied;
    }

    public boolean isDisable_cart_purchase() {
        return disable_cart_purchase;
    }

    public void setDisable_cart_purchase(boolean disable_cart_purchase) {
        this.disable_cart_purchase = disable_cart_purchase;
    }

    public String getDisable_cart_timer() {
        return disable_cart_timer;
    }

    public void setDisable_cart_timer(String disable_cart_timer) {
        this.disable_cart_timer = disable_cart_timer;
    }

    public MokamAssociateAddressModel.EnableMandatorySignInBean getEnable_mandatory_sign_in() {
        return enable_mandatory_sign_in;
    }

    public void setEnable_mandatory_sign_in(MokamAssociateAddressModel.EnableMandatorySignInBean enable_mandatory_sign_in) {
        this.enable_mandatory_sign_in = enable_mandatory_sign_in;
    }

    public boolean isEnable_online_payment_banner() {
        return enable_online_payment_banner;
    }

    public void setEnable_online_payment_banner(boolean enable_online_payment_banner) {
        this.enable_online_payment_banner = enable_online_payment_banner;
    }

    public boolean isEnable_prepaid_retry() {
        return enable_prepaid_retry;
    }

    public void setEnable_prepaid_retry(boolean enable_prepaid_retry) {
        this.enable_prepaid_retry = enable_prepaid_retry;
    }

    public MokamAssociateAddressModel.EnablePrimoCartPopupBean getEnable_primo_cart_popup() {
        return enable_primo_cart_popup;
    }

    public void setEnable_primo_cart_popup(MokamAssociateAddressModel.EnablePrimoCartPopupBean enable_primo_cart_popup) {
        this.enable_primo_cart_popup = enable_primo_cart_popup;
    }

    public boolean isEnable_remove_coupon() {
        return enable_remove_coupon;
    }

    public void setEnable_remove_coupon(boolean enable_remove_coupon) {
        this.enable_remove_coupon = enable_remove_coupon;
    }

    public boolean is_$Is_gamified_order221() {
        return _$Is_gamified_order221;
    }

    public void set_$Is_gamified_order221(boolean _$Is_gamified_order221) {
        this._$Is_gamified_order221 = _$Is_gamified_order221;
    }

    public String getJuspay_merchant_id() {
        return juspay_merchant_id;
    }

    public void setJuspay_merchant_id(String juspay_merchant_id) {
        this.juspay_merchant_id = juspay_merchant_id;
    }

    public int getMaximum_delivery_charge() {
        return maximum_delivery_charge;
    }

    public void setMaximum_delivery_charge(int maximum_delivery_charge) {
        this.maximum_delivery_charge = maximum_delivery_charge;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getMinimum_delivery_charge() {
        return minimum_delivery_charge;
    }

    public void setMinimum_delivery_charge(int minimum_delivery_charge) {
        this.minimum_delivery_charge = minimum_delivery_charge;
    }

    public String getOnline_payment_banner_link() {
        return online_payment_banner_link;
    }

    public void setOnline_payment_banner_link(String online_payment_banner_link) {
        this.online_payment_banner_link = online_payment_banner_link;
    }

    public MokamAssociateAddressModel.OrderAddressBean getOrder_address() {
        return order_address;
    }

    public void setOrder_address(MokamAssociateAddressModel.OrderAddressBean order_address) {
        this.order_address = order_address;
    }

    public MokamAssociateAddressModel.OrderDataBean getOrder_data() {
        return order_data;
    }

    public void setOrder_data(MokamAssociateAddressModel.OrderDataBean order_data) {
        this.order_data = order_data;
    }

    public MokamAssociateAddressModel.PaymentPendingOrdersBean getPayment_pending_orders() {
        return payment_pending_orders;
    }

    public void setPayment_pending_orders(MokamAssociateAddressModel.PaymentPendingOrdersBean payment_pending_orders) {
        this.payment_pending_orders = payment_pending_orders;
    }

    public MokamAssociateAddressModel.PrepaidMessageConfigBean getPrepaid_message_config() {
        return prepaid_message_config;
    }

    public void setPrepaid_message_config(MokamAssociateAddressModel.PrepaidMessageConfigBean prepaid_message_config) {
        this.prepaid_message_config = prepaid_message_config;
    }

    public String getPrepaid_order_message() {
        return prepaid_order_message;
    }

    public void setPrepaid_order_message(String prepaid_order_message) {
        this.prepaid_order_message = prepaid_order_message;
    }

    public String getPrepaid_preference_message() {
        return prepaid_preference_message;
    }

    public void setPrepaid_preference_message(String prepaid_preference_message) {
        this.prepaid_preference_message = prepaid_preference_message;
    }

    public String getPrepaid_retry_message() {
        return prepaid_retry_message;
    }

    public void setPrepaid_retry_message(String prepaid_retry_message) {
        this.prepaid_retry_message = prepaid_retry_message;
    }

    public MokamAssociateAddressModel.PrimoCartImagesBean getPrimo_cart_images() {
        return primo_cart_images;
    }

    public void setPrimo_cart_images(MokamAssociateAddressModel.PrimoCartImagesBean primo_cart_images) {
        this.primo_cart_images = primo_cart_images;
    }

    public String getRetry_message_for_close_popup() {
        return retry_message_for_close_popup;
    }

    public void setRetry_message_for_close_popup(String retry_message_for_close_popup) {
        this.retry_message_for_close_popup = retry_message_for_close_popup;
    }

    public MokamAssociateAddressModel.ShipAddressBean getShip_address() {
        return ship_address;
    }

    public void setShip_address(MokamAssociateAddressModel.ShipAddressBean ship_address) {
        this.ship_address = ship_address;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public boolean isShow_pdp_link_in_address_page() {
        return show_pdp_link_in_address_page;
    }

    public void setShow_pdp_link_in_address_page(boolean show_pdp_link_in_address_page) {
        this.show_pdp_link_in_address_page = show_pdp_link_in_address_page;
    }

    public boolean isShow_saved_cards() {
        return show_saved_cards;
    }

    public void setShow_saved_cards(boolean show_saved_cards) {
        this.show_saved_cards = show_saved_cards;
    }

    public boolean isSigned_in_user() {
        return signed_in_user;
    }

    public void setSigned_in_user(boolean signed_in_user) {
        this.signed_in_user = signed_in_user;
    }

    public boolean isSingle_step_checkout() {
        return single_step_checkout;
    }

    public void setSingle_step_checkout(boolean single_step_checkout) {
        this.single_step_checkout = single_step_checkout;
    }

    public MokamAssociateAddressModel.SpecialInstructionsBean getSpecial_instructions() {
        return special_instructions;
    }

    public void setSpecial_instructions(MokamAssociateAddressModel.SpecialInstructionsBean special_instructions) {
        this.special_instructions = special_instructions;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isUser_email_valid() {
        return user_email_valid;
    }

    public void setUser_email_valid(boolean user_email_valid) {
        this.user_email_valid = user_email_valid;
    }

    public List<?> getCart_items() {
        return cart_items;
    }

    public void setCart_items(List<?> cart_items) {
        this.cart_items = cart_items;
    }

    public List<MokamAssociateAddressModel.CountryListBean> getCountry_list() {
        return country_list;
    }

    public void setCountry_list(List<MokamAssociateAddressModel.CountryListBean> country_list) {
        this.country_list = country_list;
    }

    public List<?> getCoupon_applied() {
        return coupon_applied;
    }

    public void setCoupon_applied(List<?> coupon_applied) {
        this.coupon_applied = coupon_applied;
    }

    public List<?> getCoupon_display_messages() {
        return coupon_display_messages;
    }

    public void setCoupon_display_messages(List<?> coupon_display_messages) {
        this.coupon_display_messages = coupon_display_messages;
    }

    public List<?> getPayment_types() {
        return payment_types;
    }

    public void setPayment_types(List<?> payment_types) {
        this.payment_types = payment_types;
    }

    public List<?> getServiceable_line_items() {
        return serviceable_line_items;
    }

    public void setServiceable_line_items(List<?> serviceable_line_items) {
        this.serviceable_line_items = serviceable_line_items;
    }

    public List<MokamAssociateAddressModel.ShippedAddressesBean> getShipped_addresses() {
        return shipped_addresses;
    }

    public void setShipped_addresses(List<MokamAssociateAddressModel.ShippedAddressesBean> shipped_addresses) {
        this.shipped_addresses = shipped_addresses;
    }

    public static class EnableMandatorySignInBean {
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

    public static class EnablePrimoCartPopupBean {
        private int primo_amount;
        private boolean wap_add_default;
        private boolean wap_less_amount;
        private boolean wap_signed;

        public int getPrimo_amount() {
            return primo_amount;
        }

        public void setPrimo_amount(int primo_amount) {
            this.primo_amount = primo_amount;
        }

        public boolean isWap_add_default() {
            return wap_add_default;
        }

        public void setWap_add_default(boolean wap_add_default) {
            this.wap_add_default = wap_add_default;
        }

        public boolean isWap_less_amount() {
            return wap_less_amount;
        }

        public void setWap_less_amount(boolean wap_less_amount) {
            this.wap_less_amount = wap_less_amount;
        }

        public boolean isWap_signed() {
            return wap_signed;
        }

        public void setWap_signed(boolean wap_signed) {
            this.wap_signed = wap_signed;
        }
    }

    public static class OrderAddressBean {
        private MokamAssociateAddressModel.OrderAddressBean.AddressBean address;

        public MokamAssociateAddressModel.OrderAddressBean.AddressBean getAddress() {
            return address;
        }

        public void setAddress(MokamAssociateAddressModel.OrderAddressBean.AddressBean address) {
            this.address = address;
        }

        public static class AddressBean {
            private String address1;
            private String address2;
            private String alternative_phone;
            private String city;
            private String company;
            private int country_id;
            private String created_at;
            private String firstname;
            private int id;
            private String landmark;
            private String lastname;
            private String phone;
            private int state_id;
            private String state_name;
            private String updated_at;
            private int user_address_id;
            private int vaccount_id;
            private String zipcode;

            public String getAddress1() {
                return address1;
            }

            public void setAddress1(String address1) {
                this.address1 = address1;
            }

            public String getAddress2() {
                return address2;
            }

            public void setAddress2(String address2) {
                this.address2 = address2;
            }

            public String getAlternative_phone() {
                return alternative_phone;
            }

            public void setAlternative_phone(String alternative_phone) {
                this.alternative_phone = alternative_phone;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public int getCountry_id() {
                return country_id;
            }

            public void setCountry_id(int country_id) {
                this.country_id = country_id;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getFirstname() {
                return firstname;
            }

            public void setFirstname(String firstname) {
                this.firstname = firstname;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLandmark() {
                return landmark;
            }

            public void setLandmark(String landmark) {
                this.landmark = landmark;
            }

            public String getLastname() {
                return lastname;
            }

            public void setLastname(String lastname) {
                this.lastname = lastname;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public int getState_id() {
                return state_id;
            }

            public void setState_id(int state_id) {
                this.state_id = state_id;
            }

            public String getState_name() {
                return state_name;
            }

            public void setState_name(String state_name) {
                this.state_name = state_name;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }

            public int getUser_address_id() {
                return user_address_id;
            }

            public void setUser_address_id(int user_address_id) {
                this.user_address_id = user_address_id;
            }

            public int getVaccount_id() {
                return vaccount_id;
            }

            public void setVaccount_id(int vaccount_id) {
                this.vaccount_id = vaccount_id;
            }

            public String getZipcode() {
                return zipcode;
            }

            public void setZipcode(String zipcode) {
                this.zipcode = zipcode;
            }
        }
    }

    public static class OrderDataBean {

        /**
         * adjustments : [{"amount":50,"is_seller_coupon":false,"is_vcash":false,"label":"Shipping Charges"}]
         * cart_items_total : 8162.63
         * cod_availability : true
         * code_applied : false
         * count : 5
         * coupon_applied_message : The coupon code is applied
         * error_message : 0
         * formatted_total_income : Tk. 0.00
         * item_total : 8162.63
         * lastmile_addresses : []
         * li_by_sellers : {"Unbranded":{"adjustments":[],"item_total":1541,"items":[{"activity_object":{"activity_object":{"id":"P413210"}},"category":"Rice","category_id":2186,"cod_availability":true,"cod_message":"Delivery in 5-15 working days.","delivery_time":"Delivery in 5-15 working days.","delivery_time_message":{"message":"Delivery in 5-15 working days.","type":2},"discount":0,"final_discount":0,"formatted_income":"Tk. 0.00","formatted_per_item_total":"Tk. 1,541.00","formatted_price":"Tk. 1,541.00","formatted_sale_price":"Tk. 1,541.00","formatted_seller_price":"Tk. 0.00","formatted_variant_price":"Tk. 1,541.00","image":"https://shopimages.vstores.io/uc/832364/Lalon-Special-Miniket-Rice---25-kg-small.jpg?1591772277","is_free_item":false,"liked":false,"line_item_adjustments":[],"line_item_id":308990,"master_product_id":413210,"max_item_quantity":50,"max_selling_price":0,"messages":[],"min_order_qty":1,"min_selling_price":0,"mrp_price_line":"Tk. 1,541.00 x 1 = Tk. 1,541.00","original_amo":1541,"per_item_total":1541,"permalink":"lalon-special-miniket-rice-25-kg-8242dbfa","prepaid_availability":true,"prepaid_message":"Delivery in 5-15 working days.","price":1541,"price_line":"Tk. 1,541.00 x 1 = Tk. 1,541.00","product_id":413210,"product_name":"Lalon Special Miniket Rice - 25 kg","quantity":1,"sale_price":1541,"seller":"Unbranded","seller_slug":"unbranded","size":"25 kg","sku":"Lalon-Special-Miniket-Rice---25-kg---a027b146","slug":"lalon-special-miniket-rice-25-kg-shopup-59a5de5e","sold_out":false,"title":"Lalon Special Miniket Rice - 25 kg","variant":523685,"variant_options":[{"corrected_count_on_hand":3,"count_on_hand":11109,"id":523685,"name":"25 kg","option_value_name":"25 kg","size":5}],"variant_price":1541,"zipcode":"934"}],"subtotal":1541},"Unicorn":{"adjustments":[{"amount":580,"is_seller_coupon":false,"is_vcash":false,"label":"Shipping Charges"}],"item_total":6621.63,"items":[{"activity_object":{"activity_object":{"id":"P414699"}},"category":"Personal care essential","category_id":2243,"cod_availability":true,"cod_message":"Delivery in 5-15 working days.","delivery_time":"Delivery in 5-15 working days.","delivery_time_message":{"message":"Delivery in 5-15 working days.","type":2},"discount":0,"final_discount":0,"formatted_income":"Tk. 0.00","formatted_per_item_total":"Tk. 725.00","formatted_price":"Tk. 58.50","formatted_sale_price":"Tk. 585.00","formatted_seller_price":"Tk. 0.00","formatted_variant_price":"Tk. 58.50","image":"https://shopimages.vstores.io/uc/140564/Dettol-Handwash-170-ml-Refill-Poly-Re-energize_1-small.jpg?1591893674","is_free_item":false,"liked":false,"line_item_adjustments":[{"account_id":0,"adjustment_type":2,"amount":"140.0","created_at":"2020-12-08T14:21:35.000+06:00","eligible":true,"formatted_amount":"Tk. 140.00","id":10665,"income":0,"is_seller_coupon":false,"label":"Shipping Charges","line_item_id":308989,"order_id":148415,"result_2":0,"result_3":0,"seller_id":287000412,"updated_at":"2020-12-08T14:21:35.000+06:00","vaccount_id":2}],"line_item_id":308989,"master_product_id":414699,"max_item_quantity":50,"max_selling_price":0,"messages":[],"min_order_qty":1,"min_selling_price":0,"mrp_price_line":"Tk. 58.50 x 10 = Tk. 585.00","original_amo":58.5,"per_item_total":725,"permalink":"detol-hw-poly-170-ml-re-ener-new-rate-40bebb33","prepaid_availability":true,"prepaid_message":"Delivery in 5-15 working days.","price":58.5,"price_line":"Tk. 58.50 x 10 = Tk. 585.00","product_id":414699,"product_name":"Dettol,Hw Poly 170 Ml Re-Ener- New Rate","quantity":10,"sale_price":585,"seller":"Unicorn","seller_slug":"unicorn","size":"170ml","sku":"Detol,Hw-Poly-170-Ml-Re-Ener--New-Rate---87bea10d","slug":"detol-hw-poly-170-ml-re-ener-new-rate-shopup-05bfce45","sold_out":false,"title":"Dettol,Hw Poly 170 Ml Re-Ener- New Rate","variant":526050,"variant_options":[{"corrected_count_on_hand":3,"count_on_hand":989,"id":526050,"name":"170ml","option_value_name":"170ml","size":5}],"variant_price":58.5,"zipcode":"934"},{"activity_object":{"activity_object":{"id":"P414697"}},"category":"Floor cleaner","category_id":2160,"cod_availability":true,"cod_message":"Delivery in 5-15 working days.","delivery_time":"Delivery in 5-15 working days.","delivery_time_message":{"message":"Delivery in 5-15 working days.","type":2},"discount":0,"final_discount":0,"formatted_income":"Tk. 0.00","formatted_per_item_total":"Tk. 6,134.00","formatted_price":"Tk. 210.50","formatted_sale_price":"Tk. 5,894.00","formatted_seller_price":"Tk. 0.00","formatted_variant_price":"Tk. 210.50","image":"https://shopimages.vstores.io/uc/930564/lizol_floor_cleaner_citrus_disinfectant_surface_cleaner_975ml_1-small.jpg?1591893670","is_free_item":false,"liked":false,"line_item_adjustments":[{"account_id":0,"adjustment_type":2,"amount":"240.0","created_at":"2020-12-08T14:21:35.000+06:00","eligible":true,"formatted_amount":"Tk. 240.00","id":10664,"income":0,"is_seller_coupon":false,"label":"Shipping Charges","line_item_id":308988,"order_id":148415,"result_2":0,"result_3":0,"seller_id":287000412,"updated_at":"2020-12-08T14:21:35.000+06:00","vaccount_id":2}],"line_item_id":308988,"master_product_id":414697,"max_item_quantity":50,"max_selling_price":0,"messages":[],"min_order_qty":1,"min_selling_price":0,"mrp_price_line":"Tk. 220.00 x 28 = Tk. 6,160.00","original_amo":220,"per_item_total":6134,"permalink":"lizol-975-ml-citrus-ih-new-rat-bb8d61c6","prepaid_availability":true,"prepaid_message":"Delivery in 5-15 working days.","price":210.5,"price_line":"Tk. 210.50 x 28 = Tk. 5,894.00","product_id":414697,"product_name":"Lizol 975 Ml - Citrus - Ih - New Rat","quantity":28,"sale_price":5894,"seller":"Unicorn","seller_slug":"unicorn","size":"975ml","sku":"Lizol-975-Ml---Citrus---Ih---New-Rat---ca165571","slug":"lizol-975-ml-citrus-ih-new-rat-shopup-7805faf6","sold_out":false,"title":"Lizol 975 Ml - Citrus - Ih - New Rat","variant":526040,"variant_options":[{"corrected_count_on_hand":3,"count_on_hand":947,"id":526040,"name":"975ml","option_value_name":"975ml","size":5}],"variant_price":210.5,"zipcode":"934"},{"activity_object":{"activity_object":{"id":"P414698"}},"category":"Personal care essential","category_id":2243,"cod_availability":true,"cod_message":"Delivery in 5-15 working days.","delivery_time":"Delivery in 5-15 working days.","delivery_time_message":{"message":"Delivery in 5-15 working days.","type":2},"discount":0,"final_discount":0,"formatted_income":"Tk. 0.00","formatted_per_item_total":"Tk. 134.52","formatted_price":"Tk. 34.52","formatted_sale_price":"Tk. 34.52","formatted_seller_price":"Tk. 0.00","formatted_variant_price":"Tk. 34.52","image":"https://shopimages.vstores.io/uc/040564/Dettol-Liquid-50-Ml---New-Rate-small.jpg?1591893672","is_free_item":false,"liked":false,"line_item_adjustments":[{"account_id":0,"adjustment_type":2,"amount":"100.0","created_at":"2020-12-08T14:21:35.000+06:00","eligible":true,"formatted_amount":"Tk. 100.00","id":10663,"income":0,"is_seller_coupon":false,"label":"Shipping Charges","line_item_id":308987,"order_id":148415,"result_2":0,"result_3":0,"seller_id":287000412,"updated_at":"2020-12-08T14:21:35.000+06:00","vaccount_id":2}],"line_item_id":308987,"master_product_id":414698,"max_item_quantity":50,"max_selling_price":0,"messages":[],"min_order_qty":1,"min_selling_price":0,"mrp_price_line":"Tk. 34.52 x 1 = Tk. 34.52","original_amo":34.52,"per_item_total":134.52,"permalink":"dettol-liquid-50-ml-new-rate-6d8bfe5b","prepaid_availability":true,"prepaid_message":"Delivery in 5-15 working days.","price":34.52,"price_line":"Tk. 34.52 x 1 = Tk. 34.52","product_id":414698,"product_name":"Dettol Liquid 50 Ml - New Rate","quantity":1,"sale_price":34.52,"seller":"Unicorn","seller_slug":"unicorn","size":"50ml","sku":"Dettol-Liquid-50-Ml---New-Rate---fb581683","slug":"dettol-liquid-50-ml-new-rate-shopup-b15c7686","sold_out":false,"title":"Dettol Liquid 50 Ml - New Rate","variant":526042,"variant_options":[{"corrected_count_on_hand":3,"count_on_hand":9971,"id":526042,"name":"50ml","option_value_name":"50ml","size":5}],"variant_price":34.52,"zipcode":"934"},{"activity_object":{"activity_object":{"id":"P414700"}},"category":"Toilet cleaner","category_id":2167,"cod_availability":true,"cod_message":"Delivery in 5-15 working days.","delivery_time":"Delivery in 5-15 working days.","delivery_time_message":{"message":"Delivery in 5-15 working days.","type":2},"discount":0,"final_discount":0,"formatted_income":"Tk. 0.00","formatted_per_item_total":"Tk. 208.11","formatted_price":"Tk. 108.11","formatted_sale_price":"Tk. 108.11","formatted_seller_price":"Tk. 0.00","formatted_variant_price":"Tk. 108.11","image":"https://shopimages.vstores.io/uc/240564/HarpcPkHbc-Floral-500Mlx12---New-Rate-small.jpg?1591893674","is_free_item":false,"liked":false,"line_item_adjustments":[{"account_id":0,"adjustment_type":2,"amount":"100.0","created_at":"2020-12-08T14:21:35.000+06:00","eligible":true,"formatted_amount":"Tk. 100.00","id":10662,"income":0,"is_seller_coupon":false,"label":"Shipping Charges","line_item_id":308986,"order_id":148415,"result_2":0,"result_3":0,"seller_id":287000412,"updated_at":"2020-12-08T14:21:35.000+06:00","vaccount_id":2}],"line_item_id":308986,"master_product_id":414700,"max_item_quantity":50,"max_selling_price":0,"messages":[],"min_order_qty":1,"min_selling_price":0,"mrp_price_line":"Tk. 108.11 x 1 = Tk. 108.11","original_amo":108.11,"per_item_total":208.11,"permalink":"harpc-pk-hbc-floral-500mlx12-new-rate-94540dc6","prepaid_availability":true,"prepaid_message":"Delivery in 5-15 working days.","price":108.11,"price_line":"Tk. 108.11 x 1 = Tk. 108.11","product_id":414700,"product_name":"Harpc,Pk,Hbc Floral 500Mlx12 - New Rate","quantity":1,"sale_price":108.11,"seller":"Unicorn","seller_slug":"unicorn","size":"500ml","sku":"Harpc,Pk,Hbc-Floral-500Mlx12---New-Rate---90615d67","slug":"harpc-pk-hbc-floral-500mlx12-new-rate-shopup-cb43bcb0","sold_out":false,"title":"Harpc,Pk,Hbc Floral 500Mlx12 - New Rate","variant":526045,"variant_options":[{"corrected_count_on_hand":3,"count_on_hand":9941,"id":526045,"name":"500ml","option_value_name":"500ml","size":5}],"variant_price":108.11,"zipcode":"934"}],"subtotal":7201.63}}
         * messages : []
         * new_user_check_for_nps : false
         * order_number : M6390946727
         * payment_method : cod
         * prepaid_availability : true
         * remaining_vcash : 0
         * subtotal : 8742.630000000001
         * total : 8793
         * total_income : 0
         * vcash_data : {"approved_vcash":0,"available_vcash":0,"show_vcash_form":true,"vcash_already_applied_in_order":0}
         */

        private double cart_items_total;
        private boolean cod_availability;
        private boolean code_applied;
        private int count;
        private String coupon_applied_message;
        private int error_message;
        private String formatted_total_income;
        private double item_total;
//        private LiBySellersBean li_by_sellers;
        private boolean new_user_check_for_nps;
        private String order_number;
        private String payment_method;
        private boolean prepaid_availability;
        private int remaining_vcash;
        private double subtotal;
        private int total;
        private int total_income;
        private VcashDataBean vcash_data;
        private List<AdjustmentsBeanX> adjustments;
        private List<?> lastmile_addresses;
        private List<?> messages;

        public double getCart_items_total() {
            return cart_items_total;
        }

        public void setCart_items_total(double cart_items_total) {
            this.cart_items_total = cart_items_total;
        }

        public boolean isCod_availability() {
            return cod_availability;
        }

        public void setCod_availability(boolean cod_availability) {
            this.cod_availability = cod_availability;
        }

        public boolean isCode_applied() {
            return code_applied;
        }

        public void setCode_applied(boolean code_applied) {
            this.code_applied = code_applied;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getCoupon_applied_message() {
            return coupon_applied_message;
        }

        public void setCoupon_applied_message(String coupon_applied_message) {
            this.coupon_applied_message = coupon_applied_message;
        }

        public int getError_message() {
            return error_message;
        }

        public void setError_message(int error_message) {
            this.error_message = error_message;
        }

        public String getFormatted_total_income() {
            return formatted_total_income;
        }

        public void setFormatted_total_income(String formatted_total_income) {
            this.formatted_total_income = formatted_total_income;
        }

        public double getItem_total() {
            return item_total;
        }

        public void setItem_total(double item_total) {
            this.item_total = item_total;
        }

//        public LiBySellersBean getLi_by_sellers() {
//            return li_by_sellers;
//        }
//
//        public void setLi_by_sellers(LiBySellersBean li_by_sellers) {
//            this.li_by_sellers = li_by_sellers;
//        }

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

        public String getPayment_method() {
            return payment_method;
        }

        public void setPayment_method(String payment_method) {
            this.payment_method = payment_method;
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

        public double getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(double subtotal) {
            this.subtotal = subtotal;
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

        public VcashDataBean getVcash_data() {
            return vcash_data;
        }

        public void setVcash_data(VcashDataBean vcash_data) {
            this.vcash_data = vcash_data;
        }

        public List<AdjustmentsBeanX> getAdjustments() {
            return adjustments;
        }

        public void setAdjustments(List<AdjustmentsBeanX> adjustments) {
            this.adjustments = adjustments;
        }

        public List<?> getLastmile_addresses() {
            return lastmile_addresses;
        }

        public void setLastmile_addresses(List<?> lastmile_addresses) {
            this.lastmile_addresses = lastmile_addresses;
        }

        public List<?> getMessages() {
            return messages;
        }

        public void setMessages(List<?> messages) {
            this.messages = messages;
        }

//        public static class LiBySellersBean {
//            /**
//             * Unbranded : {"adjustments":[],"item_total":1541,"items":[{"activity_object":{"activity_object":{"id":"P413210"}},"category":"Rice","category_id":2186,"cod_availability":true,"cod_message":"Delivery in 5-15 working days.","delivery_time":"Delivery in 5-15 working days.","delivery_time_message":{"message":"Delivery in 5-15 working days.","type":2},"discount":0,"final_discount":0,"formatted_income":"Tk. 0.00","formatted_per_item_total":"Tk. 1,541.00","formatted_price":"Tk. 1,541.00","formatted_sale_price":"Tk. 1,541.00","formatted_seller_price":"Tk. 0.00","formatted_variant_price":"Tk. 1,541.00","image":"https://shopimages.vstores.io/uc/832364/Lalon-Special-Miniket-Rice---25-kg-small.jpg?1591772277","is_free_item":false,"liked":false,"line_item_adjustments":[],"line_item_id":308990,"master_product_id":413210,"max_item_quantity":50,"max_selling_price":0,"messages":[],"min_order_qty":1,"min_selling_price":0,"mrp_price_line":"Tk. 1,541.00 x 1 = Tk. 1,541.00","original_amo":1541,"per_item_total":1541,"permalink":"lalon-special-miniket-rice-25-kg-8242dbfa","prepaid_availability":true,"prepaid_message":"Delivery in 5-15 working days.","price":1541,"price_line":"Tk. 1,541.00 x 1 = Tk. 1,541.00","product_id":413210,"product_name":"Lalon Special Miniket Rice - 25 kg","quantity":1,"sale_price":1541,"seller":"Unbranded","seller_slug":"unbranded","size":"25 kg","sku":"Lalon-Special-Miniket-Rice---25-kg---a027b146","slug":"lalon-special-miniket-rice-25-kg-shopup-59a5de5e","sold_out":false,"title":"Lalon Special Miniket Rice - 25 kg","variant":523685,"variant_options":[{"corrected_count_on_hand":3,"count_on_hand":11109,"id":523685,"name":"25 kg","option_value_name":"25 kg","size":5}],"variant_price":1541,"zipcode":"934"}],"subtotal":1541}
//             * Unicorn : {"adjustments":[{"amount":580,"is_seller_coupon":false,"is_vcash":false,"label":"Shipping Charges"}],"item_total":6621.63,"items":[{"activity_object":{"activity_object":{"id":"P414699"}},"category":"Personal care essential","category_id":2243,"cod_availability":true,"cod_message":"Delivery in 5-15 working days.","delivery_time":"Delivery in 5-15 working days.","delivery_time_message":{"message":"Delivery in 5-15 working days.","type":2},"discount":0,"final_discount":0,"formatted_income":"Tk. 0.00","formatted_per_item_total":"Tk. 725.00","formatted_price":"Tk. 58.50","formatted_sale_price":"Tk. 585.00","formatted_seller_price":"Tk. 0.00","formatted_variant_price":"Tk. 58.50","image":"https://shopimages.vstores.io/uc/140564/Dettol-Handwash-170-ml-Refill-Poly-Re-energize_1-small.jpg?1591893674","is_free_item":false,"liked":false,"line_item_adjustments":[{"account_id":0,"adjustment_type":2,"amount":"140.0","created_at":"2020-12-08T14:21:35.000+06:00","eligible":true,"formatted_amount":"Tk. 140.00","id":10665,"income":0,"is_seller_coupon":false,"label":"Shipping Charges","line_item_id":308989,"order_id":148415,"result_2":0,"result_3":0,"seller_id":287000412,"updated_at":"2020-12-08T14:21:35.000+06:00","vaccount_id":2}],"line_item_id":308989,"master_product_id":414699,"max_item_quantity":50,"max_selling_price":0,"messages":[],"min_order_qty":1,"min_selling_price":0,"mrp_price_line":"Tk. 58.50 x 10 = Tk. 585.00","original_amo":58.5,"per_item_total":725,"permalink":"detol-hw-poly-170-ml-re-ener-new-rate-40bebb33","prepaid_availability":true,"prepaid_message":"Delivery in 5-15 working days.","price":58.5,"price_line":"Tk. 58.50 x 10 = Tk. 585.00","product_id":414699,"product_name":"Dettol,Hw Poly 170 Ml Re-Ener- New Rate","quantity":10,"sale_price":585,"seller":"Unicorn","seller_slug":"unicorn","size":"170ml","sku":"Detol,Hw-Poly-170-Ml-Re-Ener--New-Rate---87bea10d","slug":"detol-hw-poly-170-ml-re-ener-new-rate-shopup-05bfce45","sold_out":false,"title":"Dettol,Hw Poly 170 Ml Re-Ener- New Rate","variant":526050,"variant_options":[{"corrected_count_on_hand":3,"count_on_hand":989,"id":526050,"name":"170ml","option_value_name":"170ml","size":5}],"variant_price":58.5,"zipcode":"934"},{"activity_object":{"activity_object":{"id":"P414697"}},"category":"Floor cleaner","category_id":2160,"cod_availability":true,"cod_message":"Delivery in 5-15 working days.","delivery_time":"Delivery in 5-15 working days.","delivery_time_message":{"message":"Delivery in 5-15 working days.","type":2},"discount":0,"final_discount":0,"formatted_income":"Tk. 0.00","formatted_per_item_total":"Tk. 6,134.00","formatted_price":"Tk. 210.50","formatted_sale_price":"Tk. 5,894.00","formatted_seller_price":"Tk. 0.00","formatted_variant_price":"Tk. 210.50","image":"https://shopimages.vstores.io/uc/930564/lizol_floor_cleaner_citrus_disinfectant_surface_cleaner_975ml_1-small.jpg?1591893670","is_free_item":false,"liked":false,"line_item_adjustments":[{"account_id":0,"adjustment_type":2,"amount":"240.0","created_at":"2020-12-08T14:21:35.000+06:00","eligible":true,"formatted_amount":"Tk. 240.00","id":10664,"income":0,"is_seller_coupon":false,"label":"Shipping Charges","line_item_id":308988,"order_id":148415,"result_2":0,"result_3":0,"seller_id":287000412,"updated_at":"2020-12-08T14:21:35.000+06:00","vaccount_id":2}],"line_item_id":308988,"master_product_id":414697,"max_item_quantity":50,"max_selling_price":0,"messages":[],"min_order_qty":1,"min_selling_price":0,"mrp_price_line":"Tk. 220.00 x 28 = Tk. 6,160.00","original_amo":220,"per_item_total":6134,"permalink":"lizol-975-ml-citrus-ih-new-rat-bb8d61c6","prepaid_availability":true,"prepaid_message":"Delivery in 5-15 working days.","price":210.5,"price_line":"Tk. 210.50 x 28 = Tk. 5,894.00","product_id":414697,"product_name":"Lizol 975 Ml - Citrus - Ih - New Rat","quantity":28,"sale_price":5894,"seller":"Unicorn","seller_slug":"unicorn","size":"975ml","sku":"Lizol-975-Ml---Citrus---Ih---New-Rat---ca165571","slug":"lizol-975-ml-citrus-ih-new-rat-shopup-7805faf6","sold_out":false,"title":"Lizol 975 Ml - Citrus - Ih - New Rat","variant":526040,"variant_options":[{"corrected_count_on_hand":3,"count_on_hand":947,"id":526040,"name":"975ml","option_value_name":"975ml","size":5}],"variant_price":210.5,"zipcode":"934"},{"activity_object":{"activity_object":{"id":"P414698"}},"category":"Personal care essential","category_id":2243,"cod_availability":true,"cod_message":"Delivery in 5-15 working days.","delivery_time":"Delivery in 5-15 working days.","delivery_time_message":{"message":"Delivery in 5-15 working days.","type":2},"discount":0,"final_discount":0,"formatted_income":"Tk. 0.00","formatted_per_item_total":"Tk. 134.52","formatted_price":"Tk. 34.52","formatted_sale_price":"Tk. 34.52","formatted_seller_price":"Tk. 0.00","formatted_variant_price":"Tk. 34.52","image":"https://shopimages.vstores.io/uc/040564/Dettol-Liquid-50-Ml---New-Rate-small.jpg?1591893672","is_free_item":false,"liked":false,"line_item_adjustments":[{"account_id":0,"adjustment_type":2,"amount":"100.0","created_at":"2020-12-08T14:21:35.000+06:00","eligible":true,"formatted_amount":"Tk. 100.00","id":10663,"income":0,"is_seller_coupon":false,"label":"Shipping Charges","line_item_id":308987,"order_id":148415,"result_2":0,"result_3":0,"seller_id":287000412,"updated_at":"2020-12-08T14:21:35.000+06:00","vaccount_id":2}],"line_item_id":308987,"master_product_id":414698,"max_item_quantity":50,"max_selling_price":0,"messages":[],"min_order_qty":1,"min_selling_price":0,"mrp_price_line":"Tk. 34.52 x 1 = Tk. 34.52","original_amo":34.52,"per_item_total":134.52,"permalink":"dettol-liquid-50-ml-new-rate-6d8bfe5b","prepaid_availability":true,"prepaid_message":"Delivery in 5-15 working days.","price":34.52,"price_line":"Tk. 34.52 x 1 = Tk. 34.52","product_id":414698,"product_name":"Dettol Liquid 50 Ml - New Rate","quantity":1,"sale_price":34.52,"seller":"Unicorn","seller_slug":"unicorn","size":"50ml","sku":"Dettol-Liquid-50-Ml---New-Rate---fb581683","slug":"dettol-liquid-50-ml-new-rate-shopup-b15c7686","sold_out":false,"title":"Dettol Liquid 50 Ml - New Rate","variant":526042,"variant_options":[{"corrected_count_on_hand":3,"count_on_hand":9971,"id":526042,"name":"50ml","option_value_name":"50ml","size":5}],"variant_price":34.52,"zipcode":"934"},{"activity_object":{"activity_object":{"id":"P414700"}},"category":"Toilet cleaner","category_id":2167,"cod_availability":true,"cod_message":"Delivery in 5-15 working days.","delivery_time":"Delivery in 5-15 working days.","delivery_time_message":{"message":"Delivery in 5-15 working days.","type":2},"discount":0,"final_discount":0,"formatted_income":"Tk. 0.00","formatted_per_item_total":"Tk. 208.11","formatted_price":"Tk. 108.11","formatted_sale_price":"Tk. 108.11","formatted_seller_price":"Tk. 0.00","formatted_variant_price":"Tk. 108.11","image":"https://shopimages.vstores.io/uc/240564/HarpcPkHbc-Floral-500Mlx12---New-Rate-small.jpg?1591893674","is_free_item":false,"liked":false,"line_item_adjustments":[{"account_id":0,"adjustment_type":2,"amount":"100.0","created_at":"2020-12-08T14:21:35.000+06:00","eligible":true,"formatted_amount":"Tk. 100.00","id":10662,"income":0,"is_seller_coupon":false,"label":"Shipping Charges","line_item_id":308986,"order_id":148415,"result_2":0,"result_3":0,"seller_id":287000412,"updated_at":"2020-12-08T14:21:35.000+06:00","vaccount_id":2}],"line_item_id":308986,"master_product_id":414700,"max_item_quantity":50,"max_selling_price":0,"messages":[],"min_order_qty":1,"min_selling_price":0,"mrp_price_line":"Tk. 108.11 x 1 = Tk. 108.11","original_amo":108.11,"per_item_total":208.11,"permalink":"harpc-pk-hbc-floral-500mlx12-new-rate-94540dc6","prepaid_availability":true,"prepaid_message":"Delivery in 5-15 working days.","price":108.11,"price_line":"Tk. 108.11 x 1 = Tk. 108.11","product_id":414700,"product_name":"Harpc,Pk,Hbc Floral 500Mlx12 - New Rate","quantity":1,"sale_price":108.11,"seller":"Unicorn","seller_slug":"unicorn","size":"500ml","sku":"Harpc,Pk,Hbc-Floral-500Mlx12---New-Rate---90615d67","slug":"harpc-pk-hbc-floral-500mlx12-new-rate-shopup-cb43bcb0","sold_out":false,"title":"Harpc,Pk,Hbc Floral 500Mlx12 - New Rate","variant":526045,"variant_options":[{"corrected_count_on_hand":3,"count_on_hand":9941,"id":526045,"name":"500ml","option_value_name":"500ml","size":5}],"variant_price":108.11,"zipcode":"934"}],"subtotal":7201.63}
//             */
//
//            private UnbrandedBean Unbranded;
//            private UnicornBean Unicorn;
//
//            public UnbrandedBean getUnbranded() {
//                return Unbranded;
//            }
//
//            public void setUnbranded(UnbrandedBean Unbranded) {
//                this.Unbranded = Unbranded;
//            }
//
//            public UnicornBean getUnicorn() {
//                return Unicorn;
//            }
//
//            public void setUnicorn(UnicornBean Unicorn) {
//                this.Unicorn = Unicorn;
//            }
//
//            public static class UnbrandedBean {
//                /**
//                 * adjustments : []
//                 * item_total : 1541
//                 * items : [{"activity_object":{"activity_object":{"id":"P413210"}},"category":"Rice","category_id":2186,"cod_availability":true,"cod_message":"Delivery in 5-15 working days.","delivery_time":"Delivery in 5-15 working days.","delivery_time_message":{"message":"Delivery in 5-15 working days.","type":2},"discount":0,"final_discount":0,"formatted_income":"Tk. 0.00","formatted_per_item_total":"Tk. 1,541.00","formatted_price":"Tk. 1,541.00","formatted_sale_price":"Tk. 1,541.00","formatted_seller_price":"Tk. 0.00","formatted_variant_price":"Tk. 1,541.00","image":"https://shopimages.vstores.io/uc/832364/Lalon-Special-Miniket-Rice---25-kg-small.jpg?1591772277","is_free_item":false,"liked":false,"line_item_adjustments":[],"line_item_id":308990,"master_product_id":413210,"max_item_quantity":50,"max_selling_price":0,"messages":[],"min_order_qty":1,"min_selling_price":0,"mrp_price_line":"Tk. 1,541.00 x 1 = Tk. 1,541.00","original_amo":1541,"per_item_total":1541,"permalink":"lalon-special-miniket-rice-25-kg-8242dbfa","prepaid_availability":true,"prepaid_message":"Delivery in 5-15 working days.","price":1541,"price_line":"Tk. 1,541.00 x 1 = Tk. 1,541.00","product_id":413210,"product_name":"Lalon Special Miniket Rice - 25 kg","quantity":1,"sale_price":1541,"seller":"Unbranded","seller_slug":"unbranded","size":"25 kg","sku":"Lalon-Special-Miniket-Rice---25-kg---a027b146","slug":"lalon-special-miniket-rice-25-kg-shopup-59a5de5e","sold_out":false,"title":"Lalon Special Miniket Rice - 25 kg","variant":523685,"variant_options":[{"corrected_count_on_hand":3,"count_on_hand":11109,"id":523685,"name":"25 kg","option_value_name":"25 kg","size":5}],"variant_price":1541,"zipcode":"934"}]
//                 * subtotal : 1541
//                 */
//
//                private int item_total;
//                private int subtotal;
//                private List<?> adjustments;
//                private List<ItemsBean> items;
//
//                public int getItem_total() {
//                    return item_total;
//                }
//
//                public void setItem_total(int item_total) {
//                    this.item_total = item_total;
//                }
//
//                public int getSubtotal() {
//                    return subtotal;
//                }
//
//                public void setSubtotal(int subtotal) {
//                    this.subtotal = subtotal;
//                }
//
//                public List<?> getAdjustments() {
//                    return adjustments;
//                }
//
//                public void setAdjustments(List<?> adjustments) {
//                    this.adjustments = adjustments;
//                }
//
//                public List<ItemsBean> getItems() {
//                    return items;
//                }
//
//                public void setItems(List<ItemsBean> items) {
//                    this.items = items;
//                }
//
//                public static class ItemsBean {
//                    /**
//                     * activity_object : {"activity_object":{"id":"P413210"}}
//                     * category : Rice
//                     * category_id : 2186
//                     * cod_availability : true
//                     * cod_message : Delivery in 5-15 working days.
//                     * delivery_time : Delivery in 5-15 working days.
//                     * delivery_time_message : {"message":"Delivery in 5-15 working days.","type":2}
//                     * discount : 0
//                     * final_discount : 0
//                     * formatted_income : Tk. 0.00
//                     * formatted_per_item_total : Tk. 1,541.00
//                     * formatted_price : Tk. 1,541.00
//                     * formatted_sale_price : Tk. 1,541.00
//                     * formatted_seller_price : Tk. 0.00
//                     * formatted_variant_price : Tk. 1,541.00
//                     * image : https://shopimages.vstores.io/uc/832364/Lalon-Special-Miniket-Rice---25-kg-small.jpg?1591772277
//                     * is_free_item : false
//                     * liked : false
//                     * line_item_adjustments : []
//                     * line_item_id : 308990
//                     * master_product_id : 413210
//                     * max_item_quantity : 50
//                     * max_selling_price : 0
//                     * messages : []
//                     * min_order_qty : 1
//                     * min_selling_price : 0
//                     * mrp_price_line : Tk. 1,541.00 x 1 = Tk. 1,541.00
//                     * original_amo : 1541
//                     * per_item_total : 1541
//                     * permalink : lalon-special-miniket-rice-25-kg-8242dbfa
//                     * prepaid_availability : true
//                     * prepaid_message : Delivery in 5-15 working days.
//                     * price : 1541
//                     * price_line : Tk. 1,541.00 x 1 = Tk. 1,541.00
//                     * product_id : 413210
//                     * product_name : Lalon Special Miniket Rice - 25 kg
//                     * quantity : 1
//                     * sale_price : 1541
//                     * seller : Unbranded
//                     * seller_slug : unbranded
//                     * size : 25 kg
//                     * sku : Lalon-Special-Miniket-Rice---25-kg---a027b146
//                     * slug : lalon-special-miniket-rice-25-kg-shopup-59a5de5e
//                     * sold_out : false
//                     * title : Lalon Special Miniket Rice - 25 kg
//                     * variant : 523685
//                     * variant_options : [{"corrected_count_on_hand":3,"count_on_hand":11109,"id":523685,"name":"25 kg","option_value_name":"25 kg","size":5}]
//                     * variant_price : 1541
//                     * zipcode : 934
//                     */
//
//                    private ActivityObjectBeanX activity_object;
//                    private String category;
//                    private int category_id;
//                    private boolean cod_availability;
//                    private String cod_message;
//                    private String delivery_time;
//                    private DeliveryTimeMessageBean delivery_time_message;
//                    private int discount;
//                    private int final_discount;
//                    private String formatted_income;
//                    private String formatted_per_item_total;
//                    private String formatted_price;
//                    private String formatted_sale_price;
//                    private String formatted_seller_price;
//                    private String formatted_variant_price;
//                    private String image;
//                    private boolean is_free_item;
//                    private boolean liked;
//                    private int line_item_id;
//                    private int master_product_id;
//                    private int max_item_quantity;
//                    private int max_selling_price;
//                    private int min_order_qty;
//                    private int min_selling_price;
//                    private String mrp_price_line;
//                    private int original_amo;
//                    private int per_item_total;
//                    private String permalink;
//                    private boolean prepaid_availability;
//                    private String prepaid_message;
//                    private int price;
//                    private String price_line;
//                    private int product_id;
//                    private String product_name;
//                    private int quantity;
//                    private int sale_price;
//                    private String seller;
//                    private String seller_slug;
//                    private String size;
//                    private String sku;
//                    private String slug;
//                    private boolean sold_out;
//                    private String title;
//                    private int variant;
//                    private int variant_price;
//                    private String zipcode;
//                    private List<?> line_item_adjustments;
//                    private List<?> messages;
//                    private List<VariantOptionsBean> variant_options;
//
//                    public ActivityObjectBeanX getActivity_object() {
//                        return activity_object;
//                    }
//
//                    public void setActivity_object(ActivityObjectBeanX activity_object) {
//                        this.activity_object = activity_object;
//                    }
//
//                    public String getCategory() {
//                        return category;
//                    }
//
//                    public void setCategory(String category) {
//                        this.category = category;
//                    }
//
//                    public int getCategory_id() {
//                        return category_id;
//                    }
//
//                    public void setCategory_id(int category_id) {
//                        this.category_id = category_id;
//                    }
//
//                    public boolean isCod_availability() {
//                        return cod_availability;
//                    }
//
//                    public void setCod_availability(boolean cod_availability) {
//                        this.cod_availability = cod_availability;
//                    }
//
//                    public String getCod_message() {
//                        return cod_message;
//                    }
//
//                    public void setCod_message(String cod_message) {
//                        this.cod_message = cod_message;
//                    }
//
//                    public String getDelivery_time() {
//                        return delivery_time;
//                    }
//
//                    public void setDelivery_time(String delivery_time) {
//                        this.delivery_time = delivery_time;
//                    }
//
//                    public DeliveryTimeMessageBean getDelivery_time_message() {
//                        return delivery_time_message;
//                    }
//
//                    public void setDelivery_time_message(DeliveryTimeMessageBean delivery_time_message) {
//                        this.delivery_time_message = delivery_time_message;
//                    }
//
//                    public int getDiscount() {
//                        return discount;
//                    }
//
//                    public void setDiscount(int discount) {
//                        this.discount = discount;
//                    }
//
//                    public int getFinal_discount() {
//                        return final_discount;
//                    }
//
//                    public void setFinal_discount(int final_discount) {
//                        this.final_discount = final_discount;
//                    }
//
//                    public String getFormatted_income() {
//                        return formatted_income;
//                    }
//
//                    public void setFormatted_income(String formatted_income) {
//                        this.formatted_income = formatted_income;
//                    }
//
//                    public String getFormatted_per_item_total() {
//                        return formatted_per_item_total;
//                    }
//
//                    public void setFormatted_per_item_total(String formatted_per_item_total) {
//                        this.formatted_per_item_total = formatted_per_item_total;
//                    }
//
//                    public String getFormatted_price() {
//                        return formatted_price;
//                    }
//
//                    public void setFormatted_price(String formatted_price) {
//                        this.formatted_price = formatted_price;
//                    }
//
//                    public String getFormatted_sale_price() {
//                        return formatted_sale_price;
//                    }
//
//                    public void setFormatted_sale_price(String formatted_sale_price) {
//                        this.formatted_sale_price = formatted_sale_price;
//                    }
//
//                    public String getFormatted_seller_price() {
//                        return formatted_seller_price;
//                    }
//
//                    public void setFormatted_seller_price(String formatted_seller_price) {
//                        this.formatted_seller_price = formatted_seller_price;
//                    }
//
//                    public String getFormatted_variant_price() {
//                        return formatted_variant_price;
//                    }
//
//                    public void setFormatted_variant_price(String formatted_variant_price) {
//                        this.formatted_variant_price = formatted_variant_price;
//                    }
//
//                    public String getImage() {
//                        return image;
//                    }
//
//                    public void setImage(String image) {
//                        this.image = image;
//                    }
//
//                    public boolean isIs_free_item() {
//                        return is_free_item;
//                    }
//
//                    public void setIs_free_item(boolean is_free_item) {
//                        this.is_free_item = is_free_item;
//                    }
//
//                    public boolean isLiked() {
//                        return liked;
//                    }
//
//                    public void setLiked(boolean liked) {
//                        this.liked = liked;
//                    }
//
//                    public int getLine_item_id() {
//                        return line_item_id;
//                    }
//
//                    public void setLine_item_id(int line_item_id) {
//                        this.line_item_id = line_item_id;
//                    }
//
//                    public int getMaster_product_id() {
//                        return master_product_id;
//                    }
//
//                    public void setMaster_product_id(int master_product_id) {
//                        this.master_product_id = master_product_id;
//                    }
//
//                    public int getMax_item_quantity() {
//                        return max_item_quantity;
//                    }
//
//                    public void setMax_item_quantity(int max_item_quantity) {
//                        this.max_item_quantity = max_item_quantity;
//                    }
//
//                    public int getMax_selling_price() {
//                        return max_selling_price;
//                    }
//
//                    public void setMax_selling_price(int max_selling_price) {
//                        this.max_selling_price = max_selling_price;
//                    }
//
//                    public int getMin_order_qty() {
//                        return min_order_qty;
//                    }
//
//                    public void setMin_order_qty(int min_order_qty) {
//                        this.min_order_qty = min_order_qty;
//                    }
//
//                    public int getMin_selling_price() {
//                        return min_selling_price;
//                    }
//
//                    public void setMin_selling_price(int min_selling_price) {
//                        this.min_selling_price = min_selling_price;
//                    }
//
//                    public String getMrp_price_line() {
//                        return mrp_price_line;
//                    }
//
//                    public void setMrp_price_line(String mrp_price_line) {
//                        this.mrp_price_line = mrp_price_line;
//                    }
//
//                    public int getOriginal_amo() {
//                        return original_amo;
//                    }
//
//                    public void setOriginal_amo(int original_amo) {
//                        this.original_amo = original_amo;
//                    }
//
//                    public int getPer_item_total() {
//                        return per_item_total;
//                    }
//
//                    public void setPer_item_total(int per_item_total) {
//                        this.per_item_total = per_item_total;
//                    }
//
//                    public String getPermalink() {
//                        return permalink;
//                    }
//
//                    public void setPermalink(String permalink) {
//                        this.permalink = permalink;
//                    }
//
//                    public boolean isPrepaid_availability() {
//                        return prepaid_availability;
//                    }
//
//                    public void setPrepaid_availability(boolean prepaid_availability) {
//                        this.prepaid_availability = prepaid_availability;
//                    }
//
//                    public String getPrepaid_message() {
//                        return prepaid_message;
//                    }
//
//                    public void setPrepaid_message(String prepaid_message) {
//                        this.prepaid_message = prepaid_message;
//                    }
//
//                    public int getPrice() {
//                        return price;
//                    }
//
//                    public void setPrice(int price) {
//                        this.price = price;
//                    }
//
//                    public String getPrice_line() {
//                        return price_line;
//                    }
//
//                    public void setPrice_line(String price_line) {
//                        this.price_line = price_line;
//                    }
//
//                    public int getProduct_id() {
//                        return product_id;
//                    }
//
//                    public void setProduct_id(int product_id) {
//                        this.product_id = product_id;
//                    }
//
//                    public String getProduct_name() {
//                        return product_name;
//                    }
//
//                    public void setProduct_name(String product_name) {
//                        this.product_name = product_name;
//                    }
//
//                    public int getQuantity() {
//                        return quantity;
//                    }
//
//                    public void setQuantity(int quantity) {
//                        this.quantity = quantity;
//                    }
//
//                    public int getSale_price() {
//                        return sale_price;
//                    }
//
//                    public void setSale_price(int sale_price) {
//                        this.sale_price = sale_price;
//                    }
//
//                    public String getSeller() {
//                        return seller;
//                    }
//
//                    public void setSeller(String seller) {
//                        this.seller = seller;
//                    }
//
//                    public String getSeller_slug() {
//                        return seller_slug;
//                    }
//
//                    public void setSeller_slug(String seller_slug) {
//                        this.seller_slug = seller_slug;
//                    }
//
//                    public String getSize() {
//                        return size;
//                    }
//
//                    public void setSize(String size) {
//                        this.size = size;
//                    }
//
//                    public String getSku() {
//                        return sku;
//                    }
//
//                    public void setSku(String sku) {
//                        this.sku = sku;
//                    }
//
//                    public String getSlug() {
//                        return slug;
//                    }
//
//                    public void setSlug(String slug) {
//                        this.slug = slug;
//                    }
//
//                    public boolean isSold_out() {
//                        return sold_out;
//                    }
//
//                    public void setSold_out(boolean sold_out) {
//                        this.sold_out = sold_out;
//                    }
//
//                    public String getTitle() {
//                        return title;
//                    }
//
//                    public void setTitle(String title) {
//                        this.title = title;
//                    }
//
//                    public int getVariant() {
//                        return variant;
//                    }
//
//                    public void setVariant(int variant) {
//                        this.variant = variant;
//                    }
//
//                    public int getVariant_price() {
//                        return variant_price;
//                    }
//
//                    public void setVariant_price(int variant_price) {
//                        this.variant_price = variant_price;
//                    }
//
//                    public String getZipcode() {
//                        return zipcode;
//                    }
//
//                    public void setZipcode(String zipcode) {
//                        this.zipcode = zipcode;
//                    }
//
//                    public List<?> getLine_item_adjustments() {
//                        return line_item_adjustments;
//                    }
//
//                    public void setLine_item_adjustments(List<?> line_item_adjustments) {
//                        this.line_item_adjustments = line_item_adjustments;
//                    }
//
//                    public List<?> getMessages() {
//                        return messages;
//                    }
//
//                    public void setMessages(List<?> messages) {
//                        this.messages = messages;
//                    }
//
//                    public List<VariantOptionsBean> getVariant_options() {
//                        return variant_options;
//                    }
//
//                    public void setVariant_options(List<VariantOptionsBean> variant_options) {
//                        this.variant_options = variant_options;
//                    }
//
//                    public static class ActivityObjectBeanX {
//                        /**
//                         * activity_object : {"id":"P413210"}
//                         */
//
//                        private ActivityObjectBean activity_object;
//
//                        public ActivityObjectBean getActivity_object() {
//                            return activity_object;
//                        }
//
//                        public void setActivity_object(ActivityObjectBean activity_object) {
//                            this.activity_object = activity_object;
//                        }
//
//                        public static class ActivityObjectBean {
//                            /**
//                             * id : P413210
//                             */
//
//                            private String id;
//
//                            public String getId() {
//                                return id;
//                            }
//
//                            public void setId(String id) {
//                                this.id = id;
//                            }
//                        }
//                    }
//
//                    public static class DeliveryTimeMessageBean {
//                        /**
//                         * message : Delivery in 5-15 working days.
//                         * type : 2
//                         */
//
//                        private String message;
//                        private int type;
//
//                        public String getMessage() {
//                            return message;
//                        }
//
//                        public void setMessage(String message) {
//                            this.message = message;
//                        }
//
//                        public int getType() {
//                            return type;
//                        }
//
//                        public void setType(int type) {
//                            this.type = type;
//                        }
//                    }
//
//                    public static class VariantOptionsBean {
//                        /**
//                         * corrected_count_on_hand : 3
//                         * count_on_hand : 11109
//                         * id : 523685
//                         * name : 25 kg
//                         * option_value_name : 25 kg
//                         * size : 5
//                         */
//
//                        private int corrected_count_on_hand;
//                        private int count_on_hand;
//                        private int id;
//                        private String name;
//                        private String option_value_name;
//                        private int size;
//
//                        public int getCorrected_count_on_hand() {
//                            return corrected_count_on_hand;
//                        }
//
//                        public void setCorrected_count_on_hand(int corrected_count_on_hand) {
//                            this.corrected_count_on_hand = corrected_count_on_hand;
//                        }
//
//                        public int getCount_on_hand() {
//                            return count_on_hand;
//                        }
//
//                        public void setCount_on_hand(int count_on_hand) {
//                            this.count_on_hand = count_on_hand;
//                        }
//
//                        public int getId() {
//                            return id;
//                        }
//
//                        public void setId(int id) {
//                            this.id = id;
//                        }
//
//                        public String getName() {
//                            return name;
//                        }
//
//                        public void setName(String name) {
//                            this.name = name;
//                        }
//
//                        public String getOption_value_name() {
//                            return option_value_name;
//                        }
//
//                        public void setOption_value_name(String option_value_name) {
//                            this.option_value_name = option_value_name;
//                        }
//
//                        public int getSize() {
//                            return size;
//                        }
//
//                        public void setSize(int size) {
//                            this.size = size;
//                        }
//                    }
//                }
//            }
//
//            public static class UnicornBean {
//                /**
//                 * adjustments : [{"amount":580,"is_seller_coupon":false,"is_vcash":false,"label":"Shipping Charges"}]
//                 * item_total : 6621.63
//                 * items : [{"activity_object":{"activity_object":{"id":"P414699"}},"category":"Personal care essential","category_id":2243,"cod_availability":true,"cod_message":"Delivery in 5-15 working days.","delivery_time":"Delivery in 5-15 working days.","delivery_time_message":{"message":"Delivery in 5-15 working days.","type":2},"discount":0,"final_discount":0,"formatted_income":"Tk. 0.00","formatted_per_item_total":"Tk. 725.00","formatted_price":"Tk. 58.50","formatted_sale_price":"Tk. 585.00","formatted_seller_price":"Tk. 0.00","formatted_variant_price":"Tk. 58.50","image":"https://shopimages.vstores.io/uc/140564/Dettol-Handwash-170-ml-Refill-Poly-Re-energize_1-small.jpg?1591893674","is_free_item":false,"liked":false,"line_item_adjustments":[{"account_id":0,"adjustment_type":2,"amount":"140.0","created_at":"2020-12-08T14:21:35.000+06:00","eligible":true,"formatted_amount":"Tk. 140.00","id":10665,"income":0,"is_seller_coupon":false,"label":"Shipping Charges","line_item_id":308989,"order_id":148415,"result_2":0,"result_3":0,"seller_id":287000412,"updated_at":"2020-12-08T14:21:35.000+06:00","vaccount_id":2}],"line_item_id":308989,"master_product_id":414699,"max_item_quantity":50,"max_selling_price":0,"messages":[],"min_order_qty":1,"min_selling_price":0,"mrp_price_line":"Tk. 58.50 x 10 = Tk. 585.00","original_amo":58.5,"per_item_total":725,"permalink":"detol-hw-poly-170-ml-re-ener-new-rate-40bebb33","prepaid_availability":true,"prepaid_message":"Delivery in 5-15 working days.","price":58.5,"price_line":"Tk. 58.50 x 10 = Tk. 585.00","product_id":414699,"product_name":"Dettol,Hw Poly 170 Ml Re-Ener- New Rate","quantity":10,"sale_price":585,"seller":"Unicorn","seller_slug":"unicorn","size":"170ml","sku":"Detol,Hw-Poly-170-Ml-Re-Ener--New-Rate---87bea10d","slug":"detol-hw-poly-170-ml-re-ener-new-rate-shopup-05bfce45","sold_out":false,"title":"Dettol,Hw Poly 170 Ml Re-Ener- New Rate","variant":526050,"variant_options":[{"corrected_count_on_hand":3,"count_on_hand":989,"id":526050,"name":"170ml","option_value_name":"170ml","size":5}],"variant_price":58.5,"zipcode":"934"},{"activity_object":{"activity_object":{"id":"P414697"}},"category":"Floor cleaner","category_id":2160,"cod_availability":true,"cod_message":"Delivery in 5-15 working days.","delivery_time":"Delivery in 5-15 working days.","delivery_time_message":{"message":"Delivery in 5-15 working days.","type":2},"discount":0,"final_discount":0,"formatted_income":"Tk. 0.00","formatted_per_item_total":"Tk. 6,134.00","formatted_price":"Tk. 210.50","formatted_sale_price":"Tk. 5,894.00","formatted_seller_price":"Tk. 0.00","formatted_variant_price":"Tk. 210.50","image":"https://shopimages.vstores.io/uc/930564/lizol_floor_cleaner_citrus_disinfectant_surface_cleaner_975ml_1-small.jpg?1591893670","is_free_item":false,"liked":false,"line_item_adjustments":[{"account_id":0,"adjustment_type":2,"amount":"240.0","created_at":"2020-12-08T14:21:35.000+06:00","eligible":true,"formatted_amount":"Tk. 240.00","id":10664,"income":0,"is_seller_coupon":false,"label":"Shipping Charges","line_item_id":308988,"order_id":148415,"result_2":0,"result_3":0,"seller_id":287000412,"updated_at":"2020-12-08T14:21:35.000+06:00","vaccount_id":2}],"line_item_id":308988,"master_product_id":414697,"max_item_quantity":50,"max_selling_price":0,"messages":[],"min_order_qty":1,"min_selling_price":0,"mrp_price_line":"Tk. 220.00 x 28 = Tk. 6,160.00","original_amo":220,"per_item_total":6134,"permalink":"lizol-975-ml-citrus-ih-new-rat-bb8d61c6","prepaid_availability":true,"prepaid_message":"Delivery in 5-15 working days.","price":210.5,"price_line":"Tk. 210.50 x 28 = Tk. 5,894.00","product_id":414697,"product_name":"Lizol 975 Ml - Citrus - Ih - New Rat","quantity":28,"sale_price":5894,"seller":"Unicorn","seller_slug":"unicorn","size":"975ml","sku":"Lizol-975-Ml---Citrus---Ih---New-Rat---ca165571","slug":"lizol-975-ml-citrus-ih-new-rat-shopup-7805faf6","sold_out":false,"title":"Lizol 975 Ml - Citrus - Ih - New Rat","variant":526040,"variant_options":[{"corrected_count_on_hand":3,"count_on_hand":947,"id":526040,"name":"975ml","option_value_name":"975ml","size":5}],"variant_price":210.5,"zipcode":"934"},{"activity_object":{"activity_object":{"id":"P414698"}},"category":"Personal care essential","category_id":2243,"cod_availability":true,"cod_message":"Delivery in 5-15 working days.","delivery_time":"Delivery in 5-15 working days.","delivery_time_message":{"message":"Delivery in 5-15 working days.","type":2},"discount":0,"final_discount":0,"formatted_income":"Tk. 0.00","formatted_per_item_total":"Tk. 134.52","formatted_price":"Tk. 34.52","formatted_sale_price":"Tk. 34.52","formatted_seller_price":"Tk. 0.00","formatted_variant_price":"Tk. 34.52","image":"https://shopimages.vstores.io/uc/040564/Dettol-Liquid-50-Ml---New-Rate-small.jpg?1591893672","is_free_item":false,"liked":false,"line_item_adjustments":[{"account_id":0,"adjustment_type":2,"amount":"100.0","created_at":"2020-12-08T14:21:35.000+06:00","eligible":true,"formatted_amount":"Tk. 100.00","id":10663,"income":0,"is_seller_coupon":false,"label":"Shipping Charges","line_item_id":308987,"order_id":148415,"result_2":0,"result_3":0,"seller_id":287000412,"updated_at":"2020-12-08T14:21:35.000+06:00","vaccount_id":2}],"line_item_id":308987,"master_product_id":414698,"max_item_quantity":50,"max_selling_price":0,"messages":[],"min_order_qty":1,"min_selling_price":0,"mrp_price_line":"Tk. 34.52 x 1 = Tk. 34.52","original_amo":34.52,"per_item_total":134.52,"permalink":"dettol-liquid-50-ml-new-rate-6d8bfe5b","prepaid_availability":true,"prepaid_message":"Delivery in 5-15 working days.","price":34.52,"price_line":"Tk. 34.52 x 1 = Tk. 34.52","product_id":414698,"product_name":"Dettol Liquid 50 Ml - New Rate","quantity":1,"sale_price":34.52,"seller":"Unicorn","seller_slug":"unicorn","size":"50ml","sku":"Dettol-Liquid-50-Ml---New-Rate---fb581683","slug":"dettol-liquid-50-ml-new-rate-shopup-b15c7686","sold_out":false,"title":"Dettol Liquid 50 Ml - New Rate","variant":526042,"variant_options":[{"corrected_count_on_hand":3,"count_on_hand":9971,"id":526042,"name":"50ml","option_value_name":"50ml","size":5}],"variant_price":34.52,"zipcode":"934"},{"activity_object":{"activity_object":{"id":"P414700"}},"category":"Toilet cleaner","category_id":2167,"cod_availability":true,"cod_message":"Delivery in 5-15 working days.","delivery_time":"Delivery in 5-15 working days.","delivery_time_message":{"message":"Delivery in 5-15 working days.","type":2},"discount":0,"final_discount":0,"formatted_income":"Tk. 0.00","formatted_per_item_total":"Tk. 208.11","formatted_price":"Tk. 108.11","formatted_sale_price":"Tk. 108.11","formatted_seller_price":"Tk. 0.00","formatted_variant_price":"Tk. 108.11","image":"https://shopimages.vstores.io/uc/240564/HarpcPkHbc-Floral-500Mlx12---New-Rate-small.jpg?1591893674","is_free_item":false,"liked":false,"line_item_adjustments":[{"account_id":0,"adjustment_type":2,"amount":"100.0","created_at":"2020-12-08T14:21:35.000+06:00","eligible":true,"formatted_amount":"Tk. 100.00","id":10662,"income":0,"is_seller_coupon":false,"label":"Shipping Charges","line_item_id":308986,"order_id":148415,"result_2":0,"result_3":0,"seller_id":287000412,"updated_at":"2020-12-08T14:21:35.000+06:00","vaccount_id":2}],"line_item_id":308986,"master_product_id":414700,"max_item_quantity":50,"max_selling_price":0,"messages":[],"min_order_qty":1,"min_selling_price":0,"mrp_price_line":"Tk. 108.11 x 1 = Tk. 108.11","original_amo":108.11,"per_item_total":208.11,"permalink":"harpc-pk-hbc-floral-500mlx12-new-rate-94540dc6","prepaid_availability":true,"prepaid_message":"Delivery in 5-15 working days.","price":108.11,"price_line":"Tk. 108.11 x 1 = Tk. 108.11","product_id":414700,"product_name":"Harpc,Pk,Hbc Floral 500Mlx12 - New Rate","quantity":1,"sale_price":108.11,"seller":"Unicorn","seller_slug":"unicorn","size":"500ml","sku":"Harpc,Pk,Hbc-Floral-500Mlx12---New-Rate---90615d67","slug":"harpc-pk-hbc-floral-500mlx12-new-rate-shopup-cb43bcb0","sold_out":false,"title":"Harpc,Pk,Hbc Floral 500Mlx12 - New Rate","variant":526045,"variant_options":[{"corrected_count_on_hand":3,"count_on_hand":9941,"id":526045,"name":"500ml","option_value_name":"500ml","size":5}],"variant_price":108.11,"zipcode":"934"}]
//                 * subtotal : 7201.63
//                 */
//
//                private double item_total;
//                private double subtotal;
//                private List<AdjustmentsBean> adjustments;
//                private List<ItemsBeanX> items;
//
//                public double getItem_total() {
//                    return item_total;
//                }
//
//                public void setItem_total(double item_total) {
//                    this.item_total = item_total;
//                }
//
//                public double getSubtotal() {
//                    return subtotal;
//                }
//
//                public void setSubtotal(double subtotal) {
//                    this.subtotal = subtotal;
//                }
//
//                public List<AdjustmentsBean> getAdjustments() {
//                    return adjustments;
//                }
//
//                public void setAdjustments(List<AdjustmentsBean> adjustments) {
//                    this.adjustments = adjustments;
//                }
//
//                public List<ItemsBeanX> getItems() {
//                    return items;
//                }
//
//                public void setItems(List<ItemsBeanX> items) {
//                    this.items = items;
//                }
//
//                public static class AdjustmentsBean {
//                    /**
//                     * amount : 580
//                     * is_seller_coupon : false
//                     * is_vcash : false
//                     * label : Shipping Charges
//                     */
//
//                    private int amount;
//                    private boolean is_seller_coupon;
//                    private boolean is_vcash;
//                    private String label;
//
//                    public int getAmount() {
//                        return amount;
//                    }
//
//                    public void setAmount(int amount) {
//                        this.amount = amount;
//                    }
//
//                    public boolean isIs_seller_coupon() {
//                        return is_seller_coupon;
//                    }
//
//                    public void setIs_seller_coupon(boolean is_seller_coupon) {
//                        this.is_seller_coupon = is_seller_coupon;
//                    }
//
//                    public boolean isIs_vcash() {
//                        return is_vcash;
//                    }
//
//                    public void setIs_vcash(boolean is_vcash) {
//                        this.is_vcash = is_vcash;
//                    }
//
//                    public String getLabel() {
//                        return label;
//                    }
//
//                    public void setLabel(String label) {
//                        this.label = label;
//                    }
//                }
//
//                public static class ItemsBeanX {
//                    /**
//                     * activity_object : {"activity_object":{"id":"P414699"}}
//                     * category : Personal care essential
//                     * category_id : 2243
//                     * cod_availability : true
//                     * cod_message : Delivery in 5-15 working days.
//                     * delivery_time : Delivery in 5-15 working days.
//                     * delivery_time_message : {"message":"Delivery in 5-15 working days.","type":2}
//                     * discount : 0
//                     * final_discount : 0
//                     * formatted_income : Tk. 0.00
//                     * formatted_per_item_total : Tk. 725.00
//                     * formatted_price : Tk. 58.50
//                     * formatted_sale_price : Tk. 585.00
//                     * formatted_seller_price : Tk. 0.00
//                     * formatted_variant_price : Tk. 58.50
//                     * image : https://shopimages.vstores.io/uc/140564/Dettol-Handwash-170-ml-Refill-Poly-Re-energize_1-small.jpg?1591893674
//                     * is_free_item : false
//                     * liked : false
//                     * line_item_adjustments : [{"account_id":0,"adjustment_type":2,"amount":"140.0","created_at":"2020-12-08T14:21:35.000+06:00","eligible":true,"formatted_amount":"Tk. 140.00","id":10665,"income":0,"is_seller_coupon":false,"label":"Shipping Charges","line_item_id":308989,"order_id":148415,"result_2":0,"result_3":0,"seller_id":287000412,"updated_at":"2020-12-08T14:21:35.000+06:00","vaccount_id":2}]
//                     * line_item_id : 308989
//                     * master_product_id : 414699
//                     * max_item_quantity : 50
//                     * max_selling_price : 0
//                     * messages : []
//                     * min_order_qty : 1
//                     * min_selling_price : 0
//                     * mrp_price_line : Tk. 58.50 x 10 = Tk. 585.00
//                     * original_amo : 58.5
//                     * per_item_total : 725
//                     * permalink : detol-hw-poly-170-ml-re-ener-new-rate-40bebb33
//                     * prepaid_availability : true
//                     * prepaid_message : Delivery in 5-15 working days.
//                     * price : 58.5
//                     * price_line : Tk. 58.50 x 10 = Tk. 585.00
//                     * product_id : 414699
//                     * product_name : Dettol,Hw Poly 170 Ml Re-Ener- New Rate
//                     * quantity : 10
//                     * sale_price : 585
//                     * seller : Unicorn
//                     * seller_slug : unicorn
//                     * size : 170ml
//                     * sku : Detol,Hw-Poly-170-Ml-Re-Ener--New-Rate---87bea10d
//                     * slug : detol-hw-poly-170-ml-re-ener-new-rate-shopup-05bfce45
//                     * sold_out : false
//                     * title : Dettol,Hw Poly 170 Ml Re-Ener- New Rate
//                     * variant : 526050
//                     * variant_options : [{"corrected_count_on_hand":3,"count_on_hand":989,"id":526050,"name":"170ml","option_value_name":"170ml","size":5}]
//                     * variant_price : 58.5
//                     * zipcode : 934
//                     */
//
//                    private ActivityObjectBeanXXX activity_object;
//                    private String category;
//                    private int category_id;
//                    private boolean cod_availability;
//                    private String cod_message;
//                    private String delivery_time;
//                    private DeliveryTimeMessageBeanX delivery_time_message;
//                    private int discount;
//                    private int final_discount;
//                    private String formatted_income;
//                    private String formatted_per_item_total;
//                    private String formatted_price;
//                    private String formatted_sale_price;
//                    private String formatted_seller_price;
//                    private String formatted_variant_price;
//                    private String image;
//                    private boolean is_free_item;
//                    private boolean liked;
//                    private int line_item_id;
//                    private int master_product_id;
//                    private int max_item_quantity;
//                    private int max_selling_price;
//                    private int min_order_qty;
//                    private int min_selling_price;
//                    private String mrp_price_line;
//                    private double original_amo;
//                    private int per_item_total;
//                    private String permalink;
//                    private boolean prepaid_availability;
//                    private String prepaid_message;
//                    private double price;
//                    private String price_line;
//                    private int product_id;
//                    private String product_name;
//                    private int quantity;
//                    private int sale_price;
//                    private String seller;
//                    private String seller_slug;
//                    private String size;
//                    private String sku;
//                    private String slug;
//                    private boolean sold_out;
//                    private String title;
//                    private int variant;
//                    private double variant_price;
//                    private String zipcode;
//                    private List<LineItemAdjustmentsBean> line_item_adjustments;
//                    private List<?> messages;
//                    private List<VariantOptionsBeanX> variant_options;
//
//                    public ActivityObjectBeanXXX getActivity_object() {
//                        return activity_object;
//                    }
//
//                    public void setActivity_object(ActivityObjectBeanXXX activity_object) {
//                        this.activity_object = activity_object;
//                    }
//
//                    public String getCategory() {
//                        return category;
//                    }
//
//                    public void setCategory(String category) {
//                        this.category = category;
//                    }
//
//                    public int getCategory_id() {
//                        return category_id;
//                    }
//
//                    public void setCategory_id(int category_id) {
//                        this.category_id = category_id;
//                    }
//
//                    public boolean isCod_availability() {
//                        return cod_availability;
//                    }
//
//                    public void setCod_availability(boolean cod_availability) {
//                        this.cod_availability = cod_availability;
//                    }
//
//                    public String getCod_message() {
//                        return cod_message;
//                    }
//
//                    public void setCod_message(String cod_message) {
//                        this.cod_message = cod_message;
//                    }
//
//                    public String getDelivery_time() {
//                        return delivery_time;
//                    }
//
//                    public void setDelivery_time(String delivery_time) {
//                        this.delivery_time = delivery_time;
//                    }
//
//                    public DeliveryTimeMessageBeanX getDelivery_time_message() {
//                        return delivery_time_message;
//                    }
//
//                    public void setDelivery_time_message(DeliveryTimeMessageBeanX delivery_time_message) {
//                        this.delivery_time_message = delivery_time_message;
//                    }
//
//                    public int getDiscount() {
//                        return discount;
//                    }
//
//                    public void setDiscount(int discount) {
//                        this.discount = discount;
//                    }
//
//                    public int getFinal_discount() {
//                        return final_discount;
//                    }
//
//                    public void setFinal_discount(int final_discount) {
//                        this.final_discount = final_discount;
//                    }
//
//                    public String getFormatted_income() {
//                        return formatted_income;
//                    }
//
//                    public void setFormatted_income(String formatted_income) {
//                        this.formatted_income = formatted_income;
//                    }
//
//                    public String getFormatted_per_item_total() {
//                        return formatted_per_item_total;
//                    }
//
//                    public void setFormatted_per_item_total(String formatted_per_item_total) {
//                        this.formatted_per_item_total = formatted_per_item_total;
//                    }
//
//                    public String getFormatted_price() {
//                        return formatted_price;
//                    }
//
//                    public void setFormatted_price(String formatted_price) {
//                        this.formatted_price = formatted_price;
//                    }
//
//                    public String getFormatted_sale_price() {
//                        return formatted_sale_price;
//                    }
//
//                    public void setFormatted_sale_price(String formatted_sale_price) {
//                        this.formatted_sale_price = formatted_sale_price;
//                    }
//
//                    public String getFormatted_seller_price() {
//                        return formatted_seller_price;
//                    }
//
//                    public void setFormatted_seller_price(String formatted_seller_price) {
//                        this.formatted_seller_price = formatted_seller_price;
//                    }
//
//                    public String getFormatted_variant_price() {
//                        return formatted_variant_price;
//                    }
//
//                    public void setFormatted_variant_price(String formatted_variant_price) {
//                        this.formatted_variant_price = formatted_variant_price;
//                    }
//
//                    public String getImage() {
//                        return image;
//                    }
//
//                    public void setImage(String image) {
//                        this.image = image;
//                    }
//
//                    public boolean isIs_free_item() {
//                        return is_free_item;
//                    }
//
//                    public void setIs_free_item(boolean is_free_item) {
//                        this.is_free_item = is_free_item;
//                    }
//
//                    public boolean isLiked() {
//                        return liked;
//                    }
//
//                    public void setLiked(boolean liked) {
//                        this.liked = liked;
//                    }
//
//                    public int getLine_item_id() {
//                        return line_item_id;
//                    }
//
//                    public void setLine_item_id(int line_item_id) {
//                        this.line_item_id = line_item_id;
//                    }
//
//                    public int getMaster_product_id() {
//                        return master_product_id;
//                    }
//
//                    public void setMaster_product_id(int master_product_id) {
//                        this.master_product_id = master_product_id;
//                    }
//
//                    public int getMax_item_quantity() {
//                        return max_item_quantity;
//                    }
//
//                    public void setMax_item_quantity(int max_item_quantity) {
//                        this.max_item_quantity = max_item_quantity;
//                    }
//
//                    public int getMax_selling_price() {
//                        return max_selling_price;
//                    }
//
//                    public void setMax_selling_price(int max_selling_price) {
//                        this.max_selling_price = max_selling_price;
//                    }
//
//                    public int getMin_order_qty() {
//                        return min_order_qty;
//                    }
//
//                    public void setMin_order_qty(int min_order_qty) {
//                        this.min_order_qty = min_order_qty;
//                    }
//
//                    public int getMin_selling_price() {
//                        return min_selling_price;
//                    }
//
//                    public void setMin_selling_price(int min_selling_price) {
//                        this.min_selling_price = min_selling_price;
//                    }
//
//                    public String getMrp_price_line() {
//                        return mrp_price_line;
//                    }
//
//                    public void setMrp_price_line(String mrp_price_line) {
//                        this.mrp_price_line = mrp_price_line;
//                    }
//
//                    public double getOriginal_amo() {
//                        return original_amo;
//                    }
//
//                    public void setOriginal_amo(double original_amo) {
//                        this.original_amo = original_amo;
//                    }
//
//                    public int getPer_item_total() {
//                        return per_item_total;
//                    }
//
//                    public void setPer_item_total(int per_item_total) {
//                        this.per_item_total = per_item_total;
//                    }
//
//                    public String getPermalink() {
//                        return permalink;
//                    }
//
//                    public void setPermalink(String permalink) {
//                        this.permalink = permalink;
//                    }
//
//                    public boolean isPrepaid_availability() {
//                        return prepaid_availability;
//                    }
//
//                    public void setPrepaid_availability(boolean prepaid_availability) {
//                        this.prepaid_availability = prepaid_availability;
//                    }
//
//                    public String getPrepaid_message() {
//                        return prepaid_message;
//                    }
//
//                    public void setPrepaid_message(String prepaid_message) {
//                        this.prepaid_message = prepaid_message;
//                    }
//
//                    public double getPrice() {
//                        return price;
//                    }
//
//                    public void setPrice(double price) {
//                        this.price = price;
//                    }
//
//                    public String getPrice_line() {
//                        return price_line;
//                    }
//
//                    public void setPrice_line(String price_line) {
//                        this.price_line = price_line;
//                    }
//
//                    public int getProduct_id() {
//                        return product_id;
//                    }
//
//                    public void setProduct_id(int product_id) {
//                        this.product_id = product_id;
//                    }
//
//                    public String getProduct_name() {
//                        return product_name;
//                    }
//
//                    public void setProduct_name(String product_name) {
//                        this.product_name = product_name;
//                    }
//
//                    public int getQuantity() {
//                        return quantity;
//                    }
//
//                    public void setQuantity(int quantity) {
//                        this.quantity = quantity;
//                    }
//
//                    public int getSale_price() {
//                        return sale_price;
//                    }
//
//                    public void setSale_price(int sale_price) {
//                        this.sale_price = sale_price;
//                    }
//
//                    public String getSeller() {
//                        return seller;
//                    }
//
//                    public void setSeller(String seller) {
//                        this.seller = seller;
//                    }
//
//                    public String getSeller_slug() {
//                        return seller_slug;
//                    }
//
//                    public void setSeller_slug(String seller_slug) {
//                        this.seller_slug = seller_slug;
//                    }
//
//                    public String getSize() {
//                        return size;
//                    }
//
//                    public void setSize(String size) {
//                        this.size = size;
//                    }
//
//                    public String getSku() {
//                        return sku;
//                    }
//
//                    public void setSku(String sku) {
//                        this.sku = sku;
//                    }
//
//                    public String getSlug() {
//                        return slug;
//                    }
//
//                    public void setSlug(String slug) {
//                        this.slug = slug;
//                    }
//
//                    public boolean isSold_out() {
//                        return sold_out;
//                    }
//
//                    public void setSold_out(boolean sold_out) {
//                        this.sold_out = sold_out;
//                    }
//
//                    public String getTitle() {
//                        return title;
//                    }
//
//                    public void setTitle(String title) {
//                        this.title = title;
//                    }
//
//                    public int getVariant() {
//                        return variant;
//                    }
//
//                    public void setVariant(int variant) {
//                        this.variant = variant;
//                    }
//
//                    public double getVariant_price() {
//                        return variant_price;
//                    }
//
//                    public void setVariant_price(double variant_price) {
//                        this.variant_price = variant_price;
//                    }
//
//                    public String getZipcode() {
//                        return zipcode;
//                    }
//
//                    public void setZipcode(String zipcode) {
//                        this.zipcode = zipcode;
//                    }
//
//                    public List<LineItemAdjustmentsBean> getLine_item_adjustments() {
//                        return line_item_adjustments;
//                    }
//
//                    public void setLine_item_adjustments(List<LineItemAdjustmentsBean> line_item_adjustments) {
//                        this.line_item_adjustments = line_item_adjustments;
//                    }
//
//                    public List<?> getMessages() {
//                        return messages;
//                    }
//
//                    public void setMessages(List<?> messages) {
//                        this.messages = messages;
//                    }
//
//                    public List<VariantOptionsBeanX> getVariant_options() {
//                        return variant_options;
//                    }
//
//                    public void setVariant_options(List<VariantOptionsBeanX> variant_options) {
//                        this.variant_options = variant_options;
//                    }
//
//                    public static class ActivityObjectBeanXXX {
//                        /**
//                         * activity_object : {"id":"P414699"}
//                         */
//
//                        private ActivityObjectBeanXX activity_object;
//
//                        public ActivityObjectBeanXX getActivity_object() {
//                            return activity_object;
//                        }
//
//                        public void setActivity_object(ActivityObjectBeanXX activity_object) {
//                            this.activity_object = activity_object;
//                        }
//
//                        public static class ActivityObjectBeanXX {
//                            /**
//                             * id : P414699
//                             */
//
//                            private String id;
//
//                            public String getId() {
//                                return id;
//                            }
//
//                            public void setId(String id) {
//                                this.id = id;
//                            }
//                        }
//                    }
//
//                    public static class DeliveryTimeMessageBeanX {
//                        /**
//                         * message : Delivery in 5-15 working days.
//                         * type : 2
//                         */
//
//                        private String message;
//                        private int type;
//
//                        public String getMessage() {
//                            return message;
//                        }
//
//                        public void setMessage(String message) {
//                            this.message = message;
//                        }
//
//                        public int getType() {
//                            return type;
//                        }
//
//                        public void setType(int type) {
//                            this.type = type;
//                        }
//                    }
//
//                    public static class LineItemAdjustmentsBean {
//                        /**
//                         * account_id : 0
//                         * adjustment_type : 2
//                         * amount : 140.0
//                         * created_at : 2020-12-08T14:21:35.000+06:00
//                         * eligible : true
//                         * formatted_amount : Tk. 140.00
//                         * id : 10665
//                         * income : 0
//                         * is_seller_coupon : false
//                         * label : Shipping Charges
//                         * line_item_id : 308989
//                         * order_id : 148415
//                         * result_2 : 0
//                         * result_3 : 0
//                         * seller_id : 287000412
//                         * updated_at : 2020-12-08T14:21:35.000+06:00
//                         * vaccount_id : 2
//                         */
//
//                        private int account_id;
//                        private int adjustment_type;
//                        private String amount;
//                        private String created_at;
//                        private boolean eligible;
//                        private String formatted_amount;
//                        private int id;
//                        private int income;
//                        private boolean is_seller_coupon;
//                        private String label;
//                        private int line_item_id;
//                        private int order_id;
//                        private int result_2;
//                        private int result_3;
//                        private int seller_id;
//                        private String updated_at;
//                        private int vaccount_id;
//
//                        public int getAccount_id() {
//                            return account_id;
//                        }
//
//                        public void setAccount_id(int account_id) {
//                            this.account_id = account_id;
//                        }
//
//                        public int getAdjustment_type() {
//                            return adjustment_type;
//                        }
//
//                        public void setAdjustment_type(int adjustment_type) {
//                            this.adjustment_type = adjustment_type;
//                        }
//
//                        public String getAmount() {
//                            return amount;
//                        }
//
//                        public void setAmount(String amount) {
//                            this.amount = amount;
//                        }
//
//                        public String getCreated_at() {
//                            return created_at;
//                        }
//
//                        public void setCreated_at(String created_at) {
//                            this.created_at = created_at;
//                        }
//
//                        public boolean isEligible() {
//                            return eligible;
//                        }
//
//                        public void setEligible(boolean eligible) {
//                            this.eligible = eligible;
//                        }
//
//                        public String getFormatted_amount() {
//                            return formatted_amount;
//                        }
//
//                        public void setFormatted_amount(String formatted_amount) {
//                            this.formatted_amount = formatted_amount;
//                        }
//
//                        public int getId() {
//                            return id;
//                        }
//
//                        public void setId(int id) {
//                            this.id = id;
//                        }
//
//                        public int getIncome() {
//                            return income;
//                        }
//
//                        public void setIncome(int income) {
//                            this.income = income;
//                        }
//
//                        public boolean isIs_seller_coupon() {
//                            return is_seller_coupon;
//                        }
//
//                        public void setIs_seller_coupon(boolean is_seller_coupon) {
//                            this.is_seller_coupon = is_seller_coupon;
//                        }
//
//                        public String getLabel() {
//                            return label;
//                        }
//
//                        public void setLabel(String label) {
//                            this.label = label;
//                        }
//
//                        public int getLine_item_id() {
//                            return line_item_id;
//                        }
//
//                        public void setLine_item_id(int line_item_id) {
//                            this.line_item_id = line_item_id;
//                        }
//
//                        public int getOrder_id() {
//                            return order_id;
//                        }
//
//                        public void setOrder_id(int order_id) {
//                            this.order_id = order_id;
//                        }
//
//                        public int getResult_2() {
//                            return result_2;
//                        }
//
//                        public void setResult_2(int result_2) {
//                            this.result_2 = result_2;
//                        }
//
//                        public int getResult_3() {
//                            return result_3;
//                        }
//
//                        public void setResult_3(int result_3) {
//                            this.result_3 = result_3;
//                        }
//
//                        public int getSeller_id() {
//                            return seller_id;
//                        }
//
//                        public void setSeller_id(int seller_id) {
//                            this.seller_id = seller_id;
//                        }
//
//                        public String getUpdated_at() {
//                            return updated_at;
//                        }
//
//                        public void setUpdated_at(String updated_at) {
//                            this.updated_at = updated_at;
//                        }
//
//                        public int getVaccount_id() {
//                            return vaccount_id;
//                        }
//
//                        public void setVaccount_id(int vaccount_id) {
//                            this.vaccount_id = vaccount_id;
//                        }
//                    }
//
//                    public static class VariantOptionsBeanX {
//                        /**
//                         * corrected_count_on_hand : 3
//                         * count_on_hand : 989
//                         * id : 526050
//                         * name : 170ml
//                         * option_value_name : 170ml
//                         * size : 5
//                         */
//
//                        private int corrected_count_on_hand;
//                        private int count_on_hand;
//                        private int id;
//                        private String name;
//                        private String option_value_name;
//                        private int size;
//
//                        public int getCorrected_count_on_hand() {
//                            return corrected_count_on_hand;
//                        }
//
//                        public void setCorrected_count_on_hand(int corrected_count_on_hand) {
//                            this.corrected_count_on_hand = corrected_count_on_hand;
//                        }
//
//                        public int getCount_on_hand() {
//                            return count_on_hand;
//                        }
//
//                        public void setCount_on_hand(int count_on_hand) {
//                            this.count_on_hand = count_on_hand;
//                        }
//
//                        public int getId() {
//                            return id;
//                        }
//
//                        public void setId(int id) {
//                            this.id = id;
//                        }
//
//                        public String getName() {
//                            return name;
//                        }
//
//                        public void setName(String name) {
//                            this.name = name;
//                        }
//
//                        public String getOption_value_name() {
//                            return option_value_name;
//                        }
//
//                        public void setOption_value_name(String option_value_name) {
//                            this.option_value_name = option_value_name;
//                        }
//
//                        public int getSize() {
//                            return size;
//                        }
//
//                        public void setSize(int size) {
//                            this.size = size;
//                        }
//                    }
//                }
//            }
//        }

        public static class VcashDataBean {
            /**
             * approved_vcash : 0
             * available_vcash : 0
             * show_vcash_form : true
             * vcash_already_applied_in_order : 0
             */

            private int approved_vcash;
            private int available_vcash;
            private boolean show_vcash_form;
            private int vcash_already_applied_in_order;

            public int getApproved_vcash() {
                return approved_vcash;
            }

            public void setApproved_vcash(int approved_vcash) {
                this.approved_vcash = approved_vcash;
            }

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
        }

        public static class AdjustmentsBeanX {
            /**
             * amount : 50
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
}
