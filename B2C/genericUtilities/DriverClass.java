package genericUtilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class DriverClass {

	public static WebDriver driver = null;
	
	public void initDriver() {
		try {
			switch (PageUtils.obj_Properties.get("browser").toString().toLowerCase()) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", ".\\config\\drivers\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.setPageLoadStrategy(PageLoadStrategy.NONE);
				 options.addArguments("start-maximized"); 
				    options.addArguments("enable-automation"); 
				    options.addArguments("--no-sandbox"); 
				    options.addArguments("--disable-infobars"); 
				    options.addArguments("--disable-dev-shm-usage"); 
				    options.addArguments("--disable-browser-side-navigation"); 
				    options.addArguments("--disable-gpu");
				driver = new ChromeDriver();
				break;

			default:
				break;
			}
		} catch (Exception e) {
			
		}
	}

	public void loadUrl() {
		try {
			driver.manage().deleteAllCookies();
			driver.get(PageUtils.obj_Properties.get("url").toString());
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Long.parseLong(PageUtils.obj_Properties.get("regularWait").toString()), TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			System.out.println("DriverClass" + e.getMessage());
		}
	}

}
