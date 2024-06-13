package com.NormalQuery.NormalQuery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.NormalQuery.NormalQuery.dto.MoviesDto;
import com.NormalQuery.NormalQuery.entity.Movies;

@Repository
public interface MoviesRepository  extends JpaRepository<Movies, Integer>{
	 @Query("SELECT m FROM Movies m WHERE m.moviename = :heroin OR m.hero = :heroin OR m.heroin = :heroin ")
	List<Movies> findByHeroin(String heroin);
	
	
	 @Query(value = "SELECT m FROM Movies m WHERE "
	 +"m.moviename LIKE %:anybody% OR"
	 +" m.hero LIKE %:anybody% OR"
	 +" m.heroin LIKE %:anybody%",nativeQuery = true)
	List<Object> findByAnybody(String anybody);



	
	

}
