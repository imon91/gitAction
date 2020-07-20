package services.commerceInterfaces;

import services.commerceMethods.GetAuthenticationApiResponse;
import services.commerceMethods.GetCommerceApiResponse;
import services.commerceMethods.GetMyBagApiResponse;
import services.commerceMethods.GetSearchSuggestionsApiResponse;

public interface CommerceServices {

    GetCommerceApiResponse getControlOverServices();

    public GetMyBagApiResponse getMyBagControl();

    public void getControlOverSearchForUserApi();

    void getControlOverSearchForUserApi();

    void getControlOverUserProfileApi();

    void getControlOverCollectionsApi();

    public void getControlOverMyCartApi();

    public GetAuthenticationApiResponse getControlOverAuthentication();

    public GetSearchSuggestionsApiResponse getControlOverSearchSuggestionsApi();

}
