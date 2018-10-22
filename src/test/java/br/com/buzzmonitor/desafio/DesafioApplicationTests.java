package br.com.buzzmonitor.desafio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.buzzmonitor.desafio.model.Post;
import br.com.buzzmonitor.desafio.service.PostService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DesafioApplication.class)
public class DesafioApplicationTests {

	@Autowired
	private PostService service;
	
	@Autowired
    private ElasticsearchTemplate esTemplate;
	
	@Before
	public void before() {
		esTemplate.deleteIndex(Post.class);
		esTemplate.createIndex(Post.class);
		esTemplate.putMapping(Post.class);
		esTemplate.refresh(Post.class);
	}
	
	@Test
	public void testSave() {
		Post post = new Post("RT @JediMassaYoda: Peppa Pig when she found out that Suzy Sheep could whistle. https://t.co/5zm5ECpBRV",
				"RT @JediMassaYoda: Peppa Pig when she found out that Suzy Sheep could whistle. https://t.co/5zm5ECpBRV", "NEUTRAL",
				"twitter", null, "twitter");
		Post postDB = service.create(post);
		
		assertNotNull(postDB.getId());
		assertEquals(post.getContent(), postDB.getContent());
		
	}
	
	@Test
	public void contextLoads() {
	}

}
