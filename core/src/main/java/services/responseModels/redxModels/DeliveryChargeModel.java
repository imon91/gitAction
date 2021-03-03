package services.responseModels.redxModels;

import java.io.Serializable;

public class DeliveryChargeModel {

    /**
     * isError : false
     * body : {"pricing":{"SHOPUP_CHARGE":"60.00","SHOPUP_COD_CHARGE":0,"DISCOUNT_AMOUNT":0,"PAYABLE_AMOUNT":"2940.00"}}
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
         * pricing : {"SHOPUP_CHARGE":"60.00","SHOPUP_COD_CHARGE":0,"DISCOUNT_AMOUNT":0,"PAYABLE_AMOUNT":"2940.00"}
         */

        private PricingBean pricing;

        public PricingBean getPricing() {
            return pricing;
        }

        public void setPricing(PricingBean pricing) {
            this.pricing = pricing;
        }

        public static class PricingBean implements Serializable {
            /**
             * SHOPUP_CHARGE : 60.00
             * SHOPUP_COD_CHARGE : 0
             * DISCOUNT_AMOUNT : 0
             * PAYABLE_AMOUNT : 2940.00
             */

            private String SHOPUP_CHARGE;
            private int SHOPUP_COD_CHARGE;
            private int DISCOUNT_AMOUNT;
            private String PAYABLE_AMOUNT;

            public String getSHOPUP_CHARGE() {
                return SHOPUP_CHARGE;
            }

            public void setSHOPUP_CHARGE(String SHOPUP_CHARGE) {
                this.SHOPUP_CHARGE = SHOPUP_CHARGE;
            }

            public int getSHOPUP_COD_CHARGE() {
                return SHOPUP_COD_CHARGE;
            }

            public void setSHOPUP_COD_CHARGE(int SHOPUP_COD_CHARGE) {
                this.SHOPUP_COD_CHARGE = SHOPUP_COD_CHARGE;
            }

            public int getDISCOUNT_AMOUNT() {
                return DISCOUNT_AMOUNT;
            }

            public void setDISCOUNT_AMOUNT(int DISCOUNT_AMOUNT) {
                this.DISCOUNT_AMOUNT = DISCOUNT_AMOUNT;
            }

            public String getPAYABLE_AMOUNT() {
                return PAYABLE_AMOUNT;
            }

            public void setPAYABLE_AMOUNT(String PAYABLE_AMOUNT) {
                this.PAYABLE_AMOUNT = PAYABLE_AMOUNT;
            }
        }
    }
}

