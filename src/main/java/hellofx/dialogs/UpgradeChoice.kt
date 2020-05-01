package hellofx.dialogs

import hellofx.framework.MainContext
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

fun addVButtonImageWithText(text: String, img: String, action: () -> Unit): Button {

    var imgCtrl = ImageView(Image(img))
    val textLbl = Label(text)

    val result = VBox()
    result.children.add(imgCtrl)
    result.children.add(textLbl)
    var button = Button("", result)
    button.setOnMouseClicked {
        action()
    }
    return button
}

class UpgradeChoice(context: MainContext) {
    fun build(onExp: () -> Unit, onCash: () -> Unit): BorderPane {
        var mainPane = BorderPane()
        var hbox = HBox()
        hbox.children.add(addVButtonImageWithText("Experience", "exp.png", onExp))
        hbox.children.add(addVButtonImageWithText("Money", "cash.png", onCash))
        mainPane.center = hbox

        return mainPane
    }
}