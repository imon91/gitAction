package utils;

import coreUtils.CoreConstants;
import services.commerceInterfaces.*;
import services.commerceMethods.*;
import testData.ReadJSONFile;

public class ServiceRequestLayer implements CommerceServices {

    private String module;

    public ServiceRequestLayer(){
        this.module = CoreConstants.MODULE_MOBILE_WEB_UI;
    }


    @Override
    public GetCommerceApiResponse getControlOverServices() {
        return new GetCommerceApiResponse(module);
    }

    @Override
    public GetMyBagApiResponse getMyBagControl() {
        return new GetMyBagApiResponse(module);
    }

    @Override
    public void getControlOverSearchForUserApi() {

    }

    @Override
    public void getControlOverUserProfileApi() {

    }

    @Override
    public void getControlOverCollectionsApi() {

    }

    @Override
    public void getControlOverMyCartApi() {

    }

    @Override
    public GetAuthenticationApiResponse getControlOverAuthentication() {
        return new GetAuthenticationApiResponse(module);
    }

    @Override
    public GetSearchSuggestionsApiResponse getControlOverSearchSuggestionsApi() {
        return null;
    }

    @Override
    public GetPLPModuleApiResponse getControlOverPLPModuleApiResponse() {
        return null;
    }

    @Override
    public GetMyOrderApiResponse getControlOverMyOrderApiResponse() {
        return new GetMyOrderApiResponse(module);
    }

    @Override
    public GetSalesRepApiResponse getControlOverSalesRepApiResponse() {
        return null;
    }

    @Override
    public ReadJSONFile getControlOverReadJSONFile() {
        return null;
    }

    @Override
    public GetPDPModuleApiResponse getControlOverPDPModuleApiResponse() {
        return null;
    }


}
