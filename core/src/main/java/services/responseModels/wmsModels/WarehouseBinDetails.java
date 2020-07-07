package services.responseModels.wmsModels;

import java.io.Serializable;
import java.util.List;

public class WarehouseBinDetails {

    /**
     * success : true
     * bin_code : W100F2R1C1RA4B71
     * package_details : [{"id":null,"sku_code":"139744","count":3,"package_ids":"135979,135980,135981"},{"id":null,"sku_code":"151233","count":1,"package_ids":"135972"}]
     */

    private boolean success;
    private String bin_code;
    private List<PackageDetailsBean> package_details;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getBin_code() {
        return bin_code;
    }

    public void setBin_code(String bin_code) {
        this.bin_code = bin_code;
    }

    public List<PackageDetailsBean> getPackage_details() {
        return package_details;
    }

    public void setPackage_details(List<PackageDetailsBean> package_details) {
        this.package_details = package_details;
    }

    public static class PackageDetailsBean implements Serializable {
        /**
         * id : null
         * sku_code : 139744
         * count : 3
         * package_ids : 135979,135980,135981
         */

        private Object id;
        private String sku_code;
        private int count;
        private String package_ids;

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public String getSku_code() {
            return sku_code;
        }

        public void setSku_code(String sku_code) {
            this.sku_code = sku_code;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getPackage_ids() {
            return package_ids;
        }

        public void setPackage_ids(String package_ids) {
            this.package_ids = package_ids;
        }
    }
}
