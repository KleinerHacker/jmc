package org.pcsoft.app.jmc.picture.plugin

import org.pcsoft.app.jmc.core.plugin.loader.PluginData
import org.pcsoft.app.jmc.core.plugin.loader.PluginLoader
import org.pcsoft.app.jmc.picture.plugins.api.PictureEffectPlugin
import org.pcsoft.app.jmc.picture.plugins.api.PictureRendererPlugin

internal object PluginSystem {
    val effectPlugins: Array<PluginData<PictureEffectPlugin>> = PluginLoader.create<PictureEffectPlugin>().load()
    val rendererPlugins: Array<PluginData<PictureRendererPlugin>> = PluginLoader.create<PictureRendererPlugin>().load()
}