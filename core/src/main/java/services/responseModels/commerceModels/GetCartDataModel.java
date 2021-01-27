package services.responseModels.commerceModels;

import java.util.List;

public class GetCartDataModel {

    /**
     * isError : false
     * message : Success
     * order : {"created_at":"2021-01-20T08:27:10.073+0000","email":"","line_items":[{"created_at":"2021-01-20T08:28:46.842+0000","id":310588,"income":0,"lifting_price":52.25,"original_seller_price":49.29,"price":52.25,"product_id":414745,"quantity":4,"sale_price":0,"seller_id":287000412,"seller_price":52.25,"updated_at":"2021-01-20T08:28:46.842+0000","variant_id":526090}],"number":"M9812433594","total":0,"updated_at":"2021-01-20T08:28:46.84+0000","user_id":2489657}
     * status : 200
     */
    private boolean isError;
    private String message;
    private OrderBean order;
    private int status;
    public boolean isIsError() {
        return isError;
    }
    public void setIsError(boolean isError) {
        this.isError = isError;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public OrderBean getOrder() {
        return order;
    }
    public void setOrder(OrderBean order) {
        this.order = order;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public static class OrderBean {
        /**
         * created_at : 2021-01-20T08:27:10.073+0000
         * email : 
         * line_items : [{"created_at":"2021-01-20T08:28:46.842+0000","id":310588,"income":0,"lifting_price":52.25,"original_seller_price":49.29,"price":52.25,"product_id":414745,"quantity":4,"sale_price":0,"seller_id":287000412,"seller_price":52.25,"updated_at":"2021-01-20T08:28:46.842+0000","variant_id":526090}]
         * number : M9812433594
         * total : 0
         * updated_at : 2021-01-20T08:28:46.84+0000
         * user_id : 2489657
         */
        private String created_at;
        private String email;
        private String number;
        private int total;
        private String updated_at;
        private int user_id;
        private List<LineItemsBean> line_items;
        public String getCreated_at() {
            return created_at;
        }
        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getNumber() {
            return number;
        }
        public void setNumber(String number) {
            this.number = number;
        }
        public int getTotal() {
            return total;
        }
        public void setTotal(int total) {
            this.total = total;
        }
        public String getUpdated_at() {
            return updated_at;
        }
        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }
        public int getUser_id() {
            return user_id;
        }
        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }
        public List<LineItemsBean> getLine_items() {
            return line_items;
        }
        public void setLine_items(List<LineItemsBean> line_items) {
            this.line_items = line_items;
        }
        public static class LineItemsBean {
            /**
             * created_at : 2021-01-20T08:28:46.842+0000
             * id : 310588
             * income : 0
             * lifting_price : 52.25
             * original_seller_price : 49.29
             * price : 52.25
             * product_id : 414745
             * quantity : 4
             * sale_price : 0
             * seller_id : 287000412
             * seller_price : 52.25
             * updated_at : 2021-01-20T08:28:46.842+0000
             * variant_id : 526090
             */
            private String created_at;
            private int id;
            private int income;
            private double lifting_price;
            private double original_seller_price;
            private double price;
            private int product_id;
            private int quantity;
            private int sale_price;
            private int seller_id;
            private double seller_price;
            private String updated_at;
            private int variant_id;
            public String getCreated_at() {
                return created_at;
            }
            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }
            public int getId() {
                return id;
            }
            public void setId(int id) {
                this.id = id;
            }
            public int getIncome() {
                return income;
            }
            public void setIncome(int income) {
                this.income = income;
            }
            public double getLifting_price() {
                return lifting_price;
            }
            public void setLifting_price(double lifting_price) {
                this.lifting_price = lifting_price;
            }
            public double getOriginal_seller_price() {
                return original_seller_price;
            }
            public void setOriginal_seller_price(double original_seller_price) {
                this.original_seller_price = original_seller_price;
            }
            public double getPrice() {
                return price;
            }
            public void setPrice(double price) {
                this.price = price;
            }
            public int getProduct_id() {
                return product_id;
            }
            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }
            public int getQuantity() {
                return quantity;
            }
            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }
            public int getSale_price() {
                return sale_price;
            }
            public void setSale_price(int sale_price) {
                this.sale_price = sale_price;
            }
            public int getSeller_id() {
                return seller_id;
            }
            public void setSeller_id(int seller_id) {
                this.seller_id = seller_id;
            }
            public double getSeller_price() {
                return seller_price;
            }
            public void setSeller_price(double seller_price) {
                this.seller_price = seller_price;
            }
            public String getUpdated_at() {
                return updated_at;
            }
            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }
            public int getVariant_id() {
                return variant_id;
            }
            public void setVariant_id(int variant_id) {
                this.variant_id = variant_id;
            }
        }
    }

}
