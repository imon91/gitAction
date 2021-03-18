package services.responseModels.redxModels;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TrackParcelModel {

    /**
     * isError : false
     * tracking : [{"messageEn":"Package is created successfully","messageBn":"পার্সেলটি সফল ভাবে প্লেস করা হয়েছে","status":"pickup-pending","groupedStatus":"pickup-pending","action":"pickup-pending","time":"2021-02-24T08:43:45.000Z"},{"messageEn":"Package is picked up","messageBn":"পার্সেল পিকাপ সম্পন্ন হয়েছে ","status":"ready-for-delivery","groupedStatus":"parcel_received","action":"received-from-seller","time":"2021-02-24T08:46:34.000Z"},{"messageEn":"Package is on the way to delivery by Abdul Alim - kalabagan(8801737199008)","messageBn":"ডেলিভারি এজেন্ট Abdul Alim - kalabagan(8801737199008) ডেলিভারির জন্যে বের হয়েছে","status":"delivery-in-progress","groupedStatus":"delivery_on_the_way","action":"dispatched-to-agent","time":"2021-02-24T08:48:30.000Z"},{"messageEn":"Package is being returned. Reason : কাস্টমার ভুলে অর্ডারটি করেছেন","messageBn":"পার্সেলটি রিটার্ন করা হচ্ছে । কারণ : কাস্টমার ভুলে অর্ডারটি করেছেন","status":"agent-returning","groupedStatus":"returning","action":"user-parcel-returning","time":"2021-02-24T12:41:13.000Z"},{"messageEn":"Package is delivered successfully","messageBn":"পার্সেল ডেলিভারি সম্পন্ন হয়েছে","status":"delivered","groupedStatus":"delivered","action":"user-delivered","time":"2021-03-01T08:36:24.000Z"},{"messageEn":"Payment is settled successfully","messageBn":"পার্সেলের লেনদেনটি সম্পূর্ণ হয়েছে ","status":"cash-received","groupedStatus":"cash-received","action":"cash-received","time":"2021-03-01T08:38:27.000Z"}]
     * parcel : {"CUSTOMER_NAME":"Delivery Parcel - 50","DELIVERY_ADDRESS":"House name (Apt number), Road number","CUSTOMER_PHONE":"8801401122188","AREA":"Adabor","WEIGHT":500,"CASH":0,"SHOPUP_CHARGE":60,"SHOPUP_COD_CHARGE":0,"SHOP_ID":648299,"SHOP_NAME":"RedX Web Sanity Test Shop","TRACKING_ID":"21A224WE3K6BL"}
     * payment : {"INVOICE_ID":610974,"PAYMENT_STATUS":"settled","SETTLEMENT_AMOUNT":0}
     */

    private boolean isError;
    private ParcelBean parcel;
    private PaymentBean payment;
    private List<TrackingBean> tracking;

    public boolean isIsError() {
        return isError;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
    }

    public ParcelBean getParcel() {
        return parcel;
    }

    public void setParcel(ParcelBean parcel) {
        this.parcel = parcel;
    }

    public PaymentBean getPayment() {
        return payment;
    }

    public void setPayment(PaymentBean payment) {
        this.payment = payment;
    }

    public List<TrackingBean> getTracking() {
        return tracking;
    }

    public void setTracking(List<TrackingBean> tracking) {
        this.tracking = tracking;
    }

    public static class ParcelBean implements Serializable {
        /**
         * CUSTOMER_NAME : Delivery Parcel - 50
         * DELIVERY_ADDRESS : House name (Apt number), Road number
         * CUSTOMER_PHONE : 8801401122188
         * AREA : Adabor
         * WEIGHT : 500
         * CASH : 0
         * SHOPUP_CHARGE : 60
         * SHOPUP_COD_CHARGE : 0
         * SHOP_ID : 648299
         * SHOP_NAME : RedX Web Sanity Test Shop
         * TRACKING_ID : 21A224WE3K6BL
         */

        private String CUSTOMER_NAME;
        private String DELIVERY_ADDRESS;
        private String CUSTOMER_PHONE;
        private String AREA;
        private int WEIGHT;
        private int CASH;
        private int SHOPUP_CHARGE;
        private int SHOPUP_COD_CHARGE;
        private int SHOP_ID;
        private String SHOP_NAME;
        private String TRACKING_ID;

        public String getCUSTOMER_NAME() {
            return CUSTOMER_NAME;
        }

        public void setCUSTOMER_NAME(String CUSTOMER_NAME) {
            this.CUSTOMER_NAME = CUSTOMER_NAME;
        }

        public String getDELIVERY_ADDRESS() {
            return DELIVERY_ADDRESS;
        }

        public void setDELIVERY_ADDRESS(String DELIVERY_ADDRESS) {
            this.DELIVERY_ADDRESS = DELIVERY_ADDRESS;
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

        public int getCASH() {
            return CASH;
        }

        public void setCASH(int CASH) {
            this.CASH = CASH;
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

        public String getTRACKING_ID() {
            return TRACKING_ID;
        }

        public void setTRACKING_ID(String TRACKING_ID) {
            this.TRACKING_ID = TRACKING_ID;
        }
    }

    public static class PaymentBean implements Serializable {
        /**
         * INVOICE_ID : 610974
         * PAYMENT_STATUS : settled
         * SETTLEMENT_AMOUNT : 0
         */

        private int INVOICE_ID;
        private String PAYMENT_STATUS;
        private int SETTLEMENT_AMOUNT;

        public int getINVOICE_ID() {
            return INVOICE_ID;
        }

        public void setINVOICE_ID(int INVOICE_ID) {
            this.INVOICE_ID = INVOICE_ID;
        }

        public String getPAYMENT_STATUS() {
            return PAYMENT_STATUS;
        }

        public void setPAYMENT_STATUS(String PAYMENT_STATUS) {
            this.PAYMENT_STATUS = PAYMENT_STATUS;
        }

        public int getSETTLEMENT_AMOUNT() {
            return SETTLEMENT_AMOUNT;
        }

        public void setSETTLEMENT_AMOUNT(int SETTLEMENT_AMOUNT) {
            this.SETTLEMENT_AMOUNT = SETTLEMENT_AMOUNT;
        }
    }

    public static class TrackingBean implements Serializable {
        /**
         * messageEn : Package is created successfully
         * messageBn : পার্সেলটি সফল ভাবে প্লেস করা হয়েছে
         * status : pickup-pending
         * groupedStatus : pickup-pending
         * action : pickup-pending
         * time : 2021-02-24T08:43:45.000Z
         */

        private String messageEn;
        private String messageBn;
        private String status;
        private String groupedStatus;
        private String action;
        private String time;

        public String getMessageEn() {
            return messageEn;
        }

        public void setMessageEn(String messageEn) {
            this.messageEn = messageEn;
        }

        public String getMessageBn() {
            return messageBn;
        }

        public void setMessageBn(String messageBn) {
            this.messageBn = messageBn;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getGroupedStatus() {
            return groupedStatus;
        }

        public void setGroupedStatus(String groupedStatus) {
            this.groupedStatus = groupedStatus;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getTime() {
            System.out.println("Date in API : " + time);
            time = time.replace(".000Z"," +0000");
            SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss Z");
            SimpleDateFormat formatter2;
            try {
                Date date = formatter1.parse(time);
                int dateValue = date.getDate();
                if(((dateValue>10) && (dateValue<19)))
                    formatter2=new SimpleDateFormat("MMM, d'th' yyyy hh:mm aa");
                else
                {
                    switch (dateValue%10)
                    {
                        case 1:
                            formatter2=new SimpleDateFormat("MMM, d'st' yyyy hh:mm aa");
                            break;
                        case 2:
                            formatter2=new SimpleDateFormat("MMM, d'nd' yyyy hh:mm aa");
                            break;
                        case 3:
                            formatter2=new SimpleDateFormat("MMM, d'rd' yyyy hh:mm aa");
                            break;
                        default : formatter2=new SimpleDateFormat("MMM, d'th' yyyy hh:mm aa");
                    }
                }
                time = formatter2.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return time.replace("AM", "am").replace("PM","pm");
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
