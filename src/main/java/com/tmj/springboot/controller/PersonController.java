package com.tmj.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmj.springboot.domain.Person;
import com.tmj.springboot.mapper.PersonMapper;

@RestController
@RequestMapping("api/person")
public class PersonController {
	
	@Autowired private PersonMapper personMapper;
	
	@RequestMapping("{id}")
	public Person getById(@PathVariable int id){
		return personMapper.queryById2(id);
	}
	
	@RequestMapping("save")
	public String save(Person person){
		this.personMapper.save(person);
		return "SUCCESS";
	}
	
	@RequestMapping("update")
	public String update(Person person){
		this.personMapper.update(person);
		return "SUCCESS";
	}
	
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable int id){
		this.personMapper.delete(id);
		return "SUCCESS";
	}
	
}
