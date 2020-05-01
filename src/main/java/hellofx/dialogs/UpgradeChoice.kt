package hellofx.dialogs

import hellofx.addVButtonImageWithText
import hellofx.framework.MainContext
import javafx.geometry.Insets
import javafx.scene.control.Label
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox

class UpgradeChoice(context: MainContext) {
    fun build(onExp: () -> Unit, onCash: () -> Unit): BorderPane {
        val mainPane = BorderPane()
        mainPane.padding = Insets(10.0, 10.0, 10.0, 10.0)
        val hbox = HBox()
        hbox.padding = Insets(10.0, 10.0, 10.0, 10.0)
        hbox.spacing = 5.0
        hbox.children.add(addVButtonImageWithText("Experience", "exp.png", onExp))
        hbox.children.add(addVButtonImageWithText("Money", "cash.png", onCash))
        mainPane.center = hbox

        mainPane.top = Label("You found a box with new experience or money. \nWhat would you want?")

        return mainPane
    }
}