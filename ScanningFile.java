package basicIO;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.logging.Logger;
import java.util.logging.Level;

import java.util.Locale;
/**
* Objects of type Scanner are useful for braking down formatted 
* input into tokens and translating individual tokens according
* to their data type. By default a Scanner uses white space to
* separate tokens. White space characters include blanks, tabs,
* and line terminators. Scanners also contains methods to search
* many kinds of strings.
* @see https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#isWhiteSpace-char-
* @see https://docs.oracle.com/javase/11/docs/api/java.base/java/util/Scanner.html
*/
public class ScanningFile{
	private Scanner scanner = null;
	private String source;
	private Logger logger;
	private Locale locale;
	
	public ScanningFile(String source){
		this.source = source;
		this.locale = Locale.US;
		this.logger = Logger.getLogger(this.getClass().getName());
	}
	
	public ScanningFile(String source,Locale locale){
		this.source = source;
		this.locale = locale;
		this.logger = Logger.getLogger(this.getClass().getName());
	}
	
	public void printByWords() throws IOException{
		try{
			scanner = new Scanner(new BufferedReader(new FileReader(source)));
			System.out.println("File successfully read");
			while(scanner.hasNext()){System.out.println(scanner.next());}
			System.out.println();
		}catch(FileNotFoundException ex){
			System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			logger.log(Level.INFO,"Missing file: "+source);
			System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			ex.printStackTrace();
		}finally{
			if(scanner != null){scanner.close();}
		}
	}
	/**
	* var cp = new ScanningFile("byComma.txt");
	* cp.printByWordsDelimited(",");
	*/
	public void printByWordsDelimited(String delimiter){
		try{
			scanner = new Scanner(new BufferedReader(new FileReader(source)));
			scanner.useDelimiter(delimiter);
			System.out.println("File successfully read");
			while(scanner.hasNext()){System.out.println(scanner.next());}
			System.out.println();
		}catch(FileNotFoundException ex){
			System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			logger.log(Level.INFO,"Missing file "+source);
			System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			ex.printStackTrace();
		}finally{
			if(scanner != null){scanner.close();}
		}
	}
	
	public void printByLine() throws IOException{
		try{
			scanner = new Scanner(new BufferedReader(new FileReader(source)));
			System.out.println("File successfully read");
			while(scanner.hasNextLine()){System.out.println(scanner.nextLine());}
		}catch(FileNotFoundException ex){
			System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			logger.log(Level.INFO,"Missing file "+source);
			System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			ex.printStackTrace();
		}finally{
			if(scanner != null){scanner.close();}
		}
	}
	/**
	* This methods search a number depending on what a locale considers what a numbe is.
	* For example Locale.US not considers 127,3 as a number. The result after using this
	* method does not show up formatted.
	*/
	public void printNumbers()throws IOException{
		try{
			scanner = new Scanner(new BufferedReader(new FileReader(source)));
			scanner.useLocale(locale);
			System.out.println("File successfully read");
			while(scanner.hasNext()){
				if(scanner.hasNextDouble()){
					System.out.println(scanner.nextDouble());
				}else{
					scanner.next(); //encourage the scanner consumption
				}
			}
		}catch(FileNotFoundException ex){
			System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			logger.log(Level.INFO,"Missing file "+source);
			System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			ex.printStackTrace();
		}finally{
			if(scanner != null){scanner.close();}
		}
	}
	
}

/*

javac -d . DriverIO.java ScanningFile.java 
java basicIO.DriverIO

*/