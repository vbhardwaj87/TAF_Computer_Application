package Steps;

import Pages.AddComputerPage;
import Pages.EditComputerPage;
import Pages.HomePage;
import Support.ScenarioContext;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class EditComputerStepDef {

    WebDriver driver;
    ScenarioContext scenarioContext;
    private AddComputerPage addComputerPage;
    private HomePage homePage;
    private EditComputerPage editComputerPage;
    protected Faker faker = new Faker();
    private static final Logger logger = LogManager.getLogger();

    public EditComputerStepDef(BaseStepDef baseStepDef,ScenarioContext scenarioContext) {
        driver = baseStepDef.setupDriver();
        this.scenarioContext = baseStepDef.getScenarioContext();
        homePage = new HomePage(this.driver);
    }

    @And("^searches for existing saved computer$")
    public void searchesForExistingComputer() {
        homePage.getSearchtextbox().clear();
        homePage.getSearchtextbox().sendKeys(scenarioContext.getContext("ComputerName").toString());
        homePage.getSearchbutton().click();
        assertTrue(homePage.getSearchComputer().isDisplayed());
        editComputerPage = new EditComputerPage(this.driver);
        addComputerPage = new AddComputerPage(this.driver);
        editComputerPage.getcomputerNameLink(editComputerPage.getComputerNametable(),scenarioContext.getContext("ComputerName").toString()).click();

    }

    @And("details of saved computer are amended")
    public void detailsOfSavedComputerAreAmended() {
        String updated_name = faker.name().fullName();
        assertTrue(editComputerPage.getEdittext().isDisplayed());
        addComputerPage.getComputername().clear();
        addComputerPage.getComputername().sendKeys(updated_name);
        scenarioContext.setContext("ComputerName",updated_name);
        addComputerPage.getIntroducedDate().sendKeys("2019-08-22");
        addComputerPage.getDiscontinuedDate().sendKeys("2020-08-16");

    }

    @Then("updated details are saved in the application")
    public void updatedDetailsAreSavedInTheApplication() {
        addComputerPage.getCreateButton().click();
        assertTrue(homePage.getAlertMessage().isDisplayed());

    }


    @Then("selecting delete computer removes the computer from the application")
    public void computerIsDeletedFromTheApplication() {
        editComputerPage.getDeleteButton().click();
        assertTrue(homePage.getAlertMessage().isDisplayed());
        String deleted_message = homePage.getAlertMessage().getText();
        logger.info("Check that computer has been deleted.");
        assertTrue(deleted_message.contains("Done! Computer has been deleted"));
        homePage.getSearchtextbox().sendKeys(scenarioContext.getContext("ComputerName").toString());
        homePage.getSearchbutton().click();
        assertTrue(homePage.getNoSearchtext().isDisplayed());
    }

}
