package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditComputerPage extends BasePage{

    //This is the Page class for the Edit Computer Page//

    public EditComputerPage(WebDriver driver) {
        super(driver);
    }


    String linktext;

    @FindBy(xpath = "//h1[contains(text(),'Edit computer')]")
    private WebElement edittext;

    @FindBy(css=".danger")
    private WebElement deleteButton;

    public WebElement getcomputerNameLink(WebElement webElement, String linktext) {
        return  webElement.findElement(By.linkText(linktext));
    }

    public WebElement getComputerNametable() {
        return computerNametable;
    }

    @FindBy(xpath = "//section[@id='main']")
    private WebElement computerNametable;

    public WebElement getEdittext() {
        return edittext;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

}
