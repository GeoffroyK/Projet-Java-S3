package project;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

import org.apache.tika.Tika;

/**
 * 
 * @author Geoffroy
 *
 */
public class Informations {
	
	private File file = null;

	
	public Informations(String filename) {
		file = new File(filename);
	}
	
	public File getFile() {
		return file;
	}
	
	/**
	 * Extension
	 * @return String
	 */
	public String getFileExt() {
		String filename = file.toString();
        int pos = filename.lastIndexOf(".");
        if (pos > -1) {
            return filename.substring(pos);
        } else {
            return filename;
        }
    }
	
	
	/**
	 * Taille
	 * @return String
	 */
    public String getFormatedSize() {
        int size = (int) (this.file.length() / 1024) + 1;
        if (size > 1024) {
            return (size / 1024) + " Mo";
        } else {
            return size + " ko";
        }
    }
    
    
    /**
     * Mimetype
     * @return String
     * @throws IOException
     */
    public String getMimeType() throws IOException {
		Tika tika = new Tika();
		String mimetype = tika.detect(file);
		return mimetype;
    }
    
    
    public String getSign() throws IOException {
    	BufferedReader reader = new BufferedReader(new FileReader(file));
    	String st;
    	String tmp = "";
    	while((st = reader.readLine()) != null) {
    		tmp += st;
    	}
    	return tmp;
    }
    
    /**
     * @return String
     */
    public String toString() {
    	try {
    		return "Extension : "+getFileExt()+"\nTaille : "+getFormatedSize()+"\nMime : "+getMimeType()+"\n";
    	}catch(IOException e) {
    		System.err.println("Erreur\n");
    	}
    	return("Error !\n");
    }
}