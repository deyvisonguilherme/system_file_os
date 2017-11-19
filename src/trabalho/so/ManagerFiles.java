package trabalho.so;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ManagerFiles 
{
	private static File folder;
	private final String NOMEARQUIVO = "binary_file.de";
	
	public ManagerFiles(File _folder){ folder = _folder;}
	
	public void createFile()
	{
		File[] arqs = folder.listFiles();
		String meta = "";
		FileInputStream inFile;
		int c = 0;
		
		try 
		{
			FileOutputStream outFile = new FileOutputStream(NOMEARQUIVO,true);
			for (int i = 0; i < arqs.length; i++) 
			{
				meta = String.format("P,%s\nN,%s\nT,%s\nD,%s\nM,%s\n",i , arqs[i].getName(), arqs[i].length(), arqs[i].isDirectory(), arqs[i].lastModified());
				outFile.write(meta.getBytes());						
			}
			outFile.write(0);
			outFile.write("\n".getBytes());
			
			for (File arq : arqs) 
			{
				inFile = new FileInputStream(arq);
				while ((c = inFile.read()) != -1) 
					outFile.write(c);
				
				inFile.close();
			}
			
			outFile.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public String readMFT()
	{
		String listArq = "";
		int c;
		try 
		{
			FileInputStream arq = new FileInputStream(NOMEARQUIVO);

			while((c = arq.read()) != 0)
				listArq += (char)c;
			
		arq.close();
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
				e.printStackTrace();
		}
		
		return listArq;
	}
	
	
}//class
