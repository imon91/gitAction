package com.shopf.tests.Mokam;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import coreUtils.*;
import org.testng.asserts.SoftAssert;
import pageObjects.*;
import utils.*;


import java.util.*;



public class ProductListingPage  extends AndroidBaseClass{

    private AndroidDriver<WebElement> androidDriver;
    private ServiceRequestLayer serviceRequestLayer;
    private LoginPageObjects loginPageObjects;
    private HomePageObjects homePageObjects;
    private ActionBarObjects actionBarObjects;
    private RightNavigationDrawer rightNavigationDrawer;
    private MyBagPageObjects myBagPageObjects;
    private CheckoutAddressPageObjects checkoutAddressPageObjects;
    private OrderSuccessFulPageObjects orderSuccessFulPageObjects;
    private SearchPageObjects searchPageObjects;
    private ProductListingPageObjects productListingPageObjects;
    private ProductDescriptionPageObjects productDescriptionPageObjects;
    private ProductDescriptionPageObjects.NewProductDescriptionObjects newProductDescriptionObjects;
    private MyActions myActions;
    private SoftAssert softAssert;
    private Random random;
    private String app;
    private int productQuantity;
    private float productAmount;
    private int productIndex;
    private List<Integer> productCountOnHandOfAllProducts;
    private List<String > productIdOfItemsInCart;
    private List<String > productIdOfItemsInPLPPage;
    private List<String> productQuantityOfItemsInCart;
    private List<String> productQuantityOfItemsInPLPPage;
    private List<String> productPriceOfItemsInCart;
    private int initialCartTotal;
    private int initialCartQuantity;
    public String mobileNumber = "1877755590";
    public String otp = "666666";
    public String productName = "soap";
    public String sortText = "Sort";
    public String filterText = "Filter";
    public String itemsAndTotalText ;
    public String requestStockText = "Request Stock";
    public String addText = "Add+";
    private String selectQuantityText = "Select Quantity";
    private int i;
    public int minQuantity = 50;

    private Map<String ,List<Object>> productDetailsOfItemsInPLPPage = new HashMap<>();
    private Map<String ,List<Object>> productDetailsOfItemsInCart = new HashMap<>();
    private List<Integer> indexOfItemsInPLPWhichIsInCart = new ArrayList<>();
    private List<Integer> indexOfItemsInPLPWhichIsNotInCart = new ArrayList<>();
    private List<Integer> indexOfItemsInPLPWhichHas0Quantity = new ArrayList<>();
    private List<Integer> indexOfItemsInPLPWhichHasMoreThan0quantity = new ArrayList<>();
    private List<Integer> indexOfItemsInPLPWhichHasLessThanMinQuantity = new ArrayList<>();
    private List<Integer> indexOfItemsInPLPWhichHasMoreThanMinQuantity = new ArrayList<>();


    @BeforeSuite(alwaysRun = true)
    public void productListingPageBeforeSuite(){
        System.out.println("productListingPageBeforeSuite is called");
        androidDriver = getBaseDriver();
        pageInitializer();
        serviceRequestLayer.getControlOverAuthentication().performAuthentication();
        loginPageObjects.performAuthentication(mobileNumber,otp);
        homePageObjects.selectAddress(0);
        sleep(4000);
        switchFromWebToNative();
        actionBarObjects.clickOnUserProfileImageButton();
        rightNavigationDrawer.clickOnItemChangeLanguage();
        rightNavigationDrawer.selectEnglish();
        rightNavigationDrawer.saveLanguage();
        sleep(4000);
        System.out.println(actionBarObjects.getNumberOfItemsInCart());
        searchAProduct();
        getApiData();
        calculateInitialCartTotalAndQuantity();
        getIndexOfItemsInAndNotInCart();
        getIndexOfItemsBasedOnQuantity();
    }

