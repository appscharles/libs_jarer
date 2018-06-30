package com.appscharles.libs.jarer.preparators;

/**
 * The type Path preparator.
 */
public class PathPreparator {

    /**
     * For jar entry string.
     *
     * @param clazz the clazz
     * @return the string
     */
    public static String forJarEntry(Class clazz){
        String name = clazz.getName();
        return name.replace(".", "/") + ".class";
    }

    /**
     * For jar entry directory string.
     *
     * @param relativeDirPath the relative dir path
     * @return the string
     */
    public static String forFileJarEntry(String relativeDirPath) {
        relativeDirPath = relativeDirPath.replace("\\", "/");
        if (relativeDirPath.startsWith("/")){
            relativeDirPath = relativeDirPath.substring(1);
        }
        return relativeDirPath;
    }

    public static String forDirectoryJarEntry(String relativeDirPath) {
        relativeDirPath = relativeDirPath.replace("\\", "/");
        if (relativeDirPath.startsWith("/")){
            relativeDirPath = relativeDirPath.substring(1);
        }
        if (relativeDirPath.endsWith("/") == false){
            relativeDirPath = relativeDirPath +"/";
        }
        return relativeDirPath;
    }
}
