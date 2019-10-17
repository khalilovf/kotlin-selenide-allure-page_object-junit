import com.codeborne.selenide.Configuration
import config.*
import com.codeborne.selenide.Selenide.*
import org.junit.jupiter.api.*
import testData.CasesData
import pages.DressPage
import pages.OrderPage
import pages.MainPage
import pages.SearchResultPage
import io.qameta.allure.Description
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestSmoke {

    @BeforeAll
    fun setUp() {
        Configuration.browser = "chrome"
        Configuration.startMaximized = true
        Configuration.timeout = TestConfig.timeOut
        Configuration.screenshots = false
        open(TestConfig.baseUrl)
    }

    @AfterEach
    fun tearDown() {
        clearBrowserCookies()
    }

    @Description("Scenario 1")
    @ParameterizedTest
    @ValueSource(strings = ["evening"])
    fun test1(dressType: String) {
        MainPage().clickOnDressesMenu(dressType)
        SearchResultPage().clickOnMoreButton()
        DressPage().assertDataSheet(CasesData.dressDataSheetValues)
    }

    @Description("Scenario 2")
    @ParameterizedTest
    @ValueSource(strings = ["evening"])
    fun test2(dressType: String) {
        MainPage().clickOnDressesMenu(dressType)
        SearchResultPage().clickOnMoreButton()
        DressPage().setDressParams("M", "Pink")
        DressPage().clickAddToCardAnContinue()
        DressPage().assertCartValue(1)
    }

    @Description("Scenario 3")
    @ParameterizedTest
    @ValueSource(strings = ["evening"])
    fun test3(dressType: String) {
        MainPage().clickOnDressesMenu(dressType)
        SearchResultPage().clickOnMoreButton()
        DressPage().setDressParams("M", "Pink")
        DressPage().clickAddToCardAnContinue()
        DressPage().hoverToCartAndCheckoutClick()
        OrderPage().deleteFromCard()
        OrderPage().assertWarningMessage(CasesData.orderWarningMessage)
    }

    @Description("Failed test")
    @Disabled
    @ParameterizedTest
    @ValueSource(strings = ["evening", "summer"]) //summer dress sheet not asserted here
    fun test4(dressType: String) {
        MainPage().clickOnDressesMenu(dressType)
        SearchResultPage().clickOnMoreButton()
        DressPage().assertDataSheet(CasesData.dressDataSheetValues)
    }
}