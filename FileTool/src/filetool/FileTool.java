/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package filetool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 *
 * @author Admin
 */
public class FileTool {

    /**
     * @param args the command line arguments
     */
    //common file extensions in regex, used to getFiles of a certain extension as in the iterate and filter
    //method in file organizer
    static String audex = "regex:.*(?i:mp3|ogg|avi|wav|flacc|aud|flp)";
    static String videx = "regex:.*(?i:mp4|mkv|webm|ts|wmp|mov)";
    static String picex = "regex:.*(?i:jpg|jpeg|png|gif|bmp|jpe|jfif)";
    static String docex = "regex:.*(?i:pdf|doc|txt|pptx|xls|mhtml|html|ppt|mdb|accdb|docx)";
    static String archex = "regex:.*(?i:zip|rar|7z|aar|jar|gz|tar)";
    static String appex = "regex:.*(?i:exe|com|apk|bat|msi|iso|app|sh)";

    //get file size
    public static String getFileSize(String path) {
        Path p = Paths.get(path);
        String si = "0 MB";
        try {
            // size of a file (in bytes)
            long bytes = Files.size(p);
            si = String.format("%,d MB", (bytes / 1024) / 1024);
        } catch (IOException e) {

        }
        return si;
    }
    
    //Method to remove a word from a file name
    public static String removeWord(String word, String fileName){
        File f = new File(fileName);
        boolean bool = f.exists();
       if(bool!=true){
           return "Failed With Fatal Error: File Not Found!";
       }else{
           try{
               String newName = f.getName().replaceAll(fileName, word);
               File newFile = new File(newName);
               f.renameTo(newFile);
           }catch(Exception e){
               print("Failed with message:"+e.getMessage()+"\nStack Trace: "+Arrays.toString(e.getStackTrace()));
           }
       }
        return "Success";
    }
    
    //just standard output instead of rewriting '''System.out.println(s);''' every time
    public static void print(String s){
        System.out.println(s);
    }
    
}
