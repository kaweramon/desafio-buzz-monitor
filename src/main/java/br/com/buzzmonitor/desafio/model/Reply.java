package br.com.buzzmonitor.desafio.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reply {

	private String content;
	
	private String sentiment;
	
	private String service;
	
	private boolean archived;
	
	@Field(type = FieldType.Nested)
	private Author author;
	
	private List<String> hashtags;
	
	private List<String> urls;
	
	private String origin;
	
	@Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date collected_time;
	
}
