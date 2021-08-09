package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

    //This is the base Page class //

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    //Method to select the drop down in the application
    public static void selectDropDown(WebElement webElement, int index){
        try {
            Select dropdown = new Select(webElement);
            dropdown.selectByIndex(index);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void clickButton(WebElement webElement){
        webElement.click();
    }



}
