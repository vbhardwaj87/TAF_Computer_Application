package Support;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class DriverFactory {

    //For picking the webdriver as per the browser

    ConfigReader configReader = new ConfigReader();

    //Get the Browser Name from the properties file and initialise webdriver
        public WebDriver createWebDriver() {
            String webdriver = System.getProperty("browser", configReader.getBrowserName());
            switch(webdriver) {
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", configReader.getDriverPathFirefox());
                    return new FirefoxDriver();
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", configReader.getDriverPathChrome());
                    return new ChromeDriver();

                default:
                    throw new RuntimeException("Unsupported webdriver: " + webdriver);
            }
        }
}

