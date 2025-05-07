# import org.openqa.selenium.chrome.ChromeOptions
import com.kms.katalon.core.webui.driver.DriverFactory

ChromeOptions options = new ChromeOptions()
options.addArguments("--disable-notifications")

DriverFactory.changeWebDriver(new ChromeDriver(options))


Step-by-Step: Disable Browser Notification Popup in Chrome
	1.	Open your Katalon project.
	2.	Go to Project > Settings > Execution > Default > Web UI > Chrome.
	3.	Click the ‘Add’ button to add a desired capability:
	•	Name: args
	•	Type: List
	•	Value: --disable-notifications
	4.	Save the settings.

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



