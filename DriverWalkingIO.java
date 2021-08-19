package walkingIO;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
public class DriverWalkingIO{
	public static void main(String... args)throws IOException{
		Path dir = Paths.get(System.getProperty("user.home"),"Desktop");
		Path lookingfor = Paths.get(System.getProperty("user.home"),"Desktop","BigDecimal","documents");
		String skip = "C:/Users/hecto_000/Desktop/TheJavaTutorial/walkingIO/PrintFiles.class";
		PrintFiles pf = new PrintFiles(lookingfor,skip);
		Files.walkFileTree(dir,pf);
	}
}

/*
javac -d . DriverWalkingIO.java PrintFiles.java

java walkingIO.DriverWalkingIO
*/