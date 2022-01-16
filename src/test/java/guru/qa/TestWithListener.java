package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestWithListener {

    @Test
    public void testWithListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $("[data-test-selector=nav-search-input]").click();
        $("[data-test-selector=nav-search-input]").setValue("eroshenkoam/allure-example").submit();
        $(By.linkText("eroshenkoam/allure-example")).click();
        $(".UnderlineNav-body").shouldHave(text("Isues"));
    }
}
