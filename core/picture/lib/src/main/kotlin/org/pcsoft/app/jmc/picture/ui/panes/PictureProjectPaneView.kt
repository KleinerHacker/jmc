package org.pcsoft.app.jmc.picture.ui.panes

import javafx.fxml.FXML
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane
import org.pcsoft.framework.jfex.mvvm.FxmlView
import java.net.URL
import java.util.*

internal class PictureProjectPaneView : FxmlView<PictureProjectPaneViewModel>() {

    @FXML private lateinit var image : ImageView
    @FXML private lateinit var root : BorderPane

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        image.imageProperty().bind(viewModel.image)
        image.fitWidthProperty().bind(root.widthProperty())
        image.fitHeightProperty().bind(root.heightProperty())
    }
}