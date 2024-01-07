/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filetool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Admin
 */
public class FileMultiplier {
    //generate multiple copies of a file
    //usage: multiply(originalPath, newPath(optional), int) where int is the number of copies
    public void multiply(String orifinalFile, String newFilePath, int numberOfCopies) throws IOException {
        File origi = new File(orifinalFile);
        //File newFile = new File(newFilePath);
        Path pathh = Paths.get(orifinalFile);
        String extension = "";

        // get the file name
        String fileName = pathh.getFileName().toString();

        // split the file name into parts using the dot (.) character as separator
        String[] parts = fileName.split("\\.");

        // if there are at least two parts, the last part is the extension
        if (parts.length >= 2) {
            extension = parts[parts.length - 1];
        }

        System.out.println("File extension: " + extension);
        String origiName = origi.getName();
        int numcopies;
        if (numberOfCopies == 0) {
            //err
        } else {
            numcopies = numberOfCopies;
            for (int cp = 0; cp < numcopies; cp++) {
                String newNameWithoutExt = origiName.replaceAll(extension, "");
                String newFileCopyName = String.format(newFilePath + "\\" + newNameWithoutExt + "(%d)." + extension, cp);
                File newF = new File(newFileCopyName);
                Files.copy(origi.toPath(), newF.toPath());
            }
            //fileListCpy.setListData(vids);
        }
    }
}
