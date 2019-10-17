package pages

import com.codeborne.selenide.Condition.*
import io.qameta.allure.Step


class MainPage : Page() {

    private val dressesMenuSelector =
        "#block_top_menu > ul > li:nth-child(2) > a"
    private val eveningDressSelector =
        "#block_top_menu > ul > li:nth-child(2) > ul > li:nth-child(2) > a"
    private val summerDressSelector =
        "#block_top_menu > ul > li:nth-child(2) > ul > li:nth-child(3) > a"

    @Step("Hover on dresses menu and click to chosen dress")

    fun clickOnDressesMenu(dressType: String): MainPage {
        get(dressesMenuSelector).scrollTo()
        get(dressesMenuSelector)
            .should(appear)
            .hover()
        when (dressType) {
            "evening" -> get(eveningDressSelector).should(appear).should(
                attribute(
                    "title",
                    "Evening Dresses"
                )
            ).click()
            "casual" -> get(summerDressSelector).should(appear).should(
                attribute(
                    "title",
                    "Summer Dresses"
                )
            ).click()
        }
        return this
    }

}