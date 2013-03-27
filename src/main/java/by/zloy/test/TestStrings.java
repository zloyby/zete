package by.zloy.test;

/**
 * User: eugene
 * Date: 3/27/13
 * Time: 6:22 PM
 */
public class TestStrings {
    public static void main(String[] args) {


        String fullPathToDir = "/a/b/c/";
        String rootFolder = fullPathToDir.substring(0, fullPathToDir.length() - 1);
        if (rootFolder.length() > 0) {
            rootFolder = rootFolder.substring(rootFolder.lastIndexOf("/") + 1);
        } else {
            rootFolder = "upload from ftp";
        }
        System.out.println(rootFolder);
    }
}
