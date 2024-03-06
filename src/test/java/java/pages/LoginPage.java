package pages;

import dto.UserDTO;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends MainPage{

    @FindBy(xpath="//div[@class='btn-container']/button[2]")
    WebElement btnContWithEmail;
    @FindBy(xpath="//span[contains(text(), 'Login')]")
    WebElement btnLogin;
    @FindBy(xpath="//input[@aria-label='Email']")
    WebElement inputEmail;
    @FindBy(xpath="//input[@aria-label='Password']")
    WebElement inputPassword;
    @FindBy(xpath="//form//button[@type='submit']")
    WebElement btnSignIn;




    public void fillLoginForm(UserDTO user){
        clickBtnLogin();
        clickBtnContWithEmail();
        fillEmail(user.getEmail());
        fillPassword(user.getPassword());
        clickBtnSignIn();
    }


    public void clickBtnContWithEmail(){
        clickBase1(btnContWithEmail);
    }
    public void clickBtnLogin(){
        clickBase1(btnLogin);
    }
    public void clickBtnSignIn(){
        clickBase1(btnSignIn);
    }
    public void fillEmail(String email){
        typeTextBase1(inputEmail, email);
    }
    public void fillPassword(String password){
        typeTextBase1(inputPassword, password);
    }



}
