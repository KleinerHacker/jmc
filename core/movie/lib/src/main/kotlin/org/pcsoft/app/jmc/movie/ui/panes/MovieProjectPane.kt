package org.pcsoft.app.jmc.movie.ui.panes

import javafx.scene.layout.BorderPane
import org.pcsoft.framework.jfex.mvvm.Fxml
import java.io.File

class MovieProjectPane(file: File) : BorderPane() {

    private val viewController: MovieProjectPaneView
    private val viewModel: MovieProjectPaneViewModel

    init {
        val tuple = Fxml.from(MovieProjectPaneView::class.java).withRoot(this).load()
        viewController = tuple.viewController
        viewModel = tuple.viewModel

        viewModel.file.set(file)
    }

    val file get() = viewModel.file
}