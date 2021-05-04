package com.gurock.testrail;

import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;
import io.restassured.path.json.JsonPath;
import ioServices.FileServices;
import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.ITestResult;
import coreUtils.BuildParameterKeys;
import coreUtils.CoreFileUtils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class TestRailDataBuilder {

    static {
        BuildParameterKeys buildParameterKeys = new BuildParameterKeys();
        testRail = buildParameterKeys.getTestRailKeyValue();
        service = buildParameterKeys.getServiceKeyValue().toLowerCase();
    }

    private static final String testRail;
    private static TestRailDataBuilder testRailDataBuilder = null;

    private static APIClient apiClient;
    private static Long suite_id;
    private static final String service;

    private TestRailDataBuilder(){

    }

    public static TestRailDataBuilder getInstance()
    {
        if (testRailDataBuilder == null)
            testRailDataBuilder = new TestRailDataBuilder();

        return testRailDataBuilder;
    }

    public void beforeMethodForTestRail(ITestContext iTestContext, Method method, Class T) throws NoSuchMethodException {
        if(testRail!=null && !testRail.equals("false")){
            System.out.println("TestRail BeforeMethod is called");
            Method m = T.getMethod(method.getName());
            System.out.println(m);
            if (m.isAnnotationPresent(TestRails.class)) {
                TestRails ta = m.getAnnotation(TestRails.class);
                iTestContext.setAttribute("caseId", ta.caseId());
                System.out.println(iTestContext.getAttribute("caseId"));
            }
        }
    }

    public void afterMethodForTestRail(ITestResult result, ITestContext ctx) throws IOException, APIException {
        if (testRail != null && !testRail.equals("false")) {
            System.out.println("TestRail AfterMethod is called");
            HashMap<String, String> data = new HashMap<String, String>();
            if (result.isSuccess()) {
                data.put("status_id", "1");
            } else {
                data.put("status_id", "5");
                data.put("comment", result.getThrowable().toString());
            }
            String caseId = (String) ctx.getAttribute("caseId");
            Long suiteId = (Long) ctx.getAttribute("suiteId");
            apiClient.sendPost("add_result_for_case/" + suiteId + "/" + caseId, data);
        }
    }

    public void setUpTestRail(ITestContext iTestContext) throws IOException,APIException {
        if(testRail!=null && !testRail.equalsIgnoreCase("false")) {
            // SetUp TestRail data
            FileServices jsonServices = new FileServices();
            JSONObject jsonObject = jsonServices.readJsonFile(CoreFileUtils.testRailConfigsJsonFilePath);
            String configData = jsonObject.toJSONString();
            String testRailBaseUrl = JsonPath.with(configData).getString("baseUrl");
            String userName = JsonPath.with(configData).getString("userName");
            String password = JsonPath.with(configData).getString("password");
            int suiteId = 0;
            switch (service) {
                case "sc":
                    suiteId = JsonPath.with(configData).getInt("suiteId[0].SC-API");
                    break;
                case "oms":
                    suiteId = JsonPath.with(configData).getInt("suiteId[1].OMS-API");
                    break;
                case "redx-web":
                    suiteId = JsonPath.with(configData).getInt("suiteId[0].Redx-Web");
                    break;
                case "delivery-agents-app":
                    suiteId = JsonPath.with(configData).getInt("suiteId[1].Delivery-Agents-App");
                    break;
                case "cmt":
                    suiteId = JsonPath.with(configData).getInt("suiteId[3].CMT-API");
                    break;
                case "wms":
                    suiteId = JsonPath.with(configData).getInt("suiteId[4].WMS-API");
                    break;
            }
            System.out.println("------------ Suite : " + suiteId + " --------------- ");
            System.out.println("BeforeSuite");
            apiClient = new APIClient(testRailBaseUrl);
            apiClient.setUser(userName);
            apiClient.setPassword(password);
            HashMap<String, Object> data = new HashMap<String, Object>();
            data.put("suite_id", suiteId);
            data.put("include_all", true);
            data.put("name", iTestContext.getSuite().getName() + " - " + System.currentTimeMillis());
            JSONObject c = null;
            int PROJECT_ID = suiteId;
            c = (JSONObject) apiClient.sendPost("add_run/" + PROJECT_ID, data);
            System.out.println(c);
            suite_id = (Long) c.get("id");
            System.out.println("Returned SuiteId : " + suite_id);
            iTestContext.setAttribute("suiteId", suite_id);
        }
    }

    public void tearDownTestRail() throws IOException,APIException {
        if(testRail!=null && !testRail.equalsIgnoreCase("false")) {
            FileServices jsonServices = new FileServices();
            JSONObject jsonObject = jsonServices.readJsonFile(CoreFileUtils.testRailConfigsJsonFilePath);
            String configData = jsonObject.toJSONString();
            int reportId=0;
            switch (service){
                case "sc" :
                    reportId = JsonPath.with(configData).getInt("reportId[0].SC-API");
                    break;
                case "oms" :
                    reportId = JsonPath.with(configData).getInt("reportId[1].OMS-API");
                    break;
                case "redx-web" :
                    reportId = JsonPath.with(configData).getInt("reportId[0].Redx-Web");
                    break;
                case "delivery-agents-app" :
                    reportId = JsonPath.with(configData).getInt("reportId[1].Delivery-Agents-App");
                    break;
                case "cmt" :
                    reportId = JsonPath.with(configData).getInt("reportId[3].CMT-API");
                    break;
                case "wms" :
                    reportId = JsonPath.with(configData).getInt("reportId[4].WMS-API");
                    break;
            }
            JSONObject responseObject = (JSONObject) apiClient.sendGet("run_report/" + reportId);
            System.out.println(responseObject.get("report_html"));
            System.out.println(responseObject.get("report_pdf"));
            System.out.println(apiClient.sendGet("get_results_for_run/" + suite_id));
        }
    }

}