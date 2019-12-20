package project;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Serialization extends FilesWalk {
	private String filename = "C:\\Users\\lespi\\Desktop\\Dostemoin\\";
	
	Serialization(Saving save, String filename) {
		super(filename);
		this.filename += filename;
	}
	
	public String serializationSave() {
		ObjectOutputStream stream;
		try {
			stream = new ObjectOutputStream(new FileOutputStream(filename));
			for (Saving save : getSavings()) {
				stream.writeObject(save);
			}
			stream.close();
			return filename + "a été sérialisé avec succès.";
		} catch (FileNotFoundException e) {
			return e.getMessage();
		} catch (IOException e) {
			return e.getMessage();
		}
	}	
}
