/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//@this file contains code to organize various file types into their respective folders
//@such as Music, Videos and Documents.
package filetool;

import java.io.File;
import java.io.IOException;
//import java.lang.reflect.Array;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*import sources.FileUtil;
import static sources.FileUtil.ff;
import static sources.FileUtil.fflist;
import static sources.FileUtil.fss;
import static sources.FileUtil.sts;*/
/**
 *
 * @author Abummoja
 */
public class FileOrganizer {

    static String sts;
    static String files[] = {""};
    static List<String> fileList = new ArrayList<>(Arrays.asList(files));

    //get files by extension. Not recursive for subfolders (TODO)
    public String[] iterateAndFilter(String mpath, String ext) throws IOException {
        Path dir = Paths.get(mpath);
        PathMatcher imageFileMatcher
                = FileSystems.getDefault().getPathMatcher(
                        ext);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir,
                entry -> imageFileMatcher.matches(entry.getFileName()))) {
            for (Path path : stream) {
                System.out.println(path.getFileName());
                System.out.println(path.toString());
                fileList.add(path.toString());
                // sts = "Moved "+ext+" files from "+mpath;
                //sts = "\nFound: "+fflist.size()+" files of type "+ext;
            }
        }
        files = fileList.toArray(new String[fileList.size()]);
        System.out.println(files.length);
        //fss should be a variable to receive the directory path due to current file extension
        //fss = "C:\\Users\\User\\Music";
        // moveF(fss);
        return files;
    }

    //same as above, but i dont wanna break by removing since i dont know where it is used
    public void listFiles(String type, String dir) throws IOException {
        iterateAndFilter(dir, type);
    }
    
    //useage: to clear the list of files of a certain extension and call the iterateFilter method again to get files
    public void clearList(){
        fileList.clear();
        files = fileList.toArray(new String[fileList.size()]);
    }
    
    //move files from one dir to another
    public static void moveFiles(String morig, String mdest) throws IOException {

        File orig = new File(morig);
        File dest = new File(mdest);
        String orr = orig.getAbsolutePath();
        String nf = dest.getAbsolutePath();
        String nm = orig.getName();
        //nf is dir and nm is original file name the\\ take the file into the dir not at dir level
        File fin = new File(nf+"\\"+nm);
        System.out.println("\nnf is "+nf+" nm is "+nm);
        System.out.println("\n==> "+fin.getAbsolutePath());
        if(dest.isDirectory()){
        orig.renameTo(fin);
        sts = fin.getAbsolutePath();
        }else{
            System.err.println("not a directory"+dest.getAbsolutePath());
        }
    }
    
    //just a quick write up to move string[] of files to new destination
    public void moveFi(String destina, String[] ff) throws IOException{
        int i = 0;
        for (String t : ff) {
            i+=1;
            System.out.println("\nmoving from "+t+" to "+destina);
            moveFiles(t, destina);
            sts += "\nmoved "+i+" files.";
        }
    }
    
    //sample code to GET number of files of type in a certain dir
     /**public void organizerMain() {
        // TODO add your handling code here:
        orgState.setText("Wait...");
        String fss1 = orgDestDir.getText();
       if ("".equals(fss1)) {
            orgDestDir.setText("You must select a folder to operate.");
        } else {
            orgBtn.setVisible(true);
            orgState.setText("Processing files...");
            String fss = "C:\\Users\\" + user + "\\Documents";

            //fss1 should be the value of dir text
            //music
            loadF(FileUtil.archex, fss1);
            zips = fo.files;
            orgDirInfo.setText("Found: " + zips.length + " archives.");
            fo.clearList();
            for (String sg : zips) {
                System.out.println(sg);
            }
            orgProgBar.setValue(20);
            fo.clearList();
            //audio
            loadF(FileUtil.audex, fss1);
            auds = fo.files;
            orgDirInfo.setText(orgDirInfo.getText() + "\n" + "Found: " + auds.length + " music.");
            fo.clearList();
            for (String sg : auds) {
                System.out.println(sg);
            }
            orgProgBar.setValue(20 + orgProgBar.getValue());
            fo.clearList();
            //videos
            loadF(FileUtil.videx, fss1);
            vids = fo.files;
            orgDirInfo.setText(orgDirInfo.getText() + "\n" + "Found: " + vids.length + " videos.");
            fo.clearList();
            for (String sg : vids) {
                System.out.println(sg);
            }
            orgProgBar.setValue(20 + orgProgBar.getValue());
            fo.clearList();
            //pictures
            loadF(FileUtil.picex, fss1);
            pics = fo.files;
            orgDirInfo.setText(orgDirInfo.getText() + "\n" + "Found: " + pics.length + " pictures.");
            fo.clearList();
            for (String sg : pics) {
                System.out.println(sg);
            }
            orgProgBar.setValue(20 + orgProgBar.getValue());
            fo.clearList();
            //documents
            loadF(FileUtil.docex, fss1);
            docs = fo.files;
            orgDirInfo.setText(orgDirInfo.getText() + "\n" + "Found: " + docs.length + " documents.");
            fo.clearList();
            for (String sg : docs) {
                System.out.println(sg);
            }
            orgProgBar.setValue(20 + orgProgBar.getValue());
            fo.clearList();
            //apps
            loadF(FileUtil.appex, fss1);
            iapps = fo.files;
            orgDirInfo.setText(orgDirInfo.getText() + "\n" + "Found: " + iapps.length + " executables.");
            fo.clearList();
            for (String sg : iapps) {
                System.out.println(sg);
            }
            orgProgBar.setValue(10 + orgProgBar.getValue());
            fo.clearList();
            orgProgBar.setIndeterminate(false);
            orgProgBar.setMaximum(100);
            orgProgBar.setValue(100);
            //dmg.setVisible(false);
        }

    }**/
    
    //sample usage of ORGANIZING the files as processed above, it is recommended to first GET files as shown above
    /**private void orgBtnMouseClicked(java.awt.event.MouseEvent evt) {                                    
        // TODO add your handling code here:
        String fss = "C:\\Users\\" + user + "\\Music";
        String o = orgDestDir.getText();
        try {
            fo.moveFi(uss.getDir("aar"), zips);
            orgCmplete.setText("Moved: " + zips.length + " archives");
            fo.moveFi(uss.getDir("mp4"), vids);
            orgCmplete.setText(orgCmplete.getText() + "\nMoved: " + vids.length + " videos");
            fo.moveFi(uss.getDir("mp3"), auds);
            orgCmplete.setText(orgCmplete.getText() + "\nMoved: " + auds.length + " Music");
            fo.moveFi(uss.getDir("doc"), docs);
            orgCmplete.setText(orgCmplete.getText() + "\nMoved: " + docs.length + " Documents");
            fo.moveFi(uss.getDir("app"), iapps);
            orgCmplete.setText(orgCmplete.getText() + "\nMoved: " + iapps.length + " executables");
            fo.moveFi(uss.getDir("pic"), pics);
            orgCmplete.setText(orgCmplete.getText() + "\nMoved: " + pics.length + " pics");
            //orgCmplete.setText("Success!");
        } catch (IOException ex) {
            orgCmplete.setText(ex.getMessage());
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateOldList(o);
    }   **/
}
