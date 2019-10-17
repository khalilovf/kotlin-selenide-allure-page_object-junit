package pages

import com.codeborne.selenide.Condition
import io.qameta.allure.Step
import org.openqa.selenium.By

class DressPage : Page() {

    private val dataSheetSelector =
        "#center_column > div > section:nth-child(2) > table > tbody > tr:nth-child"

    private val moreInfoLocator =
        "#center_column > div > section:nth-child(3) > h3"

    private val sizeFieldSelector =
        "#group_1"

    private val addToCartSelector =
        "#add_to_cart > button > span"

    private val cartSelector =
        "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a > span.ajax_cart_quantity"

    private val checkOutButtonSelector =
        "#button_order_cart > span"

    private val continueShoppingFrameSelector =
        "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span"

    @Step("Scrolls to footer sheet with dress params and assert values on it")
    fun assertDataSheet(tuples: Map<String, String>) {
        get(moreInfoLocator).scrollTo()
        tuples.keys.forEachIndexed { index, key ->
            val columnCss = dataSheetSelector + "(" + (index + 1).toString() + ")"
            assert(key == get(columnCss).findElement(By.tagName("td")).text)
            assert(tuples[key] == get(columnCss).lastChild().text)
        }
    }

    @Step("Set dress size and color: {0}, {1}")
    fun setDressParams(size: String, color: String) {
        get(sizeFieldSelector).scrollTo()
        get(sizeFieldSelector).sendKeys(size)
        findById(dressColorMapping(color)).scrollTo().click()
    }

    @Step("Add dress to cart and click continue shopping")
    fun clickAddToCardAnContinue() {
        get(addToCartSelector).click()
        get(continueShoppingFrameSelector).click()
    }

    @Step("Assert quantity of dresses in cart panel: {0}")
    fun assertCartValue(value: Int) {
        get(cartSelector).scrollTo().shouldHave(Condition.text(value.toString()))
    }

    @Step("Hover on cart panel then click checkout")
    fun hoverToCartAndCheckoutClick() {
        get(cartSelector).scrollTo().hover()
        get(checkOutButtonSelector).click()
    }
}