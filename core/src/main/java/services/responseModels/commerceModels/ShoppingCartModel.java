package services.responseModels.commerceModels;

import java.util.List;

public class ShoppingCartModel {


    private List<CartItemsBean> cart_items;

    public List<CartItemsBean> getCart_items() {
        return cart_items;
    }

    public void setCart_items(List<CartItemsBean> cart_items) {
        this.cart_items = cart_items;
    }

    public static class CartItemsBean {
        /**
         * formatted_price : Tk. 1,997
         * seller : ASI
         * min_order_qty : 1
         * line_item_id : 297484
         * discount : 0
         * prepaid_availability : true
         * seller_slug : asi
         * delivery_time : COD order value max limit exceeded
         * title : Sequins Georgette Saree - 002 - ASI
         * liked : false
         * category_id : 48
         * variant_options : [{"count_on_hand":16,"option_value_name":"option","size":13,"corrected_count_on_hand":3,"name":"option","id":7858}]
         * max_item_quantity : 50
         * price : 1997.0
         * product_id : 6700
         * sold_out : false
         * variant : 7858
         * formatted_income : Tk. 444
         * mrp_price_line : Tk. 1,849 x 3 = Tk. 5,547
         * cod_availability : false
         * formatted_per_item_total : Tk. 5,991
         * per_item_total : 5991
         * sku : 307390
         * delivery_time_message : {"message":"COD order value max limit exceeded","type":0}
         * prepaid_message : Delivery in 3-5 working days.
         * activity_object : {"activity_object":{"id":"P6700"}}
         * image : https://shopimages.vstores.io/0076/1576912692637-whatsappimage2019-12-21at1.01.01pm1-small.jpeg?1580073656
         * quantity : 3
         * max_selling_price : 2607
         * original_amo : 1849
         * variant_price : 1849
         * final_discount : 0
         * formatted_variant_price : Tk. 1,849
         * price_line : Tk. 1,997 x 3 = Tk. 5,991
         * product_name : Sequins Georgette Saree - 002 - ASI
         * sale_price : 5991.0
         * product_stamp : null
         * zipcode : 7
         * formatted_seller_price : Tk. 0
         * formatted_sale_price : Tk. 5,991
         * size : option
         * line_item_adjustments : []
         * master_product_id : 6700
         * messages : []
         * min_selling_price : 1997
         * category : Saree
         * permalink : sequins-georgette-saree-002-asi-105190b0
         * cod_message : COD is not available
         */

        private String formatted_price;
        private String seller;
        private int min_order_qty;
        private int line_item_id;
        private int discount;
        private boolean prepaid_availability;
        private String seller_slug;
        private String delivery_time;
        private String title;
        private boolean liked;
        private int category_id;
        private int max_item_quantity;
        private String price;
        private int product_id;
        private boolean sold_out;
        private int variant;
        private String formatted_income;
        private String mrp_price_line;
        private boolean cod_availability;
        private String formatted_per_item_total;
        private int per_item_total;
        private String sku;
        private DeliveryTimeMessageBean delivery_time_message;
        private String prepaid_message;
        private ActivityObjectBeanX activity_object;
        private String image;
        private int quantity;
        private int max_selling_price;
        private int original_amo;
        private int variant_price;
        private int final_discount;
        private String formatted_variant_price;
        private String price_line;
        private String product_name;
        private String sale_price;
        private Object product_stamp;
        private String zipcode;
        private String formatted_seller_price;
        private String formatted_sale_price;
        private String size;
        private int master_product_id;
        private int min_selling_price;
        private String category;
        private String permalink;
        private String cod_message;
        private List<VariantOptionsBean> variant_options;
        private List<?> line_item_adjustments;
        private List<?> messages;

        public String getFormatted_price() {
            return formatted_price;
        }

        public void setFormatted_price(String formatted_price) {
            this.formatted_price = formatted_price;
        }

        public String getSeller() {
            return seller;
        }

