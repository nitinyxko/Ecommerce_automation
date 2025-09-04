package common

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows


public class CommonKeywords {
	
	@Keyword
	def navigateToApplication(String url) {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(url)
		WebUI.waitForPageLoad(30)
	}
	
	@Keyword
	def performLogin(String email, String password) {
		try {
			WebUI.click(findTestObject('Pages/Login_Page/login_link'))
			WebUI.waitForElementPresent(findTestObject('Pages/Login_Page/email_field'), 10)
			WebUI.setText(findTestObject('Pages/Login_Page/email_field'), email)
			WebUI.setEncryptedText(findTestObject('Pages/Login_Page/password_field'), password)
			WebUI.click(findTestObject('Pages/Login_Page/login_button'))
			WebUI.delay(2)
			return true
		} catch (Exception e) {
			WebUI.comment("Login failed: " + e.getMessage())
			return false
		}
	}
	
	@Keyword
	def takeScreenshotOnFailure(String testCaseName) {
		String timestamp = new Date().format('yyyy-MM-dd_HH-mm-ss')
		String screenshotPath = "Screenshots/" + testCaseName + "_" + timestamp + ".png"
		WebUI.takeScreenshot(screenshotPath)
		return screenshotPath
	}
	
	@Keyword
	def verifyElementPresentWithTimeout(def testObject, int timeout) {
		try {
			WebUI.waitForElementPresent(testObject, timeout)
			return WebUI.verifyElementPresent(testObject, timeout, FailureHandling.OPTIONAL)
		} catch (Exception e) {
			return false
		}
	}
}
