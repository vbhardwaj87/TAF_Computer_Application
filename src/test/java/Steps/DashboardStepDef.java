package Steps;

import Pages.HomePage;
import Support.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class DashboardStepDef {
    WebDriver driver;
    ScenarioContext scenarioContext;
    private HomePage homePage;
    private static final Logger logger = LogManager.getLogger();


    public DashboardStepDef(BaseStepDef baseStepDef,ScenarioContext scenarioContext) {
        driver = baseStepDef.setupDriver();
        this.scenarioContext = baseStepDef.getScenarioContext();
        homePage = new HomePage(this.driver);
    }

    @And("^(.*) is displayed on the dashboard$")
    public void linkDisplayedOnDashboard(String link){

        assertTrue(link.contains(homePage.getHomepagelink().getText()));

    }

    @Then("^buttons to add the computer is displayed$")
    public void buttonsToAddComputer(){
        assertTrue(homePage.getSearchbutton().isDisplayed());
        assertTrue(homePage.getAddButton().isDisplayed());
    }


    @And("^computers table is displayed with the columns$")
    public void computerTableisDisplayed(){

        assertTrue(homePage.getComputerDetailsTable().isDisplayed());
    }

    @Then("^previous and next button are displayed for navigation$")
    public void paginationButtons(){

        assertTrue(homePage.getNextbutton().isDisplayed());
        homePage.getNextbutton().click();
        Assert.assertEquals(homePage.getPreviousButton().isDisplayed(), true);
        homePage.getPreviousButton().click();

    }

    @Then("^table is sorted by descending when computer name heading is clicked$")
    public void checkTableSorting(){
        //Get the webtable data

        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> tabledata= homePage.getTableElements();
        for(WebElement we:tabledata){
            obtainedList.add(we.getText());
        }
        obtainedList.forEach(System.out::println);
        homePage.getComputerNameHeading().click();

        //Get the data after clicking on the computer name heading
        ArrayList<String> sortedList = new ArrayList<>();
        List<WebElement> sortedTable = homePage.getTableElements();
        for(WebElement we:sortedTable){
            sortedList.add(we.getText());
        }
        //Sorting the obtained list in descending order
        Collections.reverse(sortedList);
        sortedList.forEach(System.out::println);
        logger.info("Comparing the Sorting on the Lists");
        Assert.assertEquals(sortedList, obtainedList);
    }

    @Then("^four columns are displayed in the table header$")
    public void checkColumnHeadings(){
        List<WebElement> heading_list = homePage.getTableHeadings();
        Assert.assertEquals(heading_list.size(),4);
        logger.info("List of headings in the computer table");
        for(WebElement webElement:heading_list){

            logger.info(webElement.getText());
        }
    }

    @Then("^count of computers matches with the pagination$")
    public void computersCountValidation(){
        String count_header= homePage.getComputersCount().getText().replaceAll("\\D+","");
        String count_pagination[] = homePage.getPaginationCount().getText().split(" ");
        Assert.assertEquals(count_header, count_pagination[5]);

    }

}
