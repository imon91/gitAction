package pageObejcts;

import coreUtils.CoreConstants;
import dataBase.DataBaseCore;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import utils.StoreWapBaseClass;

public class AuthenticationPageObjects extends StoreWapBaseClass {



    public void performAuthentication(String mobileNumber){
        System.out.println("Mobile Number is : "+mobileNumber);
        String otp = new DataBaseCore().getOTPForStore();
        System.out.println("OTP is : "+otp);
    }

}
