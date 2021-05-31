package services.responseModels.sapModels;

import java.io.Serializable;
import java.util.List;

public class ShopNameListModel {

    /**
     * error : false
     * count : 70437
     * shops : [{"id":192,"name":"Kreative Korals","pickupAddress":"50, Lake Circus, Kalabagan Dhaka","shopPhone":"01720018642","createdAt":"2016-02-09T11:54:54.000Z"},{"id":395,"name":"E-Sports","pickupAddress":"kalabagan","shopPhone":"01678600786","createdAt":"2016-05-09T10:12:25.000Z"},{"id":781,"name":"Kreative Kindle","pickupAddress":"2/KA/1 Mohammadpur, dhaka Dil Goni Market.","shopPhone":"+8801871011054","createdAt":"2016-07-17T14:01:08.000Z"},{"id":2442,"name":"Guchipu","pickupAddress":"Behind suchona community center mohammadpur","shopPhone":"+8801832888121","createdAt":"2017-04-04T18:58:20.000Z"},{"id":2818,"name":"Lokoj","pickupAddress":"114,Moniprui Para, Farmgate","shopPhone":"8801679846942","createdAt":"2017-06-20T18:56:07.000Z"}]
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
         * id : 192
         * name : Kreative Korals
         * pickupAddress : 50, Lake Circus, Kalabagan Dhaka
         * shopPhone : 01720018642
         * createdAt : 2016-02-09T11:54:54.000Z
         */

        private int id;
        private String name;
        private String pickupAddress;
        private String shopPhone;
        private String createdAt;

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

        public String getPickupAddress() {
            return pickupAddress;
        }

        public void setPickupAddress(String pickupAddress) {
            this.pickupAddress = pickupAddress;
        }

        public String getShopPhone() {
            return shopPhone;
        }

        public void setShopPhone(String shopPhone) {
            this.shopPhone = shopPhone;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }
    }
}
