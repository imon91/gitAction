package services.responseModels.wmsModels;

import java.io.Serializable;
import java.util.List;

public class PurchaseOrderListModel {

    /**
     * id : 217440
     * seller_id : 29
     * supplier_id : 144
     * supplier_address_id : 56
     * warehouse_id : 100
     * status : closed
     * po_type : forward
     * vaccount_id : 1
     * created_at : 2020-06-29T12:45:50.000+06:00
     * updated_at : 2020-06-29T17:57:27.000+06:00
     * warehouse : {"id":100,"code":"Shopup Dhaka","firstname":"Shopup Main Warehouse Dhaka","address1":"Civil House, B111","address2":"Road 08, Mohakhali DOHS","land_mark":"Shopup","city":"Dhaka","state":"Dhaka","country":"Bangladesh","zipcode":1206,"phone":8809678771288,"alternative_phone":null,"vaccount_id":1,"created_at":"2020-01-09T19:24:14.000+06:00","updated_at":"2020-01-09T19:24:14.000+06:00"}
     * supplier_address : {"id":56,"supplier_id":144,"address1":"House no. 33 Road:3 Block - D , Mirpur-1","address2":"House no. 33 Road:3 Block - D , Mirpur-1","land_mark":"Dhaka","city":"city","state":"Andhra Pradesh","country":"India","zipcode":98,"deleted_at":null,"vaccount_id":1,"created_at":"2020-05-04T12:51:36.000+06:00","updated_at":"2020-05-04T12:51:36.000+06:00","gst_number":"29AHSJD0482H1ZV","supplier":{"id":144,"seller_id":29,"name":"Dhaka Fashion Wear","email":"9@shopupseller.com","phone":8801677157458,"vaccount_id":1,"created_at":"2020-05-04T12:51:36.000+06:00","updated_at":"2020-06-03T17:56:04.000+06:00"}}
     * purchase_order_line_items : [{"id":157934,"purchase_order_id":217440,"variant_id":7775,"ordered_quantity":1,"unit_price":"350.0","vaccount_id":1,"created_at":"2020-06-29T12:45:50.000+06:00","updated_at":"2020-06-29T12:45:50.000+06:00","inward_details":{"in_scanned":0,"qc_passed":0,"qc_failed":0,"on_hold":0,"qc_scanned":0},"variant":{"id":7775,"seller_id":29,"category_id":1892,"sku_code":"140882","notes":"Jack & Jones Full Sleeve T-Shirt Blue L Size - DFW1501 - 5LJ1 3387 1A00","price":"350.0","mrp":"395.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:52:03.000+06:00","updated_at":"2020-05-04T12:52:03.000+06:00"}}]
     */

    private int id;
    private int seller_id;
    private int supplier_id;
    private int supplier_address_id;
    private int warehouse_id;
    private String status;
    private String po_type;
    private int vaccount_id;
    private String created_at;
    private String updated_at;
    private WarehouseBean warehouse;
    private SupplierAddressBean supplier_address;
    private List<PurchaseOrderLineItemsBean> purchase_order_line_items;

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

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public int getSupplier_address_id() {
        return supplier_address_id;
    }

    public void setSupplier_address_id(int supplier_address_id) {
        this.supplier_address_id = supplier_address_id;
    }

