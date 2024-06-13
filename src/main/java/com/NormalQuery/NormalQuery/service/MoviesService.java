package com.NormalQuery.NormalQuery.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.NormalQuery.NormalQuery.dto.MoviesDto;
import com.NormalQuery.NormalQuery.entity.Movies;
import com.NormalQuery.NormalQuery.repository.MoviesRepository;

@Service
public class MoviesService  implements ServiceImplement{
	
	@Autowired
	private MoviesRepository moviesRepository;

	@Override
	public MoviesDto post(MoviesDto dto) {
		Movies movies=new Movies();
		movies.setNo(dto.getNo());
		movies.setMoviename(dto.getMoviename());
		movies.setHeroin(dto.getHeroin());
		movies.setHero(dto.getHero());
		moviesRepository.save(movies);
		return dto;
	}

	@Override
	public  List<MoviesDto> postall( List<MoviesDto> dto) {
		List<Movies>list=new ArrayList<Movies>();
		for(MoviesDto dto2:dto) {
			Movies movies=new Movies();
			movies.setNo(dto2.getNo());
			movies.setMoviename(dto2.getMoviename());
			movies.setHeroin(dto2.getHeroin());
			movies.setHero(dto2.getHero());
			list.add(movies);
		}List<Movies>list2=moviesRepository.saveAll(list);
		List<MoviesDto>dtos=new ArrayList<MoviesDto>();
		for(Movies movies:list2) {
			MoviesDto dtob=new MoviesDto();
			dtob.setNo(movies.getNo());
			dtob.setMoviename(movies.getMoviename());
			dtob.setHeroin(movies.getHeroin());
			dtob.setHero(movies.getHero());
			dtos.add(dtob);
		}return  dtos;
	}

	@Override
	public MoviesDto get(int no) {
		Optional<Movies>optional=moviesRepository.findById(no);
		Movies movies=optional.get();
		MoviesDto dto=new MoviesDto();
		dto.setMoviename(movies.getMoviename());
		dto.setNo(movies.getNo());
		dto.setHero(movies.getHero());
		dto.setHeroin(movies.getHeroin());
		return dto;
	}

	@Override
	public List<MoviesDto> getall() {
		List<Movies>list=moviesRepository.findAll();
		List<MoviesDto>dtos=new ArrayList<MoviesDto>();
		for(Movies movies:list) {
			MoviesDto dto=new MoviesDto();
			dto.setHero(movies.getHero());
			dto.setHeroin(movies.getHeroin());
			dto.setMoviename(movies.getMoviename());
			dto.setNo(movies.getNo());
			dtos.add(dto);
		}return dtos;
	}

	@Override
	public MoviesDto update(MoviesDto dto) {
		Optional<Movies>optional=moviesRepository.findById(dto.getNo());
		Movies movies=optional.get();
		movies.setHero(dto.getHero());
		movies.setHeroin(dto.getHeroin());
		movies.setMoviename(dto.getMoviename());
		movies.setNo(dto.getNo());
		moviesRepository.save(movies);
		return dto;
	}

	@Override
	public String delete(int no) {
		moviesRepository.deleteById(no);
		return "delete panniyachu";
	}

	@Override
	public List<MoviesDto> gets(String heroin) {
		List<Movies>list=moviesRepository.findByHeroin(heroin);
		List<MoviesDto>dtos=new ArrayList<MoviesDto>();
		for(Movies movies:list) {
			MoviesDto dto=new MoviesDto();
			dto.setHero(movies.getHero());
			dto.setHeroin(movies.getHeroin());
			dto.setMoviename(movies.getMoviename());
			dto.setNo(movies.getNo());
			dtos.add(dto);
			
		}return dtos;
	}

	@Override
	public List<Object> object(String anybody) {
		return moviesRepository.findByAnybody(anybody);
	}


}
