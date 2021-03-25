package services.responseModels.redxModels;

import java.io.Serializable;
import java.util.List;

public class PricingModel {

    /**
     * isError : false
     * zones : [{"ID":1,"NAME":"Dhaka City","AREAS":[{"ID":1,"NAME":"Mohammadpur(Dhaka)","POST_CODE":1207,"IS_COD_AVAILABLE":true,"IS_HOME_DELIVERY":true,"IS_PICKUP_AVAILABLE":true,"IS_LOCKED_DOWN":false,"District":{"NAME":"Dhaka"}},{"ID":2,"NAME":"Dhanmondi","POST_CODE":1209,"IS_COD_AVAILABLE":true,"IS_HOME_DELIVERY":true,"IS_PICKUP_AVAILABLE":true,"IS_LOCKED_DOWN":false,"District":{"NAME":"Dhaka"}},{"ID":3,"NAME":"Gulshan","POST_CODE":1212,"IS_COD_AVAILABLE":true,"IS_HOME_DELIVERY":true,"IS_PICKUP_AVAILABLE":true,"IS_LOCKED_DOWN":false,"District":{"NAME":"Dhaka"}}],"PRICING":{"SHOPUP_KG05_PRICE":60,"SHOPUP_KG1_PRICE":60,"SHOPUP_KG2_PRICE":75,"SHOPUP_KG3_PRICE":90,"SHOPUP_KG4_PRICE":105,"SHOPUP_KG5_PRICE":120,"SHOPUP_COD":0}},{"ID":2,"NAME":"Dhaka Suburbs","AREAS":[{"ID":53,"NAME":"Savar","POST_CODE":1348,"IS_COD_AVAILABLE":true,"IS_HOME_DELIVERY":true,"IS_PICKUP_AVAILABLE":true,"IS_LOCKED_DOWN":false,"District":{"NAME":"Dhaka"}},{"ID":61,"NAME":"Savar Cantonment","POST_CODE":1348,"IS_COD_AVAILABLE":true,"IS_HOME_DELIVERY":true,"IS_PICKUP_AVAILABLE":true,"IS_LOCKED_DOWN":false,"District":{"NAME":"Dhaka"}},{"ID":63,"NAME":"Tongi","POST_CODE":1700,"IS_COD_AVAILABLE":true,"IS_HOME_DELIVERY":true,"IS_PICKUP_AVAILABLE":true,"IS_LOCKED_DOWN":false,"District":{"NAME":"Gazipur"}},{"ID":278,"NAME":"Demra","POST_CODE":1360,"IS_COD_AVAILABLE":true,"IS_HOME_DELIVERY":true,"IS_PICKUP_AVAILABLE":true,"IS_LOCKED_DOWN":false,"District":{"NAME":"Dhaka"}}],"PRICING":{"SHOPUP_KG05_PRICE":100,"SHOPUP_KG1_PRICE":100,"SHOPUP_KG2_PRICE":115,"SHOPUP_KG3_PRICE":130,"SHOPUP_KG4_PRICE":145,"SHOPUP_KG5_PRICE":160,"SHOPUP_COD":1}}]
     */

    private boolean isError;
    private List<ZonesBean> zones;

    public boolean isIsError() {
        return isError;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
    }

    public List<ZonesBean> getZones() {
        return zones;
    }

    public void setZones(List<ZonesBean> zones) {
        this.zones = zones;
    }

    public static class ZonesBean implements Serializable {
        /**
         * ID : 1
         * NAME : Dhaka City
         * AREAS : [{"ID":1,"NAME":"Mohammadpur(Dhaka)","POST_CODE":1207,"IS_COD_AVAILABLE":true,"IS_HOME_DELIVERY":true,"IS_PICKUP_AVAILABLE":true,"IS_LOCKED_DOWN":false,"District":{"NAME":"Dhaka"}},{"ID":2,"NAME":"Dhanmondi","POST_CODE":1209,"IS_COD_AVAILABLE":true,"IS_HOME_DELIVERY":true,"IS_PICKUP_AVAILABLE":true,"IS_LOCKED_DOWN":false,"District":{"NAME":"Dhaka"}},{"ID":3,"NAME":"Gulshan","POST_CODE":1212,"IS_COD_AVAILABLE":true,"IS_HOME_DELIVERY":true,"IS_PICKUP_AVAILABLE":true,"IS_LOCKED_DOWN":false,"District":{"NAME":"Dhaka"}}]
         * PRICING : {"SHOPUP_KG05_PRICE":60,"SHOPUP_KG1_PRICE":60,"SHOPUP_KG2_PRICE":75,"SHOPUP_KG3_PRICE":90,"SHOPUP_KG4_PRICE":105,"SHOPUP_KG5_PRICE":120,"SHOPUP_COD":0}
         */

        private int ID;
        private String NAME;
        private PricingBean PRICING;
        private List<AreasBean> AREAS;

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getNAME() {
            return NAME;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }

        public PricingBean getPRICING() {
            return PRICING;
        }

        public void setPRICING(PricingBean PRICING) {
            this.PRICING = PRICING;
        }

        public List<AreasBean> getAREAS() {
            return AREAS;
        }

        public void setAREAS(List<AreasBean> AREAS) {
            this.AREAS = AREAS;
        }

