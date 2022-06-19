package demoga.com.tests;


import com.codeborne.selenide.Condition;;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUES = "Issues";
    private static final int ISSUE_NUMBER = 76;


    @Test
    void testGithubIssue() {

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Переходим по сыслке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Кликаем на таб " + ISSUES, () -> {
            $(partialLinkText("Issues")).click();
        });

        step("Проверяем что существует issues с номером " + ISSUE_NUMBER, () -> {
            $(withText("#76")).should(Condition.visible);
        });
    }
}

