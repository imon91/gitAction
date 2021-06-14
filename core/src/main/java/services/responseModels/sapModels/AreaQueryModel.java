package services.responseModels.sapModels;

import java.io.Serializable;
import java.util.List;

public class AreaQueryModel {

    /**
     * error : false
     * areas : [{"id":1,"name":"Mohammadpur(Dhaka)","nameBn":"মোহাম্মদপুর","courseId":null,"zoneId":1,"districtId":1,"postCode":1207,"isHomeDelivery":1,"isCodAvailable":1,"type":"level4","defaultPrice":70,"status":"active","createdAt":"2017-10-19T17:16:04.000Z","updatedAt":"2021-06-10T09:45:23.000Z","isPickupAvailable":1,"isLockedDown":0,"isOperational":0,"zoneName":"Dhaka City","partnerId":3,"zoneStatus":"preferred","shopupChargeMinPrice":null,"shopupChargeKg05Price":null,"shopupChargeKg1Price":null,"shopupChargeKg2Price":null,"shopupChargeMaxPrice":null,"partners":[{"partnerId":3,"status":"preferred"},{"partnerId":5,"status":"active"},{"partnerId":8,"status":"active"},{"partnerId":12,"status":"active"}]},{"id":2,"name":"Dhanmondi","nameBn":"ধানমন্ডি","courseId":20,"zoneId":1,"districtId":1,"postCode":1209,"isHomeDelivery":1,"isCodAvailable":1,"type":"level4","defaultPrice":70,"status":"active","createdAt":"2017-10-19T17:16:58.000Z","updatedAt":"2021-06-10T09:06:45.000Z","isPickupAvailable":1,"isLockedDown":0,"isOperational":0,"zoneName":"Dhaka City","partnerId":3,"zoneStatus":"preferred","shopupChargeMinPrice":null,"shopupChargeKg05Price":null,"shopupChargeKg1Price":null,"shopupChargeKg2Price":null,"shopupChargeMaxPrice":null,"partners":[{"partnerId":3,"status":"preferred"},{"partnerId":5,"status":"active"},{"partnerId":8,"status":"active"}]}]
     */

    private boolean error;
    private List<AreasBean> areas;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<AreasBean> getAreas() {
        return areas;
    }

    public void setAreas(List<AreasBean> areas) {
        this.areas = areas;
    }

    public static class AreasBean implements Serializable {
        /**
         * id : 1
         * name : Mohammadpur(Dhaka)
         * nameBn : মোহাম্মদপুর
         * courseId : null
         * zoneId : 1
         * districtId : 1
         * postCode : 1207
         * isHomeDelivery : 1
         * isCodAvailable : 1
         * type : level4
         * defaultPrice : 70
         * status : active
         * createdAt : 2017-10-19T17:16:04.000Z
         * updatedAt : 2021-06-10T09:45:23.000Z
         * isPickupAvailable : 1
         * isLockedDown : 0
         * isOperational : 0
         * zoneName : Dhaka City
         * partnerId : 3
         * zoneStatus : preferred
         * shopupChargeMinPrice : null
         * shopupChargeKg05Price : null
         * shopupChargeKg1Price : null
         * shopupChargeKg2Price : null
         * shopupChargeMaxPrice : null
         * partners : [{"partnerId":3,"status":"preferred"},{"partnerId":5,"status":"active"},{"partnerId":8,"status":"active"},{"partnerId":12,"status":"active"}]
         */

        private int id;
        private String name;
        private String nameBn;
        private Object courseId;
        private int zoneId;
        private int districtId;
        private int postCode;
        private int isHomeDelivery;
        private int isCodAvailable;
        private String type;
        private int defaultPrice;
        private String status;
        private String createdAt;
        private String updatedAt;
        private int isPickupAvailable;
        private int isLockedDown;
        private int isOperational;
        private String zoneName;
        private int partnerId;
        private String zoneStatus;
        private Object shopupChargeMinPrice;
        private Object shopupChargeKg05Price;
        private Object shopupChargeKg1Price;
        private Object shopupChargeKg2Price;
        private Object shopupChargeMaxPrice;
        private List<PartnersBean> partners;

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

