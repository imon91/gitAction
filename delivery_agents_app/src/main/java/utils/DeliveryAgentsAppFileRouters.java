package utils;

import java.io.File;

public class DeliveryAgentsAppFileRouters {

    public static final String dir = System.getProperty("user.dir");
    static File f = new File(System.getProperty("user.dir"));
    static String filepath = f.getParent();
    public static final String resourcesPath = dir + "/src/main/resources/";
    public static final String downloadsPath = dir + "/Downloads";
    public static final String featuresPath = dir + "/features/";
    public static final String stepDefinitionsPath = dir + "/src/test/java/stepDefinitions/";
    public static final String testDataPath = resourcesPath + "testData/";

}
