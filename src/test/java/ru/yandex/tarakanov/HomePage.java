package ru.yandex.tarakanov;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private static String TITLE = "Авторизация";

    private WebDriver driver;

    /**
     * Логин
     */
    @FindBy(id = "passp-field-login")
    private WebElement login;

    /**
     * Кнопка ввести логин
     */
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div/div[3]/div[2]/div/div/div[1]/form/div[3]/button[1]")
    private WebElement loginButton;

    /**
     * Пароль
     */
    @FindBy(id = "passp-field-passwd")
    private WebElement password;

    /**
     * Кнопка ввести пароль
     */
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div/div[3]/div[2]/div/div/form/div[2]/button[1]")
    private WebElement passwordButton;

    /**
     * Войти
     */
    @FindBy(xpath = "//*[@id=\"index-page-container\"]/div/div[2]/div/div/div[4]/a[2]/span")
    private WebElement goin;

    public HomePage (WebDriver driver){
        if (!driver.getTitle().contains(TITLE)) {
            throw new IllegalStateException(
                    "This is not the page you are expected"
            );
        }

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private void loginUser (String loginName, String loginPassword){
        WebDriverWait wait = new WebDriverWait(driver, 15);

        login.sendKeys(loginName);
        loginButton.submit();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passp-field-passwd")));

        password.sendKeys(loginPassword);
        passwordButton.submit();
    }

    public MailListPage loginUserSuccess(String login, String password){
        loginUser(login, password);
        return new MailListPage(driver);
    }
}
