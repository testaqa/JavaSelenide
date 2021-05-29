package helpers;

import com.codeborne.selenide.Configuration;
import config.ConfigHelper;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverHelper {
    public static void configureDriver() {
        Configuration.baseUrl = ConfigHelper.webConfig.webUrl();
        Configuration.browser = ConfigHelper.webConfig.webBrowser();
        Configuration.startMaximized = true;

        if (ConfigHelper.webConfig.remoteDriverUrl() != null
                && !ConfigHelper.webConfig.remoteDriverUrl().isEmpty()) {
            Configuration.remote = ConfigHelper.webConfig.remoteDriverUrl();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }
}