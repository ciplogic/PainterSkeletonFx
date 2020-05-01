package hellofx

import hellofx.framework.CanvasHandler
import hellofx.framework.GamePreferences
import hellofx.framework.MainContext
import hellofx.framework.PerFrameTimer
import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.StackPane
import javafx.stage.Stage

class HelloFX : Application() {
    override fun start(stage: Stage) {
        val context = MainContext()

        setupPreferences(context)

        val animationTimer = PerFrameTimer(context)

        val canvas = CanvasHandler(context)
        val scene = Scene(StackPane(canvas.canvas))
        stage.scene = scene
        val externalForm = HelloFX::class.java.getResource("/theme.css").toExternalForm()

        scene.stylesheets.add(externalForm)


        stage.show()
        animationTimer.start()

        context.listen(EventNames.onFrame) {
            canvas.drawShapes(canvas.canvas.graphicsContext2D)
        }
        var gameplay = Gamplay(context)
    }

    private fun setupPreferences(context: MainContext) {
        val prefs = GamePreferences()
        prefs.w = 1024
        prefs.h = 768
        context.objRepo["preferences"] = prefs
    }
}