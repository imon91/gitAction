package services;

import java.io.Serializable;
import java.util.List;

public class BulkCreateParcelLogModel {

    /**
     * isError : false
     * body : [{"ID":909361,"SHOP_ID":532439,"BULK_ID":"kkkqzioy","UID":"3c52ec99-0288-4fe9-8c3e-ece78d7fde74","PARCEL_DETAILS_JSON":"{\"INVOICE_NUMBER\":\"123457\",\"CUSTOMER_NAME\":\"PostMan_Test1\",\"CUSTOMER_PHONE\":\"8801873445555\",\"DELIVERY_ADDRESS\":\"House name (Apt number), Road number \",\"POST_CODE\":\"1208\",\"CASH\":\"120\",\"SELLER_INSTRUCTION\":\"Comment regarding delivery\",\"VALUE\":\"0\",\"WEIGHT\":500,\"AREA_ID\":98,\"AREA\":\"Tejgaon\",\"SHOP_ID\":532439,\"SHOP_NAME\":\"SHOPUP_TEST\",\"PICKUP_ADDRESS\":\"Dhanmondi\",\"PAYMENT_METHOD\":\"cash on delivery\",\"SOURCE_PANEL\":\"SAP bulk upload panel\",\"REMARKS\":null,\"SHOP_PHONE\":\"8801401122188\",\"PARCEL_TYPE\":\"regular\"}","STATUS":"success","REASON":null,"CREATED_AT":"2021-01-31T06:12:59.000Z","UPDATED_AT":"2021-01-31T06:13:01.000Z"},{"ID":909360,"SHOP_ID":532439,"BULK_ID":"kkkqzioy","UID":"b6931d87-3d3e-44c9-9032-b63bbe544d79","PARCEL_DETAILS_JSON":"{\"INVOICE_NUMBER\":\"123456\",\"CUSTOMER_NAME\":\"PostMan_Test\",\"CUSTOMER_PHONE\":\"8801873445555\",\"DELIVERY_ADDRESS\":\"House name (Apt number), Road number \",\"POST_CODE\":\"1208\",\"CASH\":\"120\",\"SELLER_INSTRUCTION\":\"Comment regarding delivery\",\"VALUE\":\"0\",\"WEIGHT\":500,\"AREA_ID\":98,\"AREA\":\"Tejgaon\",\"SHOP_ID\":532439,\"SHOP_NAME\":\"SHOPUP_TEST\",\"PICKUP_ADDRESS\":\"Dhanmondi\",\"PAYMENT_METHOD\":\"cash on delivery\",\"SOURCE_PANEL\":\"SAP bulk upload panel\",\"REMARKS\":null,\"SHOP_PHONE\":\"8801401122188\",\"PARCEL_TYPE\":\"regular\"}","STATUS":"success","REASON":null,"CREATED_AT":"2021-01-31T06:12:59.000Z","UPDATED_AT":"2021-01-31T06:13:01.000Z"}]
     */

    private boolean isError;
    private List<BodyBean> body;

    public boolean isIsError() {
        return isError;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
    }

    public List<BodyBean> getBody() {
        return body;
    }

    public void setBody(List<BodyBean> body) {
        this.body = body;
    }

    public static class BodyBean implements Serializable {
        /**
         * ID : 909361
         * SHOP_ID : 532439
         * BULK_ID : kkkqzioy
         * UID : 3c52ec99-0288-4fe9-8c3e-ece78d7fde74
         * PARCEL_DETAILS_JSON : {"INVOICE_NUMBER":"123457","CUSTOMER_NAME":"PostMan_Test1","CUSTOMER_PHONE":"8801873445555","DELIVERY_ADDRESS":"House name (Apt number), Road number ","POST_CODE":"1208","CASH":"120","SELLER_INSTRUCTION":"Comment regarding delivery","VALUE":"0","WEIGHT":500,"AREA_ID":98,"AREA":"Tejgaon","SHOP_ID":532439,"SHOP_NAME":"SHOPUP_TEST","PICKUP_ADDRESS":"Dhanmondi","PAYMENT_METHOD":"cash on delivery","SOURCE_PANEL":"SAP bulk upload panel","REMARKS":null,"SHOP_PHONE":"8801401122188","PARCEL_TYPE":"regular"}
         * STATUS : success
         * REASON : null
         * CREATED_AT : 2021-01-31T06:12:59.000Z
         * UPDATED_AT : 2021-01-31T06:13:01.000Z
         */

        private int ID;
        private int SHOP_ID;
        private String BULK_ID;
        private String UID;
        private String PARCEL_DETAILS_JSON;
        private String STATUS;
        private Object REASON;
        private String CREATED_AT;
        private String UPDATED_AT;

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

        public String getBULK_ID() {
            return BULK_ID;
        }

        public void setBULK_ID(String BULK_ID) {
            this.BULK_ID = BULK_ID;
        }

        public String getUID() {
            return UID;
        }

        public void setUID(String UID) {
            this.UID = UID;
        }

        public String getPARCEL_DETAILS_JSON() {
            return PARCEL_DETAILS_JSON;
        }

        public void setPARCEL_DETAILS_JSON(String PARCEL_DETAILS_JSON) {
            this.PARCEL_DETAILS_JSON = PARCEL_DETAILS_JSON;
        }

        public String getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(String STATUS) {
            this.STATUS = STATUS;
        }

        public Object getREASON() {
            return REASON;
        }

        public void setREASON(Object REASON) {
            this.REASON = REASON;
        }

        public String getCREATED_AT() {
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
    }
}
