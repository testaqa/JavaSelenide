package helpers;

import com.codeborne.selenide.Configuration;
import config.ConfigHelper;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverHelper {
    public static void configureDriver() {
        Configuration.baseUrl = ConfigHelper.getWebUrl();
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.startMaximized = true;

        if (ConfigHelper.isRemoteWebDriver()) {
            Configuration.remote = System.getProperty("web.remote.driver");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }
}