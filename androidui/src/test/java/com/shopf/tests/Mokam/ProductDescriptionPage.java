package com.shopf.tests.Mokam;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObjects.*;
import services.serviceUtils.EndPoints;
import utils.AndroidBaseClass;
import utils.MyActions;
import utils.ServiceRequestLayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductDescriptionPage  extends AndroidBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private ServiceRequestLayer serviceRequestLayer;
    private LoginPageObjects loginPageObjects;
    private MyActions myActions;
    private HomePageObjects homePageObjects;
    private RightNavigationDrawer rightNavigationDrawer;
    private ActionBarObjects actionBarObjects;
    private SearchPageObjects searchPageObjects;
    private ProductListingPageObjects productListingPageObjects;
    private ProductDescriptionPageObjects productDescriptionPageObjects;
    private SoftAssert softAssert;

    public String validMobileNumber = "01877755509";
    public String validOTP = "666666";
    public String productName = "Dettol";
    public String priceText = "Price";
    public String aboutThisProductText = "About this Product";
    public String codeText = "Code:";
    public String categoryText = "Category:";
    public String recentlyViewedByYouText = "Recently viewed by you";
    public String goToCartText = "Go to Cart";
    public String continueShoppingText = "Continue Shopping";
    public String packSizesText = "Pack Sizes";

    private String itemName;
    private int cartQuantity;
    private Map<String, List<Object>> productDetailsOfItemsInCart = new HashMap<>();
    private Map<String ,List<Object>> productDetailsOfItemsInPLPPage = new HashMap<>();
    private Map<String,Object> productDetailsOfProductInPDPPage = new HashMap<>();
    private List<String> productQuantityOfItemsInPLPPage = new ArrayList<>();
    private List<String> productQuantityOfItemsInCart = new ArrayList<>();
    private List<Integer> indexOfItemsInPLPWhichHas0Quantity = new ArrayList<>();
    private List<Integer> indexOfItemsInPLPWhichHasMoreThan0quantity = new ArrayList<>();
    private List<String> productNameOfItemsInPLPPage = new ArrayList<>();
    private List<String> productIdOfItemsInCart= new ArrayList<>();
    private String slug ;


    @BeforeSuite(alwaysRun = true)
    public void productDescriptionPageBeforeSuite (){
        System.out.println("ProductDescriptionPageBeforeSuite is called");
        androidDriver = getBaseDriver();
        pageInitializer();
        serviceRequestLayer.getControlOverAuthentication().performAuthentication();
        loginPageObjects.performAuthentication(validMobileNumber,validOTP);
        sleep(4000);
        actionBarObjects.clickOnUserProfileImageButton();
        rightNavigationDrawer.clickOnItemChangeLanguage();
        rightNavigationDrawer.selectEnglish();
        rightNavigationDrawer.saveLanguage();
        sleep(5000);
        searchAProduct();
        getApiData();
        itemName = productNameOfItemsInPLPPage.get(indexOfItemsInPLPWhichHasMoreThan0quantity.get(0));
        productListingPageObjects.selectAProductInPLPPage(itemName);
        System.out.println(EndPoints.RECOMMENDATIONS+slug);
        productDetailsOfProductInPDPPage = productDescriptionPageObjects.getProductDetailsOfProductInPDPPage(slug);
    }

    public void pageInitializer(){
        serviceRequestLayer = new ServiceRequestLayer();
        myActions = new MyActions();
        loginPageObjects = new LoginPageObjects(androidDriver);
        homePageObjects = new HomePageObjects(androidDriver);
        actionBarObjects = new ActionBarObjects(androidDriver);
        rightNavigationDrawer = new RightNavigationDrawer(androidDriver);
        searchPageObjects = new SearchPageObjects(androidDriver);
        productListingPageObjects = new ProductListingPageObjects(androidDriver);
        productDescriptionPageObjects = new ProductDescriptionPageObjects(androidDriver);
        SoftAssert softAssert = new SoftAssert();
    }

    private void searchAProduct(){
        actionBarObjects.clickOnSearchImageButton();
        searchPageObjects.enterProductName(productName);
        searchPageObjects.clickOnSearchButton();
        sleep(4000);
    }

    private void getApiData(){
        productDetailsOfItemsInCart = productListingPageObjects.getProductDetailsOfItemsInCart();
        productDetailsOfItemsInPLPPage = productListingPageObjects.getProductDetailsOfItemsInPLPPage(productName);
        productQuantityOfItemsInPLPPage = productListingPageObjects.getProductQuantityOfItemsInPlPPage(productDetailsOfItemsInPLPPage);
        productNameOfItemsInPLPPage = productListingPageObjects.getProductNameOfItemsInPlPPage(productDetailsOfItemsInPLPPage);
        productIdOfItemsInCart = productListingPageObjects.getProductIdOfItemsInCart(productDetailsOfItemsInCart);
        productQuantityOfItemsInCart = productListingPageObjects.getProductQuantityOfItemsInCart(productDetailsOfItemsInCart);
        getIndexOfItemsBasedOnQuantity();
        slug = productListingPageObjects.getProductSlug(productName,indexOfItemsInPLPWhichHasMoreThan0quantity.get(0));
        System.out.println(slug);
    }

    private void getIndexOfItemsBasedOnQuantity(){
        for(int i=0;i<productQuantityOfItemsInPLPPage.size();i++){
            if(Integer.parseInt(productQuantityOfItemsInPLPPage.get(i))==0){
                indexOfItemsInPLPWhichHas0Quantity.add(i);
            }
            else{
                indexOfItemsInPLPWhichHasMoreThan0quantity.add(i);
            }
        }
        System.out.println(indexOfItemsInPLPWhichHas0Quantity);
        System.out.println(indexOfItemsInPLPWhichHasMoreThan0quantity);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 1)
    public void verifyBackButtonFunctionality(){
        sleep(3000);
        actionBarObjects.clickOnBackButton();
        sleep(3000);
        productListingPageObjects.selectAProductInPLPPage(itemName);
        sleep(3000);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 2)
    public void verifyHardBackButtonFunctionality() throws Exception {
        myActions.clickOnHardKeyBack();
        sleep(3000);
        productListingPageObjects.selectAProductInPLPPage(itemName);
        sleep(3000);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 3)
    public void verifyProductNameInPDPPageActionBar(){
        Assert.assertEquals(itemName,productDescriptionPageObjects.getTextOnHeader());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 4)
    public void verifyProductNameInPDPPage(){
        Assert.assertEquals(itemName,productDescriptionPageObjects.getNameOfProduct());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 5)
    public void verifyNumberOfItemsInCart(){
        for(int i=0;i<productIdOfItemsInCart.size();i++){
            cartQuantity += Integer.parseInt(productQuantityOfItemsInCart.get(i));
        }
        Assert.assertEquals(actionBarObjects.getNumberOfItemsInCart(),cartQuantity+"");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 6)
    public void verifySearchIconFunctionality(){
        Assert.assertEquals(actionBarObjects.getSearchIconElement().getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 7)
    public void verifyCartIconFunctionality(){
        Assert.assertEquals(actionBarObjects.getCartIconElement().getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 8)
    public void verifyPriceText(){
        Assert.assertEquals(priceText,productDescriptionPageObjects.getPriceText());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 9)
    public void verifyBrandName(){
        System.out.println("Api : "+productDescriptionPageObjects.getBrandApi(productDetailsOfProductInPDPPage));
        System.out.println(productDescriptionPageObjects.getBrandNameFromPDP());
        Assert.assertEquals(productDescriptionPageObjects.getBrandApi(productDetailsOfProductInPDPPage),productDescriptionPageObjects.getBrandNameFromPDP());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 10)
    public void verifyPriceUnderProductName(){
        System.out.println("Api : "+"৳"+productDescriptionPageObjects.getPriceApi(productDetailsOfProductInPDPPage) );
        System.out.println(productDescriptionPageObjects.getPriceFromPDPPage());
        Assert.assertEquals(productDescriptionPageObjects.getPriceFromPDPPage(),"৳"+productDescriptionPageObjects.getPriceApi(productDetailsOfProductInPDPPage));
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 11)
    public void verifyPackSize(){
        Assert.assertEquals(productDescriptionPageObjects.getPackSizeFromPDP(), productDescriptionPageObjects.getProductSizeApi(productDetailsOfProductInPDPPage));//
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 12)
    public void verifyPriceUnderPackSizes(){
        Assert.assertEquals(productDescriptionPageObjects.getPriceUnderPackSizeFromPDP(),"৳"+productDescriptionPageObjects.getProductPriceUnderSizeApi(productDetailsOfProductInPDPPage));
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 13)
    public void verifyImageClickability(){
        Assert.assertEquals(productDescriptionPageObjects.getImageButton().getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 14)
    public void verifyPackSizesText(){
        Assert.assertEquals(packSizesText,productDescriptionPageObjects.getPackSizesText());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 15)
    public void verifyAboutThisProductText(){
        Assert.assertEquals(aboutThisProductText,productDescriptionPageObjects.getAboutThisProductText());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 16)
    public void verifyCodeTextAndIdOfProduct(){
        codeText = codeText+productDescriptionPageObjects.getProductCodeApi(productDetailsOfProductInPDPPage);
        System.out.println(codeText + productDescriptionPageObjects.getCodeTextAndIDOfProduct());
        softAssert.assertEquals(codeText,productDescriptionPageObjects.getCodeTextAndIDOfProduct());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority =17)
    public void verifyCategoryTextAndProductCategory(){
        categoryText = categoryText+productDescriptionPageObjects.getProductCategoryApi(productDetailsOfProductInPDPPage);
        //System.out.println(categoryText+productDescriptionPageObjects.getCategoryTextAndCategoryOfProduct());
        softAssert.assertEquals(categoryText,productDescriptionPageObjects.getCategoryTextAndCategoryOfProduct());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 18)
    public void verifyProductNameInUnderAboutThisProduct(){
        Assert.assertEquals(itemName,productDescriptionPageObjects.getProductNameUnderAboutThisProduct());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 19)
    public void verifyRecentlyViewedByYouText(){
        Assert.assertEquals(recentlyViewedByYouText,productDescriptionPageObjects.getRecentlyViewedByYouText());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 20)
    public void verifyGoToCartButtonText(){
        Assert.assertEquals(goToCartText,productDescriptionPageObjects.getGoToCartButtonElement().getText());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 21)
    public void verifyContinueShoppingButtonText(){
        Assert.assertEquals(continueShoppingText,productDescriptionPageObjects.getContinueShoppingButtonElement().getText());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 22)
    public void verifyGoToCartButtonFunctionality(){
        Assert.assertEquals(productDescriptionPageObjects.getGoToCartButtonElement().getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 23)
    public void verifyContinueShoppingButtonFunctionality(){
        Assert.assertEquals(productDescriptionPageObjects.getContinueShoppingButtonElement().getAttribute("clickable"),"true");
    }



    @AfterSuite(alwaysRun = true)
    public void loginScreenAfterSuite(){
        //actionBarObjects.clickOnCartButton();
        //sleep(3000);
        switchFromNativeToWeb(CoreConstants.SHOP_UP_MOKAM_WEB_VIEW);
        //myBagPageObjects.clickOnPlaceOrderButton();
        //sleep(3000);
        //checkoutAddressPageObjects.clickOnConfirmButton();
        System.out.println("ProductListingPageAfterSuite is called");
        quitBaseDriver();
    }



}