//ONOMA: OTHONAS GKAVARDINAS 
//AM: 2620

package main;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FileReader extends FileIO{
	
	private Scanner inputReader = null;
	
	public FileReader(String path){
		super(path);
	}
	
	public boolean init(){
		try{
			inputReader = new Scanner(new FileInputStream(super.getPath()));
			return true;
		} catch(FileNotFoundException e){
			return false;
		}
	}
	
	public ArrayList<String> readFile(){
		ArrayList<String> arlist = new ArrayList<String>();
		String line = inputReader.nextLine();
		while(inputReader.hasNextLine()){
			line = inputReader.nextLine();
			arlist.add(line);
		}
		return arlist;
	}
	
	public void close(){
		inputReader.close();
	}

}