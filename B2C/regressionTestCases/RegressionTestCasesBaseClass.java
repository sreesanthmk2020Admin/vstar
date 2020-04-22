package regressionTestCases;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public abstract class RegressionTestCasesBaseClass {

	private genericUtilities.PageUtils obj_PageUtils = null;
	private genericUtilities.DriverClass obj_DriverClass = null;
	protected pageMethods.HomePageBaseClass obj_HomePage = null;
	
	@BeforeSuite
	protected void initSuite() {
		obj_PageUtils = new genericUtilities.PageUtils();
		obj_PageUtils.properyHandler();
		
		obj_DriverClass = new genericUtilities.DriverClass();
		obj_DriverClass.initDriver();
		
		obj_HomePage = new pageMethods.HomePageBaseClass();
	}

	@BeforeTest
	protected void initTest() {
		obj_DriverClass.loadUrl();
		obj_HomePage.closeNotification();
	}

	@BeforeClass
	protected void initClass() {

	}

	@BeforeMethod
	protected void initMethod() {

	}

	@AfterMethod
	protected void tearDownMethod(ITestResult result) {
		System.out.println(result.getStatus());
	}

	@AfterClass
	protected void tearDownClass() {

	}

	@AfterTest
	protected void tearDownTest() {
		genericUtilities.DriverClass.driver.close();
	}

	@AfterSuite
	protected void tearDownSuite() {
		genericUtilities.DriverClass.driver.quit();
	}

}
