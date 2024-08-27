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

def data = findTestData('Data Files/LoginData/LoginData')

for (def index : (1..data.getRowNumbers())) {
	def userName = data.getValue('userName', index)
	def Password = data.getValue('Password', index)
	
	WebUI.openBrowser('')
	WebUI.navigateToUrl('https://www.demoblaze.com/')
	
	WebUI.click(findTestObject('Object Repository/valid user invalid pass/Page_STORE/a_Log in'))
	
	WebUI.setText(findTestObject('Object Repository/valid user invalid pass/Page_STORE/input_Username_loginusername'), userName)
	WebUI.setText(findTestObject('Object Repository/valid user invalid pass/Page_STORE/input_Password_loginpassword'), Password)
	
	WebUI.click(findTestObject('Object Repository/valid user invalid pass/Page_STORE/button_Log in'))
	
	def isLoginSuccessful = WebUI.waitForElementVisible(findTestObject('Object Repository/valid user invalid pass/Page_STORE/a_Log out'), 1, FailureHandling.OPTIONAL)
	
	if (isLoginSuccessful) {
		println('Login successful')
		WebUI.verifyElementPresent(findTestObject('Object Repository/valid user invalid pass/Page_STORE/a_Log out'),5)
		
	} else {
		println('invalid')
	}
	
	WebUI.closeBrowser()
}


