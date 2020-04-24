//ONOMA: OTHONAS GKAVARDINAS 
//AM: 2620

package main;

public class TestFiles {
	public static void main(String[] args){
		FileReader reader = new FileReader("files/universities.txt");
		if(reader.initReader()){
			FileEditor editor = new FileEditor(reader.readFile());
			reader.closeReader();
			editor.fillHashMap();
			FileWriter writer = new FileWriter("files/universities_2015_output.txt");
			if(writer.initWriter()){
				writer.writeFile(editor.getScoresOfYear(2015));
				writer.closeWriter();
			}
			else{
				System.out.println("Error creating file");
			}
			System.out.println("Average university score of year 2015: "+editor.getAverageOfYear(2015));
			System.out.println("Min university score of year 2015: "+editor.getMinOfYear(2015));
			System.out.println("Max university score of year 2015: "+editor.getMaxOfYear(2015));
		}
		else{
			System.out.println("Error opening file");
		}
	}
}
