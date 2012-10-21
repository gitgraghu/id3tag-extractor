/*
 * FileListFilter.java
 *
 * Created on August 5, 2008, 10:18 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mp3tags;
import java.io.File;
import java.io.FilenameFilter;
/**
 *
 * @author Raghu
 */
public class FileListFilter implements FilenameFilter {
private String extension; 

public FileListFilter(String extension) {this.extension = extension;}
public boolean accept(File directory, String filename) {
    boolean fileOK = true;
    if (extension != null) {fileOK &= filename.endsWith('.' + extension);}
    return fileOK;
  }
}


    

