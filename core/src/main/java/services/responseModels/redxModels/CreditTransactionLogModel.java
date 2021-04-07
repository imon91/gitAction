package services.responseModels.redxModels;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CreditTransactionLogModel {

    /**
     * isError : false
     * body : {"totalCount":3,"transactionLog":[{"id":43,"shopId":648299,"transactionType":"credit","eventType":"promotion","amount":200,"logisticsInvoiceId":null,"description":null,"createdAt":"2021-03-28T10:39:58.000Z","updatedAt":"2021-03-28T10:39:58.000Z"},{"id":44,"shopId":648299,"transactionType":"credit","eventType":"anniversary_campaign","amount":100,"logisticsInvoiceId":null,"description":null,"createdAt":"2021-03-28T10:40:36.000Z","updatedAt":"2021-03-28T10:42:10.000Z"},{"id":45,"shopId":648299,"transactionType":"debit","eventType":"delivery_cod_charge_deduction","amount":50,"logisticsInvoiceId":null,"description":null,"createdAt":"2021-03-28T10:41:45.000Z","updatedAt":"2021-03-28T10:41:45.000Z"}]}
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
         * totalCount : 3
         * transactionLog : [{"id":43,"shopId":648299,"transactionType":"credit","eventType":"promotion","amount":200,"logisticsInvoiceId":null,"description":null,"createdAt":"2021-03-28T10:39:58.000Z","updatedAt":"2021-03-28T10:39:58.000Z"},{"id":44,"shopId":648299,"transactionType":"credit","eventType":"anniversary_campaign","amount":100,"logisticsInvoiceId":null,"description":null,"createdAt":"2021-03-28T10:40:36.000Z","updatedAt":"2021-03-28T10:42:10.000Z"},{"id":45,"shopId":648299,"transactionType":"debit","eventType":"delivery_cod_charge_deduction","amount":50,"logisticsInvoiceId":null,"description":null,"createdAt":"2021-03-28T10:41:45.000Z","updatedAt":"2021-03-28T10:41:45.000Z"}]
         */

        private int totalCount;
        private List<TransactionLogBean> transactionLog;

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public List<TransactionLogBean> getTransactionLog() {
            return transactionLog;
        }

        public void setTransactionLog(List<TransactionLogBean> transactionLog) {
            this.transactionLog = transactionLog;
        }

        public static class TransactionLogBean implements Serializable {
            /**
             * id : 43
             * shopId : 648299
             * transactionType : credit
             * eventType : promotion
             * amount : 200
             * logisticsInvoiceId : null
             * description : null
             * createdAt : 2021-03-28T10:39:58.000Z
             * updatedAt : 2021-03-28T10:39:58.000Z
             */

            private int id;
            private int shopId;
            private String transactionType;
            private String eventType;
            private int amount;
            private Object logisticsInvoiceId;
            private Object description;
            private String createdAt;
            private String updatedAt;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getShopId() {
                return shopId;
            }

            public void setShopId(int shopId) {
                this.shopId = shopId;
            }

            public String getTransactionType() {
                return transactionType;
            }

            public void setTransactionType(String transactionType) {
                this.transactionType = transactionType;
            }

            public String getEventType() {
                return eventType;
            }

            public void setEventType(String eventType) {
                this.eventType = eventType;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public Object getLogisticsInvoiceId() {
                return logisticsInvoiceId;
            }

            public void setLogisticsInvoiceId(Object logisticsInvoiceId) {
                this.logisticsInvoiceId = logisticsInvoiceId;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public String getCreatedAt() {
                System.out.println("Value in API : " + createdAt);
                createdAt = createdAt.replace(".000Z"," +0000");
                SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss Z");
                SimpleDateFormat formatter2=new SimpleDateFormat("MMM dd, yyyy");
                try {
                    Date date = formatter1.parse(createdAt);
                    createdAt = formatter2.format(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }
        }
    }
}
