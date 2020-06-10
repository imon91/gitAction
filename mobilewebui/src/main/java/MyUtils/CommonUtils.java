package MyUtils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class CommonUtils {

    public static void threadSleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            System.out.println("Thread.sleep Exception");
        }
    }

    public static AndroidDriver<WebElement> getControlOnWeb(AndroidDriver<WebElement> androidDriver){
        CommonUtils.threadSleep(5000);
        // Context Switching
        Set<String> contextNames = androidDriver.getContextHandles();
        int n = contextNames.size();
        String contextData[] = new String[n];
        contextData = contextNames.toArray(contextData);
        for(int i=0;i<contextData.length;i++){
            System.out.println(contextData[i]);
            if(contextData[i].equalsIgnoreCase(Constants.SHOP_UP_RESELLER_WEB_VIEW)){
                androidDriver.context(Constants.SHOP_UP_RESELLER_WEB_VIEW);
                return androidDriver;
            }
        }
        return null;
    }
}
