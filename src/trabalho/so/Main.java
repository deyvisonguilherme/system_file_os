package trabalho.so;

import java.io.File;

public class Main {

	public static void main(String[] args) 
	{
		File _folder = new File("c:\\doc");
		ManagerFiles _managerFiles = new ManagerFiles(_folder);
		
		for (File file : _managerFiles.listFilesInFolder()) 
		{
			System.out.println(file);
		}
	}

}
