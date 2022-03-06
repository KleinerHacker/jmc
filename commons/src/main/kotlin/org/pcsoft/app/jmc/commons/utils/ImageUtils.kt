package org.pcsoft.app.jmc.commons.utils

import javafx.embed.swing.SwingFXUtils
import javafx.scene.image.Image
import javafx.scene.image.WritableImage
import org.jcodec.common.model.Picture
import org.jcodec.scale.AWTUtil

fun Picture.toImage() : Image {
    val bufferedImage = AWTUtil.toBufferedImage(this)
    val fxImage = WritableImage(bufferedImage.width, bufferedImage.height)
    SwingFXUtils.toFXImage(bufferedImage, fxImage)

    return fxImage
}