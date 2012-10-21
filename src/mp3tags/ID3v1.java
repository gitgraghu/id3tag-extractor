/*
 * ID3v1.java
 *
 * Created on July 28, 2008, 11:18 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mp3tags;
import java.io.*;
import java.lang.*;
/**
 *
 * @author Raghu
 */
public class ID3v1 {
             
                     String Title;
                     String Artist;
                     String Album;
                     String Year;   
                  void setTitle(String title)
                  { Title=new String(title); }
                  void setArtist(String title)
                  { Artist=new String(title);}
                  void setAlbum(String title)
                  { Album=new String(title); }
                  void setYear(String title)
                  { Year=new String(title);  }
                  void GetTag(File song) throws FileNotFoundException, IOException
           {
            int size = (int)song.length();System.out.println(size);
            FileInputStream file = new FileInputStream (song); 
            file.skip(size-128);
            byte[] last128 = new byte[128];
            file.read(last128);
            String id3 = new String(last128);
            String tag=new String(id3.substring(0,3));
            if (tag.equals("TAG")) {
                this.setTitle(id3.substring(3,33));
                this.setAlbum(id3.substring(33,63));
                this.setArtist(id3.substring(63,93));
                this.setYear(id3.substring(93,98));
                } else {
                System.out.println(" does not contain ID3 info.");
                }  
                      
                  }
}
    

