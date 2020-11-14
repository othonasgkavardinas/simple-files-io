//ONOMA: OTHONAS GKAVARDINAS 
//AM: 2620

package main;

import lombok.Data;

public @Data class UniversityScore{
	
	public UniversityScore(String name, String country, double score, int year) {
		super();
		this.name = name;
		this.country = country;
		this.score = score;
		this.year = year;
	}

	private String name;
	private String country;
	private double score;
	private int year;
	
	public String toString(){
		return ""+name+"\t"+country+"\t"+score+"\t"+year;
	}
}