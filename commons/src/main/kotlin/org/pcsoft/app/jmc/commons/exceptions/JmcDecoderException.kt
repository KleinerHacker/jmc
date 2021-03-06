package org.pcsoft.app.jmc.commons.exceptions

class JmcDecoderException : JmcException {
    constructor()
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
    constructor(cause: Throwable?) : super(cause)
}