package project;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

public class FilesWalk {
	
    public static void main(String[] args) throws IOException {

        String dirName = "C:\\Users\\Geoffroy\\Desktop\\JcE Pierre";

        Path path = Paths.get(dirName);
        DirectoryStream<Path> stream = Files.newDirectoryStream(path);
        try {
        	Iterator<Path> iterator = stream.iterator();
        	while(iterator.hasNext()) {
        		Path p = iterator.next();
        		//System.out.println(p);
        		Informations i = new Informations(p.toString());
        		System.out.println(i);
        		Database d = new Database(i.getFileExt());
        		Compare c = new Compare(i.getMimeType(),d.researchMime(),i.getSign(),d.researchSign());
        		Logs s = new Logs(i,c.toString());
        		System.out.println(c);
        	}
        } finally {
        	stream.close();
        }
        
        
    }
}
