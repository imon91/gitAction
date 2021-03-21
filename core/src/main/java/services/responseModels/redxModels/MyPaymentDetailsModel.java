package services.responseModels.redxModels;

import java.io.Serializable;

public class MyPaymentDetailsModel {

    /**
     * isError : false
     * payment : {"ID":455269,"SHOP_ID":648222,"BKASH_NUMBER":"01401122188","ACCOUNT_NAME":"Name","BANK_NAME":"AB BANK LTD.","BANK_ID":3,"BRANCH_NAME":"DHANMONDI","BRANCH_ID":1126,"ACCOUNT_NUMBER":"1","ROUTING_NUMBER":"020261182","ACCOUNT_TYPE":"Saving","PAYMENT_METHOD":"Bkash","DISBURSEMENT_BANK":"City Bank","DISBURSEMENT_TYPE":"BFTN","CREATED_AT":"2021-02-08T06:33:10.000Z","UPDATED_AT":"2021-03-18T10:24:57.000Z"}
     */

    private boolean isError;
    private PaymentBean payment;

    public boolean isIsError() {
        return isError;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
    }

    public PaymentBean getPayment() {
        return payment;
    }

    public void setPayment(PaymentBean payment) {
        this.payment = payment;
    }

    public static class PaymentBean implements Serializable {
        /**
         * ID : 455269
         * SHOP_ID : 648222
         * BKASH_NUMBER : 01401122188
         * ACCOUNT_NAME : Name
         * BANK_NAME : AB BANK LTD.
         * BANK_ID : 3
         * BRANCH_NAME : DHANMONDI
         * BRANCH_ID : 1126
         * ACCOUNT_NUMBER : 1
         * ROUTING_NUMBER : 020261182
         * ACCOUNT_TYPE : Saving
         * PAYMENT_METHOD : Bkash
         * DISBURSEMENT_BANK : City Bank
         * DISBURSEMENT_TYPE : BFTN
         * CREATED_AT : 2021-02-08T06:33:10.000Z
         * UPDATED_AT : 2021-03-18T10:24:57.000Z
         */

        private int ID;
        private int SHOP_ID;
        private String BKASH_NUMBER;
        private String ACCOUNT_NAME;
        private String BANK_NAME;
        private int BANK_ID;
        private String BRANCH_NAME;
        private int BRANCH_ID;
        private String ACCOUNT_NUMBER;
        private String ROUTING_NUMBER;
        private String ACCOUNT_TYPE;
        private String PAYMENT_METHOD;
        private String DISBURSEMENT_BANK;
        private String DISBURSEMENT_TYPE;
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

        public String getBKASH_NUMBER() {
            return BKASH_NUMBER;
        }

        public void setBKASH_NUMBER(String BKASH_NUMBER) {
            this.BKASH_NUMBER = BKASH_NUMBER;
        }

        public String getACCOUNT_NAME() {
            return ACCOUNT_NAME;
        }

        public void setACCOUNT_NAME(String ACCOUNT_NAME) {
            this.ACCOUNT_NAME = ACCOUNT_NAME;
        }

        public String getBANK_NAME() {
            return BANK_NAME;
        }

        public void setBANK_NAME(String BANK_NAME) {
            this.BANK_NAME = BANK_NAME;
        }

        public int getBANK_ID() {
            return BANK_ID;
        }

        public void setBANK_ID(int BANK_ID) {
            this.BANK_ID = BANK_ID;
        }

        public String getBRANCH_NAME() {
            return BRANCH_NAME;
        }

        public void setBRANCH_NAME(String BRANCH_NAME) {
            this.BRANCH_NAME = BRANCH_NAME;
        }

        public int getBRANCH_ID() {
            return BRANCH_ID;
        }

        public void setBRANCH_ID(int BRANCH_ID) {
            this.BRANCH_ID = BRANCH_ID;
        }

        public String getACCOUNT_NUMBER() {
            return ACCOUNT_NUMBER;
        }

        public void setACCOUNT_NUMBER(String ACCOUNT_NUMBER) {
            this.ACCOUNT_NUMBER = ACCOUNT_NUMBER;
        }

        public String getROUTING_NUMBER() {
            return ROUTING_NUMBER;
        }

        public void setROUTING_NUMBER(String ROUTING_NUMBER) {
            this.ROUTING_NUMBER = ROUTING_NUMBER;
        }

        public String getACCOUNT_TYPE() {
            return ACCOUNT_TYPE;
        }

        public void setACCOUNT_TYPE(String ACCOUNT_TYPE) {
            this.ACCOUNT_TYPE = ACCOUNT_TYPE;
        }

        public String getPAYMENT_METHOD() {
            return PAYMENT_METHOD;
        }

        public void setPAYMENT_METHOD(String PAYMENT_METHOD) {
            this.PAYMENT_METHOD = PAYMENT_METHOD;
        }

        public String getDISBURSEMENT_BANK() {
            return DISBURSEMENT_BANK;
        }

        public void setDISBURSEMENT_BANK(String DISBURSEMENT_BANK) {
            this.DISBURSEMENT_BANK = DISBURSEMENT_BANK;
        }

        public String getDISBURSEMENT_TYPE() {
            return DISBURSEMENT_TYPE;
        }

        public void setDISBURSEMENT_TYPE(String DISBURSEMENT_TYPE) {
            this.DISBURSEMENT_TYPE = DISBURSEMENT_TYPE;
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
