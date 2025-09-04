import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

// Test Case: API User Creation
WS.comment("Starting API User Creation Test")

// Prepare request data
RequestObject request = findTestObject('API_Endpoints/User_Management/Create_User_API')

// Set dynamic values
WS.setParameterValue(request, 'name', 'John Doe API')
WS.setParameterValue(request, 'username', 'johndoe_api')
WS.setParameterValue(request, 'email', 'john.api@test.com')
WS.setParameterValue(request, 'phone', '123-456-7890')

// Send request
ResponseObject response = WS.sendRequest(request)

// Verify response
WS.verifyResponseStatusCode(response, 201)
WS.verifyElementPropertyValue(response, 'name', 'John Doe API')
WS.verifyElementPropertyValue(response, 'email', 'john.api@test.com')

// Extract and store user ID for future tests
String userId = WS.getElementPropertyValue(response, 'id')
GlobalVariable.CreatedUserId = userId

WS.comment("User created successfully with ID: " + userId)