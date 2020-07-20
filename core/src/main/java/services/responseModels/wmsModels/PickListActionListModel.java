package services.responseModels.wmsModels;

import java.io.Serializable;
import java.util.List;

public class PickListActionListModel {

    /**
     * pick_list : {"id":8230,"status":"closed","is_closable":false,"is_refresh_available":false}
     * pick_list_items : [{"id":99513,"pick_list_id":8230,"warehouse_bin_id":31,"variant_id":8186,"quantity":2,"picked_quantity":2,"status":"picked","parent_id":null,"vaccount_id":1,"created_at":"2020-07-13T12:13:03.000+06:00","updated_at":"2020-07-13T12:14:44.000+06:00","color_code":"grey","status_code":"PICKED","variant":{"sku_code":"285261","notes":"Fashionable  Full Sleeve Sweep T-Shirt 08 - Tommy - Navy Blue - DFW","attachments":[{"id":2099,"expiring_url":"http://shopvndrs.vstores.io/variant/2020-05/1573722678321-03-small"}]},"warehouse_bin":{"bin_code":"W1R1C1RA1B4"}},{"id":99514,"pick_list_id":8230,"warehouse_bin_id":31,"variant_id":8186,"quantity":1,"picked_quantity":0,"status":"missing","parent_id":99513,"vaccount_id":1,"created_at":"2020-07-13T12:14:43.000+06:00","updated_at":"2020-07-13T12:14:51.000+06:00","color_code":"red","status_code":"MISSING","variant":{"sku_code":"285261","notes":"Fashionable  Full Sleeve Sweep T-Shirt 08 - Tommy - Navy Blue - DFW","attachments":[{"id":2099,"expiring_url":"http://shopvndrs.vstores.io/variant/2020-05/1573722678321-03-small"}]},"warehouse_bin":{"bin_code":"W1R1C1RA1B4"}},{"id":99512,"pick_list_id":8230,"warehouse_bin_id":32,"variant_id":8185,"quantity":1,"picked_quantity":1,"status":"picked","parent_id":null,"vaccount_id":1,"created_at":"2020-07-13T12:13:02.000+06:00","updated_at":"2020-07-13T12:14:44.000+06:00","color_code":"grey","status_code":"PICKED","variant":{"sku_code":"285260","notes":"Fashionable  Full Sleeve Sweep T-Shirt 08 - Tommy - Navy Blue - DFW","attachments":[{"id":2098,"expiring_url":"http://shopvndrs.vstores.io/variant/2020-05/1573722678321-03-small"}]},"warehouse_bin":{"bin_code":"W1R1C1RA1B5"}},{"id":99515,"pick_list_id":8230,"warehouse_bin_id":32,"variant_id":8185,"quantity":1,"picked_quantity":0,"status":"missing","parent_id":99512,"vaccount_id":1,"created_at":"2020-07-13T12:14:44.000+06:00","updated_at":"2020-07-13T12:14:52.000+06:00","color_code":"red","status_code":"MISSING","variant":{"sku_code":"285260","notes":"Fashionable  Full Sleeve Sweep T-Shirt 08 - Tommy - Navy Blue - DFW","attachments":[{"id":2098,"expiring_url":"http://shopvndrs.vstores.io/variant/2020-05/1573722678321-03-small"}]},"warehouse_bin":{"bin_code":"W1R1C1RA1B5"}}]
     */

    private PickListBean pick_list;
    private List<PickListItemsBean> pick_list_items;

    public PickListBean getPick_list() {
        return pick_list;
    }

    public void setPick_list(PickListBean pick_list) {
        this.pick_list = pick_list;
    }

    public List<PickListItemsBean> getPick_list_items() {
        return pick_list_items;
    }

    public void setPick_list_items(List<PickListItemsBean> pick_list_items) {
        this.pick_list_items = pick_list_items;
    }

    public static class PickListBean implements Serializable {
        /**
         * id : 8230
         * status : closed
         * is_closable : false
         * is_refresh_available : false
         */

        private int id;
        private String status;
        private boolean is_closable;
        private boolean is_refresh_available;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public boolean isIs_closable() {
            return is_closable;
        }

