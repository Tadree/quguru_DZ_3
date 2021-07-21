package ru.tadree;

import static com.codeborne.selenide.Condition.text;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = " https://the-internet.herokuapp.com";
    }

    @Test
    void changeRectanglesByDragAndDrop() {
        //открываем страницу  https://the-internet.herokuapp.com/drag_and_drop
        open("/drag_and_drop");
        //переносим прямоугольник А на место В
        $("#column-a").dragAndDropTo($("#column-b"));
        //проверяем, что прямоугольники поменялись местами
        $("#column-a").shouldHave(text("B"));
    }
}
