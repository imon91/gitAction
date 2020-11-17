package services.responseModels.commerceModels;

import java.util.List;

public class MokamUserAddressesModel {

    private boolean signed_in_user;
    private ShipAddressBean ship_address;
    private List<ShippedAddressesBean> shipped_addresses;

    public boolean isSigned_in_user() {
        return signed_in_user;
    }

    public void setSigned_in_user(boolean signed_in_user) {
        this.signed_in_user = signed_in_user;
    }

    public ShipAddressBean getShip_address() {
        return ship_address;
    }

    public void setShip_address(ShipAddressBean ship_address) {
        this.ship_address = ship_address;
    }

    public List<ShippedAddressesBean> getShipped_addresses() {
        return shipped_addresses;
    }

    public void setShipped_addresses(List<ShippedAddressesBean> shipped_addresses) {
        this.shipped_addresses = shipped_addresses;
    }

    public static class ShipAddressBean {
        private AddressBean address;

        public AddressBean getAddress() {
            return address;
        }

        public void setAddress(AddressBean address) {
            this.address = address;
        }

        public static class AddressBean {
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
