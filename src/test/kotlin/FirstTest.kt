import org.junit.Assert
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

    @Test
    fun findSomethingCloseSearch() {
        val searchField = searchElementById("org.wikipedia:id/search_container", "Cannot find search field", 10)

        searchField.click()

        val search = searchElementById("org.wikipedia:id/search_src_text", "Cannot find search", 10)

        search.sendKeys("Wikipedia")

        val firstArticle = searchElementByXpath(
            "//*[contains(@text, 'Free online encyclopedia that anyone can edit')]",
            "cannot find first article",
            10
        )

        val secondArticle = searchElementByXpath(
            "//*[contains(@text, 'American non-profit charitable organization')]",
            "cannot find first article",
            10
        )

        val closeSearch = searchElementById("org.wikipedia:id/search_close_btn", "cannot find close search element", 10)

        assertElementHasText(
            firstArticle,
            "Free online encyclopedia that anyone can edit",
            "text in first article doesn't match"
        )

        assertElementHasText(
            secondArticle,
            "American non-profit charitable organization",
            "text in second article doesn't match"
        )

        closeSearch.click()

        waitForElementNotPresentByXpath(
            "//*[contains(@text, 'American non-profit charitable organization')]",
            "cannot find first article",
            10
        )
    }

    @Test
    fun findAllElementsCheckText() {
        val searchField = searchElementById("org.wikipedia:id/search_container", "Cannot find search field", 10)

        searchField.click()

        val search = searchElementById("org.wikipedia:id/search_src_text", "Cannot find search", 10)

        val textToSearch = "Java"
        search.sendKeys(textToSearch)

        val articles = driver.findElementsByXPath("//*[contains(@text, '$textToSearch')]")
//         вариант реализации через for
//            for (i in 0 until articles.size) {
//                Assert.assertTrue(articles[i].getAttribute("text").contains(textToSearch))
//            }

        //через forEachIndexed
//        articles.forEachIndexed() { index, _ ->
//            Assert.assertTrue(articles[index].getAttribute("text").contains(textToSearch))
//        }

        articles.forEach { articles ->
            Assert.assertTrue(articles.getAttribute("text").contains(textToSearch))
        }

    }
}