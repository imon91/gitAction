package utils;

public class CommonUtils {
    public static void threadSleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            System.out.println("Thread.sleep Exception");
        }
    }
}
