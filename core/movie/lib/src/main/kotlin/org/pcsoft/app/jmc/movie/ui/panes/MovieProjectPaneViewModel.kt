package org.pcsoft.app.jmc.movie.ui.panes

import javafx.beans.binding.Bindings
import javafx.beans.binding.IntegerBinding
import javafx.beans.binding.ObjectBinding
import javafx.beans.property.*
import javafx.scene.image.Image
import org.jcodec.api.FrameGrab
import org.jcodec.api.JCodecException
import org.jcodec.common.io.NIOUtils
import org.jcodec.containers.mp4.MP4Util
import org.jcodec.containers.mp4.boxes.MovieBox
import org.pcsoft.app.jmc.commons.exceptions.JmcDecoderException
import org.pcsoft.app.jmc.commons.utils.toImage
import org.pcsoft.framework.jfex.mvvm.FxmlViewModel
import java.io.File
import java.io.IOException

internal class MovieProjectPaneViewModel : FxmlViewModel {

    val file: ObjectProperty<File> = SimpleObjectProperty();

    private val videoFrameGrabWrapper: ReadOnlyObjectWrapper<FrameGrab> = ReadOnlyObjectWrapper<FrameGrab>();
    private val movieWrapper: ReadOnlyObjectWrapper<MovieBox> = ReadOnlyObjectWrapper<MovieBox>();

    val videoFrameGrab = videoFrameGrabWrapper.readOnlyProperty
    val movie = movieWrapper.readOnlyProperty

    val videoFrameCount: IntegerBinding
    val videoFrame: ObjectBinding<Image>

    val selectedVideoFrame: IntegerProperty = SimpleIntegerProperty()

    init {
        videoFrameCount = Bindings.createIntegerBinding(
                { if (movie.get() == null) 0 else movie.get().videoTrack.frameCount },
                movie
        )
        videoFrame = Bindings.createObjectBinding(
                { if (videoFrameGrab.get() == null) null else videoFrameGrab.get().seekToFrameSloppy(selectedVideoFrame.get()).nativeFrame.toImage() },
                videoFrameGrab, selectedVideoFrame
        )

        file.addListener { _ ->
            if (file.get() == null) {
                videoFrameGrabWrapper.set(null)
                movieWrapper.set(null)
                return@addListener
            }

            try {
                videoFrameGrabWrapper.set(FrameGrab.createFrameGrab(NIOUtils.readableChannel(file.get())))
                movieWrapper.set(MP4Util.parseMovie(file.get()))
            } catch (e: IOException) {
                file.set(null)
                throw JmcDecoderException("Unable to read file", e)
            } catch (e: JCodecException) {
                file.set(null)
                throw JmcDecoderException("Unable to read file", e)
            } finally {
                selectedVideoFrame.set(0)
            }
        }
    }
}