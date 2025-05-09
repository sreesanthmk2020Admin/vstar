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


Test Failures Due to Environment Switch – Fix Estimation

Dear Stakeholders,

The existing automation test cases were originally designed to run against the Stage environment, with data and object locators tailored accordingly. Upon executing the same suite in the Test environment as requested, we have encountered several test failures due to environment-specific differences.




We are currently analyzing the failures and estimating approximately [insert estimated time, e.g., 2–3 working days] to refactor the scripts and resolve the issues for Test environment compatibility.

I will keep you updated on the progress and inform you once the suite is stable and ready for execution in Test.ur updates. QA team, let’s begin with you.”



 Request to Configure Users in Test Environment

Dear [Configuration Team],

I have a list of users currently available in the Stage environment that need to be configured in the Test environment as well. I have noticed that a few of these user IDs already exist in Test.

Kindly review the attached list and proceed with configuring the remaining users in the Test environment. Please let me know if any additional details are needed from my side.

Best regards,
[Your Name]
Test Lead | SLK Group
