package ru.tadree;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubTest {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void softAssertionsPageCheck() {
        //Открываем страницу Selenide в Github
        open("/selenide/selenide");
        //Переходим в раздел Wiki проекта
        $("[data-tab-item = i4wiki-tab]").click();
        //Находим страницу SoftAssertions и переходим по ней
        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
        $("#wiki-pages-box").find(byText("SoftAssertions")).click();
        //Проверяем наличие примера кода для JUnit5
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
