package tests;

import config.TestConfigSecond;
import org.junit.Before;
import org.junit.Test;
import pagesSecond.Authentication;
import pagesSecond.CreateAccount;
import pagesSecond.HomeSecond;

import static org.junit.Assert.assertTrue;
import static utility.DataCreator.createRandomString;

public class TestsSecond extends TestConfigSecond {
    private HomeSecond home;

    @Before
    public void Before(){
        home = new HomeSecond();
    }


    @Test
    public void SignInFail() throws InterruptedException {
        // given
        home.signIn();
        Thread.sleep(2000);
        Authentication authentication = new Authentication();
        // when
        authentication.getSignInButton().click();
        Thread.sleep(2000);
        // then
        assertTrue(authentication.getCreateAccountError().isDisplayed());
    }

    @Test
    public void setEmailCorrect() throws InterruptedException {
        // given
        home.signIn();
        Thread.sleep(2000);
        Authentication authentication = new Authentication();
        CreateAccount createAccount = new CreateAccount();
        // when

        authentication.inputText(authentication.getTextFieldForEmail(),createRandomString()+"@o2.pl");
        Thread.sleep(2000);
        // then
        assertTrue(createAccount.getSubHeading().isDisplayed());
    }
}
