package Steps;

import Support.ConfigReader;
import Support.DriverFactory;
import Support.ScenarioContext;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseStepDef {
    private WebDriver driver;
    ScenarioContext scenarioContext = new ScenarioContext();

    ConfigReader configReader = new ConfigReader();
    DriverFactory driverFactory = new DriverFactory();
    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
    private static final Logger logger = LogManager.getLogger();


    @Before
    public WebDriver setupDriver() {
        if (driver == null) {
            System.setProperty("log4j.configurationFile","log4j2-test.xml");
            logger.info("*****************Starting the Test Automation Framework***************************");
            logger.info("                           ****Initialising WebDriver******            ");
            driver = driverFactory.createWebDriver();
            driver.navigate().to(configReader.getApplicationURL());
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        }
        return driver;
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a screenshot...
            final byte[] screenshot = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
            // embed it in the report.
            scenario.write(scenario.getName());
            scenario.embed(screenshot, "image/png");
        }
        System.out.println("Shutting down WebDriver");
        if (!configReader.getBrowserName().equals("firefox")) {
            this.driver.close();
            logger.info("^^^^^^^^^^^^^^^^^Closing down Webdriver^^^^^^^^^^^^^^^^^^^^^^^^^^");
        }
        this.driver.quit();
    }

}


