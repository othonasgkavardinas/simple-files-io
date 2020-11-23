package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.FileEditor;
import main.FileReader;
import main.FileWriter;

class FileEditorTest {

	@Test
	void fillHashMapTest() {
		FileReader reader = new FileReader("files/universities.txt");
		if(reader.init()){
			FileEditor editor = new FileEditor(reader.readFile());
			reader.close();
			editor.fillHashMap();
			FileWriter writer = new FileWriter("files/universities_2015_output.txt");
			if(writer.init()){
				writer.writeFile(editor.getScoresOfYear(2015));
				writer.close();
			} else {
				System.out.println("Error creating file");
				fail();
			}
			assertEquals(editor.getAverageOfYear(2015), 46.863850000000006);
			assertEquals(editor.getMinOfYear(2015), 44.02);
			assertEquals(editor.getMaxOfYear(2015), 100.0);
		} else {
			System.out.println("Error opening file");
			fail();
		}
	}	

}
