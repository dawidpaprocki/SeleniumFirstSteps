package pagesSecond;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Data
public class Authentication extends BasePageSecond {
    @FindBy(id = "SubmitCreate")
    private WebElement signInButton;

    @FindBy(id = "email_create")
    private WebElement textFieldForEmail;

    @FindBy(id = "create_account_error")
    private WebElement createAccountError;

    @FindBy(id = "email")
    private WebElement eMail;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLogin;

    public Authentication() {
        super();
    }

    public void inputText(WebElement elementToFill,String text){
        elementToFill.sendKeys(text);
        signInButton.click();
        new CreateAccount();
    }
}
