package base;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

public class FileUtils {
	
	public String readFile(String name) {
		Optional<String> result = null;
		try {
			result = Files.lines(Paths.get(name)).findFirst();
		} catch (IOException e) {
			System.out.println("ERROR: Не верно указанно имя входного файла");
			//e.printStackTrace();
		}
		return result.get();
	}
	
	public void writeFile(String path, String result) {
		try(FileWriter writer = new FileWriter(path, false)){ 
			writer.write(result); 
			writer.flush();
			}
		catch(IOException ex){
			System.out.println(ex.getMessage());
		}
	}

}
