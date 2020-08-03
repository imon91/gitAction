package coreUtils;


import java.io.File;

public class CoreFileRouters {

    public static final String dir = System.getProperty("user.dir");
    static File f = new File(System.getProperty("user.dir"));
    static String filepath = f.getParent();
    public static final String resourcesPath = dir + "/src/main/resources/";
    public static final String apkPath = resourcesPath + "apkFiles/";
    public static final String chromeDriversFolderPath = resourcesPath + "chromeDrivers/drivers/";
    public static final String authFolderPath = filepath+"/core/src/main/java/auth/";
    public static final String commerceAuthData = authFolderPath+"commerce/";
    public static final String wmsAuthData = authFolderPath+"wms/";
    public static final String storeAuthData = authFolderPath+"store/";
    public static final String scriptPropertiesFolderPath = filepath+"/scriptProperties/";
}
