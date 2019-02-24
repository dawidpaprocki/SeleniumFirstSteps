package pagesSecond;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


@Data
public class CreateAccount extends BasePageSecond {
    @FindBy(className = "page-subheading")
    private WebElement subHeading;

    @FindBy(id = "id_gender1")
    private WebElement maleTitleRadio;
    @FindBy(id = "newsletter")
    private WebElement newsletter;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastName;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "days")
    private WebElement birthdayDaySelect;

    @FindBy(id = "months")
    private WebElement birthMonthSelect;

    @FindBy(id = "years")
    private WebElement birthdayYearSelect;

    @FindBy(id = "address1")
    private WebElement addressLine;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement stateSelect;

    @FindBy(id = "postcode")
    private WebElement zipCode;

    @FindBy(id = "phone_mobile")
    private WebElement phoneNumber;

    @FindBy(id = "submitAccount")
    private WebElement submitButton;

    @FindBy(css = "#center_column > .alert li")
    private List<WebElement> alertMessageContent;



    public CreateAccount() {
        super();
    }

    public void createCustomer() throws InterruptedException {
        maleTitleRadio.click();
        newsletter.click();
        customerFirstName.sendKeys("Daw");
        customerLastName.sendKeys("new");
        this.password.sendKeys("123456");
        new Select(birthdayDaySelect).selectByValue("1");
        new Select(birthMonthSelect).selectByValue("10");
        new Select(birthdayYearSelect).selectByValue("1990");
        addressLine.sendKeys("Uliczna1");
        city.sendKeys("miasto");
        new Select(stateSelect).selectByValue("1");
        zipCode.sendKeys("11101");
        phoneNumber.sendKeys("123456");
        submitButton.click();
        Thread.sleep(10000);
    }
}
