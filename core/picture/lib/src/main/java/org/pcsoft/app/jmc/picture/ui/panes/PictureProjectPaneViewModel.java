package org.pcsoft.app.jmc.picture.ui.panes;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;
import org.apache.commons.io.FileUtils;
import org.pcsoft.framework.jfex.mvvm.FxmlViewModel;

import java.io.File;

public class PictureProjectPaneViewModel implements FxmlViewModel {
    private final ObjectProperty<File> file = new SimpleObjectProperty<>();

    private final ObjectBinding<Image> image;

    public PictureProjectPaneViewModel() {
        image = Bindings.createObjectBinding(
                () -> file.get() == null || !file.get().exists() || !file.get().isFile() ? null : new Image(FileUtils.openInputStream(file.get())),
                file
        );
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

    public Image getImage() {
        return image.get();
    }

    public ObjectBinding<Image> imageProperty() {
        return image;
    }
}
