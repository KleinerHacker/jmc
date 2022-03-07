package org.pcsoft.app.jmc.picture.plugins.impl.basic.effects

import javafx.scene.paint.Color
import org.pcsoft.app.jmc.commons.plugins.PluginInfo
import org.pcsoft.app.jmc.picture.plugins.api.PictureEffectPlugin

@PluginInfo(name = "Gray Scale", description = "Gray Scale Effect")
class GrayScaleEffect : PictureEffectPlugin {
    override fun calculateEffect(colorGrid: Array<Array<Color>>, x: UInt, y: UInt): Color {
        val color = colorGrid[x.toInt()][y.toInt()]
        return color.grayscale()
    }
}