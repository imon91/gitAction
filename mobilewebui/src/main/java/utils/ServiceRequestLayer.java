package utils;

import coreUtils.CoreConstants;
import services.commerceInterfaces.CommerceServices;
import services.commerceMethods.GetCommerceApiResponse;
import services.commerceMethods.GetMyBagApiResponse;

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


}
