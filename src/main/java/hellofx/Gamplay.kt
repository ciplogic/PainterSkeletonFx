package hellofx

import hellofx.dialogs.UpgradeChoice
import hellofx.framework.MainContext
import javafx.scene.Scene
import javafx.scene.input.MouseEvent
import javafx.scene.layout.StackPane
import javafx.stage.Stage
import javafx.stage.StageStyle

class Gamplay(context: MainContext) {
    val ctxt = context

    init {
        context.router.register("onMouse", {
            val mouseEv: MouseEvent = it as MouseEvent
            onMouseEvent(mouseEv)
        })
    }

    fun onMouseEvent(mouseEvent: MouseEvent) {
        println("Event: " + mouseEvent)
        var upgradeChoice = UpgradeChoice(ctxt)
        var stage = Stage(StageStyle.UNDECORATED)
        val scene = Scene(StackPane(upgradeChoice.build()))

        stage.scene = scene
        stage.show()
    }
}