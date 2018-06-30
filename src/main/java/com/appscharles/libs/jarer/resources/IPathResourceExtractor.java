package com.appscharles.libs.jarer.resources;

import java.io.IOException;
import java.util.List;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 29.06.2018
 * Time: 16:40
 * Project name: jarer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public interface IPathResourceExtractor {

    List<PathResource> getPathResources() throws IOException;
}
