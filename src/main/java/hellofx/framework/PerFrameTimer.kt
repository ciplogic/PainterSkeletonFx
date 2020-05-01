package hellofx.framework

import javafx.animation.AnimationTimer

class PerFrameTimer(context: MainContext) : AnimationTimer() {
    val ctxt = context
    override fun handle(now: Long) {
        ctxt.notify("onFrame", now)
    }
}