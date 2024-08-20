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

// Load test data
def data = findTestData('Data Files/LoginData/LoginData') // Adjust the path to your test data file

// Loop through each row of data
for (def index : (1..data.getRowNumbers())) {
	// Retrieve username and password from the test data
	String userName = data.getValue('userName', index)

	String Password = data.getValue('Password', index)

	// Open the browser and navigate to the URL
	WebUI.openBrowser('')

	WebUI.navigateToUrl('https://www.demoblaze.com/')

	// Perform login
	WebUI.click(findTestObject('Object Repository/Valid user and pass/Page_STORE/a_Log in'))

	WebUI.setText(findTestObject('Object Repository/Valid user and pass/Page_STORE/input_Username_loginusername'), userName)

	WebUI.setText(findTestObject('Object Repository/Valid user and pass/Page_STORE/input_Password_loginpassword'), Password)

	WebUI.click(findTestObject('Object Repository/Valid user and pass/Page_STORE/button_Log in'))

 
	// Close the browser
	WebUI.closeBrowser()
}

