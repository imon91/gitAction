package listeners;

import coreUtils.BuildParameterKeys;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Date;

import static io.restassured.RestAssured.given;

public class RedXUiTestNgListener implements ITestListener {

    private static class Keys{
        public static final String KEY_DATE = "date";
        public static final String KEY_DURATION = "duration";
        public static final String KEY_TESTS = "total_tests";
        public static final String KEY_PASS_COUNT = "pass_count";
        public static final String KEY_FAIL_COUNT = "fail_count";
        public static final String KEY_SKIP_COUNT = "skip_count";
        public static final String KEY_PASS_PERCENTAGE = "pass_percentage";
        public static final String KEY_FAIL_PERCENTAGE = "fail_percentage";
        public static final String KEY_SKIP_PERCENTAGE = "skip_percentage";
        public static final String KEY_FILTER_DATE = "filter_date";

    }

    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {

    }

    public void onTestFailure(ITestResult iTestResult) {

    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {
        String trigger = System.getProperty(BuildParameterKeys.KEY_TRIGGER);
        String app = null;
       if(System.getProperty(BuildParameterKeys.KEY_APP).equalsIgnoreCase("Reseller")){
            app = "reseller";
       }else {
           app = "mokam";
       }

        if (trigger != null) {
            if (trigger.equalsIgnoreCase("jenkins")) {
                JSONObject object = new JSONObject();
                if (trigger.equalsIgnoreCase("jenkins")) {
                    Date date = iTestContext.getStartDate();
                    String duration = Long.toString(iTestContext.getEndDate().getTime()
                            - iTestContext.getStartDate().getTime());
                    double total_tests = iTestContext.getAllTestMethods().length;
                    double pass_count = iTestContext.getPassedTests().size();
                    double fail_count = iTestContext.getFailedTests().size();
                    double skip_count = iTestContext.getSkippedTests().size();
                    double pass_percentage = (pass_count / total_tests) * 100;
                    double fail_percentage = (fail_count / total_tests) * 100;
                    double skip_percentage = (skip_count / total_tests) * 100;
                    String day = date.toString().split(" ")[2];
                    String filter_date = date.getYear()+1900+"-"+"0"+(date.getMonth()+1)+"-"+day;
                    System.out.println(filter_date);

                    try {

                        object.put(Keys.KEY_DATE, String.valueOf(date));
                        object.put(Keys.KEY_DURATION, duration);
                        object.put(Keys.KEY_TESTS, total_tests);
                        object.put(Keys.KEY_PASS_COUNT, pass_count);
                        object.put(Keys.KEY_FAIL_COUNT, fail_count);
                        object.put(Keys.KEY_SKIP_COUNT, skip_count);
                        object.put(Keys.KEY_PASS_PERCENTAGE, pass_percentage);
                        object.put(Keys.KEY_FAIL_PERCENTAGE, fail_percentage);
                        object.put(Keys.KEY_SKIP_PERCENTAGE, skip_percentage);
                        object.put(Keys.KEY_FILTER_DATE,filter_date);

                        System.out.println(object);

                        RestAssured.baseURI = "http://localhost:3010/";
                        Response response = given().header("Content-Type","application/json").
                                body(object.toJSONString()).post(app+"/");
                        response.then().log().all();

                    } catch (Exception e) {
                        System.out.println("Error in Adding Data : " + e);
                    }
                }
            }

        }
    }
}
