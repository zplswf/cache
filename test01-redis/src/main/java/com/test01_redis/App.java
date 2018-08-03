package com.test01_redis;

import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// 创建一个redis通道
		Jedis jedis = new Jedis("10.200.20.212", 6666);
		jedis.auth("123456789");
//		jedis.set("zplss", "fasfsdfsdf");
//		jedis.mset(new String[]{"a","1","b","2","c","3"});
//		List<String> list = jedis.mget(new String[]{"a","c"});
//		System.out.println(list);
		String value = jedis.get("zplss");
		System.out.println(value);
//		
//		Long valueLong = jedis.incr("dddddddd");
//		System.out.println(valueLong);
//		
//		Long vDelete = jedis.del("b");
//		System.out.println(vDelete);
		
		
//		jedis.hset("username:1:info", "name", "老张");
//		jedis.hset("username:1:info", "age", "20");
//		String name = jedis.hget("username:1:info", "name");
//		System.out.println(name);
//		Map<String,String> map = jedis.hgetAll("username:1:info");
//		System.out.println(map);
		jedis.close();
	}
}
