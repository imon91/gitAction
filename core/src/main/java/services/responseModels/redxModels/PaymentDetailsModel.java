package services.responseModels.redxModels;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PaymentDetailsModel {

    /**
     * isError : false
     * parcels : [{"CASH":120,"INVOICE_NUMBER":"CBP123456","CUSTOMER_NAME":"Create Bulk Parcel - 01","CUSTOMER_PHONE":"8801401122188","AREA":"Adabor","WEIGHT":500,"SELLER_STATUS":"delivered","CREATED_AT":"2021-03-02T05:40:31.000Z","SHOPUP_CHARGE":60,"SHOPUP_COD_CHARGE":0,"SHOPUP_RETURN_CHARGE":0,"STATUS":"cash-received","TRACKING_ID":"21A3A2TU3K7KZ","promoCodeDiscountAmount":0,"PAYABLE_AMOUNT":"60.00"},{"CASH":120,"INVOICE_NUMBER":"CBP123456","CUSTOMER_NAME":"Create Bulk Parcel - 01","CUSTOMER_PHONE":"8801401122188","AREA":"Adabor","WEIGHT":500,"SELLER_STATUS":"delivered","CREATED_AT":"2021-03-03T09:35:06.000Z","SHOPUP_CHARGE":60,"SHOPUP_COD_CHARGE":0,"SHOPUP_RETURN_CHARGE":0,"STATUS":"cash-received","TRACKING_ID":"21A3A3WE3K7RS","promoCodeDiscountAmount":36,"PAYABLE_AMOUNT":"96.00"}]
     */

    private boolean isError;
    private List<ParcelsBean> parcels;

    public boolean isIsError() {
        return isError;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
    }

    public List<ParcelsBean> getParcels() {
        return parcels;
    }

    public void setParcels(List<ParcelsBean> parcels) {
        this.parcels = parcels;
    }

    public float getTotalPaidValue()
    {
        float totalPaidValue = 0;
        for(int i=0;i<getParcels().size();i++)
        {
            totalPaidValue = totalPaidValue + Float.parseFloat(getParcels().get(i).getPAYABLE_AMOUNT());
        }
        return totalPaidValue;
    }

    public static class ParcelsBean implements Serializable {
        /**
         * CASH : 120
         * INVOICE_NUMBER : CBP123456
         * CUSTOMER_NAME : Create Bulk Parcel - 01
         * CUSTOMER_PHONE : 8801401122188
         * AREA : Adabor
         * WEIGHT : 500
         * SELLER_STATUS : delivered
         * CREATED_AT : 2021-03-02T05:40:31.000Z
         * SHOPUP_CHARGE : 60
         * SHOPUP_COD_CHARGE : 0
         * SHOPUP_RETURN_CHARGE : 0
         * STATUS : cash-received
         * TRACKING_ID : 21A3A2TU3K7KZ
         * promoCodeDiscountAmount : 0
         * PAYABLE_AMOUNT : 60.00
         */

        private int CASH;
        private String INVOICE_NUMBER;
        private String CUSTOMER_NAME;
        private String CUSTOMER_PHONE;
        private String AREA;
        private int WEIGHT;
        private String SELLER_STATUS;
        private String CREATED_AT;
        private int SHOPUP_CHARGE;
        private int SHOPUP_COD_CHARGE;
        private int SHOPUP_RETURN_CHARGE;
        private String STATUS;
        private String TRACKING_ID;
        private int promoCodeDiscountAmount;
        private String PAYABLE_AMOUNT;

        public int getCASH() {
            return CASH;
        }

        public void setCASH(int CASH) {
            this.CASH = CASH;
        }

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

        public String getAREA() {
            return AREA;
        }

        public void setAREA(String AREA) {
            this.AREA = AREA;
        }

        public int getWEIGHT() {
            return WEIGHT;
        }

        public void setWEIGHT(int WEIGHT) {
            this.WEIGHT = WEIGHT;
        }

        public String getSELLER_STATUS() {
            return SELLER_STATUS;
        }

        public void setSELLER_STATUS(String SELLER_STATUS) {
            this.SELLER_STATUS = SELLER_STATUS;
        }

        public String getCREATED_AT() {
            System.out.println("Value in API : " + CREATED_AT);
            CREATED_AT = CREATED_AT.replace(".000Z"," +0000");
            SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss Z");
            SimpleDateFormat formatter2=new SimpleDateFormat("MM/dd/yyyy");
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

        public int getSHOPUP_CHARGE() {
            return SHOPUP_CHARGE;
        }

        public void setSHOPUP_CHARGE(int SHOPUP_CHARGE) {
            this.SHOPUP_CHARGE = SHOPUP_CHARGE;
        }

        public int getSHOPUP_COD_CHARGE() {
            return SHOPUP_COD_CHARGE;
        }

        public void setSHOPUP_COD_CHARGE(int SHOPUP_COD_CHARGE) {
            this.SHOPUP_COD_CHARGE = SHOPUP_COD_CHARGE;
        }

        public int getSHOPUP_RETURN_CHARGE() {
            return SHOPUP_RETURN_CHARGE;
        }

        public void setSHOPUP_RETURN_CHARGE(int SHOPUP_RETURN_CHARGE) {
            this.SHOPUP_RETURN_CHARGE = SHOPUP_RETURN_CHARGE;
        }

        public String getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(String STATUS) {
            this.STATUS = STATUS;
        }

        public String getTRACKING_ID() {
            return TRACKING_ID;
        }

        public void setTRACKING_ID(String TRACKING_ID) {
            this.TRACKING_ID = TRACKING_ID;
        }

        public int getPromoCodeDiscountAmount() {
            return promoCodeDiscountAmount;
        }

        public void setPromoCodeDiscountAmount(int promoCodeDiscountAmount) {
            this.promoCodeDiscountAmount = promoCodeDiscountAmount;
        }

        public String getPAYABLE_AMOUNT() {
            return PAYABLE_AMOUNT;
        }

        public void setPAYABLE_AMOUNT(String PAYABLE_AMOUNT) {
            this.PAYABLE_AMOUNT = PAYABLE_AMOUNT;
        }
    }
}
