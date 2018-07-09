package com.appscharles.libs.jarer.extractors;

import com.appscharles.libs.jarer.models.Package;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Package url extractors.
 */
public class PackageURLExtractors {

    /**
     * Get all list.
     *
     * @param aPackage        the a package
     * @param locationClasses the location classes
     * @return the list
     */
    public static List<IPackageURLExtractor> getAll(Package aPackage, URL locationClasses){
        List<IPackageURLExtractor> packageURLExtractors = new ArrayList<>();
        packageURLExtractors.add(new FilePackageURLExtractor(aPackage));
        packageURLExtractors.add(new VersionPackageURLExtractor(aPackage));
        packageURLExtractors.add(new StandardPackageURLExtractor(aPackage, locationClasses));
        return packageURLExtractors;
    }
}
