package com.appscharles.libs.jarer.creators;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 29.06.2018
 * Time: 07:52
 * Project name: jarer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public interface IJarCreator extends ICreateable {

    void addClass(Class clazz);

    void addPackage(String name);
}
