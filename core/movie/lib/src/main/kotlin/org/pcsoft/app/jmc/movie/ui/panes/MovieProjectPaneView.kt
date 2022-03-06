package org.pcsoft.app.jmc.movie.ui.panes

import javafx.fxml.FXML
import javafx.scene.control.Slider
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane
import org.pcsoft.framework.jfex.mvvm.FxmlView
import java.net.URL
import java.util.*

internal class MovieProjectPaneView : FxmlView<MovieProjectPaneViewModel>() {

    @FXML private lateinit var slider : Slider
    @FXML private lateinit var image : ImageView
    @FXML private lateinit var root : BorderPane

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        slider.disableProperty().bind(viewModel.file.isNull)
        slider.maxProperty().bind(viewModel.videoFrameCount)
        slider.valueProperty().bindBidirectional(viewModel.selectedVideoFrame)

        image.fitWidthProperty().bind(root.widthProperty())
        image.fitHeightProperty().bind(root.heightProperty())
        image.imageProperty().bind(viewModel.videoFrame)
    }
}