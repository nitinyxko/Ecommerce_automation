package common
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class UserManagementKeywords {
	
	@Keyword
	def registerNewUser(String firstName, String lastName, String email, String password) {
		try {
			// Navigate to registration page
			WebUI.click(findTestObject('Pages/Registration_Page/register_link'))
			WebUI.waitForElementPresent(findTestObject('Pages/Registration_Page/firstname_field'), 10)
			
			// Fill registration form
			WebUI.click(findTestObject('Pages/Registration_Page/gender_male'))
			WebUI.setText(findTestObject('Pages/Registration_Page/firstname_field'), firstName)
			WebUI.setText(findTestObject('Pages/Registration_Page/lastname_field'), lastName)
			WebUI.setText(findTestObject('Pages/Registration_Page/email_field'), email)
			WebUI.setText(findTestObject('Pages/Registration_Page/password_field'), password)
			WebUI.setText(findTestObject('Pages/Registration_Page/confirm_password'), password)
			
			// Submit registration
			WebUI.click(findTestObject('Pages/Registration_Page/register_button'))
			WebUI.delay(3)
			
			return true
		} catch (Exception e) {
			WebUI.comment("Registration failed: " + e.getMessage())
			return false
		}
	}
	
	@Keyword
	def validateRegistrationSuccess() {
		return WebUI.verifyTextPresent("Your registration completed", false)
	}
}