package tests;

import config.TestConfig;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.*;

import java.util.List;

import static org.junit.Assert.*;

public class DynamicControlsTest extends TestConfig {
    private Home home;

    @Before
    public void Before() {
        home = new Home();
    }


    @Test
    public void TestDynamicControlsLoadingBarVisibility() throws InterruptedException {
        //given
        home.getDynamicControls().click();
        DynamicControls dynamicControls = new DynamicControls();
        //when
        dynamicControls.getButton("Remove").click();
        Thread.sleep(2000);
        Boolean visibilityOfElement = dynamicControls.visibilityOfLoadingBar();
        //then
        assertTrue(visibilityOfElement);
    }

    @Test
    public void TestDynamicControlsRemoveObject() throws InterruptedException {
        //given
        home.getDynamicControls().click();
        DynamicControls dynamicControls = new DynamicControls();
        //when
        dynamicControls.getButton("Remove").click();
        Thread.sleep(5000);
        //then
        assertFalse(dynamicControls.checkIfElementIsPresent(dynamicControls.getCheckBox()));
        assertEquals(dynamicControls.getMessage().getText(),"It's gone!");
    }

    @Test
    public void TestDynamicControlsAddBackObject() throws InterruptedException {
        //given
        home.getDynamicControls().click();
        DynamicControls dynamicControls = new DynamicControls();
        //when
        dynamicControls.getButton("Remove").click();
        Thread.sleep(5000);
        dynamicControls.getButton("Add").click();
        Thread.sleep(3000);
        //then
        assertTrue(dynamicControls.checkIfElementIsPresent(dynamicControls.getCheckBox()));
        assertEquals(dynamicControls.getMessage().getText(),"It's back!");
    }


}
