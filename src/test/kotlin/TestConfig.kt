import io.appium.java_client.MobileDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import org.junit.jupiter.api.BeforeAll
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL
import java.util.concurrent.TimeUnit

open class TestConfig {
    companion object {

        @JvmStatic
        lateinit var driver: MobileDriver<MobileElement>


        @JvmStatic
        @BeforeAll
        fun setUp() {
            val capabilities = DesiredCapabilities()

            capabilities.setCapability("deviceName", "pixel")
            capabilities.setCapability("platformName", "Android")
            capabilities.setCapability("udid", "emulator-5554")
            capabilities.setCapability("appPackage", "org.wikipedia")
            capabilities.setCapability("appActivity", ".main.MainActivity")
            capabilities.setCapability("app", "C:\\Users\\vladm\\IdeaProjects\\appiumCourse\\apks\\org.wikipedia.apk")

            driver = AndroidDriver(URL("http://0.0.0.0:4723/wd/hub"), capabilities)

            driver.manage()?.timeouts()?.implicitlyWait(20, TimeUnit.SECONDS)

        }
    }

}