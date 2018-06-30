package com.appscharles.libs.jarer.adders;

import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.preparators.PathPreparator;

import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarOutputStream;

/**
 * The type Class adder.
 */
public class ClassAdder extends AbstractAdder {

    private Class clazz;

    /**
     * Instantiates a new Class adder.
     *
     * @param clazz           the clazz
     * @param jarOutputStream the jar output stream
     */
    public ClassAdder(Class clazz, JarOutputStream jarOutputStream) {
        super(jarOutputStream);
        this.clazz = clazz;
    }

    @Override
    public void add() throws JarerException {
        try (InputStream iS = this.getClass().getResourceAsStream("/" + PathPreparator.forJarEntry(this.clazz))) {
           IAdder inputStreamAdder = new InputStreamAdder(PathPreparator.forJarEntry(this.clazz), iS, this.jarOutputStream);
           inputStreamAdder.add();
        } catch (IOException e) {
            throw new JarerException(e);
        }
    }
}
