package org.pcsoft.app.jmc.picture.plugins.api

import javafx.scene.paint.Color

interface PicturePlugin

interface PictureEffectPlugin : PicturePlugin {
    fun calculateEffect(colorGrid: Array<Array<Color>>, x : UInt, y : UInt) : Color
}

interface PictureRendererPlugin : PicturePlugin {
    fun calculateRendering(x : UInt, y : UInt) : Color
}