package org.pcsoft.app.jmc.exceptions;

public class JmcDecoderException extends JmcException {
    public JmcDecoderException() {
    }

    public JmcDecoderException(String message) {
        super(message);
    }

    public JmcDecoderException(String message, Throwable cause) {
        super(message, cause);
    }

    public JmcDecoderException(Throwable cause) {
        super(cause);
    }
}
