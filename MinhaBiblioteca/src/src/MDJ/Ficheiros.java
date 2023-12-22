/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDJ;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author BRAVANTIC
 */
public class Ficheiros {
     private final String pathDir  = "Files";
    private FileOutputStream fos;
    
    private  boolean createDirector(){
        File dir = new File(pathDir);
        return !dir.exists() ? dir.mkdir() : false;
    }
    
    private File createClasse(String fileName){
        try { 
            File file = new File(pathDir + "/"+ fileName + ".cs");
            file.createNewFile();
            return file;
        } catch (IOException e) {
        }
        return null;
    }
    
    public void deleteFiles(){
       File dir = new File(pathDir);
       dir.delete();
       
    }
    
    public boolean addContentInFile(String fileName, StringBuilder content){
        try {
            createDirector();
            File file = createClasse(fileName);
            try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(file))) {
                buffWrite.append(content);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException ex) {
            Logger.getLogger(Ficheiros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
   public void createZipDir(){
       File dir = new File(pathDir);
       if (dir.isDirectory()) {
           try (FileOutputStream fos = new FileOutputStream(pathDir + ".zip");
                 ZipOutputStream zos = new ZipOutputStream(fos)) {

                for (File arquivo : dir.listFiles()) {
                    ZipEntry entrada = new ZipEntry(arquivo.getName());
                    zos.putNextEntry(entrada);
                    
                    FileInputStream fis = new FileInputStream(arquivo);
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = fis.read(buffer)) > 0) {
                        zos.write(buffer, 0, len);
                    }
                    fis.close();

                    zos.closeEntry();
                }
           } catch (FileNotFoundException ex) {
               Logger.getLogger(Ficheiros.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(Ficheiros.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       
   }
}
