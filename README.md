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




Subject: Action Required: Update of Impacted Object Locators in TST Environment

Hi Team,

As part of the Siebel upgrade from version 23 to 25, we have identified around 250 impacted object locators across various modules. These updates are required due to changes in applet names (e.g., "Search Applet" is now "Search"), which are affecting automation execution in the TST environment.

To streamline the update process, the impacted objects have been divided among the three of you as per the allocation below.
For tracking purposes, please populate the attached sheet with the updated status once you complete each item.

Allocation:
	•	[Member 1] – Module A, B
	•	[Member 2] – Module C, D
	•	[Member 3] – Module E, F

Please ensure the object locators are updated and corresponding test cases are passing in the TST environment. Let me know if you face any blockers.

CC: [Manager’s Name]
Attachment: Impacted_Object_Locators.xlsx

Best regards,
[Your Name]
Test Lead | SLK Group



ual fun, I’m putting together a small snacks party in the cafeteria. Would love for you all to join, chill for a bit, and grab a bite!

📅 Date: [Insert Date]
🕒 Time: [Insert Time]
📍 Place: Cafeteria

Hope to see you there! 😄




🧾 Definition of Done (DoD)
	1.	All impacted object locators (identified from Siebel v25 upgrade) are updated and committed to the automation framework.
	2.	Automated test cases are updated, rerun, and passing in the test environment.
	3.	A daily progress tracker is maintained and shared with stakeholders.
	4.	A burndown chart is created to track locator fixes and test execution completion.
	5.	All failures (if any) are triaged, root-caused, and corresponding tickets are raised or resolved.
	6.	Regression suite is executed successfully in the Test and UAT environments.
	7.	Final sign-off mail/document is shared with stakeholders.


#
Acceptance Criteria
1
All 350 impacted locators are identified, updated, and validated.
2
244 automated test cases are updated and executed.
3
Daily tracker is populated with fix status and test execution results.
4
A dashboard with locator fix and execution burndown is available and updated daily.
5
All test cases that fail due to locator issues are fixed and retested.
6
No high-severity issues remain open before regression sign-off.
7
The updated test suite passes with ≥95% success rate in UAT.
8
Sign-off email or report is sent to the client/stakeholders.





