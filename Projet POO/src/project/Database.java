package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Database {
	private String extension = null;
	private static final String PATH = "C:\\\\Users\\\\Geoffroy\\\\eclipse-workspace\\\\Projet POO\\\\database.csv";
	
	public Database(String extension) {
		this.extension = extension;
	}
	
	public String getExtension() {
		return extension;
	}
	
	public void reader() throws IOException {
		File file = new File(PATH); 
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		while ((st = br.readLine()) != null) { 
			System.out.println(st); 
		} 
	}
	
	public String researchMime() throws IOException {
		File file = new File(PATH);
		String find = getExtension();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		String fields[];
		while((st = br.readLine()) != null) {
			fields = st.split(";");
			if(fields[0].contentEquals(find)) {
				return fields[2];
			}
		}
		return "Not in the database !\n";
	}
	
	public String researchSign() throws IOException {
		File file = new File(PATH);
		String find = getExtension();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		String fields[];
		while((st = br.readLine()) != null) {
			fields = st.split(";");
			if(fields[0].contentEquals(find)) {
				return fields[1];
			}
		}
		return "Not in the database !\n";
	}
	
}
