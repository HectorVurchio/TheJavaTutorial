package basicIO;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.logging.Logger;
import java.util.logging.Level;
/**
* CopyLines gives input and output one line at a time
* BufferedReader provides lines and arrays to read texts
*/
public class CopyLines{
	private BufferedReader inputStream = null;
	private PrintWriter outputStream = null;
	private String source;
	private String target;
	private Logger logger;
	
	
	public CopyLines(String source,String target){
		this.source = source;
		this.target = target;
		logger = Logger.getLogger(this.getClass().getName());
	}
	
	public void operate() throws IOException{
		try{
			inputStream = new BufferedReader(new FileReader(source));
			outputStream = new PrintWriter(new FileWriter(target));
			String l;
			while((l = inputStream.readLine()) != null){outputStream.println(l);}
			System.out.println("File succesfully written");
		}catch(FileNotFoundException ex){
			System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			logger.log(Level.INFO,"The source file "+source+" has not been found");
			ex.printStackTrace();
			System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		}finally{
			if(inputStream != null){inputStream.close();}
			if(outputStream != null){outputStream.close();}
		}
	}
}

/*

javac -d . DriverIO.java CopyLines.java
java basicIO.DriverIO

*/