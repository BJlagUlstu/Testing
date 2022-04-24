package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    /**
     * Конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    private final String FILMS_XPATH = "//*[@id=\"__next\"]/div[2]/div[2]/div[2]/div/div/div[1]/div/div/div/div/a[3]";
    private final String ORIGINAL_TITLE_XPATH = "//*[@id=\"__next\"]/div[2]/div[2]/div[1]/div[2]/div/div[3]/div/div/div[1]/div[1]/div/div[1]/div/span[1]";
    /**
     * Определение локатора кнопки входа в аккаунт
     */
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/header/div/div[3]/div/button")
    private WebElement loginBtn;
    /**
     * Определение локатора поля для поиска фильма
     */
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/header/div/div[2]/div[2]/div/form/div/input")
    private WebElement queryField;
    /**
     * Определение локатора, определяющего первый предложенный по запросу фильм
     */
    @FindBy(xpath = "//*[@id=\"block_left_pad\"]/div/div[2]/div/div[2]/p/a")
    private WebElement firstResultOfProposed;
    /**
     * Определение локатора, определяющего оригинальное название фильма
     */
    @FindBy(xpath = ORIGINAL_TITLE_XPATH)
    private WebElement originalMovieTitle;
    /**
     * Определение локатора кнопки «Фильмы»
     */
    @FindBy(xpath = FILMS_XPATH)
    private WebElement filmsBtn;
    /**
     * Определение локатора кнопки «Лучшие фильмы»
     */
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[2]/div[4]/div[2]/div/a[1]")
    private WebElement bestFilmsBtn;
    /**
     * Определение локатора, определяющего лучший фильм
     */
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[2]/div[2]/div[3]/main/div[4]/div[2]/div[1]/div[1]/a/div[1]")
    private WebElement firstResultOfBestFilms;
    /**
     * Определение локатора меню пользователя
     */
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/header/div/div[3]/div/div[2]")
    private WebElement userMenu;
    /**
     * Определение локатора кнопки выхода из аккаунта
     */
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/header/div/div[3]/div/div[3]/nav/ul[2]/li[8]/button")
    private WebElement logoutBtn;
    /**
     * Метод для осуществления нажатия кнопки входа в аккаунт
     */
    public void clickLoginBtn() {
        loginBtn.click();
    }
    /**
     * Метод для осуществления нажатия кнопки «Фильмы»
     */
    public void clickFilmsBtn() {
        filmsBtn.click();
    }
    /**
     * Метод для осуществления нажатия кнопки «Лучшие фильмы»
     */
    public void clickBestFilmsBtn() {
        bestFilmsBtn.click();
    }
    /**
     * Метод для осуществления нажатия на первый результат из списка
     */
    public void clickOnFirstResultOfBestFilms() {
        firstResultOfBestFilms.click();
    }
    /**
     * Метод для получения оригинального названия фильма
     */
    public String getOriginalMovieTitle() {
        return originalMovieTitle.getText();
    }
    /**
     * Метод для ввода запроса
     */
    public void inputQuery(String query) {
        queryField.sendKeys(query);
    }
    /**
     * Метод для submit запроса
     */
    public void submitQuery() {
        queryField.submit();
    }
    /**
     * Метод для осуществления нажатия на первый результат из списка
     */
    public void clickOnFirstResultOfProposed() {
        firstResultOfProposed.click();
    }
    /**
     * Определение локатора кнопки «Настройки»
     */
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/header/div/div[3]/div/div[3]/nav/ul[2]/li[5]/a")
    private WebElement settingsBtn;
    /**
     * Метод для нажатия кнопки «Настройки»
     */
    public void clickSettingsBtn() {
        settingsBtn.click();
    }
    /**
     * Метод для нажатия кнопки меню пользователя
     */
    public void clickUserMenu() {
        userMenu.click();
    }
    /**
     * Метод для нажатия кнопки выхода из аккаунта
     */
    public void clickLogout() {
        logoutBtn.click();
    }
    /**
     * Метод для "усыпления" потока выполнения
     */
    public void await() {
        try {
            Thread.sleep(500);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}