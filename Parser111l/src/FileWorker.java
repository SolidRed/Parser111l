import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;


public class FileWorker {
	public static void metwrite(String fileName, String text)
	{
		File file = new File(fileName);
		
		try{ //проверяем, что если файл не существует то создаем его
			if (!file.exists()){
				file.createNewFile();
			}
			
			PrintWriter out = new PrintWriter(new FileOutputStream(file.getAbsoluteFile(), true));
			
			try{
				
				out.println(text);
				
			} finally {
				out.close();
			}
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static String text = "This new text \nThis new text2\nThis new text3\nThis new text4\n";
	private static String fileName = "D://a.txt";
	 
	public static void main(String[] args) throws FileNotFoundException {
	 
	    //Запись в файл
	    FileWorker.metwrite(fileName, text);
	 
	}
	
}
