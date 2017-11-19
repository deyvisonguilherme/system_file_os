package trabalho.so;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		File _pasta = new File("/home/deyvison/Downloads/docs");
		ManagerFiles gerenciador = new ManagerFiles(_pasta);
		
//		gerenciador.createFile();
		System.out.println(gerenciador.readMFT());
	}
}