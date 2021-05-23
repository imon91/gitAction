package services.responseModels.sapModels;

import java.io.Serializable;
import java.util.List;

public class AreaHubModel {

    /**
     * isError : false
     * areas : [{"areaId":694,"areaName":"Bhaluka","hubId":17},{"areaId":695,"areaName":"Dhubaura","hubId":17},{"areaId":696,"areaName":"Fulbaria (Mymensingh","hubId":17},{"areaId":697,"areaName":"Fulpur","hubId":17},{"areaId":698,"areaName":"Goffargaon","hubId":17},{"areaId":699,"areaName":"Gouripur","hubId":17},{"areaId":700,"areaName":"Haluaghat","hubId":17},{"areaId":701,"areaName":"Iswarganj","hubId":17},{"areaId":702,"areaName":"Mymensingh Sadar","hubId":17},{"areaId":703,"areaName":"Muktagacha","hubId":17},{"areaId":704,"areaName":"Nandail","hubId":17},{"areaId":705,"areaName":"Trishal","hubId":17}]
     */

    private boolean isError;
    private List<AreasBean> areas;

    public boolean isIsError() {
        return isError;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
    }

    public List<AreasBean> getAreas() {
        return areas;
    }

    public void setAreas(List<AreasBean> areas) {
        this.areas = areas;
    }

    public static class AreasBean implements Serializable {
        /**
         * areaId : 694
         * areaName : Bhaluka
         * hubId : 17
         */

        private int areaId;
        private String areaName;
        private int hubId;

        public int getAreaId() {
            return areaId;
        }

        public void setAreaId(int areaId) {
            this.areaId = areaId;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public int getHubId() {
            return hubId;
        }

        public void setHubId(int hubId) {
            this.hubId = hubId;
        }
    }
}
