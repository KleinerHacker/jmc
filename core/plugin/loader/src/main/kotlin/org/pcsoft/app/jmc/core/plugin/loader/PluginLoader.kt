package org.pcsoft.app.jmc.core.plugin.loader

import org.pcsoft.app.jmc.commons.exceptions.JmcPluginAnnotationException
import org.pcsoft.app.jmc.core.plugin.api.Plugin
import org.pcsoft.app.jmc.core.plugin.api.PluginInfo
import java.io.File
import java.io.FileFilter
import java.net.URLClassLoader
import java.util.*
import kotlin.reflect.KClass

class PluginLoader<T>(
        val pluginClass: KClass<T>
) where T : Plugin {
    companion object {
        private const val pluginPathProperty: String = "jmc-plugin-path"
        private const val pluginPathDefault: String = "plugins"

        val pluginPath: File
            get() = File(System.getProperty(pluginPathProperty) ?: pluginPathDefault)

        inline fun <reified T>create() : PluginLoader<T> where T : Plugin {
            return PluginLoader(T::class)
        }
    }

    fun load(): Array<PluginData<T>> {
        val files = pluginPath.listFiles(FileFilter { it.isFile && it.name.endsWith(".jar", true) })
                ?: return emptyArray()
        val urlClassLoader = URLClassLoader(files.map { it.toURI().toURL() }.toTypedArray())

        val serviceLoader = ServiceLoader.load(pluginClass.java, urlClassLoader)
        return serviceLoader
                .map {
                    val annotation = it::class.java.getAnnotation(PluginInfo::class.java)
                            ?: throw JmcPluginAnnotationException(it::class, PluginInfo::class, pluginClass.simpleName ?: "<unknown>")

                    PluginData<T>(annotation.name, annotation.description, it)
                }
                .toTypedArray()
    }

}

data class PluginData<T>(
        val name: String,
        val description: String,
        val instance: T
) where T : Plugin