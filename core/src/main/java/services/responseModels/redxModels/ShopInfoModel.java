package services.responseModels.redxModels;

import java.io.Serializable;

public class ShopInfoModel {

    /**
     * isError : false
     * body : {"shop":{"ID":648299,"PAGE_ID":null,"SHOP_NAME":"RedX Web Sanity Test Shop","SHOP_ADDRESS":"Dhandamoni","SHOP_PHONE":"01401122188","POLICY":"","MINIMUM_DELIVERY_CHARGE":0,"MAXIMUM_DELIVERY_CHARGE":0,"DISCOUNTS":null,"MINIMUM_ORDER":0,"MESSENGER":null,"GUEST_PURCHASE":true,"BKASH":"disabled","PAYMENT_ENABLED":false,"INT_SHIPPING_ENABLED":false,"SUPER_SELLER":false,"CTA":false,"SHOP_EMAIL":"shopup@gmail.com","VACATION_MODE":false,"VACATION_MESSAGE":null,"AREA_ID":2,"PICKUP_ADDRESS":"Dhandamoni","PICKUP_AREA":null,"PICKUP_PHONE":"8801401122188","BKASH_ENABLED":false,"SELF_BKASH_ENABLED":false,"CREDIT_CARD_ENABLED":false,"SOURCE_SELLER":false,"IS_RESELLER_SOURCE_SELLER":false,"BUSINESS_TYPE":"others","SELF_EXCHANGE_RATE":95,"SHOPUP_EXCHANGE_RATE":99}}
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
         * shop : {"ID":648299,"PAGE_ID":null,"SHOP_NAME":"RedX Web Sanity Test Shop","SHOP_ADDRESS":"Dhandamoni","SHOP_PHONE":"01401122188","POLICY":"","MINIMUM_DELIVERY_CHARGE":0,"MAXIMUM_DELIVERY_CHARGE":0,"DISCOUNTS":null,"MINIMUM_ORDER":0,"MESSENGER":null,"GUEST_PURCHASE":true,"BKASH":"disabled","PAYMENT_ENABLED":false,"INT_SHIPPING_ENABLED":false,"SUPER_SELLER":false,"CTA":false,"SHOP_EMAIL":"shopup@gmail.com","VACATION_MODE":false,"VACATION_MESSAGE":null,"AREA_ID":2,"PICKUP_ADDRESS":"Dhandamoni","PICKUP_AREA":null,"PICKUP_PHONE":"8801401122188","BKASH_ENABLED":false,"SELF_BKASH_ENABLED":false,"CREDIT_CARD_ENABLED":false,"SOURCE_SELLER":false,"IS_RESELLER_SOURCE_SELLER":false,"BUSINESS_TYPE":"others","SELF_EXCHANGE_RATE":95,"SHOPUP_EXCHANGE_RATE":99}
         */

        private ShopBean shop;

        public ShopBean getShop() {
            return shop;
        }

        public void setShop(ShopBean shop) {
            this.shop = shop;
        }

        public static class ShopBean implements Serializable {
            /**
             * ID : 648299
             * PAGE_ID : null
             * SHOP_NAME : RedX Web Sanity Test Shop
             * SHOP_ADDRESS : Dhandamoni
             * SHOP_PHONE : 01401122188
             * POLICY :
             * MINIMUM_DELIVERY_CHARGE : 0
             * MAXIMUM_DELIVERY_CHARGE : 0
             * DISCOUNTS : null
             * MINIMUM_ORDER : 0
             * MESSENGER : null
             * GUEST_PURCHASE : true
             * BKASH : disabled
             * PAYMENT_ENABLED : false
             * INT_SHIPPING_ENABLED : false
             * SUPER_SELLER : false
             * CTA : false
             * SHOP_EMAIL : shopup@gmail.com
             * VACATION_MODE : false
             * VACATION_MESSAGE : null
             * AREA_ID : 2
             * PICKUP_ADDRESS : Dhandamoni
             * PICKUP_AREA : null
             * PICKUP_PHONE : 8801401122188
             * BKASH_ENABLED : false
             * SELF_BKASH_ENABLED : false
             * CREDIT_CARD_ENABLED : false
             * SOURCE_SELLER : false
             * IS_RESELLER_SOURCE_SELLER : false
             * BUSINESS_TYPE : others
             * SELF_EXCHANGE_RATE : 95
             * SHOPUP_EXCHANGE_RATE : 99
             */

