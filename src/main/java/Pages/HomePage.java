package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class HomePage extends BasePage {
    //This is the Page class for the Homepage//

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="body > header > h1 > a")
    private WebElement homepagelink;

    @FindBy(css=" #main > h1")
    private WebElement computersCount;

    @FindBy(xpath = "//div[@class='alert-message warning']")
    private WebElement alertMessage;

    @FindBy(xpath = "//em[.='Nothing to display']")
    private WebElement NoSearchtext;

    @FindBy(css = "#searchbox")
    private WebElement searchtextbox;

    @FindBy(css = "#searchsubmit")
    private WebElement searchbutton;

    @FindBy(css = ".next > a")
    private WebElement nextbutton;

    @FindBy(css=".prev > a")
    private WebElement previousButton;

    @FindBy(css = "[href='/computers']")
    private WebElement computersTable;

    @FindBy(css = ".current > a")
    private WebElement pageText;

    @FindBy(css="#pagination > ul > li.current > a")
    private WebElement paginationCount;

    public WebElement getSearchComputer() {
        return searchComputer;
    }

    @FindBy(xpath = "//h1[.='One computer found']")
    private WebElement searchComputer;

    @FindBy(css = ".computers")
    private WebElement computerDetailsTable;

    public List<WebElement> getTableElements() {
        return tableElements;
    }

    @FindBys(@FindBy(xpath = "//tbody[1]/tr/td[1]"))
    private List<WebElement> tableElements;


    @FindBys(@FindBy(css = "#main > table > thead > tr >th"))
    private List<WebElement> tableHeadings;


    @FindBy(xpath = "//a[.='Computer name']")
    private WebElement computerNameHeading;

    @FindBy(css = "#add")
    private WebElement addButton;

    public List<WebElement> getTableHeadings() {
        return tableHeadings;
    }

    public WebElement getNoSearchtext() {
        return NoSearchtext;
    }

    public WebElement getAlertMessage() {
        return alertMessage;
    }

    public WebElement getAddButton() {
        return addButton;
    }

    public WebElement getComputerNameHeading() {
        return computerNameHeading;
    }


    public WebElement getHomepagelink() {
        return homepagelink;
    }

    public WebElement getSearchtextbox() {
        return searchtextbox;
    }

    public WebElement getSearchbutton() {
        return searchbutton;
    }

    public WebElement getNextbutton() {
        return nextbutton;
    }

    public WebElement getPreviousButton() {
        return previousButton;
    }

    public WebElement getComputersTable() {
        return computersTable;
    }

    public WebElement getComputerDetailsTable() {
        return computerDetailsTable;
    }

    public WebElement getPageText() {
        return pageText;
    }

    public WebElement AddButton() {
        return addButton;
    }

    public WebElement getComputersCount() {
        return computersCount;
    }

    public WebElement getPaginationCount() {
        return paginationCount;
    }



}
