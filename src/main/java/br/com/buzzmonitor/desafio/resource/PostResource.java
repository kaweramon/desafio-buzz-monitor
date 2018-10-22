package br.com.buzzmonitor.desafio.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.buzzmonitor.desafio.model.Post;
import br.com.buzzmonitor.desafio.model.Reply;
import br.com.buzzmonitor.desafio.service.PostService;

@RestController
@RequestMapping(path = "/posts")
public class PostResource {

	@Autowired
	private PostService service;
		
	@PostMapping
	public ResponseEntity<Post> create(@RequestBody Post post) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(post));
	}
	
	@PostMapping(path = "/{postId}")
	public ResponseEntity<Post> addReply(@PathVariable String postId, @RequestBody Reply reply) {
		return ResponseEntity.status(HttpStatus.OK).body(service.addReply(postId, reply));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Post> view(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.view(id));
	}
	
	@GetMapping
	public Page<Post> search(@RequestParam String username, @RequestParam String socialMedia, @RequestParam(required = false) String collectedTimeFrom, 
			@RequestParam(required = false) String collectedTimeTo, Pageable pageable) {
		return service.search(username, socialMedia, collectedTimeFrom, collectedTimeTo, pageable);
	}
	
}
