package com.NormalQuery.NormalQuery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.NormalQuery.NormalQuery.dto.MoviesDto;
import com.NormalQuery.NormalQuery.service.ServiceImplement;

@RestController
@RequestMapping("/movies/api")
public class MoviesController {

	@Autowired
	private ServiceImplement serviceImplement;

	@PostMapping("/post")
	public MoviesDto post(@RequestBody MoviesDto dto) {
		return serviceImplement.post(dto);
	}

	@PostMapping("/postall")
	public List<MoviesDto> postall(@RequestBody List<MoviesDto> dto) {
		return serviceImplement.postall(dto);
	}

	@GetMapping("/get/{no}")
	public MoviesDto get(@PathVariable int no) {
		return serviceImplement.get(no);
	}

	@GetMapping("/getall")
	public List<MoviesDto> getall() {
		return serviceImplement.getall();
	}

	@PutMapping("/update")
	public MoviesDto update(@RequestBody MoviesDto dto) {
		return serviceImplement.update(dto);
	}

	@DeleteMapping("/delete/{no}")
	public String delete(@PathVariable int no) {
		return serviceImplement.delete(no);
	}
	
	@GetMapping("/gets")
	public List<MoviesDto>gets(@RequestParam (value = "heroin",required = false)String heroin){
		return serviceImplement.gets(heroin);
	}
	
	@GetMapping("/obj")
	public List<Object>object(@RequestParam (value = "anybody",required = false)String anybody ){
		return serviceImplement.object(anybody);
	}
	

}
