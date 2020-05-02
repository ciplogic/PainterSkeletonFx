package hellofx

import javafx.geometry.Insets
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.VBox


fun inRect(x: Int, y: Int, x1: Int, y1: Int, w: Int, h: Int): Boolean {
    val x2 = x + w
    val y2 = y + h
    return (x >= x1) && (x <= x2) && (y >= y1) && (y <= y2)
}

fun addVButtonImageWithText(text: String, img: String, action: () -> Unit): Button {
    val imgCtrl = ImageView(Image(img))
    val textLbl = Label(text)

    val result = VBox()
    val externalForm = HelloFX::class.java.getResource("/theme.css").toExternalForm()
    result.padding = Insets(10.0, 10.0, 10.0, 10.0)
    result.stylesheets.add(externalForm)
    result.children.add(imgCtrl)
    result.children.add(textLbl)
    val button = Button("", result)
    button.styleClass.addAll("btn", "btn-danger")
    button.setOnMouseClicked {
        action()
    }
    button.padding = Insets(10.0, 10.0, 10.0, 10.0)
    return button
}
