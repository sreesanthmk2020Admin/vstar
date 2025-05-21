# import org.openqa.selenium.chrome.ChromeOptions
import com.kms.katalon.core.webui.driver.DriverFactory

ChromeOptions options = new ChromeOptions()
options.addArguments("--disable-notifications")

DriverFactory.changeWebDriver(new ChromeDriver(options)

Go to Project > Settings > Execution > Default > Web UI > Chrome.
	2.	Click Add and create the following key-value pair:
	•	Name: prefs
	•	Type: Dictionary
	•	Value: (click the ellipsis ... to open the dictionary editor)
Inside the dictionary editor, add:
Key
Type
Value
profile.default_content_setting_values.notifications
Number
2






