package hellofx.dialogs

import hellofx.addVButtonImageWithText
import hellofx.framework.MainContext
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.control.Label
import javafx.scene.layout.*
import javafx.scene.paint.Color

class UpgradeChoice(context: MainContext) {
    fun build(onExp: () -> Unit, onCash: () -> Unit): Node {
        val mainPane = Pane()
        val vBox = VBox()
        vBox.background = Background(BackgroundFill(Color.valueOf("#fefe00"), null, null))
        vBox.padding = Insets(10.0, 10.0, 10.0, 10.0)

        vBox.children.add(Label("You found a box with new experience or money. \nWhat would you want?"))

        val hbox = HBox()
        hbox.padding = Insets(10.0, 10.0, 10.0, 10.0)
        hbox.spacing = 10.0
        hbox.children.add(addVButtonImageWithText("Experience", "exp.png", onExp))
        hbox.children.add(addVButtonImageWithText("Money", "cash.png", onCash))
        vBox.children.add(hbox)
        VBox.setVgrow(mainPane, Priority.ALWAYS)
        vBox.alignment = Pos.CENTER
        vBox.layoutX = 200.0
        vBox.layoutY = 200.0

        mainPane.children.add(vBox)


        return mainPane
    }
}