//ONOMA: OTHONAS GKAVARDINAS 
//AM: 2620

package main;

class UniversityScore{
	
	private String name;
	private String country;
	private double score;
	private int year;
	
	public UniversityScore(String name, String country, double score, int year){
		this.name = name;
		this.country = country;
		this.score = score;
		this.year = year;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setCountry(String country){
		this.country = country;
	}
	
	public void setScore(double score){
		this.score = score;
	}
	
	public void setYear(int year){
		this.year = year;
	}
	
	public String getName(){
		return name;
	}
	
	public String getCountry(){
		return country;
	}
	
	public double getScore(){
		return score;
	}
	
	public int getYear(){
		return year;
	}
	
	public String toString(){
		return ""+name+"\t"+country+"\t"+score+"\t"+year;
	}
}