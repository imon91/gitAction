package services.responseModels.wmsModels;

import java.io.Serializable;
import java.util.List;

public class PurchaseOrderDetailsModel {

    /**
     * id : 217479
     * seller_id : 29
     * supplier_id : 144
     * supplier_address_id : 56
     * warehouse_id : 100
     * status : received
     * po_type : forward
     * vaccount_id : 1
     * created_at : 2020-07-09T12:28:06.000+06:00
     * updated_at : 2020-07-09T12:28:25.000+06:00
     * inward_details : {"ordered_quantity":26,"in_scanned":25,"qc_scanned":25}
     * purchase_order_line_items : [{"id":158000,"purchase_order_id":217479,"variant_id":8214,"ordered_quantity":9,"unit_price":"349.0","vaccount_id":1,"created_at":"2020-07-09T12:28:06.000+06:00","updated_at":"2020-07-09T12:28:06.000+06:00","inward_details":{"in_scanned":0,"qc_passed":0,"qc_failed":0,"on_hold":0,"qc_scanned":0},"receivable_quantity":0,"variant":{"id":8214,"seller_id":29,"category_id":1892,"sku_code":"285326","notes":"Fashionable  Full Sleeve Sweep T-Shirt 13 - Tommy - Red - DFW","price":"349.0","mrp":"380.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-17T20:35:46.000+06:00","updated_at":"2020-05-17T20:35:46.000+06:00","attachments":[{"id":2127,"attachable_type":"Variant","attachable_id":8214,"label_file_name":"1573724586924-18-small.jpg","label_content_type":"image/jpeg","label_file_size":3275,"vaccount_id":1,"created_at":"2020-05-17T20:35:46.000+06:00","updated_at":"2020-05-17T20:35:46.000+06:00","expiring_url":"http://shopvndrs.vstores.io/variant/2020-05/1573724586924-18-small"}]}},{"id":158001,"purchase_order_id":217479,"variant_id":8215,"ordered_quantity":10,"unit_price":"349.0","vaccount_id":1,"created_at":"2020-07-09T12:28:06.000+06:00","updated_at":"2020-07-09T12:28:06.000+06:00","inward_details":{"in_scanned":0,"qc_passed":0,"qc_failed":0,"on_hold":0,"qc_scanned":0},"receivable_quantity":0,"variant":{"id":8215,"seller_id":29,"category_id":1892,"sku_code":"285361","notes":"Fashionable  Full Sleeve Sweep T-Shirt 13 - Tommy - Red - DFW","price":"349.0","mrp":"380.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-17T20:35:46.000+06:00","updated_at":"2020-05-17T20:35:46.000+06:00","attachments":[{"id":2128,"attachable_type":"Variant","attachable_id":8215,"label_file_name":"1573724586924-18-small.jpg","label_content_type":"image/jpeg","label_file_size":3275,"vaccount_id":1,"created_at":"2020-05-17T20:35:47.000+06:00","updated_at":"2020-05-17T20:35:47.000+06:00","expiring_url":"http://shopvndrs.vstores.io/variant/2020-05/1573724586924-18-small"}]}},{"id":158002,"purchase_order_id":217479,"variant_id":8216,"ordered_quantity":7,"unit_price":"349.0","vaccount_id":1,"created_at":"2020-07-09T12:28:06.000+06:00","updated_at":"2020-07-09T12:28:06.000+06:00","inward_details":{"in_scanned":0,"qc_passed":0,"qc_failed":0,"on_hold":0,"qc_scanned":0},"receivable_quantity":0,"variant":{"id":8216,"seller_id":29,"category_id":1892,"sku_code":"285362","notes":"Fashionable  Full Sleeve Sweep T-Shirt 13 - Tommy - Red - DFW","price":"349.0","mrp":"380.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-17T20:35:47.000+06:00","updated_at":"2020-05-17T20:35:47.000+06:00","attachments":[{"id":2129,"attachable_type":"Variant","attachable_id":8216,"label_file_name":"1573724586924-18-small.jpg","label_content_type":"image/jpeg","label_file_size":3275,"vaccount_id":1,"created_at":"2020-05-17T20:35:47.000+06:00","updated_at":"2020-05-17T20:35:47.000+06:00","expiring_url":"http://shopvndrs.vstores.io/variant/2020-05/1573724586924-18-small"}]}}]
     */

