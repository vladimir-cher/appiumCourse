import org.junit.jupiter.api.Test

class FirstTest : BaseMethods() {

    @Test
    fun firstTest() {

        val searchField = searchElementById("org.wikipedia:id/search_container", "Cannot find search field", 10)

        searchField.click()

        val search = searchElementById("org.wikipedia:id/search_src_text", "Cannot find search", 10)

        search.sendKeys("Wikipedia")
        //выделять PageObject и отдельные методы для поиска на данном этапе лень, простите:)
    }

    @Test
    fun checkTextInSearchTextView() {
        val searchTextView =
            searchElementByXpath("//*[contains(@class, 'android.widget.TextView')]", "Cannot find search text view", 10)

        assertElementHasText(searchTextView, "Search Wikipedia", "text in search field doesnt match")
    }
}