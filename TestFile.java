package test2projet;

import java.io.File;
import java.io.IOException;


public class TestFile {
	public static void main(String[]args) throws IOException {
		Informations i = new Informations("C:\\Users\\lespi\\Desktop\\photos\\photo_1500386914040.jpg");
		Database d = new Database(i.getFileExt());
		if(!i.getFormatedSize().equals("0")) {
			System.out.println(i);
			i.getSign();
		}
		else {
			System.err.println("Size Error !");
		}
		if (d.getExtension().contentEquals(".png")) {
			DimImage f = new DimImage(i);
			System.out.println(f.toString());
		}
		System.out.println("Mime type de "+i.getFileExt()+" : "+d.researchMime());
		Compare c = new Compare(i.getMimeType(),d.researchMime(),i.getSign(),d.researchSign());
		System.out.println(c);
		Saving s = new Saving(i, c);
		Serialization ser = new Serialization(s);
		/*Logs l = new Logs(i,c.toString());
		System.out.println(l);
		l.textSave(); */
	}
}