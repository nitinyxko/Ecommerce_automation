import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.context.TestCaseContext

class CustomTestListener {
	
	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		println "Starting test case: " + testCaseContext.getTestCaseId()
		// Log test start time
		GlobalVariable.TestStartTime = System.currentTimeMillis()
	}
	
	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		println "Finished test case: " + testCaseContext.getTestCaseId()
		// Calculate execution time
		long executionTime = System.currentTimeMillis() - GlobalVariable.TestStartTime
		println "Execution time: " + executionTime + "ms"
	}
}