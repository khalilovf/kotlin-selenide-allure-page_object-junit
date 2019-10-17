package pages

import io.qameta.allure.Step

class SearchResultPage : Page() {

    private val moreButtonSelector =
        "#center_column > ul > li > div > div.right-block > div.button-container > a.button.lnk_view.btn.btn-default"
    private val pictureSelector =
        "#center_column > ul > li > div > div.left-block > div"

    @Step("Scrolls to first dress in search page, hover on it and click to more button")
    fun clickOnMoreButton() {
        get(pictureSelector).scrollTo().hover()
        get(moreButtonSelector).click()
    }
}