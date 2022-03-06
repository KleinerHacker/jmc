package org.pcsoft.app.jmc.ui.windows;

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

public class MainWindowViewModel implements FxmlViewModel {
}
