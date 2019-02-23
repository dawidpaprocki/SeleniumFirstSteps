package pagesSecond;


import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Data
public class HomeSecond extends BasePageSecond {

    @FindBy(className = "header_user_info" )
    private WebElement signIn;

    public HomeSecond() {
        super();
    }

    public void signIn(){
        signIn.click();
        new Authentication();
    }
}
