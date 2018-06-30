package com.appscharles.libs.jarer.exceptions;

/**
 * The type Updater exception.
 */
public class JarerException extends Exception {
    /**
     * The Serial version uid.
     */
    static final long serialVersionUID = 7821375828146020432L;

    /**
     * Instantiates a new Updater exception.
     */
    public JarerException() {
        super();
    }

    /**
     * Instantiates a new Updater exception.
     *
     * @param message the message
     */
    public JarerException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Updater exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public JarerException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Updater exception.
     *
     * @param cause the cause
     */
    public JarerException(Throwable cause) {
        super(cause);
    }
}

