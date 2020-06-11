package functionalTests.authentication;
import io.qameta.allure.Attachment;
import org.apache.commons.codec.binary.Base64;
import pageObjects.LoginPageObjects;
import utils.BaseClass;
import utils.DriverControls;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VerifyAuthentication extends BaseClass {

    private AndroidDriver<AndroidElement> androidDriver;
    private DriverControls driverControls;
    private LoginPageObjects loginPageObjects;


    @BeforeSuite
    public void setUp() throws Exception{


        // 1 : Start Appium Service
        startService();

        // 2 : Get Driver
        androidDriver = getDriver(null,null);

        String data = androidDriver.startRecordingScreen();
        if(data!=null){
            System.out.println("Recording Started Successfully");
            System.out.println(data);
        }else {
            System.out.println("Recording Didn't start");
        }

        // 3 : Set DriverControls
        driverControls = new DriverControls(androidDriver);

        loginPageObjects = new LoginPageObjects(androidDriver);

    }

    @DataProvider(name = "dataForLoginFunctionality")
    public Object[][] dataForLoginFunctionality(){
        return new Object[][]{
                {"1877755590","666666"}
        };
        }


    @Test(enabled = true,dataProvider = "dataForLoginFunctionality")
    public void verifyAuthentication(String mobile,String otp){
        // Set Implicit Wait
        driverControls.setImplicitWait(10);
        loginPageObjects.performAuthentication(mobile,otp);
    }

    @AfterSuite
    @Attachment(value = "video",type="video/mp4")
    public byte[] tearDownAndAttachFile() throws Exception {
        Thread.sleep(1000);
        String base64String = androidDriver.stopRecordingScreen();
        byte[] data = Base64.decodeBase64(base64String);
        String destinationPath = System.getProperty("user.dir") + "/src/main/resources/recordedTests/filename.mp4";
        Path path = Paths.get(destinationPath);
        Files.write(path, data);
        System.out.println("Data Written Successfully");
        androidDriver.quit();
        stopService();
        return getFile(path.toString());
    }

    public byte[] getFile(String fileName) throws Exception {
        File file = new File(fileName);
        return Files.readAllBytes(Paths.get(file.getAbsolutePath()));
    }
}
