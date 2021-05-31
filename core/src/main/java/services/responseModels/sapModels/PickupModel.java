package services.responseModels.sapModels;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PickupModel {

    /**
     * shops : [{"ID":1846,"SHOP_ID":10,"PR_CODE":null,"SOURCE_SELLER_ID":null,"REF_TYPE":"SHOP","PARCEL_COUNT":4,"PICKUP_DAY":"2021-05-09","PARCEL_PICKEDUP_COUNT":null,"PICKUP_AGENT_ID":4847,"ENTRY_SOURCE":"PICKUP_PENDING_PARCEL","FAILED_REASON":null,"REMARKS":null,"UPDATED_BY":null,"STATUS":"confirmed","LAST_STATUS_UPDATE_TIME":"2021-05-09T03:25:13.000Z","CONTACTED":0,"CREATED_AT":"2021-05-09T03:25:13.000Z","UPDATED_AT":"2021-05-09T03:25:13.000Z","SCANNED_PARCEL_COUNT":0,"UNSCANNED_PARCEL_COUNT":0,"SHOP_STORE_ID":2,"MANUAL_PARCEL_COUNT":null,"SHOP_NAME":"Ice9 Apps Showcase","SHOP_PHONE":"01678600786","SHOP_CREATED_AT":"2015-12-24T06:10:56.000Z","PICKUP_PHONE":"8801678600786","PICKUP_ADDRESS":"Dhanmondi","AREA_ID":2,"AREA_NAME":"Dhanmondi","HUB_ID":1,"AGENT_ID":4847,"AGENT_NAME":"Afsana Hossain","SHOP_STORE_NAME":"Dhanmondi","SHOP_STORE_ADDRESS":"Dhanmondi"},{"ID":1869,"SHOP_ID":525,"PR_CODE":null,"SOURCE_SELLER_ID":null,"REF_TYPE":"SHOP","PARCEL_COUNT":20,"PICKUP_DAY":"2021-05-18","PARCEL_PICKEDUP_COUNT":null,"PICKUP_AGENT_ID":null,"ENTRY_SOURCE":"SELLER","FAILED_REASON":null,"REMARKS":null,"UPDATED_BY":null,"STATUS":"confirmed","LAST_STATUS_UPDATE_TIME":"2021-05-18T06:38:34.000Z","CONTACTED":0,"CREATED_AT":"2021-05-18T06:38:34.000Z","UPDATED_AT":"2021-05-18T06:38:34.000Z","SCANNED_PARCEL_COUNT":0,"UNSCANNED_PARCEL_COUNT":0,"SHOP_STORE_ID":34,"MANUAL_PARCEL_COUNT":null,"SHOP_NAME":"Online Women's Fashion Dress collection","SHOP_PHONE":"8801926810968","SHOP_CREATED_AT":"2016-05-17T09:37:22.000Z","PICKUP_PHONE":"8801926810968","PICKUP_ADDRESS":"66/2, Jn Shaha Road, Amligola ,Lalbagh","AREA_ID":117,"AREA_NAME":"Lalbagh","HUB_ID":1,"AGENT_ID":null,"AGENT_NAME":null,"SHOP_STORE_NAME":"Lalbagh","SHOP_STORE_ADDRESS":"66/2, Jn Shaha Road, Amligola ,Lalbagh"},{"ID":1848,"SHOP_ID":283469,"PR_CODE":null,"SOURCE_SELLER_ID":null,"REF_TYPE":"SHOP","PARCEL_COUNT":1,"PICKUP_DAY":"2021-05-09","PARCEL_PICKEDUP_COUNT":null,"PICKUP_AGENT_ID":633,"ENTRY_SOURCE":"PICKUP_PENDING_PARCEL","FAILED_REASON":null,"REMARKS":null,"UPDATED_BY":null,"STATUS":"confirmed","LAST_STATUS_UPDATE_TIME":"2021-05-09T03:25:13.000Z","CONTACTED":0,"CREATED_AT":"2021-05-09T03:25:13.000Z","UPDATED_AT":"2021-05-09T03:25:13.000Z","SCANNED_PARCEL_COUNT":0,"UNSCANNED_PARCEL_COUNT":0,"SHOP_STORE_ID":9910,"MANUAL_PARCEL_COUNT":null,"SHOP_NAME":"Football Stats","SHOP_PHONE":"01521380934","SHOP_CREATED_AT":"2020-01-02T09:32:03.000Z","PICKUP_PHONE":"8801682109113","PICKUP_ADDRESS":"H-103, Road-08, Dhanmondi","AREA_ID":103,"AREA_NAME":"Kalabagan","HUB_ID":1,"AGENT_ID":633,"AGENT_NAME":"Asraful Hassan PA","SHOP_STORE_NAME":"Kalabagan","SHOP_STORE_ADDRESS":"H-103, Road-08, Dhanmondi"},{"ID":1851,"SHOP_ID":648105,"PR_CODE":null,"SOURCE_SELLER_ID":null,"REF_TYPE":"SHOP","PARCEL_COUNT":3,"PICKUP_DAY":"2021-05-17","PARCEL_PICKEDUP_COUNT":2,"PICKUP_AGENT_ID":113,"ENTRY_SOURCE":"SELLER","FAILED_REASON":null,"REMARKS":null,"UPDATED_BY":473867,"STATUS":"confirmed","LAST_STATUS_UPDATE_TIME":"2021-05-17T06:38:01.000Z","CONTACTED":0,"CREATED_AT":"2021-05-17T06:38:01.000Z","UPDATED_AT":"2021-05-17T17:23:10.000Z","SCANNED_PARCEL_COUNT":0,"UNSCANNED_PARCEL_COUNT":0,"SHOP_STORE_ID":64109,"MANUAL_PARCEL_COUNT":null,"SHOP_NAME":"ashok shops","SHOP_PHONE":"8801401122188","SHOP_CREATED_AT":"2021-01-28T05:40:33.000Z","PICKUP_PHONE":"8801401122188","PICKUP_ADDRESS":"dhanmondi","AREA_ID":2,"AREA_NAME":"Dhanmondi","HUB_ID":1,"AGENT_ID":113,"AGENT_NAME":"CX Pickup/Return Agent-1 (EDIT)","SHOP_STORE_NAME":"Dhanmondi","SHOP_STORE_ADDRESS":"dhanmondi"},{"ID":1857,"SHOP_ID":648128,"PR_CODE":null,"SOURCE_SELLER_ID":null,"REF_TYPE":"SHOP","PARCEL_COUNT":2,"PICKUP_DAY":"2021-05-10","PARCEL_PICKEDUP_COUNT":2,"PICKUP_AGENT_ID":87,"ENTRY_SOURCE":"SELLER","FAILED_REASON":null,"REMARKS":null,"UPDATED_BY":92398,"STATUS":"picked-up","LAST_STATUS_UPDATE_TIME":"2021-05-10T13:44:57.000Z","CONTACTED":0,"CREATED_AT":"2021-05-10T13:43:11.000Z","UPDATED_AT":"2021-05-10T13:44:57.000Z","SCANNED_PARCEL_COUNT":0,"UNSCANNED_PARCEL_COUNT":0,"SHOP_STORE_ID":64128,"MANUAL_PARCEL_COUNT":null,"SHOP_NAME":"Normal shop","SHOP_PHONE":"8801401122188","SHOP_CREATED_AT":"2021-01-31T06:45:14.000Z","PICKUP_PHONE":"8801401122188","PICKUP_ADDRESS":"dhanmondi","AREA_ID":2,"AREA_NAME":"Dhanmondi","HUB_ID":1,"AGENT_ID":87,"AGENT_NAME":"CX Pickup/Return Agent","SHOP_STORE_NAME":"Dhanmondi","SHOP_STORE_ADDRESS":"dhanmondi"},{"ID":1867,"SHOP_ID":648222,"PR_CODE":null,"SOURCE_SELLER_ID":null,"REF_TYPE":"SHOP","PARCEL_COUNT":5,"PICKUP_DAY":"2021-05-18","PARCEL_PICKEDUP_COUNT":null,"PICKUP_AGENT_ID":10,"ENTRY_SOURCE":"SELLER","FAILED_REASON":null,"REMARKS":null,"UPDATED_BY":null,"STATUS":"confirmed","LAST_STATUS_UPDATE_TIME":"2021-05-18T06:10:19.000Z","CONTACTED":0,"CREATED_AT":"2021-05-18T06:10:19.000Z","UPDATED_AT":"2021-05-18T06:10:19.000Z","SCANNED_PARCEL_COUNT":0,"UNSCANNED_PARCEL_COUNT":0,"SHOP_STORE_ID":64197,"MANUAL_PARCEL_COUNT":null,"SHOP_NAME":"Ram Shops","SHOP_PHONE":"01401122188","SHOP_CREATED_AT":"2021-02-08T06:32:03.000Z","PICKUP_PHONE":"8801401122188","PICKUP_ADDRESS":"Dhandamoni","AREA_ID":2,"AREA_NAME":"Dhanmondi","HUB_ID":1,"AGENT_ID":10,"AGENT_NAME":"ShopUp Test","SHOP_STORE_NAME":"Dhanmondi","SHOP_STORE_ADDRESS":"Dhandamoni"},{"ID":1854,"SHOP_ID":648299,"PR_CODE":null,"SOURCE_SELLER_ID":null,"REF_TYPE":"SHOP","PARCEL_COUNT":317,"PICKUP_DAY":"2021-05-09","PARCEL_PICKEDUP_COUNT":null,"PICKUP_AGENT_ID":10,"ENTRY_SOURCE":"PICKUP_PENDING_PARCEL","FAILED_REASON":null,"REMARKS":null,"UPDATED_BY":null,"STATUS":"confirmed","LAST_STATUS_UPDATE_TIME":"2021-05-09T03:25:13.000Z","CONTACTED":0,"CREATED_AT":"2021-05-09T03:25:13.000Z","UPDATED_AT":"2021-05-09T03:25:13.000Z","SCANNED_PARCEL_COUNT":0,"UNSCANNED_PARCEL_COUNT":0,"SHOP_STORE_ID":64285,"MANUAL_PARCEL_COUNT":null,"SHOP_NAME":"RedX Web Sanity Test Shop","SHOP_PHONE":"01401122188","SHOP_CREATED_AT":"2021-02-23T05:43:13.000Z","PICKUP_PHONE":"8801401122188","PICKUP_ADDRESS":"Dhanmondi","AREA_ID":2,"AREA_NAME":"Dhanmondi","HUB_ID":1,"AGENT_ID":10,"AGENT_NAME":"ShopUp Test","SHOP_STORE_NAME":"Dhanmondi","SHOP_STORE_ADDRESS":"Dhanmondi"},{"ID":1860,"SHOP_ID":648321,"PR_CODE":null,"SOURCE_SELLER_ID":null,"REF_TYPE":"SHOP","PARCEL_COUNT":2,"PICKUP_DAY":"2021-05-11","PARCEL_PICKEDUP_COUNT":2,"PICKUP_AGENT_ID":87,"ENTRY_SOURCE":"SELLER","FAILED_REASON":null,"REMARKS":null,"UPDATED_BY":92398,"STATUS":"picked-up","LAST_STATUS_UPDATE_TIME":"2021-05-11T13:40:21.000Z","CONTACTED":0,"CREATED_AT":"2021-05-11T13:39:52.000Z","UPDATED_AT":"2021-05-11T13:40:21.000Z","SCANNED_PARCEL_COUNT":0,"UNSCANNED_PARCEL_COUNT":0,"SHOP_STORE_ID":64308,"MANUAL_PARCEL_COUNT":null,"SHOP_NAME":"Shop name 17","SHOP_PHONE":"01401122188","SHOP_CREATED_AT":"2021-02-23T12:03:06.000Z","PICKUP_PHONE":"01401122188","PICKUP_ADDRESS":"dhanmondi","AREA_ID":2,"AREA_NAME":"Dhanmondi","HUB_ID":1,"AGENT_ID":87,"AGENT_NAME":"CX Pickup/Return Agent","SHOP_STORE_NAME":"Dhanmondi","SHOP_STORE_ADDRESS":"dhanmondi"},{"ID":1856,"SHOP_ID":648174,"PR_CODE":null,"SOURCE_SELLER_ID":null,"REF_TYPE":"SHOP","PARCEL_COUNT":10,"PICKUP_DAY":"2021-05-09","PARCEL_PICKEDUP_COUNT":null,"PICKUP_AGENT_ID":2807,"ENTRY_SOURCE":"PICKUP_PENDING_PARCEL","FAILED_REASON":null,"REMARKS":null,"UPDATED_BY":null,"STATUS":"confirmed","LAST_STATUS_UPDATE_TIME":"2021-05-09T03:25:13.000Z","CONTACTED":0,"CREATED_AT":"2021-05-09T03:25:13.000Z","UPDATED_AT":"2021-05-09T03:25:13.000Z","SCANNED_PARCEL_COUNT":0,"UNSCANNED_PARCEL_COUNT":0,"SHOP_STORE_ID":65613,"MANUAL_PARCEL_COUNT":null,"SHOP_NAME":"Devss","SHOP_PHONE":"8801701046356","SHOP_CREATED_AT":"2021-02-01T12:10:16.000Z","PICKUP_PHONE":"8801701046356","PICKUP_ADDRESS":"Green road","AREA_ID":104,"AREA_NAME":"Green Road","HUB_ID":1,"AGENT_ID":2807,"AGENT_NAME":"Rony","SHOP_STORE_NAME":"Devss Green Road","SHOP_STORE_ADDRESS":"Green road"},{"ID":1864,"SHOP_ID":649475,"PR_CODE":null,"SOURCE_SELLER_ID":null,"REF_TYPE":"SHOP","PARCEL_COUNT":2,"PICKUP_DAY":"2021-05-17","PARCEL_PICKEDUP_COUNT":null,"PICKUP_AGENT_ID":113,"ENTRY_SOURCE":"SELLER","FAILED_REASON":null,"REMARKS":null,"UPDATED_BY":473867,"STATUS":"confirmed","LAST_STATUS_UPDATE_TIME":"2021-05-17T10:43:47.000Z","CONTACTED":0,"CREATED_AT":"2021-05-17T10:43:47.000Z","UPDATED_AT":"2021-05-17T17:23:10.000Z","SCANNED_PARCEL_COUNT":0,"UNSCANNED_PARCEL_COUNT":0,"SHOP_STORE_ID":65673,"MANUAL_PARCEL_COUNT":null,"SHOP_NAME":"Multiple Pickup Test Shop","SHOP_PHONE":"8801401122188","SHOP_CREATED_AT":"2021-03-15T07:53:03.000Z","PICKUP_PHONE":"8801401122188","PICKUP_ADDRESS":"Kalabagan","AREA_ID":103,"AREA_NAME":"Kalabagan","HUB_ID":1,"AGENT_ID":113,"AGENT_NAME":"CX Pickup/Return Agent-1 (EDIT)","SHOP_STORE_NAME":"Kalabagan","SHOP_STORE_ADDRESS":"Kalabagan"}]
     * isError : false
     */

    private boolean isError;
    private List<ShopsBean> shops;

    public boolean isIsError() {
        return isError;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
    }

    public List<ShopsBean> getShops() {
        return shops;
    }

    public void setShops(List<ShopsBean> shops) {
        this.shops = shops;
    }

    public static class ShopsBean implements Serializable {
        /**
         * ID : 1846
         * SHOP_ID : 10
         * PR_CODE : null
         * SOURCE_SELLER_ID : null
         * REF_TYPE : SHOP
         * PARCEL_COUNT : 4
         * PICKUP_DAY : 2021-05-09
         * PARCEL_PICKEDUP_COUNT : null
         * PICKUP_AGENT_ID : 4847
         * ENTRY_SOURCE : PICKUP_PENDING_PARCEL
         * FAILED_REASON : null
         * REMARKS : null
         * UPDATED_BY : null
         * STATUS : confirmed
         * LAST_STATUS_UPDATE_TIME : 2021-05-09T03:25:13.000Z
         * CONTACTED : 0
         * CREATED_AT : 2021-05-09T03:25:13.000Z
         * UPDATED_AT : 2021-05-09T03:25:13.000Z
         * SCANNED_PARCEL_COUNT : 0
         * UNSCANNED_PARCEL_COUNT : 0
         * SHOP_STORE_ID : 2
         * MANUAL_PARCEL_COUNT : null
         * SHOP_NAME : Ice9 Apps Showcase
         * SHOP_PHONE : 01678600786
         * SHOP_CREATED_AT : 2015-12-24T06:10:56.000Z
         * PICKUP_PHONE : 8801678600786
         * PICKUP_ADDRESS : Dhanmondi
         * AREA_ID : 2
         * AREA_NAME : Dhanmondi
         * HUB_ID : 1
         * AGENT_ID : 4847
         * AGENT_NAME : Afsana Hossain
         * SHOP_STORE_NAME : Dhanmondi
         * SHOP_STORE_ADDRESS : Dhanmondi
         */

        private int ID;
        private int SHOP_ID;
        private Object PR_CODE;
        private Object SOURCE_SELLER_ID;
        private String REF_TYPE;
        private int PARCEL_COUNT;
        private String PICKUP_DAY;
        private Object PARCEL_PICKEDUP_COUNT;
        private int PICKUP_AGENT_ID;
        private String ENTRY_SOURCE;
        private Object FAILED_REASON;
        private Object REMARKS;
        private Object UPDATED_BY;
        private String STATUS;
        private String LAST_STATUS_UPDATE_TIME;
        private int CONTACTED;
        private String CREATED_AT;
        private String UPDATED_AT;
        private int SCANNED_PARCEL_COUNT;
        private int UNSCANNED_PARCEL_COUNT;
        private int SHOP_STORE_ID;
        private Object MANUAL_PARCEL_COUNT;
        private String SHOP_NAME;
        private String SHOP_PHONE;
        private String SHOP_CREATED_AT;
        private String PICKUP_PHONE;
        private String PICKUP_ADDRESS;
        private int AREA_ID;
        private String AREA_NAME;
        private int HUB_ID;
        private int AGENT_ID;
        private String AGENT_NAME;
        private String SHOP_STORE_NAME;
        private String SHOP_STORE_ADDRESS;

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public int getSHOP_ID() {
            return SHOP_ID;
        }

        public void setSHOP_ID(int SHOP_ID) {
            this.SHOP_ID = SHOP_ID;
        }

        public Object getPR_CODE() {
            return PR_CODE;
        }

        public void setPR_CODE(Object PR_CODE) {
            this.PR_CODE = PR_CODE;
        }

        public Object getSOURCE_SELLER_ID() {
            return SOURCE_SELLER_ID;
        }

        public void setSOURCE_SELLER_ID(Object SOURCE_SELLER_ID) {
            this.SOURCE_SELLER_ID = SOURCE_SELLER_ID;
        }

        public String getREF_TYPE() {
            return REF_TYPE;
        }

        public void setREF_TYPE(String REF_TYPE) {
            this.REF_TYPE = REF_TYPE;
        }

        public int getPARCEL_COUNT() {
            return PARCEL_COUNT;
        }

        public void setPARCEL_COUNT(int PARCEL_COUNT) {
            this.PARCEL_COUNT = PARCEL_COUNT;
        }

        public String getPICKUP_DAY() {
            return PICKUP_DAY;
        }

        public void setPICKUP_DAY(String PICKUP_DAY) {
            this.PICKUP_DAY = PICKUP_DAY;
        }

        public Object getPARCEL_PICKEDUP_COUNT() {
            return PARCEL_PICKEDUP_COUNT;
        }

        public void setPARCEL_PICKEDUP_COUNT(Object PARCEL_PICKEDUP_COUNT) {
            this.PARCEL_PICKEDUP_COUNT = PARCEL_PICKEDUP_COUNT;
        }

        public int getPICKUP_AGENT_ID() {
            return PICKUP_AGENT_ID;
        }

        public void setPICKUP_AGENT_ID(int PICKUP_AGENT_ID) {
            this.PICKUP_AGENT_ID = PICKUP_AGENT_ID;
        }

        public String getENTRY_SOURCE() {
            return ENTRY_SOURCE;
        }

        public void setENTRY_SOURCE(String ENTRY_SOURCE) {
            this.ENTRY_SOURCE = ENTRY_SOURCE;
        }

        public Object getFAILED_REASON() {
            return FAILED_REASON;
        }

        public void setFAILED_REASON(Object FAILED_REASON) {
            this.FAILED_REASON = FAILED_REASON;
        }

        public Object getREMARKS() {
            return REMARKS;
        }

        public void setREMARKS(Object REMARKS) {
            this.REMARKS = REMARKS;
        }

        public Object getUPDATED_BY() {
            return UPDATED_BY;
        }

        public void setUPDATED_BY(Object UPDATED_BY) {
            this.UPDATED_BY = UPDATED_BY;
        }

        public String getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(String STATUS) {
            this.STATUS = STATUS;
        }

        public String getLAST_STATUS_UPDATE_TIME() {
            return LAST_STATUS_UPDATE_TIME;
        }

        public void setLAST_STATUS_UPDATE_TIME(String LAST_STATUS_UPDATE_TIME) {
            this.LAST_STATUS_UPDATE_TIME = LAST_STATUS_UPDATE_TIME;
        }

        public int getCONTACTED() {
            return CONTACTED;
        }

        public void setCONTACTED(int CONTACTED) {
            this.CONTACTED = CONTACTED;
        }

        public String getCREATED_AT() {
            System.out.println("Value in API : " + CREATED_AT);
            CREATED_AT = CREATED_AT.replace(".000Z"," +0000");
            SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss Z");
            SimpleDateFormat formatter2=new SimpleDateFormat("MMM dd, yyyy hh:mm a");
            try {
                Date date = formatter1.parse(CREATED_AT);
                CREATED_AT = formatter2.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return CREATED_AT;
        }

        public void setCREATED_AT(String CREATED_AT) {
            this.CREATED_AT = CREATED_AT;
        }

        public String getUPDATED_AT() {
            return UPDATED_AT;
        }

        public void setUPDATED_AT(String UPDATED_AT) {
            this.UPDATED_AT = UPDATED_AT;
        }

        public int getSCANNED_PARCEL_COUNT() {
            return SCANNED_PARCEL_COUNT;
        }

        public void setSCANNED_PARCEL_COUNT(int SCANNED_PARCEL_COUNT) {
            this.SCANNED_PARCEL_COUNT = SCANNED_PARCEL_COUNT;
        }

        public int getUNSCANNED_PARCEL_COUNT() {
            return UNSCANNED_PARCEL_COUNT;
        }

        public void setUNSCANNED_PARCEL_COUNT(int UNSCANNED_PARCEL_COUNT) {
            this.UNSCANNED_PARCEL_COUNT = UNSCANNED_PARCEL_COUNT;
        }

        public int getSHOP_STORE_ID() {
            return SHOP_STORE_ID;
        }

        public void setSHOP_STORE_ID(int SHOP_STORE_ID) {
            this.SHOP_STORE_ID = SHOP_STORE_ID;
        }

        public Object getMANUAL_PARCEL_COUNT() {
            return MANUAL_PARCEL_COUNT;
        }

        public void setMANUAL_PARCEL_COUNT(Object MANUAL_PARCEL_COUNT) {
            this.MANUAL_PARCEL_COUNT = MANUAL_PARCEL_COUNT;
        }

        public String getSHOP_NAME() {
            return SHOP_NAME;
        }

        public void setSHOP_NAME(String SHOP_NAME) {
            this.SHOP_NAME = SHOP_NAME;
        }

        public String getSHOP_PHONE() {
            return SHOP_PHONE;
        }

        public void setSHOP_PHONE(String SHOP_PHONE) {
            this.SHOP_PHONE = SHOP_PHONE;
        }

        public String getSHOP_CREATED_AT() {
            return SHOP_CREATED_AT;
        }

        public void setSHOP_CREATED_AT(String SHOP_CREATED_AT) {
            this.SHOP_CREATED_AT = SHOP_CREATED_AT;
        }

        public String getPICKUP_PHONE() {
            return PICKUP_PHONE;
        }

        public void setPICKUP_PHONE(String PICKUP_PHONE) {
            this.PICKUP_PHONE = PICKUP_PHONE;
        }

        public String getPICKUP_ADDRESS() {
            return PICKUP_ADDRESS;
        }

        public void setPICKUP_ADDRESS(String PICKUP_ADDRESS) {
            this.PICKUP_ADDRESS = PICKUP_ADDRESS;
        }

        public int getAREA_ID() {
            return AREA_ID;
        }

        public void setAREA_ID(int AREA_ID) {
            this.AREA_ID = AREA_ID;
        }

        public String getAREA_NAME() {
            return AREA_NAME;
        }

        public void setAREA_NAME(String AREA_NAME) {
            this.AREA_NAME = AREA_NAME;
        }

        public int getHUB_ID() {
            return HUB_ID;
        }

        public void setHUB_ID(int HUB_ID) {
            this.HUB_ID = HUB_ID;
        }

        public int getAGENT_ID() {
            return AGENT_ID;
        }

        public void setAGENT_ID(int AGENT_ID) {
            this.AGENT_ID = AGENT_ID;
        }

        public String getAGENT_NAME() {
            return AGENT_NAME;
        }

        public void setAGENT_NAME(String AGENT_NAME) {
            this.AGENT_NAME = AGENT_NAME;
        }

        public String getSHOP_STORE_NAME() {
            return SHOP_STORE_NAME;
        }

        public void setSHOP_STORE_NAME(String SHOP_STORE_NAME) {
            this.SHOP_STORE_NAME = SHOP_STORE_NAME;
        }

        public String getSHOP_STORE_ADDRESS() {
            return SHOP_STORE_ADDRESS;
        }

        public void setSHOP_STORE_ADDRESS(String SHOP_STORE_ADDRESS) {
            this.SHOP_STORE_ADDRESS = SHOP_STORE_ADDRESS;
        }
    }
}