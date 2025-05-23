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


Request to Re-run Sequence Job for CSC VIP Checkbox Match-Merge Validation

Hi [Data Team/Name],

Hope you’re doing well.

Following the last run, we observed that the data was reloaded by the team; however, the match-merge scenario for the CSC VIP checkbox did not produce the desired outcome. Ideally, we should have followed the specific steps outlined by the DEV team to ensure accurate validation.

Could you please re-run the sequence job, this time aligning with the recommended DEV steps, so we can properly validate the scenario?

Appreciate your support and let me know once it’s triggered.



