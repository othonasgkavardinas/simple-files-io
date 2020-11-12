//ONOMA: OTHONAS GKAVARDINAS 
//AM: 2620

package main;

import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

class FileWriter{
	private String path;
	private PrintWriter outputWriter;
	
	public FileWriter(String path){
		this.path = path;
	}
	
	public boolean initWriter(){
		try{
			FileOutputStream outputStream = new FileOutputStream(path);		
			outputWriter = new PrintWriter(outputStream);
			return true;
		}
		catch(FileNotFoundException e){
			return false;
		}
	}
	
	public void writeFile(ArrayList<UniversityScore> array){
		for(int i=0; i<array.size(); i++)
			outputWriter.println(array.get(i));
	}
	
	public void closeWriter(){
		outputWriter.close();
	}
}