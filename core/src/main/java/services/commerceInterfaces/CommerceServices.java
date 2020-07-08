package services.commerceInterfaces;

import services.commerceMethods.GetCommerceApiResponse;

public interface CommerceServices {

    GetCommerceApiResponse getControlOverServices();

    void getControlOverSearchForUserApi();

    void getControlOverUserProfileApi();

    void getControlOverCollectionsApi();

    void getControlOverMyCartApi();
}
