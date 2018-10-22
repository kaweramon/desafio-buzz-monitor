package br.com.buzzmonitor.desafio.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Document(indexName = "post", type = "post", shards = 1, replicas = 0)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {

	@Id
	private String id;
	
	private String content;
	
	private String rt;
	
	private String sentiment;
	
	private String service;
	
	@Column(name = "collected_from")
	private String collectedFrom;
	
	private boolean archived;
	
	@Field(type = FieldType.Nested)
	private Author author;
	
	@Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date collected_time;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	private String application;
	
	private Integer tweets;
	
	private String origin;
	
	private List<String> hashtags;
	
	private List<String> urls;
	
	@Field(type = FieldType.Nested)
	private List<Reply> replies;
	
	public Post(String content, String rt, String sentiment, String service, Date collected_time, String origin) {
		this.content = content;
		this.rt = rt;
		this.sentiment = sentiment;
		this.service = service;
		this.collected_time = collected_time;
		this.origin = origin;
	}
	
}
