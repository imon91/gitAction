package services;

import java.io.Serializable;
import java.util.List;

public class ImportParcelsShopSelectModel {

    private List<ParcelsBean> parcels;

    public List<ParcelsBean> getParcels() {
        return parcels;
    }

    public void setParcels(List<ParcelsBean> parcels) {
        this.parcels = parcels;
    }

    public static class ParcelsBean implements Serializable {
        /**
         * INVOICE_NUMBER : 123456
         * CUSTOMER_NAME : PostMan_Test
         * CUSTOMER_PHONE : 8801873445555
         * DELIVERY_ADDRESS : House name (Apt number), Road number
         * POST_CODE : 1208
         * CASH : 120
         * SELLER_INSTRUCTION : Comment regarding delivery
         * VALUE : 0
         * WEIGHT : 500
         * AREA_ID : 98
         * AREA : Tejgaon
         * SHOP_ID : 532439
         * SHOP_NAME : SHOPUP_TEST
         * PICKUP_ADDRESS : Dhanmondi
         * PAYMENT_METHOD : cash on delivery
         * SOURCE_PANEL : SAP bulk upload panel
         * REMARKS : null
         */

        private String INVOICE_NUMBER;
        private String CUSTOMER_NAME;
        private String CUSTOMER_PHONE;
        private String DELIVERY_ADDRESS;
        private String POST_CODE;
        private String CASH;
        private String SELLER_INSTRUCTION;
        private String VALUE;
        private int WEIGHT;
        private int AREA_ID;
        private String AREA;
        private int SHOP_ID;
        private String SHOP_NAME;
        private String PICKUP_ADDRESS;
        private String PAYMENT_METHOD;
        private String SOURCE_PANEL;
        private Object REMARKS;

        public String getINVOICE_NUMBER() {
            return INVOICE_NUMBER;
        }

        public void setINVOICE_NUMBER(String INVOICE_NUMBER) {
            this.INVOICE_NUMBER = INVOICE_NUMBER;
        }

        public String getCUSTOMER_NAME() {
            return CUSTOMER_NAME;
        }

        public void setCUSTOMER_NAME(String CUSTOMER_NAME) {
            this.CUSTOMER_NAME = CUSTOMER_NAME;
        }

        public String getCUSTOMER_PHONE() {
            return CUSTOMER_PHONE;
        }

        public void setCUSTOMER_PHONE(String CUSTOMER_PHONE) {
            this.CUSTOMER_PHONE = CUSTOMER_PHONE;
        }

        public String getDELIVERY_ADDRESS() {
            return DELIVERY_ADDRESS;
        }

        public void setDELIVERY_ADDRESS(String DELIVERY_ADDRESS) {
            this.DELIVERY_ADDRESS = DELIVERY_ADDRESS;
        }

        public String getPOST_CODE() {
            return POST_CODE;
        }

        public void setPOST_CODE(String POST_CODE) {
            this.POST_CODE = POST_CODE;
        }

        public String getCASH() {
            return CASH;
        }

        public void setCASH(String CASH) {
            this.CASH = CASH;
        }

        public String getSELLER_INSTRUCTION() {
            return SELLER_INSTRUCTION;
        }

        public void setSELLER_INSTRUCTION(String SELLER_INSTRUCTION) {
            this.SELLER_INSTRUCTION = SELLER_INSTRUCTION;
        }

        public String getVALUE() {
            return VALUE;
        }

        public void setVALUE(String VALUE) {
            this.VALUE = VALUE;
        }

        public int getWEIGHT() {
            return WEIGHT;
        }

        public void setWEIGHT(int WEIGHT) {
            this.WEIGHT = WEIGHT;
        }

        public int getAREA_ID() {
            return AREA_ID;
        }

        public void setAREA_ID(int AREA_ID) {
            this.AREA_ID = AREA_ID;
        }

        public String getAREA() {
            return AREA;
        }

        public void setAREA(String AREA) {
            this.AREA = AREA;
        }

        public int getSHOP_ID() {
            return SHOP_ID;
        }

        public void setSHOP_ID(int SHOP_ID) {
            this.SHOP_ID = SHOP_ID;
        }

        public String getSHOP_NAME() {
            return SHOP_NAME;
        }

        public void setSHOP_NAME(String SHOP_NAME) {
            this.SHOP_NAME = SHOP_NAME;
        }

        public String getPICKUP_ADDRESS() {
            return PICKUP_ADDRESS;
        }

        public void setPICKUP_ADDRESS(String PICKUP_ADDRESS) {
            this.PICKUP_ADDRESS = PICKUP_ADDRESS;
        }

        public String getPAYMENT_METHOD() {
            return PAYMENT_METHOD;
        }

        public void setPAYMENT_METHOD(String PAYMENT_METHOD) {
            this.PAYMENT_METHOD = PAYMENT_METHOD;
        }

        public String getSOURCE_PANEL() {
            return SOURCE_PANEL;
        }

        public void setSOURCE_PANEL(String SOURCE_PANEL) {
            this.SOURCE_PANEL = SOURCE_PANEL;
        }

        public Object getREMARKS() {
            return REMARKS;
        }

        public void setREMARKS(Object REMARKS) {
            this.REMARKS = REMARKS;
        }
    }
}
