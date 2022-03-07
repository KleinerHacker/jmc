package org.pcsoft.app.jmc

import javafx.application.Application
import javafx.stage.Stage
import org.pcsoft.app.jmc.ui.windows.MainWindow

// --add-exports javafx.graphics/com.sun.javafx.tk=ALL-UNNAMED
// --add-opens javafx.graphics/com.sun.javafx.tk.quantum=ALL-UNNAMED
// --add-exports javafx.graphics/com.sun.glass.ui=ALL-UNNAMED
// --add-exports javafx.graphics/com.sun.javafx.menu=ALL-UNNAMED
// --add-exports javafx.controls/com.sun.javafx.scene.control=ALL-UNNAMED
class JmcApplication : Application() {
    override fun start(primaryStage: Stage?) {
        MainWindow().show()
    }
}

fun main(vararg args : String) {
    System.setProperty("apple.laf.useScreenMenuBar", "true");
    Application.launch(JmcApplication::class.java, *args)
}