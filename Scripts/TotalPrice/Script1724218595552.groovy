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
import org.openqa.selenium.WebElement

// Fetch login data
//def data = findTestData('LoginData/LoginData')
//def index = 2
//def userName = data.getValue('userName', index)
//def Password = data.getValue('Password', index)

// Open browser and log in
WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.demoblaze.com/')
//WebUI.click(findTestObject('Object Repository/Total price/Page_STORE/a_Log in'))
//WebUI.setText(findTestObject('Object Repository/Total price/Page_STORE/input_Username_loginusername'), userName)
//WebUI.setText(findTestObject('Object Repository/Total price/Page_STORE/input_Password_loginpassword'), Password)
//WebUI.click(findTestObject('Object Repository/Total price/Page_STORE/button_Log in'))

// Clear the cart by navigating to it and removing all items
WebUI.click(findTestObject('Object Repository/Total price/Page_STORE/a_Cart'))

// Get all delete buttons and remove all items
List<WebElement> deleteButtons = WebUI.findWebElements(findTestObject('Object Repository/Total price/Page_STORE/a_Delete'), 5)
deleteButtons.each { button ->
	button.click() // Remove all products from the cart
	WebUI.delay(1) // Delay for the deletion to process
}

// Add only the selected products to the cart
WebUI.click(findTestObject('Object Repository/Total price/Page_STORE/a_Home (current)'))
WebUI.click(findTestObject('Object Repository/Total price/Page_STORE/a_HTC One M9'))
WebUI.click(findTestObject('Object Repository/Total price/Page_STORE/a_Add to cart'))
WebUI.click(findTestObject('Object Repository/Total price/Page_STORE/a_Home (current)'))
WebUI.click(findTestObject('Object Repository/Total price/Page_STORE/a_Sony vaio i5'))
WebUI.click(findTestObject('Object Repository/Total price/Page_STORE/a_Add to cart'))
WebUI.click(findTestObject('Object Repository/Total price/Page_STORE/a_Home (current)'))
WebUI.click(findTestObject('Object Repository/Total price/Page_STORE/button_Next'))
WebUI.click(findTestObject('Object Repository/Total price/Page_STORE/a_Dell i7 8gb'))
WebUI.click(findTestObject('Object Repository/Total price/Page_STORE/a_Add to cart'))

// Navigate to the cart to calculate the total of the newly added items
WebUI.click(findTestObject('Object Repository/Total price/Page_STORE/a_Cart'))

// Fetch all price elements of the current items in the cart
List<String> priceElements = WebUI.findWebElements(findTestObject('Object Repository/Total price/Page_STORE/h3_2190'), 5).collect { it.getText() }

// Convert prices to numerical values by removing dollar signs
List<Double> prices = priceElements.collect { it.replaceAll(/\$/, "").toDouble() }

// Calculate the total sum of the selected products
def totalSum = prices.sum()

println("Total sum of selected products:\$" + totalSum)

// Close the browser after calculation
WebUI.closeBrowser()
