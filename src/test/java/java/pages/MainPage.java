package pages;


import manager.AppManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {
    WebDriver driver;

    public MainPage() {
        PageFactory.initElements(AppManager.getDriver(), this);
    }


    public String getTextBase(WebElement el) {
        return el.getText().toUpperCase().trim();
    }

    public boolean isTextEqual(WebElement el, String text) {
        if (getTextBase(el).equals(text.toUpperCase())) {
            return true;
        } else {
            System.out.println("actual result: " + getTextBase(el) + "expected result: " + text.toUpperCase());
            return false;
        }

    }

    public void pause(long mill) {
        try {
            Thread.sleep(mill * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void waitElement(WebElement el, int time) {
        new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(el));
    }

    public void clickBase1(WebElement element) {

        element.click();
    }

    public void typeTextBase1(WebElement element, String text) {

        element.click();
        element.clear();
        element.sendKeys(text);

    }

}
