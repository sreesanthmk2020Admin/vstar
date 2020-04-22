package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.DriverClass;

public abstract class HomePageBaseClass {
	protected WebDriver driver = DriverClass.driver;
			
	public HomePageBaseClass() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CSS, using = "div[id*='WebNotificationContainer']>a")
	protected WebElement btn_CloseNotification;

	@FindBy(how = How.TAG_NAME, using = "h1")
	protected WebElement lbl_pageHeader;
	
	protected WebElement lbl_ParentSectionName(String ParentSectionName) throws Exception {
		return driver.findElement(By.xpath("//span[text()='" + ParentSectionName + "']"));
	}

	protected WebElement lbl_childSectionName(String ParentSectionName, String childSectionName) throws Exception {
		return driver.findElement(By.xpath("//li[a[span[text()='" + ParentSectionName + "']]]//a[contains(text(),'" + childSectionName + "')]"));
	}

}
