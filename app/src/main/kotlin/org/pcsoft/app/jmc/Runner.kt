package org.pcsoft.app.jmc

import javafx.application.Application
import javafx.stage.Stage
import org.pcsoft.app.jmc.ui.windows.MainWindow

class JmcApplication : Application() {
    override fun start(primaryStage: Stage?) {
        MainWindow().show()
    }
}

fun main(vararg args : String) {
    Application.launch(JmcApplication::class.java, *args)
}