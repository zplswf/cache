package com.test01_redis;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml") //加载配置文件
public class AppTest {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	
	@Test
	public void search(){
		redisTemplate.opsForValue().set("zpl123456fasffd", 11);
		String value = (String)redisTemplate.opsForValue().get("zpl123456fasffd");
		System.out.println(value);
	}
	
	@Test
	public void search1(){
		User u = new User();
		u.setName("fasfdf中国");
		redisTemplate.opsForValue().set("u11", u);
//		String value = redisTemplate.opsForValue().get("zpl123456fasffd");
//		System.out.println(value);
	}
	
	@Test
	public void list(){
		List<Object> list = redisTemplate.opsForList().range("u1", 0, -1);
		System.out.println(list);
//		for(int i=0;i<10;i++){
//			User u = new User();
//			u.setName("fasfdf中国"+i);
//			redisTemplate.opsForList().rightPush("u1", u);
//		}
//		for(int i=0;i<10;i++){
//			User u = new User();
//			u.setName("fasfdf中国"+i);
//			redisTemplate.opsForList().leftPush("u2", u);
//		}
//		String value = redisTemplate.opsForValue().get("zpl123456fasffd");
//		System.out.println(value);
	}
	
	@Test
	public void inr(){
//		for(int i=0;i<10;i++){
//			Long value = redisTemplate.execute(new RedisCallback<Long>() {
//				@Override
//				public Long doInRedis(RedisConnection connection)throws DataAccessException {
//					return connection.incrBy("utest1".getBytes(), 1l);
//				}
//			});
////			redisTemplate.expire("utest1", 1, TimeUnit.MINUTES);
//			System.out.println(value);
//		}
		System.out.println(redisTemplate.opsForValue().get("utest1"));
//		redisTemplate.opsForValue().increment("testl", 1);
//		Object obj = redisTemplate.opsForValue().get("test1");
//		System.out.println(obj);
//		for(int i=0;i<10;i++){
//			User u = new User();
//			u.setName("fasfdf中国"+i);
//			redisTemplate.opsForList().rightPush("u1", u);
//		}
//		for(int i=0;i<10;i++){
//			User u = new User();
//			u.setName("fasfdf中国"+i);
//			redisTemplate.opsForList().leftPush("u2", u);
//		}
//		String value = redisTemplate.opsForValue().get("zpl123456fasffd");
//		System.out.println(value);
	}
	
}

class User{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
}
