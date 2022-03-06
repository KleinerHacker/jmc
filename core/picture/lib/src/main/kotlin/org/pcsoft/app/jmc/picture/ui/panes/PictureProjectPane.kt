package org.pcsoft.app.jmc.picture.ui.panes

import javafx.scene.layout.BorderPane
import org.pcsoft.framework.jfex.mvvm.Fxml
import java.io.File

class PictureProjectPane(file: File) : BorderPane() {
    private val viewController: PictureProjectPaneView
    private val viewModel: PictureProjectPaneViewModel

    init {
        val tuple = Fxml.from(PictureProjectPaneView::class.java).withRoot(this).load()
        viewController = tuple.viewController
        viewModel = tuple.viewModel

        viewModel.file.set(file)
    }

    val file get() = viewModel.file
}