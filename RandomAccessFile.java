package fileIO;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
* Random Access Files permit non sequential, or random, access to a file's contents.
* To access a file randomly, you open the file, seek a particular location, and read
* from or write to that file.
*/
public class RandomAccessFile{
	String s = "I was Here!\n";
	Path file = Paths.get(System.getProperty("user.dir"),"prueba.txt");
	
	void writeToAFile(){
		byte[] data = s.getBytes();
		ByteBuffer out = ByteBuffer.wrap(data);
		ByteBuffer copy = ByteBuffer.allocate(12);
		try(FileChannel fc = (FileChannel.open(file,READ,WRITE))){
			//reads the first 12 bytes of the file
			int nread;
			do{
				nread = fc.read(copy);
			}while(nread != -1 && copy.hasRemaining());
			//write I was Here! at the beginning of the file
			fc.position(0);
			while(out.hasRemaining())
				fc.write(out);
			out.rewind();
			//move to the end of the file. Copy the first 12 bytes to 
			//the end of the file. then write "I was here!" again.
			long length = fc.size();
			fc.position(length - 1);
			copy.flip();
			while(copy.hasRemaining())
				fc.write(copy);
			while(out.hasRemaining())
				fc.write(out);
		}catch(IOException e){
			System.out.println("IOException: "+e);
		}
	}
}