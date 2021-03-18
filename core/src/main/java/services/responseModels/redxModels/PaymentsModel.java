package services.responseModels.redxModels;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PaymentsModel {


    /**
     * isError : false
     * body : {"payments":[{"LOGISTICS_INVOICE_ID":611158,"COMBINED_INVOICE_ID":618614,"PARCEL_COUNT":2,"AMOUNT":120.00036,"TOTAL_SHOPUP_CHARGE":120,"TOTAL_RETURN_CHARGE":0,"TOTAL_COD_CHARGE":0,"CREDITS_USED":0,"TOTAL_PROMO_CODE_DISCOUNT":36,"TOTAL_CASH_COLLECTED":0,"CREATED_AT":"2021-03-04T06:34:05.000Z","LOAN_COLLECTIONS":0,"IS_PAID":1,"PAID_AT":"2021-03-04T09:27:34.000Z"},{"LOGISTICS_INVOICE_ID":610974,"COMBINED_INVOICE_ID":618430,"PARCEL_COUNT":50,"AMOUNT":0,"TOTAL_SHOPUP_CHARGE":3000,"TOTAL_RETURN_CHARGE":0,"TOTAL_COD_CHARGE":0,"CREDITS_USED":0,"TOTAL_PROMO_CODE_DISCOUNT":0,"TOTAL_CASH_COLLECTED":0,"CREATED_AT":"2021-03-01T08:42:12.000Z","LOAN_COLLECTIONS":0,"IS_PAID":1,"PAID_AT":"2021-03-01T08:42:30.000Z"}],"totalPayments":2}
     */

    private boolean isError;
    private BodyBean body;

    public boolean isIsError() {
        return isError;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class BodyBean implements Serializable {
        /**
         * payments : [{"LOGISTICS_INVOICE_ID":611158,"COMBINED_INVOICE_ID":618614,"PARCEL_COUNT":2,"AMOUNT":120.00036,"TOTAL_SHOPUP_CHARGE":120,"TOTAL_RETURN_CHARGE":0,"TOTAL_COD_CHARGE":0,"CREDITS_USED":0,"TOTAL_PROMO_CODE_DISCOUNT":36,"TOTAL_CASH_COLLECTED":0,"CREATED_AT":"2021-03-04T06:34:05.000Z","LOAN_COLLECTIONS":0,"IS_PAID":1,"PAID_AT":"2021-03-04T09:27:34.000Z"},{"LOGISTICS_INVOICE_ID":610974,"COMBINED_INVOICE_ID":618430,"PARCEL_COUNT":50,"AMOUNT":0,"TOTAL_SHOPUP_CHARGE":3000,"TOTAL_RETURN_CHARGE":0,"TOTAL_COD_CHARGE":0,"CREDITS_USED":0,"TOTAL_PROMO_CODE_DISCOUNT":0,"TOTAL_CASH_COLLECTED":0,"CREATED_AT":"2021-03-01T08:42:12.000Z","LOAN_COLLECTIONS":0,"IS_PAID":1,"PAID_AT":"2021-03-01T08:42:30.000Z"}]
         * totalPayments : 2
         */

        private int totalPayments;
        private List<PaymentsBean> payments;

        public int getTotalPayments() {
            return totalPayments;
        }

        public void setTotalPayments(int totalPayments) {
            this.totalPayments = totalPayments;
        }

        public List<PaymentsBean> getPayments() {
            return payments;
        }

        public void setPayments(List<PaymentsBean> payments) {
            this.payments = payments;
        }

        public static class PaymentsBean implements Serializable {
            /**
             * LOGISTICS_INVOICE_ID : 611158
             * COMBINED_INVOICE_ID : 618614
             * PARCEL_COUNT : 2
             * AMOUNT : 120.00036
             * TOTAL_SHOPUP_CHARGE : 120
             * TOTAL_RETURN_CHARGE : 0
             * TOTAL_COD_CHARGE : 0
             * CREDITS_USED : 0
             * TOTAL_PROMO_CODE_DISCOUNT : 36
             * TOTAL_CASH_COLLECTED : 0
             * CREATED_AT : 2021-03-04T06:34:05.000Z
             * LOAN_COLLECTIONS : 0
             * IS_PAID : 1
             * PAID_AT : 2021-03-04T09:27:34.000Z
             */

            private int LOGISTICS_INVOICE_ID;
            private int COMBINED_INVOICE_ID;
            private int PARCEL_COUNT;
            private double AMOUNT;
            private int TOTAL_SHOPUP_CHARGE;
            private int TOTAL_RETURN_CHARGE;
            private int TOTAL_COD_CHARGE;
            private int CREDITS_USED;
            private int TOTAL_PROMO_CODE_DISCOUNT;
            private int TOTAL_CASH_COLLECTED;
            private String CREATED_AT;
            private int LOAN_COLLECTIONS;
            private int IS_PAID;
            private String PAID_AT;

            public int getLOGISTICS_INVOICE_ID() {
                return LOGISTICS_INVOICE_ID;
            }

            public void setLOGISTICS_INVOICE_ID(int LOGISTICS_INVOICE_ID) {
                this.LOGISTICS_INVOICE_ID = LOGISTICS_INVOICE_ID;
            }

            public int getCOMBINED_INVOICE_ID() {
                return COMBINED_INVOICE_ID;
            }

            public void setCOMBINED_INVOICE_ID(int COMBINED_INVOICE_ID) {
                this.COMBINED_INVOICE_ID = COMBINED_INVOICE_ID;
            }

            public int getPARCEL_COUNT() {
                return PARCEL_COUNT;
            }

            public void setPARCEL_COUNT(int PARCEL_COUNT) {
                this.PARCEL_COUNT = PARCEL_COUNT;
            }

            public double getAMOUNT() {
                return AMOUNT;
            }

            public void setAMOUNT(double AMOUNT) {
                this.AMOUNT = AMOUNT;
            }

            public int getTOTAL_SHOPUP_CHARGE() {
                return TOTAL_SHOPUP_CHARGE;
            }

            public void setTOTAL_SHOPUP_CHARGE(int TOTAL_SHOPUP_CHARGE) {
                this.TOTAL_SHOPUP_CHARGE = TOTAL_SHOPUP_CHARGE;
            }

            public int getTOTAL_RETURN_CHARGE() {
                return TOTAL_RETURN_CHARGE;
            }

            public void setTOTAL_RETURN_CHARGE(int TOTAL_RETURN_CHARGE) {
                this.TOTAL_RETURN_CHARGE = TOTAL_RETURN_CHARGE;
            }

            public int getTOTAL_COD_CHARGE() {
                return TOTAL_COD_CHARGE;
            }

            public void setTOTAL_COD_CHARGE(int TOTAL_COD_CHARGE) {
                this.TOTAL_COD_CHARGE = TOTAL_COD_CHARGE;
            }

            public int getCREDITS_USED() {
                return CREDITS_USED;
            }

            public void setCREDITS_USED(int CREDITS_USED) {
                this.CREDITS_USED = CREDITS_USED;
            }

            public int getTOTAL_PROMO_CODE_DISCOUNT() {
                return TOTAL_PROMO_CODE_DISCOUNT;
            }

            public void setTOTAL_PROMO_CODE_DISCOUNT(int TOTAL_PROMO_CODE_DISCOUNT) {
                this.TOTAL_PROMO_CODE_DISCOUNT = TOTAL_PROMO_CODE_DISCOUNT;
            }

            public int getTOTAL_CASH_COLLECTED() {
                return TOTAL_CASH_COLLECTED;
            }

            public void setTOTAL_CASH_COLLECTED(int TOTAL_CASH_COLLECTED) {
                this.TOTAL_CASH_COLLECTED = TOTAL_CASH_COLLECTED;
            }

            public String getCREATED_AT() {
                System.out.println("Value in API : " + CREATED_AT);
                CREATED_AT = CREATED_AT.replace(".000Z"," +0000");
                SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss Z");
                SimpleDateFormat formatter2=new SimpleDateFormat("MMM dd, yyyy");
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

            public int getLOAN_COLLECTIONS() {
                return LOAN_COLLECTIONS;
            }

            public void setLOAN_COLLECTIONS(int LOAN_COLLECTIONS) {
                this.LOAN_COLLECTIONS = LOAN_COLLECTIONS;
            }

            public int getIS_PAID() {
                return IS_PAID;
            }

            public void setIS_PAID(int IS_PAID) {
                this.IS_PAID = IS_PAID;
            }

            public String getPAID_AT() {
                return PAID_AT;
            }

            public void setPAID_AT(String PAID_AT) {
                this.PAID_AT = PAID_AT;
            }
        }
    }
}
