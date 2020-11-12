//ONOMA: OTHONAS GKAVARDINAS 
//AM: 2620

package main;

import java.util.ArrayList;
import java.util.HashMap;

class FileEditor{
	
	private HashMap<Integer,ArrayList<UniversityScore>> scores;
	private ArrayList<String> lines;
	
	public FileEditor(ArrayList<String> lines){
		this.lines = lines;
	}
	
	public void fillHashMap(){
		scores = new HashMap<Integer,ArrayList<UniversityScore>>();
		int noOfDifferentScores = 4;
		int[] years = { 2012, 2013, 2014, 2015 };
		
		ArrayList<ArrayList<UniversityScore>> scoresList = new ArrayList<ArrayList<UniversityScore>>();
		
		for(int i=0; i<noOfDifferentScores; i++) {
			scoresList.add(new ArrayList<UniversityScore>());
			scores.put(years[i], scoresList.get(i));
		}
		
		String[] tempString = new String[4];
		int tempYear=0;
		for(int i=0; i<lines.size(); i++){
			tempString = (lines.get(i)).split(";");
			tempYear = Integer.valueOf(tempString[3]);
			for(int j=0; j<noOfDifferentScores; j++)
				if(tempYear==years[j]) {
					scoresList.get(i).add(new UniversityScore
						(tempString[0],tempString[1],Double.valueOf(tempString[2]),Integer.valueOf(tempString[3])));
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
		double min = scores.get(y).get(0).getScore();
		for(int i=1; i<scores.get(y).size(); i++)
			if (min>scores.get(y).get(i).getScore())
				min = scores.get(y).get(i).getScore();
		return min;
	}
	
	public double getMaxOfYear(int y){
		double max = scores.get(y).get(0).getScore();
		for(int i=1; i<scores.get(y).size(); i++)
			if (max<scores.get(y).get(i).getScore())
				max = scores.get(y).get(i).getScore();
		return max;
	}
	
}