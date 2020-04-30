package hellofx

import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.image.Image
import javafx.scene.text.TextAlignment

class CanvasHandler (w: Int, h: Int) {
    var canvas: Canvas
    val img = Image("tree.png")

    init {
        canvas = Canvas(w.toDouble(), h.toDouble())

    }
    var thickness = 5.0
    var painter = Painter()

    fun drawShapes(gc: GraphicsContext) {
        painter.updateGc(gc)
        gc.clearRect(0.0, 0.0, 800.0, 600.0)

        thickness += 0.01
        painter.draw(img, 100, 100)
        painter.textAlign(TextAlignment.CENTER)
        painter.draw("tree", 132, 180)
    }
}