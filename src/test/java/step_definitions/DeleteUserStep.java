package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import pages.ConfirmationDialog;
import pages.HomePage;

public class DeleteUserStep {

    public static final Logger oLog = LogManager.getLogger(DeleteUserStep.class);

    HomePage homePage = new HomePage();
    ConfirmationDialog confirmationDialog = new ConfirmationDialog();

    @Then("User should be able to delete newly created user data with {string} , {string} , {string}")
    public void user_should_be_able_to_delete_newly_created_user_data_with(String userName, String email, String pNumber) {
        homePage.findDeleteButtonWithinSmartTable(userName, email, pNumber).click();
        confirmationDialog.okButton.click();
        boolean isDeletedUserAvailableInTable = homePage.findRowElementsWithinSmartTable(userName, email, pNumber).size() > 0;

        Assert.assertFalse("The newly deleted user with username " + userName  + " is still available in Smart table", isDeletedUserAvailableInTable);
    }

    @When("User should be able to see an existing user data with {string}")
    public void user_should_be_able_to_see_an_existing_user_data_with(String userName) {
        boolean isExistingUserAvailableInTable = homePage.findRowElementsWithinSmartTable(userName).size() > 0;
        Assert.assertTrue("The existing user with username " + userName  + " is not available in Smart table", isExistingUserAvailableInTable);
    }
    @Then("User should be able to see delete button for an existing user data with {string}")
    public void user_should_be_able_to_see_delete_button_for_an_existing_user_data_with(String userName) {
        boolean isDeleteBtnVisible = homePage.findDeleteButtonWithinSmartTable(userName).isDisplayed();
        Assert.assertTrue("Delete button for user " + userName + "  is not visible", isDeleteBtnVisible);
    }
    @And("User should be able to delete an existing user data with {string}")
    public void user_should_be_able_to_delete_an_existing_user_data_with(String userName) {
        homePage.findDeleteButtonWithinSmartTable(userName).click();
        confirmationDialog.okButton.click();
    }
    @Then("User should verify an existing user data with {string} is deleted")
    public void user_should_verify_an_existing_user_data_with_is_deleted(String userName) {
        boolean isDeletedUserAvailableInTable = homePage.findRowElementsWithinSmartTable(userName).size() > 0;

        Assert.assertFalse("The existing user with username " + userName  + " is still available in Smart table", isDeletedUserAvailableInTable);
        oLog.info("The existing user with username " + userName  + " is deleted successfully");
    }

}