            private int ID;
            private Object PAGE_ID;
            private String SHOP_NAME;
            private String SHOP_ADDRESS;
            private String SHOP_PHONE;
            private String POLICY;
            private int MINIMUM_DELIVERY_CHARGE;
            private int MAXIMUM_DELIVERY_CHARGE;
            private Object DISCOUNTS;
            private int MINIMUM_ORDER;
            private Object MESSENGER;
            private boolean GUEST_PURCHASE;
            private String BKASH;
            private boolean PAYMENT_ENABLED;
            private boolean INT_SHIPPING_ENABLED;
            private boolean SUPER_SELLER;
            private boolean CTA;
            private String SHOP_EMAIL;
            private boolean VACATION_MODE;
            private Object VACATION_MESSAGE;
            private int AREA_ID;
            private String PICKUP_ADDRESS;
            private Object PICKUP_AREA;
            private String PICKUP_PHONE;
            private boolean BKASH_ENABLED;
            private boolean SELF_BKASH_ENABLED;
            private boolean CREDIT_CARD_ENABLED;
            private boolean SOURCE_SELLER;
            private boolean IS_RESELLER_SOURCE_SELLER;
            private String BUSINESS_TYPE;
            private int SELF_EXCHANGE_RATE;
            private int SHOPUP_EXCHANGE_RATE;

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }

            public Object getPAGE_ID() {
                return PAGE_ID;
            }

            public void setPAGE_ID(Object PAGE_ID) {
                this.PAGE_ID = PAGE_ID;
            }

            public String getSHOP_NAME() {
                return SHOP_NAME;
            }

            public void setSHOP_NAME(String SHOP_NAME) {
                this.SHOP_NAME = SHOP_NAME;
            }

            public String getSHOP_ADDRESS() {
                return SHOP_ADDRESS;
            }

            public void setSHOP_ADDRESS(String SHOP_ADDRESS) {
                this.SHOP_ADDRESS = SHOP_ADDRESS;
            }

            public String getSHOP_PHONE() {
                return SHOP_PHONE;
            }

            public void setSHOP_PHONE(String SHOP_PHONE) {
                this.SHOP_PHONE = SHOP_PHONE;
            }

            public String getPOLICY() {
                return POLICY;
            }

            public void setPOLICY(String POLICY) {
                this.POLICY = POLICY;
            }

            public int getMINIMUM_DELIVERY_CHARGE() {
                return MINIMUM_DELIVERY_CHARGE;
            }

            public void setMINIMUM_DELIVERY_CHARGE(int MINIMUM_DELIVERY_CHARGE) {
                this.MINIMUM_DELIVERY_CHARGE = MINIMUM_DELIVERY_CHARGE;
            }

            public int getMAXIMUM_DELIVERY_CHARGE() {
                return MAXIMUM_DELIVERY_CHARGE;
            }

            public void setMAXIMUM_DELIVERY_CHARGE(int MAXIMUM_DELIVERY_CHARGE) {
                this.MAXIMUM_DELIVERY_CHARGE = MAXIMUM_DELIVERY_CHARGE;
            }

            public Object getDISCOUNTS() {
                return DISCOUNTS;
            }

            public void setDISCOUNTS(Object DISCOUNTS) {
                this.DISCOUNTS = DISCOUNTS;
            }

            public int getMINIMUM_ORDER() {
                return MINIMUM_ORDER;
            }

            public void setMINIMUM_ORDER(int MINIMUM_ORDER) {
                this.MINIMUM_ORDER = MINIMUM_ORDER;
            }

            public Object getMESSENGER() {
                return MESSENGER;
            }

            public void setMESSENGER(Object MESSENGER) {
                this.MESSENGER = MESSENGER;
            }

            public boolean isGUEST_PURCHASE() {
                return GUEST_PURCHASE;
            }

            public void setGUEST_PURCHASE(boolean GUEST_PURCHASE) {
                this.GUEST_PURCHASE = GUEST_PURCHASE;
            }

            public String getBKASH() {
                return BKASH;
            }

            public void setBKASH(String BKASH) {
                this.BKASH = BKASH;
            }

            public boolean isPAYMENT_ENABLED() {
                return PAYMENT_ENABLED;
            }

            public void setPAYMENT_ENABLED(boolean PAYMENT_ENABLED) {
                this.PAYMENT_ENABLED = PAYMENT_ENABLED;
            }

            public boolean isINT_SHIPPING_ENABLED() {
                return INT_SHIPPING_ENABLED;
            }

