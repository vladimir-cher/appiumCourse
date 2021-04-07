import org.junit.Assert
import org.junit.jupiter.api.Test


class MainClass {
    private val classNumber = 20

    private fun getLocalNumber(): Int {

        return 14

    }

    @Test
    fun testGetLocalNumber() {
        Assert.assertEquals("Function getLocalNumber return number !=14", getLocalNumber(), 14)
    }

    private fun getClassNumber(): Int {
        return classNumber

    }

    @Test
    fun testGetClassNumber() {
        Assert.assertTrue("Function getClassNumber return number smaller than 45", getClassNumber() > 45)
    }
}