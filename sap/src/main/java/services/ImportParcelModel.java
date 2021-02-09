package services;

import java.io.Serializable;
import java.util.List;

public class ImportParcelModel {

    /**
     * error : false
     * parcels : [{"INVOICE_NUMBER":{"value":"199170","error":null},"CUSTOMER_NAME":{"value":"John Doe","error":null},"CUSTOMER_PHONE":{"value":"8801873445555","error":null},"DELIVERY_ADDRESS":{"value":"House name (Apt number), Road number ","error":null},"POST_CODE":{"value":"7870","error":null},"CASH":{"value":"120","error":null},"SELLER_INSTRUCTION":{"value":"Comment regarding delivery","error":null},"VALUE":{"value":null,"error":null},"WEIGHT":{"value":500,"error":null},"AREA_ID":{"value":638,"error":null},"AREA":{"value":"Alfadanga","error":null}},{"INVOICE_NUMBER":{"value":"199171","error":null},"CUSTOMER_NAME":{"value":"Jane Doe","error":null},"CUSTOMER_PHONE":{"value":"8801873445555","error":null},"DELIVERY_ADDRESS":{"value":"50 Lake Circus (7th floor) Kalabagan","error":null},"POST_CODE":{"value":"7830","error":null},"CASH":{"value":"0","error":null},"SELLER_INSTRUCTION":{"value":"Give cash amount zero if payment already done","error":null},"VALUE":{"value":null,"error":null},"WEIGHT":{"value":500,"error":null},"AREA_ID":{"value":639,"error":null},"AREA":{"value":"Bhanga","error":null}}]
     */

    private boolean error;
    private List<ParcelsBean> parcels;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ParcelsBean> getParcels() {
        return parcels;
    }

    public void setParcels(List<ParcelsBean> parcels) {
        this.parcels = parcels;
    }

    public static class ParcelsBean implements Serializable {
        /**
         * INVOICE_NUMBER : {"value":"199170","error":null}
         * CUSTOMER_NAME : {"value":"John Doe","error":null}
         * CUSTOMER_PHONE : {"value":"8801873445555","error":null}
         * DELIVERY_ADDRESS : {"value":"House name (Apt number), Road number ","error":null}
         * POST_CODE : {"value":"7870","error":null}
         * CASH : {"value":"120","error":null}
         * SELLER_INSTRUCTION : {"value":"Comment regarding delivery","error":null}
         * VALUE : {"value":null,"error":null}
         * WEIGHT : {"value":500,"error":null}
         * AREA_ID : {"value":638,"error":null}
         * AREA : {"value":"Alfadanga","error":null}
         */

        private INVOICENUMBERBean INVOICE_NUMBER;
        private CUSTOMERNAMEBean CUSTOMER_NAME;
        private CUSTOMERPHONEBean CUSTOMER_PHONE;
        private DELIVERYADDRESSBean DELIVERY_ADDRESS;
        private POSTCODEBean POST_CODE;
        private CASHBean CASH;
        private SELLERINSTRUCTIONBean SELLER_INSTRUCTION;
        private VALUEBean VALUE;
        private WEIGHTBean WEIGHT;
        private AREAIDBean AREA_ID;
        private AREABean AREA;

        public INVOICENUMBERBean getINVOICE_NUMBER() {
            return INVOICE_NUMBER;
        }

        public void setINVOICE_NUMBER(INVOICENUMBERBean INVOICE_NUMBER) {
            this.INVOICE_NUMBER = INVOICE_NUMBER;
        }

        public CUSTOMERNAMEBean getCUSTOMER_NAME() {
            return CUSTOMER_NAME;
        }

        public void setCUSTOMER_NAME(CUSTOMERNAMEBean CUSTOMER_NAME) {
            this.CUSTOMER_NAME = CUSTOMER_NAME;
        }

        public CUSTOMERPHONEBean getCUSTOMER_PHONE() {
            return CUSTOMER_PHONE;
        }

        public void setCUSTOMER_PHONE(CUSTOMERPHONEBean CUSTOMER_PHONE) {
            this.CUSTOMER_PHONE = CUSTOMER_PHONE;
        }

        public DELIVERYADDRESSBean getDELIVERY_ADDRESS() {
            return DELIVERY_ADDRESS;
        }

        public void setDELIVERY_ADDRESS(DELIVERYADDRESSBean DELIVERY_ADDRESS) {
            this.DELIVERY_ADDRESS = DELIVERY_ADDRESS;
        }

