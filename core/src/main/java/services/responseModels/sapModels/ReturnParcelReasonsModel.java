package services.responseModels.sapModels;

import java.io.Serializable;
import java.util.List;

public class ReturnParcelReasonsModel {

    /**
     * isError : false
     * reasons : [{"GROUP":"Address/customerPhone Number Issue","REASONS":[{"REASON_ID":8,"REASON_BN":"ঠিকানা অকার্যকর","REASON_EN":"ADDRESS_INVALID","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"merchant","IS_CUSTOMER_OTP":true,"IS_MERCHANT_OTP":true,"IS_SLACK_OTP":true},{"REASON_ID":9,"REASON_BN":"ভুল ফোন নাম্বার","REASON_EN":"WRONG_customerPhone_NUMBER","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":true,"IS_SLACK_OTP":true},{"REASON_ID":10,"REASON_BN":"এলাকা কাভারেজ এর বাহিরে ","REASON_EN":"OUT_OF_COVERAGE","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"merchant","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":true,"IS_SLACK_OTP":true}]},{"GROUP":"Customer","REASONS":[{"REASON_ID":13,"REASON_BN":"কাস্টমারের কাছে টাকা না থাকায় রিটার্ন হচ্ছে ","REASON_EN":"NO_MONEY_RETURN","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"merchant","IS_CUSTOMER_OTP":true,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":true},{"REASON_ID":15,"REASON_BN":"কাস্টমার নির্দিষ্ট ঠিকানায় উপস্থিত না থাকায় রিটার্ন  হচ্ছে ","REASON_EN":"CUSTOMER_NOT_IN_LOCATION_RETURN","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":true,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":true},{"REASON_ID":21,"REASON_BN":"কাস্টমার পরিবারের সদস্য অর্ডারটি দিয়েছেন","REASON_EN":"ORDER_PLACED_BY_FAMILY","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":true,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":true},{"REASON_ID":22,"REASON_BN":"পার্সেল ডেলিভারি হবার পুর্বে কাস্টমার বাতিল করেছেন","REASON_EN":"PRE_DELIVERY_CANCELED_BY_CUSTOMER","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"merchant","IS_CUSTOMER_OTP":true,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":true},{"REASON_ID":23,"REASON_BN":"কাস্টমার ভুলে অর্ডারটি করেছেন","REASON_EN":"ORDERED_BY_MISTAKE","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"merchant","IS_CUSTOMER_OTP":true,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":true},{"REASON_ID":24,"REASON_BN":"কাস্টমার কোনো অর্ডার করেনি।","REASON_EN":"NO_ORDER_BY_CUSTOMER","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":true,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":true},{"REASON_ID":25,"REASON_BN":"কাস্টমার এর পার্সেলটি পছন্দ হয় নি।","REASON_EN":"DIDNOT_LIKE_THE_PARCEL","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"merchant","IS_CUSTOMER_OTP":true,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":true},{"REASON_ID":26,"REASON_BN":"কাস্টমার প্যাকেজটি খুলে দেখতে চেয়েছেন","REASON_EN":"WANTS_TO_OPEN_THE_PACKAGE","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"merchant","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":true,"IS_SLACK_OTP":true},{"REASON_ID":27,"REASON_BN":"কাস্টমার নির্ধারিত ঠিকানায় থাকেন না","REASON_EN":"DOES_NOT_LIVE_IN_ADDRESS","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":true,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":true},{"REASON_ID":28,"REASON_BN":"করনার ভয়ে কাস্টমার নিতে অনিচছুক।","REASON_EN":"CORONA_RETURN","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":true,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":true},{"REASON_ID":29,"REASON_BN":"সন্দেহভাজন জাল অডার","REASON_EN":"FAKE_ORDER","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":true,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":true},{"REASON_ID":60,"REASON_BN":"কাস্টমার কে ফোনে পাওয়া যায়নি এবং রিটার্ন হচ্ছে ","REASON_EN":"CUSTOMER_UNREACHABLE_RETURN","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":null,"SCOPE":"customer","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":true,"IS_SLACK_OTP":true}]},{"GROUP":"General","REASONS":[{"REASON_ID":33,"REASON_BN":"হোল্ড এর লিমিট অতিক্রম করছে।","REASON_EN":"HOLD_LIMIT_REACHED","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":null,"IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":true,"IS_SLACK_OTP":true}]},{"GROUP":"Merchant","REASONS":[{"REASON_ID":35,"REASON_BN":"মার্চেন্ট প্রোডাক্টটি রিটার্ন করতে বলেছেন।","REASON_EN":"RETURN_REQ_BY_MERCHANT","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"merchant","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":true,"IS_SLACK_OTP":true}]},{"GROUP":"Operations","REASONS":[{"REASON_ID":37,"REASON_BN":"ড্রাইভার এর কাছে অতিরিক্ত পার্সেল  ছিল","REASON_EN":"DRIVER_HAD_ADDITIONAL_PARCELS","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":null,"IS_CUSTOMER_OTP":true,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":true},{"REASON_ID":38,"REASON_BN":"প্রাকৃতিক দুর্যোগ","REASON_EN":"NATURAL_DISASTER","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":null,"IS_CUSTOMER_OTP":true,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":true},{"REASON_ID":41,"REASON_BN":"পার্সেল টি সঠিক সময়ে ডেলিভারি দেয়া হয় নি","REASON_EN":"NOT_DELIVERED_ON_TIME","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":null,"IS_CUSTOMER_OTP":true,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":true}]},{"GROUP":"Product","REASONS":[{"REASON_ID":43,"REASON_BN":"পার্সেলটি ত্রুটিপূর্ণ।","REASON_EN":"FAULTY_PARCEL","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"merchant","IS_CUSTOMER_OTP":true,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":true},{"REASON_ID":44,"REASON_BN":"পার্সেল র মুল্য ভুল দেয়া","REASON_EN":"WRONG_PRICE","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"merchant","IS_CUSTOMER_OTP":true,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":true},{"REASON_ID":45,"REASON_BN":"ডুপ্লিকেট অর্ডার","REASON_EN":"DUPLICATE_ORDER","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"merchant","IS_CUSTOMER_OTP":true,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":true},{"REASON_ID":46,"REASON_BN":"ভুল পার্সেল  ছিল","REASON_EN":"WRONG_PARCEL","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"merchant","IS_CUSTOMER_OTP":true,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":true},{"REASON_ID":47,"REASON_BN":"পার্সেল টি নষ্ট হয়ে গিয়েছিল","REASON_EN":"PARCEL_GOT_DAMAGED","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":true,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":true},{"REASON_ID":49,"REASON_BN":"কিছু প্রোডাক্ট উপস্থিত নেই ","REASON_EN":"PRODUCT_MISSING","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"merchant","IS_CUSTOMER_OTP":true,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":true},{"REASON_ID":50,"REASON_BN":"ভুল সাইজ বা রং","REASON_EN":"WRONG_SIZE_COLOUR","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"merchant","IS_CUSTOMER_OTP":true,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":true},{"REASON_ID":51,"REASON_BN":"পার্সেল টির আগে বেবহ্রিত হয়েছে","REASON_EN":"USED_PRODUCT","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"merchant","IS_CUSTOMER_OTP":true,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":true},{"REASON_ID":52,"REASON_BN":"কাস্টমার প্রোডাক্টটি কম মুল্যে অন্য জায়গায় পেয়েছেন","REASON_EN":"FOUND_LOWER_PRICE_ELSEWHERE","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":true,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":true}]}]
     */

