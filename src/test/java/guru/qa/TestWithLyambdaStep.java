package guru.qa;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestWithLyambdaStep {
    private static final String REPOSITORY = "eroshenkoam/allure-example";

    @Test
    public void testWithLyambda() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий" + REPOSITORY, () -> {
            $("[data-test-selector=nav-search-input]").click();
            $("[data-test-selector=nav-search-input]").setValue(REPOSITORY).submit();
        });
        step("Открываем репозиторий" + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Проверяем наличие вкладки Issues", () -> {
            $(".UnderlineNav-body").shouldHave(text("Issues"));
        });
    }
}

