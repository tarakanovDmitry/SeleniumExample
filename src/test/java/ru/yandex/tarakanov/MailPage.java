package ru.yandex.tarakanov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailPage {

    private WebDriver driver;

    /**
     * Тайтл
     */
    @FindBy(xpath = "//*[@id=\"nb-1\"]/head/title")
    private WebElement title;

    /**
     * Отправитель
     */
    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[5]/div/div[3]/div[3]/div[2]/div[5]/div[1]/div/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/span[2]/span[1]")
    private WebElement sender;

    /**
     * Тема письма
     */
    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[5]/div/div[3]/div[3]/div[2]/div[5]/div[1]/div/div[2]/div[1]/div[1]/div/div/span/div")
    private WebElement themeMessage;

    /**
     * Текст письма
     */
    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[5]/div/div[3]/div[3]/div[2]/div[5]/div[1]/div/div[2]/div[1]/div[1]/div/div/span/div")
    private WebElement textMessage;

    /**
     * Выход из почты
     */
    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[5]/div/div[2]/div/div/header/div/div[5]/div[2]/div/ul/ul/li[5]/a")
    private WebElement logOut;

}