            public void setINT_SHIPPING_ENABLED(boolean INT_SHIPPING_ENABLED) {
                this.INT_SHIPPING_ENABLED = INT_SHIPPING_ENABLED;
            }

            public boolean isSUPER_SELLER() {
                return SUPER_SELLER;
            }

            public void setSUPER_SELLER(boolean SUPER_SELLER) {
                this.SUPER_SELLER = SUPER_SELLER;
            }

            public boolean isCTA() {
                return CTA;
            }

            public void setCTA(boolean CTA) {
                this.CTA = CTA;
            }

            public String getSHOP_EMAIL() {
                return SHOP_EMAIL;
            }

            public void setSHOP_EMAIL(String SHOP_EMAIL) {
                this.SHOP_EMAIL = SHOP_EMAIL;
            }

            public boolean isVACATION_MODE() {
                return VACATION_MODE;
            }

            public void setVACATION_MODE(boolean VACATION_MODE) {
                this.VACATION_MODE = VACATION_MODE;
            }

            public Object getVACATION_MESSAGE() {
                return VACATION_MESSAGE;
            }

            public void setVACATION_MESSAGE(Object VACATION_MESSAGE) {
                this.VACATION_MESSAGE = VACATION_MESSAGE;
            }

            public int getAREA_ID() {
                return AREA_ID;
            }

            public void setAREA_ID(int AREA_ID) {
                this.AREA_ID = AREA_ID;
            }

            public String getPICKUP_ADDRESS() {
                return PICKUP_ADDRESS;
            }

            public void setPICKUP_ADDRESS(String PICKUP_ADDRESS) {
                this.PICKUP_ADDRESS = PICKUP_ADDRESS;
            }

            public Object getPICKUP_AREA() {
                return PICKUP_AREA;
            }

            public void setPICKUP_AREA(Object PICKUP_AREA) {
                this.PICKUP_AREA = PICKUP_AREA;
            }

            public String getPICKUP_PHONE() {
                return PICKUP_PHONE;
            }

            public void setPICKUP_PHONE(String PICKUP_PHONE) {
                this.PICKUP_PHONE = PICKUP_PHONE;
            }

            public boolean isBKASH_ENABLED() {
                return BKASH_ENABLED;
            }

            public void setBKASH_ENABLED(boolean BKASH_ENABLED) {
                this.BKASH_ENABLED = BKASH_ENABLED;
            }

            public boolean isSELF_BKASH_ENABLED() {
                return SELF_BKASH_ENABLED;
            }

            public void setSELF_BKASH_ENABLED(boolean SELF_BKASH_ENABLED) {
                this.SELF_BKASH_ENABLED = SELF_BKASH_ENABLED;
            }

            public boolean isCREDIT_CARD_ENABLED() {
                return CREDIT_CARD_ENABLED;
            }

            public void setCREDIT_CARD_ENABLED(boolean CREDIT_CARD_ENABLED) {
                this.CREDIT_CARD_ENABLED = CREDIT_CARD_ENABLED;
            }

            public boolean isSOURCE_SELLER() {
                return SOURCE_SELLER;
            }

            public void setSOURCE_SELLER(boolean SOURCE_SELLER) {
                this.SOURCE_SELLER = SOURCE_SELLER;
            }

            public boolean isIS_RESELLER_SOURCE_SELLER() {
                return IS_RESELLER_SOURCE_SELLER;
            }

            public void setIS_RESELLER_SOURCE_SELLER(boolean IS_RESELLER_SOURCE_SELLER) {
                this.IS_RESELLER_SOURCE_SELLER = IS_RESELLER_SOURCE_SELLER;
            }

            public String getBUSINESS_TYPE() {
                return BUSINESS_TYPE;
            }

            public void setBUSINESS_TYPE(String BUSINESS_TYPE) {
                this.BUSINESS_TYPE = BUSINESS_TYPE;
            }

            public int getSELF_EXCHANGE_RATE() {
                return SELF_EXCHANGE_RATE;
            }

            public void setSELF_EXCHANGE_RATE(int SELF_EXCHANGE_RATE) {
                this.SELF_EXCHANGE_RATE = SELF_EXCHANGE_RATE;
            }

            public int getSHOPUP_EXCHANGE_RATE() {
                return SHOPUP_EXCHANGE_RATE;
            }

            public void setSHOPUP_EXCHANGE_RATE(int SHOPUP_EXCHANGE_RATE) {
                this.SHOPUP_EXCHANGE_RATE = SHOPUP_EXCHANGE_RATE;
            }
        }
    }
}
