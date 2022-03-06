package org.pcsoft.app.jmc.ui.windows

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Tab
import javafx.scene.control.TabPane
import javafx.stage.FileChooser
import org.pcsoft.app.jmc.movie.ui.panes.MovieProjectPane
import org.pcsoft.app.jmc.picture.ui.panes.PictureProjectPane
import org.pcsoft.framework.jfex.mvvm.FxmlView
import java.net.URL
import java.util.*

internal class MainWindowView : FxmlView<MainWindowViewModel>() {

    @FXML private lateinit var tabProjects : TabPane

    override fun initialize(location: URL?, resources: ResourceBundle?) {

    }

    @FXML
    private fun onMovieProject(actionEvent: ActionEvent) {
        val fileChooser = FileChooser()
        fileChooser.title = "Open MP4 Video"
        fileChooser.extensionFilters.setAll(
                FileChooser.ExtensionFilter("MP4 Movies", "*.mp4")
        )
        val file = fileChooser.showOpenDialog(tabProjects.scene.window)
        if (file != null) {
            tabProjects.tabs.add(Tab(file.name, MovieProjectPane(file)))
        }
    }

    @FXML
    private fun onPictureProject(actionEvent: ActionEvent) {
        val fileChooser = FileChooser()
        fileChooser.title = "Open Picture"
        fileChooser.extensionFilters.setAll(
                FileChooser.ExtensionFilter("Portable Network Graphic", "*.png"),
                FileChooser.ExtensionFilter("JPEG", "*.jpg", "*.jpeg"),
                FileChooser.ExtensionFilter("Bitmap", "*.bmp")
        )
        val file = fileChooser.showOpenDialog(tabProjects.scene.window)
        if (file != null) {
            tabProjects.tabs.add(Tab(file.name, PictureProjectPane(file)))
        }
    }
}