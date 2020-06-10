package ru.yandex.tarakanov;

import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class testCases {
    ChromeDriver driver;
    public static String THEME = "Как убедиться, что письмо доставлено";
    public static String ADDRESS = "Команда Яндекс.Почты";
    public static String FIRSTLINE = "Мы подготовили несколько писем с полезными советами, " +
            "которые помогут вам освоиться в новом ящике. Для начала расскажем про отправку писем. " +
            "Послать письмо — дело нехитрое. Но иногда возникает сомнение, дошло";
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "/Users/GADZOLA/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://passport.yandex.ru/auth?from=mail&origin=hostroot_homer_auth_ru&retpath=https%3A%2F%2Fmail.yandex.ru%2F%3Fnoretpath%3D1&backpath=https%3A%2F%2Fmail.yandex.ru%3Fnoretpath%3D1");
    }

    @Test
    public void mailTest(){
        HomePage homePage = new HomePage(driver);
        homePage.loginUserSuccess("loginfortestusage", "QWE123qwe")
                .checkLetter(THEME, ADDRESS, FIRSTLINE);
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
