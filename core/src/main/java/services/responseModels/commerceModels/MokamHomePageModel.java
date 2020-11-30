package services.responseModels.commerceModels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MokamHomePageModel {

    private String Android_App_image;
    private String IOS_App_Image;
    private ABLogicBean a_b_logic;
    private boolean big_sale_tabs;
    private CarouselsForFiltersWebBean carousels_for_filters_web;
    private int cart_item_count;
    private String close_for_banner;
    private ConfigBean config;
    private String country_code;
    private CreditDataBean credit_data;
    private CurrentUserBean current_user;
    private CurrentUserShipAddressBean current_user_ship_address;
    private DealBean deal;
    private String default_carousal_image;
    private String default_carousal_url;
    private String editorial_home;
    private String editorial_home_text;
    private boolean enable_category_discovery;
    private boolean enable_diwali_sale;
    private boolean enable_double_role_sale;
    private boolean enable_editorial;
    private boolean enable_feed_stats;
    private String enable_filter;
    private String enable_filter_sort;
    private boolean enable_search_sort;
    private boolean enable_seller_rating_web;
    private boolean fashion_essential_feature;
    private FashionEssentialHomepageBannerTextBean fashion_essential_homepage_banner_text;
    private FashionEssentialHomepageBannersBean fashion_essential_homepage_banners;
    private FeaturedFeedHashBean featured_feed_hash;
    private int filter_count;
    private String home_feed_promotions;
    private int image_version;
    private boolean is_PDP;
    private boolean is_explorer;
    private boolean is_opera_mini;
    private int new_notification_count;
    private String newlyarrived;
    private boolean open_recommendation_popup;
    private PageBean page;
    private ParamsBeBean params_be;
    private String partial;
    private int products_count;
    private QuickFiltersBean quick_filters;
    private String shopbycategory;
    private ShowCaseSideCol1Bean show_case_side_col_1;
    private ShowCaseSideCol2Bean show_case_side_col_2;
    private boolean show_product_rating;
    private boolean show_style_quiz_wap;
    private boolean show_style_quiz_web;
    private String side_banner;
    private boolean side_banner_enable;
    private int split_user;
    private String style_quiz_banner_carousel;
    private SubCategoriesForFiltersWebBean sub_categories_for_filters_web;
    private SubcategoryCarousalBean subcategory_carousal;
    private String timer_end_date;
    private String wap_download_banner;
    private String wap_side_banner;
    private String wap_style_quiz;
    private String whatstrendin;
    private java.util.List<?> blog_content;
    private java.util.List<?> carousel_promotions;
    private java.util.List<CollectionsBean> collections;
    private java.util.List<?> coupons;
    private java.util.List<String> editorials_links;
    private java.util.List<?> fetch_other_items_promotions;
    private java.util.List<FiltersNewBean> filters_new;
    private java.util.List<?> love_list;
    private java.util.List<ManualPremiumSellersBean> manual_premium_sellers;
    private java.util.List<String> market_place_banner;
    private java.util.List<String> market_place_promotional_banner;
    private java.util.List<String> no_item_pages;
    private java.util.List<?> premium_sellers;
    private java.util.List<?> promotions;
    private java.util.List<ResultsBean> results;
    private java.util.List<?> side_menu_collections;
    private java.util.List<?> side_menu_display_offers;
    private java.util.List<?> side_menu_offer_category_ids;
    private java.util.List<SortBeanX> sort;
    private java.util.List<String> states;
    private java.util.List<?> top_sellers;

    public static class SubcategoryCarousalBean{}

    public List<CollectionsBean> getCollections() {
        return collections;
    }

    public static class CollectionsBean{

        private int widget_id;
        private String type;
        private String title;
        private String description;
        private ConfigBean config;
        private int position;
        private int index;
        private List<ItemsBean> items;

        public int getWidget_id() {
            return widget_id;
        }

        public void setWidget_id(int widget_id) {
            this.widget_id = widget_id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public ConfigBean getConfig() {
            return config;
        }

        public void setConfig(ConfigBean config) {
            this.config = config;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ConfigBean {
        }

        public static class ItemsBean {
            private String title;
            private String description;
            private String image_url;
            private String url;
            private int position;
            private ConfigBeanX config;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getPosition() {
                return position;
            }

            public void setPosition(int position) {
                this.position = position;
            }

            public ConfigBeanX getConfig() {
                return config;
            }

            public void setConfig(ConfigBeanX config) {
                this.config = config;
            }

            public static class ConfigBeanX {
                private double totalCredit;
                private double totalDebit;
                private int creditLimit;
                private int availableCredit;
                private int dueAmount;
                private int isOverdue;

                public double getTotalCredit() {
                    return totalCredit;
                }

                public void setTotalCredit(double totalCredit) {
                    this.totalCredit = totalCredit;
                }

                public double getTotalDebit() {
                    return totalDebit;
                }

                public void setTotalDebit(double totalDebit) {
                    this.totalDebit = totalDebit;
                }

                public int getCreditLimit() {
                    return creditLimit;
                }

                public void setCreditLimit(int creditLimit) {
                    this.creditLimit = creditLimit;
                }

                public int getAvailableCredit() {
                    return availableCredit;
                }

                public void setAvailableCredit(int availableCredit) {
                    this.availableCredit = availableCredit;
                }

                public int getDueAmount() {
                    return dueAmount;
                }

                public void setDueAmount(int dueAmount) {
                    this.dueAmount = dueAmount;
                }

                public int getIsOverdue() {
                    return isOverdue;
                }

                public void setIsOverdue(int isOverdue) {
                    this.isOverdue = isOverdue;
                }
            }
        }
    }

    public static class FiltersNewBean{

        private List<?> category;
        private List<?> subcategory;
        private List<PriceBean> price;
        private List<?> brand;
        private List<?> size;
        private List<?> color;
        private List<DiscountBean> discount;
        private List<?> offers;

        public List<?> getCategory() {
            return category;
        }

        public void setCategory(List<?> category) {
            this.category = category;
        }

        public List<?> getSubcategory() {
            return subcategory;
        }

        public void setSubcategory(List<?> subcategory) {
            this.subcategory = subcategory;
        }

        public List<PriceBean> getPrice() {
            return price;
        }

        public void setPrice(List<PriceBean> price) {
            this.price = price;
        }

        public List<?> getBrand() {
            return brand;
        }

        public void setBrand(List<?> brand) {
            this.brand = brand;
        }

        public List<?> getSize() {
            return size;
        }

        public void setSize(List<?> size) {
            this.size = size;
        }

        public List<?> getColor() {
            return color;
        }

        public void setColor(List<?> color) {
            this.color = color;
        }

        public List<DiscountBean> getDiscount() {
            return discount;
        }

        public void setDiscount(List<DiscountBean> discount) {
            this.discount = discount;
        }

        public List<?> getOffers() {
            return offers;
        }

        public void setOffers(List<?> offers) {
            this.offers = offers;
        }

        public static class PriceBean {
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

        public static class DiscountBean {
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

    public static class ManualPremiumSellersBean{

        private String slug;
        private String brand_name;

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getBrand_name() {
            return brand_name;
        }

        public void setBrand_name(String brand_name) {
            this.brand_name = brand_name;
        }
    }

    public static class ResultsBean{

        private String activity_object_id;
        private String category;
        private int category_id;
        private CouponOfferBean coupon_offer;
        private String description;
        private int discount;
        private int discount_percentage;
        private boolean has_multi_factor_sizes;
        private int id;
        private String image;
        private int image_height;
        private int image_width;
        private boolean is_accessory;
        private int like_count;
        private boolean liked;
        private boolean look;
        private double margin;
        private int master_product_id;
        private String name;
        private String original_image;
        private String original_price;
        private String per_piece_price;
        private String permalink;
        private int plp_view_type;
        private String price;
        private double price_es;
        private String primo_price;
        private int product_id;
        private String product_stamp;
        private int product_stock;
        private int purchases_count;
        private boolean quality_verified;
        private int returns_count;
        private boolean seal_of_trust;
        private String seller;
        private int seller_rating;
        private String seo_title;
        private String slug;
        private String small_image_url;
        private boolean sponsored_highlight;
        private String stylist;
        private String title;
        private String welcome_text;
        private List<ImagesBean> images;
        private List<String> images_small;
        private List<?> product_tags;
        private List<SizesBean> sizes;
        private List<?> video;

        public String getActivity_object_id() {
            return activity_object_id;
        }

        public void setActivity_object_id(String activity_object_id) {
            this.activity_object_id = activity_object_id;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public int getCategory_id() {
            return category_id;
        }

        public void setCategory_id(int category_id) {
            this.category_id = category_id;
        }

        public CouponOfferBean getCoupon_offer() {
            return coupon_offer;
        }

        public void setCoupon_offer(CouponOfferBean coupon_offer) {
            this.coupon_offer = coupon_offer;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getDiscount() {
            return discount;
        }

        public void setDiscount(int discount) {
            this.discount = discount;
        }

        public int getDiscount_percentage() {
            return discount_percentage;
        }

        public void setDiscount_percentage(int discount_percentage) {
            this.discount_percentage = discount_percentage;
        }

        public boolean isHas_multi_factor_sizes() {
            return has_multi_factor_sizes;
        }

        public void setHas_multi_factor_sizes(boolean has_multi_factor_sizes) {
            this.has_multi_factor_sizes = has_multi_factor_sizes;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getImage_height() {
            return image_height;
        }

        public void setImage_height(int image_height) {
            this.image_height = image_height;
        }

        public int getImage_width() {
            return image_width;
        }

        public void setImage_width(int image_width) {
            this.image_width = image_width;
        }

        public boolean isIs_accessory() {
            return is_accessory;
        }

        public void setIs_accessory(boolean is_accessory) {
            this.is_accessory = is_accessory;
        }

        public int getLike_count() {
            return like_count;
        }

        public void setLike_count(int like_count) {
            this.like_count = like_count;
        }

        public boolean isLiked() {
            return liked;
        }

        public void setLiked(boolean liked) {
            this.liked = liked;
        }

        public boolean isLook() {
            return look;
        }

        public void setLook(boolean look) {
            this.look = look;
        }

        public double getMargin() {
            return margin;
        }

        public void setMargin(double margin) {
            this.margin = margin;
        }

        public int getMaster_product_id() {
            return master_product_id;
        }

        public void setMaster_product_id(int master_product_id) {
            this.master_product_id = master_product_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOriginal_image() {
            return original_image;
        }

        public void setOriginal_image(String original_image) {
            this.original_image = original_image;
        }

        public String getOriginal_price() {
            return original_price;
        }

        public void setOriginal_price(String original_price) {
            this.original_price = original_price;
        }

        public String getPer_piece_price() {
            return per_piece_price;
        }

        public void setPer_piece_price(String per_piece_price) {
            this.per_piece_price = per_piece_price;
        }

        public String getPermalink() {
            return permalink;
        }

        public void setPermalink(String permalink) {
            this.permalink = permalink;
        }

        public int getPlp_view_type() {
            return plp_view_type;
        }

        public void setPlp_view_type(int plp_view_type) {
            this.plp_view_type = plp_view_type;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public double getPrice_es() {
            return price_es;
        }

        public void setPrice_es(double price_es) {
            this.price_es = price_es;
        }

        public String getPrimo_price() {
            return primo_price;
        }

        public void setPrimo_price(String primo_price) {
            this.primo_price = primo_price;
        }

        public int getProduct_id() {
            return product_id;
        }

        public void setProduct_id(int product_id) {
            this.product_id = product_id;
        }

        public String getProduct_stamp() {
            return product_stamp;
        }

        public void setProduct_stamp(String product_stamp) {
            this.product_stamp = product_stamp;
        }

        public int getProduct_stock() {
            return product_stock;
        }

        public void setProduct_stock(int product_stock) {
            this.product_stock = product_stock;
        }

        public int getPurchases_count() {
            return purchases_count;
        }

        public void setPurchases_count(int purchases_count) {
            this.purchases_count = purchases_count;
        }

        public boolean isQuality_verified() {
            return quality_verified;
        }

        public void setQuality_verified(boolean quality_verified) {
            this.quality_verified = quality_verified;
        }

        public int getReturns_count() {
            return returns_count;
        }

        public void setReturns_count(int returns_count) {
            this.returns_count = returns_count;
        }

        public boolean isSeal_of_trust() {
            return seal_of_trust;
        }

        public void setSeal_of_trust(boolean seal_of_trust) {
            this.seal_of_trust = seal_of_trust;
        }

        public String getSeller() {
            return seller;
        }

        public void setSeller(String seller) {
            this.seller = seller;
        }

        public int getSeller_rating() {
            return seller_rating;
        }

        public void setSeller_rating(int seller_rating) {
            this.seller_rating = seller_rating;
        }

        public String getSeo_title() {
            return seo_title;
        }

        public void setSeo_title(String seo_title) {
            this.seo_title = seo_title;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getSmall_image_url() {
            return small_image_url;
        }

        public void setSmall_image_url(String small_image_url) {
            this.small_image_url = small_image_url;
        }

        public boolean isSponsored_highlight() {
            return sponsored_highlight;
        }

        public void setSponsored_highlight(boolean sponsored_highlight) {
            this.sponsored_highlight = sponsored_highlight;
        }

        public String getStylist() {
            return stylist;
        }

        public void setStylist(String stylist) {
            this.stylist = stylist;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getWelcome_text() {
            return welcome_text;
        }

        public void setWelcome_text(String welcome_text) {
            this.welcome_text = welcome_text;
        }

        public List<ImagesBean> getImages() {
            return images;
        }

        public void setImages(List<ImagesBean> images) {
            this.images = images;
        }

        public List<String> getImages_small() {
            return images_small;
        }

        public void setImages_small(List<String> images_small) {
            this.images_small = images_small;
        }

        public List<?> getProduct_tags() {
            return product_tags;
        }

        public void setProduct_tags(List<?> product_tags) {
            this.product_tags = product_tags;
        }

        public List<SizesBean> getSizes() {
            return sizes;
        }

        public void setSizes(List<SizesBean> sizes) {
            this.sizes = sizes;
        }

        public List<?> getVideo() {
            return video;
        }

        public void setVideo(List<?> video) {
            this.video = video;
        }

        public static class CouponOfferBean {
        }

        public static class ImagesBean {
            private String original;
            private String product;
            private String small;

            public String getOriginal() {
                return original;
            }

            public void setOriginal(String original) {
                this.original = original;
            }

            public String getProduct() {
                return product;
            }

            public void setProduct(String product) {
                this.product = product;
            }

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }
        }

        public static class SizesBean {
            private int corrected_count_on_hand;
            private int count_on_hand;
            private int discount;
            private int id;
            private double margin;
            private int max_selling_price;
            private int min_order_quantity;
            private int min_selling_price;
            private String name;
            private String option_value_name;
            private double original_price;
            private double per_piece_price;
            private double price;
            private int product_id;
            private int quantity_per_variant;
            private int size;
            private String size_description;

            public int getCorrected_count_on_hand() {
                return corrected_count_on_hand;
            }

            public void setCorrected_count_on_hand(int corrected_count_on_hand) {
                this.corrected_count_on_hand = corrected_count_on_hand;
            }

            public int getCount_on_hand() {
                return count_on_hand;
            }

            public void setCount_on_hand(int count_on_hand) {
                this.count_on_hand = count_on_hand;
            }

            public int getDiscount() {
                return discount;
            }

            public void setDiscount(int discount) {
                this.discount = discount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public double getMargin() {
                return margin;
            }

            public void setMargin(double margin) {
                this.margin = margin;
            }

            public int getMax_selling_price() {
                return max_selling_price;
            }

            public void setMax_selling_price(int max_selling_price) {
                this.max_selling_price = max_selling_price;
            }

            public int getMin_order_quantity() {
                return min_order_quantity;
            }

            public void setMin_order_quantity(int min_order_quantity) {
                this.min_order_quantity = min_order_quantity;
            }

            public int getMin_selling_price() {
                return min_selling_price;
            }

            public void setMin_selling_price(int min_selling_price) {
                this.min_selling_price = min_selling_price;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getOption_value_name() {
                return option_value_name;
            }

            public void setOption_value_name(String option_value_name) {
                this.option_value_name = option_value_name;
            }

            public double getOriginal_price() {
                return original_price;
            }

            public void setOriginal_price(double original_price) {
                this.original_price = original_price;
            }

            public double getPer_piece_price() {
                return per_piece_price;
            }

            public void setPer_piece_price(double per_piece_price) {
                this.per_piece_price = per_piece_price;
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

            public int getQuantity_per_variant() {
                return quantity_per_variant;
            }

            public void setQuantity_per_variant(int quantity_per_variant) {
                this.quantity_per_variant = quantity_per_variant;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getSize_description() {
                return size_description;
            }

            public void setSize_description(String size_description) {
                this.size_description = size_description;
            }
        }
    }

    public static class SortBeanX{

        private List<SortBean> sort;

        public List<SortBean> getSort() {
            return sort;
        }

        public void setSort(List<SortBean> sort) {
            this.sort = sort;
        }

        public static class SortBean {
            @SerializedName("1")
            private String _$1;
            @SerializedName("4")
            private String _$4;
            @SerializedName("3")
            private String _$3;
            @SerializedName("2")
            private String _$2;
            @SerializedName("5")
            private String _$5;
            @SerializedName("6")
            private String _$6;
            @SerializedName("9")
            private String _$9;
            @SerializedName("10")
            private String _$10;

            public String get_$1() {
                return _$1;
            }

            public void set_$1(String _$1) {
                this._$1 = _$1;
            }

            public String get_$4() {
                return _$4;
            }

            public void set_$4(String _$4) {
                this._$4 = _$4;
            }

            public String get_$3() {
                return _$3;
            }

            public void set_$3(String _$3) {
                this._$3 = _$3;
            }

            public String get_$2() {
                return _$2;
            }

            public void set_$2(String _$2) {
                this._$2 = _$2;
            }

            public String get_$5() {
                return _$5;
            }

            public void set_$5(String _$5) {
                this._$5 = _$5;
            }

            public String get_$6() {
                return _$6;
            }

            public void set_$6(String _$6) {
                this._$6 = _$6;
            }

            public String get_$9() {
                return _$9;
            }

            public void set_$9(String _$9) {
                this._$9 = _$9;
            }

            public String get_$10() {
                return _$10;
            }

            public void set_$10(String _$10) {
                this._$10 = _$10;
            }
        }
    }

    public static class ABLogicBean {
        private boolean trending_categories;
        private boolean enable_a_b;
        private boolean sale_banners;
        private boolean banner;

        public boolean isTrending_categories() {
            return trending_categories;
        }

        public void setTrending_categories(boolean trending_categories) {
            this.trending_categories = trending_categories;
        }

        public boolean isEnable_a_b() {
            return enable_a_b;
        }

        public void setEnable_a_b(boolean enable_a_b) {
            this.enable_a_b = enable_a_b;
        }

        public boolean isSale_banners() {
            return sale_banners;
        }

        public void setSale_banners(boolean sale_banners) {
            this.sale_banners = sale_banners;
        }

        public boolean isBanner() {
            return banner;
        }

        public void setBanner(boolean banner) {
            this.banner = banner;
        }
    }

    public static class CarouselsForFiltersWebBean {
        @com.google.gson.annotations.SerializedName("campus-wear-latest-sale")
        private String campuswearlatestsale;
        @com.google.gson.annotations.SerializedName("party-all")
        private String partyall;
        @com.google.gson.annotations.SerializedName("Festive-wear-july")
        private String Festivewearjuly;
        @com.google.gson.annotations.SerializedName("workwear-all")
        private String workwearall;

        public String getCampuswearlatestsale() {
            return campuswearlatestsale;
        }

        public void setCampuswearlatestsale(String campuswearlatestsale) {
            this.campuswearlatestsale = campuswearlatestsale;
        }

        public String getPartyall() {
            return partyall;
        }

        public void setPartyall(String partyall) {
            this.partyall = partyall;
        }

        public String getFestivewearjuly() {
            return Festivewearjuly;
        }

        public void setFestivewearjuly(String Festivewearjuly) {
            this.Festivewearjuly = Festivewearjuly;
        }

        public String getWorkwearall() {
            return workwearall;
        }

        public void setWorkwearall(String workwearall) {
            this.workwearall = workwearall;
        }
    }

    public static class ConfigBean {
        private boolean front_page_request;
        private String page_title;
        private String page_description;
        private java.util.List<String> page_keywords;

        public boolean isFront_page_request() {
            return front_page_request;
        }

        public void setFront_page_request(boolean front_page_request) {
            this.front_page_request = front_page_request;
        }

        public String getPage_title() {
            return page_title;
        }

        public void setPage_title(String page_title) {
            this.page_title = page_title;
        }

        public String getPage_description() {
            return page_description;
        }

        public void setPage_description(String page_description) {
            this.page_description = page_description;
        }

        public List<String> getPage_keywords() {
            return page_keywords;
        }

        public void setPage_keywords(List<String> page_keywords) {
            this.page_keywords = page_keywords;
        }
    }

    public static class CreditDataBean {
        private int approved_credits;
        private int unapproved_credits;

        public int getApproved_credits() {
            return approved_credits;
        }

        public void setApproved_credits(int approved_credits) {
            this.approved_credits = approved_credits;
        }

        public int getUnapproved_credits() {
            return unapproved_credits;
        }

        public void setUnapproved_credits(int unapproved_credits) {
            this.unapproved_credits = unapproved_credits;
        }
    }

    public static class CurrentUserBean {
        private int id;
        private String name;
        private String username;
        private String email;

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

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    public static class CurrentUserShipAddressBean {
        private int id;
        private String address1;
        private String address2;
        private String alternative_phone;
        private String city;
        private int country_id;
        private String created_at;
        private String firstname;
        private String location;
        private String phone;
        private int state_id;
        private String updated_at;
        private UserBean user;
        private int vaccount_id;
        private String zipcode;
        private String zone;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getAlternative_phone() {
            return alternative_phone;
        }

        public void setAlternative_phone(String alternative_phone) {
            this.alternative_phone = alternative_phone;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getCountry_id() {
            return country_id;
        }

        public void setCountry_id(int country_id) {
            this.country_id = country_id;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getState_id() {
            return state_id;
        }

        public void setState_id(int state_id) {
            this.state_id = state_id;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public int getVaccount_id() {
            return vaccount_id;
        }

        public void setVaccount_id(int vaccount_id) {
            this.vaccount_id = vaccount_id;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public String getZone() {
            return zone;
        }

        public void setZone(String zone) {
            this.zone = zone;
        }

        public static class UserBean {
            private int id;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }

    public static class DealBean {
    }

    public static class FashionEssentialHomepageBannerTextBean {
        @com.google.gson.annotations.SerializedName("Work Wear")
        private String _$WorkWear196; // FIXME check this code
        @com.google.gson.annotations.SerializedName("Campus Wear")
        private String _$CampusWear123; // FIXME check this code
        @com.google.gson.annotations.SerializedName("Festive Wear")
        private String _$FestiveWear143; // FIXME check this code
        @com.google.gson.annotations.SerializedName("Party Wear")
        private String _$PartyWear266; // FIXME check this code

        public String get_$WorkWear196() {
            return _$WorkWear196;
        }

        public void set_$WorkWear196(String _$WorkWear196) {
            this._$WorkWear196 = _$WorkWear196;
        }

        public String get_$CampusWear123() {
            return _$CampusWear123;
        }

        public void set_$CampusWear123(String _$CampusWear123) {
            this._$CampusWear123 = _$CampusWear123;
        }

        public String get_$FestiveWear143() {
            return _$FestiveWear143;
        }

        public void set_$FestiveWear143(String _$FestiveWear143) {
            this._$FestiveWear143 = _$FestiveWear143;
        }

        public String get_$PartyWear266() {
            return _$PartyWear266;
        }

        public void set_$PartyWear266(String _$PartyWear266) {
            this._$PartyWear266 = _$PartyWear266;
        }
    }

    public static class FashionEssentialHomepageBannersBean {
        @com.google.gson.annotations.SerializedName("campus-wear-latest-sale")
        private String campuswearlatestsale;
        @com.google.gson.annotations.SerializedName("party-all")
        private String partyall;
        @com.google.gson.annotations.SerializedName("Festive-wear-july")
        private String Festivewearjuly;
        @com.google.gson.annotations.SerializedName("workwear-all")
        private String workwearall;

        public String getCampuswearlatestsale() {
            return campuswearlatestsale;
        }

        public void setCampuswearlatestsale(String campuswearlatestsale) {
            this.campuswearlatestsale = campuswearlatestsale;
        }

        public String getPartyall() {
            return partyall;
        }

        public void setPartyall(String partyall) {
            this.partyall = partyall;
        }

        public String getFestivewearjuly() {
            return Festivewearjuly;
        }

        public void setFestivewearjuly(String Festivewearjuly) {
            this.Festivewearjuly = Festivewearjuly;
        }

        public String getWorkwearall() {
            return workwearall;
        }

        public void setWorkwearall(String workwearall) {
            this.workwearall = workwearall;
        }
    }

    public static class FeaturedFeedHashBean {
        private boolean show_featured_collection;

        public boolean isShow_featured_collection() {
            return show_featured_collection;
        }

        public void setShow_featured_collection(boolean show_featured_collection) {
            this.show_featured_collection = show_featured_collection;
        }
    }

    public static class PageBean {
        private DynamicPageBean dynamic_page;

        public DynamicPageBean getDynamic_page() {
            return dynamic_page;
        }

        public void setDynamic_page(DynamicPageBean dynamic_page) {
            this.dynamic_page = dynamic_page;
        }

        public static class DynamicPageBean {
            private String constructable_config;
            private String slug;
            private String title;

            public String getConstructable_config() {
                return constructable_config;
            }

            public void setConstructable_config(String constructable_config) {
                this.constructable_config = constructable_config;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }

    public static class ParamsBeBean {
        private String controller;
        private String format;
        private String action;
        private String term;

        public String getController() {
            return controller;
        }

        public void setController(String controller) {
            this.controller = controller;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getTerm() {
            return term;
        }

        public void setTerm(String term) {
            this.term = term;
        }
    }

    public static class QuickFiltersBean {
    }

    public static class ShowCaseSideCol1Bean {
        @com.google.gson.annotations.SerializedName("/online-store/lakme")
        private String _$OnlinestoreLakme215; // FIXME check this code
        @com.google.gson.annotations.SerializedName("/online-store/pluss")
        private String _$OnlinestorePluss78; // FIXME check this code
        @com.google.gson.annotations.SerializedName("/online-store/besiva")
        private String _$OnlinestoreBesiva201; // FIXME check this code
        @com.google.gson.annotations.SerializedName("/shopping/clovia")
        private String _$ShoppingClovia326; // FIXME check this code
        @com.google.gson.annotations.SerializedName("/shopping/jaipur-kurti")
        private String _$ShoppingJaipurkurti75; // FIXME check this code
        @com.google.gson.annotations.SerializedName("/shopping/khadims")
        private String _$ShoppingKhadims154; // FIXME check this code
        @com.google.gson.annotations.SerializedName("/online-store/voylla")
        private String _$OnlinestoreVoylla307; // FIXME check this code
        @com.google.gson.annotations.SerializedName("/online-store/maybelline")
        private String _$OnlinestoreMaybelline169; // FIXME check this code
        @com.google.gson.annotations.SerializedName("/shopping/ace-turtle")
        private String _$ShoppingAceturtle182; // FIXME check this code
        @com.google.gson.annotations.SerializedName("/shopping/intima-retail")
        private String _$ShoppingIntimaretail120; // FIXME check this code
        @com.google.gson.annotations.SerializedName("/online-store/caprese")
        private String _$OnlinestoreCaprese299; // FIXME check this code
        @com.google.gson.annotations.SerializedName("/online-store/w")
        private String _$OnlinestoreW236; // FIXME check this code

        public String get_$OnlinestoreLakme215() {
            return _$OnlinestoreLakme215;
        }

        public void set_$OnlinestoreLakme215(String _$OnlinestoreLakme215) {
            this._$OnlinestoreLakme215 = _$OnlinestoreLakme215;
        }

        public String get_$OnlinestorePluss78() {
            return _$OnlinestorePluss78;
        }

        public void set_$OnlinestorePluss78(String _$OnlinestorePluss78) {
            this._$OnlinestorePluss78 = _$OnlinestorePluss78;
        }

        public String get_$OnlinestoreBesiva201() {
            return _$OnlinestoreBesiva201;
        }

        public void set_$OnlinestoreBesiva201(String _$OnlinestoreBesiva201) {
            this._$OnlinestoreBesiva201 = _$OnlinestoreBesiva201;
        }

        public String get_$ShoppingClovia326() {
            return _$ShoppingClovia326;
        }

        public void set_$ShoppingClovia326(String _$ShoppingClovia326) {
            this._$ShoppingClovia326 = _$ShoppingClovia326;
        }

        public String get_$ShoppingJaipurkurti75() {
            return _$ShoppingJaipurkurti75;
        }

        public void set_$ShoppingJaipurkurti75(String _$ShoppingJaipurkurti75) {
            this._$ShoppingJaipurkurti75 = _$ShoppingJaipurkurti75;
        }

        public String get_$ShoppingKhadims154() {
            return _$ShoppingKhadims154;
        }

        public void set_$ShoppingKhadims154(String _$ShoppingKhadims154) {
            this._$ShoppingKhadims154 = _$ShoppingKhadims154;
        }

        public String get_$OnlinestoreVoylla307() {
            return _$OnlinestoreVoylla307;
        }

        public void set_$OnlinestoreVoylla307(String _$OnlinestoreVoylla307) {
            this._$OnlinestoreVoylla307 = _$OnlinestoreVoylla307;
        }

        public String get_$OnlinestoreMaybelline169() {
            return _$OnlinestoreMaybelline169;
        }

        public void set_$OnlinestoreMaybelline169(String _$OnlinestoreMaybelline169) {
            this._$OnlinestoreMaybelline169 = _$OnlinestoreMaybelline169;
        }

        public String get_$ShoppingAceturtle182() {
            return _$ShoppingAceturtle182;
        }

        public void set_$ShoppingAceturtle182(String _$ShoppingAceturtle182) {
            this._$ShoppingAceturtle182 = _$ShoppingAceturtle182;
        }

        public String get_$ShoppingIntimaretail120() {
            return _$ShoppingIntimaretail120;
        }

        public void set_$ShoppingIntimaretail120(String _$ShoppingIntimaretail120) {
            this._$ShoppingIntimaretail120 = _$ShoppingIntimaretail120;
        }

        public String get_$OnlinestoreCaprese299() {
            return _$OnlinestoreCaprese299;
        }

        public void set_$OnlinestoreCaprese299(String _$OnlinestoreCaprese299) {
            this._$OnlinestoreCaprese299 = _$OnlinestoreCaprese299;
        }

        public String get_$OnlinestoreW236() {
            return _$OnlinestoreW236;
        }

        public void set_$OnlinestoreW236(String _$OnlinestoreW236) {
            this._$OnlinestoreW236 = _$OnlinestoreW236;
        }
    }

    public static class ShowCaseSideCol2Bean {
        @com.google.gson.annotations.SerializedName("/online-store/soch")
        private String _$OnlinestoreSoch193; // FIXME check this code
        @com.google.gson.annotations.SerializedName("/shopping/zivame")
        private String _$ShoppingZivame230; // FIXME check this code
        @com.google.gson.annotations.SerializedName("/online-store/fastrack")
        private String _$OnlinestoreFastrack240; // FIXME check this code
        @com.google.gson.annotations.SerializedName("/online-store/tresemme")
        private String _$OnlinestoreTresemme298; // FIXME check this code
        @com.google.gson.annotations.SerializedName("/online-store/l-oreal")
        private String _$OnlinestoreLoreal95; // FIXME check this code
        @com.google.gson.annotations.SerializedName("/online-store/prym")
        private String _$OnlinestorePrym312; // FIXME check this code
        @com.google.gson.annotations.SerializedName("/online-store/aurelia")
        private String _$OnlinestoreAurelia166; // FIXME check this code
        @com.google.gson.annotations.SerializedName("/shopping/the-chennai-silks")
        private String _$ShoppingThechennaisilks8; // FIXME check this code
        @com.google.gson.annotations.SerializedName("/online-store/puma")
        private String _$OnlinestorePuma255; // FIXME check this code
        @com.google.gson.annotations.SerializedName("/online-store/yepme")
        private String _$OnlinestoreYepme287; // FIXME check this code
        @com.google.gson.annotations.SerializedName("/online-store/shuffle")
        private String _$OnlinestoreShuffle157; // FIXME check this code
        @com.google.gson.annotations.SerializedName("/online-store/revlon")
        private String _$OnlinestoreRevlon244; // FIXME check this code

        public String get_$OnlinestoreSoch193() {
            return _$OnlinestoreSoch193;
        }

        public void set_$OnlinestoreSoch193(String _$OnlinestoreSoch193) {
            this._$OnlinestoreSoch193 = _$OnlinestoreSoch193;
        }

        public String get_$ShoppingZivame230() {
            return _$ShoppingZivame230;
        }

        public void set_$ShoppingZivame230(String _$ShoppingZivame230) {
            this._$ShoppingZivame230 = _$ShoppingZivame230;
        }

        public String get_$OnlinestoreFastrack240() {
            return _$OnlinestoreFastrack240;
        }

        public void set_$OnlinestoreFastrack240(String _$OnlinestoreFastrack240) {
            this._$OnlinestoreFastrack240 = _$OnlinestoreFastrack240;
        }

        public String get_$OnlinestoreTresemme298() {
            return _$OnlinestoreTresemme298;
        }

        public void set_$OnlinestoreTresemme298(String _$OnlinestoreTresemme298) {
            this._$OnlinestoreTresemme298 = _$OnlinestoreTresemme298;
        }

        public String get_$OnlinestoreLoreal95() {
            return _$OnlinestoreLoreal95;
        }

        public void set_$OnlinestoreLoreal95(String _$OnlinestoreLoreal95) {
            this._$OnlinestoreLoreal95 = _$OnlinestoreLoreal95;
        }

        public String get_$OnlinestorePrym312() {
            return _$OnlinestorePrym312;
        }

        public void set_$OnlinestorePrym312(String _$OnlinestorePrym312) {
            this._$OnlinestorePrym312 = _$OnlinestorePrym312;
        }

        public String get_$OnlinestoreAurelia166() {
            return _$OnlinestoreAurelia166;
        }

        public void set_$OnlinestoreAurelia166(String _$OnlinestoreAurelia166) {
            this._$OnlinestoreAurelia166 = _$OnlinestoreAurelia166;
        }

        public String get_$ShoppingThechennaisilks8() {
            return _$ShoppingThechennaisilks8;
        }

        public void set_$ShoppingThechennaisilks8(String _$ShoppingThechennaisilks8) {
            this._$ShoppingThechennaisilks8 = _$ShoppingThechennaisilks8;
        }

        public String get_$OnlinestorePuma255() {
            return _$OnlinestorePuma255;
        }

        public void set_$OnlinestorePuma255(String _$OnlinestorePuma255) {
            this._$OnlinestorePuma255 = _$OnlinestorePuma255;
        }

        public String get_$OnlinestoreYepme287() {
            return _$OnlinestoreYepme287;
        }

        public void set_$OnlinestoreYepme287(String _$OnlinestoreYepme287) {
            this._$OnlinestoreYepme287 = _$OnlinestoreYepme287;
        }

        public String get_$OnlinestoreShuffle157() {
            return _$OnlinestoreShuffle157;
        }

        public void set_$OnlinestoreShuffle157(String _$OnlinestoreShuffle157) {
            this._$OnlinestoreShuffle157 = _$OnlinestoreShuffle157;
        }

        public String get_$OnlinestoreRevlon244() {
            return _$OnlinestoreRevlon244;
        }

        public void set_$OnlinestoreRevlon244(String _$OnlinestoreRevlon244) {
            this._$OnlinestoreRevlon244 = _$OnlinestoreRevlon244;
        }
    }

    // FIXME generate failure  field _$PartyWear275
// FIXME generate failure  field _$FestiveWear3
// FIXME generate failure  field _$CampusWear60
// FIXME generate failure  field _$WorkWear267
    public static class SubCategoriesForFiltersWebBean {
        public static class WorkWearBean {
            private String Shirts;
            private String Kurtis;
            private String Skirts;
            private String Tops;
            private String Jackets;
            private String Trousers;

            public String getShirts() {
                return Shirts;
            }

            public void setShirts(String Shirts) {
                this.Shirts = Shirts;
            }

            public String getKurtis() {
                return Kurtis;
            }

            public void setKurtis(String Kurtis) {
                this.Kurtis = Kurtis;
            }

            public String getSkirts() {
                return Skirts;
            }

            public void setSkirts(String Skirts) {
                this.Skirts = Skirts;
            }

            public String getTops() {
                return Tops;
            }

            public void setTops(String Tops) {
                this.Tops = Tops;
            }

            public String getJackets() {
                return Jackets;
            }

            public void setJackets(String Jackets) {
                this.Jackets = Jackets;
            }

            public String getTrousers() {
                return Trousers;
            }

            public void setTrousers(String Trousers) {
                this.Trousers = Trousers;
            }
        }

        public static class CampusWearBean {
            private String Jeggings;
            private String Shirts;
            private String Jewellery;
            @com.google.gson.annotations.SerializedName("Kurta Kurtis")
            private String _$KurtaKurtis206; // FIXME check this code
            private String Leggings;
            @com.google.gson.annotations.SerializedName("Tops & Tunics")
            private String _$TopsTunics290; // FIXME check this code
            @com.google.gson.annotations.SerializedName("Ethnic Bottoms")
            private String _$EthnicBottoms127; // FIXME check this code
            @com.google.gson.annotations.SerializedName("3/4 Pants & Capris")
            private String _$_34PantsCapris296; // FIXME check this code
            private String Jeans;
            private String Shoes;
            private String Trousers;
            @com.google.gson.annotations.SerializedName("T-Shirts")
            private String TShirts;

            public String getJeggings() {
                return Jeggings;
            }

            public void setJeggings(String Jeggings) {
                this.Jeggings = Jeggings;
            }

            public String getShirts() {
                return Shirts;
            }

            public void setShirts(String Shirts) {
                this.Shirts = Shirts;
            }

            public String getJewellery() {
                return Jewellery;
            }

            public void setJewellery(String Jewellery) {
                this.Jewellery = Jewellery;
            }

            public String get_$KurtaKurtis206() {
                return _$KurtaKurtis206;
            }

            public void set_$KurtaKurtis206(String _$KurtaKurtis206) {
                this._$KurtaKurtis206 = _$KurtaKurtis206;
            }

            public String getLeggings() {
                return Leggings;
            }

            public void setLeggings(String Leggings) {
                this.Leggings = Leggings;
            }

            public String get_$TopsTunics290() {
                return _$TopsTunics290;
            }

            public void set_$TopsTunics290(String _$TopsTunics290) {
                this._$TopsTunics290 = _$TopsTunics290;
            }

            public String get_$EthnicBottoms127() {
                return _$EthnicBottoms127;
            }

            public void set_$EthnicBottoms127(String _$EthnicBottoms127) {
                this._$EthnicBottoms127 = _$EthnicBottoms127;
            }

            public String get_$_34PantsCapris296() {
                return _$_34PantsCapris296;
            }

            public void set_$_34PantsCapris296(String _$_34PantsCapris296) {
                this._$_34PantsCapris296 = _$_34PantsCapris296;
            }

            public String getJeans() {
                return Jeans;
            }

            public void setJeans(String Jeans) {
                this.Jeans = Jeans;
            }

            public String getShoes() {
                return Shoes;
            }

            public void setShoes(String Shoes) {
                this.Shoes = Shoes;
            }

            public String getTrousers() {
                return Trousers;
            }

            public void setTrousers(String Trousers) {
                this.Trousers = Trousers;
            }

            public String getTShirts() {
                return TShirts;
            }

            public void setTShirts(String TShirts) {
                this.TShirts = TShirts;
            }
        }

        public static class FestiveWearBean {
            private String Sarees;
            private String Gowns;
            private String Shoes;
            private String Lehangas;
            @com.google.gson.annotations.SerializedName("Saree Blouses")
            private String _$SareeBlouses241; // FIXME check this code

            public String getSarees() {
                return Sarees;
            }

            public void setSarees(String Sarees) {
                this.Sarees = Sarees;
            }

            public String getGowns() {
                return Gowns;
            }

            public void setGowns(String Gowns) {
                this.Gowns = Gowns;
            }

            public String getShoes() {
                return Shoes;
            }

            public void setShoes(String Shoes) {
                this.Shoes = Shoes;
            }

            public String getLehangas() {
                return Lehangas;
            }

            public void setLehangas(String Lehangas) {
                this.Lehangas = Lehangas;
            }

            public String get_$SareeBlouses241() {
                return _$SareeBlouses241;
            }

            public void set_$SareeBlouses241(String _$SareeBlouses241) {
                this._$SareeBlouses241 = _$SareeBlouses241;
            }
        }

        public static class PartyWearBean {
            private String Dresses;
            private String Jewellery;
            private String Skirts;
            private String Tops;
            private String Shoes;

            public String getDresses() {
                return Dresses;
            }

            public void setDresses(String Dresses) {
                this.Dresses = Dresses;
            }

            public String getJewellery() {
                return Jewellery;
            }

            public void setJewellery(String Jewellery) {
                this.Jewellery = Jewellery;
            }

            public String getSkirts() {
                return Skirts;
            }

            public void setSkirts(String Skirts) {
                this.Skirts = Skirts;
            }

            public String getTops() {
                return Tops;
            }

            public void setTops(String Tops) {
                this.Tops = Tops;
            }

            public String getShoes() {
                return Shoes;
            }

            public void setShoes(String Shoes) {
                this.Shoes = Shoes;
            }
        }
    }
}
