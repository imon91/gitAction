package services.responseModels.redxModels;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CouponsModel {

    /**
     * isError : false
     * body : {"coupons":[{"id":38,"code":"benefit_duration","name":"offerDhamaka","endDate":"2021-03-03T17:59:59.000Z","constraintRules":"","type":"retention","isFlashOffer":true,"status":"applied","redemptionMessages":[],"order":0},{"id":44,"code":"all_old","name":"offerDhamaka","endDate":"2021-03-03T18:29:59.000Z","constraintRules":"","type":"retention","isFlashOffer":true,"status":"active","redemptionMessages":[],"order":1}]}
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
        private List<CouponsBean> coupons;

        public List<CouponsBean> getCoupons() {
            return coupons;
        }

        public void setCoupons(List<CouponsBean> coupons) {
            this.coupons = coupons;
        }

        public static class CouponsBean implements Serializable {
            /**
             * id : 38
             * code : benefit_duration
             * name : offerDhamaka
             * endDate : 2021-03-03T17:59:59.000Z
             * constraintRules :
             * type : retention
             * isFlashOffer : true
             * status : applied
             * redemptionMessages : []
             * order : 0
             */

            private int id;
            private String code;
            private String name;
            private String endDate;
            private String constraintRules;
            private String type;
            private boolean isFlashOffer;
            private String status;
            private int order;
            private List<?> redemptionMessages;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getEndDate() {
                System.out.println("Value in API : " + endDate);
                endDate = endDate.replace(".000Z"," +0000");
                SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss Z");
                SimpleDateFormat formatter2=new SimpleDateFormat("MMM dd, yyyy");
                try {
                    Date date = formatter1.parse(endDate);
                    endDate = formatter2.format(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return endDate;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
            }

            public String getConstraintRules() {
                return constraintRules;
            }

            public void setConstraintRules(String constraintRules) {
                this.constraintRules = constraintRules;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public boolean isIsFlashOffer() {
                return isFlashOffer;
            }

            public void setIsFlashOffer(boolean isFlashOffer) {
                this.isFlashOffer = isFlashOffer;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public List<?> getRedemptionMessages() {
                return redemptionMessages;
            }

            public void setRedemptionMessages(List<?> redemptionMessages) {
                this.redemptionMessages = redemptionMessages;
            }
        }
    }
}
