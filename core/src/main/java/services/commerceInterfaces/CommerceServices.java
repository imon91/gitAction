package services.commerceInterfaces;

import testData.ReadJSONFile;
import services.commerceMethods.*;

public interface CommerceServices {

    public GetCommerceApiResponse getControlOverServices();

    public GetMyBagApiResponse getMyBagControl();

    public void getControlOverSearchForUserApi();

    public void getControlOverUserProfileApi();

    public void getControlOverCollectionsApi();

    public void getControlOverMyCartApi();

    public GetAuthenticationApiResponse getControlOverAuthentication();

    public GetSearchSuggestionsApiResponse getControlOverSearchSuggestionsApi();

    public GetPLPModuleApiResponse getControlOverPLPModuleApiResponse();

    public GetMyOrderApiResponse getControlOverMyOrderApiResponse();

    public GetSalesRepApiResponse getControlOverSalesRepApiResponse();

    public ReadJSONFile getControlOverReadJSONFile();

    public GetPDPModuleApiResponse getControlOverPDPModuleApiResponse();

}
