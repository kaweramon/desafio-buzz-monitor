package br.com.buzzmonitor.desafio.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import br.com.buzzmonitor.desafio.model.Post;

@Repository
public interface PostRepository extends ElasticsearchRepository<Post, String>{

	@Query("{\"bool\": {\"must\": [{\"match\": {\"origin\": \"?0\"}},{\"nested\": {\"path\": \"author\",\"query\": {\"bool\": {\r\n" + 
			"\"must\": [{\"match\": {\r\n" + 
			"\"author.name\": \"?1\"}}]}}}}]}}")
	public Page<Post> findByOriginAndUserName(String origin, String username, Pageable pageable);
	
	@Query("{\"bool\": {\"must\": [{\"match\": {\"origin\": \"?0\"}},{\"nested\": {\r\n" + 
			"\"path\": \"author\",\"query\": {\"bool\": {\"must\": [\r\n" + 
			"{\"match\": {\"author.name\": \"?1\"}}]}\r\n" + 
			"}}},{\"range\": {\"collected_time\": {\"gte\": \"?2\",\"lte\": \"?3\"}}}]}}")
	public Page<Post> findByOriginAndUserNameAndCollectedTimeFromAndCollectedTimeTo(String origin, String username, 
				String collectedTimeFrom, String collectedTimeTo, Pageable pageable);
	
	@Query("{\"bool\": {\"must\": [{\"match\": {\"origin\": \"?0\"}},{\"nested\": {\r\n" + 
			"\"path\": \"author\",\"query\": {\"bool\": {\"must\": [\r\n" + 
			"{\"match\": {\"author.name\": \"?1\"}}]}\r\n" + 
			"}}},{\"range\": {\"collected_time\": {\"gte\": \"?2\"}}}]}}")
	public Page<Post> findByOriginAndUserNameAndCollectedTimeFrom(String origin, String username, 
				String collectedTimeFrom, Pageable pageable);
	
	@Query("{\"bool\": {\"must\": [{\"match\": {\"origin\": \"?0\"}},{\"nested\": {\r\n" + 
			"\"path\": \"author\",\"query\": {\"bool\": {\"must\": [\r\n" + 
			"{\"match\": {\"author.name\": \"?1\"}}]}\r\n" + 
			"}}},{\"range\": {\"collected_time\": {\"lte\": \"?2\"}}}]}}")
	public Page<Post> findByOriginAndUserNameAndCollectedTimeTo(String origin, String username, 
				String collectedTimeTo, Pageable pageable);
}
