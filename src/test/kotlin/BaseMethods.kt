import org.junit.Assert
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

open class BaseMethods : TestConfig() {

    fun searchElementById(id: String, errorMessage: String, timeoutInSeconds: Long): WebElement {
        val wait = WebDriverWait(driver, timeoutInSeconds)
        val by = By.id(id)

        wait.withMessage("$errorMessage \n")

        return wait.until(ExpectedConditions.presenceOfElementLocated(by))
    }

    fun searchElementByXpath(xpath: String, errorMessage: String, timeoutInSeconds: Long): WebElement {
        val wait = WebDriverWait(driver, timeoutInSeconds)
        val by = By.xpath(xpath)

        wait.withMessage("$errorMessage \n")

        return wait.until(ExpectedConditions.presenceOfElementLocated(by))
    }

    fun assertElementHasText(element: WebElement, text: String, errorMessage: String) {
        Assert.assertEquals("$errorMessage \n", text, element.text)
    }
}