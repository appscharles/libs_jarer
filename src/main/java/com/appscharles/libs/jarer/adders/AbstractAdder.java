package com.appscharles.libs.jarer.adders;

import java.util.jar.JarOutputStream;

/**
 * The type Abstract adder.
 */
public abstract class AbstractAdder implements IAdder {

    /**
     * The Jar output stream.
     */
    protected JarOutputStream jarOutputStream;

    /**
     * Instantiates a new Abstract adder.
     *
     * @param jarOutputStream the jar output stream
     */
    public AbstractAdder(JarOutputStream jarOutputStream) {
        this.jarOutputStream = jarOutputStream;
    }
}
