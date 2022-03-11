package org.pcsoft.app.jmc.ui.windows

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Menu
import javafx.scene.control.Tab
import javafx.scene.control.TabPane
import javafx.scene.image.ImageView
import javafx.stage.FileChooser
import org.apache.commons.lang.SystemUtils
import org.pcsoft.app.jmc.commons.JmcIcon
import org.pcsoft.app.jmc.movie.ui.panes.MovieProjectPane
import org.pcsoft.app.jmc.picture.ui.panes.PictureProjectPane
import org.pcsoft.framework.jfex.mvvm.FxmlView
import java.net.URL
import java.util.*

internal class MainWindowView : FxmlView<MainWindowViewModel>() {

    @FXML private lateinit var mnuMain: Menu
    @FXML private lateinit var tabProjects : TabPane

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        mnuMain.isVisible = !SystemUtils.IS_OS_MAC
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
            val tab = Tab(file.name, MovieProjectPane(file))
            tab.graphic = ImageView(JmcIcon.Media.movieFill)

            tabProjects.tabs.add(tab)
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
            val tab = Tab(file.name, PictureProjectPane(file))
            tab.graphic = ImageView(JmcIcon.Media.imageFill)

            tabProjects.tabs.add(tab)
        }
    }
}