package services.responseModels.wmsModels;

public class CreateGRNModel {

    /**
     * TestCaseId : CGRN_1
     * TestCase : withoutAnyInput
     * POIDInput : N/A
     * GRNDetails : Not Displayed
     * Quantity : N/A
     * Number : N/A
     * ToastMessage : N/A
     * GRNCreation : GRN Not Created
     */

    public String TestCaseId;
    public String TestCase;
    public String POIDInput;
    public String GRNDetails;
    public String Quantity;
    public String Number;
    public String ToastMessage;
    public String GRNCreation;

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

    public String getGRNDetails() {
        return GRNDetails;
    }

    public void setGRNDetails(String GRNDetails) {
        this.GRNDetails = GRNDetails;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }

    public String getToastMessage() {
        return ToastMessage;
    }

    public void setToastMessage(String ToastMessage) {
        this.ToastMessage = ToastMessage;
    }

    public String getGRNCreation() {
        return GRNCreation;
    }

    public void setGRNCreation(String GRNCreation) {
        this.GRNCreation = GRNCreation;
    }
}
