package utils;

import coreUtils.CoreConstants;
import io.appium.java_client.android.*;
import org.openqa.selenium.WebElement;
import pageObjects.*;
import java.util.*;


public class AndroidScriptRouter extends AndroidBaseClass{

    private AndroidDriver<WebElement> androidDriver;
    private static final String KEY_ACTIVITY = "activity";
    private static final String KEY_PAGE = "page";
    private ActionBarObjects actionBarObjects;
    private MyActions myActions;
    private BottomNavigationObjects bottomNavigationObjects;
    private RightNavigationDrawer rightNavigationDrawer;

    // This class is responsible to Give to context from anywhere to required Page
     /*Note : CurrentContext and CurrentURL should be used to decide the current instance of
     the app and path to reach the destination */





    public void initializeAppPageObjects(){
        myActions = new MyActions();
        actionBarObjects = new ActionBarObjects(androidDriver);
        bottomNavigationObjects = new BottomNavigationObjects(androidDriver);
        rightNavigationDrawer = new RightNavigationDrawer(androidDriver);
    }



    public HashMap<String,String> getMeTheCurrentPage() throws Exception{
        System.out.println("Control came to getMeTheCurrentPage");
        androidDriver = getBaseDriver();
        initializeAppPageObjects();
        HashMap<String,String> currentData = new HashMap<>();
        if(androidDriver.currentActivity().equalsIgnoreCase(AndroidAppConstants.LOGIN_ACTIVITY)){
            sleep(5000);
        }
        String currentActivity = androidDriver.currentActivity();
        currentData.put(KEY_ACTIVITY,currentActivity);
        Set<String> contextNames = androidDriver.getContextHandles();
       if(contextNames.contains(CoreConstants.SHOP_UP_RESELLER_WEB_VIEW)){
           switchFromNativeToWeb(CoreConstants.SHOP_UP_RESELLER_WEB_VIEW);
            String currentUrl = androidDriver.getCurrentUrl();
           currentData.put(KEY_PAGE,currentUrl);
       }else {
           currentData.put(KEY_PAGE,null);
       }
       System.out.println("CurrentData is : "+currentData);
        return currentData;
    }


