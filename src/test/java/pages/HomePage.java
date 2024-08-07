package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    public HomePage() {
        driver= Driver.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@type='add']")
    public WebElement addUserButton;

    public String deleteButtonInRowXpath = "//i[@class='icon icon-remove']/..";
    public String smartTableXpath = "//table[@table-title='Smart Table example']";


    public List<WebElement> findRowElementsWithinSmartTable (String fName, String lName, String userName, String email, String pNumber){
        String dynamicXPath = smartTableXpath +
                "//*[text()='" +
                fName +
                "']/..//*[text()='" +
                lName +
                "']/..//*[text()='" +
                userName +
                "']/..//*[text()='" +
                email +
                "']/..//*[text()='" +
                pNumber +
                "']/..";

        return Driver.getInstance().getDriver().findElements(By.xpath(dynamicXPath));
    }

    public List<WebElement> findRowElementsWithinSmartTable (String userName, String email, String pNumber){
        String dynamicXPath = smartTableXpath +
                "//*[text()='" +
                userName +
                "']/..//*[text()='" +
                email +
                "']/..//*[text()='" +
                pNumber +
                "']/..";

        return Driver.getInstance().getDriver().findElements(By.xpath(dynamicXPath));
    }

    public List<WebElement> findRowElementsWithinSmartTable (String userName){
        String dynamicXPath = smartTableXpath +
                "//*[text()='" +
                userName +
                "']/..";

        return Driver.getInstance().getDriver().findElements(By.xpath(dynamicXPath));
    }

    public WebElement findDeleteButtonWithinSmartTable (String userName, String email, String pNumber){
        String dynamicXPath = smartTableXpath +
                "//*[text()='" +
                userName +
                "']/..//*[text()='" +
                email +
                "']/..//*[text()='" +
                pNumber +
                "']/.." + deleteButtonInRowXpath;

        return Driver.getInstance().getDriver().findElement(By.xpath(dynamicXPath));
    }

    public WebElement findDeleteButtonWithinSmartTable (String fName){
        String dynamicXPath = smartTableXpath +
                "//*[text()='" +
                fName +
                "']/.." + deleteButtonInRowXpath;

        return Driver.getInstance().getDriver().findElement(By.xpath(dynamicXPath));
    }
}
