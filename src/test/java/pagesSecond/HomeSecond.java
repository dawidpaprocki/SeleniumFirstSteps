package pagesSecond;


import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Data
public class HomeSecond extends BasePageSecond {

    @FindBy(className = "header_user_info" )
    private WebElement signIn;

    @FindBy(css = "#block_top_menu > ul > li >a[title='Dresses']")
    private WebElement dresses;

    public HomeSecond() {
        super();
    }

    public void signIn(){
        signIn.click();
        new Authentication();
    }
}
