package com.appscharles.libs.jarer.adders;

import java.util.jar.JarOutputStream;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 29.06.2018
 * Time: 11:25
 * Project name: jarer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public abstract class AbstractAdder implements IAdder {

    protected JarOutputStream jarOutputStream;

    public AbstractAdder(JarOutputStream jarOutputStream) {
        this.jarOutputStream = jarOutputStream;
    }
}
