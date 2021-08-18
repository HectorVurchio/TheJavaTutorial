package fileIO;
import java.nio.file.Files;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.io.IOException;
public class FileOperations{
	void fileChecking(){
		Path file = Paths.get(System.getProperty("user.dir"),"prueba.txt");
		System.out.println("The file Exists: "+Files.exists(file,LinkOption.NOFOLLOW_LINKS));
		System.out.println("The file not Exists: "+Files.notExists(file,LinkOption.NOFOLLOW_LINKS));
	}
	
	void fileAccesibility()throws IOException{
		Path file = Paths.get(System.getProperty("user.dir"),"prueba.txt");
		System.out.format("isReadable: %s%n",Files.isReadable(file));
		System.out.format("isWritable: %s%n",Files.isWritable(file));
		System.out.format("isTheSameFile: %s%n",Files.isSameFile(file,file));
	}
	
	void basicFileAttributes()throws IOException{
		Path file = Paths.get(System.getProperty("user.dir"),"prueba.txt");;
		BasicFileAttributes attr = Files.readAttributes(file,BasicFileAttributes.class);
		System.out.println("creationTime: "+attr.creationTime());
		System.out.println("lastAccesTime: "+attr.lastAccessTime());
		System.out.println("lastModifiedTime: "+attr.lastModifiedTime());
		System.out.println("isDirectory: "+attr.isDirectory());
		System.out.println("isOther: "+attr.isOther());
		System.out.println("isRegularFile: "+attr.isRegularFile());
		System.out.println("isSymbolicLink: "+attr.isSymbolicLink());
		System.out.println("size: "+attr.size());
	}
	
	void settingTimeStamp()throws IOException{
		Path file = Paths.get(System.getProperty("user.dir"),"prueba.txt");
		BasicFileAttributes attr = Files.readAttributes(file,BasicFileAttributes.class);
		long currentTime = System.currentTimeMillis();
		FileTime ft = FileTime.fromMillis(currentTime);
		Files.setLastModifiedTime(file,ft);
	}
}