package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    /**
     * Конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    /**
     * Определение локатора главного меню
     */
    @FindBy(xpath = "//*[@id=\"kinopoisk-header-sticky-container\"]/header/div/div[1]")
    private WebElement menu;
    /**
     * Определение локатора, определяющего заголовок аккаунта
     */
    @FindBy(xpath = "//*[@id=\"content_block\"]/table/tbody/tr/td/form/table/tbody/tr[1]/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[2]/div/p/a")
    private WebElement accountTitle;
    /**
     * Определение локатора поля «Имя»
     */
    @FindBy(xpath = "//*[@id=\"edit[main][first_name]\"]")
    private WebElement firstnameField;
    /**
     * Определение локатора поля «Фамилия»
     */
    @FindBy(xpath = "//*[@id=\"edit[main][last_name]\"]")
    private WebElement lastnameField;
    /**
     * Определение локатора кнопки «Сохранить все»
     */
    @FindBy(xpath = "//*[@id=\"js-save-edit-form\"]")
    private WebElement saveAllBtn;
    /**
     * Метод для очистки поля «Имя»
     */
    public void clearFirstnameField() {
        firstnameField.clear();
    }
    /**
     * Метод для очистки поля «Фамилия»
     */
    public void clearLastnameField() {
        lastnameField.clear();
    }
    /**
     * Метод для ввода данных в поле «Имя»
     */
    public void inputFirstname(String firstname) {
        firstnameField.sendKeys(firstname);
    }
    /**
     * Метод для ввода данных в поле «Фамилия»
     */
    public void inputLastname(String lastname) {
        lastnameField.sendKeys(lastname);
    }
    /**
     * Метод нажатия кнопки главного меню
     */
    public void clickMenu() {
        menu.click();
    }
    /**
     * Метод для получения заголовка аккаунта
     */
    public String getAccountTitle() {
        return accountTitle.getText();
    }
    /**
     * Метод для submit введенных данных
     */
    public void submitData() {
        saveAllBtn.submit();
    }
}