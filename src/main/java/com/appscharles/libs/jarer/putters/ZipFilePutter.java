package com.appscharles.libs.jarer.putters;

import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.models.Dependency;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 13.07.2018
 * Time: 21:02
 * Project name: jarer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class ZipFilePutter implements IZipEntryPutter {

    @Override
    public void put(Dependency dependency, ZipEntry zipEntry, JarOutputStream jos, List<String> addedZipEntryNames) throws JarerException {
        try {
            if (zipEntry.getName().startsWith(dependency.getResource()) == false){
                return;
            }
            if (addedZipEntryNames.contains(zipEntry.getName())){
                return;
            }
            addedZipEntryNames.add(zipEntry.getName());
            ZipFile zipfile = new ZipFile(new File(dependency.getLocation().toURI()));
            InputStream inputStream = zipfile.getInputStream(zipEntry);
            JarEntry jarEntry = new JarEntry(zipEntry.getName());
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
