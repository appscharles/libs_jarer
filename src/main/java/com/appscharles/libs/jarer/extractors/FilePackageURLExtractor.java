package com.appscharles.libs.jarer.extractors;

import com.appscharles.libs.jarer.models.Package;

import java.net.URL;

/**
 * The type File package url extractor.
 */
public class FilePackageURLExtractor extends AbstractPackageURLExtractor {


    /**
     * Instantiates a new File package url extractor.
     *
     * @param aPackage the a package
     */
    public FilePackageURLExtractor(Package aPackage) {
        super(aPackage);
    }

    public URL extract() {
        if (this.aPackage.getPackageURL() == null){
            return null;
        }
        return this.aPackage.getPackageURL();
    }
}
