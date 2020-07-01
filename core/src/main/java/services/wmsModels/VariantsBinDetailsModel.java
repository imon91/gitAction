package services.wmsModels;

import java.io.Serializable;
import java.util.List;

public class VariantsBinDetailsModel {


    /**
     * success : true
     * bin_details : [{"id":null,"bin_code":"W100F2R1C1RA1B23","count":6,"package_ids":"134996,134998,135006,135007,135008,135029"},{"id":null,"bin_code":"W100F2R1C1RA1B31","count":5,"package_ids":"135004,135009,135010,135027,135028"},{"id":null,"bin_code":"W100F2R1C1RA1B33","count":11,"package_ids":"135051,135052,135053,942293,942294,942295,942296,942297,942298,942299,942300"},{"id":null,"bin_code":"W100F2R1C1RA2B12","count":7,"package_ids":"135255,135256,135257,135258,135259,135260,135261"},{"id":null,"bin_code":"W100F2R1C1RA2B13","count":10,"package_ids":"135262,135263,135264,135265,135266,135267,135268,135269,135270,135271"},{"id":null,"bin_code":"W100F2R1C1RA2B21","count":10,"package_ids":"135272,135273,135274,135275,135276,135277,135278,135279,135280,135281"},{"id":null,"bin_code":"W100F2R1C1RA2B22","count":10,"package_ids":"135282,135283,135284,135285,135286,135287,135288,135289,135290,135291"},{"id":null,"bin_code":"W100F2R1C1RA2B23","count":10,"package_ids":"135292,135293,135294,135295,135296,135297,135298,135299,135300,135301"},{"id":null,"bin_code":"W100F2R1C1RA2B31","count":10,"package_ids":"135302,135303,135304,135305,135306,135307,135308,135309,135310,135311"},{"id":null,"bin_code":"W100F2R1C1RA2B32","count":10,"package_ids":"135312,135313,135314,135315,135316,135317,135318,135319,135320,135321"},{"id":null,"bin_code":"W100F2R1C1RA2B33","count":10,"package_ids":"135322,135323,135324,135325,135326,135327,135328,135329,135330,135331"},{"id":null,"bin_code":"W100F2R1C1RA2B41","count":10,"package_ids":"135332,135333,135334,135335,135336,135337,135338,135339,135340,135341"},{"id":null,"bin_code":"W100F2R1C1RA2B42","count":10,"package_ids":"135342,135343,135344,135345,135346,135347,135348,135349,135350,135351"},{"id":null,"bin_code":"W100F2R1C1RA2B43","count":2,"package_ids":"135353,135354"},{"id":null,"bin_code":"W100F2R1C1RA4B11","count":2,"package_ids":"942301,942302"}]
     */

    private boolean success;
    private List<BinDetailsBean> bin_details;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<BinDetailsBean> getBin_details() {
        return bin_details;
    }

    public void setBin_details(List<BinDetailsBean> bin_details) {
        this.bin_details = bin_details;
    }

    public static class BinDetailsBean implements Serializable {
        /**
         * id : null
         * bin_code : W100F2R1C1RA1B23
         * count : 6
         * package_ids : 134996,134998,135006,135007,135008,135029
         */

        private Object id;
        private String bin_code;
        private int count;
        private String package_ids;

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public String getBin_code() {
            return bin_code;
        }

        public void setBin_code(String bin_code) {
            this.bin_code = bin_code;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getPackage_ids() {
            return package_ids;
        }

        public void setPackage_ids(String package_ids) {
            this.package_ids = package_ids;
        }
    }
}
