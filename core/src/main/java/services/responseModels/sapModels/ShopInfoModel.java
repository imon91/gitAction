package services.responseModels.sapModels;

import java.io.Serializable;
import java.util.List;

public class ShopInfoModel {

    /**
     * error : false
     * count : 1
     * shops : [{"id":649705,"shopName":"SAP Sanity Test Shop","shopPhone":"8801401122188","pickupPhone":"8801401122188","pickupAddress":"Uttara, Uttora","shopAddress":"Uttara, Uttora","pageId":null,"superSeller":0,"sourceSeller":0,"prioritySeller":0,"intShippingEnabled":0,"isResellerSourceSeller":0,"bkashEnabled":0,"selfBkashEnabled":0,"creditCardEnabled":0,"isC2cShop":0,"area":"Uttara"}]
     */

    private boolean error;
    private int count;
    private List<ShopsBean> shops;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ShopsBean> getShops() {
        return shops;
    }

    public void setShops(List<ShopsBean> shops) {
        this.shops = shops;
    }

    public static class ShopsBean implements Serializable {
        /**
         * id : 649705
         * shopName : SAP Sanity Test Shop
         * shopPhone : 8801401122188
         * pickupPhone : 8801401122188
         * pickupAddress : Uttara, Uttora
         * shopAddress : Uttara, Uttora
         * pageId : null
         * superSeller : 0
         * sourceSeller : 0
         * prioritySeller : 0
         * intShippingEnabled : 0
         * isResellerSourceSeller : 0
         * bkashEnabled : 0
         * selfBkashEnabled : 0
         * creditCardEnabled : 0
         * isC2cShop : 0
         * area : Uttara
         */

        private int id;
        private String shopName;
        private String shopPhone;
        private String pickupPhone;
        private String pickupAddress;
        private String shopAddress;
        private Object pageId;
        private int superSeller;
        private int sourceSeller;
        private int prioritySeller;
        private int intShippingEnabled;
        private int isResellerSourceSeller;
        private int bkashEnabled;
        private int selfBkashEnabled;
        private int creditCardEnabled;
        private int isC2cShop;
        private String area;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getShopPhone() {
            return shopPhone;
        }

        public void setShopPhone(String shopPhone) {
            this.shopPhone = shopPhone;
        }

        public String getPickupPhone() {
            return pickupPhone;
        }

        public void setPickupPhone(String pickupPhone) {
            this.pickupPhone = pickupPhone;
        }

        public String getPickupAddress() {
            return pickupAddress;
        }

        public void setPickupAddress(String pickupAddress) {
            this.pickupAddress = pickupAddress;
        }

        public String getShopAddress() {
            return shopAddress;
        }

        public void setShopAddress(String shopAddress) {
            this.shopAddress = shopAddress;
        }

        public Object getPageId() {
            return pageId;
        }

        public void setPageId(Object pageId) {
            this.pageId = pageId;
        }

        public int getSuperSeller() {
            return superSeller;
        }

        public void setSuperSeller(int superSeller) {
            this.superSeller = superSeller;
        }

        public int getSourceSeller() {
            return sourceSeller;
        }

        public void setSourceSeller(int sourceSeller) {
            this.sourceSeller = sourceSeller;
        }

        public int getPrioritySeller() {
            return prioritySeller;
        }

        public void setPrioritySeller(int prioritySeller) {
            this.prioritySeller = prioritySeller;
        }

        public int getIntShippingEnabled() {
            return intShippingEnabled;
        }

        public void setIntShippingEnabled(int intShippingEnabled) {
            this.intShippingEnabled = intShippingEnabled;
        }

        public int getIsResellerSourceSeller() {
            return isResellerSourceSeller;
        }

        public void setIsResellerSourceSeller(int isResellerSourceSeller) {
            this.isResellerSourceSeller = isResellerSourceSeller;
        }

        public int getBkashEnabled() {
            return bkashEnabled;
        }

        public void setBkashEnabled(int bkashEnabled) {
            this.bkashEnabled = bkashEnabled;
        }

        public int getSelfBkashEnabled() {
            return selfBkashEnabled;
        }

        public void setSelfBkashEnabled(int selfBkashEnabled) {
            this.selfBkashEnabled = selfBkashEnabled;
        }

        public int getCreditCardEnabled() {
            return creditCardEnabled;
        }

        public void setCreditCardEnabled(int creditCardEnabled) {
            this.creditCardEnabled = creditCardEnabled;
        }

        public int getIsC2cShop() {
            return isC2cShop;
        }

        public void setIsC2cShop(int isC2cShop) {
            this.isC2cShop = isC2cShop;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }
    }
}
