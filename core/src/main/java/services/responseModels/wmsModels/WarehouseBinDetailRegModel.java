package services.responseModels.wmsModels;

public class WarehouseBinDetailRegModel {

    /**
     * TestCaseId :  BuO
     * TestCase :  BuO
     * TestData :  BuO
     * WarehouseBinCode :  BuO
     * ToastMessage :  BuO
     */

    public String TestCaseId;
    public String TestCase;
    public String TestData;
    public String WarehouseBinCode;
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

    public String[] getWarehouseBinCode() {
        return new String[]{WarehouseBinCode};
    }

    public void setWarehouseBinCode(String WarehouseBinCode) {
        this.WarehouseBinCode = WarehouseBinCode;
    }

    public String getToastMessage() {
        return ToastMessage;
    }

    public void setToastMessage(String ToastMessage) {
        this.ToastMessage = ToastMessage;
    }
}
