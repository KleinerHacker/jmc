package org.pcsoft.app.jmc.commons.utils

import javafx.embed.swing.SwingFXUtils
import javafx.scene.image.Image
import org.apache.batik.transcoder.TranscoderException
import org.apache.batik.transcoder.TranscoderInput
import org.apache.batik.transcoder.TranscoderOutput
import org.apache.batik.transcoder.image.ImageTranscoder
import java.awt.image.BufferedImage


internal class BufferedImageTranscoder(
        width: Int,
        height: Int,
) : ImageTranscoder() {
    init {
        this.width = width.toFloat()
        this.height = height.toFloat()
    }

    override fun createImage(width: Int, height: Int): BufferedImage {
        return BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)
    }

    @Throws(TranscoderException::class)
    override fun writeImage(img: BufferedImage?, to: TranscoderOutput?) {
        if (to is TranscoderBufferedImageOutput) {
            to.image = img
        }
    }
}

internal class TranscoderBufferedImageOutput : TranscoderOutput() {
    var image: BufferedImage? = null
}


fun loadSvg(path: String, width: Int = 16, height: Int = 16): Image {
    val transcoder = BufferedImageTranscoder(width, height)

    BufferedImageTranscoder::class.java.getResourceAsStream(path).use { stream ->
        val transIn = TranscoderInput(stream)
        val transOut = TranscoderBufferedImageOutput()

        transcoder.transcode(transIn, transOut)
        return SwingFXUtils.toFXImage(transOut.image, null)
    }
}