package services.responseModels.wmsModels;

import java.io.Serializable;
import java.util.List;

public class OrderListModel {

    /**
     * id : 174
     * market_place_id : 1
     * seller_id : 3
     * warehouse_id : 1
     * order_number : R1956419436-1
     * order_type : 1
     * customer_zipcode : 560045
     * status : 80
     * tracking_code : VNKP0000531691
     * shipment_provider_id : 120
     * vaccount_id : 1
     * created_at : 2019-03-08T19:13:21.000+06:00
     * updated_at : 2019-03-19T17:04:06.000+06:00
     * vendor_address_id : null
     * manifest_id : null
     * due_time : 2019-03-08T19:18:19.000+06:00
     * deleted_at : null
     * status_code : CANCELLED
     * processed_time : 2019-03-08T19:20:02.000+06:00
     * warehouse : {"id":1,"code":"FLYGUD_BNGLR","firstname":"Siva Kumar","address1":"No. 5/BC-106 1st Floor, Service Rd,","address2":"HRBR Layout 3rd Block, Kalyan Nagar","land_mark":"Hennur Cross","city":"Bangalore","state":"Karnataka","country":"India","zipcode":560043,"phone":9900478415,"alternative_phone":9003399231,"vaccount_id":1,"created_at":"2018-01-23T16:15:50.000+06:00","updated_at":"2018-01-23T16:15:50.000+06:00"}
     * market_place : {"id":1,"name":"Voonik","aggregator_name":"VoonikAggregate","user_id":1,"vaccount_id":1,"created_at":"2017-09-25T13:06:30.000+06:00","updated_at":"2017-09-25T13:06:30.000+06:00"}
     * order_line_items : [{"id":174,"order_id":174,"variant_id":643,"pick_list_id":30,"package_id":4411,"price":"399.0","parent_line_item_id":null,"vaccount_id":1,"active":true,"created_at":"2019-03-08T19:13:22.000+06:00","updated_at":"2019-03-08T20:30:44.000+06:00","deleted_at":null,"variant":{"id":643,"seller_id":3,"category_id":1117,"sku_code":"18073TFS002 _F41-L","notes":"Brenco full sleeve Tee","price":"168.0","mrp":"1199.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2019-03-07T16:53:27.000+06:00","updated_at":"2019-07-15T21:29:20.000+06:00"}}]
     */

    private int id;
    private int market_place_id;
    private int seller_id;
    private int warehouse_id;
    private String order_number;
    private int order_type;
    private int customer_zipcode;
    private int status;
    private String tracking_code;
    private int shipment_provider_id;
    private int vaccount_id;
    private String created_at;
    private String updated_at;
    private Object vendor_address_id;
    private Object manifest_id;
    private String due_time;
    private Object deleted_at;
    private String status_code;
    private String processed_time;
    private WarehouseBean warehouse;
    private MarketPlaceBean market_place;
    private List<OrderLineItemsBean> order_line_items;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMarket_place_id() {
        return market_place_id;
    }