        public void setSeller(String seller) {
            this.seller = seller;
        }

        public int getMin_order_qty() {
            return min_order_qty;
        }

        public void setMin_order_qty(int min_order_qty) {
            this.min_order_qty = min_order_qty;
        }

        public int getLine_item_id() {
            return line_item_id;
        }

        public void setLine_item_id(int line_item_id) {
            this.line_item_id = line_item_id;
        }

        public int getDiscount() {
            return discount;
        }

        public void setDiscount(int discount) {
            this.discount = discount;
        }

        public boolean isPrepaid_availability() {
            return prepaid_availability;
        }

        public void setPrepaid_availability(boolean prepaid_availability) {
            this.prepaid_availability = prepaid_availability;
        }

        public String getSeller_slug() {
            return seller_slug;
        }

        public void setSeller_slug(String seller_slug) {
            this.seller_slug = seller_slug;
        }

        public String getDelivery_time() {
            return delivery_time;
        }

        public void setDelivery_time(String delivery_time) {
            this.delivery_time = delivery_time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isLiked() {
            return liked;
        }

        public void setLiked(boolean liked) {
            this.liked = liked;
        }

        public int getCategory_id() {
            return category_id;
        }

        public void setCategory_id(int category_id) {
            this.category_id = category_id;
        }

        public int getMax_item_quantity() {
            return max_item_quantity;
        }

        public void setMax_item_quantity(int max_item_quantity) {
            this.max_item_quantity = max_item_quantity;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getProduct_id() {
            return product_id;
        }

        public void setProduct_id(int product_id) {
            this.product_id = product_id;
        }

        public boolean isSold_out() {
            return sold_out;
        }

        public void setSold_out(boolean sold_out) {
            this.sold_out = sold_out;
        }

        public int getVariant() {
            return variant;
        }

        public void setVariant(int variant) {
            this.variant = variant;
        }

        public String getFormatted_income() {
            return formatted_income;
        }

        public void setFormatted_income(String formatted_income) {
            this.formatted_income = formatted_income;
        }

        public String getMrp_price_line() {
            return mrp_price_line;
        }

        public void setMrp_price_line(String mrp_price_line) {
            this.mrp_price_line = mrp_price_line;
        }

        public boolean isCod_availability() {
            return cod_availability;
        }

        public void setCod_availability(boolean cod_availability) {
            this.cod_availability = cod_availability;
        }

        public String getFormatted_per_item_total() {
            return formatted_per_item_total;
        }

        public void setFormatted_per_item_total(String formatted_per_item_total) {
            this.formatted_per_item_total = formatted_per_item_total;
        }

        public int getPer_item_total() {
            return per_item_total;
        }

        public void setPer_item_total(int per_item_total) {
            this.per_item_total = per_item_total;
        }

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public DeliveryTimeMessageBean getDelivery_time_message() {
            return delivery_time_message;
        }

        public void setDelivery_time_message(DeliveryTimeMessageBean delivery_time_message) {
            this.delivery_time_message = delivery_time_message;
        }

        public String getPrepaid_message() {
            return prepaid_message;
        }

        public void setPrepaid_message(String prepaid_message) {
            this.prepaid_message = prepaid_message;
        }

        public ActivityObjectBeanX getActivity_object() {
            return activity_object;
        }

        public void setActivity_object(ActivityObjectBeanX activity_object) {
            this.activity_object = activity_object;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getMax_selling_price() {
            return max_selling_price;
        }

        public void setMax_selling_price(int max_selling_price) {
            this.max_selling_price = max_selling_price;
        }

        public int getOriginal_amo() {
            return original_amo;
        }

        public void setOriginal_amo(int original_amo) {
            this.original_amo = original_amo;
        }

        public int getVariant_price() {
            return variant_price;
        }

        public void setVariant_price(int variant_price) {
            this.variant_price = variant_price;
        }

        public int getFinal_discount() {
            return final_discount;
        }

        public void setFinal_discount(int final_discount) {
            this.final_discount = final_discount;
        }

        public String getFormatted_variant_price() {
            return formatted_variant_price;
        }

        public void setFormatted_variant_price(String formatted_variant_price) {
            this.formatted_variant_price = formatted_variant_price;
        }

        public String getPrice_line() {
            return price_line;
        }

        public void setPrice_line(String price_line) {
            this.price_line = price_line;
        }

        public String getProduct_name() {
            return product_name;
        }

        public void setProduct_name(String product_name) {
            this.product_name = product_name;
        }

        public String getSale_price() {
            return sale_price;
        }

        public void setSale_price(String sale_price) {
            this.sale_price = sale_price;
        }

        public Object getProduct_stamp() {
            return product_stamp;
        }

        public void setProduct_stamp(Object product_stamp) {
            this.product_stamp = product_stamp;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public String getFormatted_seller_price() {
            return formatted_seller_price;
        }

        public void setFormatted_seller_price(String formatted_seller_price) {
            this.formatted_seller_price = formatted_seller_price;
        }

        public String getFormatted_sale_price() {
            return formatted_sale_price;
        }

        public void setFormatted_sale_price(String formatted_sale_price) {
            this.formatted_sale_price = formatted_sale_price;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public int getMaster_product_id() {
            return master_product_id;
        }

        public void setMaster_product_id(int master_product_id) {
            this.master_product_id = master_product_id;
        }

        public int getMin_selling_price() {
            return min_selling_price;
        }

        public void setMin_selling_price(int min_selling_price) {
            this.min_selling_price = min_selling_price;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getPermalink() {
            return permalink;
        }

        public void setPermalink(String permalink) {
            this.permalink = permalink;
        }

        public String getCod_message() {
            return cod_message;
        }

        public void setCod_message(String cod_message) {
            this.cod_message = cod_message;
        }

        public List<VariantOptionsBean> getVariant_options() {
            return variant_options;
        }

        public void setVariant_options(List<VariantOptionsBean> variant_options) {
            this.variant_options = variant_options;
        }

        public List<?> getLine_item_adjustments() {
            return line_item_adjustments;
        }

        public void setLine_item_adjustments(List<?> line_item_adjustments) {
            this.line_item_adjustments = line_item_adjustments;
        }

        public List<?> getMessages() {
            return messages;
        }

        public void setMessages(List<?> messages) {
            this.messages = messages;
        }

        public static class DeliveryTimeMessageBean {
            /**
             * message : COD order value max limit exceeded
             * type : 0
             */

            private String message;
            private int type;

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

        public static class ActivityObjectBeanX {
            /**
             * activity_object : {"id":"P6700"}
             */

            private ActivityObjectBean activity_object;

            public ActivityObjectBean getActivity_object() {
                return activity_object;
            }

            public void setActivity_object(ActivityObjectBean activity_object) {
                this.activity_object = activity_object;
            }

            public static class ActivityObjectBean {
                /**
                 * id : P6700
                 */

                private String id;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }
            }
        }

        public static class VariantOptionsBean {
            /**
             * count_on_hand : 16
             * option_value_name : option
             * size : 13
             * corrected_count_on_hand : 3
             * name : option
             * id : 7858
             */

            private int count_on_hand;
            private String option_value_name;
            private int size;
            private int corrected_count_on_hand;
            private String name;
            private int id;

            public int getCount_on_hand() {
                return count_on_hand;
            }

            public void setCount_on_hand(int count_on_hand) {
                this.count_on_hand = count_on_hand;
            }

            public String getOption_value_name() {
                return option_value_name;
            }

            public void setOption_value_name(String option_value_name) {
                this.option_value_name = option_value_name;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getCorrected_count_on_hand() {
                return corrected_count_on_hand;
            }

            public void setCorrected_count_on_hand(int corrected_count_on_hand) {
                this.corrected_count_on_hand = corrected_count_on_hand;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }



}
