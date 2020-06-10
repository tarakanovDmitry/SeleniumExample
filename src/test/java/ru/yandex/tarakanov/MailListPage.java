package ru.yandex.tarakanov;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailListPage {
    private WebDriver driver;

    /**
     * Тайтл
     */
    @FindBy(xpath = "//*[@id=\"nb-1\"]/head/title")
    private WebElement title;

    /**
     * Письмо
     */
    @FindBy(xpath = "/html/body/div[2]/div[5]/div/div[3]/div[3]/div[2]/div[5]/div[1]/div/div/div[2]/div/div/div/div/div/a/div")
    private WebElement letter;

    /**
     * Кнопка "не сейчас"
     */
    @FindBy(id = "//*[@id=\"root\"]/div/div/div[2]/div/div/div[3]/div[2]/div/form/div[3]/button")
    private WebElement notNow;

    /**
     * E-mail адрес
     */
    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[5]/div/div[3]/div[3]/div[2]/div[5]/div[1]/div/div/div[2]/div/div/div/div/div/a/div/span[1]/span[2]/span")
    private WebElement letterAddress;

    /**
     *Тема письма
     */
    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[5]/div/div[3]/div[3]/div[2]/div[5]/div[1]/div/div/div[2]/div/div/div/div/div/a/div/span[2]/div/span/span[1]/span[1]/span")
    private WebElement letterTheme;

    /**
     *Первая строка письма
     */
    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[5]/div/div[3]/div[3]/div[2]/div[5]/div[1]/div/div/div[2]/div/div/div/div/div/a/div/span[2]/div/span/span[2]/span")
    private WebElement letterFirstLine;

    public MailListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public MailListPage checkLetter(String theme, String address, String firstLine){

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[5]/div/div[3]/div[3]/div[2]/div[5]/div[1]/div/div/div[2]/div/div/div/div/div/a/div/span[1]/span[2]/span")));

        Assert.assertEquals("Не совпадает тема сообщения", letterTheme.getText(), theme);
        Assert.assertEquals("Не совпадает отправитель", letterAddress.getText(), address);
        Assert.assertEquals("Не совпадает содержимое письма", letterFirstLine.getText(), firstLine);
        return this;
    }


}
