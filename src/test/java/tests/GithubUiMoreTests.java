package tests;

import helpers.DriverHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.have;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class GithubUiMoreTests {

    String issueTitle = "Test Issue Title Here";
    String issueBody = "Some issue description";

    @BeforeAll
    public static void beforeAll() {
        DriverHelper.configureDriver();
    }

    @Test
    @Tag("web")
    void GithubIssueUiOtherTest() {
        open("/testaqa/qaguru_hw18/issues/");
        $("div[aria-label='Issues']").$(linkText(issueTitle)).click();
        $(".comment-body p").should(have(text(issueBody)));
    }

}