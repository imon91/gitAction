package services.responseModels.wmsModels;

import java.util.*;

public class WareHouseListModel {


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

    public List<WareHousesBean> wareHousesBeanList;

    public List<WareHousesBean> getWareHousesBeanList() {
        return wareHousesBeanList;
    }

    public void setWareHousesBeanList(List<WareHousesBean> wareHousesBeanList) {
        this.wareHousesBeanList = wareHousesBeanList;
    }

    public class WareHousesBean{
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

        public String getAddress1() { return address1;}

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


}
