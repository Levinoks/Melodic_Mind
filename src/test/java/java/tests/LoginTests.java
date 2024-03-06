package tests;


import org.testng.annotations.Test;

public class LoginTests extends BaseTest{

    @Test
    public  void  positiveLoginTest(){

        loginPage.fillLoginForm(userLogin);




    }
}
