//ONOMA: OTHONAS GKAVARDINAS 
//AM: 2620

package com.github.othonasgkavardinas.app;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class UniversityScore{
	private String name;
	private String country;
	private double score;
	private int year;
}