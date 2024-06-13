package com.NormalQuery.NormalQuery.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class MoviesDto {
	
	private int no;
	
	private String moviename;
	
	private String hero;
	
	private String heroin;

}
