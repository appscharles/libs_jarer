package com.appscharles.libs.jarer.extractors;

import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.models.Package;

import java.io.IOException;
import java.net.URL;

/**
 * The type Project package url extractor.
 */
public class StandardPackageURLExtractor extends AbstractPackageURLExtractor {


    private URL locationClasses;

    /**
     * Instantiates a new Project package url extractor.
     *
     * @param aPackage the a package
     */
    public StandardPackageURLExtractor(Package aPackage, URL locationClasses) {
        super(aPackage);
        this.locationClasses = locationClasses;
    }

    public URL extract() throws JarerException {
        if (this.aPackage.getPackageURL() != null || this.aPackage.getProjectGroup() != null){
            return null;
        }
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            URL packageURL = loader.getResource(this.aPackage.getPackageName().replace(".", "/"));
            if (packageURL == null){
                return null;
            }
            if (packageURL.toString().startsWith("jar:file:/")){
                return packageURL;
            }
            if (packageURL.toString().startsWith("file:/")) {
                return new URL(this.locationClasses.toString() + this.aPackage.getPackageName().replace(".", "/"));
            }
            return null;
        } catch (IOException e) {
            throw new JarerException(e);
        }
    }

 }
