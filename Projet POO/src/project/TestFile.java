package project;

import java.io.IOException;

public class TestFile {
	public static void main(String[]args) throws IOException {
		Informations i = new Informations("C:\\\\Users\\\\Geoffroy\\\\Desktop\\yoyo\\hello.txt");
		Database d = new Database(i.getFileExt());
		if(!i.getFormatedSize().equals("0")) {
			System.out.println(i);
			i.getSign();
		}
		else {
			System.err.println("Size Error !");
		}
		System.out.println("Mime type de "+i.getFileExt()+" : "+d.researchMime());
		Compare c = new Compare(i.getMimeType(),d.researchMime(),i.getSign(),d.researchSign());
		System.out.println(c);
		
		Logs l = new Logs(i,c.toString());
		System.out.println(l);
		l.textSave();
	}
}