    public int getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(int warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPo_type() {
        return po_type;
    }

    public void setPo_type(String po_type) {
        this.po_type = po_type;
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

    public WarehouseBean getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseBean warehouse) {
        this.warehouse = warehouse;
    }

    public SupplierAddressBean getSupplier_address() {
        return supplier_address;
    }

    public void setSupplier_address(SupplierAddressBean supplier_address) {
        this.supplier_address = supplier_address;
    }

    public List<PurchaseOrderLineItemsBean> getPurchase_order_line_items() {
        return purchase_order_line_items;
    }

    public void setPurchase_order_line_items(List<PurchaseOrderLineItemsBean> purchase_order_line_items) {
        this.purchase_order_line_items = purchase_order_line_items;
    }

    public static class WarehouseBean implements Serializable {
        /**
         * id : 100
         * code : Shopup Dhaka
         * firstname : Shopup Main Warehouse Dhaka
         * address1 : Civil House, B111
         * address2 : Road 08, Mohakhali DOHS
         * land_mark : Shopup
         * city : Dhaka
         * state : Dhaka
         * country : Bangladesh
         * zipcode : 1206
         * phone : 8809678771288
         * alternative_phone : null
         * vaccount_id : 1
         * created_at : 2020-01-09T19:24:14.000+06:00
         * updated_at : 2020-01-09T19:24:14.000+06:00
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
        private Object alternative_phone;
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

        public Object getAlternative_phone() {
            return alternative_phone;
        }

        public void setAlternative_phone(Object alternative_phone) {
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

    public static class SupplierAddressBean implements Serializable {
        /**
         * id : 56
         * supplier_id : 144
         * address1 : House no. 33 Road:3 Block - D , Mirpur-1
         * address2 : House no. 33 Road:3 Block - D , Mirpur-1
         * land_mark : Dhaka
         * city : city
         * state : Andhra Pradesh
         * country : India
         * zipcode : 98
         * deleted_at : null
         * vaccount_id : 1
         * created_at : 2020-05-04T12:51:36.000+06:00
         * updated_at : 2020-05-04T12:51:36.000+06:00
         * gst_number : 29AHSJD0482H1ZV
         * supplier : {"id":144,"seller_id":29,"name":"Dhaka Fashion Wear","email":"9@shopupseller.com","phone":8801677157458,"vaccount_id":1,"created_at":"2020-05-04T12:51:36.000+06:00","updated_at":"2020-06-03T17:56:04.000+06:00"}
         */

        private int id;
        private int supplier_id;
        private String address1;
        private String address2;
        private String land_mark;
        private String city;
        private String state;
        private String country;
        private int zipcode;
        private Object deleted_at;
        private int vaccount_id;
        private String created_at;
        private String updated_at;
        private String gst_number;
        private SupplierBean supplier;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSupplier_id() {
            return supplier_id;
        }

        public void setSupplier_id(int supplier_id) {
            this.supplier_id = supplier_id;
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

        public Object getDeleted_at() {
            return deleted_at;
        }

        public void setDeleted_at(Object deleted_at) {
            this.deleted_at = deleted_at;
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

        public String getGst_number() {
            return gst_number;
        }

        public void setGst_number(String gst_number) {
            this.gst_number = gst_number;
        }

        public SupplierBean getSupplier() {
            return supplier;
        }

        public void setSupplier(SupplierBean supplier) {
            this.supplier = supplier;
        }

        public static class SupplierBean implements Serializable {
            /**
             * id : 144
             * seller_id : 29
             * name : Dhaka Fashion Wear
             * email : 9@shopupseller.com
             * phone : 8801677157458
             * vaccount_id : 1
             * created_at : 2020-05-04T12:51:36.000+06:00
             * updated_at : 2020-06-03T17:56:04.000+06:00
             */

            private int id;
            private int seller_id;
            private String name;
            private String email;
            private long phone;
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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public long getPhone() {
                return phone;
            }

            public void setPhone(long phone) {
                this.phone = phone;
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

    public static class PurchaseOrderLineItemsBean implements Serializable {
        /**
         * id : 157934
         * purchase_order_id : 217440
         * variant_id : 7775
         * ordered_quantity : 1
         * unit_price : 350.0
         * vaccount_id : 1
         * created_at : 2020-06-29T12:45:50.000+06:00
         * updated_at : 2020-06-29T12:45:50.000+06:00
         * inward_details : {"in_scanned":0,"qc_passed":0,"qc_failed":0,"on_hold":0,"qc_scanned":0}
         * variant : {"id":7775,"seller_id":29,"category_id":1892,"sku_code":"140882","notes":"Jack & Jones Full Sleeve T-Shirt Blue L Size - DFW1501 - 5LJ1 3387 1A00","price":"350.0","mrp":"395.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:52:03.000+06:00","updated_at":"2020-05-04T12:52:03.000+06:00"}
         */

        private int id;
        private int purchase_order_id;
        private int variant_id;
        private int ordered_quantity;
        private String unit_price;
        private int vaccount_id;
        private String created_at;
        private String updated_at;
        private InwardDetailsBean inward_details;
        private VariantBean variant;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPurchase_order_id() {
            return purchase_order_id;
        }

        public void setPurchase_order_id(int purchase_order_id) {
            this.purchase_order_id = purchase_order_id;
        }

        public int getVariant_id() {
            return variant_id;
        }

        public void setVariant_id(int variant_id) {
            this.variant_id = variant_id;
        }

        public int getOrdered_quantity() {
            return ordered_quantity;
        }

        public void setOrdered_quantity(int ordered_quantity) {
            this.ordered_quantity = ordered_quantity;
        }

        public String getUnit_price() {
            return unit_price;
        }

        public void setUnit_price(String unit_price) {
            this.unit_price = unit_price;
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

        public InwardDetailsBean getInward_details() {
            return inward_details;
        }

        public void setInward_details(InwardDetailsBean inward_details) {
            this.inward_details = inward_details;
        }

        public VariantBean getVariant() {
            return variant;
        }

        public void setVariant(VariantBean variant) {
            this.variant = variant;
        }

        public static class InwardDetailsBean implements Serializable {
            /**
             * in_scanned : 0
             * qc_passed : 0
             * qc_failed : 0
             * on_hold : 0
             * qc_scanned : 0
             */

            private int in_scanned;
            private int qc_passed;
            private int qc_failed;
            private int on_hold;
            private int qc_scanned;

            public int getIn_scanned() {
                return in_scanned;
            }

            public void setIn_scanned(int in_scanned) {
                this.in_scanned = in_scanned;
            }

            public int getQc_passed() {
                return qc_passed;
            }

            public void setQc_passed(int qc_passed) {
                this.qc_passed = qc_passed;
            }

            public int getQc_failed() {
                return qc_failed;
            }

            public void setQc_failed(int qc_failed) {
                this.qc_failed = qc_failed;
            }

            public int getOn_hold() {
                return on_hold;
            }

            public void setOn_hold(int on_hold) {
                this.on_hold = on_hold;
            }

            public int getQc_scanned() {
                return qc_scanned;
            }

            public void setQc_scanned(int qc_scanned) {
                this.qc_scanned = qc_scanned;
            }
        }

        public static class VariantBean implements Serializable {
            /**
             * id : 7775
             * seller_id : 29
             * category_id : 1892
             * sku_code : 140882
             * notes : Jack & Jones Full Sleeve T-Shirt Blue L Size - DFW1501 - 5LJ1 3387 1A00
             * price : 350.0
             * mrp : 395.0
             * reorder_point : 20
             * active : true
             * vaccount_id : 1
             * created_at : 2020-05-04T12:52:03.000+06:00
             * updated_at : 2020-05-04T12:52:03.000+06:00
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
