package pages

import com.codeborne.selenide.Condition
import io.qameta.allure.Step

class OrderPage : Page() {

    private val alertSelector =
        "#center_column > p"

    private val deleteButtonId =
        "4_44_0_0"

    @Step("Click on delete from cart")
    fun deleteFromCard() {
        findById(deleteButtonId).click()
    }

    @Step("Scrolls to warning message in footer and asserts message: {0}")
    fun assertWarningMessage(message: String) {
        get(alertSelector).scrollTo()
        get(alertSelector).shouldHave(Condition.text(message))
    }

}