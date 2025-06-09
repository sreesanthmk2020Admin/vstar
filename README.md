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


import javax.naming.*;
import javax.naming.directory.*;
import java.util.Hashtable;

public class GetWindowsDisplayName {
    public static void main(String[] args) {
        String username = System.getProperty("user.name"); // e.g., jdoe

        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://your.domain.controller"); // Replace with your domain controller
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "your_domain\\" + username); // e.g., CORP\\jdoe
        env.put(Context.SECURITY_CREDENTIALS, "your_password"); // Ideally use a secure method

        try {
            DirContext ctx = new InitialDirContext(env);
            String searchFilter = "(&(objectClass=user)(sAMAccountName=" + username + "))";
            String[] attrIDs = { "displayName" };

            SearchControls ctls = new SearchControls();
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            ctls.setReturningAttributes(attrIDs);

            NamingEnumeration<SearchResult> answer = ctx.search("DC=your,DC=domain,DC=com", searchFilter, ctls);

            if (answer.hasMore()) {
                Attributes attrs = answer.next().getAttributes();
                System.out.println("Display Name: " + attrs.get("displayName").get());
            } else {
                System.out.println("User not found.");
            }
            ctx.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

Subject: Progress Update – Test Automation Maintenance Activity (Started 14th May)

Hi [Team/Recipient’s Name],

Please find below the progress update on the ongoing Test Automation Maintenance Activity, initiated on 14th May:
	•	Day 1–2: Identified and fixed impacted object locators due to the Siebel v25 upgrade.
	•	Day 3 onwards: Started executing automated test cases in batches to validate fixes and ensure suite stability.
	•	Last Week:
	•	Continued batch-wise execution and observed failures caused by hardcoded locators within test cases, instead of referencing a centralized object repository. These were systematically reviewed and corrected.
	•	Identified several older test cases that were missing object locators or had outdated code. In some instances, we found that steps critical to functional validation were already commented out, possibly due to past failures. These have been noted for correction and reactivation.
	•	As an interim measure, newly failing steps were temporarily commented to isolate and prioritize locator fixes without blocking overall progress.

We’re currently working on cleaning up such legacy test cases and restoring key validation points to maintain functional coverage. A progress tracker is being updated daily, and a dashboard view will be shared shortly.

Please let me know if you need additional details


Proposed Action Items
	1.	Centralize Locators
Refactor test cases to ensure all object locators are moved to and maintained in the shared object repository (OR) to avoid future locator inconsistencies.
	2.	Uncomment and Restore Functional Steps
Review all commented-out steps that are part of functional validation and reintroduce them after appropriate fixes, ensuring complete functional coverage.
	3.	Legacy Test Case Cleanup
Identify outdated or low-quality test cases and either update or deprecate them to improve maintainability and execution reliability.
	4.	Add Locator Validation Utility
Introduce a pre-run validation script to check if referenced locators are present and valid before execution begins, to fail fast and reduce debugging time.
	5.	Code Review and Approval Process
Establish a peer review process for any modifications made to test cases or locators to ensure standards and best practices are maintained.
	6.	BDD Framework Assessment
Explore transitioning to a BDD-based structure for long-term scalability, which allows execution to continue across scenarios even if one step fails.
	7.	Enhanced Logging and Reporting
Improve logging around locator failures and skipped/commented steps to enhance traceability and support faster resolution.
	8.	Weekly Sync with QA + Dev
Schedule a weekly QA-DEV sync meeting to align on locator naming conventions, upcoming UI changes, and any functional impact.

----------
Subject: API Test Closure Report – ReadyAPI Test Execution Summary

Dear Team,

Please find below the summary of the API test execution and closure details for the current cycle:

⸻

1. Execution Tool & Approach
	•	Test cases were executed manually using ReadyAPI.
	•	Initial plan is to validate APIs manually and later automate them using Katalon’s API testing framework.

2. Initial Issues Identified
	•	All test cases initially failed due to incorrect test data configurations, specifically the use of absolute file paths.
	•	Resolved by updating test files to use relative paths.

3. Subsequent Failures
	•	Some test cases continued to fail due to:
	•	Missing test data files
	•	Incorrect or inconsistent test data values

4. Environment Change
	•	Due to these issues, we shifted test execution to the Stage environment, which has more stable and aligned test data.

5. Future Plan
	•	Once manual validations are complete and stable, the test cases will be:
	•	Automated using Katalon
	•	Integrated with UI test flows, where APIs will set up the data for functional validations

-------

Subject: Request to Re-run Sequence Job for CSC VIP Checkbox Match-Merge Validation

Dear [Data Team / Recipient’s Name],

This is a follow-up on the previous request regarding the CSC VIP checkbox match-merge validation.

In the last execution, the required record was not included, which led to an undesired result. I have now completed the necessary data setup from my side.

Kindly re-run the sequence job and ensure that all steps as instructed by the development team are followed during execution.

Please keep me posted once the job is completed or if any clarification is needed.

Best regards,
[Your Name]
[Project / Team Name]
[Employee ID, if applicable]