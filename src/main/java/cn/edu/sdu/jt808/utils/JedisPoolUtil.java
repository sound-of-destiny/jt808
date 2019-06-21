package cn.edu.sdu.jt808.utils;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {
	private volatile JedisPool pool;
	
	private JedisPoolUtil(){
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(128);
		this.pool = new JedisPool(poolConfig, RedisUtil.REDIS_HOST, RedisUtil.REDIS_PORT);
	}
	
	private enum Singleton {
		INSTANCE;
		private JedisPoolUtil singleton;
		Singleton() {
			singleton = new JedisPoolUtil();
		}
		public JedisPoolUtil getSingleton() {
			return singleton;
		}
	}
	
	public static JedisPoolUtil getInstance() {
		return Singleton.INSTANCE.getSingleton();
	}
	
	public synchronized JedisPool getJedisPool() {
		return pool;
	}
}
