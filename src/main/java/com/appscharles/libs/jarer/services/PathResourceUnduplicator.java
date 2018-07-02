package com.appscharles.libs.jarer.services;

import com.appscharles.libs.jarer.models.PathResource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * The type Path resource unduplicator.
 */
public class PathResourceUnduplicator {


    /**
     * Unduplicate list.
     *
     * @param pathResources the path resources
     * @return the list
     */
    public static List<PathResource> unduplicate(List<PathResource> pathResources) {
        return pathResources.stream().collect(collectingAndThen(toCollection(() -> new TreeSet<>(Comparator.comparing(PathResource::getPathResource))), ArrayList::new));
    }
}
