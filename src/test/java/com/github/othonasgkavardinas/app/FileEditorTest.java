package com.github.othonasgkavardinas.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class FileEditorTest {

	@Test
	public void fillHashMapTest() {
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
			assertEquals(editor.getAverageOfYear(2015), 46, 1);
			assertEquals(editor.getMinOfYear(2015), 44, 1);
			assertEquals(editor.getMaxOfYear(2015), 100, 1);
		} else {
			System.out.println("Error opening file");
			fail();
		}
	}	

}
