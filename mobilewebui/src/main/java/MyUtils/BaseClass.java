package MyUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.WebElement;

import java.net.ServerSocket;
import java.net.URL;

public class BaseClass {
    private AppiumDriverLocalService appiumDriverLocalService;

    // Returns Host
    private String getHost(){
        return Constants.HOST;
    }

    // Returns Port
    private int getPort(){
        return Constants.PORT;
    }

    // Returns Protocol
    private String getProtocol(){
        return Constants.PROTOCOL;
    }

    // Returns Driver Role as Hub
    private String getDriverAsHub(){
        return Constants.WEB_DRIVER_AS_HUB;
    }


    // Builds AppiumDriverLocalService
    private void buildAppiumService(){
        // We need capabilities, host, port and arguments to build an appium-service

        // Building appiumService without capabilities

        // 1) Setup DesiredCapabilities : Here we are setting up desiredCapabilities in getDriver method

        // 2) Create AppiumServiceBuilder Object with cap, host, port and arguments
        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();
        appiumServiceBuilder.withIPAddress(getHost())
                .usingPort(getPort())
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL,"error");

        appiumDriverLocalService = AppiumDriverLocalService.buildService(appiumServiceBuilder);
        System.out.println("AppiumLocalService is Built");
    }

    // Check if AppiumServer is Already Running on that port
    private boolean checkIfServerIsRunning(){
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(getPort());
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
            // If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }


    // Start AppiumDriverLocalService
    public void startService(){
        buildAppiumService();
        if(!checkIfServerIsRunning()){
            appiumDriverLocalService.start();
            System.out.println("AppiumLocalService is Started : New");
        }else {
            System.out.println("AppiumLocalService is AlreadyStarted");
        }
    }

    // Stop AppiumDriverLocalService
    public void stopService(){
        appiumDriverLocalService.stop();
        System.out.println("AppiumLocalService is Stopped");
    }


    public AndroidDriver<WebElement> getDriver()throws Exception{
        // 1 : Create the URL with port for Appium  to run
        URL url = new URL(getProtocol() + getHost() + ":" + getPort() + getDriverAsHub());
        // 2 : Return AndroidDriver to tests with added capabilities
        return new AndroidDriver(url,new ResellerAndroidCapabilities().setCapabilities());
    }
}
