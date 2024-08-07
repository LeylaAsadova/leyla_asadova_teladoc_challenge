package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.AddUserModal;
import pages.ConfirmationDialog;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class AddUserStep {


    public static final Logger oLog = LogManager.getLogger(AddUserStep.class);

    HomePage homePage = new HomePage();
    AddUserModal addUserModal = new AddUserModal();
    ConfirmationDialog confirmationDialog = new ConfirmationDialog();

    @Given("User navigates to way2automation website")
    public void user_navigates_to_way2automation_website() {
        Driver.getInstance().getDriver().get(ConfigurationReader.getProperty("way2automation.url"));
        oLog.info("User navigated to way2automation website");

    }
    @Then("User should be able to see Add User button")
    public void user_should_be_able_to_see_add_user_button() {
        boolean isAddUserBtnVisible = homePage.addUserButton.isDisplayed();
        Assert.assertTrue("Add User button is not visible", isAddUserBtnVisible);

    }
    @Then("Add User button should be enabled")
    public void add_user_button_should_be_enabled() {
        boolean isAddUserBtnEnabled = homePage.addUserButton.isEnabled();
        Assert.assertTrue("Add User button is not enabled", isAddUserBtnEnabled);
    }
    @When("User clicks Add User button")
    public void user_clicks_add_user_button() {
        homePage.addUserButton.click();
    }
    @Then("User enters first name as {string}")
    public void user_enters_first_name_as(String fName) {
        addUserModal.fNameTxtBox.sendKeys(fName);
    }
    @Then("User enters last name as {string}")
    public void user_enters_last_name_as(String lName) {
        addUserModal.lNameTxtBox.sendKeys(lName);
    }
    @Then("User enters user name as {string}")
    public void user_enters_user_name_as(String userName) {
        addUserModal.userNameTxtBox.sendKeys(userName);;
    }
    @Then("User enters password as {string}")
    public void user_enters_password_as(String pwd) {
        addUserModal.pwdTxtBox.sendKeys(pwd);
    }
    @Then("User choose Company name as {string}")
    public void user_choose_company_name_as(String company) {
        if (company.equals("AAA")) {
            addUserModal.companyAAA.click();
        } else {
            addUserModal.companyBBB.click();
        }
    }
    @Then("User selects role as {string}")
    public void user_selects_role_as(String role) {
        Select select = new Select(addUserModal.roleDropDown);
        select.selectByVisibleText(role);
    }
    @Then("User enters email as {string}")
    public void user_enters_email_as(String email) {
        addUserModal.emailTxtBox.sendKeys(email);
    }
    @Then("User enters phone number as {string}")
    public void user_enters_phone_number_as(String phoneNumber) {
        addUserModal.phoneNumberTxtBox.sendKeys(phoneNumber);
    }
    @Then("User clicks the save button")
    public void user_clicks_the_save_button() {
        addUserModal.saveButton.click();
    }
    @Then("User should be able to see a newly created user data with {string} , {string} , {string} , {string} , {string}")
    public void user_should_be_able_to_see_a_newly_created_user_data_with(String fName, String lName, String userName, String email, String pNumber) {
        boolean isNewUserAvailableInTable = homePage.findRowElementsWithinSmartTable(fName, lName, userName, email, pNumber).size() > 0;

        Assert.assertTrue("The newly created user with username " + userName  + " is not available in Smart table", isNewUserAvailableInTable);

    }
}
