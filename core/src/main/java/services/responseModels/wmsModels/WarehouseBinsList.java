package services.responseModels.wmsModels;

import java.io.Serializable;
import java.util.List;

public class WarehouseBinsList {

    /**
     * id : 28
     * warehouse_id : 2
     * zone_type : 10
     * bin_type : 20
     * floor_id : 0
     * row_id : 1
     * column_id : 1
     * rack_id : 1
     * bin_id : 1
     * bin_code : W1R1C1RA1B1
     * capacity : 40
     * packages_assignable : 39
     * active : true
     * vaccount_id : 1
     * created_at : 2018-01-23T16:20:27.000+06:00
     * updated_at : 2020-06-15T16:06:22.000+06:00
     * zone_type_name : SALABLE
     * bin_type_name : MULTIPLE_VARIANT
     * bin_details : [{"id":11662,"warehouse_bin_id":28,"variant_id":7691,"orders_assignable":0,"vaccount_id":1,"created_at":"2020-04-28T11:34:28.000+06:00","updated_at":"2020-05-11T09:11:19.000+06:00","bin_data":{"in_bin_count":0,"pkg_assigned_count":0,"order_assigned_count":0},"variant":{"id":7691,"seller_id":28,"category_id":1892,"sku_code":"293544","notes":"Toothbrush Wall Mount Holder-1pcs - IPC","price":"150.0","mrp":"180.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-04-21T14:53:56.000+06:00","updated_at":"2020-04-21T14:53:56.000+06:00"}},{"id":11663,"warehouse_bin_id":28,"variant_id":7689,"orders_assignable":0,"vaccount_id":1,"created_at":"2020-04-28T11:34:47.000+06:00","updated_at":"2020-05-06T09:53:02.000+06:00","bin_data":{"in_bin_count":0,"pkg_assigned_count":0,"order_assigned_count":0},"variant":{"id":7689,"seller_id":28,"category_id":1892,"sku_code":"293542","notes":"Super Cosmetics Packaging Travel Bottle Set-Pink - IPC","price":"170.0","mrp":"210.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-04-21T14:53:55.000+06:00","updated_at":"2020-05-21T21:24:23.000+06:00"}},{"id":11664,"warehouse_bin_id":28,"variant_id":7656,"orders_assignable":0,"vaccount_id":1,"created_at":"2020-04-28T11:43:53.000+06:00","updated_at":"2020-04-28T11:44:04.000+06:00","bin_data":{"in_bin_count":0,"pkg_assigned_count":0,"order_assigned_count":0},"variant":{"id":7656,"seller_id":28,"category_id":1892,"sku_code":"293098","notes":"Folding Travel Bag - IPC","price":"320.0","mrp":"384.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-04-21T14:53:27.000+06:00","updated_at":"2020-04-21T14:53:27.000+06:00"}},{"id":11677,"warehouse_bin_id":28,"variant_id":7654,"orders_assignable":0,"vaccount_id":1,"created_at":"2020-05-10T15:17:26.000+06:00","updated_at":"2020-05-11T09:11:19.000+06:00","bin_data":{"in_bin_count":0,"pkg_assigned_count":0,"order_assigned_count":0},"variant":{"id":7654,"seller_id":28,"category_id":1892,"sku_code":"293092","notes":"Fish Cutter - Green - IPC","price":"145.0","mrp":"1550.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-04-21T14:53:25.000+06:00","updated_at":"2020-05-04T15:59:27.000+06:00"}},{"id":11689,"warehouse_bin_id":28,"variant_id":8761,"orders_assignable":1,"vaccount_id":1,"created_at":"2020-05-27T22:12:56.000+06:00","updated_at":"2020-06-03T15:45:03.000+06:00","bin_data":{"in_bin_count":0,"pkg_assigned_count":0,"order_assigned_count":0},"variant":{"id":8761,"seller_id":31,"category_id":1892,"sku_code":"1736--293098","notes":"Folding Travel Bag - IPC","price":"320.0","mrp":"384.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-27T13:15:11.000+06:00","updated_at":"2020-05-27T13:15:11.000+06:00"}},{"id":11691,"warehouse_bin_id":28,"variant_id":8905,"orders_assignable":0,"vaccount_id":1,"created_at":"2020-05-27T22:32:51.000+06:00","updated_at":"2020-06-03T15:45:04.000+06:00","bin_data":{"in_bin_count":0,"pkg_assigned_count":0,"order_assigned_count":0},"variant":{"id":8905,"seller_id":31,"category_id":1892,"sku_code":"1736--293542","notes":"Super Cosmetics Packaging Travel Bottle Set-Pink - IPC","price":"175.0","mrp":"210.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-27T22:31:49.000+06:00","updated_at":"2020-05-27T22:31:49.000+06:00"}}]
     */