    public void pageInitializer(){
        serviceRequestLayer = new ServiceRequestLayer();
        loginPageObjects = new LoginPageObjects(androidDriver);
        homePageObjects = new HomePageObjects(androidDriver);
        actionBarObjects = new ActionBarObjects(androidDriver);
        rightNavigationDrawer = new RightNavigationDrawer(androidDriver);
        myBagPageObjects = new MyBagPageObjects(androidDriver);
        checkoutAddressPageObjects = new CheckoutAddressPageObjects(androidDriver);
        orderSuccessFulPageObjects = new OrderSuccessFulPageObjects(androidDriver);
        searchPageObjects = new SearchPageObjects(androidDriver);
        productListingPageObjects = new ProductListingPageObjects(androidDriver);
        productDescriptionPageObjects = new ProductDescriptionPageObjects(androidDriver);
        newProductDescriptionObjects =productDescriptionPageObjects.new NewProductDescriptionObjects(androidDriver);
        softAssert = new SoftAssert();
        myActions = new MyActions();
        random = new Random();
        app = System.getProperty(BuildParameterKeys.KEY_APP);
    }

    private void searchAProduct(){
        actionBarObjects.clickOnSearchImageButton();
        searchPageObjects.enterProductName(productName);
        searchPageObjects.clickOnSearchSuggestion(0);
    }

    private void getApiData(){
        productDetailsOfItemsInCart = productListingPageObjects.getProductDetailsOfItemsInCart();
        productDetailsOfItemsInPLPPage = productListingPageObjects.getProductDetailsOfItemsInPLPPage(productName);
        productCountOnHandOfAllProducts = productListingPageObjects.getProductCountOfAllProducts(productName);
        i = productCountOnHandOfAllProducts.size();
        productIdOfItemsInCart = productListingPageObjects.getProductIdOfItemsInCart(productDetailsOfItemsInCart);
        productQuantityOfItemsInCart = productListingPageObjects.getProductQuantityOfItemsInCart(productDetailsOfItemsInCart);
        productPriceOfItemsInCart = productListingPageObjects.getProductPriceOfItemsInCart(productDetailsOfItemsInCart);
        productIdOfItemsInPLPPage = productListingPageObjects.getProductIdOfItemsInPlPPage(productDetailsOfItemsInPLPPage);
        productQuantityOfItemsInPLPPage = productListingPageObjects.getProductQuantityOfItemsInPlPPage(productDetailsOfItemsInPLPPage);
    }

    private void checkAddText(){
        int count=0;
        for(int i=0;i<indexOfItemsInPLPWhichHasMoreThan0quantity.size();i++){
            for(int j=0;j<indexOfItemsInPLPWhichIsInCart.size();j++){
                if(indexOfItemsInPLPWhichHasMoreThan0quantity.get(i) != indexOfItemsInPLPWhichIsInCart.get(j)){
                    count++; }
            }
            if(count == indexOfItemsInPLPWhichIsInCart.size()){
                Assert.assertEquals(addText,productListingPageObjects.getAddText(indexOfItemsInPLPWhichHasMoreThan0quantity.get(i)));
                break;
            }
            count =0 ;
        }
    }

    private void checkRequestStockText(){
        if(indexOfItemsInPLPWhichHas0Quantity.size()>0){
            Assert.assertEquals(requestStockText,productListingPageObjects.getRequestStockText(indexOfItemsInPLPWhichHas0Quantity.get(0)));}
    }

    private void getIndexOfItemsInAndNotInCart(){
        int count =0, i, j;
        for(i = 0;i<productIdOfItemsInPLPPage.size();i++){
            for(j =0;j<productIdOfItemsInCart.size();j++){
                if(Integer.parseInt(productIdOfItemsInPLPPage.get(i)) != Integer.parseInt(productIdOfItemsInCart.get(j))){
                    count++; }
            }
            if(count == productIdOfItemsInCart.size()){ indexOfItemsInPLPWhichIsNotInCart.add(i);
            }
            else{ indexOfItemsInPLPWhichIsInCart.add(i);
            }
            count = 0;
        }
        //System.out.println("not in cart"+indexOfItemsInPLPWhichIsNotInCart);
        //System.out.println("in cart"+indexOfItemsInPLPWhichIsInCart);
    }

