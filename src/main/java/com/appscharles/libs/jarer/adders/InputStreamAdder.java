package com.appscharles.libs.jarer.adders;

import com.appscharles.libs.jarer.exceptions.JarerException;

import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

/**
 * The type Input stream adder.
 */
public class InputStreamAdder extends AbstractAdder {

    private String jarEntryPath;

    private InputStream inputStream;

    /**
     * Instantiates a new Input stream adder.
     *
     * @param jarEntryPath    the jar entry path
     * @param inputStream     the input stream
     * @param jarOutputStream the jar output stream
     */
    public InputStreamAdder(String jarEntryPath, InputStream inputStream, JarOutputStream jarOutputStream) {
        super(jarOutputStream);
        this.jarEntryPath = jarEntryPath;
        this.inputStream = inputStream;
    }

    public void add() throws JarerException {
        try {
            JarEntry jarEntry = new JarEntry(this.jarEntryPath);
            this.jarOutputStream.putNextEntry(jarEntry);
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = this.inputStream.read(buffer, 0, buffer.length)) != -1) {
                this.jarOutputStream.write(buffer, 0, len);
            }
            this.jarOutputStream.closeEntry();
        } catch (IOException e) {
            throw new JarerException(e);
        }
    }
}
