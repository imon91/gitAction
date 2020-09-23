package services.responseModels.wmsModels;

public class UpdateBinCapacityModel {

    /**
     * TestCaseId : P_a1
     * TestCase : P_a1
     * TestData : P_a1
     * WarehouseBinCode : P_a1
     * Capacity : P_a1
     * ToastMessage : P_a1
     */

    public String TestCaseId;
    public String TestCase;
    public String TestData;
    public String WarehouseBinCode;
    public String Capacity;
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

    public String getWarehouseBinCode() {
        return WarehouseBinCode;
    }

    public void setWarehouseBinCode(String WarehouseBinCode) {
        this.WarehouseBinCode = WarehouseBinCode;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String Capacity) {
        this.Capacity = Capacity;
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
                {getWarehouseBinCode(),getCapacity()};
    }
}