    private void getIndexOfItemsBasedOnQuantity(){
        for(int i=0;i<productQuantityOfItemsInPLPPage.size();i++){
            if(Integer.parseInt(productQuantityOfItemsInPLPPage.get(i))==0){
                indexOfItemsInPLPWhichHas0Quantity.add(i);
            }
            else{
                indexOfItemsInPLPWhichHasMoreThan0quantity.add(i);
                if(Integer.parseInt(productQuantityOfItemsInPLPPage.get(i))>minQuantity){
                     indexOfItemsInPLPWhichHasMoreThanMinQuantity.add(i); }
                else if(Integer.parseInt(productQuantityOfItemsInPLPPage.get(i))<=minQuantity){
                    indexOfItemsInPLPWhichHasLessThanMinQuantity.add(i);
                }
            }
        }
        //System.out.println("//==// quantity of items in plp page "+productQuantityOfItemsInPLPPage);
        //System.out.println("//==// index of itmes - 0 quantity" + indexOfItemsInPLPWhichHas0Quantity);
        //System.out.println(">0 "+ indexOfItemsInPLPWhichHasMoreThan0quantity);
        //System.out.println("<=50"+indexOfItemsInPLPWhichHasLessThanMinQuantity);
        //System.out.println(">50"+indexOfItemsInPLPWhichHasMoreThanMinQuantity);
    }

    private void calculateInitialCartTotalAndQuantity(){
        for(int x=0; x< productIdOfItemsInCart.size();x++){
            System.out.println(productIdOfItemsInCart.size()+"product id of items in cart - size");
            System.out.println(productQuantityOfItemsInCart.get(x));
            initialCartQuantity += Integer.parseInt(productQuantityOfItemsInCart.get(x));
            initialCartTotal += Math.round(Integer.parseInt(productQuantityOfItemsInCart.get(x))*Float.parseFloat(productPriceOfItemsInCart.get(x)));
            System.out.println(initialCartQuantity + " & "+initialCartTotal);
        }
        //itemsAndTotalText =initialCartQuantity+" item (s); Total: ৳"+initialCartTotal;
        System.out.println(itemsAndTotalText);
    }

    private void removeFromCartButtonInvisibility(){
        if(indexOfItemsInPLPWhichIsNotInCart.size()>0){
        Assert.assertFalse(productListingPageObjects.verifyRemoveFromCartButtonVisibility(indexOfItemsInPLPWhichIsNotInCart.get(0)));}
    }

    private void clickAddButton(){
        int count=0;
        for(int i=0;i<indexOfItemsInPLPWhichHasMoreThan0quantity.size();i++){
            for(int j=0;j<indexOfItemsInPLPWhichIsInCart.size();j++){
                if(indexOfItemsInPLPWhichHasMoreThan0quantity.get(i) != indexOfItemsInPLPWhichIsInCart.get(j)){
                    count++; }
            }
            if(count == indexOfItemsInPLPWhichIsInCart.size()){
                productListingPageObjects.clickOnAddButton(i);
                break;
            }
            count =0 ;
        }
    }

