import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Test Case: Invalid Login with Data-Driven Approach
WebUI.comment("Starting Invalid Login Test with Test Data")

// Navigate to application
CustomKeywords.'common.CommonKeywords.navigateToApplication'(GlobalVariable.ApplicationURL)

// Get test data
def testData = findTestData('LoginTestData')

// Loop through test data
for (int row = 1; row <= testData.getRowNumbers(); row++) {
	String email = testData.getValue('email', row)
	String password = testData.getValue('password', row)
	String expectedResult = testData.getValue('expected_result', row)
	
	WebUI.comment("Testing with email: " + email + " and password: " + password)
	
	// Perform login
	boolean loginResult = CustomKeywords.'common.CommonKeywords.performLogin'(email, password)
	
	if (expectedResult == 'failure') {
		// Verify error message appears
		WebUI.verifyElementPresent(findTestObject('Pages/Login_Page/error_message'), 5)
		WebUI.comment("Expected failure scenario validated")
	}
	
	// Reset for next iteration
	WebUI.navigateToUrl(GlobalVariable.ApplicationURL)
}

WebUI.closeBrowser()
