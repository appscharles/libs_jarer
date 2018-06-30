package com.appscharles.libs.jarer.adders;

import com.appscharles.libs.jarer.exceptions.JarerException;

import java.util.jar.JarOutputStream;

/**
 * The interface Package adder.
 */
public interface IPackageAdder {

    /**
     * Add.
     *
     * @param name            the name
     * @param jarOutputStream the jar output stream
     * @throws JarerException the jarer exception
     */
    void add(String name, JarOutputStream jarOutputStream) throws JarerException;
}
