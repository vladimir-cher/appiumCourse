import org.junit.jupiter.api.Test

class FirstTest : TestConfig() {

    @Test
    fun firstTest() {

        val searchField = driver.findElementById("org.wikipedia:id/search_container")

        searchField.click()

        val search = driver.findElementById("org.wikipedia:id/search_src_text")

        search.sendKeys("Wikipedia")
        //выделять PageObject и отдельные методы для поиска на данном этапе лень, простите:)
    }
}