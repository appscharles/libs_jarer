package com.appscharles.libs.jarer.extractors;

import com.appscharles.libs.jarer.models.Package;

/**
 * The type Abstract package url extractor.
 */
public abstract class AbstractPackageURLExtractor implements IPackageURLExtractor {

    /**
     * The A package.
     */
    protected Package aPackage;

    /**
     * Instantiates a new Abstract package url extractor.
     *
     * @param aPackage the a package
     */
    public AbstractPackageURLExtractor(Package aPackage) {
        this.aPackage = aPackage;
    }
}
