package com.github.othonasgkavardinas.app;

import java.util.ArrayList;
import java.util.HashMap;

public class FileEditor{
	
	private HashMap<Integer, ArrayList<UniversityScore>> scores;
	private ArrayList<String> lines;
	
	public FileEditor(ArrayList<String> lines){
		this.lines = lines;
	}
	
	public void fillHashMap(){
		scores = new HashMap<Integer, ArrayList<UniversityScore>>();
		int[] years = { 2012, 2013, 2014, 2015 };
		
		ArrayList<ArrayList<UniversityScore>> scoresList = new ArrayList<ArrayList<UniversityScore>>();
		
		for(int i=0; i<years.length; i++) {
			scoresList.add(new ArrayList<UniversityScore>());
			scores.put(years[i], scoresList.get(i));
		}
		
		String[] tempString = new String[4];
		int tempYear=0;
		for(int i=0; i<lines.size(); i++){
			tempString = (lines.get(i)).split(";");
			tempYear = Integer.valueOf(tempString[3]);
			for(int j=0; j<years.length; j++)
				if(tempYear==years[j]) {
					scoresList.get(j).add(new UniversityScore(
							tempString[0], tempString[1], Double.valueOf(tempString[2]), Integer.valueOf(tempString[3])));
					break;
				}
		}
	}
	
	public ArrayList<UniversityScore> getScoresOfYear(int y){
		return scores.get(y);
	}
	
	public double getAverageOfYear(int y){
		double sum = 0;
		for(int i=0; i<scores.get(y).size(); i++)
			sum += scores.get(y).get(i).getScore();
		return sum/(scores.get(y).size());
	}
	
	public double getMinOfYear(int y){
		Consumer consumer = (v1, v2) -> v1 > v2;
		return getValue(y, consumer);
	}
	
	public double getMaxOfYear(int y){
		Consumer consumer = (v1, v2) -> v1 < v2;
		return getValue(y, consumer);
	}
	
	public double getValue(int y, Consumer consumer) {
		double retv = scores.get(y).get(0).getScore();
		for(int i=1; i<scores.get(y).size(); i++)
			if (consumer.useMethod(retv, scores.get(y).get(i).getScore()))
				retv = scores.get(y).get(i).getScore();
		return retv;
	}
	
	private interface Consumer {
		boolean useMethod(double v1, double r2);
	}
	
}
