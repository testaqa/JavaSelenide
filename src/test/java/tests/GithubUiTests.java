package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.AttachmentsHelper;
import helpers.DriverHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.have;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

@Feature("Github UI test")
public class GithubUiTests {

    String issueTitle = "Test Issue Title Here";
    String issueBody = "Some issue description";

    @BeforeAll
    public static void beforeAll() {
        DriverHelper.configureDriver();
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @AfterEach
    public void afterEach() {
        AttachmentsHelper.attachScreenshot("Last screenshot");
        AttachmentsHelper.attachPageSource();
        AttachmentsHelper.attachAsText("Browser console logs", AttachmentsHelper.getConsoleLogs());
        AttachmentsHelper.attachVideo();
    }

    @Test
    @DisplayName("Test how issue body displayed")
    @Story("Github issues userstory")
    @Description("Verify issue title and body")
    @Tag("web")
    void GithubIssueUiTest() {
        step("Open page with issues", () -> {
            open("/testaqa/qaguru_hw18/issues/");
        });
        step("Click on issue", () -> {
            $("div[aria-label='Issues']").$(linkText(issueTitle)).click();
        });
        step("Verify issue body", () -> {
            $(".comment-body p").should(have(text(issueBody)));
        });
    }
}