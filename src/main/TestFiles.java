//ONOMA: OTHONAS GKAVARDINAS 
//AM: 2620

package main;

public class TestFiles {
	public static void main(String[] args){
		FileReader reader = new FileReader("files/universities.txt");
		if(reader.init()){
			FileEditor editor = new FileEditor(reader.readFile());
			reader.close();
			editor.fillHashMap();
			FileWriter writer = new FileWriter("files/universities_2015_output.txt");
			if(writer.init()){
				writer.writeFile(editor.getScoresOfYear(2015));
				writer.close();
			} else
				System.out.println("Error creating file");
			System.out.println("Average university score of year 2015: "+editor.getAverageOfYear(2015));
			System.out.println("Min university score of year 2015: "+editor.getMinOfYear(2015));
			System.out.println("Max university score of year 2015: "+editor.getMaxOfYear(2015));
		} else
			System.out.println("Error opening file");
	}
}
