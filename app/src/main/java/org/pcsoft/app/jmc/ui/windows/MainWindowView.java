package org.pcsoft.app.jmc.ui.windows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import org.pcsoft.app.jmc.commons.exceptions.JmcException;
import org.pcsoft.app.jmc.movie.ui.panes.MovieProjectPane;
import org.pcsoft.app.jmc.picture.ui.panes.PictureProjectPane;
import org.pcsoft.framework.jfex.mvvm.FxmlView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowView extends FxmlView<MainWindowViewModel> {
    @FXML
    private TabPane tabProjects;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void onMovieProject(ActionEvent actionEvent) {
        final var fileChooser = new FileChooser();
        fileChooser.setTitle("Open MP4 Video");
        fileChooser.getExtensionFilters().setAll(
                new FileChooser.ExtensionFilter("MP4 Movies", "*.mp4")
        );

        final var file = fileChooser.showOpenDialog(tabProjects.getScene().getWindow());
        if (file != null) {
            tabProjects.getTabs().add(new Tab(file.getName(), new MovieProjectPane(file)));
        }
    }

    @FXML
    private void onPictureProject(ActionEvent actionEvent) {
        final var fileChooser = new FileChooser();
        fileChooser.setTitle("Open Picture");
        fileChooser.getExtensionFilters().setAll(
                new FileChooser.ExtensionFilter("Portable Network Graphic", "*.png"),
                new FileChooser.ExtensionFilter("JPEG", "*.jpg", "*.jpeg"),
                new FileChooser.ExtensionFilter("Bitmap", "*.bmp")
        );

        final var file = fileChooser.showOpenDialog(tabProjects.getScene().getWindow());
        if (file != null) {
            tabProjects.getTabs().add(new Tab(file.getName(), new PictureProjectPane(file)));
        }
    }
}
