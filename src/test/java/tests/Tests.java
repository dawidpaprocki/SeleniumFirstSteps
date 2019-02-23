package tests;

import config.TestConfig;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
        //given
        home.getABTesting().click();
        AbTest abTest = new AbTest();
        //when
        String textFromH3ForTest = abTest.getH3Text().getText();
        //then
        assertTrue(textFromH3ForTest.equals("A/B Test Variation 1") ||
                textFromH3ForTest.equals("A/B Test Control"));
        assertEquals(textFromH3ForTest, "Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different" +
                " versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through).");
    }

    @Test
    public void TestBasicAuth() {
        //given
        BasicAuth basicAuth = new BasicAuth();
        home.profileLogin("admin", "admin");
        //when
        String textFromH3ForTest = basicAuth.getH3Text().getText();
        //then
        assertEquals(textFromH3ForTest, "Basic Auth");
    }

    @Test
    public void TestBrokenImagesCheck() {
        //given
        home.getBrokenImages().click();
        BrokenImages brokenImages = new BrokenImages();
        //then
        assertFalse(brokenImages.checkIfNotBroken(brokenImages.getAsdf()));
        assertFalse(brokenImages.checkIfNotBroken(brokenImages.getHjkl()));
        assertTrue(brokenImages.checkIfNotBroken(brokenImages.getAvatar()));
    }

    @Test
    public void TestIfLastCheckBoxIsCheck() {
        //given
        home.getCheckBoxes().click();
        Checkboxes checkboxes = new Checkboxes();
        List<WebElement> checkBox = checkboxes.getCheckBox();
        //when
        WebElement webElementChecked = checkBox.get(checkBox.size() - 1);
        //then
        assertTrue(webElementChecked.isSelected());
    }

    @Test
    public void TestDropDownOptionCheck() {
        //given
        home.getDropDown().click();
        Dropdown dropdown = new Dropdown();
        Select selectList = new Select(dropdown.getDropDownList());
        //when
        selectList.selectByVisibleText("Option 2");
        //then
        assertEquals("Option 2", selectList.getFirstSelectedOption().getText());
    }

}
