package hellofx

import hellofx.framework.MainContext
import javafx.scene.input.MouseEvent

fun inRect(x: Int, y: Int, x1: Int, y1: Int, w: Int, h: Int): Boolean {
    var x2 = x + w
    var y2 = y + h
    return (x >= x1) && (x <= x2) && (y >= y1) && (y <= y2)
}

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

    }
}