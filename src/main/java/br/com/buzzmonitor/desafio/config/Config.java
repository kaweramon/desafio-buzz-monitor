package br.com.buzzmonitor.desafio.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@PropertySource(value = "classpath:application.properties")
@EnableElasticsearchRepositories(basePackages = "br.com.buzzmonitor.desafio.repository")
@ComponentScan(basePackages = "br.com.buzzmonitor.desafio.service")
public class Config {

	@Value("${elasticsearch.host}")
    private String elasticsearchHost;

    @Value("${elasticsearch.port}")
    private int elasticsearchPort;

    @Value("${elasticsearch.clustername}")
    private String elasticsearchClusterName;
	
	@Value("$elasticsearch.home:C:\\Program Files\\elasticsearch-6.4.2")
	private String elasticsearchHome;
	
	@Bean
	public Client client() throws UnknownHostException {
		Settings elasticsearchSettings = Settings.builder()
				.put("client.transport.sniff", true)
		          .put("path.home", elasticsearchHome)
		          .put("cluster.name", elasticsearchClusterName).build();
		        TransportClient client = new PreBuiltTransportClient(elasticsearchSettings);
		        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
		        return client;
	}
	
	@Bean
    public ElasticsearchOperations elasticsearchTemplate() throws UnknownHostException {
        return new ElasticsearchTemplate(client());
    }

}
