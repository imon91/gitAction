package services.responseModels.commerceModels;

import java.util.List;

public class MokamRetailerListModel {

    /**
     * status : true
     * user_data : [{"id":2489657,"name":"peter","phone":"8801877755590"},{"id":2491585,"name":"8801975269269","phone":"8801975269269"},{"id":111625273,"name":"testFinal3","phone":"8801877775590"},{"id":111625274,"name":"abcde","phone":"8801877775591"},{"id":111625275,"name":"8801877775592","phone":"8801877775592"},{"id":111625343,"name":"8801322222222","phone":"8801322222222"},{"id":111627466,"name":"8801313131313","phone":"8801313131313"},{"id":111629696,"name":"owner","phone":"8801333333333"},{"id":111633568,"name":"8801343434346","phone":"8801343434346"},{"id":111633571,"name":"8801823743247","phone":"8801823743247"},{"id":111633574,"name":"8801863463633","phone":"8801863463633"},{"id":111633576,"name":"Aman","phone":"8801312121212"},{"id":111633581,"name":"Amandeep","phone":"8801826263232"},{"id":111633635,"name":"cha-cha","phone":"8801344444466"},{"id":111633643,"name":"owner","phone":"8801395959595"},{"id":111633694,"name":"Tera bhai","phone":"8801344334433"},{"id":111633696,"name":"Me Myself","phone":"8801322222244"},{"id":111634271,"name":"siva","phone":"8801855577790"},{"id":111634274,"name":"Ashok","phone":"8801877755520"},{"id":111634275,"name":"888","phone":"8801828282833"},{"id":111634277,"name":"8801851664914","phone":"8801851664914"},{"id":111634278,"name":"test63&+-","phone":"8801855577710"},{"id":111634279,"name":"8801855559999","phone":"8801855559999"},{"id":111634280,"name":"8801899999990","phone":"8801899999990"},{"id":111634287,"name":"8801866965568","phone":"8801866965568"},{"id":111634288,"name":"8801877755599","phone":"8801877755599"},{"id":111634289,"name":"8801811111111","phone":"8801811111111"},{"id":111634292,"name":"8801333334433","phone":"8801333334433"},{"id":111634293,"name":"8801366677755","phone":"8801366677755"},{"id":111634298,"name":"8801833443322","phone":"8801833443322"},{"id":111634299,"name":"Bro","phone":"8801888888828"},{"id":111634302,"name":"8801333333300","phone":"8801333333300"},{"id":111634303,"name":"8801696969696","phone":"8801696969696"},{"id":111634304,"name":"8801959595959","phone":"8801959595959"},{"id":111634306,"name":"8801666666666","phone":"8801666666666"},{"id":111634307,"name":"8801555555555","phone":"8801555555555"},{"id":111634308,"name":"Ashok","phone":"8801444444444"},{"id":111634309,"name":"8801822222222","phone":"8801822222222"},{"id":111634310,"name":"8801855555555","phone":"8801855555555"},{"id":111634312,"name":"8801844444444","phone":"8801844444444"},{"id":111634313,"name":"8801366666111","phone":"8801366666111"},{"id":111634317,"name":"8801322244225","phone":"8801322244225"},{"id":111634318,"name":"8801111544664","phone":"8801111544664"},{"id":111634319,"name":"8801100000400","phone":"8801100000400"},{"id":111634320,"name":"8801111111111","phone":"8801111111111"},{"id":111634321,"name":"Owner","phone":"8801155443344"},{"id":111634322,"name":"8801177777779","phone":"8801177777779"},{"id":111634323,"name":"8801664444448","phone":"8801664444448"},{"id":111634326,"name":"8801555533338","phone":"8801555533338"},{"id":111634328,"name":"hhjd","phone":"8801844455529"},{"id":111634329,"name":"ronaldo","phone":"8801855577742"},{"id":111634330,"name":"8801844231252","phone":"8801844231252"},{"id":111634331,"name":"8801855543649","phone":"8801855543649"},{"id":111634332,"name":"8801856465469","phone":"8801856465469"},{"id":111634333,"name":"8801877755540","phone":"8801877755540"},{"id":111634334,"name":"8801866643261","phone":"8801866643261"},{"id":111634335,"name":"vijay","phone":"8801854645646"},{"id":111634336,"name":"vijay","phone":"8801844450945"},{"id":111634337,"name":"michale 6666666666666666666666666666666666666666666666666666666666666666666666666666666666666","phone":"8801855465469"},{"id":111634338,"name":"Raina","phone":"8801846948919"},{"id":111634339,"name":"8801564995461","phone":"8801564995461"},{"id":111634340,"name":"Mokam","phone":"8801877755510"},{"id":111634341,"name":"8801877755530","phone":"8801877755530"},{"id":111634342,"name":"Unicorn","phone":"8801877755550"},{"id":111634343,"name":"8801877755248","phone":"8801877755248"},{"id":111634344,"name":"Unicorn ","phone":"8801877744450"},{"id":111634345,"name":"8801855554442","phone":"8801855554442"},{"id":111634348,"name":"QA India","phone":"8801877755500"},{"id":111634349,"name":"8801877755501","phone":"8801877755501"},{"id":111634350,"name":"8801877755905","phone":"8801877755905"},{"id":111634352,"name":"8801855566621","phone":"8801855566621"},{"id":111634353,"name":"8801855566680","phone":"8801855566680"},{"id":111634354,"name":"Steve","phone":"8801588777721"},{"id":111634426,"name":"8801111144419","phone":"8801111144419"},{"id":111634427,"name":"8801144778855","phone":"8801144778855"},{"id":111634428,"name":"8801877722212","phone":"8801877722212"},{"id":111634429,"name":"8801354554545","phone":"8801354554545"},{"id":111634434,"name":"8801188885555","phone":"8801188885555"},{"id":111634435,"name":"aaa","phone":"8801122999449"},{"id":111634436,"name":"Aman","phone":"8801177442456"},{"id":111634548,"name":"8801877755744","phone":"8801877755744"},{"id":111634549,"name":"8801877755140","phone":"8801877755140"},{"id":111634634,"name":"8801866633321","phone":"8801866633321"},{"id":111634635,"name":"8801385834755","phone":"8801385834755"}]
     * message : Retailer found
     */

    private boolean status;
    private String message;
    private List<UserDataBean> user_data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<UserDataBean> getUser_data() {
        return user_data;
    }

    public void setUser_data(List<UserDataBean> user_data) {
        this.user_data = user_data;
    }

    public static class UserDataBean {
        /**
         * id : 2489657
         * name : peter
         * phone : 8801877755590
         */

        private int id;
        private String name;
        private String phone;

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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
