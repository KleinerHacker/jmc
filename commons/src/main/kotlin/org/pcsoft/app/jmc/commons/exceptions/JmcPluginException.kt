package org.pcsoft.app.jmc.commons.exceptions

open class JmcPluginException : JmcException {
    constructor() : super()
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
    constructor(cause: Throwable?) : super(cause)
}