    public void getTheControlHere(String activityName,String pageURL) throws Exception{
        //Eg 1 : HomeActivity, WishlistPage
        //Eg 2 : WebViewActivity, MyAccountIncomePage
        System.out.println("Control came to getTheControlHere");
        HashMap<String,String> myData = getMeTheCurrentPage();
        String currentActivity = myData.get(KEY_ACTIVITY); // HomeActivity
        String currentPage = myData.get(KEY_PAGE); // Homepage

        if(currentPage!=null){
            System.out.println("Current Context is WEB");
            // Context is WEB
            if(activityName.equalsIgnoreCase(currentActivity)
                    && pageURL.equalsIgnoreCase(currentPage)) {
                System.out.println("You Are Already In Activity : " + currentActivity + "\n And Page : " + currentPage);
            }else if(activityName.equalsIgnoreCase(AndroidAppConstants.HOME_ACTIVITY)){
                if(currentActivity.equalsIgnoreCase(activityName)){
                    myActions.clickOnHardKeyBack();
                    actionBarObjects.clickOnShopUpAppIcon();
                    switch (pageURL){
                        case AndroidAppConstants.URL_WISHLIST : bottomNavigationObjects.clickOnBottomBarMyShopIcon();break;
                        case AndroidAppConstants.URL_MY_ORDER_INDIVIDUAL : bottomNavigationObjects.clickOnBottomBarMyOrdersIcon();break;
                        case AndroidAppConstants.URL_MY_ACCOUNT_INCOME : bottomNavigationObjects.clickOnBottomBarPaymentsIcon();break;
                    }
                }
            }else if(activityName.equalsIgnoreCase(AndroidAppConstants.LOGIN_ACTIVITY)){

            }else if(activityName.equalsIgnoreCase(AndroidAppConstants.MAIN_ACTIVITY)){

            }else if(activityName.equalsIgnoreCase(AndroidAppConstants.SEARCH_ACTIVITY)){

            }else if(activityName.equalsIgnoreCase(AndroidAppConstants.WEB_VIEW_CART_ACTIVITY)){
                if (pageURL.equalsIgnoreCase(AndroidAppConstants.URL_MY_BAG)) {
                    if(currentActivity.equalsIgnoreCase(AndroidAppConstants.WEB_VIEW_CART_ACTIVITY)){
                        if (currentPage.equalsIgnoreCase(AndroidAppConstants.URL_CHECKOUT_ADDRESS)) {
                            myActions.clickOnHardKeyBack();
                        } else if (currentPage.equalsIgnoreCase(AndroidAppConstants.URL_CHECKOUT_PAYMENT)) {
                            myActions.clickOnHardKeyBack();
                            sleep(3000);
                            myActions.clickOnHardKeyBack();
                        }
                    }
                    if (currentActivity.equalsIgnoreCase(AndroidAppConstants.WEB_VIEW_ACTIVITY)) {
                        if (currentPage.equalsIgnoreCase(AndroidAppConstants.URL_MY_INCOME_LIST) ||
                                currentPage.equalsIgnoreCase(AndroidAppConstants.URL_MY_INCOME_LIST_ADJUSTMENTS) ||
                                currentPage.equalsIgnoreCase(AndroidAppConstants.URL_MY_INCOME_LIST_BONUS) ||
                                currentPage.equalsIgnoreCase(AndroidAppConstants.URL_MY_INCOME_LIST_CANCELLED) ||
                                currentPage.equalsIgnoreCase(AndroidAppConstants.URL_MY_INCOME_LIST_DELIVERED) ||
                                currentPage.equalsIgnoreCase(AndroidAppConstants.URL_MY_INCOME_LIST_LOST) ||
                                currentPage.equalsIgnoreCase(AndroidAppConstants.URL_MY_INCOME_LIST_RETURN) ||
                                currentPage.equalsIgnoreCase(AndroidAppConstants.URL_MY_INCOME_LIST_RTO)||
                                currentPage.equalsIgnoreCase(AndroidAppConstants.URL_MY_ACCOUNT_INCOME)||
                                currentPage.equalsIgnoreCase(AndroidAppConstants.URL_MY_ORDER_INDIVIDUAL)||
                                currentPage.equalsIgnoreCase(AndroidAppConstants.URL_MY_ORDERS_ACTIVE)||
                                currentPage.equalsIgnoreCase(AndroidAppConstants.URL_MY_ORDERS_CANCELLED)||
                                currentPage.equalsIgnoreCase(AndroidAppConstants.URL_MY_ORDERS_COMPLETED)||
                                currentPage.equalsIgnoreCase(AndroidAppConstants.URL_WISHLIST)) {
                            myActions.clickOnHardKeyBack();
                            actionBarObjects.clickOnBagImageButton();
                        } else {
                            myActions.clickOnHardKeyBack();
                            sleep(2000);
                            myActions.clickOnHardKeyBack();
                            actionBarObjects.clickOnBagImageButton();
                        }
                    }
                    else if (currentActivity.equalsIgnoreCase(AndroidAppConstants.SEARCH_ACTIVITY)){
                        myActions.clickOnHardKeyBack();
                        actionBarObjects.clickOnBagImageButton();
                    }
                    else if(currentActivity.equalsIgnoreCase(AndroidAppConstants.HOME_ACTIVITY)){
                        actionBarObjects.clickOnUserProfileImageButton();
                        rightNavigationDrawer.clickOnItemHome();
                        sleep(2000);
                        actionBarObjects.clickOnBagImageButton();
                    }
                }
            }else if(activityName.equalsIgnoreCase(AndroidAppConstants.WEB_VIEW_ACTIVITY)){

            }else {
                System.out.println(activityName + ": No Such Activity Handled Yet");
            }
        }else {
            // Context in NATIVE
            System.out.println("Current Context is NATIVE");
        }

    }


}
