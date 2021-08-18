package basicIO;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.logging.Logger;
import java.util.logging.Level;
/**
* This class reads text character by character
* Character Streams
*
*/
public class CopyCharacters{
	private FileReader inputStream = null;
	private FileWriter outputStream = null;
	private String source;
	private String target;
	private Logger logger;
	
	public CopyCharacters(String source,String target){
		this.source = source;
		this.target = target;
		logger = Logger.getLogger(this.getClass().getName());
	}
	/**
	* 
	* if inputStream.read()) == -1, the end of the stream has been reached
	*/
	public void operate()throws IOException,FileNotFoundException{
		try{
			inputStream = new FileReader(source);
			outputStream = new FileWriter(target);
			int c;
			while((c = inputStream.read()) != -1){outputStream.write(c);}
			System.out.println("File succesfully written ");
		}catch(FileNotFoundException fnfe){
			System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			logger.log(Level.INFO,"The file "+source+" does not exist");
			fnfe.printStackTrace();
			System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		}finally{
			if(inputStream != null){inputStream.close();}
			if(outputStream != null){outputStream.close();}
		}
	}
}

/*
javac -d . DriverIO.java CopyCharacters.java
java basicIO.DriverIO

*/