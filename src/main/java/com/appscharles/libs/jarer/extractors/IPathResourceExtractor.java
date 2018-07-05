package com.appscharles.libs.jarer.extractors;

import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.models.PathResource;

import java.io.IOException;
import java.util.List;

/**
 * The interface Path resource extractor.
 */
public interface IPathResourceExtractor {

    /**
     * Gets path resources.
     *
     * @return the path resources
     * @throws JarerException the jarer exception
     */
    List<PathResource> getPathResources() throws JarerException;
}
