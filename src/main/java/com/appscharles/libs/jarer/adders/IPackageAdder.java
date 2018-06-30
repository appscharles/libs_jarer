package com.appscharles.libs.jarer.adders;

import com.appscharles.libs.jarer.exceptions.JarerException;

import java.util.jar.JarOutputStream;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 29.06.2018
 * Time: 10:10
 * Project name: jarer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public interface IPackageAdder {

    void add(String name, JarOutputStream jarOutputStream) throws JarerException;
}
