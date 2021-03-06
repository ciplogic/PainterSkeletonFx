package hellofx.framework

import hellofx.EventNames
import hellofx.Painter
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.image.Image
import javafx.scene.text.TextAlignment

class CanvasHandler(context: MainContext) {
    private val ctxt = context
    var canvas: Canvas
    private val img = Image("tree.png")
    private val boxImg = Image("box.png")

    init {
        val prefs = context.getObj<GamePreferences>("preferences")
        canvas = Canvas(prefs.w.toDouble(), prefs.h.toDouble())
        canvas.setOnMouseClicked {
            context.notify(EventNames.onMouse, it)
        }
    }
    private var thickness = 5.0
    private var painter = Painter()

    fun drawShapes(gc: GraphicsContext) {
        painter.updateGc(gc)
        ctxt.notify(EventNames.onPaint, painter)


        thickness += 0.01
        painter.draw(img, 100, 100)
        painter.draw(boxImg, 200, 100)
        painter.textAlign(TextAlignment.CENTER)
        painter.draw("tree", 132, 180)
    }
}