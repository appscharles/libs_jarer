package com.appscharles.libs.jarer.putters;

import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.models.Dependency;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 13.07.2018
 * Time: 21:02
 * Project name: jarer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class UnpackFilePutter implements IFilePutter {

    @Override
    public void put(Dependency dependency, File file, JarOutputStream jos, List<String> addedZipEntryNames) throws JarerException {
        try {
            String locationDirPath = new File(dependency.getLocation().toURI()).getAbsolutePath();
            String filePath = file.getAbsolutePath();
            String jarEntryName = filePath.replace(locationDirPath, "").replace("\\", "/");
            if (jarEntryName.startsWith("/")){
                jarEntryName = jarEntryName.substring(1);
            }
            if (jarEntryName.startsWith(dependency.getResource()) == false){
                return;
            }
            if (addedZipEntryNames.contains(jarEntryName)){
                return;
            }
            addedZipEntryNames.add(jarEntryName);
            InputStream inputStream = new FileInputStream(file);
            JarEntry jarEntry = new JarEntry(jarEntryName);
            jos.putNextEntry(jarEntry);
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = inputStream.read(buffer, 0, buffer.length)) != -1) {
                jos.write(buffer, 0, len);
            }
            jos.closeEntry();
        } catch (IOException | URISyntaxException e) {
            throw new JarerException(e);
        }
    }
}
