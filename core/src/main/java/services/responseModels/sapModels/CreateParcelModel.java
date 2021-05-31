package services.responseModels.sapModels;

import java.io.Serializable;

public class CreateParcelModel {

    /**
     * isError : false
     * body : {"parcelId":5999334,"trackingId":"21A527TH3KL46","crossDockId":3}
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
         * parcelId : 5999334
         * trackingId : 21A527TH3KL46
         * crossDockId : 3
         */

        private int parcelId;
        private String trackingId;
        private int crossDockId;

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

        public int getCrossDockId() {
            return crossDockId;
        }

        public void setCrossDockId(int crossDockId) {
            this.crossDockId = crossDockId;
        }
    }
}