        public String getNameBn() {
            return nameBn;
        }

        public void setNameBn(String nameBn) {
            this.nameBn = nameBn;
        }

        public Object getCourseId() {
            return courseId;
        }

        public void setCourseId(Object courseId) {
            this.courseId = courseId;
        }

        public int getZoneId() {
            return zoneId;
        }

        public void setZoneId(int zoneId) {
            this.zoneId = zoneId;
        }

        public int getDistrictId() {
            return districtId;
        }

        public void setDistrictId(int districtId) {
            this.districtId = districtId;
        }

        public int getPostCode() {
            return postCode;
        }

        public void setPostCode(int postCode) {
            this.postCode = postCode;
        }

        public int getIsHomeDelivery() {
            return isHomeDelivery;
        }

        public void setIsHomeDelivery(int isHomeDelivery) {
            this.isHomeDelivery = isHomeDelivery;
        }

        public int getIsCodAvailable() {
            return isCodAvailable;
        }

        public void setIsCodAvailable(int isCodAvailable) {
            this.isCodAvailable = isCodAvailable;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getDefaultPrice() {
            return defaultPrice;
        }

        public void setDefaultPrice(int defaultPrice) {
            this.defaultPrice = defaultPrice;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public int getIsPickupAvailable() {
            return isPickupAvailable;
        }

        public void setIsPickupAvailable(int isPickupAvailable) {
            this.isPickupAvailable = isPickupAvailable;
        }

        public int getIsLockedDown() {
            return isLockedDown;
        }

        public void setIsLockedDown(int isLockedDown) {
            this.isLockedDown = isLockedDown;
        }

        public int getIsOperational() {
            return isOperational;
        }

        public void setIsOperational(int isOperational) {
            this.isOperational = isOperational;
        }

        public String getZoneName() {
            return zoneName;
        }

        public void setZoneName(String zoneName) {
            this.zoneName = zoneName;
        }

        public int getPartnerId() {
            return partnerId;
        }

        public void setPartnerId(int partnerId) {
            this.partnerId = partnerId;
        }

        public String getZoneStatus() {
            return zoneStatus;
        }

        public void setZoneStatus(String zoneStatus) {
            this.zoneStatus = zoneStatus;
        }

        public Object getShopupChargeMinPrice() {
            return shopupChargeMinPrice;
        }

        public void setShopupChargeMinPrice(Object shopupChargeMinPrice) {
            this.shopupChargeMinPrice = shopupChargeMinPrice;
        }

        public Object getShopupChargeKg05Price() {
            return shopupChargeKg05Price;
        }

        public void setShopupChargeKg05Price(Object shopupChargeKg05Price) {
            this.shopupChargeKg05Price = shopupChargeKg05Price;
        }

        public Object getShopupChargeKg1Price() {
            return shopupChargeKg1Price;
        }

        public void setShopupChargeKg1Price(Object shopupChargeKg1Price) {
            this.shopupChargeKg1Price = shopupChargeKg1Price;
        }

        public Object getShopupChargeKg2Price() {
            return shopupChargeKg2Price;
        }

        public void setShopupChargeKg2Price(Object shopupChargeKg2Price) {
            this.shopupChargeKg2Price = shopupChargeKg2Price;
        }

        public Object getShopupChargeMaxPrice() {
            return shopupChargeMaxPrice;
        }

        public void setShopupChargeMaxPrice(Object shopupChargeMaxPrice) {
            this.shopupChargeMaxPrice = shopupChargeMaxPrice;
        }

        public List<PartnersBean> getPartners() {
            return partners;
        }

        public void setPartners(List<PartnersBean> partners) {
            this.partners = partners;
        }

        public static class PartnersBean implements Serializable {
            /**
             * partnerId : 3
             * status : preferred
             */

            private int partnerId;
            private String status;

            public int getPartnerId() {
                return partnerId;
            }

            public void setPartnerId(int partnerId) {
                this.partnerId = partnerId;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }
        }
    }
}
