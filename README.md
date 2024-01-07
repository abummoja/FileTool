# File Tool
**NB: Most of the code is PORTED from FileHandler(SWING GUI APP)**
***
Java Library to perform some extra file functions that are not implemented in the standard JDK.<br>
Made using JDK 17 and **ANT** but can also work on **any JDK** .
<br>
Very lightweight, simple function calls and straight forward function names such as the ```removeWord()``` or ```getFileSize()``` functions in the ```FileTool``` class.
<br>**No external dependencies required**
# Usage
## Classes
- FileMultiplier
  - Generate multiple copies of a file given the file name.
```
//in this example I use a mail merging list of recipients
int numberOfCopies = recipientsList.length;
FileMultiplier mMultiplier;//no constructor needed
mMultiplier.multiply(file.getName(), recipientDir(), numberOfCopies);
//Done!
```
- FileOrganizer
   - Organize files by moving them into folders based on the file extension
   ```
   FileOrganizer org = new FileOrganizer();
   String musicExtensions = (FileTool)ft.audex;
   org.iterateAndFilter(downloadsDir, musicExtensions);//returns String[]
   //or use loadF(same params)
   //throws IOException so you catch it!
   //use clearList() after iterateFilter before you run another iteration
   org.clearList();//clear the String[]
   ```
   - Move files from a dir to another.
   ```
   org.moveFiles(originalFilePath(string), newPath(string));
   ```

   - Move a ***String[ ]*** of fileNames(files) to a new directory
   ```
   //could not name moveFiles since ambiguous with above function
   org.moveFi(destination(string), fileNameArr(String[]))
   //throws IOException so catch or handle it!
   ```

- FileRenamer
    - Remove repeated word in file names from a common directory
    ```
    FileRenamer rn = new FileRenamer();
    String successStatus = rn.removeWordFromDir(dirName, wordToRemove, newWord /*or leave newWord AS EMPTY STRING to just remove word without replacing*/);
    ```

    - Remove repeated word from a list of files
    ```
    //Similar to above but instead of folder path, accepts List<File>
    rn.removeWordFromList(listOfFiles, word, new);
    ```

- FileTool
    - Get file size in MB (MEGA bytes).
    ```
    //returns STRING
    String fileSize = FileTool.getFileSize(pathToFile(string))
    ```

    ```
    FileTool.print(String);
    //simplified method for System.out.println(STRING);
    //so you can just write shorter print statements.
    ```

    - Remove a word from a single file name
    ```
    FileTool.removeWord(word, filePath(string));
    // simple
    ```

## Example Usage of Organizer
```
//process a folder to get what type of files are in it and how many (count) result as -> "Found 23 Documents...Videos...etc"
public void processDirAndFiles() {
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

}
```

After getting the dir file types info(optional), but useful to show to user you can now organize (enable the "Organize" button in your UI to allow user action) **Optional** but recommended

```
private void organizeBtnMouseClicked(java.awt.event.MouseEvent evt) {                                    
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
}
```

# TODO
 - [ ] Add Zipping and Archiving features (zip, rar, jar, jad, gzip, 7z, tar...and more) if possible hence contributions are highly welcome
 - [ ] Edit file meta-data such as Dates, Owner...and more.
### Contributing
Contributions are welcome, just clone the repo add your code then push and we'll check it out.
**Forks** are also welcome.

## Users
Do you use this in your project(s)? we'd like to know or give us a mention.
- List Of Users
    - No users yet.
