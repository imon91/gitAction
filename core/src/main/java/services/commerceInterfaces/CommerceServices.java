package services.commerceInterfaces;

import services.commerceMethods.GetCommerceApiResponse;

public interface CommerceServices {

    public GetCommerceApiResponse getControlOverServices();

    public void getControlOverSearchForUserApi();

    public void getControlOverUserProfileApi();

    public void getControlOverCollectionsApi();

    public void getControlOverMyCartApi();
}
