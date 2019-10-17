package pages

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide.`$$`
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By


open class Page {

    fun get(selector: String): SelenideElement {
        return `$`(selector)
    }

    fun getAll(selector: String): ElementsCollection {
        return `$$`(selector)
    }

    fun findById(id: String): SelenideElement {
        return `$`(By.id(id))
    }

    fun dressColorMapping(color: String): String {
        return when (color) {
            "Pink" -> "color_24"
            "Yellow" -> "color_7"
            else -> ""
        }
    }
}