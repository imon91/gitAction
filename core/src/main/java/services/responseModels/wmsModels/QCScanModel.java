package services.responseModels.wmsModels;

public class QCScanModel {

    /**
     * TestCaseId : QC_1
     * TestCase : withoutAnySelection
     * TestData : Input
     * ScanImages : N/A
     * Image : Not Displayed
     * ScanPackages : Not Displayed
     * ToastMessage : N/A
     * POCreation : QC NOT Scanned
     */

    public String TestCaseId;
    public String TestCase;
    public String TestData;
    public String ScanImages;
    public String Image;
    public String ScanPackages;
    public String ToastMessage;
    public String POCreation;

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

    public String getScanImages() {
        return ScanImages;
    }

    public void setScanImages(String ScanImages) {
        this.ScanImages = ScanImages;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getScanPackages() {
        return ScanPackages;
    }

    public void setScanPackages(String ScanPackages) {
        this.ScanPackages = ScanPackages;
    }

    public String getToastMessage() {
        return ToastMessage;
    }

    public void setToastMessage(String ToastMessage) {
        this.ToastMessage = ToastMessage;
    }

    public String getPOCreation() {
        return POCreation;
    }

    public void setPOCreation(String POCreation) {
        this.POCreation = POCreation;
    }
}
