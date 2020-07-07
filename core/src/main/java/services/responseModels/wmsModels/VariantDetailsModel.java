package services.responseModels.wmsModels;

import java.io.Serializable;
import java.util.List;

public class VariantDetailsModel {

    /**
     * id : 22
     * seller_id : 3
     * category_id : 1122
     * sku_code : 17123_DSL007_30_KI
     * notes : Brenco Black Slim Fit Mid Rise Men's Stretch Jeans
     * price : 494.0
     * mrp : 1999.0
     * reorder_point : 20
     * active : true
     * vaccount_id : 1
     * created_at : 2018-01-23T16:55:59.000+06:00
     * updated_at : 2019-07-15T21:27:56.000+06:00
     * seller : {"id":3,"name":"Shishang","vaccount_id":1,"created_at":"2018-01-23T16:34:46.000+06:00","updated_at":"2018-01-23T16:34:46.000+06:00","supplier_id":null}
     * category : {"id":1122,"name":"Men Jeans","vaccount_id":1,"created_at":"2019-03-07T14:34:21.000+06:00","updated_at":"2019-03-07T14:34:21.000+06:00"}
     * variant_market_place_mappings : [{"id":2,"variant_id":22,"market_place_id":1,"uvid":25507113,"product_id":10312366,"sku_code":"17123_DSL007_30_KI","active":true,"vaccount_id":1,"created_at":"2018-01-23T16:55:59.000+06:00","updated_at":"2018-01-23T16:55:59.000+06:00","market_place":{"id":1,"name":"Voonik","aggregator_name":"VoonikAggregate","user_id":1,"vaccount_id":1,"created_at":"2017-09-25T13:06:30.000+06:00","updated_at":"2017-09-25T13:06:30.000+06:00"}}]
     * attachments : [{"id":4,"attachable_type":"Variant","attachable_id":22,"label_file_name":"brenco-black-slim-fit-mid-rise-men-s-stretch-jeans--small.jpg","label_content_type":"image/jpeg","label_file_size":4810,"vaccount_id":1,"created_at":"2018-01-23T16:56:01.000+06:00","updated_at":"2018-01-23T16:56:01.000+06:00","expiring_url":"http://shopvndrs.vstores.io/variant/2018-01/brenco-black-slim-fit-mid-rise-men-s-stretch-jeans--small"}]
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
    private SellerBean seller;
    private CategoryBean category;
    private List<VariantMarketPlaceMappingsBean> variant_market_place_mappings;
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

    public SellerBean getSeller() {
        return seller;
    }

    public void setSeller(SellerBean seller) {
        this.seller = seller;
    }

    public CategoryBean getCategory() {
        return category;
    }

    public void setCategory(CategoryBean category) {
        this.category = category;
    }

    public List<VariantMarketPlaceMappingsBean> getVariant_market_place_mappings() {
        return variant_market_place_mappings;
    }

    public void setVariant_market_place_mappings(List<VariantMarketPlaceMappingsBean> variant_market_place_mappings) {
        this.variant_market_place_mappings = variant_market_place_mappings;
    }

    public List<AttachmentsBean> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<AttachmentsBean> attachments) {
        this.attachments = attachments;
    }

    public static class SellerBean implements Serializable {
        /**
         * id : 3
         * name : Shishang
         * vaccount_id : 1
         * created_at : 2018-01-23T16:34:46.000+06:00
         * updated_at : 2018-01-23T16:34:46.000+06:00
         * supplier_id : null
         */

        private int id;
        private String name;
        private int vaccount_id;
        private String created_at;
        private String updated_at;
        private Object supplier_id;

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
    }

    public static class CategoryBean implements Serializable {
        /**
         * id : 1122
         * name : Men Jeans
         * vaccount_id : 1
         * created_at : 2019-03-07T14:34:21.000+06:00
         * updated_at : 2019-03-07T14:34:21.000+06:00
         */

        private int id;
        private String name;
        private int vaccount_id;
        private String created_at;
        private String updated_at;

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
    }

    public static class VariantMarketPlaceMappingsBean implements Serializable {
        /**
         * id : 2
         * variant_id : 22
         * market_place_id : 1
         * uvid : 25507113
         * product_id : 10312366
         * sku_code : 17123_DSL007_30_KI
         * active : true
         * vaccount_id : 1
         * created_at : 2018-01-23T16:55:59.000+06:00
         * updated_at : 2018-01-23T16:55:59.000+06:00
         * market_place : {"id":1,"name":"Voonik","aggregator_name":"VoonikAggregate","user_id":1,"vaccount_id":1,"created_at":"2017-09-25T13:06:30.000+06:00","updated_at":"2017-09-25T13:06:30.000+06:00"}
         */

        private int id;
        private int variant_id;
        private int market_place_id;
        private int uvid;
        private int product_id;
        private String sku_code;
        private boolean active;
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

        public int getVariant_id() {
            return variant_id;
        }

        public void setVariant_id(int variant_id) {
            this.variant_id = variant_id;
        }

        public int getMarket_place_id() {
            return market_place_id;
        }

        public void setMarket_place_id(int market_place_id) {
            this.market_place_id = market_place_id;
        }

        public int getUvid() {
            return uvid;
        }

        public void setUvid(int uvid) {
            this.uvid = uvid;
        }

        public int getProduct_id() {
            return product_id;
        }

        public void setProduct_id(int product_id) {
            this.product_id = product_id;
        }

        public String getSku_code() {
            return sku_code;
        }

        public void setSku_code(String sku_code) {
            this.sku_code = sku_code;
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

        public MarketPlaceBean getMarket_place() {
            return market_place;
        }

        public void setMarket_place(MarketPlaceBean market_place) {
            this.market_place = market_place;
        }

        public static class MarketPlaceBean implements Serializable {
            /**
             * id : 1
             * name : Voonik
             * aggregator_name : VoonikAggregate
             * user_id : 1
             * vaccount_id : 1
             * created_at : 2017-09-25T13:06:30.000+06:00
             * updated_at : 2017-09-25T13:06:30.000+06:00
             */

            private int id;
            private String name;
            private String aggregator_name;
            private int user_id;
            private int vaccount_id;
            private String created_at;
            private String updated_at;

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

            public String getAggregator_name() {
                return aggregator_name;
            }

            public void setAggregator_name(String aggregator_name) {
                this.aggregator_name = aggregator_name;
            }

            public int getUser_id() {
                return user_id;
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
        }
    }

    public static class AttachmentsBean implements Serializable {
        /**
         * id : 4
         * attachable_type : Variant
         * attachable_id : 22
         * label_file_name : brenco-black-slim-fit-mid-rise-men-s-stretch-jeans--small.jpg
         * label_content_type : image/jpeg
         * label_file_size : 4810
         * vaccount_id : 1
         * created_at : 2018-01-23T16:56:01.000+06:00
         * updated_at : 2018-01-23T16:56:01.000+06:00
         * expiring_url : http://shopvndrs.vstores.io/variant/2018-01/brenco-black-slim-fit-mid-rise-men-s-stretch-jeans--small
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
