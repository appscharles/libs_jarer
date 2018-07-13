package com.appscharles.libs.jarer.putters;

import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.models.Dependency;

import java.io.IOException;
import java.util.List;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 13.07.2018
 * Time: 21:02
 * Project name: jarer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class ZipDirectoryPutter implements IZipEntryPutter {

    @Override
    public void put(Dependency dependency, ZipEntry zipEntry, JarOutputStream jos, List<String> addedZipEntryNames) throws JarerException {
        try {
            if (zipEntry.getName().startsWith(dependency.getResource()) == false){
                return;
            }
            if (addedZipEntryNames.contains(zipEntry.getName()) == false){
                jos.putNextEntry(zipEntry);
                addedZipEntryNames.add(zipEntry.getName());
            }
        } catch (IOException e) {
            throw new JarerException(e);
        }


    }
}
