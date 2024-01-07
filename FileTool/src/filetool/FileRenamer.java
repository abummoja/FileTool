/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filetool;

import java.io.File;
//import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class FileRenamer {
    //TODO: Add a renamed file counter.
    public FileRenamer(){
        //empty constructor
    }
    
    //remove a common repeated word from a list of files (entire folder)
    public String removeWordFromDir(String folderName, String ReplaceFrom, String ReplaceWith)
    {
        try
        {
        // This method will rename all files in a folder by chaning ReplaceFrom string with ReplaceWith string
        File folder=new File(folderName);
        File[] filesList=folder.listFiles();
        for (int i=0; i< filesList.length; i++)
        {
            String newName= (filesList[i].toString().replaceAll(ReplaceFrom, ReplaceWith)).trim();
            
            filesList[i].renameTo(new File(newName));
            
            
        }
        return "Successfully renamed "+filesList.length+" files.";
        }
        catch (Exception e)
        {
            return (e.getMessage());
            
        }
    }
    //remove repeated word from a list (List<File>) of file names
    public String removeWordFromList(List<File> fileList, String ReplaceFrom, String ReplaceWith)
    {
        File[] filesList = {};
        //filesList = new ArrayList<File>(fileList);
        filesList = fileList.toArray(filesList);
        try
        {
        // This method will rename all files in a folder by chaning ReplaceFrom string with ReplaceWith string
        for (int i=0; i< filesList.length; i++)
        {
            String newName= (filesList[i].toString().replaceAll(ReplaceFrom, ReplaceWith)).trim();
            filesList[i].renameTo(new File(newName));
        }
        return "Successfully renamed "+filesList.length+" files.";
        }
        catch (Exception e)
        {
            return (e.getMessage());
        }
    }
}
