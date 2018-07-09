package com.appscharles.libs.jarer.extractors;

import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.models.Package;

import java.net.URL;

/**
 * The type Package url extractor.
 */
public class PackageURLExtractor {

    /**
     * Extract url.
     *
     * @param aPackage        the a package
     * @param locationClasses the location classes
     * @return the url
     * @throws JarerException the jarer exception
     */
    public static URL extract(Package aPackage, URL locationClasses) throws JarerException {
        for (IPackageURLExtractor packageURLExtractor : PackageURLExtractors.getAll(aPackage, locationClasses)) {
            URL packageURL = packageURLExtractor.extract();
            if (packageURL != null){
                return packageURL;
            }
        }
        throw new JarerException("Not found package: " + aPackage.getPackageName());
    }
}
