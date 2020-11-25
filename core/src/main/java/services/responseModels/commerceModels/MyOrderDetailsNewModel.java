package services.responseModels.commerceModels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyOrderDetailsNewModel {

    /**
     * customer_order : {"add_bkash_available":false,"advance_amount_paid":0,"completed_at":"2020-11-25T06:39:59.000+06:00","editable_address":true,"formatted_total":"Tk. 169.0","item_total":68.46,"loan_credit":0,"number":"M0481177236","order_combos":{},"payment_method_id":1,"ship_address":{"address1":"7,West Cross Street","address2":"","address_type":"N/A","alternative_phone":"N/A","city":"Ramu, Cox's Bazar","company":null,"country":"India","created_at":"2020-11-25T06:40:04.000+06:00","firstname":"Smoke Flow shop chittagong","id":1441396,"landmark":"","lastname":" ","phone":8801877755590,"state":"Andhra Pradesh","updated_at":"2020-11-25T06:40:04.000+06:00","user_address_id":9124372,"zipcode":"1021","zone":null},"special_instructions":{"delivery_instructions":"","parcel_weight":null,"preferred_days":"","preferred_slots":"","text":""},"total":169,"total_shipping":100,"vendor_orders":[{"created_at":"2020-11-25T06:39:59.000+06:00","current_processed_voonik_order_number":"M0481177236-1","get_refund_data":{"cancel_refund_options":null,"default_refund_option":2,"return_refund_options":{"Bank Transfer":2,"Voonik Credit":1}},"get_return_reasons":[],"id":810846,"payment_method_id":1,"raw_vendor_order_number":null,"refund_through":null,"seller_id":287000412,"total":168,"vendor_address_id":null,"vendor_adjustments":[{"adjustment_type":1,"amount":100,"formatted_amount":"Tk. 100.0","label":"Shipping Charges"}],"vendor_packages":[{"customer_tracking_details":[{"changed_at":"2020-11-25T06:40:04.000+06:00","formated_changed_at":"Nov 25,2020","formatted_customer_visible_bangla_text":"অর্ডার প্লেস হয়েছে।","formatted_customer_visible_text":"Order Confirmed"}],"fullfillment_type":2,"state":100,"tracking_code":null,"tracking_link":null,"vendor_order_line_items":[{"combo_items":[],"current_processed_line_item_id":930984,"editable_size":false,"formatted_price":"Tk. 34.23","formatted_total_product_price":"Tk. 68.46","get_progress_state":{"available_variants":[],"cancellation_availability":true,"code":"Order Confirmed","end_state_details":[{"changed_at":"Nov 25,2020","code":"Order Confirmed"}],"error":"","exchange_availability":false,"is_negative":false,"progress_position":10,"reconfirm_return_availability":false,"return_availability":false,"stages":["Placed","Processed","Dispatched","Delivered"],"verify_return_availability":false},"id":930984,"image_url":"https://shopimages.vstores.io/uc/550564/dettol_soap02-small.jpg?1591893676","other_variant_sizes":[],"price":34.23,"product_id":414713,"product_name":"Dettol Soap Cool 75G -Old Rate","quantity":2,"sale_price":null,"seller_name":"Unicorn","size_str":"75gm","sku":"Dettol-Soap-Cool-75G--Old-Rate---efa825b5","slug":"dettol-soap-cool-75g-old-rate-shopup-51be5206","total_product_price":68.46}],"vendor_package_tracking_details":[]}],"voonik_order_number":"M0481177236-1"}]}
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
         * advance_amount_paid : 0
         * completed_at : 2020-11-25T06:39:59.000+06:00
         * editable_address : true
         * formatted_total : Tk. 169.0
         * item_total : 68.46
         * loan_credit : 0
         * number : M0481177236
         * order_combos : {}
         * payment_method_id : 1
         * ship_address : {"address1":"7,West Cross Street","address2":"","address_type":"N/A","alternative_phone":"N/A","city":"Ramu, Cox's Bazar","company":null,"country":"India","created_at":"2020-11-25T06:40:04.000+06:00","firstname":"Smoke Flow shop chittagong","id":1441396,"landmark":"","lastname":" ","phone":8801877755590,"state":"Andhra Pradesh","updated_at":"2020-11-25T06:40:04.000+06:00","user_address_id":9124372,"zipcode":"1021","zone":null}
         * special_instructions : {"delivery_instructions":"","parcel_weight":null,"preferred_days":"","preferred_slots":"","text":""}
         * total : 169
         * total_shipping : 100
         * vendor_orders : [{"created_at":"2020-11-25T06:39:59.000+06:00","current_processed_voonik_order_number":"M0481177236-1","get_refund_data":{"cancel_refund_options":null,"default_refund_option":2,"return_refund_options":{"Bank Transfer":2,"Voonik Credit":1}},"get_return_reasons":[],"id":810846,"payment_method_id":1,"raw_vendor_order_number":null,"refund_through":null,"seller_id":287000412,"total":168,"vendor_address_id":null,"vendor_adjustments":[{"adjustment_type":1,"amount":100,"formatted_amount":"Tk. 100.0","label":"Shipping Charges"}],"vendor_packages":[{"customer_tracking_details":[{"changed_at":"2020-11-25T06:40:04.000+06:00","formated_changed_at":"Nov 25,2020","formatted_customer_visible_bangla_text":"অর্ডার প্লেস হয়েছে।","formatted_customer_visible_text":"Order Confirmed"}],"fullfillment_type":2,"state":100,"tracking_code":null,"tracking_link":null,"vendor_order_line_items":[{"combo_items":[],"current_processed_line_item_id":930984,"editable_size":false,"formatted_price":"Tk. 34.23","formatted_total_product_price":"Tk. 68.46","get_progress_state":{"available_variants":[],"cancellation_availability":true,"code":"Order Confirmed","end_state_details":[{"changed_at":"Nov 25,2020","code":"Order Confirmed"}],"error":"","exchange_availability":false,"is_negative":false,"progress_position":10,"reconfirm_return_availability":false,"return_availability":false,"stages":["Placed","Processed","Dispatched","Delivered"],"verify_return_availability":false},"id":930984,"image_url":"https://shopimages.vstores.io/uc/550564/dettol_soap02-small.jpg?1591893676","other_variant_sizes":[],"price":34.23,"product_id":414713,"product_name":"Dettol Soap Cool 75G -Old Rate","quantity":2,"sale_price":null,"seller_name":"Unicorn","size_str":"75gm","sku":"Dettol-Soap-Cool-75G--Old-Rate---efa825b5","slug":"dettol-soap-cool-75g-old-rate-shopup-51be5206","total_product_price":68.46}],"vendor_package_tracking_details":[]}],"voonik_order_number":"M0481177236-1"}]
         */

        private boolean add_bkash_available;
        private int advance_amount_paid;
        private String completed_at;
        private boolean editable_address;
        private String formatted_total;
        private double item_total;
        private double loan_credit;
        private String number;
        private OrderCombosBean order_combos;
        private int payment_method_id;
        private ShipAddressBean ship_address;
        private SpecialInstructionsBean special_instructions;
        private int total;
        private int total_shipping;
        private List<VendorOrdersBean> vendor_orders;

        public boolean isAdd_bkash_available() {
            return add_bkash_available;
        }

        public void setAdd_bkash_available(boolean add_bkash_available) {
            this.add_bkash_available = add_bkash_available;
        }

        public int getAdvance_amount_paid() {
            return advance_amount_paid;
        }

        public void setAdvance_amount_paid(int advance_amount_paid) {
            this.advance_amount_paid = advance_amount_paid;
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

        public String getFormatted_total() {
            return formatted_total;
        }

        public void setFormatted_total(String formatted_total) {
            this.formatted_total = formatted_total;
        }

        public double getItem_total() {
            return item_total;
        }

        public void setItem_total(double item_total) {
            this.item_total = item_total;
        }

        public double getLoan_credit() {
            return loan_credit;
        }

        public void setLoan_credit(double loan_credit) {
            this.loan_credit = loan_credit;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public OrderCombosBean getOrder_combos() {
            return order_combos;
        }

        public void setOrder_combos(OrderCombosBean order_combos) {
            this.order_combos = order_combos;
        }

        public int getPayment_method_id() {
            return payment_method_id;
        }

        public void setPayment_method_id(int payment_method_id) {
            this.payment_method_id = payment_method_id;
        }

        public ShipAddressBean getShip_address() {
            return ship_address;
        }

        public void setShip_address(ShipAddressBean ship_address) {
            this.ship_address = ship_address;
        }

        public SpecialInstructionsBean getSpecial_instructions() {
            return special_instructions;
        }

        public void setSpecial_instructions(SpecialInstructionsBean special_instructions) {
            this.special_instructions = special_instructions;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getTotal_shipping() {
            return total_shipping;
        }

        public void setTotal_shipping(int total_shipping) {
            this.total_shipping = total_shipping;
        }

        public List<VendorOrdersBean> getVendor_orders() {
            return vendor_orders;
        }

        public void setVendor_orders(List<VendorOrdersBean> vendor_orders) {
            this.vendor_orders = vendor_orders;
        }

        public static class OrderCombosBean {
        }

        public static class ShipAddressBean {
            /**
             * address1 : 7,West Cross Street
             * address2 :
             * address_type : N/A
             * alternative_phone : N/A
             * city : Ramu, Cox's Bazar
             * company : null
             * country : India
             * created_at : 2020-11-25T06:40:04.000+06:00
             * firstname : Smoke Flow shop chittagong
             * id : 1441396
             * landmark :
             * lastname :
             * phone : 8801877755590
             * state : Andhra Pradesh
             * updated_at : 2020-11-25T06:40:04.000+06:00
             * user_address_id : 9124372
             * zipcode : 1021
             * zone : null
             */

            private String address1;
            private String address2;
            private String address_type;
            private String alternative_phone;
            private String city;
            private Object company;
            private String country;
            private String created_at;
            private String firstname;
            private int id;
            private String landmark;
            private String lastname;
            private long phone;
            private String state;
            private String updated_at;
            private int user_address_id;
            private String zipcode;
            private Object zone;

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

            public String getZipcode() {
                return zipcode;
            }

            public void setZipcode(String zipcode) {
                this.zipcode = zipcode;
            }

            public Object getZone() {
                return zone;
            }

            public void setZone(Object zone) {
                this.zone = zone;
            }
        }

        public static class SpecialInstructionsBean {
            /**
             * delivery_instructions :
             * parcel_weight : null
             * preferred_days :
             * preferred_slots :
             * text :
             */

            private String delivery_instructions;
            private Object parcel_weight;
            private String preferred_days;
            private String preferred_slots;
            private String text;

            public String getDelivery_instructions() {
                return delivery_instructions;
            }

            public void setDelivery_instructions(String delivery_instructions) {
                this.delivery_instructions = delivery_instructions;
            }

            public Object getParcel_weight() {
                return parcel_weight;
            }

            public void setParcel_weight(Object parcel_weight) {
                this.parcel_weight = parcel_weight;
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

        public static class VendorOrdersBean {
            /**
             * created_at : 2020-11-25T06:39:59.000+06:00
             * current_processed_voonik_order_number : M0481177236-1
             * get_refund_data : {"cancel_refund_options":null,"default_refund_option":2,"return_refund_options":{"Bank Transfer":2,"Voonik Credit":1}}
             * get_return_reasons : []
             * id : 810846
             * payment_method_id : 1
             * raw_vendor_order_number : null
             * refund_through : null
             * seller_id : 287000412
             * total : 168
             * vendor_address_id : null
             * vendor_adjustments : [{"adjustment_type":1,"amount":100,"formatted_amount":"Tk. 100.0","label":"Shipping Charges"}]
             * vendor_packages : [{"customer_tracking_details":[{"changed_at":"2020-11-25T06:40:04.000+06:00","formated_changed_at":"Nov 25,2020","formatted_customer_visible_bangla_text":"অর্ডার প্লেস হয়েছে।","formatted_customer_visible_text":"Order Confirmed"}],"fullfillment_type":2,"state":100,"tracking_code":null,"tracking_link":null,"vendor_order_line_items":[{"combo_items":[],"current_processed_line_item_id":930984,"editable_size":false,"formatted_price":"Tk. 34.23","formatted_total_product_price":"Tk. 68.46","get_progress_state":{"available_variants":[],"cancellation_availability":true,"code":"Order Confirmed","end_state_details":[{"changed_at":"Nov 25,2020","code":"Order Confirmed"}],"error":"","exchange_availability":false,"is_negative":false,"progress_position":10,"reconfirm_return_availability":false,"return_availability":false,"stages":["Placed","Processed","Dispatched","Delivered"],"verify_return_availability":false},"id":930984,"image_url":"https://shopimages.vstores.io/uc/550564/dettol_soap02-small.jpg?1591893676","other_variant_sizes":[],"price":34.23,"product_id":414713,"product_name":"Dettol Soap Cool 75G -Old Rate","quantity":2,"sale_price":null,"seller_name":"Unicorn","size_str":"75gm","sku":"Dettol-Soap-Cool-75G--Old-Rate---efa825b5","slug":"dettol-soap-cool-75g-old-rate-shopup-51be5206","total_product_price":68.46}],"vendor_package_tracking_details":[]}]
             * voonik_order_number : M0481177236-1
             */

            private String created_at;
            private String current_processed_voonik_order_number;
            private GetRefundDataBean get_refund_data;
            private int id;
            private int payment_method_id;
            private Object raw_vendor_order_number;
            private Object refund_through;
            private int seller_id;
            private int total;
            private Object vendor_address_id;
            private String voonik_order_number;
            private List<?> get_return_reasons;
            private List<VendorAdjustmentsBean> vendor_adjustments;
            private List<VendorPackagesBean> vendor_packages;

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getCurrent_processed_voonik_order_number() {
                return current_processed_voonik_order_number;
            }

            public void setCurrent_processed_voonik_order_number(String current_processed_voonik_order_number) {
                this.current_processed_voonik_order_number = current_processed_voonik_order_number;
            }

            public GetRefundDataBean getGet_refund_data() {
                return get_refund_data;
            }

            public void setGet_refund_data(GetRefundDataBean get_refund_data) {
                this.get_refund_data = get_refund_data;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getPayment_method_id() {
                return payment_method_id;
            }

            public void setPayment_method_id(int payment_method_id) {
                this.payment_method_id = payment_method_id;
            }

            public Object getRaw_vendor_order_number() {
                return raw_vendor_order_number;
            }

            public void setRaw_vendor_order_number(Object raw_vendor_order_number) {
                this.raw_vendor_order_number = raw_vendor_order_number;
            }

            public Object getRefund_through() {
                return refund_through;
            }

            public void setRefund_through(Object refund_through) {
                this.refund_through = refund_through;
            }

            public int getSeller_id() {
                return seller_id;
            }

            public void setSeller_id(int seller_id) {
                this.seller_id = seller_id;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public Object getVendor_address_id() {
                return vendor_address_id;
            }

            public void setVendor_address_id(Object vendor_address_id) {
                this.vendor_address_id = vendor_address_id;
            }

            public String getVoonik_order_number() {
                return voonik_order_number;
            }

            public void setVoonik_order_number(String voonik_order_number) {
                this.voonik_order_number = voonik_order_number;
            }

            public List<?> getGet_return_reasons() {
                return get_return_reasons;
            }

            public void setGet_return_reasons(List<?> get_return_reasons) {
                this.get_return_reasons = get_return_reasons;
            }

            public List<VendorAdjustmentsBean> getVendor_adjustments() {
                return vendor_adjustments;
            }

            public void setVendor_adjustments(List<VendorAdjustmentsBean> vendor_adjustments) {
                this.vendor_adjustments = vendor_adjustments;
            }

            public List<VendorPackagesBean> getVendor_packages() {
                return vendor_packages;
            }

            public void setVendor_packages(List<VendorPackagesBean> vendor_packages) {
                this.vendor_packages = vendor_packages;
            }

            public static class GetRefundDataBean {
                /**
                 * cancel_refund_options : null
                 * default_refund_option : 2
                 * return_refund_options : {"Bank Transfer":2,"Voonik Credit":1}
                 */

                private Object cancel_refund_options;
                private int default_refund_option;
                private ReturnRefundOptionsBean return_refund_options;

                public Object getCancel_refund_options() {
                    return cancel_refund_options;
                }

                public void setCancel_refund_options(Object cancel_refund_options) {
                    this.cancel_refund_options = cancel_refund_options;
                }

                public int getDefault_refund_option() {
                    return default_refund_option;
                }

                public void setDefault_refund_option(int default_refund_option) {
                    this.default_refund_option = default_refund_option;
                }

                public ReturnRefundOptionsBean getReturn_refund_options() {
                    return return_refund_options;
                }

                public void setReturn_refund_options(ReturnRefundOptionsBean return_refund_options) {
                    this.return_refund_options = return_refund_options;
                }

                public static class ReturnRefundOptionsBean {
                    @SerializedName("Bank Transfer")
                    private int _$BankTransfer164; // FIXME check this code
                    @SerializedName("Voonik Credit")
                    private int _$VoonikCredit302; // FIXME check this code

                    public int get_$BankTransfer164() {
                        return _$BankTransfer164;
                    }

                    public void set_$BankTransfer164(int _$BankTransfer164) {
                        this._$BankTransfer164 = _$BankTransfer164;
                    }

                    public int get_$VoonikCredit302() {
                        return _$VoonikCredit302;
                    }

                    public void set_$VoonikCredit302(int _$VoonikCredit302) {
                        this._$VoonikCredit302 = _$VoonikCredit302;
                    }
                }
            }

            public static class VendorAdjustmentsBean {
                /**
                 * adjustment_type : 1
                 * amount : 100
                 * formatted_amount : Tk. 100.0
                 * label : Shipping Charges
                 */

                private int adjustment_type;
                private double amount;
                private String formatted_amount;
                private String label;

                public int getAdjustment_type() {
                    return adjustment_type;
                }

                public void setAdjustment_type(int adjustment_type) {
                    this.adjustment_type = adjustment_type;
                }

                public double getAmount() {
                    return amount;
                }

                public void setAmount(double amount) {
                    this.amount = amount;
                }

                public String getFormatted_amount() {
                    return formatted_amount;
                }

                public void setFormatted_amount(String formatted_amount) {
                    this.formatted_amount = formatted_amount;
                }

                public String getLabel() {
                    return label;
                }

                public void setLabel(String label) {
                    this.label = label;
                }
            }

            public static class VendorPackagesBean {
                /**
                 * customer_tracking_details : [{"changed_at":"2020-11-25T06:40:04.000+06:00","formated_changed_at":"Nov 25,2020","formatted_customer_visible_bangla_text":"অর্ডার প্লেস হয়েছে।","formatted_customer_visible_text":"Order Confirmed"}]
                 * fullfillment_type : 2
                 * state : 100
                 * tracking_code : null
                 * tracking_link : null
                 * vendor_order_line_items : [{"combo_items":[],"current_processed_line_item_id":930984,"editable_size":false,"formatted_price":"Tk. 34.23","formatted_total_product_price":"Tk. 68.46","get_progress_state":{"available_variants":[],"cancellation_availability":true,"code":"Order Confirmed","end_state_details":[{"changed_at":"Nov 25,2020","code":"Order Confirmed"}],"error":"","exchange_availability":false,"is_negative":false,"progress_position":10,"reconfirm_return_availability":false,"return_availability":false,"stages":["Placed","Processed","Dispatched","Delivered"],"verify_return_availability":false},"id":930984,"image_url":"https://shopimages.vstores.io/uc/550564/dettol_soap02-small.jpg?1591893676","other_variant_sizes":[],"price":34.23,"product_id":414713,"product_name":"Dettol Soap Cool 75G -Old Rate","quantity":2,"sale_price":null,"seller_name":"Unicorn","size_str":"75gm","sku":"Dettol-Soap-Cool-75G--Old-Rate---efa825b5","slug":"dettol-soap-cool-75g-old-rate-shopup-51be5206","total_product_price":68.46}]
                 * vendor_package_tracking_details : []
                 */

                private int fullfillment_type;
                private int state;
                private Object tracking_code;
                private Object tracking_link;
                private List<CustomerTrackingDetailsBean> customer_tracking_details;
                private List<VendorOrderLineItemsBean> vendor_order_line_items;
                private List<?> vendor_package_tracking_details;

                public int getFullfillment_type() {
                    return fullfillment_type;
                }

                public void setFullfillment_type(int fullfillment_type) {
                    this.fullfillment_type = fullfillment_type;
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

                public List<CustomerTrackingDetailsBean> getCustomer_tracking_details() {
                    return customer_tracking_details;
                }

                public void setCustomer_tracking_details(List<CustomerTrackingDetailsBean> customer_tracking_details) {
                    this.customer_tracking_details = customer_tracking_details;
                }

                public List<VendorOrderLineItemsBean> getVendor_order_line_items() {
                    return vendor_order_line_items;
                }

                public void setVendor_order_line_items(List<VendorOrderLineItemsBean> vendor_order_line_items) {
                    this.vendor_order_line_items = vendor_order_line_items;
                }

                public List<?> getVendor_package_tracking_details() {
                    return vendor_package_tracking_details;
                }

                public void setVendor_package_tracking_details(List<?> vendor_package_tracking_details) {
                    this.vendor_package_tracking_details = vendor_package_tracking_details;
                }

                public static class CustomerTrackingDetailsBean {
                    /**
                     * changed_at : 2020-11-25T06:40:04.000+06:00
                     * formated_changed_at : Nov 25,2020
                     * formatted_customer_visible_bangla_text : অর্ডার প্লেস হয়েছে।
                     * formatted_customer_visible_text : Order Confirmed
                     */

                    private String changed_at;
                    private String formated_changed_at;
                    private String formatted_customer_visible_bangla_text;
                    private String formatted_customer_visible_text;

                    public String getChanged_at() {
                        return changed_at;
                    }

                    public void setChanged_at(String changed_at) {
                        this.changed_at = changed_at;
                    }

                    public String getFormated_changed_at() {
                        return formated_changed_at;
                    }

                    public void setFormated_changed_at(String formated_changed_at) {
                        this.formated_changed_at = formated_changed_at;
                    }

                    public String getFormatted_customer_visible_bangla_text() {
                        return formatted_customer_visible_bangla_text;
                    }

                    public void setFormatted_customer_visible_bangla_text(String formatted_customer_visible_bangla_text) {
                        this.formatted_customer_visible_bangla_text = formatted_customer_visible_bangla_text;
                    }

                    public String getFormatted_customer_visible_text() {
                        return formatted_customer_visible_text;
                    }

                    public void setFormatted_customer_visible_text(String formatted_customer_visible_text) {
                        this.formatted_customer_visible_text = formatted_customer_visible_text;
                    }
                }

                public static class VendorOrderLineItemsBean {
                    /**
                     * combo_items : []
                     * current_processed_line_item_id : 930984
                     * editable_size : false
                     * formatted_price : Tk. 34.23
                     * formatted_total_product_price : Tk. 68.46
                     * get_progress_state : {"available_variants":[],"cancellation_availability":true,"code":"Order Confirmed","end_state_details":[{"changed_at":"Nov 25,2020","code":"Order Confirmed"}],"error":"","exchange_availability":false,"is_negative":false,"progress_position":10,"reconfirm_return_availability":false,"return_availability":false,"stages":["Placed","Processed","Dispatched","Delivered"],"verify_return_availability":false}
                     * id : 930984
                     * image_url : https://shopimages.vstores.io/uc/550564/dettol_soap02-small.jpg?1591893676
                     * other_variant_sizes : []
                     * price : 34.23
                     * product_id : 414713
                     * product_name : Dettol Soap Cool 75G -Old Rate
                     * quantity : 2
                     * sale_price : null
                     * seller_name : Unicorn
                     * size_str : 75gm
                     * sku : Dettol-Soap-Cool-75G--Old-Rate---efa825b5
                     * slug : dettol-soap-cool-75g-old-rate-shopup-51be5206
                     * total_product_price : 68.46
                     */

                    private int current_processed_line_item_id;
                    private boolean editable_size;
                    private String formatted_price;
                    private String formatted_total_product_price;
                    private GetProgressStateBean get_progress_state;
                    private int id;
                    private String image_url;
                    private double price;
                    private int product_id;
                    private String product_name;
                    private int quantity;
                    private Object sale_price;
                    private String seller_name;
                    private String size_str;
                    private String sku;
                    private String slug;
                    private double total_product_price;
                    private List<?> combo_items;
                    private List<?> other_variant_sizes;

                    public int getCurrent_processed_line_item_id() {
                        return current_processed_line_item_id;
                    }

                    public void setCurrent_processed_line_item_id(int current_processed_line_item_id) {
                        this.current_processed_line_item_id = current_processed_line_item_id;
                    }

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

                    public double getPrice() {
                        return price;
                    }

                    public void setPrice(double price) {
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

                    public double getTotal_product_price() {
                        return total_product_price;
                    }

                    public void setTotal_product_price(double total_product_price) {
                        this.total_product_price = total_product_price;
                    }

                    public List<?> getCombo_items() {
                        return combo_items;
                    }

                    public void setCombo_items(List<?> combo_items) {
                        this.combo_items = combo_items;
                    }

                    public List<?> getOther_variant_sizes() {
                        return other_variant_sizes;
                    }

                    public void setOther_variant_sizes(List<?> other_variant_sizes) {
                        this.other_variant_sizes = other_variant_sizes;
                    }

                    public static class GetProgressStateBean {
                        /**
                         * available_variants : []
                         * cancellation_availability : true
                         * code : Order Confirmed
                         * end_state_details : [{"changed_at":"Nov 25,2020","code":"Order Confirmed"}]
                         * error :
                         * exchange_availability : false
                         * is_negative : false
                         * progress_position : 10
                         * reconfirm_return_availability : false
                         * return_availability : false
                         * stages : ["Placed","Processed","Dispatched","Delivered"]
                         * verify_return_availability : false
                         */

                        private boolean cancellation_availability;
                        private String code;
                        private String error;
                        private boolean exchange_availability;
                        private boolean is_negative;
                        private int progress_position;
                        private boolean reconfirm_return_availability;
                        private boolean return_availability;
                        private boolean verify_return_availability;
                        private List<?> available_variants;
                        private List<EndStateDetailsBean> end_state_details;
                        private List<String> stages;

                        public boolean isCancellation_availability() {
                            return cancellation_availability;
                        }

                        public void setCancellation_availability(boolean cancellation_availability) {
                            this.cancellation_availability = cancellation_availability;
                        }

                        public String getCode() {
                            return code;
                        }

                        public void setCode(String code) {
                            this.code = code;
                        }

                        public String getError() {
                            return error;
                        }

                        public void setError(String error) {
                            this.error = error;
                        }

                        public boolean isExchange_availability() {
                            return exchange_availability;
                        }

                        public void setExchange_availability(boolean exchange_availability) {
                            this.exchange_availability = exchange_availability;
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

                        public boolean isReconfirm_return_availability() {
                            return reconfirm_return_availability;
                        }

                        public void setReconfirm_return_availability(boolean reconfirm_return_availability) {
                            this.reconfirm_return_availability = reconfirm_return_availability;
                        }

                        public boolean isReturn_availability() {
                            return return_availability;
                        }

                        public void setReturn_availability(boolean return_availability) {
                            this.return_availability = return_availability;
                        }

                        public boolean isVerify_return_availability() {
                            return verify_return_availability;
                        }

                        public void setVerify_return_availability(boolean verify_return_availability) {
                            this.verify_return_availability = verify_return_availability;
                        }

                        public List<?> getAvailable_variants() {
                            return available_variants;
                        }

                        public void setAvailable_variants(List<?> available_variants) {
                            this.available_variants = available_variants;
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
                             * changed_at : Nov 25,2020
                             * code : Order Confirmed
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
            }
        }
    }
}
