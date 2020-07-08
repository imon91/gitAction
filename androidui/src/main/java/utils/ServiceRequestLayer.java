package utils;

import coreUtils.CoreConstants;
import services.commerceInterfaces.CommerceServices;
import services.commerceMethods.GetCommerceApiResponse;

public class ServiceRequestLayer implements CommerceServices {

    private final String module;

    public ServiceRequestLayer(){
        this.module = CoreConstants.MODULE_ANDROID_UI;
    }


    @Override
    public GetCommerceApiResponse getControlOverServices() {
        return new GetCommerceApiResponse(module);
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
