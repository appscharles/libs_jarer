package com.appscharles.libs.jarer.extractors;

import com.appscharles.libs.jarer.exceptions.JarerException;

import java.net.URL;

/**
 * The interface Package url extractor.
 */
public interface IPackageURLExtractor {
    /**
     * Extract url.
     *
     * @return the url
     */
    URL extract() throws JarerException;
}
