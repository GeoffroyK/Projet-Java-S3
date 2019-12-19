package project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FilesWalk2 {
	@SuppressWarnings("unused")
	private String dirpath;
	private ArrayList<String> files = new ArrayList<String>();
	private ArrayList<String> filesunzip = new ArrayList<String>();
	private static final String UNZIP = "C:\\Users\\Geoffroy\\eclipse-workspace\\Projet POO\\unzip";
    
	public FilesWalk2(String dirpath) {
    	this.dirpath = dirpath;
    	listDir(files, dirpath);
    	getAllFiles();
    }
     
	
    public void listDir(ArrayList<String> directories, String root) {
    	File f = new File(root);
    	File[] listFiles = f.listFiles();
    	for (int i = 0; i < listFiles.length; i++) {
    		if (listFiles[i].isDirectory()) {
    			listDir(directories, listFiles[i].toString());
    	    }
    	    else {
    	    	directories.add(listFiles[i].toString());
    	    }
    	}
    }
    
    public void getAllFiles() {
    	for(String s : files) {
    		System.out.println("FICHIER :"+s);
    		Informations2 i = new Informations2(s);
    		System.out.println(i);
    		if(i.getFileExt().contentEquals(".zip")) {
    			System.out.println(".zip : Décompression");
    			try {
					Unzip u = new Unzip(s,UNZIP);
					listDir(filesunzip,UNZIP);
					for(String su : filesunzip) {
						Informations2 iu = new Informations2(su);
			    		System.out.println(iu);
			    		System.out.println("\n");
					}
					File toBeDeleted = new File(UNZIP);
					if(!toBeDeleted.exists()) {
						toBeDeleted.mkdir();
					}
					u.erase(toBeDeleted);
				} catch (IOException e) {
					System.err.println(e);
				}
    		}
    		System.out.println("\n");
    	}
    }


	@Override
	public String toString() {
		return "FilesWalk2 [dirpath= \n" + dirpath + ", files= \n" + files + "]";
	}
}