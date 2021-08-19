package fileIO;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.buffer.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;

/**
* Methods for channels and ByteBuffers
* While streams I/O reads a characters at a time, 
* channel I/O rads buffer at a time
*/
public class ByteBufferChannel{
	public static void readFile(Path path)throws IOException{
		try(SeekableByteChannel sbc Files.newByteChannel(path)){
			final int BUFFER_CAPACITY = 10;
			ByteBuffer buf = ByteBuffer.allocate(BUFFER_CAPACITY);
			/*
			read the bytes with the propper encoding for this plattform.
			if you skip this step, you might see foreign or illegible characters
			*/
			String encoding = System.getProperty("file.encoding");
			while(sbc.read(buf) > 0){
				buf.flip();
				System.out.print(Charset.forName(encoding).decode(buf));
				buf.clear();
			}
		}
	}
}