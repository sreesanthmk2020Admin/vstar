package genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class PageUtils {

	private Action obj_Action = null;
	private WebDriverWait obj_WebDriverWait = null;
	public static Properties obj_Properties = null;
	
	public void exceptionHandler(Exception e) {
		System.out.println("DriverClass" + e.getMessage());
	}
	
	public void properyHandler() {
		try {
			obj_Properties = new Properties();
			obj_Properties.load(new FileInputStream(".\\config\\testRunConfig.properties"));
		} catch (Exception e) {
			exceptionHandler(e);
		}
	}
	
}
