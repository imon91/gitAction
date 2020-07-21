package services.responseModels.wmsModels;

import java.io.Serializable;
import java.util.List;

public class SellersListModel {

    /**
     * id : 3
     * name : Shishang
     * vaccount_id : 1
     * created_at : 2018-01-23T16:34:46.000+06:00
     * updated_at : 2018-01-23T16:34:46.000+06:00
     * supplier_id : null
     * seller_warehouse_mappings : [{"id":2,"seller_id":3,"warehouse_id":1,"gst_number":"29AAZCS1672G1ZN","active":true,"vaccount_id":1,"created_at":"2018-01-23T16:34:46.000+06:00","updated_at":"2018-01-23T16:34:46.000+06:00","warehouse":{"code":"FLYGUD_BNGLR"}},{"id":3,"seller_id":3,"warehouse_id":3,"gst_number":"29AAZCS1672G1ZN","active":true,"vaccount_id":1,"created_at":"2019-03-07T17:20:09.000+06:00","updated_at":"2019-03-07T17:20:09.000+06:00","warehouse":{"code":"shishang"}},{"id":5,"seller_id":3,"warehouse_id":5,"gst_number":"29AAZCS1672G1ZN","active":true,"vaccount_id":1,"created_at":"2019-05-09T19:18:03.000+06:00","updated_at":"2019-05-09T19:18:03.000+06:00","warehouse":{"code":"KGP"}},{"id":7,"seller_id":3,"warehouse_id":6,"gst_number":"29AAZCS1672G1ZN","active":true,"vaccount_id":1,"created_at":"2019-07-19T16:30:24.000+06:00","updated_at":"2019-07-19T16:30:24.000+06:00","warehouse":{"code":"MTK_STORE"}},{"id":8,"seller_id":3,"warehouse_id":9,"gst_number":"29AAZCS1672G1ZN","active":true,"vaccount_id":1,"created_at":"2019-07-19T16:35:11.000+06:00","updated_at":"2019-07-19T16:35:11.000+06:00","warehouse":{"code":"MAL_STORE"}}]
     * seller_market_place_mappings : [{"id":2,"seller_id":3,"market_place_id":1,"user_id":260888716,"vaccount_id":1,"created_at":"2018-01-23T16:34:46.000+06:00","updated_at":"2018-01-23T16:34:46.000+06:00","market_place":{"name":"Voonik"}}]
     */

    private int id;
    private String name;
    private int vaccount_id;
    private String created_at;
    private String updated_at;
    private Object supplier_id;
    private List<SellerWarehouseMappingsBean> seller_warehouse_mappings;
    private List<SellerMarketPlaceMappingsBean> seller_market_place_mappings;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVaccount_id() {
        return vaccount_id;
    }

    public void setVaccount_id(int vaccount_id) {
        this.vaccount_id = vaccount_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Object getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(Object supplier_id) {
        this.supplier_id = supplier_id;
    }

    public List<SellerWarehouseMappingsBean> getSeller_warehouse_mappings() {
        return seller_warehouse_mappings;
    }

    public void setSeller_warehouse_mappings(List<SellerWarehouseMappingsBean> seller_warehouse_mappings) {
        this.seller_warehouse_mappings = seller_warehouse_mappings;
    }

    public List<SellerMarketPlaceMappingsBean> getSeller_market_place_mappings() {
        return seller_market_place_mappings;
    }

    public void setSeller_market_place_mappings(List<SellerMarketPlaceMappingsBean> seller_market_place_mappings) {
        this.seller_market_place_mappings = seller_market_place_mappings;
    }

    public static class SellerWarehouseMappingsBean implements Serializable {
        /**
         * id : 2
         * seller_id : 3
         * warehouse_id : 1
         * gst_number : 29AAZCS1672G1ZN
         * active : true
         * vaccount_id : 1
         * created_at : 2018-01-23T16:34:46.000+06:00
         * updated_at : 2018-01-23T16:34:46.000+06:00
         * warehouse : {"code":"FLYGUD_BNGLR"}
         */

        private int id;
        private int seller_id;
        private int warehouse_id;
        private String gst_number;
        private boolean active;
        private int vaccount_id;
        private String created_at;
        private String updated_at;
        private WarehouseBean warehouse;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSeller_id() {
            return seller_id;
        }

        public void setSeller_id(int seller_id) {
            this.seller_id = seller_id;
        }

        public int getWarehouse_id() {
            return warehouse_id;
        }

        public void setWarehouse_id(int warehouse_id) {
            this.warehouse_id = warehouse_id;
        }

        public String getGst_number() {
            return gst_number;
        }

        public void setGst_number(String gst_number) {
            this.gst_number = gst_number;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        public int getVaccount_id() {
            return vaccount_id;
        }

        public void setVaccount_id(int vaccount_id) {
            this.vaccount_id = vaccount_id;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public WarehouseBean getWarehouse() {
            return warehouse;
        }

        public void setWarehouse(WarehouseBean warehouse) {
            this.warehouse = warehouse;
        }

        public static class WarehouseBean implements Serializable {
            /**
             * code : FLYGUD_BNGLR
             */

            private String code;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }
        }
    }

    public static class SellerMarketPlaceMappingsBean implements Serializable {
        /**
         * id : 2
         * seller_id : 3
         * market_place_id : 1
         * user_id : 260888716
         * vaccount_id : 1
         * created_at : 2018-01-23T16:34:46.000+06:00
         * updated_at : 2018-01-23T16:34:46.000+06:00
         * market_place : {"name":"Voonik"}
         */

        private int id;
        private int seller_id;
        private int market_place_id;
        private int user_id;
        private int vaccount_id;
        private String created_at;
        private String updated_at;
        private MarketPlaceBean market_place;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSeller_id() {
            return seller_id;
        }

        public void setSeller_id(int seller_id) {
            this.seller_id = seller_id;
        }

        public int getMarket_place_id() {
            return market_place_id;
        }

        public void setMarket_place_id(int market_place_id) {
            this.market_place_id = market_place_id;
        }

        public String  getUser_id() {
            return String.valueOf(user_id);
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getVaccount_id() {
            return vaccount_id;
        }

        public void setVaccount_id(int vaccount_id) {
            this.vaccount_id = vaccount_id;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public MarketPlaceBean getMarket_place() {
            return market_place;
        }

        public void setMarket_place(MarketPlaceBean market_place) {
            this.market_place = market_place;
        }

        public static class MarketPlaceBean implements Serializable {
            /**
             * name : Voonik
             */

            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
