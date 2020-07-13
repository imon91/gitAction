package services.responseModels.wmsModels;

import java.util.List;

public class SuppliersListModel {


    /**
     * id : 10
     * seller_id : null
     * name : Krishna Impex
     * email : selvaprakash@voonik.com
     * phone : 9677554737
     * vaccount_id : 1
     * created_at : 2018-01-23T16:38:18.000+06:00
     * updated_at : 2018-01-23T16:38:18.000+06:00
     * supplier_addresses : [{"id":11,"supplier_id":10,"address1":"No:17, Subhas street , MEG layout main road","address2":"Near mythri school, A. Narayanpura","land_mark":"","city":"Bangalore","state":"Karnataka","country":null,"zipcode":560016,"deleted_at":null,"vaccount_id":1,"created_at":"2018-01-23T16:38:18.000+06:00","updated_at":"2018-01-23T16:38:18.000+06:00","gst_number":null},{"id":12,"supplier_id":10,"address1":"Voonik Technologies","address2":"No. 5/BC-106 1st Floor","land_mark":"Karnataka","city":"Bangalore","state":"Karnataka","country":null,"zipcode":560043,"deleted_at":null,"vaccount_id":1,"created_at":"2019-03-06T17:56:55.000+06:00","updated_at":"2019-04-08T17:11:42.000+06:00","gst_number":null}]
     */

    private int id;
    private Object seller_id;
    private String name;
    private String email;
    private long phone;
    private int vaccount_id;
    private String created_at;
    private String updated_at;
    private List<SupplierAddressesBean> supplier_addresses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Object seller_id) {
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

    public String getPhone() {
        return String.valueOf(phone);
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

    public List<SupplierAddressesBean> getSupplier_addresses() {
        return supplier_addresses;
    }

    public void setSupplier_addresses(List<SupplierAddressesBean> supplier_addresses) {
        this.supplier_addresses = supplier_addresses;
    }

    public static class SupplierAddressesBean {
        /**
         * id : 11
         * supplier_id : 10
         * address1 : No:17, Subhas street , MEG layout main road
         * address2 : Near mythri school, A. Narayanpura
         * land_mark :
         * city : Bangalore
         * state : Karnataka
         * country : null
         * zipcode : 560016
         * deleted_at : null
         * vaccount_id : 1
         * created_at : 2018-01-23T16:38:18.000+06:00
         * updated_at : 2018-01-23T16:38:18.000+06:00
         * gst_number : null
         */

        private int id;
        private int supplier_id;
        private String address1;
        private String address2;
        private String land_mark;
        private String city;
        private String state;
        private Object country;
        private int zipcode;
        private Object deleted_at;
        private int vaccount_id;
        private String created_at;
        private String updated_at;
        private Object gst_number;

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

        public Object getCountry() {
            return country;
        }

        public void setCountry(Object country) {
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

        public Object getGst_number() {
            return gst_number;
        }

        public void setGst_number(Object gst_number) {
            this.gst_number = gst_number;
        }
    }
}
