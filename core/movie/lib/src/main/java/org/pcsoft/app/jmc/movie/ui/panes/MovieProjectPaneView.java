package org.pcsoft.app.jmc.movie.ui.panes;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import org.pcsoft.framework.jfex.mvvm.FxmlView;

import java.net.URL;
import java.util.ResourceBundle;

public class MovieProjectPaneView extends FxmlView<MovieProjectPaneViewModel> {
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
}
