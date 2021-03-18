package services.responseModels.sapModels;

import java.io.Serializable;
import java.util.List;

public class ParcelReasonsModel {

    /**
     * isError : false
     * reasons : [{"GROUP":"Customer","REASONS":[{"REASON_ID":12,"REASON_BN":"কাস্টমারের কাছে টাকা না থাকায় হোল্ড  হচ্ছে ","REASON_EN":"NO_MONEY_HOLD","CATEGORY":"hold","TOTAL_CALLS":3,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":false},{"REASON_ID":14,"REASON_BN":"কাস্টমার নির্দিষ্ট ঠিকানায় উপস্থিত না থাকায় হোল্ড হচ্ছে","REASON_EN":"CUSTOMER_NOT_IN_LOCATION_HOLD","CATEGORY":"hold","TOTAL_CALLS":3,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":false},{"REASON_ID":16,"REASON_BN":"কাস্টমারকে ফোনে পাওয়া যায় নি।","REASON_EN":"CUSTOMER_UNREACHABLE","CATEGORY":"hold","TOTAL_CALLS":3,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":false},{"REASON_ID":17,"REASON_BN":"কাস্টমার এর ফোন বন্ধ।","REASON_EN":"CUSTOMER_PHONE_OFF","CATEGORY":"hold","TOTAL_CALLS":3,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":false},{"REASON_ID":18,"REASON_BN":"কাস্টমার অন্য পার্সেলের সঙ্গে নিবেন।","REASON_EN":"RECEIVE_WITH_OTHER_PARCEL","CATEGORY":"hold","TOTAL_CALLS":3,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":false},{"REASON_ID":19,"REASON_BN":"কাস্টমার এর অফিস বন্ধ।","REASON_EN":"OFFICE_CLOSED","CATEGORY":"hold","TOTAL_CALLS":3,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":false},{"REASON_ID":20,"REASON_BN":"কাস্টমার আজ পার্সেলটি নিতে পারবেন না। অন্য দিন নিবেন","REASON_EN":"ON_HOLD","CATEGORY":"hold","TOTAL_CALLS":3,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":false}]},{"GROUP":"Merchant","REASONS":[{"REASON_ID":34,"REASON_BN":"মার্চেন্ট পার্সেলটি হোল্ড করার নির্দেশনা দিয়েছেন।","REASON_EN":"ON_HOLD_BY_MERCHANT","CATEGORY":"hold","TOTAL_CALLS":3,"CALL_DURATION":30,"SCOPE":null,"IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":false}]},{"GROUP":"Operations","REASONS":[{"REASON_ID":39,"REASON_BN":"ডেলিভারি করার বাহন নষ্ট হয়ে গিয়েছিল","REASON_EN":"VEHICLE_ISSUE","CATEGORY":"hold","TOTAL_CALLS":3,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":false},{"REASON_ID":56,"REASON_BN":"কোরোনার জন্য এলাকায় প্রবেশ করা যায় নি ","REASON_EN":"AREA_LOCKDOWN_CORONA","CATEGORY":"hold","TOTAL_CALLS":3,"CALL_DURATION":30,"SCOPE":"merchant","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":false},{"REASON_ID":57,"REASON_BN":"আবহাওয়া খারাপ এর জন্যে ডেলিভারি করা যায়নি ","REASON_EN":"BAD_WEATHER","CATEGORY":"hold","TOTAL_CALLS":3,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":false},{"REASON_ID":58,"REASON_BN":"অভ্যন্তরীণ সমস্যার জন্যে ডেলিভারি করা যায় নি ","REASON_EN":"INTERNAL_PROBLEM","CATEGORY":"hold","TOTAL_CALLS":3,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":false},{"REASON_ID":59,"REASON_BN":"সময় স্বল্পতার জন্যে ডেলিভারি করা যায়নি","REASON_EN":"TIME_ISSUE","CATEGORY":"hold","TOTAL_CALLS":3,"CALL_DURATION":30,"SCOPE":null,"IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":false}]},{"GROUP":"Product","REASONS":[{"REASON_ID":42,"REASON_BN":"লেনদেন এ ঝামেলা আছে।","REASON_EN":"TRANSACTION_PROBLEM","CATEGORY":"hold","TOTAL_CALLS":3,"CALL_DURATION":30,"SCOPE":"merchant","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":false}]}]
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
         * GROUP : Customer
         * REASONS : [{"REASON_ID":12,"REASON_BN":"কাস্টমারের কাছে টাকা না থাকায় হোল্ড  হচ্ছে ","REASON_EN":"NO_MONEY_HOLD","CATEGORY":"hold","TOTAL_CALLS":3,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":false},{"REASON_ID":14,"REASON_BN":"কাস্টমার নির্দিষ্ট ঠিকানায় উপস্থিত না থাকায় হোল্ড হচ্ছে","REASON_EN":"CUSTOMER_NOT_IN_LOCATION_HOLD","CATEGORY":"hold","TOTAL_CALLS":3,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":false},{"REASON_ID":16,"REASON_BN":"কাস্টমারকে ফোনে পাওয়া যায় নি।","REASON_EN":"CUSTOMER_UNREACHABLE","CATEGORY":"hold","TOTAL_CALLS":3,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":false},{"REASON_ID":17,"REASON_BN":"কাস্টমার এর ফোন বন্ধ।","REASON_EN":"CUSTOMER_PHONE_OFF","CATEGORY":"hold","TOTAL_CALLS":3,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":false},{"REASON_ID":18,"REASON_BN":"কাস্টমার অন্য পার্সেলের সঙ্গে নিবেন।","REASON_EN":"RECEIVE_WITH_OTHER_PARCEL","CATEGORY":"hold","TOTAL_CALLS":3,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":false},{"REASON_ID":19,"REASON_BN":"কাস্টমার এর অফিস বন্ধ।","REASON_EN":"OFFICE_CLOSED","CATEGORY":"hold","TOTAL_CALLS":3,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":false},{"REASON_ID":20,"REASON_BN":"কাস্টমার আজ পার্সেলটি নিতে পারবেন না। অন্য দিন নিবেন","REASON_EN":"ON_HOLD","CATEGORY":"hold","TOTAL_CALLS":3,"CALL_DURATION":30,"SCOPE":"customer","IS_CUSTOMER_OTP":false,"IS_MERCHANT_OTP":false,"IS_SLACK_OTP":false}]
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
             * REASON_ID : 12
             * REASON_BN : কাস্টমারের কাছে টাকা না থাকায় হোল্ড  হচ্ছে
             * REASON_EN : NO_MONEY_HOLD
             * CATEGORY : hold
             * TOTAL_CALLS : 3
             * CALL_DURATION : 30
             * SCOPE : customer
             * IS_CUSTOMER_OTP : false
             * IS_MERCHANT_OTP : false
             * IS_SLACK_OTP : false
             */

            private int REASON_ID;
            private String REASON_BN;
            private String REASON_EN;
            private String CATEGORY;
            private int TOTAL_CALLS;
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

            public int getTOTAL_CALLS() {
                return TOTAL_CALLS;
            }

            public void setTOTAL_CALLS(int TOTAL_CALLS) {
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
