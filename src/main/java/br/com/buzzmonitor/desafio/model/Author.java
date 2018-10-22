package br.com.buzzmonitor.desafio.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Author {

	private String name;
	
	private String name_searchable;
	
	private String description;
	
	private List<String> bios;
	
	private Integer followers;
	
	private Integer friends;
	
	private String location;
	
	private String location_searchable;
	
	private String gender;
	
	private boolean updated;
	
	@Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date created_at;
	
	private String screenname;
	
	private String profile_image_url;
	
	private Integer tweets;
	
	public Author(String name, String description, String gender, Integer followers, Integer friends) {
		this.name = name;
		this.description = description;
		this.gender = gender;
		this.followers = followers;
		this.friends = friends;
	}
}
