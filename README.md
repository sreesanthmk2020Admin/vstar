Quick overview (high level)
	1.	Create / parameterize a RESTful Web Service Request in Object Repository.
	2.	Create Test Data / Profiles for input values.
	3.	Create a Test Case (or BDD feature + step defs) that:
	•	Sends the POST request.
	•	Verifies HTTP status + response body.
	•	Captures any returned identifier needed for UI verification.
	•	Performs any required wait/retry until backend state reaches UI.
	•	Opens the UI, navigates to the relevant screen and verifies UI changes.
	•	Cleans up if needed.
	4.	Add the Test Case to appropriate vault/suite and attach reports/screenshots.

⸻

Detailed step-by-step

1) Prepare test data & environment
	•	Add required API URLs and credentials to Profiles (e.g., Profiles/default):
	•	GlobalVariable.BaseURL
	•	GlobalVariable.ApiAuthToken (or username/password)
	•	GlobalVariable.TestAccountId (if applicable)
	•	If you have a test-data spreadsheet, add it under Data Files/ and map to the test.

⸻

2) Create REST POST request object in Object Repository → Web Service Request
	1.	Right-click → New → Web Service Request.
	2.	Name it something meaningful, e.g. API/ServiceRequests/CreateServiceRequest.
	3.	Type: REST, Method: POST.
	4.	URL: ${GlobalVariable.BaseURL}/service-requests (or full path)
	5.	Headers: Content-Type: application/json, Authorization: Bearer ${GlobalVariable.ApiAuthToken} (or set auth in request)
	6.	Body (use variables for dynamic values):

{
  "customerId": "${customerId}",
  "product": "${product}",
  "service": "${service}",
  "issue": "${issue}",
  "description": "${description}"
}

7.	Save. Katalon will allow you to define variables (customerId, product, … ) for the request.

⸻

3) Create / update Test Object variables (if needed)
	•	In the request object, define default values or leave them blank so you can pass runtime values from your test script.

⸻

4) Create the Test Case (Groovy) — API + UI flow

Create a new test case Test Cases/API_UI/CreateSR_and_VerifyUI and paste the flow below, adapted to your object names.

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.TestObject
import groovy.json.JsonSlurper
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// 0. Test data (can be from GlobalVariable or Data File)
String customerId = GlobalVariable.TestCustomerId ?: '12345'
String product = 'ProductX'
String service = 'ServiceY'
String issue = 'IssueZ'
String description = 'Created by automation at ' + new Date().toString()

// 1. Prepare request object with runtime variables
TestObject createReq = findTestObject('API/ServiceRequests/CreateServiceRequest',
    [('customerId'): customerId,
     ('product'): product,
     ('service'): service,
     ('issue'): issue,
     ('description'): description])

// 2. Send POST request
def response = WS.sendRequest(createReq)

// 3. Verify HTTP status and basic response fields
WS.verifyResponseStatusCode(response, 201)  // or 200 depending on API contract
KeywordUtil.logInfo("API Response: " + response.getResponseBodyContent())

def json = new JsonSlurper().parseText(response.getResponseBodyContent())
// example: assume response contains srId
assert json.srId != null
String srId = json.srId.toString()
KeywordUtil.logInfo("Created SR ID: " + srId)

// 4. Optional: wait/poll backend until SR is in expected state (if eventual consistency)
int retry = 0
int maxRetries = 10
int waitSec = 3
boolean foundInBackend = false

while (retry < maxRetries) {
    // call GET API or database check to confirm SR is created/processed
    def getReq = findTestObject('API/ServiceRequests/GetServiceRequest', [('srId'): srId])
    def getResp = WS.sendRequest(getReq)
    if (getResp && getResp.getStatusCode() == 200) {
        def getJson = new JsonSlurper().parseText(getResp.getResponseBodyContent())
        if (getJson.status == 'CREATED' || getJson.status == 'OPEN') {
            foundInBackend = true
            break
        }
    }
    WebUI.delay(waitSec)
    retry++
}
assert foundInBackend : "Service Request not ready in backend within timeout"

// 5. Open UI and navigate to screen that shows the SR or where changes reflect
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl(GlobalVariable.UI_BaseURL + '/service-requests') // update to actual path

// 6. If the UI lists SRs, you may need to search by srId or customerId
// Example: enter search and click search
WebUI.setText(findTestObject('Page_SR/Search_Input'), srId)
WebUI.click(findTestObject('Page_SR/Search_Button'))
WebUI.waitForElementPresent(findTestObject('Page_SR/SR_Row_By_Id', [('srId'): srId]), 10)

// 7. Verify UI elements and values (exact locators depend on your app)
WebUI.verifyElementText(findTestObject('Page_SR/SR_Row_Product', [('srId'): srId]), product)
WebUI.verifyElementText(findTestObject('Page_SR/SR_Row_Service', [('srId'): srId]), service)
WebUI.verifyElementText(findTestObject('Page_SR/SR_Row_Issue', [('srId'): srId]), issue)

// 8. Take screenshot for evidence
WebUI.takeScreenshot(('Screenshots/SR_' + srId + '.png'))

// 9. Close browser
WebUI.closeBrowser()

Notes on the snippet:
	•	findTestObject('path', [('var'): value]) is used to pass variables to API or UI test objects.
	•	Adjust status codes (201/200) to what your API actually returns.
	•	Include polling if the UI is updated asynchronously (common in enterprise apps).

⸻

5) BDD option (feature + step defs)

If you prefer BDD, create a .feature:

Include/features/create_sr.feature

Feature: Create Service Request and verify UI

  Scenario: Create SR via API and confirm in UI
    Given I prepare request payload for product "ProductX", service "ServiceY", issue "IssueZ"
    When I submit the create SR POST API
    Then API should respond with code 201 and return srId
    And SR should be visible in UI with matching product, service and issue

katalonc.exe -noSplash -runMode=console -projectPath="C:\projects\katalon\myproject.prj" -testSuitePath="Test Suites/Release_25.4_API_UI_Smoke" -executionProfile="default" -browserType="Chrome"