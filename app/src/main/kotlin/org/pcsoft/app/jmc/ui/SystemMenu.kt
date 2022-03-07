package org.pcsoft.app.jmc.ui

import javafx.fxml.FXMLLoader
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import javafx.util.Callback
import org.pcsoft.app.jmc.ui.windows.MainWindowView

internal class SystemMenu(controller : MainWindowView) : Menu() {
    init {
        val loader = FXMLLoader()
        loader.setRoot(this)
        loader.location = this::class.java.getResource("/org/pcsoft/app/jmc/ui/SystemMenu.fxml")
        loader.controllerFactory = Callback { controller }
        loader.load<MenuBar>()
    }
}