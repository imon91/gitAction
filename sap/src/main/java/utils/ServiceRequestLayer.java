package utils;

import coreUtils.CoreConstants;
import services.commerceInterfaces.CommerceServices;
import services.commerceMethods.*;
import testData.ReadJSONFile;

public class ServiceRequestLayer implements CommerceServices {

    private String module;

    public ServiceRequestLayer(){
        this.module = CoreConstants.MODULE_WEB_UI;
    }


    @Override
    public GetCommerceApiResponse getControlOverServices() {
        return new GetCommerceApiResponse(module);
    }

    @Override
    public GetMyBagApiResponse getMyBagControl() {
        return null;
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
        return null;
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
        return null;
    }

    @Override
    public GetSalesRepApiResponse getControlOverSalesRepApiResponse() {
        return null;
    }

    @Override
    public ReadJSONFile getControlOverReadJSONFile() {
        return null;
    }

}

