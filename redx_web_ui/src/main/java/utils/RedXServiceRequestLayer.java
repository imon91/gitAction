package utils;

import coreUtils.CoreConstants;
import services.commerceInterfaces.CommerceServices;
import services.commerceMethods.*;
import services.redxInterfaces.RedXServices;
import testData.ReadJSONFile;

public class RedXServiceRequestLayer implements RedXServices {

    private String module;

    public RedXServiceRequestLayer(){
        this.module = CoreConstants.MODULE_WEB_UI;
    }

}

