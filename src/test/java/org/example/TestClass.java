package org.example;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestClass {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static MainPage mainPage;
    public static MoviePage moviePage;
    public static WebDriver driver;
    private static boolean isAuthorize = false;
    /**
     * Осуществление первоначальной настройки
     */
    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        mainPage = new MainPage(driver);
        moviePage = new MoviePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfProperties.getProperty("mainPage"));
    }

    @Before
    public void loginTest() {
        if (!isAuthorize) {
            mainPage.clickLoginBtn();
            loginPage.inputLogin(ConfProperties.getProperty("login"));
            loginPage.clickLoginBtn();
            loginPage.inputPassword(ConfProperties.getProperty("password"));
            loginPage.clickLoginBtn();
            isAuthorize = loginPage.getIsAuthorize();
        }
    }

    @Test
    public void setUserNameTest() {
        mainPage.await();
        mainPage.clickUserMenu();
        mainPage.await();
        mainPage.clickSettingsBtn();
        profilePage.clearFirstnameField();
        profilePage.clearLastnameField();
        profilePage.inputFirstname(ConfProperties.getProperty("firstname"));
        profilePage.inputLastname(ConfProperties.getProperty("lastname"));
        profilePage.submitData();
        profilePage.clickMenu();
    }

    @Test
    public void getAccountTitleTest() {
        mainPage.await();
        mainPage.clickUserMenu();
        mainPage.await();
        mainPage.clickSettingsBtn();
        String actualAccountTitle = profilePage.getAccountTitle();
        Assert.assertEquals(ConfProperties.getProperty("accountTitle"), actualAccountTitle);
        System.out.println(actualAccountTitle);
        profilePage.clickMenu();
    }

    @Test
    public void getBestMovieTitleTest() {
        mainPage.clickFilmsBtn();
        mainPage.clickBestFilmsBtn();
        mainPage.clickOnFirstResultOfBestFilms();
        String actualMovieTitle = mainPage.getOriginalMovieTitle();
        Assert.assertEquals(ConfProperties.getProperty("originalTitleOfBestFilm"), actualMovieTitle);
        System.out.println(actualMovieTitle);
        moviePage.clickMenu();
    }

    @Test
    public void getMovieTitleByQueryTest() {
        mainPage.inputQuery(ConfProperties.getProperty("query"));
        mainPage.submitQuery();
        mainPage.clickOnFirstResultOfProposed();
        String actualMovieTitle = mainPage.getOriginalMovieTitle();
        Assert.assertEquals(ConfProperties.getProperty("originalMovieTitleByQuery"), actualMovieTitle);
        System.out.println(actualMovieTitle);
        moviePage.clickMenu();
    }

    @AfterClass
    public static void tearDown() {
        if (isAuthorize) {
            mainPage.clickUserMenu();
            mainPage.clickLogout();
        }
        driver.quit();
    }
}