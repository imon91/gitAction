package services.responseModels.wmsModels;

public class AddingWarehouseModel {

    /**
     * TestCaseId : Krishna Impex
     * TestCase : Krishna Impex
     * TestData : Krishna Impex
     * WarehouseCode : Krishna Impex
     * Name : Krishna Impex
     * Address : Krishna Impex
     * Address2 : Krishna Impex
     * LandMark : Krishna Impex
     * City : Krishna Impex
     * State : Krishna Impex
     * Country : Krishna Impex
     * ZipCode : Krishna Impex
     * Phone : Krishna Impex
     * AlternativePhone : Krishna Impex
     * ToastMessage : Krishna Impex
     * IsRun : Krishna Impex
     */

    public String TestCaseId;
    public String TestCase;
    public String TestData;
    public String WarehouseCode;
    public String Name;
    public String Address;
    public String Address2;
    public String LandMark;
    public String City;
    public String State;
    public String Country;
    public String ZipCode;
    public String Phone;
    public String AlternativePhone;
    public String ToastMessage;
    public String IsRun;

    public String getTestCaseId() {
        return TestCaseId;
    }

    public void setTestCaseId(String TestCaseId) {
        this.TestCaseId = TestCaseId;
    }

    public String getTestCase() {
        return TestCase;
    }

    public void setTestCase(String TestCase) {
        this.TestCase = TestCase;
    }

    public String getTestData() {
        return TestData;
    }

    public void setTestData(String TestData) {
        this.TestData = TestData;
    }

    public String getWarehouseCode() {
        return WarehouseCode;
    }

    public void setWarehouseCode(String WarehouseCode) {
        this.WarehouseCode = WarehouseCode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getAddress2() {
        return Address2;
    }

    public void setAddress2(String Address2) {
        this.Address2 = Address2;
    }

    public String getLandMark() {
        return LandMark;
    }

    public void setLandMark(String LandMark) {
        this.LandMark = LandMark;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String ZipCode) {
        this.ZipCode = ZipCode;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getAlternativePhone() {
        return AlternativePhone;
    }

    public void setAlternativePhone(String AlternativePhone) {
        this.AlternativePhone = AlternativePhone;
    }

    public String getToastMessage() {
        return ToastMessage;
    }

    public void setToastMessage(String ToastMessage) {
        this.ToastMessage = ToastMessage;
    }

    public String getIsRun() {
        return IsRun;
    }

    public void setIsRun(String IsRun) {
        this.IsRun = IsRun;
    }

    public String[] getAll()
    {
        return new String[]
                {getWarehouseCode(),getName(),getAddress(),getAddress2(),getLandMark(),getCity(),getState(),
                getCountry(),getZipCode(),getPhone(),getAlternativePhone()};
    }
}
