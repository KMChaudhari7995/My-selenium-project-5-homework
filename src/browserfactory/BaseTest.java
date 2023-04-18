package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    public void openBrowser(String baseUrl){
        driver = new ChromeDriver();
        //launch URL
        driver.get(baseUrl);
        //maximize the window
        driver.manage().window();
        //implicit timeout for method
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void closeBrowser(){
        //closing the browser code
        driver.quit();
    }


}
