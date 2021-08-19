package walkingIO;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.FileVisitResult;
import static java.nio.file.FileVisitResult.*;
import java.io.IOException;
/**
* This class recursively visit all the files in a tree
* by using the FileVisitoe Interface.
*/
public class PrintFiles extends SimpleFileVisitor<Path>{
	private Path lookingfor;
	private String skip;
	
	public PrintFiles(Path lookingfor,String skip){
		this.lookingfor = lookingfor;
		this.skip = skip;
	}
	
	

	//print information about each type of file
	@Override
	public FileVisitResult visitFile(Path file,BasicFileAttributes attr){
		if(attr.isSymbolicLink()){
			System.out.format("Symbolic link: %s",file);
		}else if(attr.isRegularFile()){
			System.out.format("Regular file: %s",file);
		}else{
			System.out.format("Other: %s",file);
		}
		System.out.println("("+attr.size()+"bytes)");
		return CONTINUE;
	}
	

/*
	//here as soon as "lookingfor" is located, this is printed and walking terminates
	@Override
	public FileVisitResult visitFile(Path file,BasicFileAttributes attr){
		if(file.getFileName().equals(lookingfor)){
			System.out.println("Located File: "+file);
			return TERMINATE;
		}
		return CONTINUE;
	}
*/	
	
	
	//here any directory named MyDirectory es skipped
	@Override
	public FileVisitResult preVisitDirectory(Path file,BasicFileAttributes attrs){
		if(file.getFileName().toString().equals(skip)){
			return SKIP_SUBTREE;
		}
		return CONTINUE;
	}
	

/*	
	//print each directory visited
	@Override
	public FileVisitResult postVisitDirectory(Path file,IOException exc){
		System.out.format("Directory: %s%n",file);
		return CONTINUE;
	}
	
*/
	
	/**
	* if there is some error accession the file, let the user know.
	* if you don't override this method and an error occurs, an
	* I/O exception is thrown
	*/
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc){
		System.err.println(exc);
		return CONTINUE;
	}
	
}