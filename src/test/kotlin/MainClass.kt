import org.junit.Assert
import org.junit.jupiter.api.Test


class MainClass {

    private fun getLocalNumber(): Int {

        return 14

    }

    @Test
    fun testGetLocalNumber() {
        Assert.assertEquals("Function getLocalNumber return number !=14", getLocalNumber(), 14)
    }
}