package com.appscharles.libs.jarer.adders;

import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.preparators.PathPreparator;
import com.appscharles.libs.jarer.models.PathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;

/**
 * The type Package adder.
 */
public class PackageAdder extends AbstractAdder {


    /**
     * The Path resources.
     */
    public List<PathResource> pathResources;

    /**
     * Instantiates a new Package adder.
     *
     * @param pathResources   the path resources
     * @param jarOutputStream the jar output stream
     */
    public PackageAdder(List<PathResource> pathResources, JarOutputStream jarOutputStream) {
        super(jarOutputStream);
        this.pathResources = pathResources;
    }

    @Override
    public void add() throws JarerException {
        try {
            for (PathResource pathResource : this.pathResources) {
                if (pathResource.isDirectory() == false){
                    InputStream iS = this.getClass().getResourceAsStream("/" + PathPreparator.forFileJarEntry(pathResource.getPathResource()));
                    IAdder inputStreamAdder = new InputStreamAdder(PathPreparator.forFileJarEntry(pathResource.getPathResource()), iS, this.jarOutputStream);
                    inputStreamAdder.add();
                } else {
                    this.jarOutputStream.putNextEntry(new ZipEntry(PathPreparator.forDirectoryJarEntry(pathResource.getPathResource())));
                }
            }
        } catch (IOException e) {
            throw new JarerException(e);
        }
    }
}