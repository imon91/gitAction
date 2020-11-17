package services.responseModels.commerceModels;

public class MokamUserProfileModel {

    private String status;
    private String error;
    private String eloan_link;
    private String boost_link;
    private String khata_link;
    private String success;
    private String email;
    private String name;
    private String phone;
    private String gender;
    private String shop_name;
    private Object occupation;
    private String dob;
    private Object selling_preference;
    private AddressBean address;
    private Object nid_number;
    private String business_type;
    private boolean localisation_enabled;
    private int primo_subscription;
    private Object location;
    private Object zone;
    private String user_type;
    private Object zone_nr;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getEloan_link() {
        return eloan_link;
    }

    public void setEloan_link(String eloan_link) {
        this.eloan_link = eloan_link;
    }

    public String getBoost_link() {
        return boost_link;
    }

    public void setBoost_link(String boost_link) {
        this.boost_link = boost_link;
    }

    public String getKhata_link() {
        return khata_link;
    }

    public void setKhata_link(String khata_link) {
        this.khata_link = khata_link;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public Object getOccupation() {
        return occupation;
    }

    public void setOccupation(Object occupation) {
        this.occupation = occupation;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Object getSelling_preference() {
        return selling_preference;
    }

    public void setSelling_preference(Object selling_preference) {
        this.selling_preference = selling_preference;
    }

    public AddressBean getAddress() {
        return address;
    }

    public void setAddress(AddressBean address) {
        this.address = address;
    }

    public Object getNid_number() {
        return nid_number;
    }

    public void setNid_number(Object nid_number) {
        this.nid_number = nid_number;
    }

    public String getBusiness_type() {
        return business_type;
    }

    public void setBusiness_type(String business_type) {
        this.business_type = business_type;
    }

    public boolean isLocalisation_enabled() {
        return localisation_enabled;
    }

    public void setLocalisation_enabled(boolean localisation_enabled) {
        this.localisation_enabled = localisation_enabled;
    }

    public int getPrimo_subscription() {
        return primo_subscription;
    }

    public void setPrimo_subscription(int primo_subscription) {
        this.primo_subscription = primo_subscription;
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public Object getZone() {
        return zone;
    }

    public void setZone(Object zone) {
        this.zone = zone;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public Object getZone_nr() {
        return zone_nr;
    }

    public void setZone_nr(Object zone_nr) {
        this.zone_nr = zone_nr;
    }

    public static class AddressBean {
        private int id;
        private String address1;
        private String address2;
        private Object alternative_phone;
        private String city;
        private Object company;
        private Object country;
        private int country_id;
        private String created_at;
        private String firstname;
        private Object is_saved;
        private Object landmark;
        private Object lastname;
        private String location;
        private String phone;
        private String state;
        private int state_id;
        private String updated_at;
        private UserBean user;
        private int vaccount_id;
        private String zipcode;
        private String zone;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public Object getAlternative_phone() {
            return alternative_phone;
        }

        public void setAlternative_phone(Object alternative_phone) {
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

        public Object getCountry() {
            return country;
        }

        public void setCountry(Object country) {
            this.country = country;
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

        public Object getIs_saved() {
            return is_saved;
        }

        public void setIs_saved(Object is_saved) {
            this.is_saved = is_saved;
        }

        public Object getLandmark() {
            return landmark;
        }

        public void setLandmark(Object landmark) {
            this.landmark = landmark;
        }

        public Object getLastname() {
            return lastname;
        }

        public void setLastname(Object lastname) {
            this.lastname = lastname;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
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

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
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

        public static class UserBean {
            private int id;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}
