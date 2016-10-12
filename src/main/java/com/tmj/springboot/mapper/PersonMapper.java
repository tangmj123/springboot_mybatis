package com.tmj.springboot.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.SQL;

import com.tmj.springboot.domain.Person;
public interface PersonMapper {

	@Select({"select * from",
			" person ",
			"where id=#{id}"})
	public Person queryById(@Param("id") int id);
	
	@SelectProvider(type=PersonSqlBuilder.class,method="getById")
	public Person queryById2(@Param("id")int id);
	
	@Insert({"insert into person",
			"(name,password)",
			"values",
			"(#{p.name},#{p.password})"})
	public void save(@Param("p")Person person);
	
	@Update("update person set name=#{p.name},password=#{p.password} where id=#{p.id}")
	public void update(@Param("p")Person person);
	
	@Delete("delete from person where id=#{id}")
	public void delete(@Param("id") int id);
	
	
	class PersonSqlBuilder{
		public String getById(final int id){
			return new SQL(){{
				SELECT("*");
				FROM("person");
				WHERE("id=#{id}");
			}}.toString();
		}
	}
}
