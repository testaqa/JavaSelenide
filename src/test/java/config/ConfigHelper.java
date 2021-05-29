package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    public static WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());

    public static ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());

    // web
//    public static WebConfig getWebConfig() {
//        return ConfigFactory.create(WebConfig.class, System.getProperties());
//    }

//    public static String getWebBrowser() {
//        return getWebConfig().webBrowser();
//    }

//    public static String getWebUrl() {
//        return getWebConfig().webUrl();
//    }

//    public static String getRemoteDriverUrl() {
//        return getWebConfig().remoteDriverUrl();
//    }

//    // api
//    private static ApiConfig getApiConfig() {
//        return ConfigFactory.create(ApiConfig.class);
//    }
//
//    public static String getApiUrl() {
//        return getApiConfig().apiUrl();
//    }
}