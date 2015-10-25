package is.arnlaugsson.chuck_joke;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ChuckWebTest {

    static WebDriver driver;
    static String baseUrl;
    static String port;

    @BeforeClass
    public static void before() {
        driver = new FirefoxDriver();
        port = System.getenv("PORT");
        if(port == null) {
            port = "4567";
        }
        baseUrl = "http://localhost:" + port;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void after() {
        driver.close();
    }

    @Before
    public void setup() {
        ;
    }

    @After
    public void tearDown() {
        driver.get(baseUrl + "/resetName");
    }

    @Test
    public void assertTitle() {
        driver.get(baseUrl + "/");
        assertEquals("Chuck Norris Jokes", driver.getTitle());
    }

    @Test
    public void assertSpecificJoke() {
        driver.get(baseUrl + "/specific.html");

        WebElement number = driver.findElement(By.id("number"));
        number.clear();
        number.sendKeys("5");

        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement updatedBox = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success"))
        );
        String expected = "Chuck Norris lost his virginity before his dad did.";
        String found = driver.findElement(By.id("results")).getText();
        assertEquals(expected, found);
    }

    @Test
    public void assertThatChangedNameIsUsed() {
        driver.get(baseUrl + "/config.html");

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.clear();
        firstName.sendKeys("Hannes");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.clear();
        lastName.sendKeys("Pétursson");

        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        driver.get(baseUrl + "/specific.html");

        WebElement number = driver.findElement(By.id("number"));
        number.clear();
        number.sendKeys("396");

        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement updatedBox = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success"))
        );
        String expected = "Only Hannes Pétursson can prevent forest fires.";
        String found = driver.findElement(By.id("results")).getText();
        assertEquals(expected, found);
    }
}
