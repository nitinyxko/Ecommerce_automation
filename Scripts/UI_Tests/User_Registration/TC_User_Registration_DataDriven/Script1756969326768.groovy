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

// Test Case: User Registration with Multiple Data Sets
WebUI.comment("Starting Data-Driven User Registration Test")

// Navigate to application
CustomKeywords.'common.CommonKeywords.navigateToApplication'(GlobalVariable.ApplicationURL)

// Get registration test data
def testData = findTestData('UserRegistrationData')

// Register multiple users
for (int row = 1; row <= testData.getRowNumbers(); row++) {
	String firstName = testData.getValue('firstname', row)
	String lastName = testData.getValue('lastname', row)
	String email = testData.getValue('email', row)
	String password = testData.getValue('password', row)
	
	WebUI.comment("Registering user: " + firstName + " " + lastName)
	
	// Perform registration
	boolean registrationResult = CustomKeywords.'common.UserManagementKeywords.registerNewUser'(
		firstName, lastName, email, password
	)
	
	if (registrationResult) {
		// Validate success
		boolean isSuccess = CustomKeywords.'common.UserManagementKeywords.validateRegistrationSuccess'()
		WebUI.verifyTrue(isSuccess)
		WebUI.comment("User " + email + " registered successfully")
	}
	
	// Navigate back for next user
	WebUI.navigateToUrl(GlobalVariable.ApplicationURL)
}

WebUI.closeBrowser()
