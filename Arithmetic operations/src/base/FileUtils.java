package base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
	
	
	public String readFile(String name) throws IOException {
		String result = "";
		try (BufferedReader br = new BufferedReader(new FileReader(name))) {
			while (br.ready()) {
				result += br.readLine();
			}
		}
		catch(FileNotFoundException e1) {
			System.out.println("ERROR: Не верно указанно имя входного файла");
			e1.printStackTrace();
		}
		return result;
	}
	
	public void writeFile(String path, String result) {
		try(FileWriter writer = new FileWriter(path, false)){ 
			writer.write(result); 
			writer.flush();
			writer.close();
			}
		catch(IOException ex){
			System.out.println(ex.getMessage());
		}
	}

}
