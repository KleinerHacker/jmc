package org.pcsoft.app.jmc.commons

import org.junit.Test
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.javaGetter

class JmcIconTest {
    @Test
    fun testAll() {
        for (nestedClass in JmcIcon::class.nestedClasses) {
            println("Class " + nestedClass.simpleName)
            println("======" + "=".repeat(nestedClass.simpleName?.length ?: 0))
            for (memberProperty in nestedClass.memberProperties) {
                println(">>> " + memberProperty.name)
                memberProperty.javaGetter?.invoke(nestedClass.objectInstance)
            }
            println("======" + "=".repeat(nestedClass.simpleName?.length ?: 0))
            println()
        }
    }
}