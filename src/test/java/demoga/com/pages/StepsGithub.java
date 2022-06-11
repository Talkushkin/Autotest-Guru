package demoga.com.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepsGithub  {

    @Step("Открываем главную страницу")
    public void openMainPage () {
        open("https://github.com/");
    }
    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Переходим по сыслке репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Кликаем на таб")
    public void openIssuesTab() {
        $(partialLinkText("Issues")).click();
    }

    @Step("Проверяем что существует issues с номером {number}")
    public void shouldSeeIssuesWithNumber(int number) {
        $(withText("#"+ number)).should(Condition.visible);
    }
}
