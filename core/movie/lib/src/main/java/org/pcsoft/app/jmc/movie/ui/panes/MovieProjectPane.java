package org.pcsoft.app.jmc.movie.ui.panes;

import javafx.beans.property.ObjectProperty;
import javafx.scene.layout.BorderPane;
import org.pcsoft.framework.jfex.mvvm.Fxml;

import java.io.File;

public class MovieProjectPane extends BorderPane {

    private final MovieProjectPaneView viewController;
    private final MovieProjectPaneViewModel viewModel;

    public MovieProjectPane() {
        final var tuple = Fxml.from(MovieProjectPaneView.class).withRoot(this).load();
        viewController = tuple.getViewController();
        viewModel = tuple.getViewModel();
    }

    public MovieProjectPane(File file) {
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
