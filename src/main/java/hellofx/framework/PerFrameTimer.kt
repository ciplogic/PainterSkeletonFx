package hellofx.framework

import hellofx.EventNames
import javafx.animation.AnimationTimer

class PerFrameTimer(context: MainContext) : AnimationTimer() {
    private val ctxt = context
    override fun handle(now: Long) {
        ctxt.notify(EventNames.onFrame, now)
    }
}