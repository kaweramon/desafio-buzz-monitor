package br.com.buzzmonitor.desafio.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.buzzmonitor.desafio.exceptionhandler.BadRequestException;
import br.com.buzzmonitor.desafio.model.Post;
import br.com.buzzmonitor.desafio.model.Reply;
import br.com.buzzmonitor.desafio.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository repository;
	
	@Override
	public Post create(Post post) {
		return repository.save(post);
	}

	@Override
	public List<Post> list() {	
		return (List<Post>) repository.findAll();
	}

	public Page<Post> search(String user, String socialMedia, String collectedTimeFrom, String collectedTimeTo, Pageable pageable) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		if (!StringUtils.isEmpty(collectedTimeFrom)) {
			try {
				formatter.parse(collectedTimeFrom);
			} catch (ParseException e) {
				throw new BadRequestException("Formato inválido da data 'collectedTimeFrom': " + e.getMessage());
			}
		}
		
		if (!StringUtils.isEmpty(collectedTimeTo)) {
			try {
				formatter.parse(collectedTimeTo);
			} catch (ParseException e) {
				throw new BadRequestException("Formato inválido da data 'collectedTimeTo': " + e.getMessage());
			}
		}
		
		if (!StringUtils.isEmpty(collectedTimeFrom) && StringUtils.isEmpty(collectedTimeTo))
			return repository.findByOriginAndUserNameAndCollectedTimeFrom(socialMedia, user, collectedTimeFrom, pageable);
		else if (StringUtils.isEmpty(collectedTimeFrom) && !StringUtils.isEmpty(collectedTimeTo))
			return repository.findByOriginAndUserNameAndCollectedTimeTo(socialMedia, user, collectedTimeTo, pageable);
		
		if (collectedTimeFrom == null && collectedTimeTo == null)
			return repository.findByOriginAndUserName(socialMedia, user, pageable);
		else
			return repository.findByOriginAndUserNameAndCollectedTimeFromAndCollectedTimeTo(
					socialMedia, user, collectedTimeFrom, collectedTimeTo, pageable);
		
	}
	
	@Override
	public Post view(String id) {
		Optional<Post> post = repository.findById(id);
		
		if (post != null)
			return post.get();
		else
			throw new ResourceNotFoundException("Post não encontrado!");
	}

	@Override
	public void delete(String id) {
		repository.delete(view(id));
		
	}

	@Override
	public Post addReply(String postId, Reply reply) {
		Post postDB = view(postId);
		if (postDB.getReplies() != null)
			postDB.getReplies().add(reply);
		else {
			List<Reply> replies = new ArrayList<Reply>();
			replies.add(reply);
			postDB.setReplies(replies);
		}
			
		return repository.save(postDB);
	}

}
