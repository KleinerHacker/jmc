package org.pcsoft.app.jmc.commons.exceptions

import kotlin.reflect.KClass

class JmcPluginAnnotationException(
        clazz: KClass<*>,
        annotationClass: KClass<*>,
        pluginType: String
) : JmcPluginException("Unable to find required annotation ${annotationClass.qualifiedName} on plugin class " +
        "${clazz.qualifiedName} for plugin $pluginType")