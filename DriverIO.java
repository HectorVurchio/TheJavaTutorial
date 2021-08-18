package basicIO;
import java.io.IOException;
import java.util.Locale;
public class DriverIO{
	public static void main(String... args)throws IOException{
		var cp = new ScanningFile("numbers.txt",new Locale("es","VE"));
		//cp.printByWords();
		//cp.printByWordsDelimited(",");
		//cp.printByLine();
		cp.printNumbers();
	}
}