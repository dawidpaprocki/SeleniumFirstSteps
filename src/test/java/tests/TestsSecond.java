package tests;

import config.TestConfigSecond;
import org.junit.Before;
import org.junit.Test;
import pagesSecond.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utility.DataCreator.createRandomString;

public class TestsSecond extends TestConfigSecond {
    private HomeSecond home;
    private Authentication authentication;
    private MyAccount myAccount;
    private CreateAccount createAccount;

    @Before
    public void Before() {

        home = new HomeSecond();
        authentication = new Authentication();
        myAccount = new MyAccount();
        createAccount = new CreateAccount();
    }


    @Test
    public void TestSignInFail() throws InterruptedException {
        // given
        home.signIn();
        Thread.sleep(2000);
        // when
        authentication.getSignInButton().click();
        Thread.sleep(2000);
        // then
        assertTrue(authentication.getCreateAccountError().isDisplayed());
    }

    @Test
    public void TestSetEmailCorrectAndSignIn() throws InterruptedException {
        // given
        home.signIn();
        Thread.sleep(2000);
        // when
        authentication.inputText(authentication.getTextFieldForEmail(), createRandomString() + "@o2.pl");
        Thread.sleep(2000);
        // then
        assertTrue(createAccount.getSubHeading().isDisplayed());
    }

    @Test
    public void TestLogin() throws InterruptedException {
        // given
        home.signIn();
        Thread.sleep(2000);
        // when
        authentication.getEMail().sendKeys("srel2@o2.pl");
        authentication.getPassword().sendKeys("12345");
        // then
        assertTrue(myAccount.getPageHeading().isDisplayed());
    }

    @Test
    public void fillUpCustomerRegisterData() throws InterruptedException {
        // given
        home.signIn();
        // when
        authentication.inputText(authentication.getTextFieldForEmail(), createRandomString() + "@o2.pl");
        createAccount.createCustomer();
        // then
        assertEquals(myAccount.getPageHeading().getText(), "My account");
    }

    @Test
    public void checkAddedToShoppingCart() throws InterruptedException {
        // given
        home.getDresses().click();
        Dresses dresses = new Dresses();
        // when
        Thread.sleep(2000);
        dresses.addDressToCart();
        // then
        assertTrue(dresses.checkIfElementIsVisible("cart_block_product_name"));
    }
}
