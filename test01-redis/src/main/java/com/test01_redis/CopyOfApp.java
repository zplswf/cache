package com.test01_redis;

import java.util.Map;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Hello world!
 *
 */
public class CopyOfApp {
	public static void main(String[] args) {
		// 创建一个redis通道
		GenericObjectPoolConfig config = new JedisPoolConfig();
//		config.se
		config.setMaxTotal(100);//设置连接池中最多放100个jedis对象
		//建议maxtotal和maxidle保持一致即可
		config.setMaxIdle(50);//设置连接池中最大允许的空闲链接
		config.setMinIdle(10);//设置连接池中最小允许的空闲链接
		config.setMaxWaitMillis(1000);//没有获取资源时最长等待1S后还没有就会报错
		
		
		//以下都是默认的
		config.setTestOnBorrow(false);
		config.setTestOnReturn(false);
		config.setTestOnCreate(false);//远程链接存在问题 本地链接没有问题
		config.setBlockWhenExhausted(true);//当连接池内jedis无可用资源时,是否等待资源
		
		JedisPool pool = new JedisPool(config, "10.200.20.212", 6666);
		Jedis jedis = pool.getResource();
		jedis.auth("123456789");
//		jedis.set("zplss", "fasfsdfsdf");
//		jedis.mset(new String[]{"a","1","b","2","c","3"});
//		List<String> list = jedis.mget(new String[]{"a","c"});
//		System.out.println(list);
//		String value = jedis.get("zplss");
//		System.out.println(value);
//		
//		Long valueLong = jedis.incr("dddddddd");
//		System.out.println(valueLong);
//		
//		Long vDelete = jedis.del("b");
//		System.out.println(vDelete);
		
		
		jedis.hset("username:1:info", "name", "老张");
		jedis.hset("username:1:info", "age", "20");
		String name = jedis.hget("username:1:info", "name");
		System.out.println(name);
		Map<String,String> map = jedis.hgetAll("username:1:info");
		System.out.println(map);
		jedis.close();//归还
//		pool.close();
	}
}
