package Steps;

import Pages.AddComputerPage;
import Pages.EditComputerPage;
import Pages.HomePage;
import Support.ScenarioContext;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;


public class AddComputerStepDef {
    WebDriver driver;
    ScenarioContext scenarioContext;

    private AddComputerPage addComputerPage;
    private HomePage homePage;
    private EditComputerPage editComputerPage;
    protected Faker faker = new Faker();
    private static final Logger logger = LogManager.getLogger(AddComputerStepDef.class.getName());

    public AddComputerStepDef(BaseStepDef baseStepDef, ScenarioContext scenarioContext) {
        driver = baseStepDef.setupDriver();
        this.scenarioContext = baseStepDef.getScenarioContext();
        homePage = new HomePage(this.driver);
    }


    @Given("^user is on the homepage of computer database application$")
    public void userIsOnTheHomePage() throws Exception {
        System.out.println(org.apache.logging.log4j.Logger.class.getResource("/log4j2-test.xml"));
        assertTrue(driver.getTitle().contains("Computers"));
    }

    @And("^selects add computer$")
    public void selectsAddComputer() throws Exception {
        addComputerPage = new AddComputerPage(this.driver);
        homePage.AddButton().click();
        assertTrue(driver.findElement(By.cssSelector("#main > h1")).isDisplayed());


    }

    @When("^computer is added without the name$")
    public void computerIsAddedWithoutTheName() throws Exception {
        assertTrue(addComputerPage.getComputername().isDisplayed());
        addComputerPage.getCreateButton().click();


    }

    @Then("computer name is highlighted as mandatory")
    public void computerNameIsHighlightedAsMandatory() throws Exception {

        assertTrue(addComputerPage.getInputError().isDisplayed());

    }

    @When("alphanumeric characters are entered in the Date")
    public void alphanumericCharactersAreEnteredInTheDate() throws Exception {
        addComputerPage.getIntroducedDate().sendKeys(faker.name().username());


    }

    @Then("date fields are shown highlighted")
    public void dateFieldsAreShownHighlighted() throws Exception {
        addComputerPage.getCreateButton().click();
        assertTrue(addComputerPage.getInputDateError().isDisplayed());

    }

    @And("^computer is added with only name$")
    public void onlyComputerNameIsProvided() throws Exception {
        String computerName = faker.name().fullName();
        addComputerPage.getComputername().sendKeys(computerName);
        scenarioContext.setContext("ComputerName", computerName);
        addComputerPage.getCreateButton().click();
        System.out.println("Computer name created is:" + scenarioContext.getContext("ComputerName").toString());
        String success_message = homePage.getAlertMessage().getText();
//        System.out.println(success_message);
        logger.info(success_message);
        assertTrue(success_message.contains(computerName+" has been created"));
    }

    @Then("computer is added to the database")
    public void computerIsAddedToTheDatabase() throws Exception {
        homePage.getSearchtextbox().clear();
        homePage.getSearchtextbox().sendKeys(scenarioContext.getContext("ComputerName").toString());
        homePage.getSearchbutton().click();
        assertTrue(homePage.getSearchComputer().isDisplayed());

    }

    @And("computer name is provided with the introduced and discontinued date")
    public void computerNameIsProvidedWithTheIntroducedAndDiscontinuedDate() throws Exception {
        String computerName = faker.name().firstName();
        scenarioContext.setContext("computerName", computerName);
        addComputerPage.getComputername().sendKeys(computerName);
        addComputerPage.getIntroducedDate().sendKeys("2019-08-02");
        addComputerPage.getDiscontinuedDate().sendKeys("2020-08-01");
//        System.out.println("Second computer added is --" + computerName);
        logger.info("Second computer added is --" + computerName);
    }

    @Then("^date field are shown highlighted$")
    public void DateFieldsHighlighted() throws Exception {
        addComputerPage.getIntroducedDate().sendKeys("Test Date");
        addComputerPage.getCreateButton().click();
        assertTrue(addComputerPage.getInputDateError().isDisplayed());

    }

    @And("company name is selected")
    public void companyNameIsSelected() {
        addComputerPage.selectDropDown(4);
        addComputerPage.getCreateButton().click();
    }


    @Then("computer is added to the database with the details provided")
    public void computerIsAddedToTheDatabaseWithTheDetailsProvided() {
        String success_message = homePage.getAlertMessage().getText();
        assertTrue(success_message.contains((scenarioContext.getContext("computerName").toString())+" has been created"));
    }

    @And("^selects cancel button$")
    public void clickCancelButton(){
        assertTrue(addComputerPage.getCancelbutton().isDisplayed());
        homePage=addComputerPage.clickCancelButton();

    }

    @Then("^user is taken to the Homepage$")
    public void userTakenToHomepage(){

        assertTrue(homePage.getHomepagelink().isDisplayed());

    }



}