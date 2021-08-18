package pathIO;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.URI;

public class PathOperations{
	
	public void pathRepresentation(){
		Path[] path = new Path[4];
		path[0] = Paths.get("tmp/foo");
		path[1] = Paths.get(URI.create("file:///users/joe/FileTest.java"));
		path[2] = FileSystems.getDefault().getPath("/users/sally");
		path[3] = Paths.get(System.getProperty("user.home"),"logs","foo.log");
		for(Path pa : path){System.out.println(pa);}
	}
	
	public void pathInfo(){
		Path path = Paths.get("C:\\home\\joe\\foo");
		System.out.format("toString(): %s%n",path.toString());
		System.out.format("getFileName: %s%n",path.getFileName());
		System.out.format("getName(0): %s%n",path.getName(0));
		System.out.format("getNameCount: %d%n",path.getNameCount());
		System.out.format("subpath(0,2): %s%n",path.subpath(0,2));
		System.out.format("getParent: %s%n",path.getParent());
		System.out.format("getRoot(): %s%n",path.getRoot());
	}
	
	public void convertingApath(){
		System.out.println("Converting a path");
		Path p1 = Paths.get("/home/logfile");
		System.out.format("p1.toString(): %s%n",p1.toString());
		System.out.format("p1.toUri() %s%n",p1.toUri());
	}
	
	public void joiningTwoPaths(){
		System.out.println("Joining two paths");
		Path p1 = Paths.get("C:\\home\\joe\\foo");
		System.out.format("%s%n",p1.resolve("bar"));
	}
}