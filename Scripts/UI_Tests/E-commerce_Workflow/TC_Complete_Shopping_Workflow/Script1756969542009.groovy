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
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Test Case: Complete E-commerce Workflow
WebUI.comment("Starting Complete Shopping Workflow Test")

try {
	// Step 1: Navigate and Login
	CustomKeywords.'common.CommonKeywords.navigateToApplication'(GlobalVariable.ApplicationURL)
	CustomKeywords.'common.CommonKeywords.performLogin'(GlobalVariable.ValidEmail, GlobalVariable.ValidPassword)
	
	// Step 2: Browse and Select Product
	WebUI.click(findTestObject('Pages/Home_Page/computers_category'))
	WebUI.waitForPageLoad(10)
	WebUI.click(findTestObject('Pages/Product_Page/first_product'))
	
	// Step 3: Add to Cart
	WebUI.setText(findTestObject('Pages/Product_Page/quantity_field'), '2')
	WebUI.click(findTestObject('Pages/Product_Page/add_to_cart_btn'))
	WebUI.waitForElementPresent(findTestObject('Pages/Product_Page/success_message'), 10)
	
	// Step 4: View Cart
	WebUI.click(findTestObject('Pages/Shopping_Cart/cart_link'))
	WebUI.verifyElementPresent(findTestObject('Pages/Shopping_Cart/checkout_button'), 10)
	
	// Step 5: Verify Cart Contents
	String cartQuantity = WebUI.getAttribute(findTestObject('Pages/Shopping_Cart/cart_quantity'), 'value')
	WebUI.verifyEqual(cartQuantity, '2')
	
	WebUI.comment("Shopping workflow completed successfully")
	
} catch (Exception e) {
	// Take screenshot on failure
	CustomKeywords.'common.CommonKeywords.takeScreenshotOnFailure'('Shopping_Workflow')
	WebUI.comment("Test failed: " + e.getMessage())
	throw e
} finally {
	WebUI.closeBrowser()
}
