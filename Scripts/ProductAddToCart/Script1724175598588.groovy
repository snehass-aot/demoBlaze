import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling

def data = findTestData('LoginData/LoginData')

def index = 2
def userName = data.getValue('userName', index)
def Password = data.getValue('Password', index)

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.demoblaze.com/')

WebUI.click(findTestObject('Object Repository/AddToCart/Page_STORE/a_Log in'))

WebUI.setText(findTestObject('Object Repository/AddToCart/Page_STORE/input_Username_loginusername'),userName)

WebUI.setText(findTestObject('Object Repository/AddToCart/Page_STORE/input_Password_loginpassword'), Password)

WebUI.click(findTestObject('Object Repository/AddToCart/Page_STORE/button_Log in'))

WebUI.click(findTestObject('Object Repository/AddToCart/Page_STORE/a_HTC One M9'))

WebUI.click(findTestObject('Object Repository/AddToCart/Page_STORE/a_Add to cart'))
WebUI.click(findTestObject('Object Repository/AddToCart/Page_STORE/a_Home (current)'))
WebUI.click(findTestObject('Object Repository/AddToCart/Page_STORE/button_Next'))
WebUI.click(findTestObject('Object Repository/AddToCart/Page_STORE/a_Dell i7 8gb'))
WebUI.click(findTestObject('Object Repository/AddToCart/Page_STORE/a_Add to cart'))
WebUI.click(findTestObject('Object Repository/AddToCart/Page_STORE/a_Home (current)'))
WebUI.click(findTestObject('Object Repository/AddToCart/Page_STORE/a_Sony vaio i5'))
WebUI.click(findTestObject('Object Repository/AddToCart/Page_STORE/a_Add to cart'))

WebUI.click(findTestObject('Object Repository/AddToCart/Page_STORE/a_Cart'))


WebUI.verifyElementPresent(findTestObject('Object Repository/AddToCart/Page_STORE/a_Delete'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()
