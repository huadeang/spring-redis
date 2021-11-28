package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
@RestController
public class DemoApplication {

	@Autowired
    private RedisTemplate<String, String> redisTemplate;

	// inject the template as ListOperations
	@Resource(name = "redisTemplate")
	private ListOperations<String, String> listOps;

	@Resource(name = "redisTemplate")
	private SetOperations<String,String> setOperations;

//	/**
//	 * Lettuce
//	 */
//	@Bean
//	public RedisConnectionFactory lettuceConnectionFactory() {
//		RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration()
//				.master("mymaster")
//				.sentinel("my-redis", 26379);
//		sentinelConfig.setPassword("gRldRd6AUE");
//		sentinelConfig.setSentinelPassword("gRldRd6AUE");
//		return new LettuceConnectionFactory(sentinelConfig);
//	}
//
//	@Bean("redisTemplate")
//	public RedisTemplate<String, Object> redisTemplate() {
//		RedisTemplate<String, Object> template = new RedisTemplate<>();
//		template.setConnectionFactory(lettuceConnectionFactory());
//		return template;
//	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}



	@GetMapping("/hello")
	private ResponseEntity<String> hello(){
//		System.out.println(listOps);
//		listOps.leftPush("key1","value1");
		setOperations.add("key1","value1");
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}

}
