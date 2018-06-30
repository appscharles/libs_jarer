package com.appscharles.libs.jarer.adders;

import com.appscharles.libs.jarer.exceptions.JarerException;

import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 29.06.2018
 * Time: 10:26
 * Project name: jarer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class InputStreamAdder extends AbstractAdder {

    private String jarEntryPath;

    private InputStream inputStream;

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
