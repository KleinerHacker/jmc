package org.pcsoft.app.jmc.movie.ui.panes;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.*;
import javafx.scene.image.Image;
import org.jcodec.api.FrameGrab;
import org.jcodec.api.JCodecException;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.containers.mp4.MP4Util;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.pcsoft.app.jmc.commons.exceptions.JmcDecoderException;
import org.pcsoft.app.jmc.commons.utils.ImageUtils;
import org.pcsoft.framework.jfex.mvvm.FxmlViewModel;

import java.io.File;
import java.io.IOException;

public class MovieProjectPaneViewModel implements FxmlViewModel {
    private final ObjectProperty<File> file = new SimpleObjectProperty<>();

    private final ReadOnlyObjectWrapper<FrameGrab> videoFrameGrabWrapper = new ReadOnlyObjectWrapper<>();
    private final ReadOnlyObjectWrapper<MovieBox> movieWrapper = new ReadOnlyObjectWrapper<>();

    private final ReadOnlyObjectProperty<FrameGrab> videoFrameGrab = videoFrameGrabWrapper.getReadOnlyProperty();
    private final ReadOnlyObjectProperty<MovieBox> movie = movieWrapper.getReadOnlyProperty();

    private final IntegerBinding videoFrameCount;
    private final ObjectBinding<Image> videoFrame;

    private final IntegerProperty selectedVideoFrame = new SimpleIntegerProperty();

    public MovieProjectPaneViewModel() {
        videoFrameCount = Bindings.createIntegerBinding(
                () -> movie.get() == null ? 0 : movie.get().getVideoTrack().getFrameCount(),
                movie
        );
        videoFrame = Bindings.createObjectBinding(
                () -> videoFrameGrab.get() == null ? null : ImageUtils.toImage(videoFrameGrab.get().seekToFrameSloppy(selectedVideoFrame.get()).getNativeFrame()),
                videoFrameGrab, selectedVideoFrame
        );

        file.addListener(o -> {
            if (file.get() == null) {
                videoFrameGrabWrapper.set(null);
                movieWrapper.set(null);

                return;
            }

            try {
                videoFrameGrabWrapper.set(FrameGrab.createFrameGrab(NIOUtils.readableChannel(file.get())));
                movieWrapper.set(MP4Util.parseMovie(file.get()));
            } catch (IOException | JCodecException e) {
                file.set(null);
                throw new JmcDecoderException("Unable to read file", e);
            } finally {
                selectedVideoFrame.set(0);
            }
        });
    }

    public File getFile() {
        return file.get();
    }

    public ObjectProperty<File> fileProperty() {
        return file;
    }

    public void setFile(File file) {
        this.file.set(file);
    }

    public FrameGrab getVideoFrameGrab() {
        return videoFrameGrab.get();
    }

    public ReadOnlyObjectProperty<FrameGrab> videoFrameGrabProperty() {
        return videoFrameGrab;
    }

    public MovieBox getMovie() {
        return movie.get();
    }

    public ReadOnlyObjectProperty<MovieBox> movieProperty() {
        return movie;
    }

    public Number getVideoFrameCount() {
        return videoFrameCount.get();
    }

    public IntegerBinding videoFrameCountProperty() {
        return videoFrameCount;
    }

    public Image getVideoFrame() {
        return videoFrame.get();
    }

    public ObjectBinding<Image> videoFrameProperty() {
        return videoFrame;
    }

    public int getSelectedVideoFrame() {
        return selectedVideoFrame.get();
    }

    public IntegerProperty selectedVideoFrameProperty() {
        return selectedVideoFrame;
    }

    public void setSelectedVideoFrame(int selectedVideoFrame) {
        this.selectedVideoFrame.set(selectedVideoFrame);
    }
}
