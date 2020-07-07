package com.shopf.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import coreUtils.CoreConstants;
import org.testng.annotations.Test;
import services.responseModels.wmsModels.WareHouseListModel;
import services.responseModels.wmsModels.WarehouseBinDetails;
import services.wmsMethods.GetWMSApiResponse;
import utils.WmsBaseClass;

import java.util.List;


public class TestClass extends WmsBaseClass {

    @Test(groups = CoreConstants.GROUP_SMOKE)
    public void tester() throws JsonProcessingException {
        GetWMSApiResponse getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
        List<WareHouseListModel.WareHousesBean> list = getWMSApiResponse.getListOfWarehouses();
        System.out.println(list.get(2).getFirstname());
    }}
