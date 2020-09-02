package services.responseModels.wmsModels;

public class AddSuppliersModel {

    /**
     * TestCaseId : Krishna Impex
     * TestCase : Krishna Impex
     * TestData : Krishna Impex
     * Name : Krishna Impex
     * Email : Krishna Impex
     * Phone : Krishna Impex
     * Address1 : Krishna Impex
     * Address2 : Krishna Impex
     * LandMark : Krishna Impex
     * City : Krishna Impex
     * State : Krishna Impex
     * ZipCode : Krishna Impex
     * VATNumber : Krishna Impex
     * ToastMessage : Krishna Impex
     */

    public String TestCaseId;
    public String TestCase;
    public String TestData;
    public String Name;
    public String Email;
    public String Phone;
    public String Address1;
    public String Address2;
    public String LandMark;
    public String City;
    public String State;
    public String ZipCode;
    public String VATNumber;
    public String ToastMessage;

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

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getAddress1() {
        return Address1;
    }

    public void setAddress1(String Address1) {
        this.Address1 = Address1;
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

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String ZipCode) {
        this.ZipCode = ZipCode;
    }

    public String getVATNumber() {
        return VATNumber;
    }

    public void setVATNumber(String VATNumber) {
        this.VATNumber = VATNumber;
    }

    public String getToastMessage() {
        return ToastMessage;
    }

    public void setToastMessage(String ToastMessage) {
        this.ToastMessage = ToastMessage;
    }

    public String[] getAll()
    {
        return new String[]
                {getName(),getEmail(),getPhone(),getAddress1(),getAddress2(),getLandMark(),getCity(),
                        getState(),getZipCode(),getVATNumber()};
    }
}
