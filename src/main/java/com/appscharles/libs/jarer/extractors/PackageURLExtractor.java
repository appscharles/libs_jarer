package com.appscharles.libs.jarer.extractors;

import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.models.Package;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;

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
     * @throws MalformedURLException the malformed url exception
     */
    public static URL extract(Package aPackage, URL locationClasses) throws MalformedURLException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL packageURL = loader.getResource(aPackage.getName().replace(".", "/"));
        if (packageURL.toString().startsWith("file:/")){
            return new URL(locationClasses.toString()  + aPackage.getName().replace(".", "/"));
        } else {
            return packageURL;
        }
    }

    /**
     * Extract url.
     *
     * @param aPackage the a package
     * @return the url
     * @throws IOException    the io exception
     * @throws JarerException the jarer exception
     */
    public static URL extract(Package aPackage) throws IOException, JarerException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> packageURLs = loader.getResources(aPackage.getName().replace(".", "/"));
        while(packageURLs.hasMoreElements()){
            URL url = packageURLs.nextElement();
            if (url.toString().replace("\\", "/").contains(aPackage.getProjectGroup() + "/" + aPackage.getProjectArtifact())){
                return url;
            }
        }
        throw new JarerException("Not found package in project group "+ aPackage.getProjectGroup() + " in project artifact "+ aPackage.getProjectArtifact());
    }
}
