package services;

import java.io.Serializable;
import java.util.List;

public class DownloadModel {

    /**
     * isError : false
     * sheets : [{"bulkId":"kkp19nx6-fqs9","action":"dispatched-to-hub","bulkTransferId":"kkouxzq1-fqs9_02-03","totalParcels":24,"sourceHub":"Tejgaon Hub","destinationHub":"Mohakhali Hub","partnerName":"ShopUp","agentName":null,"createdAt":"2021-02-03T06:11:53.000Z"},{"bulkId":"kkouxzp5-fqs9","action":"received-from-seller","bulkTransferId":"kkouxzq1-fqs9_02-03","totalParcels":24,"sourceHub":"Tejgaon Hub","destinationHub":null,"partnerName":"ShopUp","agentName":null,"createdAt":"2021-02-03T03:14:51.000Z"}]
     */

    private boolean isError;
    private List<SheetsBean> sheets;

    public boolean isIsError() {
        return isError;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
    }

    public List<SheetsBean> getSheets() {
        return sheets;
    }

    public void setSheets(List<SheetsBean> sheets) {
        this.sheets = sheets;
    }

    public static class SheetsBean implements Serializable {
        /**
         * bulkId : kkp19nx6-fqs9
         * action : dispatched-to-hub
         * bulkTransferId : kkouxzq1-fqs9_02-03
         * totalParcels : 24
         * sourceHub : Tejgaon Hub
         * destinationHub : Mohakhali Hub
         * partnerName : ShopUp
         * agentName : null
         * createdAt : 2021-02-03T06:11:53.000Z
         */

        private String bulkId;
        private String action;
        private String bulkTransferId;
        private int totalParcels;
        private String sourceHub;
        private String destinationHub;
        private String partnerName;
        private Object agentName;
        private String createdAt;

        public String getBulkId() {
            return bulkId;
        }

        public void setBulkId(String bulkId) {
            this.bulkId = bulkId;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getBulkTransferId() {
            return bulkTransferId;
        }

        public void setBulkTransferId(String bulkTransferId) {
            this.bulkTransferId = bulkTransferId;
        }

        public int getTotalParcels() {
            return totalParcels;
        }

        public void setTotalParcels(int totalParcels) {
            this.totalParcels = totalParcels;
        }

        public String getSourceHub() {
            return sourceHub;
        }

        public void setSourceHub(String sourceHub) {
            this.sourceHub = sourceHub;
        }

        public String getDestinationHub() {
            return destinationHub;
        }

        public void setDestinationHub(String destinationHub) {
            this.destinationHub = destinationHub;
        }

        public String getPartnerName() {
            return partnerName;
        }

        public void setPartnerName(String partnerName) {
            this.partnerName = partnerName;
        }

        public Object getAgentName() {
            return agentName;
        }

        public void setAgentName(Object agentName) {
            this.agentName = agentName;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }
    }
}
