package org.pcsoft.app.jmc.ui.windows

import javafx.scene.Scene
import javafx.stage.Stage
import org.pcsoft.framework.jfex.mvvm.Fxml

class MainWindow : Stage() {

    private val controller: MainWindowView
    private val model: MainWindowViewModel

    init {
        title = "Java Media Center"

        val tuple = Fxml.from(MainWindowView::class.java).load()
        scene = Scene(tuple.view, 1024.0, 800.0)

        model = tuple.viewModel
        controller = tuple.viewController
    }

}