    public void setMarket_place_id(int market_place_id) {
        this.market_place_id = market_place_id;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

    public int getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(int warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public int getOrder_type() {
        return order_type;
    }

    public void setOrder_type(int order_type) {
        this.order_type = order_type;
    }

    public int getCustomer_zipcode() {
        return customer_zipcode;
    }

    public void setCustomer_zipcode(int customer_zipcode) {
        this.customer_zipcode = customer_zipcode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTracking_code() {
        return tracking_code;
    }

    public void setTracking_code(String tracking_code) {
        this.tracking_code = tracking_code;
    }

    public int getShipment_provider_id() {
        return shipment_provider_id;
    }

    public void setShipment_provider_id(int shipment_provider_id) {
        this.shipment_provider_id = shipment_provider_id;
    }

    public int getVaccount_id() {
        return vaccount_id;
    }

    public void setVaccount_id(int vaccount_id) {
        this.vaccount_id = vaccount_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Object getVendor_address_id() {
        return vendor_address_id;
    }

    public void setVendor_address_id(Object vendor_address_id) {
        this.vendor_address_id = vendor_address_id;
    }

    public Object getManifest_id() {
        return manifest_id;
    }

    public void setManifest_id(Object manifest_id) {
        this.manifest_id = manifest_id;
    }

    public String getDue_time() {
        return due_time;
    }

    public void setDue_time(String due_time) {
        this.due_time = due_time;
    }

    public Object getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Object deleted_at) {
        this.deleted_at = deleted_at;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public String getProcessed_time() {
        return processed_time;
    }

    public void setProcessed_time(String processed_time) {
        this.processed_time = processed_time;
    }

    public WarehouseBean getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseBean warehouse) {
        this.warehouse = warehouse;
    }

    public MarketPlaceBean getMarket_place() {
        return market_place;
    }

    public void setMarket_place(MarketPlaceBean market_place) {
        this.market_place = market_place;
    }

    public List<OrderLineItemsBean> getOrder_line_items() {
        return order_line_items;
    }

    public void setOrder_line_items(List<OrderLineItemsBean> order_line_items) {
        this.order_line_items = order_line_items;
    }

    public static class WarehouseBean implements Serializable {
        /**
         * id : 1
         * code : FLYGUD_BNGLR
         * firstname : Siva Kumar
         * address1 : No. 5/BC-106 1st Floor, Service Rd,
         * address2 : HRBR Layout 3rd Block, Kalyan Nagar
         * land_mark : Hennur Cross
         * city : Bangalore
         * state : Karnataka
         * country : India
         * zipcode : 560043
         * phone : 9900478415
         * alternative_phone : 9003399231
         * vaccount_id : 1
         * created_at : 2018-01-23T16:15:50.000+06:00
         * updated_at : 2018-01-23T16:15:50.000+06:00
         */

        private int id;
        private String code;
        private String firstname;
        private String address1;
        private String address2;
        private String land_mark;
        private String city;
        private String state;
        private String country;
        private int zipcode;
        private long phone;
        private long alternative_phone;
        private int vaccount_id;
        private String created_at;
        private String updated_at;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
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

        public String getLand_mark() {
            return land_mark;
        }

        public void setLand_mark(String land_mark) {
            this.land_mark = land_mark;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
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

        public int getZipcode() {
            return zipcode;
        }

        public void setZipcode(int zipcode) {
            this.zipcode = zipcode;
        }

        public long getPhone() {
            return phone;
        }

        public void setPhone(long phone) {
            this.phone = phone;
        }

        public long getAlternative_phone() {
            return alternative_phone;
        }

        public void setAlternative_phone(long alternative_phone) {
            this.alternative_phone = alternative_phone;
        }

        public int getVaccount_id() {
            return vaccount_id;
        }

        public void setVaccount_id(int vaccount_id) {
            this.vaccount_id = vaccount_id;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }
    }

    public static class MarketPlaceBean implements Serializable {
        /**
         * id : 1
         * name : Voonik
         * aggregator_name : VoonikAggregate
         * user_id : 1
         * vaccount_id : 1
         * created_at : 2017-09-25T13:06:30.000+06:00
         * updated_at : 2017-09-25T13:06:30.000+06:00
         */

        private int id;
        private String name;
        private String aggregator_name;
        private int user_id;
        private int vaccount_id;
        private String created_at;
        private String updated_at;

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

        public String getAggregator_name() {
            return aggregator_name;
        }

        public void setAggregator_name(String aggregator_name) {
            this.aggregator_name = aggregator_name;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getVaccount_id() {
            return vaccount_id;
        }

        public void setVaccount_id(int vaccount_id) {
            this.vaccount_id = vaccount_id;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }
    }

    public static class OrderLineItemsBean implements Serializable {
        /**
         * id : 174
         * order_id : 174
         * variant_id : 643
         * pick_list_id : 30
         * package_id : 4411
         * price : 399.0
         * parent_line_item_id : null
         * vaccount_id : 1
         * active : true
         * created_at : 2019-03-08T19:13:22.000+06:00
         * updated_at : 2019-03-08T20:30:44.000+06:00
         * deleted_at : null
         * variant : {"id":643,"seller_id":3,"category_id":1117,"sku_code":"18073TFS002 _F41-L","notes":"Brenco full sleeve Tee","price":"168.0","mrp":"1199.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2019-03-07T16:53:27.000+06:00","updated_at":"2019-07-15T21:29:20.000+06:00"}
         */

        private int id;
        private int order_id;
        private int variant_id;
        private int pick_list_id;
        private int package_id;
        private String price;
        private Object parent_line_item_id;
        private int vaccount_id;
        private boolean active;
        private String created_at;
        private String updated_at;
        private Object deleted_at;
        private VariantBean variant;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public int getVariant_id() {
            return variant_id;
        }

        public void setVariant_id(int variant_id) {
            this.variant_id = variant_id;
        }

        public int getPick_list_id() {
            return pick_list_id;
        }

        public void setPick_list_id(int pick_list_id) {
            this.pick_list_id = pick_list_id;
        }

        public int getPackage_id() {
            return package_id;
        }

        public void setPackage_id(int package_id) {
            this.package_id = package_id;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public Object getParent_line_item_id() {
            return parent_line_item_id;
        }

        public void setParent_line_item_id(Object parent_line_item_id) {
            this.parent_line_item_id = parent_line_item_id;
        }

        public int getVaccount_id() {
            return vaccount_id;
        }

        public void setVaccount_id(int vaccount_id) {
            this.vaccount_id = vaccount_id;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public Object getDeleted_at() {
            return deleted_at;
        }

        public void setDeleted_at(Object deleted_at) {
            this.deleted_at = deleted_at;
        }

        public VariantBean getVariant() {
            return variant;
        }

        public void setVariant(VariantBean variant) {
            this.variant = variant;
        }

        public static class VariantBean implements Serializable {
            /**
             * id : 643
             * seller_id : 3
             * category_id : 1117
             * sku_code : 18073TFS002 _F41-L
             * notes : Brenco full sleeve Tee
             * price : 168.0
             * mrp : 1199.0
             * reorder_point : 20
             * active : true
             * vaccount_id : 1
             * created_at : 2019-03-07T16:53:27.000+06:00
             * updated_at : 2019-07-15T21:29:20.000+06:00
             */

            private int id;
            private int seller_id;
            private int category_id;
            private String sku_code;
            private String notes;
            private String price;
            private String mrp;
            private int reorder_point;
            private boolean active;
            private int vaccount_id;
            private String created_at;
            private String updated_at;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getSeller_id() {
                return seller_id;
            }

            public void setSeller_id(int seller_id) {
                this.seller_id = seller_id;
            }

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public String getSku_code() {
                return sku_code;
            }

            public void setSku_code(String sku_code) {
                this.sku_code = sku_code;
            }

            public String getNotes() {
                return notes;
            }

            public void setNotes(String notes) {
                this.notes = notes;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getMrp() {
                return mrp;
            }

            public void setMrp(String mrp) {
                this.mrp = mrp;
            }

            public int getReorder_point() {
                return reorder_point;
            }

            public void setReorder_point(int reorder_point) {
                this.reorder_point = reorder_point;
            }

            public boolean isActive() {
                return active;
            }

            public void setActive(boolean active) {
                this.active = active;
            }

            public int getVaccount_id() {
                return vaccount_id;
            }

            public void setVaccount_id(int vaccount_id) {
                this.vaccount_id = vaccount_id;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }
        }
    }
}
