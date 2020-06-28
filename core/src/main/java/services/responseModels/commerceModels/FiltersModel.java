package services.responseModels.commerceModels;

import java.util.List;

public class FiltersModel {


    private List<FiltersNewBean> filters_new;

    public List<FiltersNewBean> getFilters_new() {
        return filters_new;
    }

    public void setFilters_new(List<FiltersNewBean> filters_new) {
        this.filters_new = filters_new;
    }

    public static class FiltersNewBean {
        private List<CategoryBean> category;
        private List<SubCategoryBean> subcategory;
        private List<PriceBean> price;
        private List<BrandBean> brand;
        private List<SizeBean> size;
        private List<ColorBean> color;
        private List<DiscountBean> discount;
        private List<OffersBean> offers;
        private List<GenderBean> gender;

        public List<CategoryBean> getCategory() {
            return category;
        }

        public void setCategory(List<CategoryBean> category) {
            this.category = category;
        }

        public List<SubCategoryBean> getSubcategory() {
            return subcategory;
        }

        public void setSubcategory(List<SubCategoryBean> subcategory) {
            this.subcategory = subcategory;
        }

        public List<PriceBean> getPrice() {
            return price;
        }

        public void setPrice(List<PriceBean> price) {
            this.price = price;
        }

        public List<BrandBean> getBrand() {
            return brand;
        }

        public void setBrand(List<BrandBean> brand) {
            this.brand = brand;
        }

        public List<SizeBean> getSize() {
            return size;
        }

        public void setSize(List<SizeBean> size) {
            this.size = size;
        }

        public List<ColorBean> getColor() {
            return color;
        }

        public void setColor(List<ColorBean> color) {
            this.color = color;
        }

        public List<DiscountBean> getDiscount() {
            return discount;
        }

        public void setDiscount(List<DiscountBean> discount) {
            this.discount = discount;
        }

        public List<OffersBean> getOffers() {
            return offers;
        }

        public void setOffers(List<OffersBean> offers) {
            this.offers = offers;
        }

        public List<GenderBean> getGender() {
            return gender;
        }

        public void setGender(List<GenderBean> gender) {
            this.gender = gender;
        }

        public static class CategoryBean {
            /**
             * id : 1118
             * image : http://images1.voonik.com/sub-categories/men-shirts.jpg?vq=11
             * label : Men Shirts
             * query : product_category_id = (1118)
             * slug : men-shirts
             */

            private String id;
            private String image;
            private String label;
            private String query;
            private String slug;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getQuery() {
                return query;
            }

            public void setQuery(String query) {
                this.query = query;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }
        }

        public static class PriceBean {
            /**
             * avg_price : null
             * id : 33
             * label : Below 500 Tk
             * query : {:lower_limit=>0,:upper_limit=>500}
             */

            private Object avg_price;
            private String id;
            private String label;
            private String query;

            public Object getAvg_price() {
                return avg_price;
            }

            public void setAvg_price(Object avg_price) {
                this.avg_price = avg_price;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getQuery() {
                return query;
            }

            public void setQuery(String query) {
                this.query = query;
            }
        }

        public static class DiscountBean {
            /**
             * id : 1054
             * label : 70% and above
             * query : (((cached_product_properties.original_amount - cached_product_properties.amount)/cached_product_properties.original_amount)*100) > 69
             */

            private String id;
            private String label;
            private String query;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getQuery() {
                return query;
            }

            public void setQuery(String query) {
                this.query = query;
            }
        }

        private class SubCategoryBean {

            private String id;
            private String label;
            private String query;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getQuery() {
                return query;
            }

            public void setQuery(String query) {
                this.query = query;
            }
        }

        private class BrandBean {

            private String id;
            private String label;
            private String query;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getQuery() {
                return query;
            }

            public void setQuery(String query) {
                this.query = query;
            }
        }

        private class SizeBean {

            private String id;
            private String label;
            private String query;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getQuery() {
                return query;
            }

            public void setQuery(String query) {
                this.query = query;
            }
        }

        private class ColorBean {

            private String id;
            private String label;
            private String query;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getQuery() {
                return query;
            }

            public void setQuery(String query) {
                this.query = query;
            }
        }

        private class OffersBean {

            private String id;
            private String label;
            private String query;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getQuery() {
                return query;
            }

            public void setQuery(String query) {
                this.query = query;
            }
        }

        private class GenderBean {

            private String id;
            private String label;
            private String query;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getQuery() {
                return query;
            }

            public void setQuery(String query) {
                this.query = query;
            }
        }
    }
}
