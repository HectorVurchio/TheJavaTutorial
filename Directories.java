package directoryIO;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.DirectoryStream;
import java.nio.file.DirectoryIteratorException;
public class Directories{
	/**
	* List all the root directories for a file system
	*/
	void listingFiles(){
		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
		for(Path name : dirs){
			System.err.println(name);
		}
	}
	/**
	* Files.createDirectory(Path dir,FileAttribute<?>... attrs);
	* the new directory created as follow will have default attributes
	*/
	void createDirectory()throws IOException{
		Path dir = Paths.get(System.getProperty("user.home"),"Desktop","MyFolder");
		Files.createDirectory(dir);
	}
	
	void directoryContents(){
		Path dir = Paths.get(System.getProperty("user.dir"));
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)){
			for(Path file : stream){
				System.out.println(file.getFileName());
			}
		}catch(IOException | DirectoryIteratorException e){
			System.err.println(e);
		}
	}
	/**
	* filter = "*.{java,class,jar}";
	* Directories d = new Directories();
	* d.filteredDirectories("*.{java}");
	*/
	void filteredDirectories(String filter){
		Path dir = Paths.get(System.getProperty("user.dir"));
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir,filter)){
			for(Path entry : stream){
				System.out.println(entry.getFileName());
			}
		}catch(IOException e){
			System.err.println(e);
		}
	}
	
	/**
	* Creating your own directory filter
	*/
	
	void createDirectoryFilter(){
		Path path = Paths.get(System.getProperty("user.dir"));
		DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>(){
			public boolean accept(Path file)throws IOException{
				/*try{*/
					return(Files.isDirectory(path));
				/*}catch(IOException e){
					System.err.println(e);
					return false;
				}*/
			}
		};
	}
	
	
	/**
	* this could be seen as a shortcut to access the existing file
	*/
	void createHardLink(){
		Path newLink = Paths.get(System.getProperty("user.home"),"Desktop","link.txt");
		Path existingFile = Paths.get(System.getProperty("user.dir"),"MyHardLink.txt");
		try{
			Files.createLink(newLink,existingFile);
		}
		catch(IOException e){System.out.println(e);}
		catch(UnsupportedOperationException e){System.err.println(e);}
	}
	
	void createSymbLink(){
		Path newLink = Paths.get(System.getProperty("user.home"),"Desktop","link.txt");
		Path existingFile = Paths.get(System.getProperty("user.dir"),"MyHardLink.txt");
		try{
			Files.createSymbolicLink(newLink,existingFile);
		}
		catch(IOException e){System.out.println(e);}
		catch(UnsupportedOperationException e){System.err.println(e);}
	}
}
