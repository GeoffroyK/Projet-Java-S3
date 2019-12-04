package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Logs {
	private static final String SAVEPATH = "C:\\\\\\\\Users\\\\\\\\Geoffroy\\\\\\\\eclipse-workspace\\\\\\\\Projet POO\\\\\\\\save.txt";
	private GregorianCalendar date = (GregorianCalendar) GregorianCalendar.getInstance();
	private Informations info;
	private String state;
	
	
	public GregorianCalendar getDate() {
		return date;
	}
	
	public Informations getInfo() {
		return info;
	}
	
	public String getState() {
		return state;
	}
	
	public Logs(Informations info, String state) {
		this.info = info;
		this.state = state;
	}
	
	
	
	public void textSave() {
		try {
			File file = new File(SAVEPATH);
			ArrayList<String> previous = new ArrayList<String>();
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
		
			while((line = reader.readLine()) != null) {
				previous.add(line);
			}
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			for(String c : previous) {
				writer.write(c);
				writer.newLine();
			}
		
			writer.write(toString());
			writer.newLine();
			writer.close();
			System.out.println("logs saved");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	
	public String toString() {
		try {
			return "["+date.getTime().toString()+" ; "+info.getFileExt()+" ; "+info.getFormatedSize()+" ; "+info.getMimeType()+" ; "+getState();
		} catch (IOException e) {
			return(e.getMessage());
		}
	}
}
