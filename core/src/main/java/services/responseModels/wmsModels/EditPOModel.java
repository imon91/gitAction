package services.responseModels.wmsModels;

public class EditPOModel {

    /**
     * TestCaseId : EPO_1
     * TestCase : withoutAnyInput
     * POIDInput : N/A
     * PODetails : Not Displayed
     * ToastMessage : N/A
     * POClose : PO Close N/A
     */

    public String TestCaseId;
    public String TestCase;
    public String POIDInput;
    public String PODetails;
    public String ToastMessage;
    public String POClose;

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

    public String getPOIDInput() {
        return POIDInput;
    }

    public void setPOIDInput(String POIDInput) {
        this.POIDInput = POIDInput;
    }

    public String getPODetails() {
        return PODetails;
    }

    public void setPODetails(String PODetails) {
        this.PODetails = PODetails;
    }

    public String getToastMessage() {
        return ToastMessage;
    }

    public void setToastMessage(String ToastMessage) {
        this.ToastMessage = ToastMessage;
    }

    public String getPOClose() {
        return POClose;
    }

    public void setPOClose(String POClose) {
        this.POClose = POClose;
    }
}
