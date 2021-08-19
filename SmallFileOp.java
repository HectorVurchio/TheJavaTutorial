package fileIO;
import java nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SmallFileOp{
	void readWrite(){
		Path sourceFile = Paths.get(System.getProperty("user.dir"),"prueba.txt");
		byte[] fileArray = Files.readAllBytes(sourceFile);
		Path tagetFile = Paths.get(System.getProperty("user.dir"),"target.txt");
		Files.write(targetFile,fileArray);
	}
}