package tests;

import config.TestConfig;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.*;

import java.util.List;

import static org.junit.Assert.*;

public class Tests extends TestConfig {
    private Home home;

    @Before
    public void Before() {
        home = new Home();
    }

    @Test
    public void testAbTestText() {
        home.getABTesting().click();
        AbTest abTest = new AbTest();
        assertTrue(abTest.getH3Text().getText().equals("A/B Test Variation 1") ||
                abTest.getH3Text().getText().equals("A/B Test Control"));
        assertEquals(abTest.getPText().getText(), "Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different" +
                " versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through).");
    }

    @Test
    public void TestBasicAuth() {
        BasicAuth basicAuth = new BasicAuth();
        home.profileLogin("admin","admin");
        
        assertEquals(basicAuth.getH3Text().getText(),"Basic Auth");
    }
    @Test
    public void TestBrokenImagesCheck() {
        home.getBrokenImages().click();
        BrokenImages brokenImages = new BrokenImages();

        assertFalse(brokenImages.checkIfNotBroken(brokenImages.getAsdf()));
        assertFalse(brokenImages.checkIfNotBroken(brokenImages.getHjkl()));
        assertTrue(brokenImages.checkIfNotBroken(brokenImages.getAvatar()));
    }

    @Test
    public void TestIfLastCheckBoxIsChecked() {
        home.getCheckBoxes().click();

        Checkboxes checkboxes = new Checkboxes();
        List<WebElement> checkBox = checkboxes.getCheckBox();

        WebElement webElementChecked = checkBox.get(checkBox.size() - 1);

        assertTrue(webElementChecked.isSelected());
    }

}
