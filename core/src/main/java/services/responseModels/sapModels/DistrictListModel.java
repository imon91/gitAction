package services.responseModels.sapModels;

import java.io.Serializable;
import java.util.List;

public class DistrictListModel {

    /**
     * isError : false
     * districts : [{"id":18,"name":"Bagerhat","divisionId":3,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:05.545Z"},{"id":46,"name":"Bandarban","divisionId":7,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:24.737Z"},{"id":40,"name":"Barguna","divisionId":6,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:19.944Z"},{"id":41,"name":"Barisal","divisionId":6,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:19.944Z"},{"id":42,"name":"Bhola","divisionId":6,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:19.944Z"},{"id":28,"name":"Bogra","divisionId":4,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:09.809Z"},{"id":47,"name":"Brahmanbaria","divisionId":7,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:24.737Z"},{"id":48,"name":"Chandpur","divisionId":7,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:24.737Z"},{"id":29,"name":"Chapai Nawabganj","divisionId":4,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:09.809Z"},{"id":49,"name":"Chittagong","divisionId":7,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:24.737Z"},{"id":19,"name":"Chuadanga","divisionId":3,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:05.545Z"},{"id":50,"name":"Comilla","divisionId":7,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:24.737Z"},{"id":51,"name":"Cox's Bazar","divisionId":7,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:24.737Z"},{"id":1,"name":"Dhaka","divisionId":1,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:30:50.192Z"},{"id":57,"name":"Dinajpur","divisionId":8,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:29.116Z"},{"id":2,"name":"Faridpur","divisionId":1,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:30:50.192Z"},{"id":52,"name":"Feni","divisionId":7,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:24.737Z"},{"id":58,"name":"Gaibandha","divisionId":8,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:29.116Z"},{"id":3,"name":"Gazipur","divisionId":1,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:30:50.192Z"},{"id":4,"name":"Gopalganj","divisionId":1,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:30:50.192Z"},{"id":36,"name":"Habiganj","divisionId":5,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:14.455Z"},{"id":5,"name":"Jamalpur","divisionId":2,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:30:32.798Z"},{"id":20,"name":"Jessore","divisionId":3,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:05.545Z"},{"id":43,"name":"Jhalokathi","divisionId":6,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:19.944Z"},{"id":21,"name":"Jhenaidah","divisionId":3,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:05.545Z"},{"id":30,"name":"Joypurhat","divisionId":4,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:09.809Z"},{"id":53,"name":"Khagrachari","divisionId":7,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:24.737Z"},{"id":22,"name":"Khulna","divisionId":3,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:05.545Z"},{"id":6,"name":"Kishoreganj","divisionId":1,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:30:50.192Z"},{"id":59,"name":"Kurigram","divisionId":8,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:29.116Z"},{"id":23,"name":"Kushtia","divisionId":3,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:05.545Z"},{"id":54,"name":"Laksmipur","divisionId":7,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:24.737Z"},{"id":60,"name":"Lalmonirhat","divisionId":8,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:29.116Z"},{"id":7,"name":"Madaripur","divisionId":1,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:30:50.192Z"},{"id":24,"name":"Magura","divisionId":3,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:05.545Z"},{"id":8,"name":"Manikganj","divisionId":1,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:30:50.192Z"},{"id":25,"name":"Meherpur","divisionId":3,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:05.545Z"},{"id":37,"name":"Moulvibazar","divisionId":5,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:14.455Z"},{"id":9,"name":"Munshiganj","divisionId":1,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:30:50.192Z"},{"id":10,"name":"Mymensingh","divisionId":2,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:30:32.798Z"},{"id":31,"name":"Naogaon","divisionId":4,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:09.809Z"},{"id":26,"name":"Narail","divisionId":3,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:05.545Z"},{"id":11,"name":"Narayanganj","divisionId":1,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:30:50.192Z"},{"id":32,"name":"Natore","divisionId":4,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:09.809Z"},{"id":13,"name":"Netrokona","divisionId":2,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:30:32.798Z"},{"id":61,"name":"Nilphamari","divisionId":8,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:29.116Z"},{"id":55,"name":"Noakhali","divisionId":7,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:24.737Z"},{"id":12,"name":"Norshingdi","divisionId":1,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:30:50.192Z"},{"id":33,"name":"Pabna","divisionId":4,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:09.809Z"},{"id":62,"name":"Panchagarh","divisionId":8,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:29.116Z"},{"id":44,"name":"Patuakhali","divisionId":6,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:19.944Z"},{"id":45,"name":"Perojpur","divisionId":6,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:19.944Z"},{"id":14,"name":"Rajbari","divisionId":1,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:30:50.192Z"},{"id":34,"name":"Rajshahi","divisionId":4,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:09.809Z"},{"id":56,"name":"Rangamati","divisionId":7,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:24.737Z"},{"id":63,"name":"Rangpur","divisionId":8,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:29.116Z"},{"id":27,"name":"Satkhira","divisionId":3,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:05.545Z"},{"id":15,"name":"Shariatpur","divisionId":1,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:30:50.192Z"},{"id":16,"name":"Sherpur","divisionId":2,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:30:32.798Z"},{"id":35,"name":"Sirajganj","divisionId":4,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:09.809Z"},{"id":38,"name":"Sunamganj","divisionId":5,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:14.455Z"},{"id":39,"name":"Sylhet","divisionId":5,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:14.455Z"},{"id":17,"name":"Tangail","divisionId":1,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:30:50.192Z"},{"id":64,"name":"Thakurgaon","divisionId":8,"createdAt":"2020-01-13T14:48:51.000Z","updatedAt":"2020-10-22T13:31:29.116Z"}]
     */

    private boolean isError;
    private List<DistrictsBean> districts;

    public boolean isIsError() {
        return isError;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
    }

    public List<DistrictsBean> getDistricts() {
        return districts;
    }

    public void setDistricts(List<DistrictsBean> districts) {
        this.districts = districts;
    }

    public static class DistrictsBean implements Serializable {
        /**
         * id : 18
         * name : Bagerhat
         * divisionId : 3
         * createdAt : 2020-01-13T14:48:51.000Z
         * updatedAt : 2020-10-22T13:31:05.545Z
         */

        private int id;
        private String name;
        private int divisionId;
        private String createdAt;
        private String updatedAt;

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

        public int getDivisionId() {
            return divisionId;
        }

        public void setDivisionId(int divisionId) {
            this.divisionId = divisionId;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }
    }
}
