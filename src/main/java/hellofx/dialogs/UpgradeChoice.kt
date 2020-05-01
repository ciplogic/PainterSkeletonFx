package hellofx.dialogs

import hellofx.framework.MainContext
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

fun addImageAndPanelInHBox(text: String, img: String): VBox {
    var imgCtrl = ImageView(Image(img))
    val textLbl = Label(text)

    val result = VBox()
    result.children.add(imgCtrl)
    result.children.add(textLbl)
    return result
}

class UpgradeChoice(context: MainContext) {
    fun build(): BorderPane {
        var mainPane = BorderPane()
        var hbox = HBox()
        hbox.children.add(Button("", addImageAndPanelInHBox("Experience", "exp.png")))
        hbox.children.add(Button("Money"))
        mainPane.center = hbox

        return mainPane
    }
}