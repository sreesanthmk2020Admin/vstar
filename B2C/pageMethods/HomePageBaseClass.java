package pageMethods;

import org.openqa.selenium.interactions.Actions;

public final class HomePageBaseClass extends pageObjects.HomePageBaseClass{

	private boolean actualResult = false;
	
	public void closeNotification() {
		try {
		if(btn_CloseNotification.isDisplayed())
			btn_CloseNotification.click();
		} catch (Exception e) {
			
		}
	}
	
	public boolean selectSection(String parentSectionName, String childSectionName) {
		actualResult = false;
		
		try {
			Actions action = new Actions(driver);
			action.moveToElement(lbl_ParentSectionName(parentSectionName)).build().perform();
			lbl_childSectionName(parentSectionName, childSectionName).click();
			
			actualResult = lbl_pageHeader.getText().equalsIgnoreCase(childSectionName);
		} catch (Exception e) {
			System.out.println("HomePage" + e.getMessage());
		}
		return actualResult;
	}
	
}
