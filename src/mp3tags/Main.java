/*
 * Main.java
 *
 * Created on August 5, 2008, 12:49 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mp3tags;

import java.io.*;
import java.lang.*;
import java.sql.* ;
import javax.swing.*;

/**
 *
 * @author Raghu
 */
public class Main {
        public static void main(String[] args) throws SQLException{
          
        DataOperation Query= new DataOperation();
        FilenameFilter selectmp3 = new FileListFilter("mp3");
      try {
            File song = new File("C://Music//Hindi & Tamil//En Chella Peru.mp3");
            if(song.isDirectory())
            { 
             File songs[]=new File[20];    
             songs=song.listFiles(selectmp3);
             ID3v1 mp3tag=new ID3v1();
             for(File mp3 : songs)
             {   
              mp3tag.GetTag(mp3);
              Query.Insert(mp3tag,mp3);
             }  
            } 
            else
            {
              ID3v1 mp3tag=new ID3v1();
              mp3tag.GetTag(song);
              Query.Insert(mp3tag,song);
             }
            
        } catch (Exception e) {
            System.out.println("Error -- " + e.toString());
        }
        //Query.Select("MUSIC");
        }
    
}




