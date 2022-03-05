package org.pcsoft.app.jmc.exceptions;

public class JmcException extends RuntimeException {
    public JmcException() {
    }

    public JmcException(String message) {
        super(message);
    }

    public JmcException(String message, Throwable cause) {
        super(message, cause);
    }

    public JmcException(Throwable cause) {
        super(cause);
    }
}
