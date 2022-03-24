import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Homepage {

    public static String basedUrl = "https://www.placelab.com/";
    public WebDriver driver;
    public String browser;

    public Homepage() {

    }

    @BeforeTest
    public void openBrowser() {
        this.browser = "Edge";
        if (this.browser.contains("Chrome")) {
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
        } else if (this.browser.contains("Edge")) {
            WebDriverManager.edgedriver().setup();
            this.driver = new EdgeDriver();
        }
        this.driver.navigate().to(basedUrl);

    }

    @Test
    public void verifyHomepageText() {
        String expectedText = "How it works?";
        //String expectedText = "How it works? Hi";   //- check will the test fail
        //By by = new By.ByXPath("//div[@class=\"how-it-works-container shorter\"]/h3");
        //String actualText = this.driver.findElement(by).getText();

        //Or we can do like this:
        String actualText = this.driver.findElement(By.xpath("//div[@class=\"how-it-works-container shorter\"]/h3")).getText();

        Assert.assertEquals(actualText, expectedText);
    }

    @AfterTest
    public void closeBrowser() {
        this.driver.quit();
    }
}
