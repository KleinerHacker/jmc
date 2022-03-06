package org.pcsoft.app.jmc.picture.ui.panes

import javafx.beans.binding.Bindings
import javafx.beans.binding.ObjectBinding
import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.scene.image.Image
import org.apache.commons.io.FileUtils
import org.pcsoft.framework.jfex.mvvm.FxmlViewModel
import java.io.File

internal class PictureProjectPaneViewModel : FxmlViewModel {
    val file: ObjectProperty<File> = SimpleObjectProperty()

    val image: ObjectBinding<Image>

    init {
        image = Bindings.createObjectBinding(
                { if (file.get() == null || !file.get().exists() || !file.get().isFile) null else Image(FileUtils.openInputStream(file.get())) },
                file
        )
    }
}