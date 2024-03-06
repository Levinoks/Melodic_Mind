package tests;

import dto.UserDTO;
import manager.TestNGListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import utils.ConfigProperties;

import java.lang.reflect.Method;
import java.util.Arrays;

@Listeners(TestNGListener.class)
public class BaseTest {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    BlogPage blogPage = new BlogPage();
    ContactPage contactPage = new ContactPage();
    FAQPage faqPage = new FAQPage();
    LearnPage learnPage = new LearnPage();
    PartnerWithUsPage partnerWithUsPage = new PartnerWithUsPage();
    TheStoryPage storyPage = new TheStoryPage();
    TutorialsPage tutorialsPage = new TutorialsPage();


    Logger logger = LoggerFactory.getLogger(BaseTest.class);

    UserDTO userLogin = UserDTO.builder()
            .email(ConfigProperties.getProperty("email"))
            .password(ConfigProperties.getProperty("password"))
            .build();


    @BeforeMethod(alwaysRun = true)
    public void beforeEachMethod(Method method) {
        logger.info("-------------------------------------");
        logger.info("started method: " + method.getName());
        logger.info("started method with params: " + Arrays.toString(method.getParameters()));
    }

    @AfterMethod(alwaysRun = true)
    public void afterEachMethod(Method method) {
        logger.info("stopped method: " + method.getName());
        logger.info("stopped method with params: " + Arrays.toString(method.getParameters()));
    }
}
