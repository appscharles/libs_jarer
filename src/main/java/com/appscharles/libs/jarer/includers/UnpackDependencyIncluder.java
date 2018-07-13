package com.appscharles.libs.jarer.includers;

import com.appscharles.libs.ioer.services.DirReader;
import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.models.Dependency;
import com.appscharles.libs.jarer.putters.UnpackDirectoryPutter;
import com.appscharles.libs.jarer.putters.UnpackFilePutter;
import com.appscharles.libs.jarer.putters.IFilePutter;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.jar.JarOutputStream;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 13.07.2018
 * Time: 20:33
 * Project name: jarer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class UnpackDependencyIncluder implements IDependencyIncluder {

    private IFilePutter unpackDirectoryPutter;

    private IFilePutter unpackFilePutter;

    public UnpackDependencyIncluder() {
        this.unpackDirectoryPutter = new UnpackDirectoryPutter();
        this.unpackFilePutter = new UnpackFilePutter();
    }

    @Override
    public void include(Dependency dependency, JarOutputStream jos, List<String> addedZipEntryNames) throws JarerException {
        try {
            File file = new File(new File(dependency.getLocation().toURI()), dependency.getResource());
            if (file.exists()==false){
                throw new JarerException("File not exist: " + file.getAbsolutePath());
            }
            if (file.isFile()){
                this.unpackFilePutter.put(dependency, file, jos, addedZipEntryNames);
            } else {
                for (File foundFile :  DirReader.getFiles(file)) {
                    if (foundFile.isFile()){
                        this.unpackFilePutter.put(dependency, foundFile, jos, addedZipEntryNames);
                    } else {
                        this.unpackDirectoryPutter.put(dependency, foundFile, jos, addedZipEntryNames);
                    }
                }
            }
        } catch (URISyntaxException | IOException e) {
            throw new JarerException(e);
        }
    }

    @Override
    public Boolean validate(Dependency dependency) {
        return dependency.getLocation().toString().endsWith("/");
    }
}
