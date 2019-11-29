package project2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CreerDossier {
	public static void main(String[] args) throws IOException {
		File fb = new File("C:\\Users\\lespi\\desktop\\testage"); 
		fb.mkdirs();
		System.out.println("Directory has been created.");
	}
}