package basicIO;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.logging.Logger;
import java.util.logging.Level;

/**
* We'll explore FileInputStream classes. To demonstrate how
* byte streams work, we'll focus on the file I/O byte streams,
* FileInputStream and FileOutputStream. Other kinds of byte streams
* are used in much the same way; they differ mainly in the way they are 
* constructed.
* @author The Java Tutorial
* @version java 11
* @since 2021-08-17
*/
public class CopyBytes{
	private FileInputStream in = null;
	private FileOutputStream out = null;
	private String name;
	private String target;
	private Logger logger;
	
	public CopyBytes(String name,String target){
		this.name = name;
		this.target = target;
		logger = Logger.getLogger(CopyBytes.class.getName());
	}
	/**
	* this method reads a file in the same root directory as 
	* .java files.
	* c = in.read() == -1 -> the end of the file is reached.
	* @throws IOException required by both FileInputStreams
	* and FileOutputStreams class constructors
	*/
	public void operate()throws IOException{
		try{
			in = new FileInputStream(name);
			out = new FileOutputStream(target);
			int c;
			while((c = in.read())!= -1){out.write(c);}
			System.out.println("File succesfuly written");
		}catch(IOException ex){
			System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			logger.log(Level.INFO,"Probably the file "+name+" does not exist");
			ex.printStackTrace();
			System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		}finally{
			if(in != null){in.close();}
			if(out != null){out.close();}
		}
	}
	
	
}