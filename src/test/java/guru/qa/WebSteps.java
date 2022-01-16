package guru.qa;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step("Открываем главную страницу")
    public WebSteps openMainPage() {
        open("https://github.com");

        return this;
    }

    @Step("Ищем репозиторий {repository}")
    public WebSteps searchForRepository(String repository) {
        $("[data-test-selector=nav-search-input]").click();
        $("[data-test-selector=nav-search-input]").setValue(repository).submit();

        return this;
    }

    @Step("Открываем репозиторий")
    public WebSteps openRepositoryPage(String repository) {
        $(By.linkText(repository)).click();

        return this;
    }

    @Step("Проверяем наличие вкладки Issues")
    public WebSteps shouldSeeIssue() {
        $(".UnderlineNav-body").shouldHave(text("Issues"));

        return this;
    }

    @AfterEach
    @Attachment(value = "Screenshot", type = "text/html", fileExtension = "html")
    public byte[] attachPageSource() {
        return WebDriverRunner.source().getBytes(StandardCharsets.UTF_8);
    }
}
