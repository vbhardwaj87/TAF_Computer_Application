package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddComputerPage extends BasePage {

    //This is the Page class for the Add Computer Page//

    public AddComputerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#name")
    private WebElement computername;

    @FindBy(css = "#introduced")
    private WebElement introducedDate;

    @FindBy(css = "#discontinued")
    private WebElement discontinuedDate;

    @FindBy(css = "#company")
    private WebElement companyDropDown;

    @FindBy(css = ".primary")
    private WebElement createButton;

    @FindBy(css = "[href='/computers']")
    private WebElement cancelbutton;



    public WebElement getInputError() {
        return inputError;
    }

    public WebElement getInputDateError() {
        return inputDateError;
    }

    @FindBy(css=".error > .input")
    private WebElement inputError;

    @FindBy(xpath = "//div[2]/div[@class='input']")
    private WebElement inputDateError;


    public WebElement getComputername() {
        return computername;
    }

    public WebElement getIntroducedDate() {
        return introducedDate;
    }

    public WebElement getDiscontinuedDate() {
        return discontinuedDate;
    }

    public WebElement getCompanyDropDown() {
        return companyDropDown;
    }

    public WebElement getCreateButton() {
        return createButton;
    }

    public WebElement getCancelbutton() {
        return cancelbutton;
    }

    public HomePage clickCancelButton(){
        clickButton(cancelbutton);
        return new HomePage(this.driver);
    }



    public void selectDropDown(int index){
        selectDropDown(getCompanyDropDown(),index);
    }


}
