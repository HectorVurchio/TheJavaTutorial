package fileIO;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import static java.nio.file.StandardOpenOption.*;

/**
* Methods for unbuffered streams and interoperable with java.io APIs
*/
public class UnbufferedStreamIOFiles{
	void readfFileStream(){
		Path sourceFile = Paths.get(System.getProperty("user.dir"),"prueba.txt"); 
		try(InputStream in = Files.newInputStream(sourceFile);
			BufferedReader reader = new BufferedReader(new InputStream(in))){
				String line = null;
				while((line = reader.readLine()) != null){
					System.out.println(line);
				}
			}catch(IOExcepation e){
				System.err.println(e);
			}
	}
	
	void writeFileStream(){
		String s = "Hello World!";
		byte[] data = s.getBytes();
		Path p = Paths.get("./logFile.txt");
		try(OutputStream out = new BufferedOutputStream(Files.newOutputStream(p,CREATE,APPEND))){
			out.write(data,0,data.length);
		}catch(IOException e){
			System.err.println(e);
		}
	}		
}