        public void setIs_closable(boolean is_closable) {
            this.is_closable = is_closable;
        }

        public boolean isIs_refresh_available() {
            return is_refresh_available;
        }

        public void setIs_refresh_available(boolean is_refresh_available) {
            this.is_refresh_available = is_refresh_available;
        }
    }

    public static class PickListItemsBean implements Serializable {
        /**
         * id : 99513
         * pick_list_id : 8230
         * warehouse_bin_id : 31
         * variant_id : 8186
         * quantity : 2
         * picked_quantity : 2
         * status : picked
         * parent_id : null
         * vaccount_id : 1
         * created_at : 2020-07-13T12:13:03.000+06:00
         * updated_at : 2020-07-13T12:14:44.000+06:00
         * color_code : grey
         * status_code : PICKED
         * variant : {"sku_code":"285261","notes":"Fashionable  Full Sleeve Sweep T-Shirt 08 - Tommy - Navy Blue - DFW","attachments":[{"id":2099,"expiring_url":"http://shopvndrs.vstores.io/variant/2020-05/1573722678321-03-small"}]}
         * warehouse_bin : {"bin_code":"W1R1C1RA1B4"}
         */

        private int id;
        private int pick_list_id;
        private int warehouse_bin_id;
        private int variant_id;
        private int quantity;
        private int picked_quantity;
        private String status;
        private Object parent_id;
        private int vaccount_id;
        private String created_at;
        private String updated_at;
        private String color_code;
        private String status_code;
        private VariantBean variant;
        private WarehouseBinBean warehouse_bin;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPick_list_id() {
            return pick_list_id;
        }

        public void setPick_list_id(int pick_list_id) {
            this.pick_list_id = pick_list_id;
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

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getPicked_quantity() {
            return picked_quantity;
        }

        public void setPicked_quantity(int picked_quantity) {
            this.picked_quantity = picked_quantity;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Object getParent_id() {
            return parent_id;
        }

        public void setParent_id(Object parent_id) {
            this.parent_id = parent_id;
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

        public String getColor_code() {
            return color_code;
        }

        public void setColor_code(String color_code) {
            this.color_code = color_code;
        }

        public String getStatus_code() {
            return status_code;
        }

        public void setStatus_code(String status_code) {
            this.status_code = status_code;
        }

        public VariantBean getVariant() {
            return variant;
        }

        public void setVariant(VariantBean variant) {
            this.variant = variant;
        }

        public WarehouseBinBean getWarehouse_bin() {
            return warehouse_bin;
        }

        public void setWarehouse_bin(WarehouseBinBean warehouse_bin) {
            this.warehouse_bin = warehouse_bin;
        }

        public static class VariantBean implements Serializable {
            /**
             * sku_code : 285261
             * notes : Fashionable  Full Sleeve Sweep T-Shirt 08 - Tommy - Navy Blue - DFW
             * attachments : [{"id":2099,"expiring_url":"http://shopvndrs.vstores.io/variant/2020-05/1573722678321-03-small"}]
             */

            private String sku_code;
            private String notes;
            private List<AttachmentsBean> attachments;

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

            public List<AttachmentsBean> getAttachments() {
                return attachments;
            }

            public void setAttachments(List<AttachmentsBean> attachments) {
                this.attachments = attachments;
            }

            public static class AttachmentsBean implements Serializable {
                /**
                 * id : 2099
                 * expiring_url : http://shopvndrs.vstores.io/variant/2020-05/1573722678321-03-small
                 */

                private int id;
                private String expiring_url;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getExpiring_url() {
                    return expiring_url;
                }

                public void setExpiring_url(String expiring_url) {
                    this.expiring_url = expiring_url;
                }
            }
        }

        public static class WarehouseBinBean implements Serializable {
            /**
             * bin_code : W1R1C1RA1B4
             */

            private String bin_code;

            public String getBin_code() {
                return bin_code;
            }

            public void setBin_code(String bin_code) {
                this.bin_code = bin_code;
            }
        }
    }
}
