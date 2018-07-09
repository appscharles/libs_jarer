package com.appscharles.libs.jarer.extractors;

import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.models.Package;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * The type Dependency package url extractor.
 */
public class VersionPackageURLExtractor extends AbstractPackageURLExtractor {


    /**
     * Instantiates a new Dependency package url extractor.
     *
     * @param aPackage the a package
     */
    public VersionPackageURLExtractor(Package aPackage) {
        super(aPackage);
    }

    public URL extract() throws JarerException {
        if (this.aPackage.getVersion() == null){
            return null;
        }
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            Enumeration<URL> packageURLs = loader.getResources(this.aPackage.getPackageName().replace(".", "/"));
            while(packageURLs.hasMoreElements()){
                URL packageURL = packageURLs.nextElement();
                if (packageURL.toString().replace("\\", "/").contains(this.aPackage.getProjectGroup() + "/" + this.aPackage.getProjectArtifact() + "/" + this.aPackage.getVersion() + "/")){
                    return packageURL;
                }
            }
            return null;
        } catch (IOException e) {
            throw new JarerException(e);
        }
    }
}
