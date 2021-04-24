package services.responseModels.redxModels;

import java.io.Serializable;
import java.util.List;

public class PickupListModel {

    /**
     * isError : false
     * body : [{"ID":64285,"SHOP_ID":648299,"NAME":"Dhanmondi","ADDRESS":"Dhanmondi","AREA_NAME":"Dhanmondi","AREA_ID":2,"PHONE":"8801401122188","STATUS":"active","IS_PICKUP_ENABLED":1,"IS_RETURN_ENABLED":1,"IS_DEFAULT_RETURN_STORE":0,"CREATED_AT":"2021-02-23T05:43:13.000Z","UPDATED_AT":"2021-02-25T09:19:14.000Z"},{"ID":64286,"SHOP_ID":648299,"NAME":"CWH","ADDRESS":"CWH","AREA_NAME":"CWH","AREA_ID":448,"PHONE":"8801401122188","STATUS":"active","IS_PICKUP_ENABLED":1,"IS_RETURN_ENABLED":1,"IS_DEFAULT_RETURN_STORE":0,"CREATED_AT":"2021-02-23T05:43:55.000Z","UPDATED_AT":"2021-02-23T05:43:55.000Z"}]
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
         * ID : 64285
         * SHOP_ID : 648299
         * NAME : Dhanmondi
         * ADDRESS : Dhanmondi
         * AREA_NAME : Dhanmondi
         * AREA_ID : 2
         * PHONE : 8801401122188
         * STATUS : active
         * IS_PICKUP_ENABLED : 1
         * IS_RETURN_ENABLED : 1
         * IS_DEFAULT_RETURN_STORE : 0
         * CREATED_AT : 2021-02-23T05:43:13.000Z
         * UPDATED_AT : 2021-02-25T09:19:14.000Z
         */

        private int ID;
        private int SHOP_ID;
        private String NAME;
        private String ADDRESS;
        private String AREA_NAME;
        private int AREA_ID;
        private String PHONE;
        private String STATUS;
        private int IS_PICKUP_ENABLED;
        private int IS_RETURN_ENABLED;
        private int IS_DEFAULT_RETURN_STORE;
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

        public String getNAME() {
            return NAME;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }

        public String getADDRESS() {
            return ADDRESS;
        }

        public void setADDRESS(String ADDRESS) {
            this.ADDRESS = ADDRESS;
        }

        public String getAREA_NAME() {
            return AREA_NAME;
        }

        public void setAREA_NAME(String AREA_NAME) {
            this.AREA_NAME = AREA_NAME;
        }

        public int getAREA_ID() {
            return AREA_ID;
        }

        public void setAREA_ID(int AREA_ID) {
            this.AREA_ID = AREA_ID;
        }

        public String getPHONE() {
            return PHONE;
        }

        public void setPHONE(String PHONE) {
            this.PHONE = PHONE;
        }

        public String getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(String STATUS) {
            this.STATUS = STATUS;
        }

        public int getIS_PICKUP_ENABLED() {
            return IS_PICKUP_ENABLED;
        }

        public void setIS_PICKUP_ENABLED(int IS_PICKUP_ENABLED) {
            this.IS_PICKUP_ENABLED = IS_PICKUP_ENABLED;
        }

        public int getIS_RETURN_ENABLED() {
            return IS_RETURN_ENABLED;
        }

        public void setIS_RETURN_ENABLED(int IS_RETURN_ENABLED) {
            this.IS_RETURN_ENABLED = IS_RETURN_ENABLED;
        }

        public int getIS_DEFAULT_RETURN_STORE() {
            return IS_DEFAULT_RETURN_STORE;
        }

        public void setIS_DEFAULT_RETURN_STORE(int IS_DEFAULT_RETURN_STORE) {
            this.IS_DEFAULT_RETURN_STORE = IS_DEFAULT_RETURN_STORE;
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
