package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoviePage {
    /**
     * Конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public MoviePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    /**
     * Определение локатора главного меню
     */
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/header/div/div[1]/div")
    private WebElement menu;
    /**
     * Метод нажатия кнопки главного меню
     */
    public void clickMenu() {
        menu.click();
    }
}