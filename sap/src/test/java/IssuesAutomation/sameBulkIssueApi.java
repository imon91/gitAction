package IssuesAutomation;

import coreUtils.CoreConstants;

import org.testng.Assert;
import org.testng.annotations.*;
import services.GetSapApiResponse;
import utils.SapBaseClass;


public class sameBulkIssueApi extends SapBaseClass {

    private GetSapApiResponse getSapApiResponse1;
    private GetSapApiResponse getSapApiResponse2;

    @Test(groups = {CoreConstants.GROUP_REGRESSION})
    public void verifySameBulkIdIssueApi()
    {
        System.out.println("Verifying Same Bulk Id Issue Api in Thread Id : " + Thread.currentThread().getId() +"\n");
        getSapApiResponse1 = new GetSapApiResponse(CoreConstants.MODULE_SAP_UI);

        String dir = System.getProperty("user.dir");
//        String filePath = dir + "/src/test/resources/testData/parcels1.csv";
        String filePath = dir + "/src/test/resources/testData/Parcel_Data1.csv";
        String path = "/Users/ramaditya/Downloads/shopup-sample.xlsx";

        String cookie;
        Boolean[] assertValue1 = new Boolean[5];

        cookie = getSapApiResponse1.performAuthentication();
        System.out.println("Cookie Value of Thread Id " + Thread.currentThread().getId() + " is : \n" + cookie +"\n");

        assertValue1 = getSapApiResponse1.getBulkId(cookie,filePath,path);
        Assert.assertEquals(assertValue1[4],Boolean.TRUE);
    }

    @Test(groups = {CoreConstants.GROUP_REGRESSION})
    public void verifySameBulkIdIssueApi1()
    {
        System.out.println("Verifying Same Bulk Id Issue Api in Thread Id : " + Thread.currentThread().getId()+"\n");
        getSapApiResponse2 = new GetSapApiResponse(CoreConstants.MODULE_SAP_UI);
        String dir = System.getProperty("user.dir");
//        String filePath = dir + "/src/test/resources/testData/parcels2.csv";
        String filePath = dir + "/src/test/resources/testData/Parcel_Data2.csv";
        String path = "/Users/ramaditya/Downloads/shopup-sample.xlsx";

        String cookie;
        Boolean[] assertValue2 = new Boolean[5];

        cookie = getSapApiResponse2.performAuthentication();
        System.out.println("Cookie Value of Thread Id " + Thread.currentThread().getId() + " is : \n" + cookie +"\n");

        assertValue2 = getSapApiResponse2.getBulkId(cookie,filePath,path);
        Assert.assertEquals(assertValue2[4],Boolean.TRUE);
    }
}
