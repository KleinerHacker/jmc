package org.pcsoft.app.jmc.utils;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import org.jcodec.common.model.Picture;
import org.jcodec.scale.AWTUtil;

public final class ImageUtils {
    private ImageUtils() {
    }

    public static Image toImage(Picture picture) {
        final var bufferedImage = AWTUtil.toBufferedImage(picture);
        final var fxImage = new WritableImage(bufferedImage.getWidth(), bufferedImage.getHeight());
        SwingFXUtils.toFXImage(bufferedImage, fxImage);

        return fxImage;
    }
}
