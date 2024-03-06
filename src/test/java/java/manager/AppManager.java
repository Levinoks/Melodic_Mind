package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.ConfigProperties;
import java.util.concurrent.TimeUnit;

public class AppManager {
    private static EventFiringWebDriver driver = null;
    static Logger logger = LoggerFactory.getLogger(AppManager.class);


    @BeforeSuite
    private static EventFiringWebDriver init() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.navigate().to(ConfigProperties.getProperty("url"));
        logger.info("open page: " + ConfigProperties.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.register(new WDListener());

        return driver;

    }

    @AfterSuite
    private static void tearDown() {
        driver.quit();

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = init();
        }
        return driver;
    }
}









