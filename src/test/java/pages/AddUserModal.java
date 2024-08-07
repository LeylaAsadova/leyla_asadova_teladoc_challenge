package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AddUserModal {
    private WebDriver driver;

    public AddUserModal() {
        driver= Driver.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "FirstName")
    public WebElement fNameTxtBox;

    @FindBy(name = "LastName")
    public WebElement lNameTxtBox;

    @FindBy(name = "UserName")
    public WebElement userNameTxtBox;

    @FindBy(name = "Password")
    public WebElement pwdTxtBox;

    @FindBy(xpath = "//label[text() = 'Company AAA']/input")
    public WebElement companyAAA;

    @FindBy(xpath = "//label[text() = 'Company BBB']/input")
    public WebElement companyBBB;

    @FindBy(name = "RoleId")
    public WebElement roleDropDown;

    @FindBy(name = "Email")
    public WebElement emailTxtBox;

    @FindBy(name = "Mobilephone")
    public WebElement phoneNumberTxtBox;

    @FindBy(xpath = "//button[text() = 'Save']")
    public WebElement saveButton;
}
