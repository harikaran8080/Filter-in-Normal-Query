package com.NormalQuery.NormalQuery.service;

import java.util.List;

import com.NormalQuery.NormalQuery.dto.MoviesDto;

public interface ServiceImplement {

	MoviesDto post(MoviesDto dto);

	 List<MoviesDto> postall(List<MoviesDto> dto);

	MoviesDto get(int no);

	List<MoviesDto> getall();

	MoviesDto update(MoviesDto dto);

	String delete(int no);

	List<MoviesDto> gets(String heroin);

	List<Object> object(String anybody);

	

}
