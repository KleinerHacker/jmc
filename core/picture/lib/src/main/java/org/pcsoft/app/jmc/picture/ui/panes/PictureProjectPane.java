package org.pcsoft.app.jmc.picture.ui.panes;

import javafx.beans.property.ObjectProperty;
import javafx.scene.layout.BorderPane;
import org.pcsoft.framework.jfex.mvvm.Fxml;

import java.io.File;

public class PictureProjectPane extends BorderPane {
    private final PictureProjectPaneView viewController;
    private final PictureProjectPaneViewModel viewModel;

    public PictureProjectPane() {
        final var tuple = Fxml.from(PictureProjectPaneView.class).withRoot(this).load();
        viewController = tuple.getViewController();
        viewModel = tuple.getViewModel();
    }

    public PictureProjectPane(File file) {
        this();
        viewModel.setFile(file);
    }

    public File getFile() {
        return viewModel.getFile();
    }

    public ObjectProperty<File> fileProperty() {
        return viewModel.fileProperty();
    }

    public void setFile(File file) {
        viewModel.setFile(file);
    }
}