        public POSTCODEBean getPOST_CODE() {
            return POST_CODE;
        }

        public void setPOST_CODE(POSTCODEBean POST_CODE) {
            this.POST_CODE = POST_CODE;
        }

        public CASHBean getCASH() {
            return CASH;
        }

        public void setCASH(CASHBean CASH) {
            this.CASH = CASH;
        }

        public SELLERINSTRUCTIONBean getSELLER_INSTRUCTION() {
            return SELLER_INSTRUCTION;
        }

        public void setSELLER_INSTRUCTION(SELLERINSTRUCTIONBean SELLER_INSTRUCTION) {
            this.SELLER_INSTRUCTION = SELLER_INSTRUCTION;
        }

        public VALUEBean getVALUE() {
            return VALUE;
        }

        public void setVALUE(VALUEBean VALUE) {
            this.VALUE = VALUE;
        }

        public WEIGHTBean getWEIGHT() {
            return WEIGHT;
        }

        public void setWEIGHT(WEIGHTBean WEIGHT) {
            this.WEIGHT = WEIGHT;
        }

        public AREAIDBean getAREA_ID() {
            return AREA_ID;
        }

        public void setAREA_ID(AREAIDBean AREA_ID) {
            this.AREA_ID = AREA_ID;
        }

        public AREABean getAREA() {
            return AREA;
        }

        public void setAREA(AREABean AREA) {
            this.AREA = AREA;
        }

        public static class INVOICENUMBERBean implements Serializable {
            /**
             * value : 199170
             * error : null
             */

            private String value;
            private Object error;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public Object getError() {
                return error;
            }

            public void setError(Object error) {
                this.error = error;
            }
        }

        public static class CUSTOMERNAMEBean implements Serializable {
            /**
             * value : John Doe
             * error : null
             */

            private String value;
            private Object error;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public Object getError() {
                return error;
            }

            public void setError(Object error) {
                this.error = error;
            }
        }

        public static class CUSTOMERPHONEBean implements Serializable {
            /**
             * value : 8801873445555
             * error : null
             */

            private String value;
            private Object error;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public Object getError() {
                return error;
            }

            public void setError(Object error) {
                this.error = error;
            }
        }

        public static class DELIVERYADDRESSBean implements Serializable {
            /**
             * value : House name (Apt number), Road number
             * error : null
             */

            private String value;
            private Object error;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public Object getError() {
                return error;
            }

            public void setError(Object error) {
                this.error = error;
            }
        }

        public static class POSTCODEBean implements Serializable {
            /**
             * value : 7870
             * error : null
             */

            private String value;
            private Object error;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public Object getError() {
                return error;
            }

            public void setError(Object error) {
                this.error = error;
            }
        }

        public static class CASHBean implements Serializable {
            /**
             * value : 120
             * error : null
             */

            private String value;
            private Object error;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public Object getError() {
                return error;
            }

            public void setError(Object error) {
                this.error = error;
            }
        }

        public static class SELLERINSTRUCTIONBean implements Serializable {
            /**
             * value : Comment regarding delivery
             * error : null
             */

            private String value;
            private Object error;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public Object getError() {
                return error;
            }

            public void setError(Object error) {
                this.error = error;
            }
        }

        public static class VALUEBean implements Serializable {
            /**
             * value : null
             * error : null
             */

            private Object value;
            private Object error;

            public Object getValue() {
                return value;
            }

            public void setValue(Object value) {
                this.value = value;
            }

            public Object getError() {
                return error;
            }

            public void setError(Object error) {
                this.error = error;
            }
        }

        public static class WEIGHTBean implements Serializable {
            /**
             * value : 500
             * error : null
             */

            private int value;
            private Object error;

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public Object getError() {
                return error;
            }

            public void setError(Object error) {
                this.error = error;
            }
        }

        public static class AREAIDBean implements Serializable {
            /**
             * value : 638
             * error : null
             */

            private int value;
            private Object error;

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public Object getError() {
                return error;
            }

            public void setError(Object error) {
                this.error = error;
            }
        }

        public static class AREABean implements Serializable {
            /**
             * value : Alfadanga
             * error : null
             */

            private String value;
            private Object error;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public Object getError() {
                return error;
            }

            public void setError(Object error) {
                this.error = error;
            }
        }
    }
}