    private boolean isError;
    private List<ReasonsBean> reasons;

    public boolean isIsError() {
        return isError;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
    }

    public List<ReasonsBean> getReasons() {
        return reasons;
    }

    public void setReasons(List<ReasonsBean> reasons) {
        this.reasons = reasons;
    }

    public static class ReasonsBean implements Serializable {
        /**
         * GROUP : Address/customerPhone Number Issue
         * REASONS : [{"REASON_ID":8,"REASON_BN":"ঠিকানা অকার্যকর","REASON_EN":"ADDRESS_INVALID","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"merchant","IS_CUSTOMER_OTP":true,"IS_MERCHANT_OTP":true,"IS_SLACK_OTP":true},{"REASON_ID":9,"REASON_BN":"ভুল ফোন নাম্বার","REASON_EN":"WRONG_customerPhone_NUMBER","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":true,"IS_SLACK_OTP":true},{"REASON_ID":10,"REASON_BN":"এলাকা কাভারেজ এর বাহিরে ","REASON_EN":"OUT_OF_COVERAGE","CATEGORY":"return","TOTAL_CALLS":null,"CALL_DURATION":30,"SCOPE":"merchant","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":true,"IS_SLACK_OTP":true}]
         */

        private String GROUP;
        private List<REASONSBean> REASONS;

