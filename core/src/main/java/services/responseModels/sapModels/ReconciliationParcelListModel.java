package services.responseModels.sapModels;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReconciliationParcelListModel {

    /**
     * isError : false
     * data : [{"id":3662,"parcelId":5983119,"trackingId":"21A314SU3K8LR","agentId":2638,"hubId":1,"closingStatus":"delivery-payment-collected","closingTime":"2021-03-14T08:48:57.000Z","createdAt":"2021-03-14T08:41:47.000Z","updatedAt":"2021-03-14T08:48:58.000Z"},{"id":3663,"parcelId":5983120,"trackingId":"21A314SU3K8LS","agentId":2638,"hubId":1,"closingStatus":"delivery-payment-collected","closingTime":"2021-03-14T08:48:57.000Z","createdAt":"2021-03-14T08:41:47.000Z","updatedAt":"2021-03-14T08:48:58.000Z"}]
     */

    private boolean isError;
    private List<DataBean> data;

    public boolean isIsError() {
        return isError;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * id : 3662
         * parcelId : 5983119
         * trackingId : 21A314SU3K8LR
         * agentId : 2638
         * hubId : 1
         * closingStatus : delivery-payment-collected
         * closingTime : 2021-03-14T08:48:57.000Z
         * createdAt : 2021-03-14T08:41:47.000Z
         * updatedAt : 2021-03-14T08:48:58.000Z
         */

        private int id;
        private int parcelId;
        private String trackingId;
        private int agentId;
        private int hubId;
        private String closingStatus;
        private String closingTime;
        private String createdAt;
        private String updatedAt;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getParcelId() {
            return parcelId;
        }

        public void setParcelId(int parcelId) {
            this.parcelId = parcelId;
        }

        public String getTrackingId() {
            return trackingId;
        }

        public void setTrackingId(String trackingId) {
            this.trackingId = trackingId;
        }

        public int getAgentId() {
            return agentId;
        }

        public void setAgentId(int agentId) {
            this.agentId = agentId;
        }

        public int getHubId() {
            return hubId;
        }

        public void setHubId(int hubId) {
            this.hubId = hubId;
        }

        public String getClosingStatus() {
            return closingStatus;
        }

        public void setClosingStatus(String closingStatus) {
            this.closingStatus = closingStatus;
        }

        public String getClosingTime() {
            closingTime = closingTime.replace(".000Z"," +0000");
            SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss Z");
            SimpleDateFormat formatter2=new SimpleDateFormat("yyyy-MM-dd HH:mm");
            SimpleDateFormat formatter3=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date date = formatter1.parse(closingTime);
                closingTime = formatter2.format(date);
//                System.out.println("Current Date Time API : " + formatter3.format(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return closingTime;
        }

        public void setClosingTime(String closingTime) {
            this.closingTime = closingTime;
        }

        public String getCreatedAt() {
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
