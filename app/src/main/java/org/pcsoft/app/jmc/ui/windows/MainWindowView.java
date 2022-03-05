package org.pcsoft.app.jmc.ui.windows;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import org.pcsoft.app.jmc.exceptions.JmcException;
import org.pcsoft.framework.jfex.mvvm.FxmlView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowView extends FxmlView<MainWindowViewModel> {

    @FXML
    private BorderPane root;
    @FXML
    private ImageView image;
    @FXML
    private Slider slider;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        slider.disableProperty().bind(viewModel.fileProperty().isNull());
        slider.maxProperty().bind(viewModel.videoFrameCountProperty());
        slider.valueProperty().bindBidirectional(viewModel.selectedVideoFrameProperty());

        image.fitWidthProperty().bind(root.widthProperty());
        image.fitHeightProperty().bind(root.heightProperty());
        image.imageProperty().bind(viewModel.videoFrameProperty());
    }

    @FXML
    private void onOpen(ActionEvent actionEvent) {
        final var fileChooser = new FileChooser();
        fileChooser.setTitle("Open MP4 Video");
        fileChooser.getExtensionFilters().setAll(
                new FileChooser.ExtensionFilter("MP4 Movies", "*.mp4")
        );

        final var file = fileChooser.showOpenDialog(slider.getScene().getWindow());
        if (file != null) {
            try {
                viewModel.setFile(file);
            } catch (JmcException e) {
                new Alert(Alert.AlertType.ERROR, "Unable to load file!", ButtonType.OK).showAndWait();
            }
        }
    }
}
