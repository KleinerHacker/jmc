package org.pcsoft.app.jmc;

import javafx.application.Application;
import javafx.stage.Stage;
import org.pcsoft.app.jmc.ui.windows.MainWindow;

public class Runner extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        new MainWindow().show();
    }
}
