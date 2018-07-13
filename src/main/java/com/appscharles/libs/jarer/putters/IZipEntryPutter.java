package com.appscharles.libs.jarer.putters;

import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.models.Dependency;

import java.util.List;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;

/**
 * The interface Zip entry putter.
 */
public interface IZipEntryPutter {

    /**
     * Put.
     *
     * @param dependency         the dependency
     * @param entry              the entry
     * @param jos                the jos
     * @param addedZipEntryNames the added zip entry names
     * @throws JarerException the jarer exception
     */
    void put(Dependency dependency, ZipEntry entry, JarOutputStream jos, List<String> addedZipEntryNames) throws JarerException;
}
