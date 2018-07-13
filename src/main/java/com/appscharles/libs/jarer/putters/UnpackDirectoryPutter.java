package com.appscharles.libs.jarer.putters;

import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.models.Dependency;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
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
public class UnpackDirectoryPutter implements IFilePutter {

    @Override
    public void put(Dependency dependency, File file, JarOutputStream jos, List<String> addedZipEntryNames) throws JarerException {
        try {
            String locationDirPath = new File(dependency.getLocation().toURI()).getAbsolutePath();
            String filePath = file.getAbsolutePath();
            String zipEntryName = filePath.replace(locationDirPath, "").replace("\\", "/");
            if (zipEntryName.startsWith("/")){
                zipEntryName = zipEntryName.substring(1);
            }
            if (zipEntryName.endsWith("/") == false){
                zipEntryName = zipEntryName +"/";
            }
            if (zipEntryName.startsWith(dependency.getResource()) == false){
                return;
            }
            if (addedZipEntryNames.contains(zipEntryName) == false){
                jos.putNextEntry(new ZipEntry(zipEntryName));
                addedZipEntryNames.add(zipEntryName);
            }
        } catch (URISyntaxException | IOException e) {
            throw new JarerException(e);
        }


    }
}
