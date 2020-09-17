package services.responseModels.omsModels;

public class AdminMasterTemplate {
    String category;
    int sellerCode;
    String sku;
    int productId;
    String itemName;
    String description;
    String updateOrDelete;
    int maxSalePrice;
    int discountedSalePrice;
    int liftingPrice;
    int quantity;
    String size;
    int leadTime;
    String weight;
    String url;

    public AdminMasterTemplate(String category, int sellerCode, String sku, int productId, String itemName, String description, String updateOrDelete, int maxSalePrice, int discountedSalePrice, int liftingPrice, int quantity, String size, int leadTime, String weight, String url) {
        this.category = category;
        this.sellerCode = sellerCode;
        this.sku = sku;
        this.productId = productId;
        this.itemName = itemName;
        this.description = description;
        this.updateOrDelete = updateOrDelete;
        this.maxSalePrice = maxSalePrice;
        this.discountedSalePrice = discountedSalePrice;
        this.liftingPrice = liftingPrice;
        this.quantity = quantity;
        this.size = size;
        this.leadTime = leadTime;
        this.weight = weight;
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(int sellerCode) {
        this.sellerCode = sellerCode;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdateOrDelete() {
        return updateOrDelete;
    }

    public void setUpdateOrDelete(String updateOrDelete) {
        this.updateOrDelete = updateOrDelete;
    }

    public int getMaxSalePrice() {
        return maxSalePrice;
    }

    public void setMaxSalePrice(int maxSalePrice) {
        this.maxSalePrice = maxSalePrice;
    }

    public int getDiscountedSalePrice() {
        return discountedSalePrice;
    }

    public void setDiscountedSalePrice(int discountedSalePrice) {
        this.discountedSalePrice = discountedSalePrice;
    }

    public int getLiftingPrice() {
        return liftingPrice;
    }

    public void setLiftingPrice(int liftingPrice) {
        this.liftingPrice = liftingPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(int leadTime) {
        this.leadTime = leadTime;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