        public String getGROUP() {
            return GROUP;
        }

        public void setGROUP(String GROUP) {
            this.GROUP = GROUP;
        }

        public List<REASONSBean> getREASONS() {
            return REASONS;
        }

        public void setREASONS(List<REASONSBean> REASONS) {
            this.REASONS = REASONS;
        }

        public static class REASONSBean implements Serializable {
            /**
             * REASON_ID : 8
             * REASON_BN : ঠিকানা অকার্যকর
             * REASON_EN : ADDRESS_INVALID
             * CATEGORY : return
             * TOTAL_CALLS : null
             * CALL_DURATION : 30
             * SCOPE : merchant
             * IS_CUSTOMER_OTP : true
             * IS_MERCHANT_OTP : true
             * IS_SLACK_OTP : true
             */

            private int REASON_ID;
            private String REASON_BN;
            private String REASON_EN;
            private String CATEGORY;
            private Object TOTAL_CALLS;
            private int CALL_DURATION;
            private String SCOPE;
            private boolean IS_CUSTOMER_OTP;
            private boolean IS_MERCHANT_OTP;
            private boolean IS_SLACK_OTP;

            public int getREASON_ID() {
                return REASON_ID;
            }

            public void setREASON_ID(int REASON_ID) {
                this.REASON_ID = REASON_ID;
            }

            public String getREASON_BN() {
                return REASON_BN;
            }

            public void setREASON_BN(String REASON_BN) {
                this.REASON_BN = REASON_BN;
            }

            public String getREASON_EN() {
                return REASON_EN;
            }

            public void setREASON_EN(String REASON_EN) {
                this.REASON_EN = REASON_EN;
            }

            public String getCATEGORY() {
                return CATEGORY;
            }

            public void setCATEGORY(String CATEGORY) {
                this.CATEGORY = CATEGORY;
            }

            public Object getTOTAL_CALLS() {
                return TOTAL_CALLS;
            }

            public void setTOTAL_CALLS(Object TOTAL_CALLS) {
                this.TOTAL_CALLS = TOTAL_CALLS;
            }

            public int getCALL_DURATION() {
                return CALL_DURATION;
            }

            public void setCALL_DURATION(int CALL_DURATION) {
                this.CALL_DURATION = CALL_DURATION;
            }

            public String getSCOPE() {
                return SCOPE;
            }

            public void setSCOPE(String SCOPE) {
                this.SCOPE = SCOPE;
            }

            public boolean isIS_CUSTOMER_OTP() {
                return IS_CUSTOMER_OTP;
            }

            public void setIS_CUSTOMER_OTP(boolean IS_CUSTOMER_OTP) {
                this.IS_CUSTOMER_OTP = IS_CUSTOMER_OTP;
            }

            public boolean isIS_MERCHANT_OTP() {
                return IS_MERCHANT_OTP;
            }

            public void setIS_MERCHANT_OTP(boolean IS_MERCHANT_OTP) {
                this.IS_MERCHANT_OTP = IS_MERCHANT_OTP;
            }

            public boolean isIS_SLACK_OTP() {
                return IS_SLACK_OTP;
            }

            public void setIS_SLACK_OTP(boolean IS_SLACK_OTP) {
                this.IS_SLACK_OTP = IS_SLACK_OTP;
            }
        }
    }
}
