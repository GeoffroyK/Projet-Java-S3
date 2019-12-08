package test2projet;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {
	private Saving save;
	Serialization(Saving save) {
		this.save = save;
	}
	public void serializationSave(String fileName) {
		ObjectOutputStream stream;
		try {
			stream = new ObjectOutputStream(new FileOutputStream(fileName));
			stream.writeObject(save);
			stream.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
