import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FirstTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void Test() {
        driver.navigate().to("http://google.pl");

        driver.findElement(By.name("q")).sendKeys("TTMS to najlepsza firma na świecie");
        driver.findElement(By.name("q")).submit();

        String pageTitle = driver.getTitle();
        assertTrue(pageTitle.contains("TTMS"));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}