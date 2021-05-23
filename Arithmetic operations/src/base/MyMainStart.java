package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyMainStart {
	
	public static void main(String[] args) throws IOException {
		var reader = new BufferedReader(new InputStreamReader(System.in));
		String[] startComd = (reader.readLine()).split(" "); //указывать иходной параметр нужно через пробел!!!
		if(startComd[0].equals("-")) {
			sentResult(startComd[1], getResult((reader.readLine()).split(" ")));
		}
		else {
			try {
				sentResult(startComd[1], getResult((new FileUtils().readFile(startComd[0])).split(" ")));
			}
			catch(Exception e) {
				System.out.println("ERROR: Не верно указана стартовая команда.");
			}
		}
		reader.close();
	}
	
	public static long getResult(String[] param) {
		long result = 0;
		if(checkComand(param[0])) {
			switch (param[0]) {
	        case  ("sum"):
	        	result = new Сalculations().sum(convert(param));
	            break;
	        case ("mult"):
	        	result = new Сalculations().mult(convert(param));
	            break;
	        case ("multsum"):
	        	result = new Сalculations().multsum(convert(param));
	            break;
			}
		}
		else {
			System.out.println("ERROR: Не верно указана команда арифметической операции.\nКорректные команды: sum, mult, multsum.");
			System.exit(0);
		}
		return result;
	}
	
	public static int[] convert(String[] strArr) {
		int numArr[] = new int[strArr.length-1];
        for (int i = 0; i < strArr.length-1; i++) {
        	try{
        		numArr[i] = Integer.parseInt(strArr[i+1]);
        	}
        	catch(NumberFormatException e){
        		System.out.println("ERROR: Указаны не корректные числа.");
        		System.exit(0);
        	}
        }
        return numArr;
	}
	
	public static void sentResult(String path, long result) {
		if(path.equals("-")) {
			System.out.println(result);
		}
		else {
			new FileUtils().writeFile(path, result+"");
		}
	}
	
	public static boolean checkComand(String comand) {
		if(comand.equals("sum")||comand.equals("mult")||comand.equals("multsum")) {
			return true;
		}
		return false;
	}
}
