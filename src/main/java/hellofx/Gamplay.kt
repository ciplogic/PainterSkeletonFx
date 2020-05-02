package hellofx

import hellofx.dialogs.UpgradeChoice
import hellofx.framework.MainContext
import javafx.scene.input.MouseEvent
import javafx.scene.layout.StackPane
import javafx.stage.Stage

class Gamplay(context: MainContext) {
    private val ctxt = context

    init {
        context.listen<MouseEvent>(EventNames.onMouse) {
            onMouseEvent(it)
        }
    }

    private var stage: Stage? = null
    private fun onMouseEvent(mouseEvent: MouseEvent) {
        println("Event: " + mouseEvent)
        val upgradeChoice = UpgradeChoice(ctxt)
        if (stage != null)
            return
        val mainStack = ctxt.getObj<StackPane>(ObjectNames.mainStack)

        mainStack.children.add(upgradeChoice.build({
            println("Experience chosen")
            val lastNode = mainStack.children[mainStack.children.size - 1]
            mainStack.children.remove(lastNode)
        }, {
            println("Money chosen")
            val lastNode = mainStack.children[mainStack.children.size - 1]
            mainStack.children.remove(lastNode)
        }))
    }
}