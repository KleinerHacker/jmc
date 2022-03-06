package org.pcsoft.app.jmc.picture.plugins.api

interface PicturePlugin

interface PictureEffectPlugin : PicturePlugin {
    fun calculateEffect()
}

interface PictureRendererPlugin : PicturePlugin {
    fun calculateRendering()
}