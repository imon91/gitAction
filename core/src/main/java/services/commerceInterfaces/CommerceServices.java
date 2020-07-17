package services.commerceInterfaces;
import services.commerceMethods.GetCommerceApiResponse;
import services.commerceMethods.GetSearchSuggestionsApiResponse;

public interface CommerceServices {

    GetCommerceApiResponse getControlOverServices();

    void getControlOverSearchForUserApi();

    void getControlOverUserProfileApi();

    void getControlOverCollectionsApi();

    public void getControlOverMyCartApi();

    public GetSearchSuggestionsApiResponse getControlOverSearchSuggestionsApi();

}
