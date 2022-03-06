package org.pcsoft.app.jmc.picture.ui.panes;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import org.pcsoft.framework.jfex.mvvm.FxmlView;

import java.net.URL;
import java.util.ResourceBundle;

public class PictureProjectPaneView extends FxmlView<PictureProjectPaneViewModel> {
    @FXML
    private BorderPane root;
    @FXML
    private ImageView image;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        image.imageProperty().bind(viewModel.imageProperty());
        image.fitWidthProperty().bind(root.widthProperty());
        image.fitHeightProperty().bind(root.heightProperty());
    }
}
