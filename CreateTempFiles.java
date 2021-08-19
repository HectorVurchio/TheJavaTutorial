package fileIO;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.FileAlreadyExistsException;

/**
* Create an empty temporary file with an initial set of attributes
*/
public class CreateTempFiles{
	/**
	* This method allows the code to specify a directory for the temporary file
	*/
	void createRegularFile(){
		Path file = Paths.get(System.getProperty("user.dir"),"temp.txt");
		try{
			Files.createFile(file);
		}catch(FileAlreadyExistsException e){
			System.err.format("file named %s"+" already exists %n",file);
		}catch(IOException e){
			System.err.format("createFile error: %s%n", e);
		}
	}
	/**
	* This method creates a new file in the deefault temporary directory
	* After running this method, it yields:
	* The temporary file  has been created: 
	* C:\Users\HECTO_~1\AppData\Local\Temp\null5111119420323697373.myApp
	*/
	void createTempFile(){
		try{
			Path tempFile = Files.createTempFile("null",".myApp");
			System.out.format("The temporary file "+" has been created: %s%n",tempFile);
		}catch(IOException e){
			System.err.format("IOException: %s%n",e);
		}
	}
}