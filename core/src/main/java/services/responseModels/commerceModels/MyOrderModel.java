package services.responseModels.commerceModels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyOrderModel {

    private List<AllmyordersBean> allmyorders;
    private List<CancelReasonsBean> cancel_reasons;
    private List<ExchangeReasonsBean> exchange_reasons;
    private List<ReturnReasonsBean> return_reasons;

    public List<AllmyordersBean> getAllmyorders() {
        return allmyorders;
    }

    public void setAllmyorders(List<AllmyordersBean> allmyorders) {
        this.allmyorders = allmyorders;
    }

    public List<CancelReasonsBean> getCancel_reasons() {
        return cancel_reasons;
    }

    public void setCancel_reasons(List<CancelReasonsBean> cancel_reasons) {
        this.cancel_reasons = cancel_reasons;
    }

    public List<ExchangeReasonsBean> getExchange_reasons() {
        return exchange_reasons;
    }

    public void setExchange_reasons(List<ExchangeReasonsBean> exchange_reasons) {
        this.exchange_reasons = exchange_reasons;
    }

    public List<ReturnReasonsBean> getReturn_reasons() {
        return return_reasons;
    }

    public void setReturn_reasons(List<ReturnReasonsBean> return_reasons) {
        this.return_reasons = return_reasons;
    }

    public static class AllmyordersBean {
        /**
         * customer_order : {"add_bkash_available":false,"adjustment_total":120,"auto_confirmation_available?":false,"completed_at":"2020-07-27T00:21:36.000+06:00","editable_address":false,"editable_payment_method":false,"email":"iamasthme@gmail.com","formatted_total":"Tk. 4241","item_total":4121,"number":"R9955424107","order_confirmation_text":{"alternative_otp_text":"Our Executive will contact you shortly to confirm your order","popup_text":" Alternatively you can give a missed call to 9243000043 to confirm the order"},"payment_method_id":1,"prepaid_pending_status":false,"ship_address":{"address1":"Shopf Street","address2":"","address_type":"N/A","alternative_phone":"N/A","city":"Bagerhat Sadar, Bagerhat","company":null,"country":"India","firstname":"Naveen","landmark":"","lastname":" ","phone":8801877655690,"state":"Andhra Pradesh","user_address_id":9122855,"zipcode":"755"},"ship_address_id":1432696,"total":4241,"vendor_orders":[{"vendor_packages":[{"fullfillment_type":2,"shipment_provider_id":null,"state":135,"tracking_code":null,"tracking_link":null,"vendor_order_line_items":[{"editable_size":false,"formatted_price":"Tk. 399","formatted_total_product_price":"Tk. 399","get_progress_state":{"code":"Waiting for Wholesaler confirmation","end_state_details":[{"changed_at":"Jul 27,2020","code":"Waiting for Wholesaler confirmation"}],"is_negative":false,"progress_position":20,"stages":["Placed","Processed","Dispatched","Delivered"]},"id":924432,"image_url":"https://shopimages.vstores.io/15256/1569927970391-19-small.jpg?1580192775","price":399,"product_id":65251,"product_name":"Navy Blue Sleeve Casual Shirt for Men - UPF","quantity":1,"sale_price":null,"seller_name":"Update Fashion ","size_str":"L","sku":"264039","slug":"navy-blue-sleeve-casual-shirt-for-men-upf-shopup-6e663d38","total_product_price":399}],"vendor_package_tracking_details":[{"formated_change_expected_at":"Aug 08,2020","formated_changed_at":null,"formatted_customer_visible_text":"With you now","progress_position":40,"state":400}]}]},{"vendor_packages":[{"fullfillment_type":2,"shipment_provider_id":null,"state":135,"tracking_code":null,"tracking_link":null,"vendor_order_line_items":[{"editable_size":false,"formatted_price":"Tk. 733","formatted_total_product_price":"Tk. 733","get_progress_state":{"code":"Waiting for Wholesaler confirmation","end_state_details":[{"changed_at":"Jul 27,2020","code":"Waiting for Wholesaler confirmation"}],"is_negative":false,"progress_position":20,"stages":["Placed","Processed","Dispatched","Delivered"]},"id":924433,"image_url":"https://shopimages.vstores.io/41391/1575284915862-2-small.jpg?1580120187","price":733,"product_id":19314,"product_name":"Casual Check Shirt - 2 - Brown Check - ABL","quantity":1,"sale_price":null,"seller_name":"Aeroblue","size_str":"XL","sku":"295320","slug":"casual-check-shirt-2-brown-check-abl-shopup-cacaee26","total_product_price":733}],"vendor_package_tracking_details":[{"formated_change_expected_at":"Aug 08,2020","formated_changed_at":null,"formatted_customer_visible_text":"With you now","progress_position":40,"state":400}]}]},{"vendor_packages":[{"fullfillment_type":2,"shipment_provider_id":null,"state":135,"tracking_code":null,"tracking_link":null,"vendor_order_line_items":[{"editable_size":false,"formatted_price":"Tk. 466","formatted_total_product_price":"Tk. 466","get_progress_state":{"code":"Waiting for Wholesaler confirmation","end_state_details":[{"changed_at":"Jul 27,2020","code":"Waiting for Wholesaler confirmation"}],"is_negative":false,"progress_position":20,"stages":["Placed","Processed","Dispatched","Delivered"]},"id":924434,"image_url":"https://shopimages.vstores.io/49386/1570621593488-whatsappimage2019-10-06at4.25.12pm1-small.jpeg?1580195418","price":466,"product_id":68394,"product_name":"Trendy Casual Full Sleeve Cotton Shirt for Men- 0074- DKB","quantity":1,"sale_price":null,"seller_name":"Dokander Bari","size_str":"M","sku":"268260","slug":"trendy-casual-full-sleeve-cotton-shirt-for-men-0074-dkb-shopup-211bde5d","total_product_price":466}],"vendor_package_tracking_details":[{"formated_change_expected_at":"Aug 08,2020","formated_changed_at":null,"formatted_customer_visible_text":"With you now","progress_position":40,"state":400}]}]},{"vendor_packages":[{"fullfillment_type":2,"shipment_provider_id":null,"state":135,"tracking_code":null,"tracking_link":null,"vendor_order_line_items":[{"editable_size":false,"formatted_price":"Tk. 633","formatted_total_product_price":"Tk. 1899","get_progress_state":{"code":"Waiting for Wholesaler confirmation","end_state_details":[{"changed_at":"Jul 27,2020","code":"Waiting for Wholesaler confirmation"}],"is_negative":false,"progress_position":20,"stages":["Placed","Processed","Dispatched","Delivered"]},"id":924435,"image_url":"https://shopimages.vstores.io/11204/1563612152851-rbvawvwzq4gabhm-aankelrp-9i025-small.jpg?1580157539","price":633,"product_id":40211,"product_name":"A1/W8 Smart Watch - 001 - Multi Color - WLB","quantity":3,"sale_price":null,"seller_name":"Welcome BD","size_str":"option","sku":"227724","slug":"a1-w8-smart-watch-001-multi-color-wlb-shopup-84018328","total_product_price":1899}],"vendor_package_tracking_details":[{"formated_change_expected_at":"Aug 08,2020","formated_changed_at":null,"formatted_customer_visible_text":"With you now","progress_position":40,"state":400}]}]},{"vendor_packages":[{"fullfillment_type":2,"shipment_provider_id":null,"state":135,"tracking_code":null,"tracking_link":null,"vendor_order_line_items":[{"editable_size":false,"formatted_price":"Tk. 156","formatted_total_product_price":"Tk. 156","get_progress_state":{"code":"Waiting for Wholesaler confirmation","end_state_details":[{"changed_at":"Jul 27,2020","code":"Waiting for Wholesaler confirmation"}],"is_negative":false,"progress_position":20,"stages":["Placed","Processed","Dispatched","Delivered"]},"id":924436,"image_url":"https://shopimages.vstores.io/9246/1562226578785-black-small.jpg?1580073149","price":156,"product_id":6429,"product_name":"Rubber Print Cotton T-shirt - Black - The Rock - CHS","quantity":1,"sale_price":null,"seller_name":"Chorui Shop","size_str":"S","sku":"222885","slug":"rubber-print-cotton-t-shirt-black-the-rock-chs-shopup-e36b3d38","total_product_price":156}],"vendor_package_tracking_details":[{"formated_change_expected_at":"Aug 08,2020","formated_changed_at":null,"formatted_customer_visible_text":"With you now","progress_position":40,"state":400}]}]},{"vendor_packages":[{"fullfillment_type":2,"shipment_provider_id":null,"state":155,"tracking_code":null,"tracking_link":null,"vendor_order_line_items":[{"editable_size":false,"formatted_price":"Tk. 468","formatted_total_product_price":"Tk. 468","get_progress_state":{"code":"Cancelled","end_state_details":[{"changed_at":"Jul 27,2020","code":"Cancelled"}],"is_negative":true,"progress_position":10,"stages":["Placed","Processed","Dispatched","Delivered"]},"id":924437,"image_url":"https://shopimages.vstores.io/38854/1577790058950-hd-920-small.jpg?1580160194","price":468,"product_id":45883,"product_name":"MEN'S PREMIUM SWEAT SHIRT FULL SLEEVE - HD-920 - DVS","quantity":1,"sale_price":null,"seller_name":"DIVINE SOUL","size_str":"M","sku":"313509","slug":"men-s-premium-sweat-shirt-full-sleeve-hd-920-dvs-shopup-4a7c95b2","total_product_price":468}],"vendor_package_tracking_details":[{"formated_change_expected_at":"Aug 08,2020","formated_changed_at":null,"formatted_customer_visible_text":"With you now","progress_position":40,"state":400}]}]}]}
         */

        private CustomerOrderBean customer_order;

        public CustomerOrderBean getCustomer_order() {
            return customer_order;
        }

        public void setCustomer_order(CustomerOrderBean customer_order) {
            this.customer_order = customer_order;
        }

        public static class CustomerOrderBean {
            /**
             * add_bkash_available : false
             * adjustment_total : 120
             * auto_confirmation_available? : false
             * completed_at : 2020-07-27T00:21:36.000+06:00
             * editable_address : false
             * editable_payment_method : false
             * email : iamasthme@gmail.com
             * formatted_total : Tk. 4241
             * item_total : 4121
             * number : R9955424107
             * order_confirmation_text : {"alternative_otp_text":"Our Executive will contact you shortly to confirm your order","popup_text":" Alternatively you can give a missed call to 9243000043 to confirm the order"}
             * payment_method_id : 1
             * prepaid_pending_status : false
             * ship_address : {"address1":"Shopf Street","address2":"","address_type":"N/A","alternative_phone":"N/A","city":"Bagerhat Sadar, Bagerhat","company":null,"country":"India","firstname":"Naveen","landmark":"","lastname":" ","phone":8801877655690,"state":"Andhra Pradesh","user_address_id":9122855,"zipcode":"755"}
             * ship_address_id : 1432696
             * total : 4241
             * vendor_orders : [{"vendor_packages":[{"fullfillment_type":2,"shipment_provider_id":null,"state":135,"tracking_code":null,"tracking_link":null,"vendor_order_line_items":[{"editable_size":false,"formatted_price":"Tk. 399","formatted_total_product_price":"Tk. 399","get_progress_state":{"code":"Waiting for Wholesaler confirmation","end_state_details":[{"changed_at":"Jul 27,2020","code":"Waiting for Wholesaler confirmation"}],"is_negative":false,"progress_position":20,"stages":["Placed","Processed","Dispatched","Delivered"]},"id":924432,"image_url":"https://shopimages.vstores.io/15256/1569927970391-19-small.jpg?1580192775","price":399,"product_id":65251,"product_name":"Navy Blue Sleeve Casual Shirt for Men - UPF","quantity":1,"sale_price":null,"seller_name":"Update Fashion ","size_str":"L","sku":"264039","slug":"navy-blue-sleeve-casual-shirt-for-men-upf-shopup-6e663d38","total_product_price":399}],"vendor_package_tracking_details":[{"formated_change_expected_at":"Aug 08,2020","formated_changed_at":null,"formatted_customer_visible_text":"With you now","progress_position":40,"state":400}]}]},{"vendor_packages":[{"fullfillment_type":2,"shipment_provider_id":null,"state":135,"tracking_code":null,"tracking_link":null,"vendor_order_line_items":[{"editable_size":false,"formatted_price":"Tk. 733","formatted_total_product_price":"Tk. 733","get_progress_state":{"code":"Waiting for Wholesaler confirmation","end_state_details":[{"changed_at":"Jul 27,2020","code":"Waiting for Wholesaler confirmation"}],"is_negative":false,"progress_position":20,"stages":["Placed","Processed","Dispatched","Delivered"]},"id":924433,"image_url":"https://shopimages.vstores.io/41391/1575284915862-2-small.jpg?1580120187","price":733,"product_id":19314,"product_name":"Casual Check Shirt - 2 - Brown Check - ABL","quantity":1,"sale_price":null,"seller_name":"Aeroblue","size_str":"XL","sku":"295320","slug":"casual-check-shirt-2-brown-check-abl-shopup-cacaee26","total_product_price":733}],"vendor_package_tracking_details":[{"formated_change_expected_at":"Aug 08,2020","formated_changed_at":null,"formatted_customer_visible_text":"With you now","progress_position":40,"state":400}]}]},{"vendor_packages":[{"fullfillment_type":2,"shipment_provider_id":null,"state":135,"tracking_code":null,"tracking_link":null,"vendor_order_line_items":[{"editable_size":false,"formatted_price":"Tk. 466","formatted_total_product_price":"Tk. 466","get_progress_state":{"code":"Waiting for Wholesaler confirmation","end_state_details":[{"changed_at":"Jul 27,2020","code":"Waiting for Wholesaler confirmation"}],"is_negative":false,"progress_position":20,"stages":["Placed","Processed","Dispatched","Delivered"]},"id":924434,"image_url":"https://shopimages.vstores.io/49386/1570621593488-whatsappimage2019-10-06at4.25.12pm1-small.jpeg?1580195418","price":466,"product_id":68394,"product_name":"Trendy Casual Full Sleeve Cotton Shirt for Men- 0074- DKB","quantity":1,"sale_price":null,"seller_name":"Dokander Bari","size_str":"M","sku":"268260","slug":"trendy-casual-full-sleeve-cotton-shirt-for-men-0074-dkb-shopup-211bde5d","total_product_price":466}],"vendor_package_tracking_details":[{"formated_change_expected_at":"Aug 08,2020","formated_changed_at":null,"formatted_customer_visible_text":"With you now","progress_position":40,"state":400}]}]},{"vendor_packages":[{"fullfillment_type":2,"shipment_provider_id":null,"state":135,"tracking_code":null,"tracking_link":null,"vendor_order_line_items":[{"editable_size":false,"formatted_price":"Tk. 633","formatted_total_product_price":"Tk. 1899","get_progress_state":{"code":"Waiting for Wholesaler confirmation","end_state_details":[{"changed_at":"Jul 27,2020","code":"Waiting for Wholesaler confirmation"}],"is_negative":false,"progress_position":20,"stages":["Placed","Processed","Dispatched","Delivered"]},"id":924435,"image_url":"https://shopimages.vstores.io/11204/1563612152851-rbvawvwzq4gabhm-aankelrp-9i025-small.jpg?1580157539","price":633,"product_id":40211,"product_name":"A1/W8 Smart Watch - 001 - Multi Color - WLB","quantity":3,"sale_price":null,"seller_name":"Welcome BD","size_str":"option","sku":"227724","slug":"a1-w8-smart-watch-001-multi-color-wlb-shopup-84018328","total_product_price":1899}],"vendor_package_tracking_details":[{"formated_change_expected_at":"Aug 08,2020","formated_changed_at":null,"formatted_customer_visible_text":"With you now","progress_position":40,"state":400}]}]},{"vendor_packages":[{"fullfillment_type":2,"shipment_provider_id":null,"state":135,"tracking_code":null,"tracking_link":null,"vendor_order_line_items":[{"editable_size":false,"formatted_price":"Tk. 156","formatted_total_product_price":"Tk. 156","get_progress_state":{"code":"Waiting for Wholesaler confirmation","end_state_details":[{"changed_at":"Jul 27,2020","code":"Waiting for Wholesaler confirmation"}],"is_negative":false,"progress_position":20,"stages":["Placed","Processed","Dispatched","Delivered"]},"id":924436,"image_url":"https://shopimages.vstores.io/9246/1562226578785-black-small.jpg?1580073149","price":156,"product_id":6429,"product_name":"Rubber Print Cotton T-shirt - Black - The Rock - CHS","quantity":1,"sale_price":null,"seller_name":"Chorui Shop","size_str":"S","sku":"222885","slug":"rubber-print-cotton-t-shirt-black-the-rock-chs-shopup-e36b3d38","total_product_price":156}],"vendor_package_tracking_details":[{"formated_change_expected_at":"Aug 08,2020","formated_changed_at":null,"formatted_customer_visible_text":"With you now","progress_position":40,"state":400}]}]},{"vendor_packages":[{"fullfillment_type":2,"shipment_provider_id":null,"state":155,"tracking_code":null,"tracking_link":null,"vendor_order_line_items":[{"editable_size":false,"formatted_price":"Tk. 468","formatted_total_product_price":"Tk. 468","get_progress_state":{"code":"Cancelled","end_state_details":[{"changed_at":"Jul 27,2020","code":"Cancelled"}],"is_negative":true,"progress_position":10,"stages":["Placed","Processed","Dispatched","Delivered"]},"id":924437,"image_url":"https://shopimages.vstores.io/38854/1577790058950-hd-920-small.jpg?1580160194","price":468,"product_id":45883,"product_name":"MEN'S PREMIUM SWEAT SHIRT FULL SLEEVE - HD-920 - DVS","quantity":1,"sale_price":null,"seller_name":"DIVINE SOUL","size_str":"M","sku":"313509","slug":"men-s-premium-sweat-shirt-full-sleeve-hd-920-dvs-shopup-4a7c95b2","total_product_price":468}],"vendor_package_tracking_details":[{"formated_change_expected_at":"Aug 08,2020","formated_changed_at":null,"formatted_customer_visible_text":"With you now","progress_position":40,"state":400}]}]}]
             */

            private boolean add_bkash_available;
            private int adjustment_total;
            @SerializedName("auto_confirmation_available?")
            private boolean _$Auto_confirmation_available322; // FIXME check this code
            private String completed_at;
            private boolean editable_address;
            private boolean editable_payment_method;
            private String email;
            private String formatted_total;
            private int item_total;
            private String number;
            private OrderConfirmationTextBean order_confirmation_text;
            private int payment_method_id;
            private boolean prepaid_pending_status;
            private ShipAddressBean ship_address;
            private int ship_address_id;
            private int total;
            private List<VendorOrdersBean> vendor_orders;

            public boolean isAdd_bkash_available() {
                return add_bkash_available;
            }

            public void setAdd_bkash_available(boolean add_bkash_available) {
                this.add_bkash_available = add_bkash_available;
            }

            public int getAdjustment_total() {
                return adjustment_total;
            }

            public void setAdjustment_total(int adjustment_total) {
                this.adjustment_total = adjustment_total;
            }

            public boolean is_$Auto_confirmation_available322() {
                return _$Auto_confirmation_available322;
            }

            public void set_$Auto_confirmation_available322(boolean _$Auto_confirmation_available322) {
                this._$Auto_confirmation_available322 = _$Auto_confirmation_available322;
            }

            public String getCompleted_at() {
                return completed_at;
            }

            public void setCompleted_at(String completed_at) {
                this.completed_at = completed_at;
            }

            public boolean isEditable_address() {
                return editable_address;
            }

            public void setEditable_address(boolean editable_address) {
                this.editable_address = editable_address;
            }

            public boolean isEditable_payment_method() {
                return editable_payment_method;
            }

            public void setEditable_payment_method(boolean editable_payment_method) {
                this.editable_payment_method = editable_payment_method;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getFormatted_total() {
                return formatted_total;
            }

            public void setFormatted_total(String formatted_total) {
                this.formatted_total = formatted_total;
            }

            public int getItem_total() {
                return item_total;
            }

            public void setItem_total(int item_total) {
                this.item_total = item_total;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public OrderConfirmationTextBean getOrder_confirmation_text() {
                return order_confirmation_text;
            }

            public void setOrder_confirmation_text(OrderConfirmationTextBean order_confirmation_text) {
                this.order_confirmation_text = order_confirmation_text;
            }

            public int getPayment_method_id() {
                return payment_method_id;
            }

            public void setPayment_method_id(int payment_method_id) {
                this.payment_method_id = payment_method_id;
            }

            public boolean isPrepaid_pending_status() {
                return prepaid_pending_status;
            }

            public void setPrepaid_pending_status(boolean prepaid_pending_status) {
                this.prepaid_pending_status = prepaid_pending_status;
            }

            public ShipAddressBean getShip_address() {
                return ship_address;
            }

            public void setShip_address(ShipAddressBean ship_address) {
                this.ship_address = ship_address;
            }

            public int getShip_address_id() {
                return ship_address_id;
            }

            public void setShip_address_id(int ship_address_id) {
                this.ship_address_id = ship_address_id;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public List<VendorOrdersBean> getVendor_orders() {
                return vendor_orders;
            }

            public void setVendor_orders(List<VendorOrdersBean> vendor_orders) {
                this.vendor_orders = vendor_orders;
            }

            public static class OrderConfirmationTextBean {
                /**
                 * alternative_otp_text : Our Executive will contact you shortly to confirm your order
                 * popup_text :  Alternatively you can give a missed call to 9243000043 to confirm the order
                 */

                private String alternative_otp_text;
                private String popup_text;

                public String getAlternative_otp_text() {
                    return alternative_otp_text;
                }

                public void setAlternative_otp_text(String alternative_otp_text) {
                    this.alternative_otp_text = alternative_otp_text;
                }

                public String getPopup_text() {
                    return popup_text;
                }

                public void setPopup_text(String popup_text) {
                    this.popup_text = popup_text;
                }
            }

            public static class ShipAddressBean {
                /**
                 * address1 : Shopf Street
                 * address2 :
                 * address_type : N/A
                 * alternative_phone : N/A
                 * city : Bagerhat Sadar, Bagerhat
                 * company : null
                 * country : India
                 * firstname : Naveen
                 * landmark :
                 * lastname :
                 * phone : 8801877655690
                 * state : Andhra Pradesh
                 * user_address_id : 9122855
                 * zipcode : 755
                 */

                private String address1;
                private String address2;
                private String address_type;
                private String alternative_phone;
                private String city;
                private Object company;
                private String country;
                private String firstname;
                private String landmark;
                private String lastname;
                private long phone;
                private String state;
                private int user_address_id;
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

                public String getAddress_type() {
                    return address_type;
                }

                public void setAddress_type(String address_type) {
                    this.address_type = address_type;
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

                public Object getCompany() {
                    return company;
                }

                public void setCompany(Object company) {
                    this.company = company;
                }

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

                public long getPhone() {
                    return phone;
                }

                public void setPhone(long phone) {
                    this.phone = phone;
                }

                public String getState() {
                    return state;
                }

                public void setState(String state) {
                    this.state = state;
                }

                public int getUser_address_id() {
                    return user_address_id;
                }

                public void setUser_address_id(int user_address_id) {
                    this.user_address_id = user_address_id;
                }

                public String getZipcode() {
                    return zipcode;
                }

                public void setZipcode(String zipcode) {
                    this.zipcode = zipcode;
                }
            }

            public static class VendorOrdersBean {
                private List<VendorPackagesBean> vendor_packages;

                public List<VendorPackagesBean> getVendor_packages() {
                    return vendor_packages;
                }

                public void setVendor_packages(List<VendorPackagesBean> vendor_packages) {
                    this.vendor_packages = vendor_packages;
                }

                public static class VendorPackagesBean {
                    /**
                     * fullfillment_type : 2
                     * shipment_provider_id : null
                     * state : 135
                     * tracking_code : null
                     * tracking_link : null
                     * vendor_order_line_items : [{"editable_size":false,"formatted_price":"Tk. 399","formatted_total_product_price":"Tk. 399","get_progress_state":{"code":"Waiting for Wholesaler confirmation","end_state_details":[{"changed_at":"Jul 27,2020","code":"Waiting for Wholesaler confirmation"}],"is_negative":false,"progress_position":20,"stages":["Placed","Processed","Dispatched","Delivered"]},"id":924432,"image_url":"https://shopimages.vstores.io/15256/1569927970391-19-small.jpg?1580192775","price":399,"product_id":65251,"product_name":"Navy Blue Sleeve Casual Shirt for Men - UPF","quantity":1,"sale_price":null,"seller_name":"Update Fashion ","size_str":"L","sku":"264039","slug":"navy-blue-sleeve-casual-shirt-for-men-upf-shopup-6e663d38","total_product_price":399}]
                     * vendor_package_tracking_details : [{"formated_change_expected_at":"Aug 08,2020","formated_changed_at":null,"formatted_customer_visible_text":"With you now","progress_position":40,"state":400}]
                     */

                    private int fullfillment_type;
                    private Object shipment_provider_id;
                    private int state;
                    private Object tracking_code;
                    private Object tracking_link;
                    private List<VendorOrderLineItemsBean> vendor_order_line_items;
                    private List<VendorPackageTrackingDetailsBean> vendor_package_tracking_details;

                    public int getFullfillment_type() {
                        return fullfillment_type;
                    }

                    public void setFullfillment_type(int fullfillment_type) {
                        this.fullfillment_type = fullfillment_type;
                    }

                    public Object getShipment_provider_id() {
                        return shipment_provider_id;
                    }

                    public void setShipment_provider_id(Object shipment_provider_id) {
                        this.shipment_provider_id = shipment_provider_id;
                    }

                    public int getState() {
                        return state;
                    }

                    public void setState(int state) {
                        this.state = state;
                    }

                    public Object getTracking_code() {
                        return tracking_code;
                    }

                    public void setTracking_code(Object tracking_code) {
                        this.tracking_code = tracking_code;
                    }

                    public Object getTracking_link() {
                        return tracking_link;
                    }

                    public void setTracking_link(Object tracking_link) {
                        this.tracking_link = tracking_link;
                    }

                    public List<VendorOrderLineItemsBean> getVendor_order_line_items() {
                        return vendor_order_line_items;
                    }

                    public void setVendor_order_line_items(List<VendorOrderLineItemsBean> vendor_order_line_items) {
                        this.vendor_order_line_items = vendor_order_line_items;
                    }

                    public List<VendorPackageTrackingDetailsBean> getVendor_package_tracking_details() {
                        return vendor_package_tracking_details;
                    }

                    public void setVendor_package_tracking_details(List<VendorPackageTrackingDetailsBean> vendor_package_tracking_details) {
                        this.vendor_package_tracking_details = vendor_package_tracking_details;
                    }

                    public static class VendorOrderLineItemsBean {
                        /**
                         * editable_size : false
                         * formatted_price : Tk. 399
                         * formatted_total_product_price : Tk. 399
                         * get_progress_state : {"code":"Waiting for Wholesaler confirmation","end_state_details":[{"changed_at":"Jul 27,2020","code":"Waiting for Wholesaler confirmation"}],"is_negative":false,"progress_position":20,"stages":["Placed","Processed","Dispatched","Delivered"]}
                         * id : 924432
                         * image_url : https://shopimages.vstores.io/15256/1569927970391-19-small.jpg?1580192775
                         * price : 399
                         * product_id : 65251
                         * product_name : Navy Blue Sleeve Casual Shirt for Men - UPF
                         * quantity : 1
                         * sale_price : null
                         * seller_name : Update Fashion
                         * size_str : L
                         * sku : 264039
                         * slug : navy-blue-sleeve-casual-shirt-for-men-upf-shopup-6e663d38
                         * total_product_price : 399
                         */

                        private boolean editable_size;
                        private String formatted_price;
                        private String formatted_total_product_price;
                        private GetProgressStateBean get_progress_state;
                        private int id;
                        private String image_url;
                        private int price;
                        private int product_id;
                        private String product_name;
                        private int quantity;
                        private Object sale_price;
                        private String seller_name;
                        private String size_str;
                        private String sku;
                        private String slug;
                        private int total_product_price;

                        public boolean isEditable_size() {
                            return editable_size;
                        }

                        public void setEditable_size(boolean editable_size) {
                            this.editable_size = editable_size;
                        }

                        public String getFormatted_price() {
                            return formatted_price;
                        }

                        public void setFormatted_price(String formatted_price) {
                            this.formatted_price = formatted_price;
                        }

                        public String getFormatted_total_product_price() {
                            return formatted_total_product_price;
                        }

                        public void setFormatted_total_product_price(String formatted_total_product_price) {
                            this.formatted_total_product_price = formatted_total_product_price;
                        }

                        public GetProgressStateBean getGet_progress_state() {
                            return get_progress_state;
                        }

                        public void setGet_progress_state(GetProgressStateBean get_progress_state) {
                            this.get_progress_state = get_progress_state;
                        }

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public String getImage_url() {
                            return image_url;
                        }

                        public void setImage_url(String image_url) {
                            this.image_url = image_url;
                        }

                        public int getPrice() {
                            return price;
                        }

                        public void setPrice(int price) {
                            this.price = price;
                        }

                        public int getProduct_id() {
                            return product_id;
                        }

                        public void setProduct_id(int product_id) {
                            this.product_id = product_id;
                        }

                        public String getProduct_name() {
                            return product_name;
                        }

                        public void setProduct_name(String product_name) {
                            this.product_name = product_name;
                        }

                        public int getQuantity() {
                            return quantity;
                        }

                        public void setQuantity(int quantity) {
                            this.quantity = quantity;
                        }

                        public Object getSale_price() {
                            return sale_price;
                        }

                        public void setSale_price(Object sale_price) {
                            this.sale_price = sale_price;
                        }

                        public String getSeller_name() {
                            return seller_name;
                        }

                        public void setSeller_name(String seller_name) {
                            this.seller_name = seller_name;
                        }

                        public String getSize_str() {
                            return size_str;
                        }

                        public void setSize_str(String size_str) {
                            this.size_str = size_str;
                        }

                        public String getSku() {
                            return sku;
                        }

                        public void setSku(String sku) {
                            this.sku = sku;
                        }

                        public String getSlug() {
                            return slug;
                        }

                        public void setSlug(String slug) {
                            this.slug = slug;
                        }

                        public int getTotal_product_price() {
                            return total_product_price;
                        }

                        public void setTotal_product_price(int total_product_price) {
                            this.total_product_price = total_product_price;
                        }

                        public static class GetProgressStateBean {
                            /**
                             * code : Waiting for Wholesaler confirmation
                             * end_state_details : [{"changed_at":"Jul 27,2020","code":"Waiting for Wholesaler confirmation"}]
                             * is_negative : false
                             * progress_position : 20
                             * stages : ["Placed","Processed","Dispatched","Delivered"]
                             */

                            private String code;
                            private boolean is_negative;
                            private int progress_position;
                            private List<EndStateDetailsBean> end_state_details;
                            private List<String> stages;

                            public String getCode() {
                                return code;
                            }

                            public void setCode(String code) {
                                this.code = code;
                            }

                            public boolean isIs_negative() {
                                return is_negative;
                            }

                            public void setIs_negative(boolean is_negative) {
                                this.is_negative = is_negative;
                            }

                            public int getProgress_position() {
                                return progress_position;
                            }

                            public void setProgress_position(int progress_position) {
                                this.progress_position = progress_position;
                            }

                            public List<EndStateDetailsBean> getEnd_state_details() {
                                return end_state_details;
                            }

                            public void setEnd_state_details(List<EndStateDetailsBean> end_state_details) {
                                this.end_state_details = end_state_details;
                            }

                            public List<String> getStages() {
                                return stages;
                            }

                            public void setStages(List<String> stages) {
                                this.stages = stages;
                            }

                            public static class EndStateDetailsBean {
                                /**
                                 * changed_at : Jul 27,2020
                                 * code : Waiting for Wholesaler confirmation
                                 */

                                private String changed_at;
                                private String code;

                                public String getChanged_at() {
                                    return changed_at;
                                }

                                public void setChanged_at(String changed_at) {
                                    this.changed_at = changed_at;
                                }

                                public String getCode() {
                                    return code;
                                }

                                public void setCode(String code) {
                                    this.code = code;
                                }
                            }
                        }
                    }

                    public static class VendorPackageTrackingDetailsBean {
                        /**
                         * formated_change_expected_at : Aug 08,2020
                         * formated_changed_at : null
                         * formatted_customer_visible_text : With you now
                         * progress_position : 40
                         * state : 400
                         */

                        private String formated_change_expected_at;
                        private Object formated_changed_at;
                        private String formatted_customer_visible_text;
                        private int progress_position;
                        private int state;

                        public String getFormated_change_expected_at() {
                            return formated_change_expected_at;
                        }

                        public void setFormated_change_expected_at(String formated_change_expected_at) {
                            this.formated_change_expected_at = formated_change_expected_at;
                        }

                        public Object getFormated_changed_at() {
                            return formated_changed_at;
                        }

                        public void setFormated_changed_at(Object formated_changed_at) {
                            this.formated_changed_at = formated_changed_at;
                        }

                        public String getFormatted_customer_visible_text() {
                            return formatted_customer_visible_text;
                        }

                        public void setFormatted_customer_visible_text(String formatted_customer_visible_text) {
                            this.formatted_customer_visible_text = formatted_customer_visible_text;
                        }

                        public int getProgress_position() {
                            return progress_position;
                        }

                        public void setProgress_position(int progress_position) {
                            this.progress_position = progress_position;
                        }

                        public int getState() {
                            return state;
                        }

                        public void setState(int state) {
                            this.state = state;
                        }
                    }
                }
            }
        }
    }

    public static class CancelReasonsBean {
        /**
         * code : Want to add another product to the order
         * id : 263
         */

        private String code;
        private int id;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class ExchangeReasonsBean {
        /**
         * code : SIZE_AND_FITTING_ISSUE
         * id : 125
         */

        private String code;
        private int id;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class ReturnReasonsBean {
        /**
         * code : DAMAGED_PRODUCT
         * id : 23
         */

        private String code;
        private int id;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
