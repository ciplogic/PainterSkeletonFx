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
        context.listen<MouseEvent>("onMouse") {
            onMouseEvent(it)
        }
    }

    var stage: Stage? = null
    fun onMouseEvent(mouseEvent: MouseEvent) {
        println("Event: " + mouseEvent)
        val upgradeChoice = UpgradeChoice(ctxt)
        if (stage != null)
            return
        stage = Stage(StageStyle.UNDECORATED)
        val scene = Scene(StackPane(upgradeChoice.build({
            println("Experience chosen")
            stage!!.close()
            stage = null
        }, {
            println("Money chosen")
            stage!!.close()
            stage = null
        })))


        val externalForm = HelloFX::class.java.getResource("/theme.css").toExternalForm()

        scene.stylesheets.add(externalForm)

        stage!!.scene = scene
        stage!!.show()
    }
}