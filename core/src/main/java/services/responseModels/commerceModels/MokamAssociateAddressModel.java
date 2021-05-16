package services.responseModels.commerceModels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MokamAssociateAddressModel {

    private boolean check_duplicate_order;
    private boolean coupon_code_applied;
    private boolean disable_cart_purchase;
    private String disable_cart_timer;
    private EnableMandatorySignInBean enable_mandatory_sign_in;
    private boolean enable_online_payment_banner;
    private boolean enable_prepaid_retry;
    private EnablePrimoCartPopupBean enable_primo_cart_popup;
    private boolean enable_remove_coupon;
    @SerializedName("is_gamified_order?")
    private boolean _$Is_gamified_order221; // FIXME check this code
    private String juspay_merchant_id;
    private int maximum_delivery_charge;
    private String message;
    private int minimum_delivery_charge;
    private String online_payment_banner_link;
    private OrderAddressBean order_address;
    private OrderDataBean order_data;
    private PaymentPendingOrdersBean payment_pending_orders;
    private PrepaidMessageConfigBean prepaid_message_config;
    private String prepaid_order_message;
    private String prepaid_preference_message;
    private String prepaid_retry_message;
    private PrimoCartImagesBean primo_cart_images;
    private String retry_message_for_close_popup;
    private ShipAddressBean ship_address;
    private String shop_name;
    private boolean show_pdp_link_in_address_page;
    private boolean show_saved_cards;
    private boolean signed_in_user;
    private boolean single_step_checkout;
    private SpecialInstructionsBean special_instructions;
    private int status;
    private boolean user_email_valid;
    private List<?> cart_items;
    private List<CountryListBean> country_list;
    private List<?> coupon_applied;
    private List<?> coupon_display_messages;
    private List<?> payment_types;
    private List<?> serviceable_line_items;
    private List<ShippedAddressesBean> shipped_addresses;

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

    public EnableMandatorySignInBean getEnable_mandatory_sign_in() {
        return enable_mandatory_sign_in;
    }

    public void setEnable_mandatory_sign_in(EnableMandatorySignInBean enable_mandatory_sign_in) {
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

    public EnablePrimoCartPopupBean getEnable_primo_cart_popup() {
        return enable_primo_cart_popup;
    }

    public void setEnable_primo_cart_popup(EnablePrimoCartPopupBean enable_primo_cart_popup) {
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

    public OrderAddressBean getOrder_address() {
        return order_address;
    }

    public void setOrder_address(OrderAddressBean order_address) {
        this.order_address = order_address;
    }

    public OrderDataBean getOrder_data() {
        return order_data;
    }

    public void setOrder_data(OrderDataBean order_data) {
        this.order_data = order_data;
    }

    public PaymentPendingOrdersBean getPayment_pending_orders() {
        return payment_pending_orders;
    }

    public void setPayment_pending_orders(PaymentPendingOrdersBean payment_pending_orders) {
        this.payment_pending_orders = payment_pending_orders;
    }

    public PrepaidMessageConfigBean getPrepaid_message_config() {
        return prepaid_message_config;
    }

    public void setPrepaid_message_config(PrepaidMessageConfigBean prepaid_message_config) {
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

    public PrimoCartImagesBean getPrimo_cart_images() {
        return primo_cart_images;
    }

    public void setPrimo_cart_images(PrimoCartImagesBean primo_cart_images) {
        this.primo_cart_images = primo_cart_images;
    }

    public String getRetry_message_for_close_popup() {
        return retry_message_for_close_popup;
    }

    public void setRetry_message_for_close_popup(String retry_message_for_close_popup) {
        this.retry_message_for_close_popup = retry_message_for_close_popup;
    }

    public ShipAddressBean getShip_address() {
        return ship_address;
    }

    public void setShip_address(ShipAddressBean ship_address) {
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

    public SpecialInstructionsBean getSpecial_instructions() {
        return special_instructions;
    }

    public void setSpecial_instructions(SpecialInstructionsBean special_instructions) {
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

    public List<CountryListBean> getCountry_list() {
        return country_list;
    }

    public void setCountry_list(List<CountryListBean> country_list) {
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

    public List<ShippedAddressesBean> getShipped_addresses() {
        return shipped_addresses;
    }

    public void setShipped_addresses(List<ShippedAddressesBean> shipped_addresses) {
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
        private AddressBean address;

        public AddressBean getAddress() {
            return address;
        }

        public void setAddress(AddressBean address) {
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
            private String zone;

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

            public String getZone() {
                return zone;
            }

            public void setZone(String zone) {
                this.zone = zone;
            }
        }
    }

    public static class OrderDataBean {
//        private List<?> li_by_sellers;
//
//        public List<?> getLi_by_sellers() {
//            return li_by_sellers;
//        }
//
//        public void setLi_by_sellers(List<?> li_by_sellers) {
//            this.li_by_sellers = li_by_sellers;
//        }


//        private int cart_items_total;
//        private boolean cod_availability;
//        private boolean code_applied;
//        private int count;
//        private String coupon_applied_message;
//        private int error_message;
//        private String formatted_total_income;
//        private int item_total;
//        private LiBySellersBean li_by_sellers;
//        private boolean new_user_check_for_nps;
//        private String order_number;
//        private String payment_method;
//        private boolean prepaid_availability;
//        private int remaining_vcash;
//        private int subtotal;
//        private int total;
//        private int total_income;
//        private VcashDataBean vcash_data;
//        private List<AdjustmentsBean> adjustments;
//        private List<?> lastmile_addresses;
//        private List<?> messages;
//
//        public int getCart_items_total() {
//            return cart_items_total;
//        }
//
//        public void setCart_items_total(int cart_items_total) {
//            this.cart_items_total = cart_items_total;
//        }
//
//        public boolean isCod_availability() {
//            return cod_availability;
//        }
//
//        public void setCod_availability(boolean cod_availability) {
//            this.cod_availability = cod_availability;
//        }
//
//        public boolean isCode_applied() {
//            return code_applied;
//        }
//
//        public void setCode_applied(boolean code_applied) {
//            this.code_applied = code_applied;
//        }
//
//        public int getCount() {
//            return count;
//        }
//
//        public void setCount(int count) {
//            this.count = count;
//        }
//
//        public String getCoupon_applied_message() {
//            return coupon_applied_message;
//        }
//
//        public void setCoupon_applied_message(String coupon_applied_message) {
//            this.coupon_applied_message = coupon_applied_message;
//        }
//
//        public int getError_message() {
//            return error_message;
//        }
//
//        public void setError_message(int error_message) {
//            this.error_message = error_message;
//        }
//
//        public String getFormatted_total_income() {
//            return formatted_total_income;
//        }
//
//        public void setFormatted_total_income(String formatted_total_income) {
//            this.formatted_total_income = formatted_total_income;
//        }
//
//        public int getItem_total() {
//            return item_total;
//        }
//
//        public void setItem_total(int item_total) {
//            this.item_total = item_total;
//        }
//
//        public LiBySellersBean getLi_by_sellers() {
//            return li_by_sellers;
//        }
//
//        public void setLi_by_sellers(LiBySellersBean li_by_sellers) {
//            this.li_by_sellers = li_by_sellers;
//        }
//
//        public boolean isNew_user_check_for_nps() {
//            return new_user_check_for_nps;
//        }
//
//        public void setNew_user_check_for_nps(boolean new_user_check_for_nps) {
//            this.new_user_check_for_nps = new_user_check_for_nps;
//        }
//
//        public String getOrder_number() {
//            return order_number;
//        }
//
//        public void setOrder_number(String order_number) {
//            this.order_number = order_number;
//        }
//
//        public String getPayment_method() {
//            return payment_method;
//        }
//
//        public void setPayment_method(String payment_method) {
//            this.payment_method = payment_method;
//        }
//
//        public boolean isPrepaid_availability() {
//            return prepaid_availability;
//        }
//
//        public void setPrepaid_availability(boolean prepaid_availability) {
//            this.prepaid_availability = prepaid_availability;
//        }
//
//        public int getRemaining_vcash() {
//            return remaining_vcash;
//        }
//
//        public void setRemaining_vcash(int remaining_vcash) {
//            this.remaining_vcash = remaining_vcash;
//        }
//
//        public int getSubtotal() {
//            return subtotal;
//        }
//
//        public void setSubtotal(int subtotal) {
//            this.subtotal = subtotal;
//        }
//
//        public int getTotal() {
//            return total;
//        }
//
//        public void setTotal(int total) {
//            this.total = total;
//        }
//
//        public int getTotal_income() {
//            return total_income;
//        }
//
//        public void setTotal_income(int total_income) {
//            this.total_income = total_income;
//        }
//
//        public VcashDataBean getVcash_data() {
//            return vcash_data;
//        }
//
//        public void setVcash_data(VcashDataBean vcash_data) {
//            this.vcash_data = vcash_data;
//        }
//
//        public List<AdjustmentsBean> getAdjustments() {
//            return adjustments;
//        }
//
//        public void setAdjustments(List<AdjustmentsBean> adjustments) {
//            this.adjustments = adjustments;
//        }
//
//        public List<?> getLastmile_addresses() {
//            return lastmile_addresses;
//        }
//
//        public void setLastmile_addresses(List<?> lastmile_addresses) {
//            this.lastmile_addresses = lastmile_addresses;
//        }
//
//        public List<?> getMessages() {
//            return messages;
//        }
//
//        public void setMessages(List<?> messages) {
//            this.messages = messages;
//        }
//
//        public static class LiBySellersBean {
//            private UnbrandedBean Unbranded;
//
//            public UnbrandedBean getUnbranded() {
//                return Unbranded;
//            }
//
//            public void setUnbranded(UnbrandedBean Unbranded) {
//                this.Unbranded = Unbranded;
//            }
//
//            public static class UnbrandedBean {
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
//                    private ActivityObjectBeanX activity_object;
//                    private String category;
//                    private int category_id;
//                    private boolean cod_availability;
//                    private String cod_message;
//                    private String delivery_time;
//                    private DeliveryTimeMessageBean delivery_time_message;
//                    private double discount;
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
//                    public double getDiscount() {
//                        return discount;
//                    }
//
//                    public void setDiscount(double discount) {
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
        }

        public static class VcashDataBean {
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

        public static class AdjustmentsBean {
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


    public static class PaymentPendingOrdersBean {
        private boolean is_present;
        private List<?> orders_list;

        public boolean isIs_present() {
            return is_present;
        }

        public void setIs_present(boolean is_present) {
            this.is_present = is_present;
        }

        public List<?> getOrders_list() {
            return orders_list;
        }

        public void setOrders_list(List<?> orders_list) {
            this.orders_list = orders_list;
        }
    }

    public static class PrepaidMessageConfigBean {
        private String prepaid_order_message;
        private String prepaid_retry_message;
        private String retry_message_for_close_popup;

        public String getPrepaid_order_message() {
            return prepaid_order_message;
        }

        public void setPrepaid_order_message(String prepaid_order_message) {
            this.prepaid_order_message = prepaid_order_message;
        }

        public String getPrepaid_retry_message() {
            return prepaid_retry_message;
        }

        public void setPrepaid_retry_message(String prepaid_retry_message) {
            this.prepaid_retry_message = prepaid_retry_message;
        }

        public String getRetry_message_for_close_popup() {
            return retry_message_for_close_popup;
        }

        public void setRetry_message_for_close_popup(String retry_message_for_close_popup) {
            this.retry_message_for_close_popup = retry_message_for_close_popup;
        }
    }

    public static class PrimoCartImagesBean {
        private String wap_signed;
        private String wap_unsigned;
        private String web_signed;
        private String web_unsigned;

        public String getWap_signed() {
            return wap_signed;
        }

        public void setWap_signed(String wap_signed) {
            this.wap_signed = wap_signed;
        }

        public String getWap_unsigned() {
            return wap_unsigned;
        }

        public void setWap_unsigned(String wap_unsigned) {
            this.wap_unsigned = wap_unsigned;
        }

        public String getWeb_signed() {
            return web_signed;
        }

        public void setWeb_signed(String web_signed) {
            this.web_signed = web_signed;
        }

        public String getWeb_unsigned() {
            return web_unsigned;
        }

        public void setWeb_unsigned(String web_unsigned) {
            this.web_unsigned = web_unsigned;
        }
    }

    public static class ShipAddressBean {
        private AddressBeanX address;

        public AddressBeanX getAddress() {
            return address;
        }

        public void setAddress(AddressBeanX address) {
            this.address = address;
        }

        public static class AddressBeanX {
            private int user_id;
            private int id;
            private String firstname;
            private String lastname;
            private String address1;
            private String address2;
            private String city;
            private String phone;
            private String landmark;
            private String zipcode;
            private String state;
            private String country;
            private int country_id;
            private int state_id;
            private String location;
            private String zone;

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getFirstname() {
                return firstname;
            }

            public void setFirstname(String firstname) {
                this.firstname = firstname;
            }

            public String getLastname() {
                return lastname;
            }

            public void setLastname(String lastname) {
                this.lastname = lastname;
            }

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

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getLandmark() {
                return landmark;
            }

            public void setLandmark(String landmark) {
                this.landmark = landmark;
            }

            public String getZipcode() {
                return zipcode;
            }

            public void setZipcode(String zipcode) {
                this.zipcode = zipcode;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public int getCountry_id() {
                return country_id;
            }

            public void setCountry_id(int country_id) {
                this.country_id = country_id;
            }

            public int getState_id() {
                return state_id;
            }

            public void setState_id(int state_id) {
                this.state_id = state_id;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getZone() {
                return zone;
            }

            public void setZone(String zone) {
                this.zone = zone;
            }
        }
    }

    public static class SpecialInstructionsBean {
        private String customer_preferred_delivery_date;
        private String preferred_days;
        private String preferred_slots;
        private String text;

        public String getCustomer_preferred_delivery_date() {
            return customer_preferred_delivery_date;
        }

        public void setCustomer_preferred_delivery_date(String customer_preferred_delivery_date) {
            this.customer_preferred_delivery_date = customer_preferred_delivery_date;
        }

        public String getPreferred_days() {
            return preferred_days;
        }

        public void setPreferred_days(String preferred_days) {
            this.preferred_days = preferred_days;
        }

        public String getPreferred_slots() {
            return preferred_slots;
        }

        public void setPreferred_slots(String preferred_slots) {
            this.preferred_slots = preferred_slots;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public static class CountryListBean {
        private String code;
        private double conversion_rate;
        private String currency;
        private String currency_code;
        private String currency_unicode;
        private String extra_data;
        private String flag;
        private int id;
        private String name;
        private String status;
        private String updated_at;
        private String created_at;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public double getConversion_rate() {
            return conversion_rate;
        }

        public void setConversion_rate(double conversion_rate) {
            this.conversion_rate = conversion_rate;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getCurrency_code() {
            return currency_code;
        }

        public void setCurrency_code(String currency_code) {
            this.currency_code = currency_code;
        }

        public String getCurrency_unicode() {
            return currency_unicode;
        }

        public void setCurrency_unicode(String currency_unicode) {
            this.currency_unicode = currency_unicode;
        }

        public String getExtra_data() {
            return extra_data;
        }

        public void setExtra_data(String extra_data) {
            this.extra_data = extra_data;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }
    }

    public static class ShippedAddressesBean {
        private int user_id;
        private int id;
        private String firstname;
        private String lastname;
        private String address1;
        private String city;
        private String phone;
        private String landmark;
        private String zipcode;
        private String state;
        private String country;
        private int country_id;
        private int state_id;
        private String location;
        private String zone;
        private String address2;
        private String alternative_phone;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getLandmark() {
            return landmark;
        }

        public void setLandmark(String landmark) {
            this.landmark = landmark;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public int getCountry_id() {
            return country_id;
        }

        public void setCountry_id(int country_id) {
            this.country_id = country_id;
        }

        public int getState_id() {
            return state_id;
        }

        public void setState_id(int state_id) {
            this.state_id = state_id;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getZone() {
            return zone;
        }

        public void setZone(String zone) {
            this.zone = zone;
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
    }
}