        public static class PricingBean implements Serializable {
            /**
             * SHOPUP_KG05_PRICE : 60
             * SHOPUP_KG1_PRICE : 60
             * SHOPUP_KG2_PRICE : 75
             * SHOPUP_KG3_PRICE : 90
             * SHOPUP_KG4_PRICE : 105
             * SHOPUP_KG5_PRICE : 120
             * SHOPUP_COD : 0
             */

            private int SHOPUP_KG05_PRICE;
            private int SHOPUP_KG1_PRICE;
            private int SHOPUP_KG2_PRICE;
            private int SHOPUP_KG3_PRICE;
            private int SHOPUP_KG4_PRICE;
            private int SHOPUP_KG5_PRICE;
            private int SHOPUP_COD;

            public int getSHOPUP_KG05_PRICE() {
                return SHOPUP_KG05_PRICE;
            }

            public void setSHOPUP_KG05_PRICE(int SHOPUP_KG05_PRICE) {
                this.SHOPUP_KG05_PRICE = SHOPUP_KG05_PRICE;
            }

            public int getSHOPUP_KG1_PRICE() {
                return SHOPUP_KG1_PRICE;
            }

            public void setSHOPUP_KG1_PRICE(int SHOPUP_KG1_PRICE) {
                this.SHOPUP_KG1_PRICE = SHOPUP_KG1_PRICE;
            }

            public int getSHOPUP_KG2_PRICE() {
                return SHOPUP_KG2_PRICE;
            }

            public void setSHOPUP_KG2_PRICE(int SHOPUP_KG2_PRICE) {
                this.SHOPUP_KG2_PRICE = SHOPUP_KG2_PRICE;
            }

            public int getSHOPUP_KG3_PRICE() {
                return SHOPUP_KG3_PRICE;
            }

            public void setSHOPUP_KG3_PRICE(int SHOPUP_KG3_PRICE) {
                this.SHOPUP_KG3_PRICE = SHOPUP_KG3_PRICE;
            }

            public int getSHOPUP_KG4_PRICE() {
                return SHOPUP_KG4_PRICE;
            }

            public void setSHOPUP_KG4_PRICE(int SHOPUP_KG4_PRICE) {
                this.SHOPUP_KG4_PRICE = SHOPUP_KG4_PRICE;
            }

            public int getSHOPUP_KG5_PRICE() {
                return SHOPUP_KG5_PRICE;
            }

            public void setSHOPUP_KG5_PRICE(int SHOPUP_KG5_PRICE) {
                this.SHOPUP_KG5_PRICE = SHOPUP_KG5_PRICE;
            }

            public int getSHOPUP_COD() {
                return SHOPUP_COD;
            }

            public void setSHOPUP_COD(int SHOPUP_COD) {
                this.SHOPUP_COD = SHOPUP_COD;
            }
        }

        public static class AreasBean implements Serializable {
            /**
             * ID : 1
             * NAME : Mohammadpur(Dhaka)
             * POST_CODE : 1207
             * IS_COD_AVAILABLE : true
             * IS_HOME_DELIVERY : true
             * IS_PICKUP_AVAILABLE : true
             * IS_LOCKED_DOWN : false
             * District : {"NAME":"Dhaka"}
             */

            private int ID;
            private String NAME;
            private int POST_CODE;
            private boolean IS_COD_AVAILABLE;
            private boolean IS_HOME_DELIVERY;
            private boolean IS_PICKUP_AVAILABLE;
            private boolean IS_LOCKED_DOWN;
            private DistrictBean District;

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }

            public String getNAME() {
                return NAME;
            }

            public void setNAME(String NAME) {
                this.NAME = NAME;
            }

            public int getPOST_CODE() {
                return POST_CODE;
            }

            public void setPOST_CODE(int POST_CODE) {
                this.POST_CODE = POST_CODE;
            }

            public boolean isIS_COD_AVAILABLE() {
                return IS_COD_AVAILABLE;
            }

            public void setIS_COD_AVAILABLE(boolean IS_COD_AVAILABLE) {
                this.IS_COD_AVAILABLE = IS_COD_AVAILABLE;
            }

            public boolean isIS_HOME_DELIVERY() {
                return IS_HOME_DELIVERY;
            }

            public void setIS_HOME_DELIVERY(boolean IS_HOME_DELIVERY) {
                this.IS_HOME_DELIVERY = IS_HOME_DELIVERY;
            }

            public boolean isIS_PICKUP_AVAILABLE() {
                return IS_PICKUP_AVAILABLE;
            }

            public void setIS_PICKUP_AVAILABLE(boolean IS_PICKUP_AVAILABLE) {
                this.IS_PICKUP_AVAILABLE = IS_PICKUP_AVAILABLE;
            }

            public boolean isIS_LOCKED_DOWN() {
                return IS_LOCKED_DOWN;
            }

            public void setIS_LOCKED_DOWN(boolean IS_LOCKED_DOWN) {
                this.IS_LOCKED_DOWN = IS_LOCKED_DOWN;
            }

            public DistrictBean getDistrict() {
                return District;
            }

            public void setDistrict(DistrictBean District) {
                this.District = District;
            }

            public static class DistrictBean implements Serializable {
                /**
                 * NAME : Dhaka
                 */

                private String NAME;

                public String getNAME() {
                    return NAME;
                }

                public void setNAME(String NAME) {
                    this.NAME = NAME;
                }
            }
        }
    }
}
