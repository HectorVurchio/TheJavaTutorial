package fileIO;
import java.io.IOException;

public class DriverFileIO{
	public static void main(String... args)throws IOException{
		var fo = new FileOperations();
		System.out.println("File Checking");
		fo.fileChecking();
		System.out.println("Checking file accesibility");
		fo.fileAccesibility();
		System.out.println("Basic File Attributes");
		fo.basicFileAttributes();
		System.out.println("Setting Time Stamp");
		fo.settingTimeStamp();
	}
}