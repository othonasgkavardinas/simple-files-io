//ONOMA: OTHONAS GKAVARDINAS 
//AM: 2620

package main;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class FileReader{
	
	private String path;
	private Scanner inputReader = null;
	
	public FileReader(String path){
		this.path = path;
	}
	
	public boolean initReader(){
		try{
			inputReader = new Scanner(new FileInputStream(path));
			return true;
		}
		catch(FileNotFoundException e){
			return false;
		}
	}
	
	public ArrayList<String> readFile(){
		ArrayList<String> l = new ArrayList<String>();
		String line = inputReader.nextLine();
		while(inputReader.hasNextLine()){
			line = inputReader.nextLine();
			l.add(line);
		}
		return l;
	}
	
	public void closeReader(){
		inputReader.close();
	}
}