package hellofx

import javafx.scene.canvas.GraphicsContext
import javafx.scene.image.Image
import javafx.scene.paint.Color
import javafx.scene.text.TextAlignment

class Painter {
    private lateinit var gc: GraphicsContext
    fun updateGc(gc: GraphicsContext) {
        this.gc = gc
    }

    fun draw(image: Image, x: Int, y: Int) {
        gc.drawImage(image, x.toDouble(), y.toDouble())
    }

    fun fill(color: Color = Color.WHITE){
        gc.fill = color
    }

    fun textAlign(alignment: TextAlignment){
        gc.textAlign = alignment
    }

    fun draw(text: String, x: Int, y: Int, thickness: Int=1) {
        gc.lineWidth = thickness.toDouble()
        gc.fillText(text, x.toDouble(), y.toDouble())
    }

}