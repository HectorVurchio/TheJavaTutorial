package fileIO;
import java.io.IOException;
import java.io.BufferedReader;
import java nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
/**
* Reading a file by using Buffered Stream I/O
*/
public class BufferedStreamIOFiles{
	void readBufferedFile(){
		Charset charset = Charset.forName("US-ASCII");
		Path sourceFile = Paths.get(System.getProperty("user.dir"),"prueba.txt");
		try(BufferedReader reader = Files.newBufferedReader(sourceFile,charset)){
			String line = null;
			while((line = reader.readLine()) != null){
				System.out.println(line);
			}
		}catch(IOException e){
			System.err.format("IOException: %s%n ",e);
		}
	}
	
	void writeBufferedFile(String s){
		Path targetFile = Paths.get(System.getProperty("user.dir"),"target.txt");
		Charset charset = Charset.forName("US-ASCII");
		try(BufferedWriter writer = Files.newBufferedWriter(targetFile,charset)){
			writer.write(s,0,s.length());
		}catch(IOException e){
			System.err.format("IOException: %s%n",e);
		}
	}
	
}