    private void selectWithinMinQuantity(){
        int count=0;
        for(int i=0;i<indexOfItemsInPLPWhichHasLessThanMinQuantity.size();i++){
            for(int j=0;j<indexOfItemsInPLPWhichIsInCart.size();j++){
                if(indexOfItemsInPLPWhichHasLessThanMinQuantity.get(i) != indexOfItemsInPLPWhichIsInCart.get(j)){
                    count++; }
            }
            if(count == indexOfItemsInPLPWhichIsInCart.size()){
                productListingPageObjects.clickOnAddButton(i);
                productQuantity = (Integer.parseInt(productQuantityOfItemsInPLPPage.get(i))/2) -1;
                System.out.println(productQuantity);
                productIndex = i;
                newProductDescriptionObjects.scrollInQuantityList(productQuantity);
                break;
            }
            count =0 ;
        }
    }




    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 1)
    public void verifyBackButtonFunctionality(){
        productListingPageObjects.clickOnPLPBackButton();
        sleep(3000);
        Assert.assertTrue(actionBarObjects.getProfileButtonElement().isDisplayed());
        searchAProduct();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 2)
    public void verifyHardBackButtonFunctionality() throws Exception {
        myActions.clickOnHardKeyBack();
        sleep(3000);
        Assert.assertTrue(actionBarObjects.getProfileButtonElement().isDisplayed());
        searchAProduct();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 3)
    public void verifyProductNameInActionBar(){
        softAssert.assertEquals(productListingPageObjects.getTextOnHeader(),productName);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 4)
    public void verifyNumberOfItemsInCart(){
        Assert.assertEquals(initialCartQuantity+"",actionBarObjects.getNumberOfItemsInCart());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 5)
    public void verifySortText(){
        Assert.assertEquals(sortText,productListingPageObjects.getTextOnSortButton());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 6)
    public void verifyFilterText(){
        Assert.assertEquals(filterText,productListingPageObjects.getTextOnFilterButton());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 7)
    public void verifySortButtonFunctionality(){
        Assert.assertEquals((productListingPageObjects.getSortButtonElement()).getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 8)
    public void verifyFilterButtonFunctionality(){
        Assert.assertEquals((productListingPageObjects.getFilterButtonElement()).getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 9)
    public void verifyItemsAndTotalText(){
        System.out.println(itemsAndTotalText+"   "+productListingPageObjects.getItemsAndTotalText());
        //Assert.assertEquals(itemsAndTotalText,productListingPageObjects.getItemsAndTotalText());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 10)
    public void verifyAddText(){
         checkAddText();            //
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 11)
    public void verifyRequestStockText(){
        checkRequestStockText();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 12)
    public void verifyRequestStockButtonFunctionality(){
        if(indexOfItemsInPLPWhichHas0Quantity.size()>0){
            productListingPageObjects.clickRequestStockButton(0);
        }
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 13)
    public void verifyRemoveFromCartButtonIsInvisible(){
        removeFromCartButtonInvisibility();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 14)
    public void verifyAddButtonFunctionality(){
        clickAddButton();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 15)
    public void verifySelectQuantityText(){
        Assert.assertEquals(selectQuantityText,productListingPageObjects.getSelectQuantityText());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 16)
    public void verifyCloseButtonInItemQuantityPopUP() {
        Assert.assertEquals(productListingPageObjects.getCloseItemQuantityButton().getAttribute("clickable"),"true");
        productListingPageObjects.getCloseItemQuantityButton().click();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 17)
    public void verifySelectMinimumQuantity(){
        selectWithinMinQuantity();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 18)
    public void verifyRemoveFromCartButtonFunctionality(){
        if(indexOfItemsInPLPWhichIsInCart.size()>0){
            productListingPageObjects.getRemoveFromCartButtonElement(productIndex).click();
        }
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 19)
    public void verifyPlusButtonFunctionality(){
        if(indexOfItemsInPLPWhichIsInCart.size()>0){
            productListingPageObjects.getAddToCartButtonElement(productIndex).click();
        }
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 20)
    public void verifyCartTotalAndItemTotalAfterAddingProducts(){
        productAmount = Float.parseFloat(productListingPageObjects.getProductPriceOfItemsInPlPPage(productDetailsOfItemsInPLPPage).get(productIndex));
        System.out.println(productAmount);
        //Assert.assertEquals((initialCartQuantity + productQuantity)+" item (s); Total: ৳"+(initialCartTotal + Math.round(productAmount)),productListingPageObjects.getItemsAndTotalText());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 21)
    public void verifyTotalItemsInActionBarCart(){
        Assert.assertEquals((initialCartQuantity + productQuantity)+"",actionBarObjects.getNumberOfItemsInCart());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 22)
    public void verifyQuantityContainerIsClickable(){
        productListingPageObjects.getItemCount(productIndex).click();
        productListingPageObjects.getCloseItemQuantityButton().click();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 23)
    public void verifySelectMaxQuantity(){
        if(indexOfItemsInPLPWhichHasMoreThanMinQuantity.size()>0 ) {
            productListingPageObjects.clickOnAddButton(indexOfItemsInPLPWhichHasMoreThanMinQuantity.get(0));
            newProductDescriptionObjects.scrollInQuantityList(51);
            Assert.assertEquals(productListingPageObjects.getItemCount(indexOfItemsInPLPWhichHasMoreThanMinQuantity.get(0)).getText(),"50");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void loginScreenAfterSuite(){
        actionBarObjects.clickOnCartButton();
        sleep(3000);
        switchFromNativeToWeb(CoreConstants.SHOP_UP_MOKAM_WEB_VIEW);
        myBagPageObjects.clickOnPlaceOrderButton();
        sleep(3000);
        checkoutAddressPageObjects.clickOnConfirmButton();
        System.out.println("ProductListingPageAfterSuite is called");
        quitBaseDriver();
    }


}
