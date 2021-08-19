package directoryIO;
import java.io.IOException;
public class DriverDirectoriesIO {
	public static void main(String[] args)throws IOException{
		Directories d = new Directories();
		//d.filteredDirectories("*.{java}");
		//d.createHardLink();
		d.createSymbLink();
	}
}

/*

javac -d . DriverDirectoriesIO.java Directories.java
java directoryIO.DriverDirectoriesIO

*/