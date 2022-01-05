package solutions.hard;

import java.util.ArrayList;
import java.util.List;

public class ShortenPath {
    // This is one solution. The better solution could be using stack.
    public static String shortenPath(String path) {
        // Handle few edge cases.
        while (path.contains("/./")) {
            path = path.replace("/./", "/");
        }
        while (path.contains("//")) {
            path = path.replace("//", "/");
        }
        if(path.endsWith("/.")) {
            path = path.substring(0, path.length()-2);
        }

        /*
        /foo/../test/../test/../foo/bar/baz
         */
        List<String> initialDirectoryList = new ArrayList<>();
        if(path.startsWith("/")) {
            initialDirectoryList.add("/");
        }
        String[] splittedStr = path.split("/");
        for(String v : splittedStr) {
            if(v.trim().length() == 0 || v.equals(".")) {
                continue;
            }
            initialDirectoryList.add(v);
        }
        List<String> finalDirectoryList = new ArrayList<>();
        for(String dir : initialDirectoryList) {
            if(!dir.equals("..")) {
                finalDirectoryList.add(dir);
            } else {
                if(finalDirectoryList.size() > 0) {
                    int lastIndex = finalDirectoryList.size()-1;
                    String lastElementOfFinalDirList = finalDirectoryList.get(lastIndex);
                    if(lastElementOfFinalDirList.equals("..")) {
                        finalDirectoryList.add("..");
                    } else {
                        if(!lastElementOfFinalDirList.equals("/")) {
                            finalDirectoryList.remove(lastIndex);
                        }
                        // else do nothing
                    }
                } else {
                    finalDirectoryList.add("..");
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        if(finalDirectoryList.get(0).equals("/")) {
            builder.append("/");
        } else {
            builder.append(finalDirectoryList.get(0));
            builder.append("/");
        }
        for(int i = 1;i<finalDirectoryList.size()-1;i++) {
            builder.append(finalDirectoryList.get(i));
            builder.append("/");
        }
        int lastIndex = finalDirectoryList.size() - 1;
        if(lastIndex > 0) {
            builder.append(finalDirectoryList.get(finalDirectoryList.size() - 1));
        }
        int lastIndexOfBuilder = builder.length() - 1;
        if(lastIndexOfBuilder >0 && builder.charAt(lastIndexOfBuilder) == '/') {
            builder.deleteCharAt(lastIndexOfBuilder);
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        String path = "./foo/bar";
        System.out.println(shortenPath(path));
        // /./././  -> /./
    }
}
