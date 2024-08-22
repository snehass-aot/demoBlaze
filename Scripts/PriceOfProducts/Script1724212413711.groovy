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

//def data = findTestData('LoginData/LoginData')

//def index = 2

//def userName = data.getValue('userName', index)

//def Password = data.getValue('Password', index)

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.demoblaze.com/')

//WebUI.click(findTestObject('Object Repository/PriceOfProducts/Page_STORE/a_Log in'))

//WebUI.setText(findTestObject('Object Repository/PriceOfProducts/Page_STORE/input_Username_loginusername'), userName)

//WebUI.setText(findTestObject('Object Repository/PriceOfProducts/Page_STORE/input_Password_loginpassword'), Password)

//WebUI.click(findTestObject('Object Repository/PriceOfProducts/Page_STORE/button_Log in'))

def orgnlPrice1 = WebUI.getText(findTestObject('Object Repository/PriceOfProducts/Page_STORE/h5_700'))

def orgnlPrice2 = WebUI.getText(findTestObject('Object Repository/PriceOfProducts/Page_STORE/h5_790'))


WebUI.click(findTestObject('Object Repository/PriceOfProducts/Page_STORE/a_HTC One M9'))

WebUI.click(findTestObject('Object Repository/PriceOfProducts/Page_STORE/a_Add to cart'))

WebUI.click(findTestObject('Object Repository/PriceOfProducts/Page_STORE/a_Home (current)'))

WebUI.click(findTestObject('Object Repository/PriceOfProducts/Page_STORE/a_Sony vaio i5'))

WebUI.click(findTestObject('Object Repository/PriceOfProducts/Page_STORE/a_Add to cart'))

WebUI.click(findTestObject('Object Repository/PriceOfProducts/Page_STORE/a_Home (current)'))

WebUI.click(findTestObject('Object Repository/PriceOfProducts/Page_STORE/button_Next'))

WebUI.click(findTestObject('Object Repository/PriceOfProducts/Page_STORE/a_Dell i7 8gb'))

WebUI.click(findTestObject('Object Repository/PriceOfProducts/Page_STORE/a_Add to cart'))

WebUI.click(findTestObject('Object Repository/PriceOfProducts/Page_STORE/a_Cart'))

def dsplyPrice1 = WebUI.getText(findTestObject('Object Repository/PriceOfProducts/Page_STORE/td_700'))

def dsplyPrice2 = WebUI.getText(findTestObject('Object Repository/PriceOfProducts/Page_STORE/td_790'))

orgnlPrice1 = orgnlPrice1.replace('$', '')

assert orgnlPrice1 == dsplyPrice1

orgnlPrice2 = orgnlPrice2.replace('$', '')

assert orgnlPrice2 == dsplyPrice2

WebUI.verifyElementPresent(findTestObject('Object Repository/AddToCart/Page_STORE/a_Delete'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

