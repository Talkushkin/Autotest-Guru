package demoga.com.tests;
import demoga.com.pages.StepsGithub;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class StepCheckNumber extends TestBase {
    StepsGithub steps = new StepsGithub();

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUES = "Issues";
    private static final int ISSUE_NUMBER = 76;

    @Test
    @Tag("Github")
    @Owner("Talkushkin")
    @Link(value = "Тестинг", url = "https://github.com")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TestCheckNumber")
    void testCheckNumber() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssuesWithNumber(ISSUE_NUMBER);
    }
}
