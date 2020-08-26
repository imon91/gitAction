package pageObjects;

import coreUtils.BuildParameterKeys;
import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utils.AndroidBaseClass;
import utils.MyActions;

public class NativePopUpProgressBarPO extends AndroidBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private String packageName;
    private String app;

    public NativePopUpProgressBarPO(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        packageName = getAppPackage();
        app = System.getProperty(BuildParameterKeys.KEY_APP);
    }

    private WebElement progress_bar_common;


    public Boolean isProgressBarCrossingThreshold(){
        if(androidDriver.getContextHandles().size()<1
                && androidDriver.getContextHandles().toArray()[0].toString().equalsIgnoreCase(CoreConstants.SHOP_UP_NATIVE_VIEW)){
            int i=0;
            try{
                progress_bar_common =
                        androidDriver.findElement(By.xpath("//android.widget.ProgressBar[@resource-id='"+packageName+":id/custom_progress_dialog_progress']"));
                if(progress_bar_common.isDisplayed()){
                    try{
                        if(i<7){
                            Thread.sleep(1000);
                            isProgressBarCrossingThreshold();
                            i++;
                        }else {
                            return true;
                        }
                    }catch (Exception e){
                        System.out.println("Exception at CheckTheVisibilityOfCommonProgressBar");
                    }
                }
                return false;
            }catch (NoSuchElementException e){
                return false;
            }catch (ElementNotVisibleException e){
                return false;
            }

        }
        return false;
    }

}
