psee# import org.openqa.selenium.chrome.ChromeOptions
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
1. Create the SOAP Request Object

Steps:
	1.	Go to Object Repository → New → Web Service Request
	2.	Set:
	•	Request Type: SOAP
	•	WSDL URL: (your service WSDL)
	3.	Click Load WSDL, pick the operation (e.g., getCustomerDetails)
	4.	Katalon auto-generates the XML SOAP envelope
	5.	Set any dynamic values using ${variable} syntax
	6.	Save it under:
Object Repository/API/SOAP/getCustomerDetails

Feature: Get Customer Details via SOAP

  Scenario: Get details of a valid customer
    Given I prepare the SOAP request for valid customer ID
    When I send the SOAP request
    Then I should receive a 200 response
    And the response should contain the customer name

package stepdefinitions

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import internal.GlobalVariable
import io.cucumber.java.en.*
import com.kms.katalon.core.util.KeywordUtil
import groovy.xml.XmlSlurper

class GetCustomerSteps {

    def response

    @Given("I prepare the SOAP request for valid customer ID")
    def prepareSOAPRequest() {
        // You can pass test data via variable substitution here if needed
        GlobalVariable.soapRequest = findTestObject('API/SOAP/getCustomerDetails')
        KeywordUtil.logInfo("SOAP request prepared")
    }

    @When("I send the SOAP request")
    def sendSOAPRequest() {
        response = WS.sendRequest(GlobalVariable.soapRequest)
        KeywordUtil.logInfo("SOAP request sent")
    }

    @Then("I should receive a 200 response")
    def verifyStatusCode() {
        WS.verifyResponseStatusCode(response, 200)
        KeywordUtil.logInfo("Received HTTP 200 OK")
    }

    @And("the response should contain the customer name")
    def verifyCustomerName() {
        def parsed = new XmlSlurper().parseText(response.getResponseBodyContent())
        def customerName = parsed.'**'.find { it.name() == 'CustomerName' }?.text()
        assert customerName != null && customerName != ""
        KeywordUtil.logInfo("Customer Name from response: " + customerName)
    }

========######======
Subject: Dropdown Validation Scope & Discussion on Findings

Hi [Architect’s Name] / Team,

Following our call, I’d like to summarize the dropdown validation scope and next steps:
	•	Current validation results are as expected.
	•	Fields to be reconsidered: Product, Service (dependent on Product), Issue (dependent on Service).
	•	Actions and Segmentation dropdowns are out of scope for now.
	•	LOVs for Product, Service, and Issue will be validated during new Service Request creation, considering hierarchical dependencies.

I am available tomorrow right after the stand-up to review the findings, validation details, and supporting reports with stakeholders. Please confirm if this time works or suggest an alternate slot.

Discussion Agenda:
	1.	Validation scope & approach
	2.	Key observations & deviations
	3.	Next steps and defect logging (if required)

Best regards,
[Your Name]
QA Automation Team



 [Architect’s Name] / Team,

Following our discussion over the call, I would like to formally summarize the agreed scope and next steps for the dropdown value and sorting validation:
	•	The current validation results are as expected.
	•	The fields identified for reconsideration and detailed validation are:
	•	Product
	•	Service (dependent on Product selection)
	•	Issue (dependent on Service selection)
	•	The Actions and Segmentation dropdowns are not part of the current scope and will be excluded from this validation cycle.
	•	The List of Values (LOV) for Product, Service, and Issue will be validated during new Service Request creation, ensuring proper handling of their hierarchical dependencies.

I have captured the observations and findings as part of this analysis, and I would like to discuss them further with the stakeholders for alignment and next steps.

I’ll be available tomorrow right after the stand-up to walk through the findings, validation details, and supporting reports. Please let me know if this time works for everyone, or if you’d prefer an alternate slot.

Proposed Discussion Agenda:
	1.	Summary of dropdown validation scope and methodology
	2.	Key observations and deviations from expected behavior
	3.	Next steps, defect logging (if required), and stakeholder alignment

Best regards,
[Your Name]
QA Automation Team

--------

Regression Testing – Initial Coverage

1. Purpose

This page captures the initial regression coverage for [Project Name], focusing on LOV validations and UI checklist / visual verification. It serves as a starting point for building the full regression suite.

⸻

2. LOV (List of Values) Validation

Scope:
	•	Validating value availability and alphabetical sorting for hierarchical dropdowns:
	•	Product → determines available Services
	•	Service → determines available Issues
	•	Issue → dependent on Service selection

Validation Approach:
	1.	Verify that all expected values from the test data sheet are available in the dropdown.
	2.	Check that dropdown options are sorted alphabetically.
	3.	Capture screenshots and execution reports for reference.
	4.	Apply the same check for additional LOVs on the screen for extended coverage.

Vault Mapping:
	•	Included in regression under Golden Legacy Vault for existing validations.

Attachments:
	•	Test data sheet
	•	Katalon execution reports

⸻

3. UI Checklist / Visual Verification

Scope:
	•	Verify table column headers, page elements, and key navigation components.
	•	Checklist will grow based on new requirements or release changes.

Validation Approach:
	1.	Identify critical UI elements to validate per screen.
	2.	Confirm presence, labels, and alignment of headers and elements.
	3.	Capture screenshots for failed or missing elements.
	4.	Track all validated elements in the regression suite under UI Visual Vault.

Vault Mapping:
	•	UI-related verifications stored under UI Visual Vault in regression repository.

Attachments:
	•	Execution reports with screenshots


