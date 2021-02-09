package services;

import java.io.Serializable;

public class OverviewModel {

    /**
     * isError : false
     * body : {"availableCredits":0,"totalOrders":11,"totalDelivered":0,"totalInTransit":11,"totalSales":0,"totalFeesPaid":0,"totalOrdersReturned":0,"totalOrdersToBeReturned":0,"totalUnpaidAmount":0,"totalPaymentProcessingAmount":0,"successfulDeliveryPercentage":0}
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
         * availableCredits : 0
         * totalOrders : 11
         * totalDelivered : 0
         * totalInTransit : 11
         * totalSales : 0
         * totalFeesPaid : 0
         * totalOrdersReturned : 0
         * totalOrdersToBeReturned : 0
         * totalUnpaidAmount : 0
         * totalPaymentProcessingAmount : 0
         * successfulDeliveryPercentage : 0
         */

        private int availableCredits;
        private int totalOrders;
        private int totalDelivered;
        private int totalInTransit;
        private float totalSales;
        private float totalFeesPaid;
        private int totalOrdersReturned;
        private int totalOrdersToBeReturned;
        private float totalUnpaidAmount;
        private float totalPaymentProcessingAmount;
        private int successfulDeliveryPercentage;

        public int getAvailableCredits() {
            return availableCredits;
        }

        public void setAvailableCredits(int availableCredits) {
            this.availableCredits = availableCredits;
        }

        public int getTotalOrders() {
            return totalOrders;
        }

        public void setTotalOrders(int totalOrders) {
            this.totalOrders = totalOrders;
        }

        public int getTotalDelivered() {
            return totalDelivered;
        }

        public void setTotalDelivered(int totalDelivered) {
            this.totalDelivered = totalDelivered;
        }

        public int getTotalInTransit() {
            return totalInTransit;
        }

        public void setTotalInTransit(int totalInTransit) {
            this.totalInTransit = totalInTransit;
        }

        public float getTotalSales() {
            return totalSales;
        }

        public void setTotalSales(float totalSales) {
            this.totalSales = totalSales;
        }

        public float getTotalFeesPaid() {
            return totalFeesPaid;
        }

        public void setTotalFeesPaid(float totalFeesPaid) {
            this.totalFeesPaid = totalFeesPaid;
        }

        public int getTotalOrdersReturned() {
            return totalOrdersReturned;
        }

        public void setTotalOrdersReturned(int totalOrdersReturned) {
            this.totalOrdersReturned = totalOrdersReturned;
        }

        public int getTotalOrdersToBeReturned() {
            return totalOrdersToBeReturned;
        }

        public void setTotalOrdersToBeReturned(int totalOrdersToBeReturned) {
            this.totalOrdersToBeReturned = totalOrdersToBeReturned;
        }

        public float getTotalUnpaidAmount() {
            return totalUnpaidAmount;
        }

        public void setTotalUnpaidAmount(float totalUnpaidAmount) {
            this.totalUnpaidAmount = totalUnpaidAmount;
        }

        public float getTotalPaymentProcessingAmount() {
            return totalPaymentProcessingAmount;
        }

        public void setTotalPaymentProcessingAmount(float totalPaymentProcessingAmount) {
            this.totalPaymentProcessingAmount = totalPaymentProcessingAmount;
        }

        public int getSuccessfulDeliveryPercentage() {
            return successfulDeliveryPercentage;
        }

        public void setSuccessfulDeliveryPercentage(int successfulDeliveryPercentage) {
            this.successfulDeliveryPercentage = successfulDeliveryPercentage;
        }
    }
}
