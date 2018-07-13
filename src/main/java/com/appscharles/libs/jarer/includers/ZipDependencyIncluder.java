package com.appscharles.libs.jarer.includers;

import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.models.Dependency;
import com.appscharles.libs.jarer.putters.IZipEntryPutter;
import com.appscharles.libs.jarer.putters.ZipDirectoryPutter;
import com.appscharles.libs.jarer.putters.ZipFilePutter;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 13.07.2018
 * Time: 20:33
 * Project name: jarer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class ZipDependencyIncluder implements IDependencyIncluder {

    private IZipEntryPutter zipDirectoryPutter;

    private IZipEntryPutter zipFilePutter;

    public ZipDependencyIncluder() {
        this.zipDirectoryPutter = new ZipDirectoryPutter();
        this.zipFilePutter = new ZipFilePutter();
    }

    @Override
    public void include(Dependency dependency, JarOutputStream jos, List<String> addedZipEntryNames) throws JarerException {
        try {
            ZipFile zipFile = new ZipFile(new File(dependency.getLocation().toURI()));
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            Boolean fileExist = false;
            while(entries.hasMoreElements()){
                ZipEntry entry = entries.nextElement();
                if (entry.getName().contains(dependency.getResource())){
                    fileExist = true;
                }
                if (entry.isDirectory()){
                    this.zipDirectoryPutter.put(dependency, entry, jos, addedZipEntryNames);
                } else {
                    this.zipFilePutter.put(dependency, entry, jos, addedZipEntryNames);
                }
            }
            if (fileExist == false){
                throw new JarerException("File is not found: " + dependency.getResource());
            }
        } catch ( IOException | URISyntaxException e) {
            throw new JarerException(e);
        }
    }

    @Override
    public Boolean validate(Dependency dependency) {
        return dependency.getLocation().toString().endsWith(".jar");
    }
}
