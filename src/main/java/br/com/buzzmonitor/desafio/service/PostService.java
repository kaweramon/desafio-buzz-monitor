package br.com.buzzmonitor.desafio.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.buzzmonitor.desafio.model.Post;
import br.com.buzzmonitor.desafio.model.Reply;

public interface PostService {

	public Post create(Post post);
	
	public Post addReply(String postId, Reply reply);
	
	public List<Post> list();
	
	public Page<Post> search(String username, String socialMedia, String collectedTimeFrom, String collectedTimeTo, Pageable pageable);
	
	public Post view(String id);
	
	public void delete(String id);
	
}
