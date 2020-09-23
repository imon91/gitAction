package services.responseModels.wmsModels;

public class PickListActionModel {

    /**
     * TestCaseId : PLA_1
     * TestCase : withoutAnySelection
     * TestData : Input
     * PickListId : N/A
     * ScanPackages : N/A
     * ErrorMessages : This field is required.
     * ToastMessage : N/A
     */

    public String TestCaseId;
    public String TestCase;
    public String TestData;
    public String PickListId;
    public String ScanPackages;
    public String ErrorMessages;
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

    public String getPickListId() {
        return PickListId;
    }

    public void setPickListId(String PickListId) {
        this.PickListId = PickListId;
    }

    public String getScanPackages() {
        return ScanPackages;
    }

    public void setScanPackages(String ScanPackages) {
        this.ScanPackages = ScanPackages;
    }

    public String getErrorMessages() {
        return ErrorMessages;
    }

    public void setErrorMessages(String ErrorMessages) {
        this.ErrorMessages = ErrorMessages;
    }

    public String getToastMessage() {
        return ToastMessage;
    }

    public void setToastMessage(String ToastMessage) {
        this.ToastMessage = ToastMessage;
    }
}