    private int id;
    private int seller_id;
    private int supplier_id;
    private int supplier_address_id;
    private int warehouse_id;
    private String status;
    private String po_type;
    private int vaccount_id;
    private String created_at;
    private String updated_at;
    private InwardDetailsBean inward_details;
    private List<PurchaseOrderLineItemsBean> purchase_order_line_items;

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

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public int getSupplier_address_id() {
        return supplier_address_id;
    }

    public void setSupplier_address_id(int supplier_address_id) {
        this.supplier_address_id = supplier_address_id;
    }

    public int getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(int warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPo_type() {
        return po_type;
    }

    public void setPo_type(String po_type) {
        this.po_type = po_type;
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

    public InwardDetailsBean getInward_details() {
        return inward_details;
    }

    public void setInward_details(InwardDetailsBean inward_details) {
        this.inward_details = inward_details;
    }

    public List<PurchaseOrderLineItemsBean> getPurchase_order_line_items() {
        return purchase_order_line_items;
    }

    public void setPurchase_order_line_items(List<PurchaseOrderLineItemsBean> purchase_order_line_items) {
        this.purchase_order_line_items = purchase_order_line_items;
    }

    public static class InwardDetailsBean implements Serializable {
        /**
         * ordered_quantity : 26
         * in_scanned : 25
         * qc_scanned : 25
         */

        private int ordered_quantity;
        private int in_scanned;
        private int qc_scanned;

        public int getOrdered_quantity() {
            return ordered_quantity;
        }

        public void setOrdered_quantity(int ordered_quantity) {
            this.ordered_quantity = ordered_quantity;
        }

        public int getIn_scanned() {
            return in_scanned;
        }

        public void setIn_scanned(int in_scanned) {
            this.in_scanned = in_scanned;
        }

        public int getQc_scanned() {
            return qc_scanned;
        }

        public void setQc_scanned(int qc_scanned) {
            this.qc_scanned = qc_scanned;
        }
    }

    public static class PurchaseOrderLineItemsBean implements Serializable {
        /**
         * id : 158000
         * purchase_order_id : 217479
         * variant_id : 8214
         * ordered_quantity : 9
         * unit_price : 349.0
         * vaccount_id : 1
         * created_at : 2020-07-09T12:28:06.000+06:00
         * updated_at : 2020-07-09T12:28:06.000+06:00
         * inward_details : {"in_scanned":0,"qc_passed":0,"qc_failed":0,"on_hold":0,"qc_scanned":0}
         * receivable_quantity : 0
         * variant : {"id":8214,"seller_id":29,"category_id":1892,"sku_code":"285326","notes":"Fashionable  Full Sleeve Sweep T-Shirt 13 - Tommy - Red - DFW","price":"349.0","mrp":"380.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-17T20:35:46.000+06:00","updated_at":"2020-05-17T20:35:46.000+06:00","attachments":[{"id":2127,"attachable_type":"Variant","attachable_id":8214,"label_file_name":"1573724586924-18-small.jpg","label_content_type":"image/jpeg","label_file_size":3275,"vaccount_id":1,"created_at":"2020-05-17T20:35:46.000+06:00","updated_at":"2020-05-17T20:35:46.000+06:00","expiring_url":"http://shopvndrs.vstores.io/variant/2020-05/1573724586924-18-small"}]}
         */

        private int id;
        private int purchase_order_id;
        private int variant_id;
        private int ordered_quantity;
        private String unit_price;
        private int vaccount_id;
        private String created_at;
        private String updated_at;
        private InwardDetailsBeanX inward_details;
        private int receivable_quantity;
        private VariantBean variant;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPurchase_order_id() {
            return purchase_order_id;
        }

        public void setPurchase_order_id(int purchase_order_id) {
            this.purchase_order_id = purchase_order_id;
        }

        public int getVariant_id() {
            return variant_id;
        }

        public void setVariant_id(int variant_id) {
            this.variant_id = variant_id;
        }

        public int getOrdered_quantity() {
            return ordered_quantity;
        }

        public void setOrdered_quantity(int ordered_quantity) {
            this.ordered_quantity = ordered_quantity;
        }

        public String getUnit_price() {
            return unit_price;
        }

        public void setUnit_price(String unit_price) {
            this.unit_price = unit_price;
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

        public InwardDetailsBeanX getInward_details() {
            return inward_details;
        }

        public void setInward_details(InwardDetailsBeanX inward_details) {
            this.inward_details = inward_details;
        }

        public int getReceivable_quantity() {
            return receivable_quantity;
        }

        public void setReceivable_quantity(int receivable_quantity) {
            this.receivable_quantity = receivable_quantity;
        }

        public VariantBean getVariant() {
            return variant;
        }

        public void setVariant(VariantBean variant) {
            this.variant = variant;
        }

        public static class InwardDetailsBeanX implements Serializable {
            /**
             * in_scanned : 0
             * qc_passed : 0
             * qc_failed : 0
             * on_hold : 0
             * qc_scanned : 0
             */

            private int in_scanned;
            private int qc_passed;
            private int qc_failed;
            private int on_hold;
            private int qc_scanned;

            public int getIn_scanned() {
                return in_scanned;
            }

            public void setIn_scanned(int in_scanned) {
                this.in_scanned = in_scanned;
            }

            public int getQc_passed() {
                return qc_passed;
            }

            public void setQc_passed(int qc_passed) {
                this.qc_passed = qc_passed;
            }

            public int getQc_failed() {
                return qc_failed;
            }

            public void setQc_failed(int qc_failed) {
                this.qc_failed = qc_failed;
            }

            public int getOn_hold() {
                return on_hold;
            }

            public void setOn_hold(int on_hold) {
                this.on_hold = on_hold;
            }

            public int getQc_scanned() {
                return qc_scanned;
            }

            public void setQc_scanned(int qc_scanned) {
                this.qc_scanned = qc_scanned;
            }
        }

        public static class VariantBean implements Serializable {
            /**
             * id : 8214
             * seller_id : 29
             * category_id : 1892
             * sku_code : 285326
             * notes : Fashionable  Full Sleeve Sweep T-Shirt 13 - Tommy - Red - DFW
             * price : 349.0
             * mrp : 380.0
             * reorder_point : 20
             * active : true
             * vaccount_id : 1
             * created_at : 2020-05-17T20:35:46.000+06:00
             * updated_at : 2020-05-17T20:35:46.000+06:00
             * attachments : [{"id":2127,"attachable_type":"Variant","attachable_id":8214,"label_file_name":"1573724586924-18-small.jpg","label_content_type":"image/jpeg","label_file_size":3275,"vaccount_id":1,"created_at":"2020-05-17T20:35:46.000+06:00","updated_at":"2020-05-17T20:35:46.000+06:00","expiring_url":"http://shopvndrs.vstores.io/variant/2020-05/1573724586924-18-small"}]
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
            private List<AttachmentsBean> attachments;

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

            public List<AttachmentsBean> getAttachments() {
                return attachments;
            }

            public void setAttachments(List<AttachmentsBean> attachments) {
                this.attachments = attachments;
            }

            public static class AttachmentsBean implements Serializable {
                /**
                 * id : 2127
                 * attachable_type : Variant
                 * attachable_id : 8214
                 * label_file_name : 1573724586924-18-small.jpg
                 * label_content_type : image/jpeg
                 * label_file_size : 3275
                 * vaccount_id : 1
                 * created_at : 2020-05-17T20:35:46.000+06:00
                 * updated_at : 2020-05-17T20:35:46.000+06:00
                 * expiring_url : http://shopvndrs.vstores.io/variant/2020-05/1573724586924-18-small
                 */

                private int id;
                private String attachable_type;
                private int attachable_id;
                private String label_file_name;
                private String label_content_type;
                private int label_file_size;
                private int vaccount_id;
                private String created_at;
                private String updated_at;
                private String expiring_url;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getAttachable_type() {
                    return attachable_type;
                }

                public void setAttachable_type(String attachable_type) {
                    this.attachable_type = attachable_type;
                }

                public int getAttachable_id() {
                    return attachable_id;
                }

                public void setAttachable_id(int attachable_id) {
                    this.attachable_id = attachable_id;
                }

                public String getLabel_file_name() {
                    return label_file_name;
                }

                public void setLabel_file_name(String label_file_name) {
                    this.label_file_name = label_file_name;
                }

                public String getLabel_content_type() {
                    return label_content_type;
                }

                public void setLabel_content_type(String label_content_type) {
                    this.label_content_type = label_content_type;
                }

                public int getLabel_file_size() {
                    return label_file_size;
                }

                public void setLabel_file_size(int label_file_size) {
                    this.label_file_size = label_file_size;
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

                public String getExpiring_url() {
                    return expiring_url;
                }

                public void setExpiring_url(String expiring_url) {
                    this.expiring_url = expiring_url;
                }
            }
        }
    }
}
