package services.commerceInterfaces;

import services.commerceMethods.GetCommerceApiResponse;
import services.commerceMethods.GetMyBagApiResponse;

public interface CommerceServices {

    public GetCommerceApiResponse getControlOverServices();

    public GetMyBagApiResponse getMyBagControl();

    public void getControlOverSearchForUserApi();

    public void getControlOverUserProfileApi();

    public void getControlOverCollectionsApi();

    public void getControlOverMyCartApi();
}
