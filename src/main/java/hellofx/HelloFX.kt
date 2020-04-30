package hellofx

import hellofx.framework.Router
import javafx.animation.AnimationTimer
import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.StackPane
import javafx.stage.Stage


class PerFrameTimer(context: MainContext) : AnimationTimer() {
    val router = context.router
    override fun handle(now: Long) {
        router.call("onFrame", now)
    }
}

class MainContext
{
    val router= Router()
    val objRepo = hashMapOf<String, Any>()
}


class HelloFX : Application() {
    override fun start(stage: Stage) {
        val context = MainContext()

        var animationTimer = PerFrameTimer(context)


        var canvas = CanvasHandler(800, 600)
        val scene = Scene(StackPane(canvas.canvas), 800.0, 600.0)
        stage.scene = scene
        stage.show()
        animationTimer.start()

        context.router.register("onFrame", {canvas.drawShapes(canvas.canvas.graphicsContext2D)} )
    }

}
fun main(args: Array<String>) {
    Application.launch(HelloFX::class.java)
}