    private int id;
    private int warehouse_id;
    private int zone_type;
    private int bin_type;
    private int floor_id;
    private int row_id;
    private int column_id;
    private int rack_id;
    private int bin_id;
    private String bin_code;
    private int capacity;
    private int packages_assignable;
    private boolean active;
    private int vaccount_id;
    private String created_at;
    private String updated_at;
    private String zone_type_name;
    private String bin_type_name;
    private List<BinDetailsBean> bin_details;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(int warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public int getZone_type() {
        return zone_type;
    }

    public void setZone_type(int zone_type) {
        this.zone_type = zone_type;
    }

    public int getBin_type() {
        return bin_type;
    }

    public void setBin_type(int bin_type) {
        this.bin_type = bin_type;
    }

    public int getFloor_id() {
        return floor_id;
    }

    public void setFloor_id(int floor_id) {
        this.floor_id = floor_id;
    }

    public int getRow_id() {
        return row_id;
    }

    public void setRow_id(int row_id) {
        this.row_id = row_id;
    }

    public int getColumn_id() {
        return column_id;
    }

    public void setColumn_id(int column_id) {
        this.column_id = column_id;
    }

    public int getRack_id() {
        return rack_id;
    }

    public void setRack_id(int rack_id) {
        this.rack_id = rack_id;
    }

    public int getBin_id() {
        return bin_id;
    }

    public void setBin_id(int bin_id) {
        this.bin_id = bin_id;
    }

    public String getBin_code() {
        return bin_code;
    }

    public void setBin_code(String bin_code) {
        this.bin_code = bin_code;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPackages_assignable() {
        return packages_assignable;
    }

    public void setPackages_assignable(int packages_assignable) {
        this.packages_assignable = packages_assignable;
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

    public String getZone_type_name() {
        return zone_type_name;
    }

    public void setZone_type_name(String zone_type_name) {
        this.zone_type_name = zone_type_name;
    }

    public String getBin_type_name() {
        return bin_type_name;
    }

    public void setBin_type_name(String bin_type_name) {
        this.bin_type_name = bin_type_name;
    }

    public List<BinDetailsBean> getBin_details() {
        return bin_details;
    }

    public void setBin_details(List<BinDetailsBean> bin_details) {
        this.bin_details = bin_details;
    }

    public static class BinDetailsBean implements Serializable {
        /**
         * id : 11662
         * warehouse_bin_id : 28
         * variant_id : 7691
         * orders_assignable : 0
         * vaccount_id : 1
         * created_at : 2020-04-28T11:34:28.000+06:00
         * updated_at : 2020-05-11T09:11:19.000+06:00
         * bin_data : {"in_bin_count":0,"pkg_assigned_count":0,"order_assigned_count":0}
         * variant : {"id":7691,"seller_id":28,"category_id":1892,"sku_code":"293544","notes":"Toothbrush Wall Mount Holder-1pcs - IPC","price":"150.0","mrp":"180.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-04-21T14:53:56.000+06:00","updated_at":"2020-04-21T14:53:56.000+06:00"}
         */

        private int id;
        private int warehouse_bin_id;
        private int variant_id;
        private int orders_assignable;
        private int vaccount_id;
        private String created_at;
        private String updated_at;
        private BinDataBean bin_data;
        private VariantBean variant;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getWarehouse_bin_id() {
            return warehouse_bin_id;
        }

        public void setWarehouse_bin_id(int warehouse_bin_id) {
            this.warehouse_bin_id = warehouse_bin_id;
        }

        public int getVariant_id() {
            return variant_id;
        }

        public void setVariant_id(int variant_id) {
            this.variant_id = variant_id;
        }

        public int getOrders_assignable() {
            return orders_assignable;
        }

        public void setOrders_assignable(int orders_assignable) {
            this.orders_assignable = orders_assignable;
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

        public BinDataBean getBin_data() {
            return bin_data;
        }

        public void setBin_data(BinDataBean bin_data) {
            this.bin_data = bin_data;
        }

        public VariantBean getVariant() {
            return variant;
        }

        public void setVariant(VariantBean variant) {
            this.variant = variant;
        }

        public static class BinDataBean implements Serializable {
            /**
             * in_bin_count : 0
             * pkg_assigned_count : 0
             * order_assigned_count : 0
             */

            private int in_bin_count;
            private int pkg_assigned_count;
            private int order_assigned_count;

            public int getIn_bin_count() {
                return in_bin_count;
            }

            public void setIn_bin_count(int in_bin_count) {
                this.in_bin_count = in_bin_count;
            }

            public int getPkg_assigned_count() {
                return pkg_assigned_count;
            }

            public void setPkg_assigned_count(int pkg_assigned_count) {
                this.pkg_assigned_count = pkg_assigned_count;
            }

            public int getOrder_assigned_count() {
                return order_assigned_count;
            }

            public void setOrder_assigned_count(int order_assigned_count) {
                this.order_assigned_count = order_assigned_count;
            }
        }

        public static class VariantBean implements Serializable {
            /**
             * id : 7691
             * seller_id : 28
             * category_id : 1892
             * sku_code : 293544
             * notes : Toothbrush Wall Mount Holder-1pcs - IPC
             * price : 150.0
             * mrp : 180.0
             * reorder_point : 20
             * active : true
             * vaccount_id : 1
             * created_at : 2020-04-21T14:53:56.000+06:00
             * updated_at : 2020-04-21T14:53:56.000+06:00
             */

            private int id;
            private int seller_id;
            private int category_id;
            private String sku_code;
            private String notes;
            private String price;
            private String mrp;
            private int reorder_point;
            private boolean active;
            private int vaccount_id;
            private String created_at;
            private String updated_at;

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

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public String getSku_code() {
                return sku_code;
            }

            public void setSku_code(String sku_code) {
                this.sku_code = sku_code;
            }

            public String getNotes() {
                return notes;
            }

            public void setNotes(String notes) {
                this.notes = notes;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getMrp() {
                return mrp;
            }

            public void setMrp(String mrp) {
                this.mrp = mrp;
            }

            public int getReorder_point() {
                return reorder_point;
            }

            public void setReorder_point(int reorder_point) {
                this.reorder_point = reorder_point;
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
        }
    }
}
