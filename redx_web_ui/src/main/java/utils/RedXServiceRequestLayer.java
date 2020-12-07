package utils;

import coreUtils.CoreConstants;
import services.redxInterfaces.RedXServices;
import testData.ReadJSONFileRedX;

public class RedXServiceRequestLayer implements RedXServices {

    private String module;

    public RedXServiceRequestLayer(){
        this.module = CoreConstants.MODULE_WEB_UI;
    }

    public ReadJSONFileRedX getControlOverReadJSONFileRedX(){
        return new ReadJSONFileRedX(module);
    }
}

